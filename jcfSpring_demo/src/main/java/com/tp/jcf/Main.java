package com.tp.jcf;

import com.tp.jcf.service.AsyncTaskService;
import com.tp.jcf.service.TestService;
import com.tp.jcf.service.UseFunctionService;
import org.junit.Test;
import org.springframework.beans.factory.config.PropertyResourceConfigurer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

/**
 * Created by hongjian.chen on 2018/8/27.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(DiConfig.class);
//        DiConfig resource = ctx.getBean(DiConfig.class);
//        resource.outputResource();
//        AsyncTaskService asyncTaskService = ctx.getBean(AsyncTaskService.class);
//        for (int i = 0; i < 10; i++) {
//            asyncTaskService.executeAsyncTask(i);
//            asyncTaskService.executeAsyncTaskPlus(i);
//        }
//        ctx.close();
    }

    @Test
    public void testDemo() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(DemoConfig.class);
        TestService testService = ctx.getBean(TestService.class);
        testService.outputResult();
        ctx.close();


    }
}
