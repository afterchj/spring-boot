package svndemo.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.io.File;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void test() {
        File file = new File("D:\\test\\", "temp.txt");
        boolean flag = true;
        System.out.println(!flag);
        System.out.println(file.isDirectory() + "\t" + file.getPath());
    }

}
