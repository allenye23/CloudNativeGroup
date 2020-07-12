package com.macro.client.eurekaclient;

import java.util.Date;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {

  @Autowired
  private AmqpTemplate rabbitTemplate;

  public String send(String username) {
    this.rabbitTemplate.convertAndSend("hello1", username);
    return username;
  }

}