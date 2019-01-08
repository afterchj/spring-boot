package svndemo.test;


import svndemo.test.function.Anno;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created by after on 2018/12/19.
 */

@SuppressWarnings("unchecked")
@Deprecated
@Anno
@Anno
public class AnnoTest {
    public AnnoTest() {

    }

    private void privateMethod() {
        System.out.println("通过反射执行无参数的私有方法");
    }

    private void privateMethod(String str) {
        System.out.println("通过反射执行有参数的私有方法，str=" + str);
    }

    public AnnoTest(String name) {

        System.out.println("执行有参数构造函数！");
    }

    public void info() {
        System.out.println("执行无惨数的info方法");
    }

    public void info(String str) {
        System.out.println("执行有惨数的info方法，str=" + str);
    }

    class inner {

    }

    public static void main(String[] args) throws Exception {
        Class<AnnoTest> clazz = AnnoTest.class;
        AnnoTest annoTest=clazz.newInstance();

        Constructor[] constructors = clazz.getDeclaredConstructors();
        System.out.println("类的全部构造函数如下：");
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
        Method[] methods = clazz.getMethods();
        System.out.println("类的全部public方法数如下：");
        for (Method m : methods) {
            System.out.println(m);
        }
        Method method = clazz.getDeclaredMethod("privateMethod", String.class);
        method.invoke(annoTest, "Test is ok!");
        Annotation[] annotations = clazz.getAnnotations();
        System.out.println("类的全部annotation数如下：");
        for (Annotation anno : annotations) {
            System.out.println(anno);
        }
        System.out.println("类的名称：" + clazz.getName());
        System.out.println("类的简称：" + clazz.getSimpleName());

        Class[] inClass=clazz.getDeclaredClasses();
        System.out.println("类的全部内部类n数如下：");
        for (Class c:inClass){
            System.out.println(c);
        }
        Class inClazz=Class.forName("svndemo.test.AnnoTest$inner");
        System.out.println("inClazz对应的内部类为："+inClazz.getDeclaringClass());
        System.out.println("AnnoTest对应的包为："+clazz.getPackage());
        System.out.println("inClazz对应的父类为："+clazz.getSuperclass());
    }
}
