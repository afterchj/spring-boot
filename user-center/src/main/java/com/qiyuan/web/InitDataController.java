package com.qiyuan.web;

import com.qiyuan.model.UserEntity;
import com.qiyuan.model.dd.ResultDict;
import com.qiyuan.service.UserService;
import com.qiyuan.model.UserEntity;
import com.qiyuan.model.dd.ResultDict;
import com.qiyuan.service.RoleService;
import com.qiyuan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class InitDataController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    /**
     * 初始化用户数据
     */
    @RequestMapping("/initUserData")
    public String initUserData() {
        //普通用户
        UserEntity user = new UserEntity();
        user.setUsername("user");
        user.setPassword(BCrypt.hashpw("user", BCrypt.gensalt()));
//		user.setPassword(new BCryptPasswordEncoder().encode("user"));
        userService.saveUser(user);
        //管理员
        UserEntity admin = new UserEntity();
        admin.setUsername("admin");
        admin.setPassword(BCrypt.hashpw("admin", BCrypt.gensalt()));
//		admin.setPassword(new BCryptPasswordEncoder().encode("admin"));
        userService.saveUser(admin);

        return "success";
    }

    /**
     * 初始化用户数据
     */
    @RequestMapping("/userAdd")
    public String registerUser(String name, String password) {
        Map map = new HashMap();
        map.put("roleId", 1);
        //普通用户
        UserEntity user = new UserEntity();
        user.setUsername(name);
        user.setPassword(BCrypt.hashpw(password, BCrypt.gensalt()));
//		user.setPassword(new BCryptPasswordEncoder().encode("user"));
        userService.saveUser(user);
        map.put("userId", user.getId());
        roleService.insertUserRole(map);
        return "success";
    }

    @RequestMapping("/userList")
    public Map getAllUser() {
        Map result = new HashMap();
        result.put("code", ResultDict.SUCCESS.getCode());
        result.put("msg", ResultDict.SUCCESS.getValue());
        List<Map> u = userService.getAll();
        result.put("data", u);
        return result;
    }
}
