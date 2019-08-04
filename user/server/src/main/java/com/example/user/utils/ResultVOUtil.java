package com.example.user.utils;


import com.example.user.enums.ResultEnum;
import com.example.user.vo.ResultVO;

public class ResultVOUtil {

    public static ResultVO success(ResultEnum resultEnum) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(resultEnum.getCode());
        resultVO.setMessage(resultEnum.getMessage());
        return resultVO;
    }

    public static ResultVO error(ResultEnum resultEnum) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(resultEnum.getCode());
        resultVO.setMessage(resultEnum.getMessage());
        return resultVO;
    }
}
