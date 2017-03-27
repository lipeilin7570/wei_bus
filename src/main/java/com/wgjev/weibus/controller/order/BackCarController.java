package com.wgjev.weibus.controller.order;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wgjev.weibus.entity.BusResult;
import com.wgjev.weibus.service.OrderService;

@Controller
@RequestMapping("/order")
public class BackCarController {
	
	@Resource
	private OrderService orderService;
	
	@RequestMapping("/backCar.do")
	@ResponseBody
	public BusResult execute(Integer operatorID, Integer leaseID, Integer siteID, String remark, String backTime,
			HttpServletRequest request, HttpServletResponse response){
		String loginIP = request.getRemoteHost();
		return orderService.backCar(operatorID, leaseID, siteID, remark, backTime, loginIP);
	}
}
