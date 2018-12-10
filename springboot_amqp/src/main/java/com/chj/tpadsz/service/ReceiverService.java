package com.chj.tpadsz.service;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

/**
 * Created by hongjian.chen on 2018/9/21.
 */

@Service
public class ReceiverService {

    @JmsListener(destination = "test-destination")
    public void receiverMessage1(String message) {
        System.out.println("接收到test-destination消息：" + message);
    }

    @JmsListener(destination = "com.tpadsz.uic.queue.myEmail")
    public void receiverMessage2(String message) {
        System.out.println("接收到com.tpadsz.uic.queue.myEmail消息：" + message);
    }

    @JmsListener(destination = "queue://com.tpadsz.uic.queue.myEmail")
    public void receiverMessage3(String message) {
        System.out.println("接收到queue://com.tpadsz.uic.queue.myEmail消息：" + message);
    }
}
