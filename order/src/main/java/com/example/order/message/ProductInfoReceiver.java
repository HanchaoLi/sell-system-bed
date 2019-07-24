package com.example.order.message;

import com.example.order.entity.ProductInfoOutput;
import com.example.order.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ProductInfoReceiver {

    private static final String PRODUCT_STOCK_TEMPLATE = "product_stock_%s";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RabbitListener(queuesToDeclare = @Queue("productInfo"))
    public void process(String message) {
        ProductInfoOutput productInfoOutput = (ProductInfoOutput)JsonUtil.fromJson(message, ProductInfoOutput.class);
        log.info("receive message : {}", productInfoOutput);

        stringRedisTemplate
                .opsForValue()
                .set(String.format(PRODUCT_STOCK_TEMPLATE
                        ,productInfoOutput.getProductId())
                        ,String.valueOf(productInfoOutput.getProductStock()));
    }

}
