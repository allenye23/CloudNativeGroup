package com.springcould.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaMain8082 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaMain8082.class, args);
    }

}
