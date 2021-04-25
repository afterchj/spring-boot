package com.example.demo.controller;

import com.example.demo.entity.Info;
import com.example.demo.service.InfoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * Created by hongjian.chen on 2018/6/26.
 */

@RequestMapping("/info")
@RestController
public class UserController {

    @Autowired
    private InfoService infoService;

    @GetMapping("/name/{userName}")
    public Info getInfo(@PathVariable("userName") String userName) {
        return infoService.findByUserName(userName);
    }

    @ApiOperation(value = "用户列表", notes = "用户列表")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Info> getInfos() {
        return infoService.findAll();
    }

    @ApiOperation(value = "创建用户", notes = "创建用户")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Info saveInfo(@RequestBody Info info) {
        return infoService.saveInfo(info);
    }


    @ApiOperation(value = "获取用户信息", notes = "根据url的id获取用户信息")
    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public Info getInfo(@PathVariable Long id) {
        return infoService.findById(id);
    }

    @ApiOperation(value = "更新信息", notes = "根据url的id更新用户信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Info updateInfo(@PathVariable long id, @RequestBody Info info) {
        Info info1 = new Info();
        info1.setId(id);
        info1.setUserName(info.getUserName());
        info1.setPassword(info.getPassword());
        return infoService.updateUser(info1);
    }

    @ApiOperation(value = "删除用户信息", notes = "根据url的id删除指定用户信息")
    @RequestMapping(value = "/id/{id}", method = RequestMethod.DELETE)
    public String deleteInfo(@PathVariable Long id) {
        infoService.deleteUser(id);
        return "success";
    }

    @ApiIgnore
    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String jsonTest() {
        return "hei men!";
    }
}
