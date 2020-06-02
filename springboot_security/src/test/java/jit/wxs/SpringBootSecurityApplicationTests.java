package jit.wxs;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootSecurityApplicationTests {


    @Test
    public void test() {
        for (int i = 0; i < 3; i++) {
            System.out.println(BCrypt.gensalt());
        }
    }
}
