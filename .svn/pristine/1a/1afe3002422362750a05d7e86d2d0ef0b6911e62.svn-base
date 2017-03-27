package com.wgjev.weibus.controller.ill;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wgjev.weibus.entity.BusResult;
import com.wgjev.weibus.service.IllService;

@Controller
@RequestMapping("/order")
public class QueryFaultController {
	@Resource
	private IllService illService;
	
	@RequestMapping("/queryFault.do")
	@ResponseBody
	public BusResult execute(Integer operatorID, Integer days, 
			Integer faultStatus, Integer leaseID, String carNo,
			HttpServletRequest request, HttpServletResponse response){
		String loginIP = request.getRemoteHost();
		return illService.queryFault(operatorID, days, faultStatus, leaseID, carNo, loginIP);
	}
}
