//package com.example.demo.controller;
//
//import com.alibaba.fastjson.JSON;
//import com.example.demo.dao.SysUserRepository;
//import com.example.demo.entity.Msg;
//import com.example.demo.entity.SysUser;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import java.security.Principal;
//
//
//@Controller
//public class LoginController {
//
//    @Autowired
//    private SysUserRepository userRepository;
//
//    @RequestMapping("/show")
//    public String index(Model model,Principal principal) {
//        String username=principal.getName();
//        System.out.println("username:" + username);
//        Msg msg = new Msg("测试标题", "测试内容", "额外信息，只对管理员显示");
//        model.addAttribute("msg", msg);
//        model.addAttribute("username", username);
//        return "home";
//    }
//
//    @RequestMapping("/sin_in")
//    public String login() {
//        return "home";
//    }
//
//    @ResponseBody
//    @RequestMapping(value = "/registry")
//    public String register(SysUser user) {
//        user.setUsername(user.getUsername());
//        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
//        user.setPassword(user.getPassword());
//        System.out.println("user:" + user.getUsername());
//        userRepository.save(user);
//        return "ok";
//    }
//}
