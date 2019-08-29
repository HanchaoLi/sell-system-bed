package com.example.order.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
@DefaultProperties(defaultFallback = "defaultFallback")
public class HystrixController {

    @HystrixCommand(commandProperties = {
            // set circult break time
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),

            // enable curcuit breaker
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),

            // request threshold
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),

            // set error percentage
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")

    })
    @GetMapping("/getProductInfoList")
    public String getProductInfo() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject("http://localhost:9000/product/listForOrder",
                Arrays.asList("157875196366160022"),
                String.class);

    }

    private String fallback() {
        return "too crowded, please try later";
    }

    private String defaultFallback() {
        return "default: too crowded, please try later";
    }

}
