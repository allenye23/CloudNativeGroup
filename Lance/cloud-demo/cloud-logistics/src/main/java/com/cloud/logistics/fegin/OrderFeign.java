package com.cloud.logistics.fegin;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("cloud-order")
public interface OrderFeign {

  @RequestMapping("/order/orders")
  List<String> getAllOrderList();
}