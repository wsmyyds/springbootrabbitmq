package com.example.producer.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @program:
 * @description:
 * @author:
 * @create:
 **/
@RestController
public class SendMessageController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * Direct模式测试
     * 在rabbitmq使用实体类传递数据时，包路径要完全相同才能被消费者接收
     * @return
     */
    @RequestMapping("/sdm")
    public String sendDirectMessage(){

        rabbitTemplate.convertAndSend("directExchange", "routing", "hello,Direct");
        return "success";
    }

    @RequestMapping("/stm1")
    public String sendTopicMessage1(){

        rabbitTemplate.convertAndSend("topicExchange","topic.A","hello,Topic.A");
        return "success";
    }

    @RequestMapping("/stm2")
    public String sendTopicMessage2(){

        rabbitTemplate.convertAndSend("topicExchange","topic.B","hello,All_Topic");
        return "ok2";
    }

    @RequestMapping("/sfm")
    public String sendFanoutMessage(){

        rabbitTemplate.convertAndSend("fanoutExchange",null,"hello,Fanout");
        return "success";
    }

    /**
     * 测试找不到exchange时
     * @return
     */
    @RequestMapping("/nex")
    public String noExchange(){

        rabbitTemplate.convertAndSend("yyds","routing","nex");
        return "ok";
    }

    /**
     * 没有对应routingKey时
     * @return
     */
    @RequestMapping("/nqu")
    public String noQueue(){

        rabbitTemplate.convertAndSend("lonelyDirectExchange","routee","nr");
        return "ok";
    }


}
