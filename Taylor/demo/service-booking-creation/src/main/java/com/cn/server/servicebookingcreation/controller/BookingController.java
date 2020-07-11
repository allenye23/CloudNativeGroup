package com.cn.server.servicebookingcreation.controller;

import com.cn.server.servicebookingcreation.entity.Booking;
import com.cn.server.servicebookingcreation.service.BookingUpdateService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {

  @Value("${server.port}")
  String port;

  @Autowired
  BookingUpdateService service;

  @RequestMapping("/create")
  public String create(@RequestParam(value = "bkgNum") String bkgNum) throws JsonProcessingException {
    return service.create(new Booking(bkgNum, port)) ? bkgNum : "Server issue";
  }
}
