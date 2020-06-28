package com.qiyuan;

import com.alibaba.fastjson.JSON;
import com.qiyuan.dao.RoleDao;
import com.qiyuan.model.Role;
import com.qiyuan.model.UserEntity;
import com.qiyuan.service.RoleService;
import com.qiyuan.service.UserService;
import com.qiyuan.dao.RoleDao;
import com.qiyuan.model.Role;
import com.qiyuan.model.UserEntity;
import com.qiyuan.service.RoleService;
import com.qiyuan.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootSecurityApplicationTests {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private RoleDao roleDao;

    @Test
    public void testAddUser() {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("zdqian");
        userEntity.setPassword("123456");
//        userService.saveUser(userEntity);
//        System.out.println(userEntity.getId());
        Map userRole = new HashMap();
        userRole.put("userId", 4);
        userRole.put("roleId", 1);
        roleService.insertUserRole(userRole);
        System.out.println(JSON.toJSONString(roleService.getAll()));
    }

    @Test
    public void test() {
        List<Role> roles = roleDao.getUserRoleByUserId(1);
        System.out.println("roles="+JSON.toJSONString(roles));
//        for (int i = 0; i < 3; i++) {
//            System.out.println(BCrypt.gensalt());
//        }
    }
}
