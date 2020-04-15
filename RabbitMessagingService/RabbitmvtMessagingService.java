package com.microservices.elit.messaging;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gunner.demo.model.mvtCRUD;

@Service
public class RabbitmvtMessagingService
        {
  
  private RabbitTemplate rabbit;
  
  @Autowired
  public RabbitmvtMessagingService(RabbitTemplate rabbit) {
    this.rabbit = rabbit;
  }
  
  public void sendmvt(mvtCRUD test) {
	try {  
	new Queue("mvt.queue");}
	catch(Exception e) {}
    rabbit.convertAndSend("mvt.queue", test);
  }
  
}