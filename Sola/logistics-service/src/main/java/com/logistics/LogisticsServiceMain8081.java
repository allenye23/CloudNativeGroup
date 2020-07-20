package com.logistics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class LogisticsServiceMain8081 {
    public static void main(String[] args) {
        SpringApplication.run(LogisticsServiceMain8081.class, args);
    }
}
