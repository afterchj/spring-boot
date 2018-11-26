package com.tp.jcf.test;

import com.tp.jcf.DiConfig;
import com.tp.jcf.demo.TestBean;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

/**
 * Created by hongjian.chen on 2018/8/30.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DiConfig.class)
@ActiveProfiles("dev")
public class DemoBeanIntegrationTests {

    @Autowired
    private TestBean testBean;

    @Autowired
    private DiConfig diConfig;

    @Test
    public void prodBean() {
        String str = "from development profile";

        String actual = testBean.getContent();
        Assert.assertEquals(str, actual);
    }

    @Test
    public void testValue() throws IOException {
        diConfig.outputResource();
    }
}
