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
        this.rabbitTemplate.convertAndSend("topicExchange", "topic.1", context);
    }

    public void send1() {
        String context = "hi, i am message 1";
        this.rabbitTemplate.convertAndSend("topicExchange", "topic.message", context);
    }

    public void send2() {
        String context = "hi, i am messages 2";
        this.rabbitTemplate.convertAndSend("topicExchange", "topic.messages", context);
    }
}
