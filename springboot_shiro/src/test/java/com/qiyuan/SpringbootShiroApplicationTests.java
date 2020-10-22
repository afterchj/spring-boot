package com.qiyuan;

import com.alibaba.fastjson.JSON;
import com.qiyuan.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
@MapperScan("com.qiyuan.mapper")
public class SpringbootShiroApplicationTests {

    @Autowired
    IUserService userService;

    @Test
    public void contextLoads() {
        String ids="1,2,3";
        System.out.println("Hello World!" + JSON.toJSONString(userService.findByName("zhangsan")));
        log.warn("userList {}",userService.selectByIds(ids));

    }

}
