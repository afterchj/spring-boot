package com.example.demo.util;

import java.lang.reflect.Proxy;

/**
 * Created by after on 2020/2/17.
 */
public class JDKProxyFactory {

    public static Object getProxy(Object target){
        Object proxy= Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),new MyInvocationHandle(target));
        return proxy;
    }
}
