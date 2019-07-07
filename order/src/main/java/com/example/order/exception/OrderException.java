package com.example.order.exception;

import com.example.order.enums.ResultEnum;

public class OrderException extends Exception{

    private Integer code;
    public OrderException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public OrderException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
