package com.macro.client.eurekaclient;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {
  @Autowired
  private RestTemplate restTemplate;
  @Value("${service-url.order-service}")
  private String orderServiceUrl;

  @HystrixCommand(fallbackMethod = "getDefaultOrder")
  public Order getUser(String id) {
    return restTemplate.getForObject(orderServiceUrl + "/order/search/{1}", Order.class, id);
  }

  public Order getDefaultOrder(@PathVariable String id) {
    Order defaultUser = new Order();
    defaultUser.setId(id);
    defaultUser.setUsername("defaultOrder");
      return defaultUser;
  }
}
