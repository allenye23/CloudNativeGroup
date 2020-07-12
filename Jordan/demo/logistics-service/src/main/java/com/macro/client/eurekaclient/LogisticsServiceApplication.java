package com.macro.client.eurekaclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableConfigServer
@EnableCircuitBreaker
@EnableEurekaClient
@SpringBootApplication
public class LogisticsServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(LogisticsServiceApplication.class, args);
  }

}
