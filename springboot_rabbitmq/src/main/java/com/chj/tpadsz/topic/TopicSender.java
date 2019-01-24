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
        this.rabbitTemplate.convertAndSend("topic_exchange", "topic.demo", context + i);
    }

    public void send1(int i) {
        String context = "hi, i am message * ";
        this.rabbitTemplate.convertAndSend("topic_exchange", "topic.spring.demo.message", context + i);
    }

    public void send2(int i) {
        String context = "hi, i am messages # ";
        this.rabbitTemplate.convertAndSend("topic_exchange", "topic.spring.test", context + i);
    }
}
