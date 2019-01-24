package com.chj.tpadsz.topic;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by hongjian.chen on 2018/12/28.
 */

@Component
public class TopicReceiver {

    @RabbitListener(queues = "topic.demo")
    public void process1(Message message) {
        System.out.println(message.getMessageProperties().getReceivedRoutingKey() + " " + new String(message.getBody()));
    }

    @RabbitListener(queues = "topic.spring.test")
    public void process2(Message message) {
        System.out.println(message.getMessageProperties().getReceivedRoutingKey() + " " + new String(message.getBody()));
    }

    @RabbitListener(queues = "topic.spring.demo.message")
    public void process3(Message message) {
        System.out.println(message.getMessageProperties().getReceivedRoutingKey() + " " + new String(message.getBody()));
    }
}
