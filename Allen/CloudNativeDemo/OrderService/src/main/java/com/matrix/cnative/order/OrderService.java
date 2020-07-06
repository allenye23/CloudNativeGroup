package com.matrix.cnative.order;

public interface OrderService {
    void submitOrder(Order order);
    Order findOrder(Integer orderId );
    LogisticDTO getLogisticDTO(String id);
}
