package svndemo.test.function;

import java.util.concurrent.Callable;

/**
 * Created by after on 2018/12/9.
 */
public class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int i = 0;
        for (; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
        return i;
    }
}
