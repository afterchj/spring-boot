package com.example.demo.service;

import com.example.demo.exception.InvalidCodeException;


/**
 * Created by after on 2018/12/12.
 */
public interface MsgSendService {
    String updateCheckOut(String appid, String mobile) throws Exception;

    String checkValidation(String code, String mobile) throws InvalidCodeException;
}
