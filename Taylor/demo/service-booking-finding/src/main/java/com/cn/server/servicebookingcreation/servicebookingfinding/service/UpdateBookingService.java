package com.cn.server.servicebookingcreation.servicebookingfinding.service;

import com.cn.server.servicebookingcreation.servicebookingfinding.entity.Booking;
import com.cn.server.servicebookingcreation.servicebookingfinding.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class UpdateBookingService {

  @Autowired
  private BookingRepository bookingRepository;

  @Autowired
  private RedisTemplate redisTemplate;

  public void update(Booking booking) {
    redisTemplate.delete("bkgNum_"+ booking.getBookingNumber());
    bookingRepository.save(booking);
  }
}
