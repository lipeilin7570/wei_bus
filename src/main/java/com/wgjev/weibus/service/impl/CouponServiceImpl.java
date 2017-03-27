package com.wgjev.weibus.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.wgjev.weibus.dao.CompanyInfoMapper;
import com.wgjev.weibus.dao.UserRentalMapper;
import com.wgjev.weibus.dao.json.CouponJsonMapper;
import com.wgjev.weibus.dao.json.OptViewJsonMapper;
import com.wgjev.weibus.entity.BusResult;
import com.wgjev.weibus.entity.CompanyInfo;
import com.wgjev.weibus.entity.UserRental;
import com.wgjev.weibus.entity.json.CouponJson;
import com.wgjev.weibus.entity.json.OptViewJson;
import com.wgjev.weibus.service.CouponService;
import com.wgjev.weibus.util.BusUtil;
import com.wgjev.weibus.util.JsonPostUtil;

@Service
public class CouponServiceImpl implements CouponService {
	
	@Resource
	private OptViewJsonMapper optViewJsonMapper;
	
	@Resource
	private CouponJsonMapper couponJsonMapper;
	
	@Resource
	private CompanyInfoMapper companyInfoMapper;
	
	@Resource
	private UserRentalMapper userRentalMapper;
	
	/**
	 * 新增优惠券
	 */
	public BusResult addCoupon(Integer operatorID, Integer couponModel, String couponName, Integer reachType, String reachTime,
			String reachEndTime, String regBegin, String regEnd, Integer userAuth, Integer hasOrder,
			Integer hasOrderDays, Integer newUser, Integer couponNum, String users, String appointCompany,
			Integer validateType, Integer validateDays, String validateBegin, String validateEnd, Integer couponType,
			double couponMoney, double limitMoney, String remark, String loginIP) {
		// TODO Auto-generated method stub
		BusResult result = new BusResult();
//		OptViewJson optViewJson = optViewJsonMapper.findOptByUserID(operatorID);
		
		JSONObject obj = new JSONObject();
		obj.putOpt("OptID", operatorID);
        
		obj.putOpt("CouponName", couponName);
		obj.putOpt("AppointCompany", appointCompany);
        obj.putOpt("CouponType", couponType);
        obj.putOpt("CouponMoney", couponMoney);
        obj.putOpt("LimitMoney", limitMoney);
        obj.putOpt("Remark", remark);
        
        String url;
        if (couponModel == 1) {
        	url = BusUtil.BASE_IP+"Coupon/AddCouponNow/?UserID="+operatorID+"&UserType=1&UserIP="+loginIP;
        	obj.putOpt("RegBegin", regBegin);
            obj.putOpt("RegEnd", regEnd);
            obj.putOpt("UserAuth", userAuth);
            obj.putOpt("HasOrder", hasOrder);
            obj.putOpt("ValidateBegin", validateBegin);
            obj.putOpt("ValidateEnd", validateEnd);
		}else if (couponModel == 2) {
			url = BusUtil.BASE_IP+"Coupon/AddCouponLater/?UserID="+operatorID+"&UserType=1&UserIP="+loginIP;
        	obj.putOpt("RegBegin", regBegin);
            obj.putOpt("RegEnd", regEnd);
            obj.putOpt("UserAuth", userAuth);
            obj.putOpt("HasOrder", hasOrder);
            obj.putOpt("ValidateBegin", validateBegin);
            obj.putOpt("ValidateEnd", validateEnd);
            obj.putOpt("ReachTime", reachTime);
            obj.putOpt("ReachEndTime", reachEndTime);
            obj.putOpt("NewUser", newUser);
            obj.putOpt("CouponNum", couponNum);
            obj.putOpt("ValidateType", validateType);
            obj.putOpt("ValidateDays", validateDays);
            
		}else if (couponModel == 3) {
			url = BusUtil.BASE_IP+"Coupon/AddCouponGet/?UserID="+operatorID+"&UserType=1&UserIP="+loginIP;
        	obj.putOpt("RegBegin", regBegin);
            obj.putOpt("RegEnd", regEnd);
            obj.putOpt("UserAuth", userAuth);
            obj.putOpt("HasOrder", hasOrder);
            obj.putOpt("ReachTime", reachTime);
            obj.putOpt("ReachEndTime", reachEndTime);
            obj.putOpt("NewUser", newUser);
            obj.putOpt("CouponNum", couponNum);
            obj.putOpt("ValidateDays", validateDays);
            obj.putOpt("HasOrderDays", hasOrderDays);
            
		}else if (couponModel == 4) {
			url = BusUtil.BASE_IP+"Coupon/AddCouponNew/?UserID="+operatorID+"&UserType=1&UserIP="+loginIP;
            obj.putOpt("UserAuth", userAuth);
            obj.putOpt("HasOrder", hasOrder);
            obj.putOpt("ReachTime", reachTime);
            obj.putOpt("ReachEndTime", reachEndTime);
            obj.putOpt("CouponNum", couponNum);
            obj.putOpt("ValidateDays", validateDays);
            obj.putOpt("HasOrderDays", hasOrderDays);
            
		}else if (couponModel == 5) {
			url = BusUtil.BASE_IP+"Coupon/AddCouponAppoint/?UserID="+operatorID+"&UserType=1&UserIP="+loginIP;
            obj.putOpt("ValidateBegin", validateBegin);
            obj.putOpt("ValidateEnd", validateEnd);
            if (users != null) {
				users = userTelPhonesToUserIDs(users);
			}
            if (users.equals("error")) {
				result.setStatus(102);
				return result;
			}
            obj.putOpt("Users", users);
            
		}else {
			result.setStatus(1);
			return result;
		}
       
        BusResult  jsonResult = JsonPostUtil.sendPost(url, obj.toString());
        String jsonStr = jsonResult.getData().toString();
		
        JSONObject jsonObject = new JSONObject(jsonStr);
		int status = jsonObject.getInt("Result");
		result.setStatus(status);
		
		return result;
	}

	/**
	 * 新增邀请码活动
	 */
	public BusResult addInvite(Integer operatorID, String couponName, Integer inviteType, String inviteEndTime, String regBegin,
			String regEnd, Integer userAuth, Integer hasOrder, Integer newUser, String users, Integer inviteSelf,
			Integer inviteLime, Integer bUserAuth, Integer bHasOrder, Integer bHasOrderDays, Integer appointCompany,
			Integer validateDays, Integer couponType, double couponMoney, double limitMoney, String remark,
			String loginIP) {
		// TODO Auto-generated method stub
		BusResult result = new BusResult();
//		OptViewJson optViewJson = optViewJsonMapper.findOptByUserID(operatorID);
		
		JSONObject obj = new JSONObject();
		obj.putOpt("OptID", operatorID);
		obj.putOpt("CouponName", couponName);
		obj.putOpt("InviteType", inviteType);
		obj.putOpt("InviteEndTime", inviteEndTime);
        obj.putOpt("RegBegin", regBegin);
        obj.putOpt("RegEnd", regEnd);
        obj.putOpt("UserAuth", userAuth);
        obj.putOpt("HasOrder", hasOrder);
        obj.putOpt("NewUser", newUser);
        if (users != null) {
			users = userTelPhonesToUserIDs(users);
		}
        if (users.equals("error")) {
			result.setStatus(102);
			return result;
		}
        obj.putOpt("Users", users);
        obj.putOpt("InviteSelf", inviteSelf);
        obj.putOpt("InviteLime", inviteLime);
        obj.putOpt("BUserAuth", bUserAuth);
        obj.putOpt("BHasOrder", bHasOrder);
        obj.putOpt("BHasOrderDays", bHasOrderDays);
        obj.putOpt("AppointCompany", appointCompany);
        obj.putOpt("ValidateDays", validateDays);
        obj.putOpt("CouponType", couponType);
        obj.putOpt("CouponMoney", couponMoney);
        obj.putOpt("LimitMoney", limitMoney);
        obj.putOpt("Remark", remark);
        
        String url = BusUtil.BASE_IP+"Coupon/AddInvite/?UserID="+operatorID+"&UserType=1&UserIP="+loginIP;
        
        BusResult  jsonResult = JsonPostUtil.sendPost(url, obj.toString());
        String jsonStr = jsonResult.getData().toString();
		
        JSONObject jsonObject = new JSONObject(jsonStr);
		int status = jsonObject.getInt("Result");
		result.setStatus(status);
		
		return result;
	}

	/**
	 * 显示公司的优惠券信息
	 */
	public BusResult loadCoupon(Integer companyID) {
		// TODO Auto-generated method stub
		BusResult result = new BusResult();
		List<CouponJson> rList = new ArrayList<CouponJson>();
		List<CouponJson> list = couponJsonMapper.loadCouponsByCompanyID(companyID);
		for (CouponJson couponJson : list) {
			if (couponJson.getAuditStatus() == null) {
				couponJson.setAuditStatus(0);
			}
			if (couponJson.getAppointCompany() == null || couponJson.getAppointCompany().equals("") || couponJson.getAppointCompany().equals("0")) {
				couponJson.setShortName("不限");
			}else {
				StringBuffer shortName = new StringBuffer("");
				String arr[] = couponJson.getAppointCompany().split(",");
				for (int j = 0; j < arr.length; j++) {
					
					try {
						CompanyInfo companyInfo = companyInfoMapper.selectByPrimaryKey(new Integer(arr[j].trim()));
						if (j == arr.length-1) {
							shortName.append(companyInfo.getShortname());
						}else {
							shortName.append(companyInfo.getShortname()).append("、");
						}
					} catch (Exception e) {
						// TODO: handle exception
						continue;
					}
				}
				couponJson.setShortName(shortName.toString());
			}
			rList.add(couponJson);
		}
		result.setStatus(0);
		result.setData(rList);
		
		return result;
	}

	/**
	 * 会员手机号码转成会员ID
	 * @param users
	 * @return
	 */
	public String userTelPhonesToUserIDs(String users){
		String arr[] = users.split(",");
		StringBuffer userIDs = new StringBuffer("");
		for (int i = 0; i < arr.length; i++) {
			UserRental userRental = userRentalMapper.findByTelPhone(arr[i].trim());
			if (userRental == null) {
				return "error";
			}else {
				if (i == arr.length-1) {
					userIDs.append(userRental.getRentaluserid());
				}else {
					userIDs.append(userRental.getRentaluserid()).append(",");
				}
			}
		}
		return userIDs.toString();
	}
	
	/**
	 * 优惠券审核
	 */
	public BusResult auditCoupon(Integer operatorID, String loginIP, Integer couponID, Integer auditStatus,
			String failCause) {
		// TODO Auto-generated method stub
		BusResult result = new BusResult();
		
		JSONObject obj = new JSONObject();
		obj.putOpt("OptID", operatorID);
		obj.putOpt("CouponID", couponID);
		obj.putOpt("AuditStatus", auditStatus);
		if (auditStatus == 2) {
			obj.putOpt("FailCause", failCause);
		}
		
        String url = BusUtil.BASE_IP+"Coupon/AuditCoupon/?UserID="+operatorID+"&UserType=1&UserIP="+loginIP;
        
        BusResult  jsonResult = JsonPostUtil.sendPost(url, obj.toString());
        String jsonStr = jsonResult.getData().toString();
		
        JSONObject jsonObject = new JSONObject(jsonStr);
		int status = jsonObject.getInt("Result");
		result.setStatus(status);
		
		return result;
	}
	
	
}
