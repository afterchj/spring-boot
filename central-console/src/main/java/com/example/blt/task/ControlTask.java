package com.example.blt.task;

import com.example.blt.netty.ClientMain;

import java.util.concurrent.*;

/**
 * Created by after on 2019/5/31.
 */
public class ControlTask implements Callable<String> {

    private ClientMain clientMain;
    private String val;
    private boolean flag;

    public ControlTask(ClientMain clientMain, String val, boolean flag) {
        this.clientMain = clientMain;
        this.val = val;
        this.flag = flag;
    }

    @Override
    public String call() {
        String result;
        try {
            clientMain.sendCron(8001,val, flag);
            result = "ok";
        } catch (Exception e) {
            result = "fail";
        }
        return result;
    }

    public String executeTask() {
        ExecutorService executor = Executors.newCachedThreadPool();
        FutureTask<String> futureTask = new FutureTask(this);
        executor.submit(futureTask);
        executor.shutdown();
        String result;
        try {
            result = futureTask.get();
        } catch (Exception e) {
            result = "fail";
        }
        return result;
    }
}
