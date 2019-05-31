package com.example.blt.service;

import com.example.blt.netty.ClientMain;
import com.example.blt.netty.ServerMain;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Created by hongjian.chen on 2019/5/17.
 */
@Service
@EnableScheduling
public class NettyService implements ApplicationListener<ContextRefreshedEvent> {

    private ClientMain clientMain = new ClientMain();

    @Scheduled(cron = "0/30 * * * * ?")
    public void cronTest() {
        clientMain.sendCron("ok", false);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        new ServerMain().run(8001);
    }
}