package com.tp.jcf.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by hongjian.chen on 2018/8/30.
 */
@Service
public class SecheduleTaskService {

    private final static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        System.out.println("每个5秒执行一次 " + DATE_FORMAT.format(new Date()));
    }

    @Scheduled(cron = "0 47 10 ? * *")
    public void fixTimeExcute() {
        System.out.println("在指定时间执行 " + DATE_FORMAT.format(new Date()));
    }
}
