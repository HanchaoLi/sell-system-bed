package com.example.product.dto;

import lombok.Data;

@Data
public class CartDTO {
    private String productId;
    private Integer productQuantity;
}
