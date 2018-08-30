package com.tp.demo.controller;

import com.tp.demo.service.PushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * Created by hongjian.chen on 2018/8/24.
 */

@Controller
public class AsyncController {

    @Autowired
    private PushService pushService;

    @ResponseBody
    @RequestMapping(value = "/defer")
    public DeferredResult<String> deferredResult(){
        return pushService.getAsyncUpdate();
    }
}
