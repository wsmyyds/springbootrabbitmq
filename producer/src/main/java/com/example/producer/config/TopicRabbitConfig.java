package com.example.producer.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program:
 * @description: Topic模式配置，exchange根据routingKey匹配找到queue,#匹配一个字符,*匹配多个
 * @author:
 * @create:
 **/
@Configuration
public class TopicRabbitConfig {

    public final static String TYPE_A = "topic.A";
    public final static String TYPE_B = "topic.B";

    @Bean
    public Queue firstQueue() {
        return new Queue(TYPE_A);
    }

    @Bean
    public Queue secondQueue() {
        return new Queue(TYPE_B);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange("topicExchange");
    }

    @Bean
    Binding bindingExchangeMessage1() {
        return BindingBuilder.bind(firstQueue()).to(exchange()).with(TYPE_A);
    }

    @Bean
    Binding bindingExchangeMessage2() {
        return BindingBuilder.bind(secondQueue()).to(exchange()).with("topic.#");
    }

}
