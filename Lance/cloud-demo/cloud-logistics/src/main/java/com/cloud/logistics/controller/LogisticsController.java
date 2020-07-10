package com.cloud.logistics.controller;

import com.cloud.logistics.fegin.OrderFeign;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/logistics")
public class LogisticsController {

  @Autowired
  private OrderFeign orderFeign;

  @RequestMapping("/orders")
  @ResponseStatus(HttpStatus.OK)
  public List<String> getOrderList() {
    return orderFeign.getAllOrderList();
  }

}