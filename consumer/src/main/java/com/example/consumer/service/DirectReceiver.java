package com.example.consumer.service;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


/**
 * @program: consumer
 * @description: Direct
 * @author:
 * @create:
 **/
@Component
@RabbitListener(queues = {"directQueue"})
public class DirectReceiver {

    @RabbitHandler
    public void process(Object message){

        System.out.println("DirectReceiver消费者收到消息  : "+message);
    }
}
