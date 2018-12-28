package com.chj.tpadsz.service;

import com.chj.tpadsz.component.Person;
import com.chj.tpadsz.component.User;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;



/**
 * Created by hongjian.chen on 2018/9/21.
 */

@Service
public class ReceiverService {

    @JmsListener(destination = "queue://com.tpadsz.uic.queue.email")
    public void receiverMessage1(String message) {
        System.out.println("接收到queue://com.tpadsz.uic.queue.email消息：" + message);
    }

    @JmsListener(destination = "after-destination")
    public void receiverMessage2(User message) {
        System.out.println("接收到after-destination消息：" + message);
    }

    @JmsListener(destination = "com.tpadsz.uic.queue.email")
    public void receiverMessage3(String message) {
        System.out.println("接收到com.tpadsz.uic.queue.email消息：" + message);
    }


}
