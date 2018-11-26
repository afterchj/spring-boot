package com.tp.jcf;

import com.tp.jcf.service.FunctionService;
import com.tp.jcf.service.UseFunctionService;
import org.apache.commons.io.IOUtils;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.io.IOException;
import java.util.concurrent.Executor;


/**
 * Created by hongjian.chen on 2018/8/27.
 */

@Configuration
@EnableAsync
@EnableScheduling
@ComponentScan("com.tp.jcf")
@PropertySource("classpath:test.properties")
public class DiConfig implements AsyncConfigurer{

    @Value("normal value")
    private String normal;

    @Value("#{systemProperties['os.name']}")
    private String osName;

    @Value("#{ T(java.lang.Math).random()*100+1}")
    private int randomNum;

    @Value("#{demoSerivce.another}")
    private String fromAnother;

    @Value("classpath:test.txt")
    private Resource testFile;

    @Value("http://baidu.com")
    private Resource testUrl;

    @Value("${book.name}")
    private String bookName;

    @Autowired
    private Environment environment;

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    public void outputResource() throws IOException {
        System.out.println(normal);
        System.out.println(osName);
        System.out.println(IOUtils.toString(testUrl.getInputStream()));
        System.out.println("testFile----->"+testFile.getDescription());
        System.out.println("bookName="+bookName);
        System.out.println("book.author="+environment.getProperty("book.author"));
    }

    @Bean
    public FunctionService functionService() {
        return new FunctionService();
    }

    @Bean
    public UseFunctionService useFunctionService() {
        return new UseFunctionService();
    }

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor=new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(10);
        executor.setQueueCapacity(25);
        executor.initialize();
        return executor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return null;
    }
}
