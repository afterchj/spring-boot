package com.chj.tpadsz;

import com.chj.tpadsz.service.QueueSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by hongjian.chen on 2018/12/27.
 */
@Component
@RabbitListener(queues = "hello-queue")
public class QueueRecive {
    private Logger logger = LoggerFactory.getLogger(QueueSender.class);
    @RabbitHandler
    public void process(String msg) throws InterruptedException {
        logger.info("Receiver1:"+msg);
        System.out.println("Receiver1 hello-queue: " + msg);
        new Thread().sleep(1000);
    }

}
