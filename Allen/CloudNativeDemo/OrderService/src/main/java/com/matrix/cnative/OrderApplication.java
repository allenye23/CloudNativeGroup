package com.matrix.cnative;

import com.matrix.cnative.order.LogisticDTO;
import com.matrix.cnative.order.Order;
import com.matrix.cnative.order.OrderAndLogisticResult;
import com.matrix.cnative.order.OrderService;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@RestController
@EnableCaching
@EnableCircuitBreaker
public class OrderApplication {

    @Autowired
    OrderService orderService;




    @RequestMapping(value = "/order",method = RequestMethod.POST)
    public String submitOrder(@RequestBody Order order){
        orderService.submitOrder(order);
        return "Hello world";
    }



    @RequestMapping("/order/{id}")
    public OrderAndLogisticResult home(@PathVariable("id") String id){
       OrderAndLogisticResult result =  new OrderAndLogisticResult();
       result.setLogisticDTO(orderService.getLogisticDTO(id));
       result.setOrder(orderService.findOrder(Integer.parseInt(id)));
        return result;

    }



    public static void main(String[] args) {
        new SpringApplicationBuilder(OrderApplication.class).web(WebApplicationType.SERVLET).run(args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
