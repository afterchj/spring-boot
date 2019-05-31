package com.example.blt.entity;


import java.io.Serializable;

/**
 * Created by hongjian.chen on 2019/5/31.
 */
public class HostInfo implements Serializable {

    private String id;
    private String ip;
    private boolean status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

//    @Override
//    public String toString() {
//        return "HostInfo{" + "id='" + id + '\'' + ", ip=" + ip + ", status=" + status+ '}';
//    }
//
//    public static void main(String[] args) {
//        HostInfo info=new HostInfo();
//        info.setStatus(true);
//        info.setId("123453");
//        info.setIp("127.0.0.1");
//        System.out.println(info.toString());
//    }
}
