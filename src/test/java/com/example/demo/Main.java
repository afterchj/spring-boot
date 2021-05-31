//package com.example.demo;
//
//import org.junit.Test;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//import java.io.File;
//
///**
// * Created by hongjian.chen on 2018/9/10.
// */
//public class Main {
//    public static void main(String[] args) {
//        BCryptPasswordEncoder econd = new BCryptPasswordEncoder();
//        String str=econd.encode("wyf");
//        System.out.println(str);
//    }
//
//    @Test
//    public void testPath(){
//        String path=Main.class.getResource("/").getPath();
//        File file=new File(path+"mapper"+File.separator+"UserMapper.xml");
//        System.out.println(path+"\t"+file.getName());
//    }
//
//}
