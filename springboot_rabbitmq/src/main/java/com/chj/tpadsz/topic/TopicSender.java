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

    public void send() {
        String context = "hi, i am message all";
        this.rabbitTemplate.convertAndSend("topicExchange", "topic.message", context);
    }

    public void send1(int i) {
        String context = "hi, i am message ";
        this.rabbitTemplate.convertAndSend("topicExchange", "topic.message", context + i);
    }

    public void send2(int i) {
        String context = "hi, i am messages ";
        this.rabbitTemplate.convertAndSend("topicExchange", "topic.messages", context + i);
    }
}
