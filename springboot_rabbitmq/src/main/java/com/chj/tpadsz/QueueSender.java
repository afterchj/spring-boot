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

    public void send(int i) {
        rabbitTemplate.convertAndSend("hello-queue", "say hello " + i);
    }

    public void sendObj(User user) throws InterruptedException {
        rabbitTemplate.convertAndSend("hello-object", user);
    }

    public void sleepOneSecond() {
        try {
            new Thread().sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
