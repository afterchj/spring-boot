package com.example.demo.service.dubbo;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.demo.service.DemoService;
import com.tpadsz.after.api.RecordBillService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by hongjian.chen on 2018/12/12.
 */

@Service
public class DemoServiceConsume {

    @Reference(version = "1.0.0")
    DemoService demoService1;

    @Reference(version = "2.0.0")
    DemoService demoService2;

    @Reference(version = "0.4.0")
    RecordBillService recordBillService0;

    public Map test0() {
        return (Map) recordBillService0.getByDeviceId("dev_7777");
    }


    public String test1() {
        return demoService1.version("1");
    }

    public String test2() {
        return demoService2.version("2");
    }
}
