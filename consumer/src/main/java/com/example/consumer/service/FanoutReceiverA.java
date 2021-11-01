package com.example.consumer.service;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @program: consumer
 * @description:
 * 可以监听多个queue
 * @author:
 * @create:
 **/
@Component
@RabbitListener(queues = {"fanout.A","fanout.B"})
public class FanoutReceiverA {

    @RabbitHandler
    public void process(Object msg){
        System.out.println("FanoutReceiverA/B:"+msg);
    }

}
