package com.macro.client.eurekaclient;

public interface RedisService {
  void saveOrder(String id, String orderName);
  String searchOrder(String id);
}
