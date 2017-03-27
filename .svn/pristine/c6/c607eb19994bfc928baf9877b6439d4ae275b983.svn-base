package com.wgjev.weibus.controller.coupon;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wgjev.weibus.entity.BusResult;
import com.wgjev.weibus.service.CouponService;

@Controller
@RequestMapping("/run")
public class LoadCouponController {
	@Resource
	private CouponService couponService;
	
	@RequestMapping("/loadCoupon.do")
	@ResponseBody
	public BusResult execute(Integer companyID){
		return couponService.loadCoupon(companyID);
	}
	
}
