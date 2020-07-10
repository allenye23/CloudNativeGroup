package com.cn.server.servicebookingcreation.servicebookingfinding.service;

import com.cn.server.servicebookingcreation.servicebookingfinding.entity.Booking;
import com.cn.server.servicebookingcreation.servicebookingfinding.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class SearchBookingService {

  @Autowired
  private BookingRepository bookingRepository;

  @Autowired
  private RedisTemplate redisTemplate;

  public Booking get(String bkgNum) {
    String key = "bkgNum_" + bkgNum;
    Boolean hasKey = redisTemplate.hasKey(key);
    if (hasKey) {
      return (Booking) redisTemplate.opsForValue().get(key);
    }
    Booking booking = bookingRepository.findById(bkgNum).get();
    redisTemplate.opsForValue().set(key, booking);
    return booking;
  }
}
