package com.example.order.message;

import com.example.order.entity.ProductInfoOutput;
import com.example.order.utils.JsonUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class ProductInfoReceiver {

    private static final String PRODUCT_STOCK_TEMPLATE = "product_stock_%s";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RabbitListener(queuesToDeclare = @Queue("productInfo"))
    public void process(String message) {
        List<ProductInfoOutput> productInfoOutputList =
                (List<ProductInfoOutput>)JsonUtil.fromJson(message,
                        new TypeReference<List<ProductInfoOutput>>() {});
        log.info("receive message : {}", productInfoOutputList);

        for (ProductInfoOutput productInfoOutput : productInfoOutputList) {
            stringRedisTemplate
                    .opsForValue()
                    .set(String.format(PRODUCT_STOCK_TEMPLATE
                            ,productInfoOutput.getProductId())
                            ,String.valueOf(productInfoOutput.getProductStock()));
        }

    }

}
