package com.macro.client.eurekaclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceImpl implements RedisService{

  @Autowired
  StringRedisTemplate stringRedisTemplate;

  @Override
  public void saveOrder(String id, String orderName) {
    stringRedisTemplate.opsForValue().set(id, orderName);
  }

  @Override
  public String searchOrder(String id) {
    return stringRedisTemplate.opsForValue().get(id);
  }
}
