package com.example.demo.service.dubbo;

import com.alibaba.dubbo.config.annotation.Reference;
import com.tpadsz.after.api.RecordBillService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by hongjian.chen on 2018/12/12.
 */

@Service
public class ConsumeService {

    @Reference(version = "0.3.0")
    RecordBillService recordBillService1;

    @Reference(version = "0.5.0")
    RecordBillService recordBillService2;


    public Map test1() {
        return (Map) recordBillService1.getByDeviceId("dev_1111");
    }

    public Map test2() {
        return (Map) recordBillService2.getByDeviceId("dev_2222");
    }
}
