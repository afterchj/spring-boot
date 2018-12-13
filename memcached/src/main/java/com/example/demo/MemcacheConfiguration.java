package com.example.demo;

import com.whalin.MemCached.MemCachedClient;
import com.whalin.MemCached.SockIOPool;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.XMemcachedClient;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.command.BinaryCommandFactory;
import net.rubyeye.xmemcached.impl.KetamaMemcachedSessionLocator;
import net.rubyeye.xmemcached.utils.AddrUtil;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * Created by hongjian.chen on 2018/11/23.
 */

@Configuration
@ConfigurationProperties(prefix = "memcache")
public class MemcacheConfiguration {

    private String[] servers;
    private boolean failover;
    private int initConn;
    private int minConn;
    private int maxConn;
    private int maintSleep;
    private boolean nagel;

    private int socketTO;
    private boolean aliveCheck;

    public String[] getServers() {
        return servers;
    }

    public void setServers(String[] servers) {
        this.servers = servers;
    }

    public boolean isFailover() {
        return failover;
    }

    public void setFailover(boolean failover) {
        this.failover = failover;
    }

    public int getInitConn() {
        return initConn;
    }

    public void setInitConn(int initConn) {
        this.initConn = initConn;
    }

    public int getMinConn() {
        return minConn;
    }

    public void setMinConn(int minConn) {
        this.minConn = minConn;
    }

    public int getMaxConn() {
        return maxConn;
    }

    public void setMaxConn(int maxConn) {
        this.maxConn = maxConn;
    }

    public int getMaintSleep() {
        return maintSleep;
    }

    public void setMaintSleep(int maintSleep) {
        this.maintSleep = maintSleep;
    }

    public boolean isNagel() {
        return nagel;
    }

    public void setNagel(boolean nagel) {
        this.nagel = nagel;
    }

    public int getSocketTO() {
        return socketTO;
    }

    public void setSocketTO(int socketTO) {
        this.socketTO = socketTO;
    }

    public boolean isAliveCheck() {
        return aliveCheck;
    }

    public void setAliveCheck(boolean aliveCheck) {
        this.aliveCheck = aliveCheck;
    }

    @Bean
    public SockIOPool sockIOPool() {
        SockIOPool pool = SockIOPool.getInstance();
        pool.setServers(servers);
        pool.setFailover(failover);
        pool.setInitConn(initConn);
        pool.setMinConn(minConn);
        pool.setMaxConn(maxConn);
        pool.setMaintSleep(maintSleep);
        pool.setNagle(nagel);
        pool.setSocketTO(socketTO);
        pool.setAliveCheck(aliveCheck);
        pool.initialize();
        return pool;
    }

    @Bean
    public MemCachedClient memCachedClient() {
        return new MemCachedClient();
    }

    @Bean
    public XMemcachedClient xMemcachedClient() throws IOException {
        System.out.println("servers[0]"+servers[0]);
        XMemcachedClientBuilder builder = new XMemcachedClientBuilder(AddrUtil.getAddresses(servers[0]));
        XMemcachedClient xMemcachedClient = null;
        // 默认是采用余数哈希，可以修改为一致性哈希
        builder.setSessionLocator(new KetamaMemcachedSessionLocator());
        // 启用二进制协议，getAndTouch等方法仅在二进制协议中支持
        builder.setCommandFactory(new BinaryCommandFactory());

        // build the memcached client
        xMemcachedClient = (XMemcachedClient) builder.build();
        return xMemcachedClient;
    }

}
