package com.example.user.enums;

import lombok.Getter;

@Getter
public enum RoleEnum {
    BUYER(1, "buyer"),
    SELLER(2, "seller"),
    ;
    private Integer code;
    private String message;

    RoleEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
