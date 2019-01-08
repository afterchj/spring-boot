package svndemo.test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by after on 2018/12/19.
 */
public class ObjectPoolFactory {

    private Map<String, Object> objectPool = new HashMap<>();

    public Object createObject(String clazzName) throws Exception {
        Class<?> clazz = Class.forName(clazzName);
        return clazz.newInstance();
    }

    public void initPool(InputStream fis) throws Exception {
        Properties pros = new Properties();
        pros.load(fis);
        for (String name : pros.stringPropertyNames()) {
            objectPool.put(name, createObject(pros.getProperty(name)));
        }
    }

    public Object getObject(String name) {
        return objectPool.get(name);
    }

    public static void main(String[] args) throws Exception {
        ObjectPoolFactory factory = new ObjectPoolFactory();
        InputStream fis= factory.getClass().getResourceAsStream("/obj.txt");
        factory.initPool(fis);
        System.out.println(factory.getObject("a"));
        System.out.println(factory.getObject("b"));
    }
}
