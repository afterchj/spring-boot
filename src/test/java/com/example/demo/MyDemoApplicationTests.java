package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.example.demo.dao.RedisDao;
import com.example.demo.dao.UserDao;
import com.example.demo.entity.UserVo;
import com.example.demo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyDemoApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private RedisDao redisDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserService userService;

    @Test
    public void testUserDao() {
//        for (int i = 0; i < 3; i++) {
//            UserVo userVo = new UserVo();
//            userVo.setIsAdmin(false);
//            userVo.setCompany("苏州天平先进数字科技有限公司");
//            userVo.setLoginName("test"+(i+1));
//            userVo.setUserName("测试员");
//            userVo.setPassword("123"+i);
//            userVo.setTelephone("1817075568"+i);
//            userService.insertUser(userVo);
//        }


        List<UserVo> list = userDao.getAll();
//        Map map = userDao.getById(5);
//        System.out.println(JSON.toJSONString(map));
        System.out.println(JSON.toJSONString(list));
    }

    @Test
    public void testRedis() {
        redisDao.setKey("name", "admin.chen");
        redisDao.setKey("age", "23");
        System.out.println("redis test="+redisDao.getValue("name"));
    }
}
