package com.example.blt;

import com.alibaba.fastjson.JSON;
import com.example.blt.entity.HostInfo;
import com.example.blt.utils.ConsoleUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * Created by hongjian.chen on 2019/5/31.
 */
public class MainTest {

    @Test
    public void testStream() throws Exception {
        String str = "[{\"id\":\"684fd6ef\",\"ip\":\"127.0.0.1\",\"status\":true},{\"id\":\"9280ead5\",\"ip\":\"192.168.1.51.75\",\"status\":true},{\"id\":\"9280ead5\",\"ip\":\"127.0.0.1\",\"status\":true},{\"id\":\"f670f820\",\"ip\":\"127.0.0.1\",\"status\":true},{\"id\":\"f670f820\",\"ip\":\"192.168.51.90\",\"status\":true},{\"id\":\"f670f820\",\"ip\":\"192.168.51.95\",\"status\":true},{\"id\":\"c48e50ec\",\"ip\":\"127.0.0.1\",\"status\":true},{\"id\":\"c48e50ec\",\"ip\":\"127.0.0.1\",\"status\":true},{\"id\":\"c48e50ec\",\"ip\":\"127.0.0.1\",\"status\":true},{\"id\":\"c48e50ec\",\"ip\":\"127.0.0.1\",\"status\":true},{\"id\":\"c48e50ec\",\"ip\":\"127.0.0.1\",\"status\":true},{\"id\":\"dcc4a1d8\",\"ip\":\"127.0.0.1\",\"status\":true},{\"id\":\"dcc4a1d8\",\"ip\":\"127.0.0.1\",\"status\":true},{\"id\":\"dcc4a1d8\",\"ip\":\"127.0.0.1\",\"status\":true},{\"id\":\"dcc4a1d8\",\"ip\":\"127.0.0.1\",\"status\":true},{\"id\":\"dcc4a1d8\",\"ip\":\"127.0.0.1\",\"status\":true},{\"id\":\"c0da419d\",\"ip\":\"127.0.0.1\",\"status\":true},{\"id\":\"c0da419d\",\"ip\":\"127.0.0.1\",\"status\":true},{\"id\":\"c0da419d\",\"ip\":\"127.0.0.1\",\"status\":true},{\"id\":\"c0da419d\",\"ip\":\"127.0.0.1\",\"status\":true}]";
//        List<HostInfo> infoList = JSON.parseArray(str, HostInfo.class);
        List<HostInfo> infoList= ConsoleUtil.getHosts();
        System.out.println("去重之前：" + infoList.size());
//        infoList = infoList.stream().filter(o -> !o.getIp().equals("127.0.0.1")).collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(HostInfo::getIp))), ArrayList::new));
        infoList = infoList.stream().filter(o -> !o.getIp().equals("127.0.0.1")).collect(Collectors.toList());
        System.out.println("去重之后：" + infoList.size());
        System.out.println("hosts：" + JSON.toJSONString(infoList));
    }
}
