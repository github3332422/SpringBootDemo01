package com.example.demo01.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;

/**
 * @program: demo01
 * @description: User实体类
 * @author: 张清
 * @create: 2019-12-27 18:12
 **/
@Data
public class User {
    private String name;
    @JsonIgnore
    private String password;
    private Integer age;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss a",locale = "zh",timezone = "GMT+8")
    private Date birthday;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String desc;
}
