package com.example.order.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {

    PARAM_ERROR(1, "param error"),
    CART_EMPTY(2, "empty cart"),
    ORDER_NOT_EXIST(3, "order not exist"),
    ORDER_STATUS_ERROR(4, "order status error"),
    ORDER_DETAIL_NOT_EXSIT(5, "order detail not exsit"),
    ;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    private Integer code;
    private String message;


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
