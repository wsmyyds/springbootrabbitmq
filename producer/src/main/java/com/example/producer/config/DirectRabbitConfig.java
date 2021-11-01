package com.example.producer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @program:
 * @description: Direct模式配置，exchange通过routingKey找到对应queue
 * @author:
 * @create:
 **/
@Configuration
public class DirectRabbitConfig {

    /**
     * 定义队列
     * durable 是否持久化
     * exclusive 是否exclusive 连接关闭时该队列是否自动删除，是否只能一个消费者访问
     * autoDelete 是否自动删除 最后一个消费者断开时队列是否自动删除
     * @return
     */
    @Bean
    public Queue directQueue() {
        return new Queue("directQueue", true);
    }

    /**
     * 定义交换机
     * @return
     */
    @Bean
    DirectExchange directExchange() {
        return new DirectExchange("directExchange", true, false);
    }

    /**
     * 定义绑定
     * routingKey 路由键
     * @return
     */
    @Bean
    Binding bindingDirect() {
        return BindingBuilder.bind(directQueue()).to(directExchange()).with("routing");
    }

    @Bean
    DirectExchange lonelyDirectExchange() {
        return new DirectExchange("lonelyDirectExchange");
    }
}
