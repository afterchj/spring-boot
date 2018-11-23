package com.example.demo;

import com.example.demo.entity.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisApplicationTests {


    @Autowired
    private RedisTemplate <String, Object> redisTemplate;

    @Test
    public void set() {
//		redisTemplate.opsForValue().set("mykey","test is ok");
        redisTemplate.opsForValue().set("mykey","Test is ok!" ,10, TimeUnit.SECONDS);
        System.out.println(redisTemplate.opsForValue().get("mykey"));
        try {
            new Thread().sleep(10000);
            System.out.println(redisTemplate.opsForValue().get("mykey"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testObject() {
        Person person = new Person();
        person.setName("after");
        person.setAddress("苏州");
        person.setAge(24);
        redisTemplate.opsForValue().set("person1", person,10,TimeUnit.SECONDS);
        Person p1 = (Person) redisTemplate.opsForValue().get("person1");
        Person p2 = (Person) redisTemplate.opsForValue().get("person2");
        System.out.println("result=" + p1.toJsonString());
//        redisTemplate.expire("person1", 10, TimeUnit.SECONDS);
        try {
            new Thread().sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("p1=" + redisTemplate.opsForValue().get("person1"));
        System.out.println("p2=" + p2.toJsonString());
    }

    @Test
    public void testHash(){

        Map<String,String> map=new HashMap();
        map.put("key1","aaa");
        map.put("key2","bbb");
        map.put("key3","ccc");
        Map<String,String> map1=new HashMap();
        map1.put("key4","111");
        map1.put("key5","222");
        map1.put("key6","333");
        List list=new ArrayList();
        for (String key:map1.keySet()){
            list.add(key);
        }
        redisTemplate.opsForHash().putAll("hashKey1",map1);
        System.out.println(redisTemplate.opsForHash().multiGet("hashKey1",list));

    }
}
