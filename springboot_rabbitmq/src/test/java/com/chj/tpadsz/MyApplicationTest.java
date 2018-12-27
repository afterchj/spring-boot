package com.chj.tpadsz;

import com.chj.tpadsz.service.QueueSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * Created by hongjian.chen on 2018/12/27.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyApplicationTest {

    @Autowired
    private QueueSender queueSender;

    @Test
    public void test1() throws InterruptedException {
//        queueSender.sendMsg();
        System.out.println("-------------------------------分割线-------------------------------");
//        queueSender.send1();
        Thread.sleep(5000);
    }

    @Test
    public void test2(){
        String str = String.valueOf(new Date().getTime());
        String countStr = str.substring(str.length()-12, str.length()-3);
        System.out.println("=============old countStr new===========" + countStr);
    }
}
