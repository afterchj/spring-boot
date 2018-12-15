package com.example.demo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.demo.constants.MobileVerifyType;
import com.example.demo.exception.InvalidCodeException;
import com.example.demo.service.MsgSendService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by after on 2018/12/12.
 */
@Service(version = "1.0.0")
//@org.springframework.stereotype.Service
public class MsgSendServiceImpl implements MsgSendService {

    @Autowired
    ValidationService validationService;

    public String updateCheckOut(String appid, String mobile) throws Exception {
        return validationService.checkOut(appid, mobile, MobileVerifyType.UPDATE);
    }

    @Override
    public String checkValidation(String code, String mobile) throws InvalidCodeException {
        return validationService.checkValidation(code, mobile, MobileVerifyType.UPDATE);
    }

}
