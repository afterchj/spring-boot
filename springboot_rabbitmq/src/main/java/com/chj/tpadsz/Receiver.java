package com.chj.tpadsz;

import com.chj.tpadsz.service.QueueSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    private Logger logger = LoggerFactory.getLogger(Receiver.class);

    @RabbitListener(queues = "my-queue")
    public void receiveMessage(String message) {

        try {
            System.out.println("Received my-queue-><" + message + ">");
            new Thread().sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @RabbitListener(queues = "hello-queue")
    public void receiveMsg(String message) throws InterruptedException {
        logger.info("Receiver2:" + message);
        System.out.println("Receiver2 hello-queue->" + message);
        new Thread().sleep(1000);
    }
}
