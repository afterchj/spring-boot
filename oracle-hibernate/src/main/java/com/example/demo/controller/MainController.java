package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.entity.ConsoleInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hongjian.chen on 2019/6/12.
 */
@RestController
public class MainController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/switch")
    public String console(ConsoleInfo consoleInfo) {
        logger.info(JSON.toJSONString(consoleInfo));
        return "ok";
    }
}
