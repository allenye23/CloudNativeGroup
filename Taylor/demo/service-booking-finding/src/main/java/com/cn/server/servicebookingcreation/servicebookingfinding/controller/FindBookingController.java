package com.cn.server.servicebookingcreation.servicebookingfinding.controller;

import com.cn.server.servicebookingcreation.servicebookingfinding.entity.Booking;
import com.cn.server.servicebookingcreation.servicebookingfinding.service.SearchBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FindBookingController {

  @Value("${server.port}")
  String port;

  @Autowired
  SearchBookingService service;

  @RequestMapping("/search")
  public Booking create(@RequestParam(value = "bkgNum") String bkgNum) {
    return service.get(bkgNum);
  }
}
