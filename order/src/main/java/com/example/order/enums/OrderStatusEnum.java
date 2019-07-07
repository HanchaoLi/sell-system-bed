package com.example.order.enums;

import lombok.Getter;

@Getter
public enum OrderStatusEnum {
    NEW(0, "new order"),
    FINISHED(1, "finish"),
    CANCEL(2, "cancel order"),
    ;
    private Integer code;
    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

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
