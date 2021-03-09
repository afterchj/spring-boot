package com.qiyuan.controller;

import com.alibaba.fastjson.JSON;
import com.qiyuan.entity.User;
import com.qiyuan.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Random;

/**
 * @author jitwxs
 * @date 2018/3/20 11:22
 */
@Controller
public class LoginController {
    @Autowired
    IUserService userService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(User user, boolean rememberMe) {
        try {
            System.out.println("user:" + user.toString());
            Subject currentUser = SecurityUtils.getSubject();
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getName(), user.getPassword(), rememberMe);
            //进行验证，这里可以捕获异常，然后返回对应信息
            currentUser.login(usernamePasswordToken);
            if (currentUser.isAuthenticated()) {
                return "home";
            } else {
                usernamePasswordToken.clear();
                return "redirect:login";
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            return "redirect:login";
        }
    }


    @RequestMapping("/save")
    public String save(User user) {
        System.out.println("id=" + user.getId());
        if (user.getId() == null || "".equals(user.getId())) {
            String id = user.getId() == null ? String.valueOf(new Random().nextInt(100)) : user.getId();
            user.setId(id);
            userService.insertUser(user);
        } else {
            userService.updateUser(user);
        }
        return "forward:/list";
    }

    @RequestMapping(value = "/list")
    public String list(Model model, String ids) {
        List<User> users = userService.selectByIds(ids);
        System.out.println(JSON.toJSONString(users));
        model.addAttribute("users", users);
        return "list";
    }

    @RequestMapping(value = "/createUI")
    public String creat() {
        return "create";
    }

    @GetMapping("/editUI")
    public String edit(String id, Model model) {
        User user = userService.selectById(id);
        System.out.println("user=" + JSON.toJSONString(user));
        if (user != null) {
            model.addAttribute("user", user);
        }
        return "edit";
    }

    @RequestMapping("/logout")
    public String logout() {
        return "redirect:/logout";
    }

    @RequiresRoles("admin")
    @RequiresPermissions("create")
    @RequestMapping("/adminCreate")
    @ResponseBody
    public String adminCreate() {
        return "只有[admin]身份且具有[create]权限才能看见这句话";
    }
}