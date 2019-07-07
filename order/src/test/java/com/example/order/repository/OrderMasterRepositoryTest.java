package com.example.order.repository;

import com.example.order.OrderApplicationTests;
import com.example.order.entity.OrderMaster;
import com.example.order.enums.OrderStatusEnum;
import com.example.order.enums.PayStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

@Component
public class OrderMasterRepositoryTest extends OrderApplicationTests {

    @Autowired
    private OrderMasterRepository orderMasterRepository;


    @Test
    public void testSave() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("1110002");
        orderMaster.setBuyerName("lee john");
        orderMaster.setBuyerPhone("15200339923");
        orderMaster.setBuyerAddress("362 sixth st, apt 2");
        orderMaster.setBuyerOpenid("332912");
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMaster.setOrderAmount(BigDecimal.ONE);
//        orderMaster.setCreateTime("DEFAULT");
//        orderMaster.setUpdateTime("DEFAULT");

        OrderMaster res = orderMasterRepository.save(orderMaster);
        Assert.assertTrue(res != null);
    }
}