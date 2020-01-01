package com.example.demo01.controller;

import com.example.demo01.pojo.JsonResult;
import com.example.demo01.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @program: demo01
 * @description: User控制器
 * @author: 张清
 * @create: 2019-12-27 18:15
 **/
//@Controller
@RestController //RestController = Controller + ResponseBody
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/getUser")
//    @ResponseBody
    public User hello(){
        User user = new User();
        user.setName("zq");
        user.setAge(18);
        user.setPassword("admin");
        user.setBirthday(new Date());
        return user;
    }
    @RequestMapping("/getUserJson")
//    @ResponseBody
    public JsonResult getUserJson(){
        User user = new User();
        user.setName("zq1");
        user.setAge(18);
        user.setPassword("admin1");
        user.setBirthday(new Date());
        return JsonResult.ok(user);
    }
}
