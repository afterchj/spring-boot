package com.example.demo.service.impl;

import com.example.demo.constants.MemcachedObjectType;
import com.example.demo.constants.MobileVerifyType;
import com.example.demo.exception.InvalidCodeException;
import com.example.demo.utils.HttpUtils;
import net.rubyeye.xmemcached.XMemcachedClient;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * Created by hongjian.chen on 2018/12/13.
 */
@Service
public class ValidationService {

    @Autowired
    XMemcachedClient client;

    public String checkOut(String appid, String mobile, MobileVerifyType type) throws Exception {
        String key = String.format(MemcachedObjectType.CACHE_MESSAGE_VERIFICATION.getPrefix(), type.getValue() + mobile);
        System.out.println("formatKey=" + key);
        String code = getCode(key);
        if (StringUtils.isEmpty(code)) {
            code = prepare(key, code);
        }
        HttpUtils.callSendMsg(appid, code, mobile);
        return code;
    }

    public String checkValidation(String code, String mobile, MobileVerifyType type) throws InvalidCodeException {
        String key = String.format(MemcachedObjectType.CACHE_MESSAGE_VERIFICATION.getPrefix(), type.getValue() + mobile);
        String value = getCode(key);
        System.out.println("code=" + code + ",value=" + value);
        if (!StringUtils.equals(code, value)) {
            throw new InvalidCodeException("验证码不正确！");
        }
        return value;
    }

    public String prepare(String key, String code) throws Exception {
        code = StringUtils.isEmpty(code) ? getRandomNum(6) : code;
        client.set(key, MemcachedObjectType.CACHE_MESSAGE_VERIFICATION.getExpiredTime(), code);
        return code;
    }

    public String getRandomNum(int len) {
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(r.nextInt(10));
        }
        return sb.toString();
    }

    public String getCode(String key) {
        String code = null;
        try {
            code = client.get(key);
        } catch (Exception e) {
        }
        return code;
    }

}
