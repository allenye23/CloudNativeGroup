package com.cn.solace;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class SolaceQueueSender {

  @Autowired
  private JmsTemplate jmsQueueTemplate;

  @Value("Q/Test")
  private String queue;

  @Scheduled(fixedRate = 100)
  public void sendEvent() {
    System.out.println("Send to queue");
    jmsQueueTemplate.convertAndSend(queue, "Send to queue");
  }

}

