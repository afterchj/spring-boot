package com.chj.tpadsz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by hongjian.chen on 2018/12/27.
 */
@Component
@RabbitListener(queues = "topic.test-queue")
public class QueueRecive {
    private Logger logger = LoggerFactory.getLogger(QueueRecive.class);

    @RabbitHandler
    public void process(String msg) throws InterruptedException {
        logger.info("hello-queue:"+msg);
    }
}
