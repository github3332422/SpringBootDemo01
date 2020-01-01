package com.example.demo01.exception;

import com.example.demo01.pojo.JsonResult;
import org.springframework.web.bind.annotation.ControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: demo01
 * @description: ajax异常处理
 * @author: 张清
 * @create: 2019-12-28 20:54
 **/
//@ControllerAdvice
public class AjaxExceptionHandler {
//    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
    public JsonResult defaultErrorHandler(HttpServletRequest request,
                                          Exception e)throws Exception{
        e.printStackTrace();
        return JsonResult.errorException(e.getMessage());
    }
}
