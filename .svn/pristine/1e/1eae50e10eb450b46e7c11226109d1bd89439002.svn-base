package com.wgjev.weibus.controller.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wgjev.weibus.entity.BusResult;
import com.wgjev.weibus.service.UserService;

@Controller
@RequestMapping("/vip")
public class LoadUsersController {
	
	@Resource
	private UserService userService;
	
	@RequestMapping("/loadUsers.do")
	@ResponseBody
	public BusResult execute(){
		return userService.loadUsers();
	}
	
}
