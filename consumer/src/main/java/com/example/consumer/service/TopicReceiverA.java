package com.example.consumer.service;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @program: consumer
 * @description:
 * @author:
 * @create:
 **/
@Component
@RabbitListener(queues = "topic.A")
public class TopicReceiverA {

    @RabbitHandler
    public void process(Object msg){
        System.out.println("TopicReceiverA收到消息:"+msg);
    }
}
