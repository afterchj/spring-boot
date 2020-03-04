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
    public void process1(String message) {
        logger.warn("receive topic.test.demo msg {}", message);
    }

    @RabbitListener(queues = "topic.spring.demo.message")
    public void process2(String message) {
        logger.warn("receive topic.spring.demo.message {}" ,message);
    }

    @RabbitListener(queues = "topic.spring.demo")
    public void process3(String message) {
        logger.warn("receive topic.spring.demo {}", message);
    }
}
