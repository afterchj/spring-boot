package com.chj.tpadsz;

import com.chj.tpadsz.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hongjian.chen on 2018/12/27.
 */

@Service
public class QueueSender {

    private Logger logger = LoggerFactory.getLogger(QueueSender.class);

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send1(int i) {
        logger.info("sender1 send hello " + (i + 1));
        rabbitTemplate.convertAndSend("hello-queue", "sender1 hello " + (i + 1));
    }

    public void send2(int i) {
        logger.info("sender2 send hello " + (i + 1));
        rabbitTemplate.convertAndSend("hello-queue", "sender2 hello " + (i + 1));
    }

    public void sendMsg() {
        for (int i = 0; i < 3; i++) {
            rabbitTemplate.convertAndSend("my-queue", "来自RabbitMQ的问候" + (i + 1));
            sleepOneSecond();
        }
    }

    public void sleepOneSecond() {
        try {
            new Thread().sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
