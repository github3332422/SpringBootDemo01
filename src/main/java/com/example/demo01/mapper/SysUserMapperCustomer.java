package com.example.demo01.mapper;

import com.example.demo01.pojo.SysUser;

import java.util.List;

public interface SysUserMapperCustomer{

    List<SysUser> queryUserSimplyInfoById(String id);
}