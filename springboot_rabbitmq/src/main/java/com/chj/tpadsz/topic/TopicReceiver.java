package com.chj.tpadsz.topic;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by hongjian.chen on 2018/12/28.
 */

@Component
public class TopicReceiver {


    @RabbitListener(queues = "topic.message")
    public void process1(String message) {
        System.out.println("Topic Receiver1  : " + message);
    }

    @RabbitListener(queues = "topic.messages")
    public void process2(String message) {
        System.out.println("Topic Receiver2  : " + message);
    }
}
