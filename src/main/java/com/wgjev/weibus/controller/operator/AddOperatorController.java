package com.wgjev.weibus.controller.operator;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wgjev.weibus.entity.BusResult;
import com.wgjev.weibus.service.OperatorService;

@Controller
@RequestMapping("/operator")
public class AddOperatorController {
	
	@Resource
	private OperatorService operatorService;
	
	@RequestMapping("/addOperator.do")
	@ResponseBody
	public BusResult execute(String userName, String pwd, String loginName, Integer roleID, Integer deptType, String telPhone,
			String remark, Integer companyID){
		BusResult result;
		try {
			result = operatorService.addOperator(userName, pwd, loginName, roleID, deptType, telPhone, remark, companyID);
		} catch (Exception e) {
			result = new BusResult();
			result.setStatus(1);
			e.printStackTrace();
		}
		
		return result;
		
	}
	
}
