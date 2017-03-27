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
public class AddCouponController {
	
	@Resource
	private CouponService couponService;
	
	@RequestMapping("/addCoupon.do")
	@ResponseBody
	public BusResult execute(Integer operatorID, Integer couponModel, String couponName, Integer reachType, String reachTime,
			String reachEndTime, String regBegin, String regEnd, Integer userAuth, Integer hasOrder,
			Integer hasOrderDays, Integer newUser, Integer couponNum, String users, String appointCompany,
			Integer validateType, Integer validateDays, String validateBegin, String validateEnd, Integer couponType,
			double couponMoney, double limitMoney, String remark, 
			HttpServletRequest request, HttpServletResponse response){
		String loginIP = request.getRemoteHost();
		return couponService.addCoupon(operatorID, couponModel, couponName, reachType, reachTime, reachEndTime, 
				regBegin, regEnd, userAuth, hasOrder, hasOrderDays, newUser, couponNum, users, appointCompany, 
				validateType, validateDays, validateBegin, validateEnd, couponType, couponMoney, limitMoney, 
				remark, loginIP);
	}
	
}
