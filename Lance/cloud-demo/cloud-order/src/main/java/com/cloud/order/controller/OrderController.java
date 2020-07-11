package com.cloud.order.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

  @GetMapping("/orders")
  @ResponseStatus(HttpStatus.OK)
  public List<String> getOrders() {
    List<String> orders = new ArrayList<>();
    orders.add("order 1");
    orders.add("order 2");
    return orders;
  }
}