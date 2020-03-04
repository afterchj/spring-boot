package com.example.demo.util;

import com.example.demo.service.Cooking;
import com.example.demo.service.CookingImpl;

/**
 * Created by after on 2020/2/17.
 */
public class ProxyDemo {
    public static void main(String[] args) {
        Cooking cooking=new CookingImpl();
        Cooking o= (Cooking) JDKProxyFactory.getProxy(cooking);
        o.cook();
    }
}
