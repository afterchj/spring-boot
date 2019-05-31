package com.example.blt.controller;

import com.example.blt.entity.HostInfo;
import com.example.blt.utils.ConsoleUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by hongjian.chen on 2019/5/17.
 */

@Controller
public class HomeController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/welcome")
    public String welcome(){
        return "welcome";
    }

    @RequestMapping("/index2")
    public String index2(){
        return "index2";
    }

    @ResponseBody
    @RequestMapping(value = "/hosts", method = RequestMethod.GET)
    public List<HostInfo> showHosts() {
        List<HostInfo> infoList = ConsoleUtil.getHosts();
        infoList = infoList.stream().filter(o -> !o.getIp().equals("127.0.0.1")).collect(Collectors.toList());
        return infoList;
    }
}
