package com.chj.tpadsz;

import com.chj.tpadsz.entity.User;
import com.chj.tpadsz.topic.TopicSender;
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

    @Autowired
    private ObjSender objSender;

    @Autowired
    private TopicSender topicSender;

    @Test
    public void test1() throws InterruptedException {
//        queueSender.sendMsg();
        Thread.sleep(10000);
        System.out.println("-------------------------------分割线-------------------------------");
//        for (int i = 0; i < 10; i++) {
        topicSender.send();
        topicSender.send1();
        topicSender.send2();
//            objSender.sendObj(new User(i, "test" + i));
//            queueSender.send1(i);
//            queueSender.send2(i);
//        }
        Thread.sleep(10000);
    }

    @Test
    public void test2() {
        String str = String.valueOf(new Date().getTime());
        String countStr = str.substring(str.length() - 12, str.length() - 3);
        System.out.println("=============old countStr new===========" + countStr);
    }
}
