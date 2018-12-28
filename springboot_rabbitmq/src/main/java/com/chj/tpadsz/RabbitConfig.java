package com.chj.tpadsz;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by hongjian.chen on 2018/12/27.
 */

@Configuration
public class RabbitConfig {

    @Bean
    public Queue HelloQueue() {
        return new Queue("hello-queue");
    }
    @Bean //2
    public Queue MyQueue(){
        return new Queue("my-queue");
    }

    @Bean
    public Queue objectQueue() {
        return new Queue("hello-object");
    }
}
