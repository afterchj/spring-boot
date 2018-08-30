package com.tp.demo.controller;

import com.tp.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by hongjian.chen on 2018/8/24.
 */

@Controller
@RequestMapping(value = "/another")
public class JsonController {

    @ResponseBody
    @RequestMapping(value = "/test", produces = "text/plain;charset=UTF-8")
    public String index(HttpServletRequest request) {
        return "url:" + request.getRequestURI() + " can access";
    }

    @ResponseBody
    @RequestMapping(value = "/pathVar/{str}", produces = "text/plain;charset=UTF-8")
    public String pathVar(@PathVariable String str, HttpServletRequest request) {
        return "url:" + request.getRequestURI() + " can access,str:" + str;
    }

    @ResponseBody
    @RequestMapping(value = "/reqParam", produces = "text/plain;charset=UTF-8")
    public String passRequestParam(int id, HttpServletRequest request) {
        return "url:" + request.getRequestURI() + " can access,id:" + id;
    }

    @ResponseBody
    @RequestMapping(value = "/obj", produces = "application/json;charset=UTF-8")
    public String passObj(User user, HttpServletRequest request) {
        return "url:" + request.getRequestURI() + " can access,id:" + user.getId() + ",name:" + user.getLoginName();
    }

    @ResponseBody
    @RequestMapping(value = {"/name1", "/name2"}, produces = "text/plain;charset=UTF-8")
    public String remove(HttpServletRequest request) {
        return "url:" + request.getRequestURI() + " can access";
    }
}
