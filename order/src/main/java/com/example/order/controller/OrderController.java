package com.example.order.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {


    /**
     * 1. validate params
     * 2. check product info
     * 3. calculate total price
     * 4. deduct product stock
     * 5. crate order
     */
    @PostMapping("/create")
    public void create() {

    }
}
