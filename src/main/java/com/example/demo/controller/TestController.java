package com.example.demo.controller;

import com.example.demo.entity.PersonVo;
import com.example.demo.entity.TestVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by hongjian.chen on 2018/8/24.
 */

@Controller
@RequestMapping(value = "/home")
public class TestController {
    @RequestMapping(value = "/person")
    public String hello(Model model) {

        PersonVo single = new PersonVo("after", 23);
        List<PersonVo> people = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            PersonVo p = new PersonVo("test" + i, (i + 20));
            people.add(p);
        }
        model.addAttribute("singlePerson", single);
        model.addAttribute("people", people);
        return "home";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/footer")
    public String showFoot() {
        return "foot";
    }

    @RequestMapping("/test")
    public String test(ModelMap map) {
        List<TestVo> testVos = new ArrayList<>();
        testVos.add(new TestVo("测试员", 10, new Date(), 1));
        testVos.add(new TestVo("管理员", 70, new Date(), 2));
        testVos.add(new TestVo("监考官", 100, new Date(), 3));
        map.put("test", testVos);
        return "test";
    }
}
