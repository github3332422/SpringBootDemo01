package com.example.demo01.controller;

import com.example.demo01.pojo.JsonResult;
import com.example.demo01.pojo.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: demo01
 * @description: ...
 * @author: 张清
 * @create: 2019-12-27 12:42
 **/
@RestController
//@RequestMapping("/ftl")
public class HelloController {

    @Autowired
    private Resource resource;

    /**
     * 返回字符串到页面
     * */
    @RequestMapping("/hello")
    public Object hello(){
        return "hello springboot ~";
    }

    /**
     * 获取配置文件中的信息
     * */
    @RequestMapping("/getResource")
    public JsonResult getResource(){
        Resource bean = new Resource();
        BeanUtils.copyProperties(resource,bean);
        return JsonResult.ok(bean);
    }


}
