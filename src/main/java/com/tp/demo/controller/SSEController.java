package com.tp.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

/**
 * Created by hongjian.chen on 2018/8/24.
 */

@Controller
public class SSEController {

    @ResponseBody
    @RequestMapping(value = "/push", produces = "text/event-stream")
    public String push() {
        Random r = new Random();
        try {
            Thread.sleep(3000
            );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int n = r.nextInt(1000) + 3;
        return "data:Testing 1,2,3," + n + "\n\n";
    }
}
