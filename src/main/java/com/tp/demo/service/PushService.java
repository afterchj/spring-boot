package com.tp.demo.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * Created by hongjian.chen on 2018/8/24.
 */

@Service
public class PushService {

    private DeferredResult<String> deferredResult;

    public DeferredResult<String> getAsyncUpdate(){
        deferredResult=new DeferredResult<>();
        return deferredResult;
    }

    @Scheduled(fixedDelay = 3000)
    public void refresh(){
        if (deferredResult!=null){
            deferredResult.setResult(new Long(System.currentTimeMillis()).toString());
        }
    }
}
