package com.chj.tpadsz.service;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

/**
 * Created by hongjian.chen on 2018/9/21.
 */

@Service
public class ReceiverService {

    @JmsListener(destination = "test-destination")
    public void receiverMessage(String message) {
        System.out.println("接收到：<" + message + ">");
    }
}
