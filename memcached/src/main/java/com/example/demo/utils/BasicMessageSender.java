package com.example.demo.utils;

import com.example.demo.entity.HttpUtils;
import com.example.demo.entity.MNumValidation;
import com.example.demo.utils.Constants;
import com.google.common.collect.Lists;
import com.tpadsz.utils.DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.*;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;

public class BasicMessageSender implements Callable<Boolean> {

    private Logger logger = Logger.getLogger(BasicMessageSender.class);
    private String mobile;
    private String code;
    private String formatter;

    public BasicMessageSender(String key, String code, String formatter) {
        super();
        String[] keys = key.split("_");
        this.mobile = keys[1];
        this.code = code;
        this.formatter = formatter;
    }

    public BasicMessageSender(MNumValidation invitation) {
        this(invitation.getKey(), invitation.getValue(), invitation.getFormatter());
    }

    private List<NameValuePair> generateParams() {
        List<NameValuePair> params = Lists.newArrayList();
        params.add(new BasicNameValuePair("SpCode", Constants.MESSAGE_SPCODE));
        params.add(new BasicNameValuePair("LoginName", Constants.MESSAGE_ACCOUNT));
        params.add(new BasicNameValuePair("Password", Constants.MESSAGE_PASSWORD));
        String content = String.format(formatter, this.code);
        params.add(new BasicNameValuePair("MessageContent", content));
        params.add(new BasicNameValuePair("UserNumber", this.mobile));
        params.add(new BasicNameValuePair("SerialNumber", DateUtil.format(new Date(), "yyyyMMddhhmmssSSS")));
        params.add(new BasicNameValuePair("f", "1"));
        return params;
    }

    private boolean sendMessage() {
        List<NameValuePair> params = generateParams();
        Integer status = null;
        int count = 0;
        boolean isSended = false;
        do {
            HttpResponse response = HttpUtils.post(Constants.MESSAGE_SEND_URL, "gbk", params);
            try {
                if (response != null) {
                    status = response.getStatusLine().getStatusCode();
                    System.out.println("status=" + status);
                    HttpEntity entity = response.getEntity();
                    if (entity != null) {
                        isSended = checkResult(entity);
                        System.out.println("flag=" + isSended);
                    }
                }
            } catch (Exception e1) {
                logger.error(e1);
            } finally {
                count++;
            }
        } while ((status == null || status != HttpStatus.SC_OK) && count < 3);
        return isSended;

    }

    private boolean checkResult(HttpEntity entity) throws ParseException, IOException {
        String data = EntityUtils.toString(entity, "gbk");
        System.out.println("result="+data);
        boolean isSended = false;
        if (StringUtils.isNotBlank(data)) {
            String[] pairs = StringUtils.split(data, "&");
            if (pairs != null && pairs.length != 0) {
                String result = null;
                String descr = null;
                for (String pair : pairs) {
                    if (StringUtils.isNotBlank(pair)) {
                        String[] nameValue = StringUtils.split(pair, "=");
                        if (nameValue != null && nameValue.length == 2) {
                            String name = nameValue[0];
                            String value = nameValue[1];
                            if (StringUtils.equals(name, "result")) {
                                result = value;
                            } else if (StringUtils.equals(name, "description")) {
                                descr = value;
                            }
                        }
                    }
                }
                if (StringUtils.equals(result, "0")) {
                    isSended = true;
                } else {
                    logger.error("Sending Message Error. Code: " + result + ", Because : " + descr);
                }
            }
        }
        return isSended;
    }

    @Override
    public Boolean call() throws Exception {
        return sendMessage();
    }

}
