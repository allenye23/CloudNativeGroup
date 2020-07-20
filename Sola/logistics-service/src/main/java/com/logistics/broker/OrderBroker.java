package com.logistics.broker;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.logistics.repository.LogisticsRepository;
import common.entities.Logistics;
import common.entities.Order;
import lombok.AllArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class OrderBroker {

    private final LogisticsRepository logisticsRepository;

    @KafkaListener(topics = "test")
    public void listen(ConsumerRecord<?, String> consumerRecord) throws JsonProcessingException {
        String orderJacksonStr = consumerRecord.value();
        Order order = new ObjectMapper().readValue(orderJacksonStr, Order.class);
        logisticsRepository.save(toLogistics(order));
    }

    private Logistics toLogistics(Order order) {
        Logistics logistics = new Logistics();
        logistics.setOrderNumber(order.getOrderNumber());
        logistics.setCargo(order.getCargo());
        logistics.setQuantity(order.getQuantity());
        logistics.setCurrentLocation("Warehouse");
        return logistics;
    }

}
