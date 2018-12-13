package com.example.demo.service.dubbo;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.demo.exception.InvalidCodeException;
import com.example.demo.service.DemoService;
import com.example.demo.service.MsgSendService;
import com.tpadsz.after.api.RecordBillService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by hongjian.chen on 2018/12/12.
 */

@Service
public class MsgServiceConsume {

    @Reference(version = "1.0.0")
    MsgSendService msgSendService;


    public String updateCheckOut(String appid, String mobile) throws Exception {
        return msgSendService.updateCheckOut(appid, mobile);
    }

    public String checkValidation(String code, String mobile) throws InvalidCodeException {
        return msgSendService.checkValidation(code, mobile);
    }
}
