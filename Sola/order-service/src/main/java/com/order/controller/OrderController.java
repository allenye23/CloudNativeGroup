package com.order.controller;

import com.order.service.OrderService;
import common.entities.CommonResult;
import common.entities.Logistics;
import common.entities.Order;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

    private final RestTemplate restTemplate;

    private final static String LOGISTICS_HOST = "http://LOGISTICS-SERVICE";

    @PostMapping("/create")
    public CommonResult<String> createUser(Order order) {
        String orderNumber = orderService.createOrder(order);
        return new CommonResult<String>("200","Success",orderNumber);
    }

    @GetMapping("/consumer/find")
    public CommonResult<Logistics> findLogistics(String orderNumber) {
        return restTemplate.getForObject(LOGISTICS_HOST + "/logistics/find", CommonResult.class, orderNumber);
    }

}
