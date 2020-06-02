package jit.wxs.web;

import jit.wxs.model.UserEntity;
import jit.wxs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InitDataController {
    @Autowired
    private UserService userService;

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
}
