package com.example.order.service;


import com.example.order.dto.OrderDTO;
import com.example.order.entity.OrderDetail;
import com.example.order.entity.OrderMaster;

public interface OrderService {
    public OrderDTO create(OrderDTO orderDTO);
}
