package svndemo.test;

import java.lang.reflect.Constructor;

/**
 * Created by after on 2018/12/19.
 */
public class CreateJFrame {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("javax.swing.JFrame");
        Constructor constructor = clazz.getConstructor(String.class);
        Object o = constructor.newInstance("测试窗口");
        System.out.println(o);
    }
}
