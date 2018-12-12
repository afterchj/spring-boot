package com.example.demo.utils;

import com.google.common.collect.Lists;
import com.tpadsz.utils.DateUtil;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.Date;
import java.util.List;

/**
 * Created by after on 2018/12/12.
 */
public class CommonParams {

    public static List<NameValuePair> generateParams(String str, String code, String mobile) {
        List<NameValuePair> params = Lists.newArrayList();
        params.add(new BasicNameValuePair("SpCode", Constants.MESSAGE_SPCODE));
        params.add(new BasicNameValuePair("LoginName", Constants.MESSAGE_ACCOUNT));
        params.add(new BasicNameValuePair("Password", Constants.MESSAGE_PASSWORD));
        String content = String.format(Constants.APPID_MSG, code);
        System.out.println("content="+content);
        params.add(new BasicNameValuePair("MessageContent", content));
        params.add(new BasicNameValuePair("UserNumber", mobile));
        params.add(new BasicNameValuePair("SerialNumber", DateUtil.format(new Date(), "yyyyMMddhhmmssSSS")));
        params.add(new BasicNameValuePair("f", "1"));
        return params;
    }
}
