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
public class FinishLeaseByFaultController {
	@Resource
	private IllService illService;
	
	@RequestMapping("/finishLeaseByFault.do")
	@ResponseBody
	public BusResult execute(Integer operatorID, Integer leaseID, Integer cancelFee, 
			double couponFee, Integer addInFault, Integer payBail, double bailFee, String remark,
			HttpServletRequest request, HttpServletResponse response){
		String loginIP = request.getRemoteHost();
		return illService.finishLeaseByFault(operatorID, leaseID, cancelFee, couponFee, addInFault, payBail, bailFee, remark, loginIP);
	}
}
