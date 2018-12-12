package com.example.demo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.tpadsz.after.api.RecordBillService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hongjian.chen on 2018/12/10.
 */

@Service(version = "0.4.0")
public class RecordBillServiceImpl implements RecordBillService<Map> {

    @Override
    public Map getByDeviceId(String s) {
        Map map = new HashMap();
        map.put("deviceId", s);
        map.put("bossUid", "555");
        map.put("lightUid", "999");
        map.put("other", "V4 test is ok!");
        System.out.println(JSON.toJSONString(map));
        return map;
    }

    @Override
    public Map getByLightUid(String s) {
        return null;
    }

    @Override
    public void insetBill(Map map) {

    }

    @Override
    public List<Map> getChargeList(String s) {
        return null;
    }

    @Override
    public Map getSumCharge(String s) {
        return null;
    }
}
