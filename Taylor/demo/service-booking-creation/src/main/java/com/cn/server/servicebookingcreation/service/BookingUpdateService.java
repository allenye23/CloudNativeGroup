package com.cn.server.servicebookingcreation.service;

import com.cn.server.servicebookingcreation.entity.Booking;
import com.cn.server.servicebookingcreation.jms.Producer;
import com.cn.server.servicebookingcreation.repository.BookingRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingUpdateService {

  @Autowired
  private BookingRepository bookingRepository;

  @Autowired
  Producer producer;

  public BookingUpdateService() {
  }

  public boolean create(Booking booking) throws JsonProcessingException {
    bookingRepository.save(booking);
    producer.sendMessage("cn.booking.update", new ObjectMapper().writeValueAsString(booking));
    return true;
  }


}
