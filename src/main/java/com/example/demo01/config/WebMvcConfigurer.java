package com.example.demo01.config;

import com.example.demo01.controller.interceptor.OneInterceptor;
import com.example.demo01.controller.interceptor.TwoInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @program: demo01
 * @description: .
 * @author: 张清
 * @create: 2019-12-29 20:39
 **/
@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {
    public void addInterceptors(InterceptorRegistry registry) {
        /**
         * 拦截器按照顺序执行
         */
        registry.addInterceptor(new OneInterceptor()).addPathPatterns("/one/**")
                                                     .addPathPatterns("/two/**");
        registry.addInterceptor(new TwoInterceptor()).addPathPatterns("/two/**")
                .addPathPatterns("/one/**");

        super.addInterceptors(registry);
    }
}
