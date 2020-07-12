package com.macro.client.eurekaclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/order")
public class OrderController {

  @Value("${server.port}")
  private String configInfo;

  @Autowired
  MessageSender messageSender;

  @Autowired
  RedisService redisService;

  @Autowired
  OrderService orderService;

  @RequestMapping(value = "/add",method = RequestMethod.POST)
  @ResponseBody
  @CrossOrigin
  public void addOrder(@RequestParam(value = "orderName") String orderName) {
    Order order = new Order();
    order.setUsername(orderName);
    String uuid = orderService.saveCusBaseInfo(order);

    redisService.saveOrder(uuid, orderName);
    messageSender.send(orderName);
  }

  @RequestMapping(value = "/search/{id}",method = RequestMethod.GET)
  @ResponseBody
  @CrossOrigin
  public Order searchOrder(@PathVariable(value = "id") String id) {
    System.out.println("hahahha");
    if(redisService.searchOrder(id) != null){
      Order order = new Order();
      order.setUsername(redisService.searchOrder(id));
      order.setId(id);
      return order;
    }
    return orderService.searchById(id);
  }

  @RequestMapping(value = "/configInfo",method = RequestMethod.GET)
  @ResponseBody
  @CrossOrigin
  public String getConfigInfo() {
    return configInfo;
  }
}
