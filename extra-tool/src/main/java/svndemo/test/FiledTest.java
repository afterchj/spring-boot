package svndemo.test;

import java.lang.reflect.Field;

/**
 * Created by after on 2018/12/19.
 */
public class FiledTest {
    public static void main(String[] args) throws Exception {
        Person p=new Person();
        Class<Person> clazz=Person.class;
        Field nameField=clazz.getDeclaredField("name");
        //设置通过反射访问该成员变量时取消访问权限检查
        nameField.setAccessible(true);
        nameField.set(p,"hongjian.chen");
        Field ageField=clazz.getDeclaredField("age");
        ageField.setAccessible(true);
        ageField.set(p,25);
        System.out.println(p);
    }
}
