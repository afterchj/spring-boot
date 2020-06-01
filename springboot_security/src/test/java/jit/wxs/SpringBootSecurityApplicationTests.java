package jit.wxs;

import com.alibaba.fastjson.JSON;
import jit.wxs.entity.SysRole;
import jit.wxs.entity.SysUserRole;
import jit.wxs.service.SysRoleService;
import jit.wxs.service.SysUserRoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootSecurityApplicationTests {

    @Autowired
    private SysUserRoleService userRoleService;
    @Autowired
    private SysRoleService roleService;

    @Test
    public void contextLoads() {
        List<SysUserRole> userRoles = userRoleService.listByUserId(1);
        List<SysRole> roles = new ArrayList<>();
        for (SysUserRole userRole : userRoles) {
            SysRole role = roleService.selectById(userRole.getRoleId());
            roles.add(role);
        }
        System.out.println("result:" + JSON.toJSONString(roles));
    }

    @Test
    public void test() {
        for (int i = 0; i < 3; i++) {
            System.out.println(BCrypt.gensalt());
        }
    }
}
