package com.example.blt.utils;

import com.example.blt.entity.HostInfo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 * Created by hongjian.chen on 2019/6/13.
 */
public class SpringUtil {

    private static ApplicationContext ctx;

    static {
        ctx = new ClassPathXmlApplicationContext("classpath:spring-hibernate.xml");
    }

    public static EntityManagerFactory getEntityManager() {
        return (EntityManagerFactory) ctx.getBean("entityManagerFactory");
    }

}
