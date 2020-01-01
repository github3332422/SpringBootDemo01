package com.example.demo01.exception;

import com.example.demo01.pojo.JsonResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
/**
 * @program: demo01
 * @description: 异常处理类
 * @author: 张清
 * @create: 2019-12-28 20:41
 **/
// 抛出异常时会被这个类捕获
@ControllerAdvice
public class AllExceptionHandler {
    public static final String ERROR_VIEW = "error";

//    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
//    public Object errorHandler(HttpServletRequest request,
//                HttpServletResponse response,Exception e) throws  Exception{
//        e.printStackTrace();
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("exception",e);
//        mav.addObject("url",request.getRequestURL());
//        mav.setViewName(ERROR_VIEW);
//        return mav;
//    }
    @ExceptionHandler(value = Exception.class)
    public Object errorHandler(HttpServletRequest reqest,
                               HttpServletResponse response, Exception e) throws Exception {

        e.printStackTrace();

        if (isAjax(reqest)) {
            JsonResult jsonResult = JsonResult.errorException(e.getMessage());
            return jsonResult;
        } else {
            ModelAndView mav = new ModelAndView();
            mav.addObject("exception", e);
            mav.addObject("url", reqest.getRequestURL());
            mav.setViewName(ERROR_VIEW);
            return mav;
        }
    }
    /**
     * 判断是不是 Ajax 请求
     * */
    public static boolean isAjax(HttpServletRequest httpRequest){
        return  (httpRequest.getHeader("X-Requested-With") != null
                && "XMLHttpRequest"
                .equals( httpRequest.getHeader("X-Requested-With").toString()) );
    }
}
