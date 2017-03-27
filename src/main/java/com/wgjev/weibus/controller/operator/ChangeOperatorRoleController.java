package com.wgjev.weibus.controller.operator;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wgjev.weibus.entity.BusResult;
import com.wgjev.weibus.service.OperatorService;

@Controller
@RequestMapping("/operator")
public class ChangeOperatorRoleController {
	
	@Resource
	private OperatorService operatorService;
	
	@RequestMapping("/changeOperatorRole.do")
	@ResponseBody
	public BusResult execute(Integer operatorID, Integer roleID){
		BusResult result = operatorService.changeRole(operatorID, roleID);
		return result;
	}
	
}
