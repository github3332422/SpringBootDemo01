package com.example.demo01.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @program: demo01
 * @description:
 * @author: 张清
 * @create: 2019-12-27 19:35
 **/
@Data
// 加这个注解避免 ConfigurationProperties 出现异常
@Component
@Configuration
@ConfigurationProperties(prefix="com.imooc.opensource")
@PropertySource(value = "classpath:resource.properties")
public class Resource {
    private String name;
    private String website;
    private String language;

}
