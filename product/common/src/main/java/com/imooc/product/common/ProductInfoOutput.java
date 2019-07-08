package com.imooc.product.common;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 2017-12-09 21:23
 */
@Data
public class ProductInfoOutput {

    private String productId;

    private String productName;

    private BigDecimal productPrice;

    private Integer productStock;

    private String productDescription;

    private String productIcon;

    private Integer productStatus;

    private Integer categoryType;
}
