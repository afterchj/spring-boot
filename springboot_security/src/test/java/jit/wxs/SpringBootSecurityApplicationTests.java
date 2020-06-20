package jit.wxs;

import com.alibaba.fastjson.JSON;
import jit.wxs.dao.RoleDao;
import jit.wxs.model.Role;
import jit.wxs.model.UserEntity;
import jit.wxs.service.RoleService;
import jit.wxs.service.UserService;
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
