package com.example.blt.utils;

import com.alibaba.fastjson.JSON;

/**
 * Created by after on 2019/6/14.
 */
public class StrUtil {

    public static void buildLightInfo(String str) {
        String msg = str.replace(" ", "").toLowerCase();
        String prefix = msg.substring(0, 8);
        String lmac = msg.substring(8, 20);
        String vaddr = msg.substring(20, 28);
        String productId = msg.substring(28, 32);
        System.out.println(prefix + "\t" + lmac + "\t" + vaddr + "\t" + productId);
        String[] strArr = buildStr(lmac);
        StringBuffer sortMac = new StringBuffer();
        for (int i = strArr.length-1; i >= 0; i--) {
            if (i!=0){
                sortMac.append(strArr[i] + ":");
            }else {
                sortMac.append(strArr[i]);
            }
        }
        System.out.println(JSON.toJSONString(strArr)+"<-sortMac->" + sortMac.toString());
    }


    public static void main(String args[]) {
        String str = "77 04 0F 01 A9 10 64 D7 AC F0 7D 00 00 00 44 4F 03 0A CC CC ";
        buildLightInfo(str);
    }

    public static String[] buildStr(String str ){
        char[] chars = str.toCharArray();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            if (i < chars.length - 1) {
                if (i % 2 != 0) {
                    buffer.append(chars[i] + ":");
                } else {
                    buffer.append(chars[i]);
                }
            } else {
                buffer.append(chars[i]);
            }
        }
       return buffer.toString().split(":");
    }
}
