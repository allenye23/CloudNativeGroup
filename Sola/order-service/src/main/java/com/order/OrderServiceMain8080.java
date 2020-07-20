package com.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class OrderServiceMain8080 {
    public static void main(String[] args) {
        SpringApplication.run(OrderServiceMain8080.class, args);
    }
}
