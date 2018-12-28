package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.example.demo.constants.MemcachedObjectType;
import com.example.demo.constants.MobileVerifyType;
import com.example.demo.entity.Person;
import com.example.demo.service.MsgSendService;
import com.whalin.MemCached.MemCachedClient;
import net.rubyeye.xmemcached.XMemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeoutException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemcachedApplicationTests {

    @Autowired
    private MemCachedClient memCachedClient;

    @Autowired
    private XMemcachedClient xMemcachedClient;

    @Autowired
    private MsgSendService sendService;

    @Test
    public void testSend() throws Exception {
        String code = sendService.updateCheckOut("12", "18170756879");
        System.out.println("code=" + code);
    }

    @Test
    public void contextLoads() throws InterruptedException {
        // 放入缓存
        boolean flag = memCachedClient.add("testKey", "testValue");
        System.out.println("flag=" + flag);

        // 取出缓存
        Object a = memCachedClient.get("testKey");
        System.out.println("a=" + a);
//        memCachedClient.set("number","100");
        memCachedClient.incr("number",1);
        System.out.println("number="+memCachedClient.get("number"));


        // 3s后过期
        memCachedClient.set("b", "2", new Date(3000));
        Object b = memCachedClient.get("b");
        System.out.println("b="+b);

        Thread.sleep(3000);
        b = memCachedClient.get("b");
        System.out.println("a=" + a);
        System.out.println("b=" + b);
    }

    @Test
    public void testCode() throws InterruptedException, MemcachedException, TimeoutException {
        String key = String.format(MemcachedObjectType.CACHE_MESSAGE_VERIFICATION.getPrefix(), MobileVerifyType.UPDATE.getValue() + "18170756879");
//        xMemcachedClient.set(key, MemcachedObjectType.CACHE_MESSAGE_VERIFICATION.getExpiredTime(), "123456");
        String value = xMemcachedClient.get(key);
        System.out.println(value);
    }

    @Test
    public void testXmemcached() throws InterruptedException, MemcachedException, TimeoutException {
        System.out.println("xMemcachedClient=" + xMemcachedClient);
        List<Person> list = new ArrayList<>();
        Person person = new Person();
        person.setName("after");
        person.setAddress("苏州");
        person.setAge(24);
        list.add(person);
        Person person1 = new Person();
        person1.setName("admin");
        person1.setAddress("苏州");
        person1.setAge(25);
        list.add(person1);
        Person person2 = new Person();
        person2.setName("test");
        person2.setAddress("苏州");
        person2.setAge(23);
        list.add(person2);
        xMemcachedClient.set("person1", 24 * 60 * 60, person);
        xMemcachedClient.set("people", 24 * 60 * 60, list);
        List<Person> people = xMemcachedClient.get("people");
        for (Person p : people) {
            System.out.println(p.toJsonString());
        }
        Person p = xMemcachedClient.get("person1");
        System.out.println("person=" + p.toJsonString());
        // set: 第一个参数是key，第二个参数是超时时间，第三个参数是value
        xMemcachedClient.set("first", 3, "tianjin");//添加或者更新
        xMemcachedClient.set("second", 2, "chengdu");//添加,key不存在添加成功返回true,否则返回false
        xMemcachedClient.replace("first", 3, "Beijing");//替换,key已经存在替换成功返回true,不存在返回false
        System.out.println("first=======================" + xMemcachedClient.get("first"));
        System.out.println("second======================" + xMemcachedClient.get("second"));
        System.out.println("--------------------------------------------------------------");

//        Thread.sleep(5000);
        System.out.println("first========================" + xMemcachedClient.get("first"));
        System.out.println("second=======================" + xMemcachedClient.get("second"));
    }

    @Test
    public void updateSerino() throws InterruptedException, MemcachedException, TimeoutException {
        //天平账号f_tpad_user
//        xMemcachedClient.set("uic_counter_serialno:tpad", 0,"45273147");
        System.out.println("tpad count="+xMemcachedClient.get("uic_counter_serialno:tpad"));

        //老板锁屏 appid=9
//        xMemcachedClient.set("uic_counter_serialno:bosslocker",0, "24405266");
        System.out.println("bosslocker count="+xMemcachedClient.get("uic_counter_serialno:bosslocker"));

        //天天锁屏  //天平账号 appid=1
        xMemcachedClient.set("uic_counter_serialno:fun", 0, "24405266");
        System.out.println("fun count="+xMemcachedClient.get("uic_counter_serialno:fun"));
    }
}
