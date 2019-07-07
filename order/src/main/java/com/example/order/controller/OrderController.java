package com.example.order.controller;

import com.example.order.enums.ResultEnum;
import com.example.order.exception.OrderException;
import com.example.order.form.OrderForm;
import org.springframework.validation.BindingResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {


    /**
     * 1. validate params
     * 2. check product info
     * 3. calculate total price
     * 4. deduct product stock
     * 5. crate order
     */
    @PostMapping("/create")
    public void create(@Valid OrderForm orderForm, BindingResult bindingResult) throws OrderException {
        if (bindingResult.hasErrors()) {

            log.error("unvaild parameter, orderFrom = {}", orderForm);
            throw new OrderException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }
    }
}
