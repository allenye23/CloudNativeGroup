package com.macro.client.eurekaclient;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class OrderRibbonController {
  @Autowired
  OrderService orderService;
  @Autowired
  private RestTemplate restTemplate;
  @Value("${service-url.order-service}")
  private String orderServiceUrl;

  @GetMapping("/{id}")
  public Order getOrder(@PathVariable String id) {
    return restTemplate.getForObject(orderServiceUrl + "/order/search/{1}", Order.class, id);
  }

  @GetMapping("/testFallback/{id}")
  public Order testFallback(@PathVariable String id) {
    return orderService.getUser(id);
  }
}
