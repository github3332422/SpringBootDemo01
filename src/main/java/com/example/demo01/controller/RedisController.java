package com.example.demo01.controller;

import com.example.demo01.pojo.JsonResult;
import com.example.demo01.pojo.User;
import com.example.demo01.utils.JsonUtils;

import com.example.demo01.utils.RedisOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: demo01
 * @description: redis数据库测试
 * @author: 张清
 * @create: 2019-12-28 21:44
 **/
@RestController
@RequestMapping("/redis")
public class RedisController {
    @Autowired
    private StringRedisTemplate strRedis;
    @Autowired
    private RedisOperator redis;

    @RequestMapping("/test")
    public JsonResult test(){
        strRedis.opsForValue().set("imooc-cache","Hello 慕课网");
        User user = new User();
        user.setName("zq");
        user.setAge(18);
        user.setPassword("admin");
        user.setBirthday(new Date());
        strRedis.opsForValue().set("json-user", JsonUtils.objectToJson(user));
        User user1 = JsonUtils.jsonToPojo(strRedis.opsForValue().get("json-user"), User.class);
        return JsonResult.ok(user1);
    }

    @RequestMapping("/getJsonList")
    public JsonResult getJsonList() {

        User user = new User();

        user.setName("慕课网");
        user.setPassword("123456");
        user.setBirthday(new Date());

        User u1 = new User();
        u1.setAge(19);
        u1.setName("imooc");
        u1.setPassword("123456");
        u1.setBirthday(new Date());

        User u2 = new User();
        u2.setAge(17);
        u2.setName("hello imooc");
        u2.setPassword("123456");
        u2.setBirthday(new Date());

        List<User> userList = new ArrayList<>();
        userList.add(user);
        userList.add(u1);
        userList.add(u2);

        redis.set("json:info:userlist", JsonUtils.objectToJson(userList), 2000);

        String userListJson = redis.get("json:info:userlist");
        List<User> userListBorn = JsonUtils.jsonToList(userListJson, User.class);

        return JsonResult.ok(userListBorn);
    }
}
