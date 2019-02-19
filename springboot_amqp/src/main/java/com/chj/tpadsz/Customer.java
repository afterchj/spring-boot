package com.chj.tpadsz;

import com.chj.tpadsz.component.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;

/**
 * Created by hongjian.chen on 2018/12/28.
 */

@Component
public class Customer {

    private final static Logger logger = LoggerFactory.getLogger(Customer.class);

    //queue模式
    @JmsListener(destination = "queue-1", containerFactory = "jmsListenerContainerQueue")
    public void receiveQueue(String text) throws JMSException {
        System.out.println(text + " queue-1 消息已经消费了");
    }

    //topic模式
    @JmsListener(destination = "topic-1", containerFactory = "jmsListenerContainerTopic")
    public void receiveTopic(String text) throws JMSException {
        System.out.println(text + " topic-1 消息已经消费了");
    }

}
