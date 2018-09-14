package com.example.demo.controller;


import com.alibaba.fastjson.JSON;
import com.example.demo.dao.SysUserRepository;
import com.example.demo.entity.Msg;
import com.example.demo.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
public class HomeController {

    @Autowired
    private SysUserRepository userRepository;

    @RequestMapping("/show")
    public String index(HttpServletRequest request, Authentication authentication, Model model) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        System.out.println("User has authorities: " + JSON.toJSONString(userDetails.getAuthorities()));
        Principal principal = request.getUserPrincipal();
        System.out.println("username:" + principal.getName());
        Msg msg = new Msg("测试标题", "测试内容", "额外信息，只对管理员显示");
        model.addAttribute("msg", msg);
        model.addAttribute("username", principal.getName());
        return "home";
    }

    @ResponseBody
    @RequestMapping(value = "/registry")
    public String register(SysUser user) {
        user.setUsername(user.getUsername());
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        System.out.println("user:" + user.getUsername());
        userRepository.save(user);
        return "ok";
    }
}
