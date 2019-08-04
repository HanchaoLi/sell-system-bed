package com.example.user.controller;

import com.example.user.constrant.CookieConstrant;
import com.example.user.constrant.RedisConstrant;
import com.example.user.entity.UserInfo;
import com.example.user.enums.ResultEnum;
import com.example.user.enums.RoleEnum;
import com.example.user.service.UserService;
import com.example.user.utils.CookieUtil;
import com.example.user.utils.ResultVOUtil;
import com.example.user.vo.ResultVO;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @GetMapping("buyer")
    public ResultVO buyerLogin(@RequestParam("openid") String openid,
                          HttpServletResponse response) {
        UserInfo userInfo = userService.findByOpenid(openid);
        if (userInfo == null) {
            return ResultVOUtil.error(ResultEnum.LOGIN_FAIL);
        }
        if (userInfo.getRole() != RoleEnum.BUYER.getCode()) {
            return ResultVOUtil.error(ResultEnum.ROLE_ERROR);
        }
        CookieUtil.set(response, CookieConstrant.OPENID, openid, CookieConstrant.expire);

        return ResultVOUtil.success(ResultEnum.LOGIN_SUCCESS);
    }

    @GetMapping("seller")
    public ResultVO sellerLogin(@RequestParam("openid") String openid,
                               HttpServletRequest request,
                               HttpServletResponse response) {
        Cookie cookie = CookieUtil.get(request, CookieConstrant.TOKEN);
        if (cookie != null
                && !StringUtils.isEmpty(redisTemplate
                    .opsForValue()
                    .get(String.format(RedisConstrant.TOKEN_TEMPLATE, cookie.getValue())))) {
            return ResultVOUtil.success(ResultEnum.LOGIN_SUCCESS);
        }
        UserInfo userInfo = userService.findByOpenid(openid);
        if (userInfo == null) {
            return ResultVOUtil.error(ResultEnum.LOGIN_FAIL);
        }
        if (userInfo.getRole() != RoleEnum.SELLER.getCode()) {
            return ResultVOUtil.error(ResultEnum.ROLE_ERROR);
        }
        String token = UUID.randomUUID().toString();
        Integer expire = CookieConstrant.expire;
        redisTemplate.opsForValue().set(String.format(RedisConstrant.TOKEN_TEMPLATE, token),
                openid,
                expire,
                TimeUnit.SECONDS);


        CookieUtil.set(response, CookieConstrant.TOKEN, token, CookieConstrant.expire);

        return ResultVOUtil.success(ResultEnum.LOGIN_SUCCESS);
    }
}
