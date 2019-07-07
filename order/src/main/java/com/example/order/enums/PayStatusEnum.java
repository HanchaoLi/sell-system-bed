package com.example.order.enums;

import lombok.Getter;

@Getter
public enum PayStatusEnum {
    WAIT(0, "waiting payment"),
    FINISHED(1, "payment success"),
    ;
    private Integer code;
    private String message;

    PayStatusEnum(Integer code, String message) {
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
