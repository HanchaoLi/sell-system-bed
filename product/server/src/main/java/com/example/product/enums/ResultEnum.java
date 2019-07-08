package com.example.product.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {
    PRODUCT_NOT_EXSIT(1, "product not exsit"),
    PRODUCT_STOCK_ERROR(2, "stock not enough"),
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
