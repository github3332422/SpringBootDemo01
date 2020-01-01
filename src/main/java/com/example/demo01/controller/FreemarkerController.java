package com.example.demo01.controller;

import com.example.demo01.pojo.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: demo01
 * @description: .
 * @author: 张清
 * @create: 2019-12-28 10:39
 **/
@Controller
@RequestMapping("/fm")
public class FreemarkerController {
    @Autowired
    private Resource resource;

    @RequestMapping("/index")
    public String index(ModelMap map){
        map.addAttribute("resource",resource);
        return "fmdemo/index";
    }

    @RequestMapping("/center")
    public String center(){
        return "fmdemo/center/center";
    }
}

