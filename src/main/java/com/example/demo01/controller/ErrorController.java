package com.example.demo01.controller;

import com.example.demo01.pojo.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: demo01
 * @description: 错误控制页面
 * @author: 张清
 * @create: 2019-12-28 20:37
 **/
@Controller
@RequestMapping("/err")
public class ErrorController {
    @RequestMapping("/error")
    public String error(){
        int a = 1 / 0;
        return "thymeleaf/error";
    }

    @RequestMapping("/ajaxerror")
    public String ajaxerror(){
        return "thymeleaf/ajaxerror";
    }

    @RequestMapping("/getAjaxerror")
    @ResponseBody
    public JsonResult getAjaxerror() {

        int a = 1 / 0;

        return JsonResult.ok();
    }
}
