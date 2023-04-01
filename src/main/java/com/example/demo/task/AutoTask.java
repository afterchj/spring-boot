package com.example.demo.task;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Classname AutoTask
 * @Description TODO
 * @auth after
 * @since 2023/3/30 21:21
 */

@Data
@Slf4j
@Component
@ConfigurationProperties(prefix = "thread.pool")
public class AutoTask {

    /** 核心线程数 */
    private int corePoolSize;

    /** 最大线程数 */
    private String maxPoolSize;

    /** 工作队列容量 */
    private int queueCapacity;

    /** 线程池维护线程所允许的空闲时间 */
    private int keepAliveSeconds;

    @PostConstruct
    public void stat() {
        log.info("coreSize{},maxSize{},keepAlive{},queueCapacity{}", getCorePoolSize(), maxPoolSize, keepAliveSeconds, queueCapacity);

        System.out.println("threadName=" + Thread.currentThread().getName() + "...");
//        try {
//            businessContext.executeBusiness("order", "test", "is", "ok");
//        } catch (Exception e) {
//            log.error("测试异步任务异常:", e);
//        }
    }
}
