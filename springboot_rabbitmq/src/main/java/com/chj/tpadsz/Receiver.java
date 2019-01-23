package com.chj.tpadsz;

import com.chj.tpadsz.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    private Logger logger = LoggerFactory.getLogger(Receiver.class);

    @RabbitListener(queues = "tpad-blt-console-queue")
    public void remoteMsg(String message) throws InterruptedException {
        logger.info("Receive tpad-blt-console-queue:" + message);
        System.out.println("receive message:" + message);
    }

    @RabbitListener(queues = "hello-object")
    public void process(User user) throws InterruptedException {
        logger.info("Receiver object:" + user);
        System.out.println("Receiver hello-object: " + user);
        new Thread().sleep(1000);
    }
}
