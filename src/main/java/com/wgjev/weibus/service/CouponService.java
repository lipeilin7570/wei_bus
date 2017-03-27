package com.wgjev.weibus.service;

import com.wgjev.weibus.entity.BusResult;

public interface CouponService {
	
	/**
	 * 新增优惠券
	 * @param operatorID
	 * @param couponModel
	 * @param couponName
	 * @param reachType
	 * @param reachTime
	 * @param reachEndTime
	 * @param regBegin
	 * @param regEnd
	 * @param userAuth
	 * @param hasOrder
	 * @param hasOrderDays
	 * @param newUser
	 * @param couponNum
	 * @param users
	 * @param appointCompany
	 * @param validateType
	 * @param validateDays
	 * @param validateBegin
	 * @param validateEnd
	 * @param couponType
	 * @param couponMoney
	 * @param limitMoney
	 * @param remark
	 * @param loginIP
	 * @return
	 */
	public BusResult addCoupon(Integer operatorID, Integer couponModel, String couponName, Integer reachType, 
			String reachTime, String reachEndTime, String regBegin, String regEnd, Integer userAuth,
			Integer hasOrder, Integer hasOrderDays, Integer newUser, Integer couponNum, String users,
			String appointCompany, Integer validateType, Integer validateDays, String validateBegin,
			String validateEnd, Integer couponType, double couponMoney, double limitMoney, String remark,
			String loginIP);
	
	/**
	 * 新增邀请码活动
	 * @param operatorID
	 * @param couponName
	 * @param inviteType
	 * @param inviteEndTime
	 * @param regBegin
	 * @param regEnd
	 * @param userAuth
	 * @param hasOrder
	 * @param newUser
	 * @param users
	 * @param inviteSelf
	 * @param inviteLime
	 * @param bUserAuth
	 * @param bHasOrder
	 * @param bHasOrderDays
	 * @param appointCompany
	 * @param validateDays
	 * @param couponType
	 * @param couponMoney
	 * @param limitMoney
	 * @param remark
	 * @param loginIP
	 * @return
	 */
	public BusResult addInvite(Integer operatorID, String couponName, Integer inviteType, String inviteEndTime, String regBegin, 
			String regEnd, Integer userAuth, Integer hasOrder, Integer newUser, String users, Integer inviteSelf,
			Integer inviteLime, Integer bUserAuth, Integer bHasOrder, Integer bHasOrderDays, Integer appointCompany,
			Integer validateDays, Integer couponType, double couponMoney, double limitMoney, String remark,
			String loginIP);
	
	/**
	 * 显示公司的优惠券信息
	 * @param companyID
	 * @return
	 */
	public BusResult loadCoupon(Integer companyID);
	
	
	/**
	 * 优惠券审核
	 * @param operatorID
	 * @param loginIP
	 * @param couponID
	 * @param auditStatus
	 * @param failCause
	 * @return
	 */
	public BusResult auditCoupon(Integer operatorID, String loginIP, Integer couponID, Integer auditStatus, String failCause);
	
	
}
