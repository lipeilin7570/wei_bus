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
public class QueryIllegalLeaseController {
	@Resource
	private IllService illService;
	
	@RequestMapping("/queryIllegalLease.do")
	@ResponseBody
	public BusResult execute(Integer operatorID, Integer undeal, Integer overDate,
			HttpServletRequest request, HttpServletResponse response){
		String loginIP = request.getRemoteHost();
		return illService.queryIllegalLease(operatorID, undeal, overDate, loginIP);
	}
}
