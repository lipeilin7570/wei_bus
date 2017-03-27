package com.wgjev.weibus.controller.order;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wgjev.weibus.entity.BusResult;
import com.wgjev.weibus.service.OrderService;

@Controller
@RequestMapping("/order")
public class LoadAllLeaseOrderJsonController {
	
	@Resource
	private OrderService orderService;
	
	@RequestMapping("/loadAllLeaseOrders.do")
	@ResponseBody
	public BusResult execute(){
		return orderService.loadAllLeaseOrder();
	}
	
}
