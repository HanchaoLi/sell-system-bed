package com.example.product.service;

import com.example.product.entity.ProductInfo;

import java.util.List;

public interface ProductService {

    /**
     * get all instock product list
     */
    List<ProductInfo> findUpAll();
}
