package svndemo.test;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Map map=new HashMap();
        for (Season season:Season.values()){
            System.out.println(season.getName()+"代表"+season.getDesc());
            map.put(season.getName(),season.getDesc());
        }
        System.out.println(JSON.toJSONString(map));
        System.out.println("Hello World!");
    }
}
