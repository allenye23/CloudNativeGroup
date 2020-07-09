package com.locke.order.service;

import com.locke.order.entity.Order;

public interface OrderService {

    public int save(Order order);

    public Order getOne(int id);
}
