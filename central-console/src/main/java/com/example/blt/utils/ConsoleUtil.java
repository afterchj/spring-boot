package com.example.blt.utils;

import com.alibaba.fastjson.JSON;
import com.example.blt.entity.HostInfo;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * Created by hongjian.chen on 2019/5/31.
 */
public class ConsoleUtil {

    private static Logger logger = LoggerFactory.getLogger(ConsoleUtil.class);

    public static void saveHosts(List<HostInfo> list) {
        list = list.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(HostInfo::getIp))), ArrayList::new));
        //Write Obj to File
        File file = new File("/temp/hosts/", "hosts");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(list);
        } catch (IOException e) {
            logger.error("IOException:" + e.getMessage());
        } finally {
            IOUtils.closeQuietly(oos);
        }
    }

    public static List getHosts() {
        File file = new File("/temp/hosts/", "hosts");
        //Read Obj from File
        ObjectInputStream ois = null;
        List<HostInfo> list = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(file));
            list = (List<HostInfo>) ois.readObject();
            logger.info("lists=" + JSON.toJSONString(list));
        } catch (IOException e) {
            logger.error("IOException:" + e.getMessage());
        } catch (ClassNotFoundException e) {
            logger.error("ClassNotFoundException:" + e.getMessage());
        } finally {
            IOUtils.closeQuietly(ois);
        }
        return list;
    }
}
