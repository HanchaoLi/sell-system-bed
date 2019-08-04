package com.example.order.controller;

import com.example.order.converter.OrderForm2OrderDTO;
import com.example.order.dto.OrderDTO;
import com.example.order.enums.ResultEnum;
import com.example.order.exception.OrderException;
import com.example.order.form.OrderForm;
import com.example.order.service.OrderService;
import com.example.order.utils.ResultVOUtil;
import com.example.order.vo.ResultVO;
import org.springframework.validation.BindingResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {


    @Autowired
    private OrderService orderService;

    /**
     * 1. validate params
     * 2. check product info
     * 3. calculate total price
     * 4. deduct product stock
     * 5. crate order
     */
    @PostMapping("/create")
    public ResultVO<Map<String, String>> create(@Valid OrderForm orderForm, BindingResult bindingResult) throws OrderException {
        if (bindingResult.hasErrors()) {

            log.error("unvaild parameter, orderFrom = {}", orderForm);
            throw new OrderException(ResultEnum.PARAM_ERROR);
        }
        OrderDTO orderDTO = OrderForm2OrderDTO.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("shopping cart is empty");
            throw new OrderException(ResultEnum.CART_EMPTY);

        }
        OrderDTO result = orderService.create(orderDTO);
        Map<String, String> map = new HashMap<>();

        map.put("orderId", result.getOrderId());

        return ResultVOUtil.success(map);
    }

    @PostMapping("finish")
    public ResultVO<OrderDTO> finish(@RequestParam("orderId") String orderId) {
        return ResultVOUtil.success(orderService.finish(orderId));

    }
}
