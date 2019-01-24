package com.chj.tpadsz.topic;


import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by hongjian.chen on 2018/12/28.
 */

@Component
public class TopicSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(int i) {
        String context = "hi, i am message all ";
        this.rabbitTemplate.convertAndSend("topicExchange", "spring.topic.message", context + i);
    }

    public void send1(int i) {
        String context = "hi, i am message * ";
        this.rabbitTemplate.convertAndSend("topicExchange", "spring.topic.demo.message", context + i);
    }

    public void send2(int i) {
        String context = "hi, i am messages # ";
        this.rabbitTemplate.convertAndSend("topicExchange", "spring.topic.messages", context + i);
    }
}
