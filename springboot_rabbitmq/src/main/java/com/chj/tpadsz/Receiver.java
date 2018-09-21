package com.chj.tpadsz;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

	@RabbitListener(queues = "my-queue")
    public void receiveMessage(String message) {

        try {
            System.out.println("Received <" + message + ">");
            new Thread().sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
