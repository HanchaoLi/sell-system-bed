package com.example.order.exception;

public class OrderException extends Exception{

    private Integer code;
    private String message;
    public OrderException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
