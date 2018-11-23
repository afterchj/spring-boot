package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.example.demo.entity.Person;
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

    @Test
    public void contextLoads() throws InterruptedException {
        // 放入缓存
        boolean flag = memCachedClient.add("testKey", "testValue");
        System.out.println("flag=" + flag);

        // 取出缓存
        Object a = memCachedClient.get("testKey");
        System.out.println("a=" + a);


        // 3s后过期
        memCachedClient.set("b", "2", new Date(3000));
        Object b = memCachedClient.get("b");
        System.out.println(b);

        Thread.sleep(3000);
        b = memCachedClient.get("b");
        System.out.println("a=" + a);
        System.out.println("b=" + b);
    }


    @Test
    public void testXmemcached() throws InterruptedException, MemcachedException, TimeoutException {
        List <Person> list = new ArrayList <>();
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
//        xMemcachedClient.set("person1", 24 * 60 * 60, person);
        xMemcachedClient.set("people", 24 * 60 * 60, list);
        List <Person> people = xMemcachedClient.get("people");
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

}
