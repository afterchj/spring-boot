package svndemo.test;

import java.lang.reflect.Proxy;

/**
 * Created by after on 2018/12/9.
 */
public class MyProxyFactory {
    public static Object getProxy(Object object) {
        MyInvocationHandler hander = new MyInvocationHandler();
        hander.setTarget(object);
        return Proxy.newProxyInstance(object.getClass().getClassLoader(),object.getClass().getInterfaces(), hander);
    }
}
