package com.chj.tpadsz;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.amqp.core.Queue;

/**
 * Created by hongjian.chen on 2018/9/21.
 */

@SpringBootApplication
public class MyApplication implements CommandLineRunner {


    @Autowired
   private RabbitTemplate rabbitTemplate; //1

    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }

    @Bean //2
    public Queue wiselyQueue(){
        return new Queue("my-queue");
    }


    @Override
    public void run(String... args) throws Exception {
        for (int i=1;i<11;i++){
            rabbitTemplate.convertAndSend("my-queue", "来自RabbitMQ的问候"+i);
            sleepOneSecond();

        }
    }
    public void sleepOneSecond(){
        try {
            new Thread().sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
