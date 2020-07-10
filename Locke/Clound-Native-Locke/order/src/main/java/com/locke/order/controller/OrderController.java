package com.locke.order.controller;


import com.locke.order.entity.Order;
import com.locke.order.model.ResponseMessage;
import com.locke.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/order")
public class OrderController {


    @Autowired
    @Qualifier("orderServiceImpl")
    private OrderService orderService;

    @PostMapping
    public ResponseMessage save(@RequestBody Order order) {

        int id = orderService.save(order);

        return new ResponseMessage(order);
    }


    @GetMapping("/{id}")
    public ResponseMessage getOne(@PathVariable int id){

        Order order = this.orderService.getOne(id);

        return new ResponseMessage(order);
    }

}
