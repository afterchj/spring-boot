package com.example.demo.controller;

import com.example.demo.entity.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hongjian.chen on 2018/8/24.
 */

@Controller
@RequestMapping(value = "/home")
public class HomeController {
    @RequestMapping(value = "/person")
    public String hello(Model model) {

        Person single = new Person("after", 23);
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Person p = new Person("test" + i, (i + 20));
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
}
