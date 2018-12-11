package com.chj.tpadsz;

import com.chj.tpadsz.component.Msg;
import com.chj.tpadsz.convent.InnerMessageConverter;
import com.chj.tpadsz.convent.JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.core.JmsTemplate;

/**
 * Created by hongjian.chen on 2018/9/21.
 */

@SpringBootApplication
public class MyApplication implements CommandLineRunner {

    @Autowired
    private JmsTemplate template;


    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class,args);
    }



    @Override
    public void run(String... strings) throws Exception {
        System.out.println("jsmTemplate="+template);
        template.send("test-destination",new Msg());
    }
}
