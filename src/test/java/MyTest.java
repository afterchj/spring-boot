import org.junit.Test;

import java.util.Random;

/**
 * Created by hongjian.chen on 2018/8/24.
 */
public class MyTest {

    @Test
    public void test() {


        Random random = new Random();

        for (int i = 0; i < 1000; i++) {
            int s = random.nextInt(100) + 3;
            if (s < 4 || s > 100) {
                System.out.println("current number is:" + s);
            }
        }
    }
}
