package com.cn.service.servicegateway;

import java.util.HashMap;
import java.util.Map;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
@Configuration
public class ServiceGatewayApplication {

  public static void main(String[] args) {
    SpringApplication.run(ServiceGatewayApplication.class, args);
  }

  @RequestMapping(value = "/fallback")
  public Map<String, String> fallBackController() {
    Map<String, String> res = new HashMap();
    res.put("code", "-1");
    res.put("data", "service not available");
    return res;
  }
}
