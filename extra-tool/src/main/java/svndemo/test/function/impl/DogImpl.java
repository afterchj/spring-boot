package svndemo.test.function.impl;

import svndemo.test.function.Dog;

/**
 * Created by after on 2018/12/9.
 */
public class DogImpl implements Dog {
    @Override
    public void info() {
        System.out.println("I am a dog.");
    }

    @Override
    public void run() {
        System.out.println("I can run fast very much!");
    }
}
