package com.example.demo;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DubboClientApplicationTests {

//    @Autowired
//    ConsumeService consumeService;
//
//    @Autowired
//    DemoServiceConsume demoServiceConsume;

//    @Autowired
//    MsgServiceConsume sendService;

    @Test
    public void contextLoads() {
        System.out.println("test version=" + JSON.parseArray("[556677]"));
    }
//
//    @Test
//    public void testDubbo() {
//        System.out.println("test version=" + JSON.toJSONString(demoServiceConsume.test0()));
//        System.out.println("test version=" + demoServiceConsume.test1());
//        System.out.println("test version=" + demoServiceConsume.test2());
//    }

//        @Test
//        public void testMsg () throws Exception {
//            try {
//                String code = sendService.updateCheckOut("12", "18170756879");
//                System.out.println("code=" + code);
//                String code = sendService.updateCheckOut("9", "18550791817");
//                System.out.println("code=" + code);
//                String value = sendService.checkValidation("123456", "18550791817");
//                System.out.println("value=" + value);
//
//            } catch (InvalidCodeException e) {
//                e.printStackTrace();
//            }
//        }
//    }
}
