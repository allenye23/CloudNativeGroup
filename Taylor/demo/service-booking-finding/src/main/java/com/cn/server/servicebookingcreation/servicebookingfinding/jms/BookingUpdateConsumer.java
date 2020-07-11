package com.cn.server.servicebookingcreation.servicebookingfinding.jms;

import com.cn.server.servicebookingcreation.servicebookingfinding.entity.Booking;
import com.cn.server.servicebookingcreation.servicebookingfinding.service.UpdateBookingService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class BookingUpdateConsumer {

  @Autowired
  UpdateBookingService service;

  @JmsListener(destination = "cn.booking.update")
  public void receiveQueue(String msg) throws JsonProcessingException {
    service.update(new ObjectMapper().readValue(msg, Booking.class));
  }
}
