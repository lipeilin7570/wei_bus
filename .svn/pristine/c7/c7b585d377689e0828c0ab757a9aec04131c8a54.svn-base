package com.wgjev.weibus.controller.operator;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wgjev.weibus.entity.BusResult;
import com.wgjev.weibus.service.OperatorService;

@Controller
@RequestMapping("/operator")
public class UpdateOperatorStatus {
	
	@Resource
	private OperatorService operatorService;
	
	@RequestMapping("/changeStatus.do")
	@ResponseBody
	public BusResult execute(Integer operatorID, Integer status){
		BusResult result = operatorService.changeStatus(operatorID, status);
		return result;
	}
	
}
