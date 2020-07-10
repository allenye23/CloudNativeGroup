package com.cn.server.servicebookingcreation.jms;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

@Service("producer")
public class Producer {

    private static final Logger logger = LoggerFactory.getLogger(Producer.class);

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    public void sendMessage(String destination, String message) {
        jmsMessagingTemplate.convertAndSend(destination, message);
        logger.info("Send Message -> [DESTINATION] : " + destination + "[Message] : " + message);
    }
}
