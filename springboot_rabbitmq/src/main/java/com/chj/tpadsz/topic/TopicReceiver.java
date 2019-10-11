package com.chj.tpadsz.topic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by hongjian.chen on 2018/12/28.
 */

@Component
public class TopicReceiver {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RabbitListener(queues = "topic.test.demo")
    public void process1(Message message) {
        logger.warn("receive topic.test.demo msg {}", new String(message.getBody()));
    }

    @RabbitListener(queues = "topic.spring.demo.message")
    public void process2(Message message) {
        logger.warn("receive topic.spring.demo.message {}" ,new String(message.getBody()));
    }

    @RabbitListener(queues = "topic.spring.demo")
    public void process3(Message message) {
        logger.warn("receive topic.spring.demo {}", new String(message.getBody()));
    }
}
