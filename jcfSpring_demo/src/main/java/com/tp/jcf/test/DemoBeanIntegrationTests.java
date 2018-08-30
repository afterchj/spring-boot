package com.tp.jcf.test;

import com.tp.jcf.TestConfig;
import com.tp.jcf.demo.TestBean;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by hongjian.chen on 2018/8/30.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
@ActiveProfiles("dev")
public class DemoBeanIntegrationTests {

    @Autowired
    private TestBean testBean;

    @Test
    public void prodBean(){
        String str="from development profile";

        String actual=testBean.getContent();
        Assert.assertEquals(str,actual);
    }
}
