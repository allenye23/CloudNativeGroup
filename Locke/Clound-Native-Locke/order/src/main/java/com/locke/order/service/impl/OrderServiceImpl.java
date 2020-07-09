package com.locke.order.service.impl;


import com.locke.order.dao.OrderDao;
import com.locke.order.entity.Order;
import com.locke.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderServiceImpl  implements OrderService {

    @Autowired
    private OrderDao orderDao;


    public int save(Order order){
        orderDao.save(order);
        return order.getId();
    }

    @Override
    @Cacheable(value = "orders")
    public Order getOne(int id) {
        Optional<Order> byId = orderDao.findById(id);

        return byId.orElse(null);
    }


}
