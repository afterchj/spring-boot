package com.example.demo.controller;

import com.example.demo.exception.InvalidCodeException;
import com.example.demo.service.MsgSendService;
import com.example.demo.utils.Constants;
import org.apache.commons.lang3.StringUtils;
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
    public Map testSend(String appid, String mobile) {
        appid = StringUtils.isEmpty(appid) ? "12" : appid;
        Map map = new HashMap();
        String str = Constants.PROPERTIES_LOADER.getProperty("message.sender.appid" + appid + ".msg");
        String code = null;
        try {
            code = sendService.updateCheckOut(appid, mobile);
        } catch (Exception e) {
            map.put("value", e.getMessage());
        }
        map.put("content", str);
        map.put("code", code);
        return map;
    }

    @RequestMapping("/login")
    public Map verifyCode(String code, String mobile) {
        Map map = new HashMap();
        try {
            String value = sendService.checkValidation(code, mobile);
            map.put("value", value);
        } catch (InvalidCodeException e) {
            map.put("error", e.getMessage());
        }
        return map;
    }

}
