import com.alibaba.fastjson.JSON;

import com.tp.demo.config.DBConfig;
import com.tp.demo.config.SpringConfig;
import com.tp.demo.model.Person;
import com.tp.demo.model.Pid;
import net.rubyeye.xmemcached.XMemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by hongjian.chen on 2018/11/26.
 */

@ContextConfiguration(classes = {SpringConfig.class, DBConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class ConfigurationTest {

    @Autowired
    private XMemcachedClient xMemcachedClient;

    @Autowired
    private RedisTemplate <String, Object> redisTemplate;

    @Autowired
    private SqlSessionTemplate sessionTemplate;

    @Test
    public void testSql() {
        List <Pid> list = sessionTemplate.selectList("tbk.getPids");
        System.out.println(list.size());
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
//        xMemcachedClient.set("people", 24 * 60 * 60, list);
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

        Thread.sleep(5000);
        System.out.println("first========================" + xMemcachedClient.get("first"));
        System.out.println("second=======================" + xMemcachedClient.get("second"));
    }

    @Test
    public void set() {
//		redisTemplate.opsForValue().set("mykey","test is ok");
        redisTemplate.opsForValue().set("mykey", "Test is ok!", 10, TimeUnit.SECONDS);
        System.out.println(redisTemplate.opsForValue().get("mykey"));
        try {
            new Thread().sleep(10000);
            System.out.println(redisTemplate.opsForValue().get("mykey"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testObject() throws InterruptedException {
        Person person = new Person();
        person.setName("after");
        person.setAddress("苏州");
        person.setAge(24);
        Person person2 = new Person();
        person2.setName("test");
        person2.setAddress("苏州");
        person2.setAge(23);
        redisTemplate.opsForValue().set("person1", person, 10, TimeUnit.SECONDS);
//        redisTemplate.opsForValue().set("person2", person2);
        Person p1 = (Person) redisTemplate.opsForValue().get("person1");
        Person p2 = (Person) redisTemplate.opsForValue().get("person2");
        System.out.println("p2=" + p2.toJsonString());
        System.out.println("p1=" + p1.toJsonString());

//        System.out.println( redisTemplate.expire("person1", 10, TimeUnit.SECONDS));
        System.out.println("-----------------分隔线-----------------");
        new Thread().sleep(10000);
        System.out.println("p2=" + redisTemplate.opsForValue().get("person2"));
        System.out.println("p1=" + redisTemplate.opsForValue().get("person1"));
    }

    @Test
    public void testHash() {
        Person person = new Person();
        person.setName("after");
        person.setAddress("苏州");
        person.setAge(24);
        Person person1 = new Person();
        person1.setName("admin");
        person1.setAddress("苏州");
        person1.setAge(25);
        Person person2 = new Person();
        person2.setName("test");
        person2.setAddress("苏州");
        person2.setAge(23);
        Map <String, Person> people = new HashMap();
        people.put("key1", person);
        people.put("key2", person1);
        people.put("key3", person2);


        Map <String, String> map = new HashMap();
        map.put("key1", "aaa");
        map.put("key2", "bbb");
        map.put("key3", "ccc");
        Map <String, String> map1 = new HashMap();
        map1.put("key4", "111");
        map1.put("key5", "222");
        map1.put("key6", "333");

        List list = new ArrayList();
        for (String key : people.keySet()) {
            list.add(key);
        }
//        redisTemplate.opsForHash().putAll("peopleHash", people);
        System.out.println(JSON.toJSONString(redisTemplate.opsForHash().multiGet("peopleHash", list)));

    }
}
