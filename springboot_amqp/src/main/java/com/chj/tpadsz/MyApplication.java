package com.chj.tpadsz;

import com.chj.tpadsz.component.Msg;
import com.chj.tpadsz.component.User;
import com.chj.tpadsz.convent.InnerMessageConverter;
import com.chj.tpadsz.convent.JsonMessageConverter;
import org.apache.activemq.command.ActiveMQObjectMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

import javax.annotation.Resource;
import javax.jms.Destination;

/**
 * Created by hongjian.chen on 2018/9/21.
 */

@SpringBootApplication
@EnableJms
public class MyApplication implements CommandLineRunner {

    @Autowired
    private JmsTemplate template;

    @Resource(name = "queue2")
    private Destination queue;

    @Autowired
    private Producer producer;

    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }


    @Override
    public void run(String... strings) throws Exception {
//        producer.send();
//        ActiveMQObjectMessage objectMessage=new ActiveMQObjectMessage();
//        objectMessage.setObject( new User(101, "after"));
//        templates.convertAndSend(queue,"test is ok");
        template.send("after-destination",new Msg());
    }
}
