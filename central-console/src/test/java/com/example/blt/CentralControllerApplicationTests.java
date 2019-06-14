package com.example.blt;

import com.example.blt.dao.ConsoleDao;
import com.example.blt.dao.LightDao;
import com.example.blt.entity.HostInfo;
import com.example.blt.entity.LightInfo;
import com.example.blt.utils.SpringUtil;
import com.example.blt.utils.StrUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CentralControllerApplicationTests {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ConsoleDao consoleDao;

    @Autowired
    private LightDao lightDao;

    @Test
    public void contextLoads() {
        HostInfo host = new HostInfo();
        host.setStatus(true);
        host.setIp("192.168.56.1");
        host.setCreate_date(new Date());
        host.setLog_date(new Date());
        HostInfo result = consoleDao.saveAndFlush(host);
        HostInfo s = consoleDao.getByIp("192.168.56.1");
        logger.warn("id=" + result.getId());
        consoleDao.delete(s);
    }

    @Test
    public void saveLight() {
        String str = "77 04 0F 01 A9 10 64 D7 AC F0 7D 00 00 00 44 4F 03 0A CC CC ";
        String str1 = "77 04 0F 01 F1 10 64 D7 AC F0 3D 00 00 00 44 4F 03 0A CC CC ";
        String str2 = "77 04 0F 01 A8 10 64 D7 AC F0 0D 00 00 00 44 4F 03 0A CC CC ";
        for (int i = 0; i < 3; i++) {
            LightInfo lightInfo;
            if (i == 0) {
                lightInfo = StrUtil.buildLightInfo(str);
            } else if (i==1){
                lightInfo = StrUtil.buildLightInfo(str1);
            }else {
                lightInfo = StrUtil.buildLightInfo(str2);
            }
            lightDao.save(lightInfo);
        }
    }

    @Test
    public void testLight(){
        LightInfo info=lightDao.getByVaddr("7d000000");
        logger.info("lmac="+info.getLmac());
    }
}
