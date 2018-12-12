package com.example.demo.service;

import com.example.demo.utils.HttpUtils;
import com.example.demo.utils.CommonParams;
import com.example.demo.utils.Constants;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by after on 2018/12/12.
 */
@Service
public class MsgSendService {

    public boolean sendMessage(String str, String code, String mobile) {
        List<NameValuePair> params = CommonParams.generateParams(str, code, mobile);
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
                        isSended = HttpUtils.checkResult(entity);
                        System.out.println("flag=" + isSended);
                    }
                }
            } catch (Exception e1) {
            } finally {
                count++;
            }
        } while ((status == null || status != HttpStatus.SC_OK) && count < 3);
        return isSended;
    }
}
