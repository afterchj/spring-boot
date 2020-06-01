package jit.wxs;

import com.alibaba.fastjson.JSON;
import jit.wxs.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootShiroApplicationTests {

    Logger logger = LoggerFactory.getLogger(SpringbootShiroApplicationTests.class);
    @Autowired
    IUserService userService;

    @Test
    public void contextLoads() {
        System.out.println("Hello World!" + JSON.toJSONString(userService.findByName("zhangsan")));
    }

}
