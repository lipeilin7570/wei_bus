package com.wgjev.weibus.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.wgjev.weibus.dao.json.ExtractJsonMapper;
import com.wgjev.weibus.entity.BusResult;
import com.wgjev.weibus.entity.json.ExtractJson;
import com.wgjev.weibus.service.AccountService;
import com.wgjev.weibus.util.BusUtil;
import com.wgjev.weibus.util.JsonPostUtil;

@Service
public class AccountServiceImpl implements AccountService {

	@Resource
	private ExtractJsonMapper extractJsonMapper;
	
	/**
	 * 加载提现申请信息
	 */
	public BusResult loadExtract() {
		// TODO Auto-generated method stub
		BusResult result = new BusResult();
		List<ExtractJson> list = extractJsonMapper.loadExtract();
		result.setStatus(0);
		result.setData(list);
		
		return result;
	}
	

	/**
	 * 查询交易记录
	 */
	public BusResult queryDeals(Integer operatorID, String beginTime, String endTime, Integer userID, Integer dealType,
			Integer tradeType, Integer tradeAccount, String loginIP) {
		// TODO Auto-generated method stub
		BusResult result = new BusResult();
		
		JSONObject obj = new JSONObject();
		obj.putOpt("BeginTime", beginTime);
		obj.putOpt("EndTime", endTime);
		obj.putOpt("UserID", userID);
		obj.putOpt("DealType", dealType);
		obj.putOpt("TradeType", tradeType);
		obj.putOpt("TradeAccount", tradeAccount);
		
		
        String url = BusUtil.BASE_IP+"Finance/QueryDeals/?UserID="+operatorID+"&UserType=1&UserIP="+loginIP;
        
        BusResult  jsonResult = JsonPostUtil.sendPost(url, obj.toString());
        String jsonStr = jsonResult.getData().toString();
		
        JSONObject jsonObject = new JSONObject(jsonStr);
		int status = jsonObject.getInt("Result");
		result.setStatus(status);
		if (status != 0) {
			return result;
		}
		List<Map<String, Object>> Illegals = new ArrayList<Map<String,Object>>();
		JSONArray Deals = jsonObject.getJSONArray("Deals");
		for (int i = 0; i < Deals.length(); i++) {
			JSONObject jsonItem = Deals.getJSONObject(i);

			String DealNo = jsonItem.getString("DealNo");
			String LeaseNo = jsonItem.getString("LeaseNo");
			String DealTime = jsonItem.getString("DealTime");
			String UserName = jsonItem.getString("UserName");
			String UserTel = jsonItem.getString("UserTel");
			Integer DealType = jsonItem.getInt("DealType");
			Double DealMoney = jsonItem.getDouble("DealMoney");
			Integer TradeAccount = jsonItem.getInt("TradeAccount");
			String State = jsonItem.getString("State");
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("DealNo", DealNo);
			map.put("LeaseNo", LeaseNo);
			map.put("DealTime", DealTime);
			map.put("UserName", UserName);
			map.put("UserTel", UserTel);
			map.put("DealType", DealType);
			map.put("DealMoney", DealMoney);
			map.put("TradeAccount", TradeAccount);
			map.put("State", State);
			
			Illegals.add(map);
		}
		result.setData(Illegals);
		
		return result;
	}

	/**
	 * 查询账户余额列表
	 */
	public BusResult queryBalances(Integer operatorID, Integer order, String loginIP) {
		// TODO Auto-generated method stub
		BusResult result = new BusResult();
		
		JSONObject obj = new JSONObject();
		obj.putOpt("Order", order);
		
		
        String url = BusUtil.BASE_IP+"Finance/QueryBalancels/?UserID="+operatorID+"&UserType=1&UserIP="+loginIP;
        
        BusResult  jsonResult = JsonPostUtil.sendPost(url, obj.toString());
        String jsonStr = jsonResult.getData().toString();
		
        JSONObject jsonObject = new JSONObject(jsonStr);
		int status = jsonObject.getInt("Result");
		result.setStatus(status);
		
		if (status != 0) {
			return result;
		}
		List<Map<String, Object>> Illegals = new ArrayList<Map<String,Object>>();
		JSONArray Balances = jsonObject.getJSONArray("Balances");
		for (int i = 0; i < Balances.length(); i++) {
			JSONObject jsonItem = Balances.getJSONObject(i);
			Integer UserID = jsonItem.getInt("UserID");
			String UserName = jsonItem.getString("UserName");
			String UserTel = jsonItem.getString("UserTel");
			String UpdateTime = jsonItem.getString("UpdateTime");
			Double FeeMoney = jsonItem.getDouble("FeeMoney");
			Double FreezeMoney = jsonItem.getDouble("FreezeMoney");
			Double AcctBalance = jsonItem.getDouble("AcctBalance");
			Double Pledge = jsonItem.getDouble("Pledge");
			Integer CouponCount = jsonItem.getInt("CouponCount");
			Double CouponMoney = jsonItem.getDouble("CouponMoney");
			
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("UserID", UserID);
			map.put("UserName", UserName);
			map.put("UserTel", UserTel);
			map.put("UpdateTime", UpdateTime);
			map.put("FeeMoney", FeeMoney);
			map.put("AcctBalance", AcctBalance);
			map.put("FreezeMoney", FreezeMoney);
			map.put("Pledge", Pledge);
			map.put("CouponCount", CouponCount);
			map.put("CouponMoney", CouponMoney);
			
			Illegals.add(map);
		}
		result.setData(Illegals);
		
		return result;
	}

	
	/**
	 * 审核提现
	 */
	public BusResult auditExtract(Integer operatorID, Integer extractID, Integer auditStatus, String failReason,
			String loginIP) {
		// TODO Auto-generated method stub
		BusResult result = new BusResult();
		
		JSONObject obj = new JSONObject();
		obj.putOpt("OptID", operatorID);
		obj.putOpt("ExtractID", extractID);
		obj.putOpt("AuditStatus", auditStatus);
		obj.putOpt("FailReason", failReason);
		
		
        String url = BusUtil.BASE_IP+"Extract/AuditExtract/?UserID="+operatorID+"&UserType=1&UserIP="+loginIP;
        
        BusResult  jsonResult = JsonPostUtil.sendPost(url, obj.toString());
        String jsonStr = jsonResult.getData().toString();
		
        JSONObject jsonObject = new JSONObject(jsonStr);
		int status = jsonObject.getInt("Result");
		result.setStatus(status);
		
		return result;
	}
	
	
	
}
