package com.example.demo01.controller;

import java.util.Date;
import java.util.List;

import com.example.demo01.pojo.JsonResult;
import com.example.demo01.pojo.SysUser;
import com.example.demo01.service.UserService;
import org.n3r.idworker.Sid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/mybatis")
public class MyBatisCRUDController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private Sid sid;
	
	@RequestMapping("/saveUser")
	public JsonResult saveUser() throws Exception {
		
		String userId = sid.nextShort();
		
		SysUser user = new SysUser();
		user.setId(userId);
		user.setUsername("imooc" + new Date());
		user.setNickname("imooc" + new Date());
		user.setPassword("abc123");
		user.setIsDelete(0);
		user.setRegistTime(new Date());
		
		userService.saveUser(user);
		
		return JsonResult.ok("保存成功");
	}
	
	@RequestMapping("/updateUser")
	public JsonResult updateUser() {
		
		SysUser user = new SysUser();
		user.setId("191229CGNC93S0SW");
		user.setUsername("10011001-updated" + new Date());
		user.setNickname("10011001-updated" + new Date());
		user.setPassword("10011001-updated");
		user.setIsDelete(0);
		user.setRegistTime(new Date());
		
		userService.updateUser(user);
		
		return JsonResult.ok("保存成功");
	}
	
	@RequestMapping("/deleteUser")
	public JsonResult deleteUser(String userId) {
		
		userService.deleteUser(userId);
		
		return JsonResult.ok("删除成功");
	}
	
	@RequestMapping("/queryUserById")
	public JsonResult queryUserById(String userId) {
		
		return JsonResult.ok(userService.queryUserById(userId));
	}
	
	@RequestMapping("/queryUserList")
	public JsonResult queryUserList() {
		
		SysUser user = new SysUser();
		user.setUsername("imooc");
		user.setNickname("lee");
		
		List<SysUser> userList = userService.queryUserList(user);
		
		return JsonResult.ok(userList);
	}
	
	@RequestMapping("/queryUserListPaged")
	public JsonResult queryUserListPaged(Integer page) {

		if (page == null) {
			page = 1;
		}

		int pageSize = 10;

		SysUser user = new SysUser();
//		user.setNickname("lee");

		List<SysUser> userList = userService.queryUserListPaged(user, page, pageSize);

		return JsonResult.ok(userList);
	}

	@RequestMapping("/queryUserByIdCustom")
	public JsonResult queryUserByIdCustom(String userId) {

		return JsonResult.ok(userService.queryUserByIdCustom(userId));
	}

//	@RequestMapping("/saveUserTransactional")
//	public JsonResult saveUserTransactional() {
//
//		String userId = sid.nextShort();
//
//		SysUser user = new SysUser();
//		user.setId(userId);
//		user.setUsername("lee" + new Date());
//		user.setNickname("lee" + new Date());
//		user.setPassword("abc123");
//		user.setIsDelete(0);
//		user.setRegistTime(new Date());
//
//		userService.saveUserTransactional(user);
//
//		return JsonResult.ok("保存成功");
//	}
}
