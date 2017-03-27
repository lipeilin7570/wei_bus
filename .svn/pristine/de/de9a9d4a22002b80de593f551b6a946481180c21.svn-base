package com.wgjev.weibus.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.wgjev.weibus.entity.BusResult;
import com.wgjev.weibus.service.IllService;
import com.wgjev.weibus.util.BusUtil;
import com.wgjev.weibus.util.JsonPostUtil;

@Service
public class IllServiceImpl implements IllService {
	
	/**
	 * 违章信息录入
	 */
	public BusResult AddIllegal(Integer operatorID, Integer leaseID, String illegalTime, String description,
			String address, String collectionUnit, Integer points, double fine, String remark, String loginIP) {
		// TODO Auto-generated method stub
		BusResult result = new BusResult();
		
		JSONObject obj = new JSONObject();
		obj.putOpt("OptID", operatorID);
		obj.putOpt("LeaseID", leaseID);
		obj.putOpt("IllegalTime", illegalTime);
		obj.putOpt("Description", description);
		obj.putOpt("Address", address);
		obj.putOpt("CollectionUnit", collectionUnit);
		obj.putOpt("Points", points);
		obj.putOpt("Fine", fine);
		obj.putOpt("Remark", remark);
		
        String url = BusUtil.BASE_IP+"Illegal/AddIllegal/?UserID="+operatorID+"&UserType=1&UserIP="+loginIP;
        
        BusResult  jsonResult = JsonPostUtil.sendPost(url, obj.toString());
        String jsonStr = jsonResult.getData().toString();
		
        JSONObject jsonObject = new JSONObject(jsonStr);
		int status = jsonObject.getInt("Result");
		result.setStatus(status);
		
		return result;
	}


	/**
	 * 查询有违章的订单
	 */
	public BusResult queryIllegalLease(Integer operatorID, Integer undeal, Integer overDate, String loginIP) {
		// TODO Auto-generated method stub
		BusResult result = new BusResult();
		
		JSONObject obj = new JSONObject();
		obj.putOpt("OptID", operatorID);
		obj.putOpt("Undeal", undeal);
		obj.putOpt("OverDate", overDate);
		
		
        String url = BusUtil.BASE_IP+"Illegal/QueryIllegalLease/?UserID="+operatorID+"&UserType=1&UserIP="+loginIP;
        
        BusResult  jsonResult = JsonPostUtil.sendPost(url, obj.toString());
        String jsonStr = jsonResult.getData().toString();
		
        JSONObject jsonObject = new JSONObject(jsonStr);
		int status = jsonObject.getInt("Result");
		result.setStatus(status);
		
		if (status != 0) {
			return result;
		}
		List<Map<String, Object>> Illegals = new ArrayList<Map<String,Object>>();
		JSONArray illegalJsons = jsonObject.getJSONArray("Illegals");
		for (int i = 0; i < illegalJsons.length(); i++) {
			JSONObject jsonItem = illegalJsons.getJSONObject(i);
			Integer LeaseID = jsonItem.getInt("LeaseID");
			String LeaseNo = jsonItem.getString("LeaseNo");
			Integer LeaseCarID = jsonItem.getInt("LeaseCarID");
			String LeaseCarNo = jsonItem.getString("LeaseCarNo");
			String LeaseCarModelName = jsonItem.getString("LeaseCarModelName");
			String LeaseCarModelAlias = jsonItem.getString("LeaseCarModelAlias");
			String LeaseCarModelIcon = jsonItem.getString("LeaseCarModelIcon");
			String LeaseCarModelImg = jsonItem.getString("LeaseCarModelImg");
			String LeaseTime = jsonItem.getString("LeaseTime");
			String LeaseTakeTime = jsonItem.getString("LeaseTakeTime");
			String LeaseTakeLoc = jsonItem.getString("LeaseTakeLoc");
			String LeaseBackTime = jsonItem.getString("LeaseBackTime");
			String LeaseBackLoc = jsonItem.getString("LeaseBackLoc");
			Integer UserID = jsonItem.getInt("UserID");
			String UserName = jsonItem.getString("UserName");
			String UserPhone = jsonItem.getString("UserPhone");
			Integer UnDealIllegal = jsonItem.getInt("UnDealIllegal");
			Integer UnDealIllegalPoints = jsonItem.getInt("UnDealIllegalPoints");
			Double UnDealIllegalFines = jsonItem.getDouble("UnDealIllegalFines");
			Double PayBail = jsonItem.getDouble("PayBail");
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("LeaseID", LeaseID);
			map.put("LeaseNo", LeaseNo);
			map.put("LeaseCarID", LeaseCarID);
			map.put("LeaseCarNo", LeaseCarNo);
			map.put("LeaseCarModelName", LeaseCarModelName);
			map.put("LeaseCarModelAlias", LeaseCarModelAlias);
			map.put("LeaseCarModelIcon", BusUtil.SERVICE_IP+LeaseCarModelIcon);
			map.put("LeaseCarModelImg", BusUtil.SERVICE_IP+LeaseCarModelImg);
			map.put("LeaseTime", LeaseTime);
			map.put("LeaseTakeTime", LeaseTakeTime);
			map.put("LeaseTakeLoc", LeaseTakeLoc);
			map.put("LeaseBackTime", LeaseBackTime);
			map.put("LeaseBackLoc", LeaseBackLoc);
			map.put("UserID", UserID);
			map.put("UserName", UserName);
			map.put("UserPhone", UserPhone);
			map.put("UnDealIllegal", UnDealIllegal);
			map.put("UnDealIllegalPoints", UnDealIllegalPoints);
			map.put("UnDealIllegalFines", UnDealIllegalFines);
			map.put("PayBail", PayBail);
			Illegals.add(map);
		}
		result.setData(Illegals);
		
		return result;
	}

	/**
	 * 按订单查询违章
	 */
	public BusResult quertLeaseIllegal(Integer operatorID, Integer leaseID, String loginIP) {
		// TODO Auto-generated method stub
		BusResult result = new BusResult();
		
		JSONObject obj = new JSONObject();
		obj.putOpt("OptID", operatorID);
		obj.putOpt("LeaseID", leaseID);
		
        String url = BusUtil.BASE_IP+"Illegal/QueryLeaseIllegal/?UserID="+operatorID+"&UserType=1&UserIP="+loginIP;
        
        BusResult  jsonResult = JsonPostUtil.sendPost(url, obj.toString());
        String jsonStr = jsonResult.getData().toString();
		
        JSONObject jsonObject = new JSONObject(jsonStr);
		int status = jsonObject.getInt("Result");
		result.setStatus(status);
		
		if (status != 0) {
			return result;
		}
		Integer LeaseID = jsonObject.getInt("LeaseID");
		String LeaseNo = jsonObject.getString("LeaseNo");
		Integer LeaseCarID = jsonObject.getInt("LeaseCarID");
		String LeaseCarNo = jsonObject.getString("LeaseCarNo");
		String LeaseCarModelName = jsonObject.getString("LeaseCarModelName");
		String LeaseCarModelAlias = jsonObject.getString("LeaseCarModelAlias");
		String LeaseCarModelIcon = jsonObject.getString("LeaseCarModelIcon");
		String LeaseCarModelImg = jsonObject.getString("LeaseCarModelImg");
		String LeaseTime = jsonObject.getString("LeaseTime");
		String LeaseTakeTime = jsonObject.getString("LeaseTakeTime");
		String LeaseTakeLoc = jsonObject.getString("LeaseTakeLoc");
		String LeaseBackTime = jsonObject.getString("LeaseBackTime");
		String LeaseBackLoc = jsonObject.getString("LeaseBackLoc");
		Integer UserID = jsonObject.getInt("UserID");
		String UserName = jsonObject.getString("UserName");
		String UserPhone = jsonObject.getString("UserPhone");
		Double PayBail = jsonObject.getDouble("PayBail");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("LeaseID", LeaseID);
		map.put("LeaseNo", LeaseNo);
		map.put("LeaseCarID", LeaseCarID);
		map.put("LeaseCarNo", LeaseCarNo);
		map.put("LeaseCarModelName", LeaseCarModelName);
		map.put("LeaseCarModelAlias", LeaseCarModelAlias);
		map.put("LeaseCarModelIcon", BusUtil.SERVICE_IP+LeaseCarModelIcon);
		map.put("LeaseCarModelImg", BusUtil.SERVICE_IP+LeaseCarModelImg);
		map.put("LeaseTime", LeaseTime);
		map.put("LeaseTakeTime", LeaseTakeTime);
		map.put("LeaseTakeLoc", LeaseTakeLoc);
		map.put("LeaseBackTime", LeaseBackTime);
		map.put("LeaseBackLoc", LeaseBackLoc);
		map.put("UserID", UserID);
		map.put("UserName", UserName);
		map.put("UserPhone", UserPhone);
		map.put("PayBail", PayBail);
		
		List<Map<String, Object>> Illegals = new ArrayList<Map<String,Object>>();
		JSONArray illegalJsons = jsonObject.getJSONArray("Illegals");
		for (int i = 0; i < illegalJsons.length(); i++) {
			JSONObject jsonItem = illegalJsons.getJSONObject(i);
			Integer IllegalID = jsonItem.getInt("IllegalID");
			String IllegalTime = jsonItem.getString("IllegalTime");
			String Description = jsonItem.getString("Description");
			String Address = jsonItem.getString("Address");
			String CollectionUnit = jsonItem.getString("CollectionUnit");
			Integer Points = jsonItem.getInt("Points");
			Double Fine = jsonItem.getDouble("Fine");
			Integer Status = jsonItem.getInt("Status");
			String DealTime = jsonItem.getString("DealTime");
//			String DealProof = jsonItem.getString("DealProof");
			String AuditTime = jsonItem.getString("AuditTime");
			

			Map<String , Object> ill = new HashMap<String, Object>();
			ill.put("IllegalID", IllegalID);
			ill.put("IllegalTime", IllegalTime);
			ill.put("Description", Description);
			ill.put("Address", Address);
			ill.put("CollectionUnit", CollectionUnit);
			ill.put("Points", Points);
			ill.put("Fine", Fine);
			ill.put("Status", Status);
			ill.put("DealTime", DealTime);
//			ill.put("DealProof", DealProof);
			ill.put("AuditTime", AuditTime);
			
			Illegals.add(ill);
		}
		map.put("Illegals", Illegals);
		
		result.setData(map);
		
		return result;
	}

	/**
	 * 违章审核
	 */
	public BusResult auditIllegal(Integer operatorID, Integer illegalID, Integer auditStatus, String failReason,
			String loginIP) {
		// TODO Auto-generated method stub
		BusResult result = new BusResult();
		
		JSONObject obj = new JSONObject();
		obj.putOpt("OptID", operatorID);
		obj.putOpt("IllegalID", illegalID);
		obj.putOpt("AuditStatus", auditStatus);
		obj.putOpt("FailReason", failReason);
		
		
        String url = BusUtil.BASE_IP+"Illegal/AuditIllegal/?UserID="+operatorID+"&UserType=1&UserIP="+loginIP;
        
        BusResult  jsonResult = JsonPostUtil.sendPost(url, obj.toString());
        String jsonStr = jsonResult.getData().toString();
		
        JSONObject jsonObject = new JSONObject(jsonStr);
		int status = jsonObject.getInt("Result");
		result.setStatus(status);
		
		return result;
	}

	/**
	 * 违章未处理扣除保证金
	 */
	public BusResult undealIllegal(Integer operatorID, Integer leaseID, double deductBail, String deductRemark,
			Integer addPenalty, String penaltyReason, String loginIP) {
		// TODO Auto-generated method stub
		BusResult result = new BusResult();
		
		JSONObject obj = new JSONObject();
		obj.putOpt("OptID", operatorID);
		obj.putOpt("LeaseID", leaseID);
		obj.putOpt("DeductBail", deductBail);
		obj.putOpt("DeductRemark", deductRemark);
		obj.putOpt("AddPenalty", addPenalty);
		obj.putOpt("PenaltyReason", penaltyReason);
		
        String url = BusUtil.BASE_IP+"Illegal/AuditIllegal/?UserID="+operatorID+"&UserType=1&UserIP="+loginIP;
        
        BusResult  jsonResult = JsonPostUtil.sendPost(url, obj.toString());
        String jsonStr = jsonResult.getData().toString();
		
        JSONObject jsonObject = new JSONObject(jsonStr);
		int status = jsonObject.getInt("Result");
		result.setStatus(status);
		Map<String, Object> map = new HashMap<String, Object>();
		if (status==0) {
			Double PayBail = jsonObject.getDouble("PayBail");
			map.put("PayBail", PayBail);
		}else if (status == 102) {
			Double RepayBail = jsonObject.getDouble("RepayBail");
			map.put("RepayBail", RepayBail);
		}
		result.setData(map);
		
		return result;
	}

	
	
	//*****************************************
	
	/**
	 * 故障信息登记
	 */
	public BusResult addFault(Integer operatorID, Integer userID, Integer leaseID, Integer carID, String faultTime,
			String faultBrief, Integer userFault, Integer cancelFee, double couponFee, Integer addInFault,
			Integer payBail, double bailFee, String remark, String loginIP) {
		// TODO Auto-generated method stub
		BusResult result = new BusResult();
		
		JSONObject obj = new JSONObject();
		obj.putOpt("OptID", operatorID);
		obj.putOpt("UserID", userID);
		obj.putOpt("LeaseID", leaseID);
		obj.putOpt("CarID", carID);
		obj.putOpt("FaultTime", faultTime);
		obj.putOpt("FaultBrief", faultBrief);
		obj.putOpt("UserFault", userFault);
		if (userFault == 1) {
			obj.putOpt("CancelFee", cancelFee);
			obj.putOpt("CouponFee", couponFee);
			obj.putOpt("AddInFault", addInFault);
			obj.putOpt("PayBail", payBail);
			obj.putOpt("BailFee", bailFee);
			obj.putOpt("Remark", remark);
		}
		
		
        String url = BusUtil.BASE_IP+"Fault/AddFault/?UserID="+operatorID+"&UserType=1&UserIP="+loginIP;
        
        BusResult  jsonResult = JsonPostUtil.sendPost(url, obj.toString());
        String jsonStr = jsonResult.getData().toString();
		
        JSONObject jsonObject = new JSONObject(jsonStr);
		int status = jsonObject.getInt("Result");
		result.setStatus(status);
		
		if (status != 0) {
			return result;
		}
		Integer FaultID = jsonObject.getInt("FaultID");
		String FaultNo = jsonObject.getString("FaultNo");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("FaultID", FaultID);
		map.put("FaultNo", FaultNo);
		
		
		result.setData(map);
		return result;
	}

	
	/**
	 * 查询有故障的订单
	 */
	public BusResult queryFault(Integer operatorID, Integer days, Integer faultStatus, Integer leaseID, String carNo,
			String loginIP) {
		// TODO Auto-generated method stub
		BusResult result = new BusResult();
		
		JSONObject obj = new JSONObject();
		obj.putOpt("Days", days);
		obj.putOpt("FaultStatus", faultStatus);
		obj.putOpt("LeaseID", leaseID);
		obj.putOpt("CarNo", carNo);
		
		
        String url = BusUtil.BASE_IP+"Fault/QueryFault/?UserID="+operatorID+"&UserType=1&UserIP="+loginIP;
        
        BusResult  jsonResult = JsonPostUtil.sendPost(url, obj.toString());
        String jsonStr = jsonResult.getData().toString();
		
        JSONObject jsonObject = new JSONObject(jsonStr);
		int status = jsonObject.getInt("Result");
		result.setStatus(status);
		
		if (status != 0) {
			return result;
		}
		List<Map<String, Object>> Faults = new ArrayList<Map<String,Object>>();
		JSONArray faultJsons = jsonObject.getJSONArray("Faults");
		for (int i = 0; i < faultJsons.length(); i++) {
			JSONObject jsonItem = faultJsons.getJSONObject(i);
			Integer LeaseID = jsonItem.getInt("LeaseID");
			String LeaseNo = jsonItem.getString("LeaseNo");
			Integer LeaseCarID = jsonItem.getInt("LeaseCarID");
			String LeaseCarNo = jsonItem.getString("LeaseCarNo");
			String LeaseCarModelName = jsonItem.getString("LeaseCarModelName");
			String LeaseCarModelAlias = jsonItem.getString("LeaseCarModelAlias");
			String LeaseCarModelIcon = jsonItem.getString("LeaseCarModelIcon");
			String LeaseCarModelImg = jsonItem.getString("LeaseCarModelImg");
			String LeaseTime = jsonItem.getString("LeaseTime");
			String LeaseTakeTime = jsonItem.getString("LeaseTakeTime");
			String LeaseTakeLoc = jsonItem.getString("LeaseTakeLoc");
			String LeaseBackTime = jsonItem.getString("LeaseBackTime");
			String LeaseBackLoc = jsonItem.getString("LeaseBackLoc");
			Integer UserID = jsonItem.getInt("UserID");
			String UserName = jsonItem.getString("UserName");
			String UserPhone = jsonItem.getString("UserPhone");
			
			Integer FaultID = jsonItem.getInt("FaultID");
			String FaultNo = jsonItem.getString("FaultNo");
			String FaultTime = jsonItem.getString("FaultTime");
			String FaultDetail = jsonItem.getString("FaultDetail");
			String FaultImg1 = jsonItem.getString("FaultImg1");
			String FaultImg2 = jsonItem.getString("FaultImg2");
			String FaultImg3 = jsonItem.getString("FaultImg3");
			Integer UserFault = jsonItem.getInt("UserFault");
			Integer FaultStatus = jsonItem.getInt("FaultStatus");
			
			Integer FaultBailID = jsonItem.getInt("FaultBailID");
			Double FaultBailFee = jsonItem.getDouble("FaultBailFee");
			Double FaultBailPay = jsonItem.getDouble("FaultBailPay");
			Integer FaultRepairID = jsonItem.getInt("FaultRepairID");
			String FaultRepairTime = jsonItem.getString("FaultRepairTime");
			String FaultRepairDetail = jsonItem.getString("FaultRepairDetail");
			Double FaultRepairFee = jsonItem.getDouble("FaultRepairFee");
			Double FaultUserFee = jsonItem.getDouble("FaultUserFee");
			Integer FaultUserFeeID = jsonItem.getInt("FaultUserFeeID");
			Double FaultBailUse = jsonItem.getDouble("FaultBailUse");
			Double FaultRepayBail = jsonItem.getDouble("FaultRepayBail");
			Double FaultUserPay = jsonItem.getDouble("FaultUserPay");
			String FaultUserPayTime = jsonItem.getString("FaultUserPayTime");
			
			
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("LeaseID", LeaseID);
			map.put("LeaseNo", LeaseNo);
			map.put("LeaseCarID", LeaseCarID);
			map.put("LeaseCarNo", LeaseCarNo);
			map.put("LeaseCarModelName", LeaseCarModelName);
			map.put("LeaseCarModelAlias", LeaseCarModelAlias);
			map.put("LeaseCarModelIcon", BusUtil.SERVICE_IP + LeaseCarModelIcon);
			map.put("LeaseCarModelImg", BusUtil.SERVICE_IP + LeaseCarModelImg);
			map.put("LeaseTime", LeaseTime);
			map.put("LeaseTakeTime", LeaseTakeTime);
			map.put("LeaseTakeLoc", LeaseTakeLoc);
			map.put("LeaseBackTime", LeaseBackTime);
			map.put("LeaseBackLoc", LeaseBackLoc);
			map.put("UserID", UserID);
			map.put("UserName", UserName);
			map.put("UserPhone", UserPhone);
			
			map.put("FaultID", FaultID);
			map.put("FaultNo", FaultNo);
			map.put("FaultTime", FaultTime);
			map.put("FaultDetail", FaultDetail);
			map.put("FaultImg1", FaultImg1);
			map.put("FaultImg2", FaultImg2);
			map.put("FaultImg3", FaultImg3);
			map.put("UserFault", UserFault);
			map.put("FaultStatus", FaultStatus);
			
			map.put("FaultBailID", FaultBailID);
			map.put("FaultBailFee", FaultBailFee);
			map.put("FaultBailPay", FaultBailPay);
			map.put("FaultRepairID", FaultRepairID);
			map.put("FaultRepairTime", FaultRepairTime);
			map.put("FaultRepairDetail", FaultRepairDetail);
			map.put("FaultRepairFee", FaultRepairFee);
			map.put("FaultUserFee", FaultUserFee);
			map.put("FaultUserFeeID", FaultUserFeeID);
			map.put("FaultBailUse", FaultBailUse);
			map.put("FaultRepayBail", FaultRepayBail);
			map.put("FaultUserPay", FaultUserPay);
			map.put("FaultUserPayTime", FaultUserPayTime);
			
			Faults.add(map);
		}
		result.setData(Faults);
		
		return result;
	}

	
	/**
	 * 因故障结束订单
	 */
	public BusResult finishLeaseByFault(Integer operatorID, Integer leaseID, Integer cancelFee, double couponFee,
			Integer addInFault, Integer payBail, double bailFee, String remark, String loginIP) {
		// TODO Auto-generated method stub
		BusResult result = new BusResult();
		
		JSONObject obj = new JSONObject();
		obj.putOpt("OptID", operatorID);
		obj.putOpt("LeaseID", leaseID);
		obj.putOpt("CancelFee", cancelFee);
		obj.putOpt("CouponFee", couponFee);
		obj.putOpt("AddInFault", addInFault);
		obj.putOpt("PayBail", payBail);
		obj.putOpt("BailFee", bailFee);
		obj.putOpt("Remark", remark);
		
        String url = BusUtil.BASE_IP+"Fault/FinishLeaseByFault/?UserID="+operatorID+"&UserType=1&UserIP="+loginIP;
        
        BusResult  jsonResult = JsonPostUtil.sendPost(url, obj.toString());
        String jsonStr = jsonResult.getData().toString();
		
        JSONObject jsonObject = new JSONObject(jsonStr);
		int status = jsonObject.getInt("Result");
		result.setStatus(status);
		Map<String, Object> map = new HashMap<String, Object>();
		if (status!=0) {
			return result;
		}
		Double LeaseFee = jsonObject.getDouble("LeaseFee");
		map.put("LeaseFee", LeaseFee);
	
		Double BailFee = jsonObject.getDouble("BailFee");
		map.put("BailFee", BailFee);
		
		result.setData(map);
		
		return result;
	}

	
	/**
	 * 故障维修完毕
	 */
	public BusResult faultRepaired(Integer operatorID, Integer faultID, String repairTime, String repairDetail,
			double repairFee, double userPayFee, String remark, String loginIP) {
		// TODO Auto-generated method stub
		BusResult result = new BusResult();
		
		JSONObject obj = new JSONObject();
		obj.putOpt("OptID", operatorID);
		obj.putOpt("FaultID", faultID);
		obj.putOpt("RepairTime", repairTime);
		obj.putOpt("RepairDetail", repairDetail);
		obj.putOpt("RepairFee", repairFee);
		obj.putOpt("UserPayFee", userPayFee);
		obj.putOpt("Remark", remark);
		
        String url = BusUtil.BASE_IP+"Fault/FaultRepaired/?UserID="+operatorID+"&UserType=1&UserIP="+loginIP;
        
        BusResult  jsonResult = JsonPostUtil.sendPost(url, obj.toString());
        String jsonStr = jsonResult.getData().toString();
		
        JSONObject jsonObject = new JSONObject(jsonStr);
		int status = jsonObject.getInt("Result");
		result.setStatus(status);
		Map<String, Object> map = new HashMap<String, Object>();
		if (status!=0) {
			return result;
		}
		Double BailPayFee = jsonObject.getDouble("BailPayFee");
		map.put("BailPayFee", BailPayFee);
	
		Double UserPayFee = jsonObject.getDouble("UserPayFee");
		map.put("UserPayFee", UserPayFee);
		
		result.setData(map);
		
		return result;
	}

	
	/**
	 * 故障到期客户仍不支付费用处理
	 */
	public BusResult faultUnPay(Integer operatorID, Integer faultID, Integer addPenalty, String penaltyReason,
			String loginIP) {
		// TODO Auto-generated method stub
		BusResult result = new BusResult();
		
		JSONObject obj = new JSONObject();
		obj.putOpt("OptID", operatorID);
		obj.putOpt("FaultID", faultID);
		obj.putOpt("AddPenalty", addPenalty);
		obj.putOpt("PenaltyReason", penaltyReason);
		
        String url = BusUtil.BASE_IP+"Fault/FaultUnPay/?UserID="+operatorID+"&UserType=1&UserIP="+loginIP;
        
        BusResult  jsonResult = JsonPostUtil.sendPost(url, obj.toString());
        String jsonStr = jsonResult.getData().toString();
		
        JSONObject jsonObject = new JSONObject(jsonStr);
		int status = jsonObject.getInt("Result");
		result.setStatus(status);
		
		return result;
	}

	//*****************************************
	
	/**
	 * 事故登记
	 */
	public BusResult addAccident(Integer operatorID, Integer userID, Integer leaseID, Integer carID, String acctTime,
			String acctBrief, String remark, String loginIP) {
		// TODO Auto-generated method stub
		BusResult result = new BusResult();
		
		JSONObject obj = new JSONObject();
		obj.putOpt("OptID", operatorID);
		obj.putOpt("UserID", userID);
		obj.putOpt("LeaseID", leaseID);
		obj.putOpt("CarID", carID);
		obj.putOpt("AcctTime", acctTime);
		obj.putOpt("AcctBrief", acctBrief);
		obj.putOpt("Remark", remark);
		
		
        String url = BusUtil.BASE_IP+"Accident/AddAccident/?UserID="+operatorID+"&UserType=1&UserIP="+loginIP;
        
        BusResult  jsonResult = JsonPostUtil.sendPost(url, obj.toString());
        String jsonStr = jsonResult.getData().toString();
		
        JSONObject jsonObject = new JSONObject(jsonStr);
		int status = jsonObject.getInt("Result");
		result.setStatus(status);
		
		if (status != 0) {
			return result;
		}
		Integer AcctID = jsonObject.getInt("AcctID");
		String AcctNo = jsonObject.getString("AcctNo");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("AcctID", AcctID);
		map.put("AcctNo", AcctNo);
		
		
		result.setData(map);
		return result;
	}
	
	
	
	
	
	
}
