package com.example.demo;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.example.demo.dao.RedisDao;
import com.example.demo.dao.UserDao;
import com.example.demo.entity.UserVo;
import com.example.demo.entity.bo.MailBO;
import com.example.demo.service.UserService;
import com.example.demo.util.MailUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyDemoApplicationTests {
    Logger logger = LoggerFactory.getLogger(MyDemoApplicationTests.class);

    @Test
    public void contextLoads() throws Exception {
        run();
    }

    @Autowired
    private RedisDao redisDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserService userService;



    @Autowired
    private MailUtil mailUtil;

    private MailBO mailBean = new MailBO();

    @Before
    public void buildSimpleMail() {
        mailBean.setUrl("https://www.baidu.com");
        mailBean.setSubject("测试SpringBootMail");
        mailBean.setContent("测试内容，不用回复");
        mailBean.setReceives(Arrays.asList("766256898@qq.com", "hjchencl@isoftstone.com"));
        mailBean.setCcReceives(Arrays.asList("1432668569@qq.com"));
    }

    @Test
    public void load() {
        System.out.println("....................");
    }

    @Test
    public void sendSimpleMail() throws Exception {
        mailUtil.sendSimpleMail(mailBean);
    }

    @Test
    public void sendHTMLMail() throws Exception {
        mailUtil.sendHTMLMail(mailBean);
    }

    @Test
    public void sendAttachmentMail() throws Exception {
        mailBean.setSubject("测试SpringBoot发送附件");
        mailBean.setContent("测试SpringBoot发送附件，正文部分");
        mailUtil.sendAttachmentMail(mailBean);

    }

    @Test
    public void sendInlineMail() throws Exception {
        mailBean.setSubject("测试SpringBoot发送带静态资源邮件");
        mailBean.setContent("测试SpringBoot发送带静态资源邮件，正文部分");
        mailUtil.sendInlineMail(mailBean);
    }

    @Test
    public void sendTemplateMail() throws Exception {
        mailBean.setSubject("测试SpringBoot发送带FreeMarker邮件");
        mailBean.setContent("希望大家能够学到自己想要的东西，谢谢各位的帮助！！！");
        mailUtil.sendTemplateMail(mailBean);
    }

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
        System.out.println("redis test=" + redisDao.getValue("name"));
    }

    public void run() throws Exception {
        ExecutorService es = Executors.newCachedThreadPool();
        for (int i = 0; i < 1000; i++) {
            int temp = i;
            es.execute(() -> {
                logger.warn("index {}", temp);
            });
        }
        logger.warn("execute...");
    }
}
