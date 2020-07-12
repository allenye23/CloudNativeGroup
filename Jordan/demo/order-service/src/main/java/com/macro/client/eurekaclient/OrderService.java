package com.macro.client.eurekaclient;

public interface OrderService {
  String saveCusBaseInfo(Order order);
  Order searchById(String id);
}
