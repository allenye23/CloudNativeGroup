package com.cn.server.servicebookingcreation.servicebookingfinding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ServiceBookingFindingApplication {

  public static void main(String[] args) {
    SpringApplication.run(ServiceBookingFindingApplication.class, args);
  }

}
