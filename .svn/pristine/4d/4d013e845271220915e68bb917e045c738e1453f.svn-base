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
public class FinishOrderController {
	
	@Resource
	private OrderService orderService;
	
	@RequestMapping("/finishLease.do")
	@ResponseBody
	public BusResult execute(Integer operatorID, Integer leaseID, Integer finishType, 
			Integer cancelFee, double couponFee, String remark, String finishTime,
			HttpServletRequest request, HttpServletResponse response){
		String loginIP = request.getRemoteHost();
		return orderService.finishOrder(operatorID, leaseID, finishType, cancelFee, 
				couponFee, remark, finishTime, loginIP);
				
	}
	
}
