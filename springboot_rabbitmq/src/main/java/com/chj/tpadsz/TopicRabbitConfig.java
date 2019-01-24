package com.chj.tpadsz;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by hongjian.chen on 2018/12/28.
 */

@Configuration
public class TopicRabbitConfig {

    final static String message = "spring.topic.message";
    final static String messages = "spring.topic.messages";

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
        return new Queue("spring.topic.demo.message");
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange("topicExchange");
    }

    @Bean
    Binding bindingExchangeDemo() {
        return BindingBuilder.bind(demoQueue()).to(exchange()).with("*.topic.*.message");
    }

    @Bean
    Binding bindingExchangeMessage(Queue queueMessage, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage).to(exchange).with("spring.topic.*.message");
    }

    @Bean
    Binding bindingExchangeMessages(Queue queueMessages, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessages).to(exchange).with("spring.topic.#");
    }

}
