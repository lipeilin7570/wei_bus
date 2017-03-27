package com.wgjev.weibus.controller.operator;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wgjev.weibus.entity.BusResult;
import com.wgjev.weibus.service.OperatorService;

@Controller
@RequestMapping("/operator")
public class LoadOperatorController {
	
	@Resource
	private OperatorService operatorService;
	
	@RequestMapping("/loadoperators.do")
	@ResponseBody
	public BusResult execute(){
		BusResult result = operatorService.loadAllOperators();
		return result;
	}
}
