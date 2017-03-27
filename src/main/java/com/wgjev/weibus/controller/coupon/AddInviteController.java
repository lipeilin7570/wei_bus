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
public class AddInviteController {
	@Resource
	private CouponService couponService;
	
	@RequestMapping("/addInvite.do")
	@ResponseBody
	public BusResult execute(Integer operatorID, String couponName, Integer inviteType, String inviteEndTime, String regBegin,
			String regEnd, Integer userAuth, Integer hasOrder, Integer newUser, String users, Integer inviteSelf,
			Integer inviteLime, Integer bUserAuth, Integer bHasOrder, Integer bHasOrderDays, Integer appointCompany,
			Integer validateDays, Integer couponType, double couponMoney, double limitMoney, String remark,
			HttpServletRequest request, HttpServletResponse response){
		String loginIP = request.getRemoteHost();
		return couponService.addInvite(operatorID, couponName, inviteType, inviteEndTime, regBegin, regEnd, 
				userAuth, hasOrder, newUser, users, inviteSelf, inviteLime, bUserAuth, bHasOrder, 
				bHasOrderDays, appointCompany, validateDays, couponType, couponMoney, limitMoney, 
				remark, loginIP);
	}
}
