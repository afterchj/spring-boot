import com.tp.jcf.demo.MultiModuleDemo;
import org.junit.Test;

/**
 * Created by hongjian.chen on 2018/8/27.
 */
public class MutilModuleTest {

    @Test
    public void test() {
        MultiModuleDemo multiModuleDemo = new MultiModuleDemo();
        System.out.println(multiModuleDemo.moduleInfo());
    }
}
