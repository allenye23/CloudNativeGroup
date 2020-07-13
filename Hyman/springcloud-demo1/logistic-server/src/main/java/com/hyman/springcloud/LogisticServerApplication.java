package com.hyman.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class LogisticServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogisticServerApplication.class, args);
    }

}
