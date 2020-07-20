package com.order.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.order.repository.OrderRepository;
import common.entities.Order;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    private final KafkaTemplate<String,String> kafkaTemplate;

    @Transactional
    public String createOrder(Order order){
        order.setOrderNumber(UUID.randomUUID().toString());
        orderRepository.save(order);
        sendMessage(order);
        return order.getOrderNumber();
    }

    private void sendMessage(Order order) {
        try {
            String message = new ObjectMapper().writeValueAsString(order);
            kafkaTemplate.send("test", message);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

}
