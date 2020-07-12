package com.locker.logistics.mq;

import com.locker.logistics.dao.LogisticsDao;
import com.locker.logistics.entity.Logistics;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {


    @Autowired
    private LogisticsDao logisticsDao;

    @RabbitListener(queuesToDeclare =  @Queue("logistics"))
    public  void processMessage(String content){

        String[] split = content.split("::");
        Logistics logistics = new Logistics();
        logistics.setOid(Integer.parseInt(split[0]));
        logistics.setAddress(split[1]);
        logisticsDao.save(logistics);

    }
}
