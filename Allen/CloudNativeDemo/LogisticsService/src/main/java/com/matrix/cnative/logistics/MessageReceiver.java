package com.matrix.cnative.logistics;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MessageReceiver {

    @Autowired
    LogisticsRepository logisticsRepository;

    @RabbitListener(queuesToDeclare  = @Queue("test_queue"))
    public void processMessage(String content) {

        Logistics logistics = new Logistics();

        System.out.println(content);
        String[] split = content.split("_");
        logistics.setOrderId(Integer.parseInt(split[0]));
        logistics.setAddress(split[1]);
        logistics.setArrivalTime(new Date() );
        logisticsRepository.save(logistics);
    }

}
