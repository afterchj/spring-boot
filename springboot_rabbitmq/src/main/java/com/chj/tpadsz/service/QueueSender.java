package com.chj.tpadsz.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by hongjian.chen on 2018/12/27.
 */

@Service
public class QueueSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send1() {
        for (int i = 0; i < 100; i++) {
            rabbitTemplate.convertAndSend("hello-queue", "hello " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").format(new Date()));
        }
    }

    public void send2() {
        String context = "hello " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").format(new Date());
        rabbitTemplate.convertAndSend("hello-queue", context);
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
