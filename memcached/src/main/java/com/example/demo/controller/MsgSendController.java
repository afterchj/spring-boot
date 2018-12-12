package com.example.demo.controller;

import com.example.demo.service.MsgSendService;
import com.example.demo.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by after on 2018/12/12.
 */

@RestController
public class MsgSendController {

    @Autowired
    MsgSendService sendService;

    @RequestMapping("/verify")
    public Map testSend(String code, String mobile) {
        String str = Constants.APPID_MSG;
        Map map = new HashMap();
        boolean flag = sendService.sendMessage(str, code, mobile);
        String content = String.format(str, code);
        map.put("content", content);
        map.put("flag", flag);
        return map;
    }
}
