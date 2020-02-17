package com.chj.tpadsz;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by hongjian.chen on 2018/12/28.
 */

@Configuration
public class TopicRabbitConfig {

    final static String message = "topic.test.demo";
    final static String messages = "topic.spring.demo";

    @Bean
    public Queue queueMessage() {
        return new Queue(message);
    }

    @Bean
    public Queue queueMessages() {
        return new Queue(messages);
    }

    @Bean
    public Queue demoQueue() {
        return new Queue("topic.spring.demo.message");
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange("topic_exchange");
    }

    @Bean
    Binding bindingExchangeDemo() {
        return BindingBuilder.bind(demoQueue()).to(exchange()).with("topic.spring.*.message");
    }

    @Bean
    Binding bindingExchangeMessage() {
        return BindingBuilder.bind(queueMessage()).to(exchange()).with("topic.spring.*");
    }

    @Bean
    Binding bindingExchangeMessages() {
        return BindingBuilder.bind(queueMessages()).to(exchange()).with("topic.#");
    }

}
