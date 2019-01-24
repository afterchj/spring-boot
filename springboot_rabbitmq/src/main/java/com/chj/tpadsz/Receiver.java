package com.chj.tpadsz;

import com.chj.tpadsz.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    private Logger logger = LoggerFactory.getLogger(Receiver.class);

    @RabbitListener(queues = "tpad-blt-console-queue")
    public void remoteMsg(Message message) throws InterruptedException {
        logger.info("receive message:{} " + message.getMessageProperties().getReceivedRoutingKey() + " " + new String(message.getBody()));
    }

    @RabbitListener(queues = "hello-object")
    public void process(User user) throws InterruptedException {
        logger.info("Receiver object:" + user);
        new Thread().sleep(1000);
    }
}
