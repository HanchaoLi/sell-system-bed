package com.example.order.service.impl;

import com.example.order.dto.OrderDTO;
import com.example.order.entity.OrderDetail;
import com.example.order.entity.OrderMaster;
import com.example.order.enums.OrderStatusEnum;
import com.example.order.enums.PayStatusEnum;
import com.example.order.repository.OrderDetailRepository;
import com.example.order.repository.OrderMasterRepository;
import com.example.order.service.OrderService;
import com.example.order.utils.KeyUtil;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    public OrderDTO create(OrderDTO orderDTO) {
        //TODO search product info

        //TODO calculate total price

        //deduct product stock value

        // create order
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDTO, orderMaster);

        orderDTO.setOrderId(KeyUtil.genUniqueKey());
        orderMaster.setOrderAmount(BigDecimal.valueOf(2.0));
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());

        orderMasterRepository.save(orderMaster);

        return orderDTO;
    }
}
