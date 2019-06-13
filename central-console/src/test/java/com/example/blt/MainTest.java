package com.example.blt;

import com.alibaba.fastjson.JSON;
import com.example.blt.entity.HostInfo;
import com.example.blt.utils.ConsoleUtil;
import com.example.blt.utils.SpringUtil;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by hongjian.chen on 2019/5/31.
 */
public class MainTest {

    public static void main(String[] args) {
        String str = "[{\"id\":\"684fd6ef\",\"ip\":\"127.0.0.1\",\"status\":true},{\"id\":\"9280ead5\",\"ip\":\"192.168.1.51.75\",\"status\":true},{\"id\":\"9280ead5\",\"ip\":\"127.0.0.1\",\"status\":true},{\"id\":\"f670f820\",\"ip\":\"127.0.0.1\",\"status\":true},{\"id\":\"f670f820\",\"ip\":\"192.168.51.90\",\"status\":true},{\"id\":\"f670f820\",\"ip\":\"192.168.51.95\",\"status\":true},{\"id\":\"c48e50ec\",\"ip\":\"127.0.0.1\",\"status\":true},{\"id\":\"c48e50ec\",\"ip\":\"127.0.0.1\",\"status\":true},{\"id\":\"c48e50ec\",\"ip\":\"127.0.0.1\",\"status\":true},{\"id\":\"c48e50ec\",\"ip\":\"127.0.0.1\",\"status\":true},{\"id\":\"c48e50ec\",\"ip\":\"127.0.0.1\",\"status\":true},{\"id\":\"dcc4a1d8\",\"ip\":\"127.0.0.1\",\"status\":true},{\"id\":\"dcc4a1d8\",\"ip\":\"127.0.0.1\",\"status\":true},{\"id\":\"dcc4a1d8\",\"ip\":\"127.0.0.1\",\"status\":true},{\"id\":\"dcc4a1d8\",\"ip\":\"127.0.0.1\",\"status\":true},{\"id\":\"dcc4a1d8\",\"ip\":\"127.0.0.1\",\"status\":true},{\"id\":\"c0da419d\",\"ip\":\"127.0.0.1\",\"status\":true},{\"id\":\"c0da419d\",\"ip\":\"127.0.0.1\",\"status\":true},{\"id\":\"c0da419d\",\"ip\":\"127.0.0.1\",\"status\":true},{\"id\":\"c0da419d\",\"ip\":\"127.0.0.1\",\"status\":true}]";
//        List<HostInfo> infoList = JSON.parseArray(str, HostInfo.class);
        List<HostInfo> infoList = ConsoleUtil.getHosts();
        System.out.println("去重之前：" + infoList.size());
//        infoList = infoList.stream().filter(o -> !o.getIp().equals("127.0.0.1")).collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(HostInfo::getIp))), ArrayList::new));
        infoList = infoList.stream().filter(o -> !o.getIp().equals("127.0.0.1")).collect(Collectors.toList());
        System.out.println("去重之后：" + infoList.size());
        System.out.println("hosts：" + JSON.toJSONString(infoList));
    }

    @Test
    public void testHibernate(){
        EntityManager em = SpringUtil.getEntityManager().createEntityManager();
        HostInfo host = new HostInfo();
        host.setStatus(true);
        host.setIp("192.168.16.1");
        host.setCreate_date(new Date());
        host.setLog_date(new Date());
        em.persist(host);
//        try {
//            Query query = em.createNativeQuery("select * from host_info as p where p.ip = ?1",HostInfo.class);
//            query.setParameter(1, host.getIp());
//            HostInfo info = (HostInfo) query.getSingleResult();
//            System.out.println("id="+info.getId());
//        } finally {
//            if (em != null) {
//                em.close();
//            }
//        }
    }
}
