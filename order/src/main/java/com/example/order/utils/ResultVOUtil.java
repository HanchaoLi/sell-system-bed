package com.example.order.utils;

import com.example.order.vo.ResultVO;

public class ResultVOUtil {

    public static ResultVO success(Object obj) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMessage("success");
        resultVO.setData(obj);
        return resultVO;
    }
}
