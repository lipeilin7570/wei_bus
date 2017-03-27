package com.wgjev.weibus.controller.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wgjev.weibus.entity.BusResult;
import com.wgjev.weibus.service.UserService;

@Controller
@RequestMapping("/vip")
public class SetUserAuthenticationController {
	
	@Resource
	private UserService userService;
	
	@RequestMapping("/changAuthentication.do")
	@ResponseBody
	public BusResult execute(Integer operatorID, Integer userID, Integer authentication, String reason){
		return userService.changUserAuthentication(operatorID, userID, authentication, reason);
	}
}
