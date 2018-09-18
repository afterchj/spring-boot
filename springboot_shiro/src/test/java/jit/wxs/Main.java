package jit.wxs;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import java.util.Date;

/**
 * Created by hongjian.chen on 2018/9/18.
 */
public class Main {

    public static void main(String[] args) {
        int hashIterations = 2;//加密的次数
        ByteSource salt = ByteSource.Util.bytes("abc");//盐值
        String credentials = "123";//密码
        String hashAlgorithmName = "MD5";//加密方式
        String simpleHash = new SimpleHash(hashAlgorithmName, credentials, "abc", hashIterations).toHex();
        String newPs = new SimpleHash("MD5", credentials, salt, 2).toHex();
        System.out.println(newPs.equals(simpleHash)+"<-----加密后的值----->" + simpleHash);
    }

}
