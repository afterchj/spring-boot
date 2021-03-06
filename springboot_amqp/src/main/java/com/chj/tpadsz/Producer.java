package com.chj.tpadsz;

import com.chj.tpadsz.component.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.Queue;
import javax.jms.Topic;
import java.util.Date;

/**
 * Created by hongjian.chen on 2018/12/28.
 */

@Component
@EnableScheduling
public class Producer {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Resource(name = "queue2")
    private Queue queue;

    @Resource(name = "topic1")
    private Topic topic;


    @Scheduled(fixedDelay = 3000)    // 每3s执行1次
    public void send() {
        jmsTemplate.convertAndSend(queue, "send time:" + new Date().getTime());
    }
//
//    @Scheduled(fixedDelay = 2000)    // 每2s执行1次
//    public void sendTopic() {
//        jmsTemplate.convertAndSend(topic, new User(102,"admin"));
//    }
}
