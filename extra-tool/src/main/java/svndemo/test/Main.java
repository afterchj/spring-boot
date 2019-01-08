package svndemo.test;

import svndemo.test.function.MyTest;

/**
 * Created by after on 2018/12/9.
 */
public class Main {
    public static void main(String[] args) {
        MyTest mt=(a,b,c)->a.substring(b,c);
        System.out.println(mt.test("I am chj",2,6));
        MyTest mt1=String::substring;
        System.out.println(mt1.test("Hello world",6,11));
    }
}
