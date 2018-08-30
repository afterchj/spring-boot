package com.tp.jcf.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by hongjian.chen on 2018/8/27.
 */

@Service
public class DemoSerivce {

    @Value("Other Attributes")
    private String another;

    public String getAnother() {
        return another;
    }

    public void setAnother(String another) {
        this.another = another;
    }

}
