package com.chj.tpadsz;

import com.chj.tpadsz.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by hongjian.chen on 2018/12/27.
 */
@Component
@RabbitListener(queues = "hello-object")
public class ObjRecive {
    private Logger logger = LoggerFactory.getLogger(QueueSender.class);

    @RabbitHandler
    public void process(User user) throws InterruptedException {
        logger.info("Receiver object:" + user);
        System.out.println("Receiver hello-object: " + user);
        new Thread().sleep(3000);
    }

}
