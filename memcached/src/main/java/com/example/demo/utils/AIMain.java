package com.example.demo.utils;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.command.BinaryCommandFactory;
import net.rubyeye.xmemcached.exception.MemcachedException;
import net.rubyeye.xmemcached.impl.KetamaMemcachedSessionLocator;
import net.rubyeye.xmemcached.utils.AddrUtil;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

/**
 * Created by hongjian.chen on 2018/11/23.
 */
public class AIMain {

    public static void initCmemcachedClient() throws IOException, InterruptedException, MemcachedException, TimeoutException {
        XMemcachedClientBuilder builder = new XMemcachedClientBuilder(AddrUtil.getAddresses("114.115.217.234:12000"));
        MemcachedClient memcachedClient = null;


        // 默认是采用余数哈希，可以修改为一致性哈希
        builder.setSessionLocator(new KetamaMemcachedSessionLocator());
        // 启用二进制协议，getAndTouch等方法仅在二进制协议中支持
        builder.setCommandFactory(new BinaryCommandFactory());

        // build the memcached client
        memcachedClient = builder.build();

        // set: 第一个参数是key，第二个参数是超时时间，第三个参数是value
        memcachedClient.set("first", 50, "tianjin");//添加或者更新
        memcachedClient.add("third", 50, "苏州");//添加,key不存在添加成功返回true,否则返回false
        System.out.println("third=" + memcachedClient.get("third"));
        memcachedClient.replace("third", 50, "上海");//替换,key已经存在替换成功返回true,不存在返回false
        System.out.println("third=" + memcachedClient.get("third"));
        System.out.println("first=" + memcachedClient.get("first"));
        new Thread().sleep(5000);
        // get：根据key获取value
        System.out.println("first=" + memcachedClient.get("first"));
        System.out.println("third=" + memcachedClient.get("third"));
    }
/**
 * AI核心代码，估值一个亿
 */
    public static void AICoreCode() {
        Scanner sc = new Scanner(System.in);
        String str;
        do {
            str = sc.next();
            str = str.replace("吗", "");
            str = str.replace("?", "!");
            str = str.replace("？", "！");
            System.out.println(str);
        } while (!str.equals("bye"));
    }

    public static void main(String[] args) throws Exception {
        AICoreCode();
    }
}
