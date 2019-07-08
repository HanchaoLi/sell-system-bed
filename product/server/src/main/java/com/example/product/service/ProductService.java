package com.example.product.service;

import com.example.product.dto.CartDTO;
import com.example.product.entity.ProductInfo;

import java.util.List;

public interface ProductService {

    /**
     * get all instock product list
     */
    List<ProductInfo> findUpAll();

    List<ProductInfo> findList(List<String> productIdList);

    void decreaseStock(List<CartDTO> cartDTOList);
}
