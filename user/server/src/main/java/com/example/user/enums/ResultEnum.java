package com.example.user.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {
    LOGIN_SUCCESS(0, "login success!"),
    LOGIN_FAIL(-1, "login fail!"),
    ROLE_ERROR(2, "wrong permission role!")
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
