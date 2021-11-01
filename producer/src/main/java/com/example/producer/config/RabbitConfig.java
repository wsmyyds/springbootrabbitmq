package com.example.producer.config;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program:
 * @description: RabbitTemplate
 * @author:
 * @create:
 **/
@Configuration
public class RabbitConfig {

    @Bean
    public RabbitTemplate createRabbitTemplate(ConnectionFactory connectionFactory){

        RabbitTemplate rabbitTemplate = new RabbitTemplate();
        rabbitTemplate.setConnectionFactory(connectionFactory);
        //开启接收路由不可达消息
        rabbitTemplate.setMandatory(true);

        rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {

            System.out.println("ConfirmCallback"+correlationData);
            System.out.println("ConfirmCallback"+ack);
            System.out.println("ConfirmCallback"+cause);
        });

        rabbitTemplate.setReturnsCallback(returnedMessage -> System.out.println(returnedMessage));

        return rabbitTemplate;
    }
}
