package com.example.demo.util;

import com.example.demo.service.Cooking;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by after on 2020/2/17.
 */
public class MyInvocationHandle implements InvocationHandler {

    private Object target;

    public MyInvocationHandle(Object target) {
        this.target = target;
    }

    public void before(){
        System.out.println("洗菜ing");
    }

    public void after(){
        System.out.println("刷碗ing");
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        method.invoke(target,args);
        after();
        return proxy;
    }
}
