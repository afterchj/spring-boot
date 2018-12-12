package com.example.demo.utils;

import com.example.demo.entity.MNumValidation;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.*;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import java.io.IOException;
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


//    private boolean sendMessage() {
//        List<NameValuePair> params = CommonParams.generateParams(formatter, code, mobile);
//        Integer status = null;
//        int count = 0;
//        boolean isSended = false;
//        do {
//            HttpResponse response = HttpUtils.post(Constants.MESSAGE_SEND_URL, "gbk", params);
//            try {
//                if (response != null) {
//                    status = response.getStatusLine().getStatusCode();
//                    System.out.println("status=" + status);
//                    HttpEntity entity = response.getEntity();
//                    if (entity != null) {
//                        isSended = checkResult(entity);
//                        System.out.println("flag=" + isSended);
//                    }
//                }
//            } catch (Exception e1) {
//                logger.error(e1);
//            } finally {
//                count++;
//            }
//        } while ((status == null || status != HttpStatus.SC_OK) && count < 3);
//        return isSended;
//
//    }



    @Override
    public Boolean call() throws Exception {
        return true;
    }

}
