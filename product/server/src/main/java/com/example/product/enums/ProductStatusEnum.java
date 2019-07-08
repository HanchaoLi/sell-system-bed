package com.example.product.enums;

public enum ProductStatusEnum {
    UP(0, "in stock"),
    DOWN(1, "off stock"),
    ;

    private Integer code;

    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
