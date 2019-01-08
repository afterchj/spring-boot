package svndemo.test;

import com.alibaba.druid.support.json.JSONUtils;
import org.junit.Test;
import svndemo.test.function.MyCallable;
import svndemo.test.function.YouTest;


import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by after on 2018/5/15.
 */
public class TestUtil {
    @Test
    public void test1() {
        List<Map<String, Object>> listItems = createList();
        for (int i = 0; i < listItems.size(); i++) {
            String jsonStr = JSONUtils.toJSONString(listItems.get(i));
            System.out.println(jsonStr);
        }
    }

    public static List<Map<String, Object>> createList() {
        int[] imageIds = new int[]{5, 6, 7, 8, 9, 10};
        List<Map<String, Object>> listItems = new ArrayList<>();
        for (int i = 0; i < imageIds.length; i++) {
            Map<String, Object> listItem = new HashMap<>();
            listItem.put("image", imageIds[i]);
            listItems.add(listItem);
            System.out.println(listItem.size());
        }
        return listItems;
    }

    @Test
    public void test2(){
        YouTest youTest=a->new JFrame(a);
        System.out.println(youTest.win("new window"));
        YouTest yt=JFrame::new;
        System.out.println(yt.win("new window"));

    }

    @Test
    public void test3(){
        FutureTask<Integer> task=new FutureTask<Integer>(new MyCallable());
        for (int i=0;i<100;i++){
            System.out.println(Thread.currentThread().getName() + ":" + i);
            if (i==20){
                new Thread(task,"myCallable").start();
            }
        }
        try {
            System.out.println("result="+task.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        System.out.println("Hello Subversion!");
    }
}
