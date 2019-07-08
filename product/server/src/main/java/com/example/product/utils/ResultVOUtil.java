package com.example.product.utils;

import com.example.product.vo.ResultVO;

public class ResultVOUtil {

    public static ResultVO success(Object obj) {
        ResultVO resultVO = new ResultVO();
        resultVO.setData(obj);
        resultVO.setCode(0);
        resultVO.setMessage("success");

        return resultVO;
    }
}
