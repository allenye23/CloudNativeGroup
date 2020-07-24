package com.cn.solace;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.connection.SingleConnectionFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class SolaceTopicSender {

  @Autowired
  private JmsTemplate jmsTopicTemplate;

//  @PostConstruct
//  private void customizeJmsTemplate() {
//    SingleConnectionFactory ccf = new SingleConnectionFactory();
//    ccf.setTargetConnectionFactory(jmsTopicTemplate.getConnectionFactory());
//    jmsTopicTemplate.setConnectionFactory(ccf);
//    // By default Spring Integration uses Queues, but if you set this to true you
//    // will send to a PubSub+ topic destination
//    jmsTopicTemplate.setPubSubDomain(true);
//  }

  @Value("Q/Test1")
  private String topic;

  @Scheduled(fixedRate = 1000)
  public void sendEvent() {
    jmsTopicTemplate.convertAndSend(topic, "Send to Topic");
  }

}

