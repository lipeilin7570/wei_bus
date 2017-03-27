package com.wgjev.weibus.controller.operator;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wgjev.weibus.entity.BusResult;
import com.wgjev.weibus.service.OperatorService;

@Controller
@RequestMapping("/operator")
public class FindOperatorController {
	
	@Resource
	private OperatorService operatorService;
	
	@RequestMapping("/findoperator.do")
	@ResponseBody
	public BusResult execute(String userName,String loginName,Integer roleID,String telPhone,Integer status,Integer companyID){
		BusResult result = operatorService.findoperators(userName,loginName,roleID,telPhone,status,companyID);
		return result;
	}
	
}
