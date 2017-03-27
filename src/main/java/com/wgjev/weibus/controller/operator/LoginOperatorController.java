package com.wgjev.weibus.controller.operator;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wgjev.weibus.entity.BusResult;
import com.wgjev.weibus.service.OperatorService;

@Controller
@RequestMapping("/operator")
public class LoginOperatorController {
	@Resource
	private OperatorService operatorService;
	
	@RequestMapping("/login.do")
	@ResponseBody
	public BusResult execute(String loginName, String pwd,  
			HttpServletRequest request, HttpServletResponse response){
		String loginIP = request.getRemoteHost();
		BusResult result = operatorService.chenckLogin(loginName, pwd, loginIP);
		return result;
	}
	
	
	
}
