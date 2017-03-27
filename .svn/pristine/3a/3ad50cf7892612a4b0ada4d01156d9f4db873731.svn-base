package com.wgjev.weibus.controller.coupon;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wgjev.weibus.entity.BusResult;
import com.wgjev.weibus.service.CouponService;

@Controller
@RequestMapping("/run")
public class AuditCouponController {
	@Resource
	private CouponService couponService;
	
	@RequestMapping("/auditCoupon.do")
	@ResponseBody
	public BusResult execute(Integer operatorID, Integer couponID, Integer auditStatus, String failCause, 
			HttpServletRequest request, HttpServletResponse response){
		String loginIP = request.getRemoteHost();
		return couponService.auditCoupon(operatorID, loginIP, couponID, auditStatus, failCause);
	}
}
