package com.chj.tpadsz;

import com.chj.tpadsz.entity.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hongjian.chen on 2018/12/28.
 */

@Service
public class ObjSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void sendObj(User user) throws InterruptedException {
        rabbitTemplate.convertAndSend("hello-object",user);
        new Thread().sleep(1000);
    }
}
