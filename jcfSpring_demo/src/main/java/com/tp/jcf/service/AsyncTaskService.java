package com.tp.jcf.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Created by hongjian.chen on 2018/8/27.
 */

@Service
public class AsyncTaskService {

    @Async
    public void executeAsyncTask(int i) {
        System.out.println("executeAsyncTask:" + i);
    }

    @Async
    public void executeAsyncTaskPlus(int i) {
        System.out.println("executeAsyncTaskPlus:" + (i + 1));
    }
}
