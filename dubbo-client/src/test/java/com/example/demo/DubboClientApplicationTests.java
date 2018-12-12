package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.example.demo.service.dubbo.ConsumeService;
import com.example.demo.service.dubbo.DemoServiceConsume;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DubboClientApplicationTests {

	@Autowired
	ConsumeService consumeService;

	@Autowired
	DemoServiceConsume demoServiceConsume;

	@Test
	public void contextLoads() {
		System.out.println("test version="+ JSON.toJSONString(consumeService.test1()));
		System.out.println("test version="+ JSON.toJSONString(consumeService.test0()));
		System.out.println("test version="+JSON.toJSONString(consumeService.test2()));
	}
	@Test
	public void testDubbo() {
		System.out.println("test version="+demoServiceConsume.test1());
		System.out.println("test version="+demoServiceConsume.test2());
	}

}
