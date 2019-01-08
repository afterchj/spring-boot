package svndemo.test;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import svndemo.test.function.Dog;
import svndemo.test.function.Person;
import svndemo.test.function.impl.DogImpl;

import java.lang.reflect.Proxy;

/**
 * Created by after on 2018/12/9.
 */
public class ProxyTest {
    public static void main(String[] args) {

    }

    @Test
    public void testProxyInterface(){
        Person p = (Person) Proxy.newProxyInstance(ProxyTest.class.getClassLoader(),new Class[]{Person.class}, (proxy, method, args1) -> {
            System.out.println("正在调用的方法：" + method + "，传入的参数：" + JSON.toJSONString(args1));
            return null;
        });
        p.walk();
        p.sayHi("after");
    }

    @Test
    public void testProxyAop(){
        Dog target=new DogImpl();
        Dog proxyDog= (Dog) MyProxyFactory.getProxy(target);
        proxyDog.info();
        proxyDog.run();
    }
}
