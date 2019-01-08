package svndemo.test;

/**
 * Created by hongjian.chen on 2018/11/5.
 */
public enum  Season {
    SPRING("立春","春季的开始"),SUMMER("立夏","夏季的开始"),FALL("立秋","秋季的开始"),WINTER("立冬","冬季的开始");
    String name;
    String desc;
    Season(String name,String desc){
        this.name=name;
        this.desc=desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }
}
