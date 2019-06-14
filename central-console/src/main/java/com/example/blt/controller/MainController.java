package com.example.blt.controller;

import com.alibaba.fastjson.JSON;
import com.example.blt.entity.ConsoleInfo;
import com.example.blt.netty.ClientMain;
import com.example.blt.task.ControlTask;
import com.example.blt.utils.SocketUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hongjian.chen on 2019/5/17.
 */

@RestController
public class MainController {
    private Logger logger = LoggerFactory.getLogger(MainController.class);
    private ClientMain clientMain = new ClientMain();

    @RequestMapping("/test")
    public String console(String cmd) {
        SocketUtil.sendCmd(cmd);
        return "ok";
    }

    @RequestMapping("/switch")
    public String console(ConsoleInfo consoleInfo) {
        String info = JSON.toJSONString(consoleInfo);
        ControlTask task = new ControlTask(clientMain, info, true);
        String result = task.executeTask();
        return result;
    }

    @RequestMapping(value = "/sendSocket", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> sendSocket(String host, String command) {
        Map<String, String> map = new HashMap<>();
        String success = "success";
        if ("开".equals(command)) {
            command = "1";
        } else if ("关".equals(command)) {
            command = "2";
        }
        String cmd = host + ":" + command;
        logger.info("cmd=" + command);
        String code = SocketUtil.sendCmd2(host, cmd);
        if ("1".equals(code)) {
//            失败
            success = "error";
        }
        map.put("success", success);
        return map;
    }

    @RequestMapping(value = "/sendSocket2", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> sendSocket2(String host1, String host2, String command) {
        Map<String, String> map = new HashMap<>();
        String success1 = "success";
        String success2 = "success";
        if ("开".equals(command)) {
            command = "1";
        } else if ("关".equals(command)) {
            command = "2";
        }
        logger.info("cmd=" + command);
        String cmd1 = host1 + ":" + command;
        String cmd2 = host2 + ":" + command;
        String code1 = SocketUtil.sendCmd2(host1, cmd1);
        String code2 = SocketUtil.sendCmd2(host2, cmd2);
        if ("1".equals(code1)) {
//            失败
            success1 = "error";
        }
        if ("1".equals(code2)) {
//            失败
            success2 = "error";
        }
        map.put("success1", success1);
        map.put("success2", success2);
        return map;
    }

    @RequestMapping(value = "/sendSocket3", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> sendSocket3(String host, String command) {
        Map<String, String> map = new HashMap<>();
        String success = "success";
        String cmd = host + ":" + command;
        logger.info("cmd=" + command);
        String code = SocketUtil.sendCmd2(host, cmd);
        if ("1".equals(code)) {
//            失败
            success = "error";
        }
        map.put("success", success);
        return map;
    }

    @RequestMapping(value = "/sendSocket4", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> sendSocket4(String host, String command) {
        Map<String, String> map = new HashMap<>();
        String success = "success";
        String host1 = "192.168.1.4";//茶室
        String host2 = "192.168.1.5";//活动室
        String host3 = "192.168.1.6";//客餐厅
        String host4 = "192.168.1.7";//洽谈室
        String host5 = "192.168.1.8";//办公大厅
        if (command.equalsIgnoreCase("ON")) {
            //开
            command = "77010315373766";
        } else if (command.equalsIgnoreCase("OFF")) {
            //关
            command = "77010315323266";
        }
        if (host.equals("all")) {
            //向所有地址发信息
            String cmd1 = host1 + ":" + command;
            String cmd2 = host2 + ":" + command;
            String cmd3 = host3 + ":" + command;
            String cmd4 = host4 + ":" + command;
            String cmd5 = host5 + ":" + command;
            String code1 = SocketUtil.sendCmd2(host1, cmd1);
            String code2 = SocketUtil.sendCmd2(host2, cmd2);
            String code3 = SocketUtil.sendCmd2(host3, cmd3);
            String code4 = SocketUtil.sendCmd2(host4, cmd4);
            String code5 = SocketUtil.sendCmd2(host5, cmd5);
            if ("1".equals(code1) || "1".equals(code2) || "1".equals(code3) || "1".equals(code4) || "1".equals(code5)) {
                //            失败
                success = "error";
            }
        } else {
            String cmd = host + ":" + command;
            String code = SocketUtil.sendCmd2(host, cmd);
            if ("1".equals(code)) {
                success = "error";
            }
        }
        map.put("success", success);
        return map;
    }

    @RequestMapping(value = "/sendSocket5", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> sendSocket5(String host, String command) {
        Map<String, String> map = new HashMap<>();
        String success = "success";
        if (command.equals("场景一")) {
            command = "7701021901";
        } else if (command.equals("场景二")) {
            command = "7701021902";
        } else if (command.equals("场景三")) {
            command = "7701021903";
        } else if (command.equals("场景四")) {
            command = "7701021904";
        } else if (command.equals("场景五")) {
            command = "7701021905";
        } else if (command.equals("场景六")) {
            command = "7701021906";
        } else if (command.equals("场景七")) {
            command = "7701021907";
        } else if (command.equals("场景八")) {
            command = "7701021908";
        }
        String cmd = host + ":" + command;
        SocketUtil.sendCmd2(host, cmd);
        map.put("success", success);
        return map;
    }


}
