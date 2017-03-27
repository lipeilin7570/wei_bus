package com.wgjev.weibus.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.wgjev.weibus.dao.CompanyInfoMapper;
import com.wgjev.weibus.dao.json.CompanyJsonMapper;
import com.wgjev.weibus.entity.BusResult;
import com.wgjev.weibus.entity.CompanyInfo;
import com.wgjev.weibus.entity.json.CompanyJson;
import com.wgjev.weibus.service.CompanyService;
import com.wgjev.weibus.util.BusUtil;
import com.wgjev.weibus.util.JsonPostUtil;

@Service
public class CompanyServiceImpl implements CompanyService {
	
	@Resource
	private CompanyInfoMapper companyInfoMapper;
	
	@Resource
	private CompanyJsonMapper companyJsonMapper;
	
	/**
	 * 加载所有公司信息
	 * @return
	 */
	public BusResult loadCompanies() {
		// TODO Auto-generated method stub
		BusResult result = new BusResult();
		List<CompanyJson> list = companyJsonMapper.loadAllCompanyJson();
		
		result.setStatus(0);
		result.setData(list);
		return result;
	}

	/**
	 * 增加公司信息
	 */
	public BusResult addCompany(Integer operatorID, String address, String companyName, String shortName, Integer parentID, String companyPhone, 
			String contacts, String zcode, Integer companyCode, String remark, Integer regionStatus, double lng, double lat) {
		// TODO Auto-generated method stub
		BusResult result = new BusResult();
		int order;
		List<CompanyInfo> list = companyInfoMapper.loadCompanies();
		if (list == null) {
			order = 1;
		}else {
			order = list.size()+1;
		}
		CompanyInfo companyInfo = new CompanyInfo();
		if (address != null) {
			companyInfo.setAddress(address);
		}
		if (companyName != null) {
			companyInfo.setCompanyname(companyName);
		}
		if (shortName != null) {
			companyInfo.setShortname(shortName);
		}
		if (parentID != null) {
			companyInfo.setPartentid(parentID);
		}
		if (companyPhone != null) {
			companyInfo.setCompanyphone(companyPhone);
		}
		if (contacts != null) {
			companyInfo.setContacts(contacts);
		}
		if (zcode != null) {
			companyInfo.setZcode(zcode);
		}
		if (companyCode != null) {
			companyInfo.setConpanycode(companyCode);
		}
		if (remark != null) {
			companyInfo.setRemark(remark);
		}
		companyInfo.setCompanyorder(new Integer(order));
		
		if (regionStatus != null) {
			companyInfo.setRegionstatus(regionStatus);
		}
		if (lng > 0) {
			companyInfo.setLongitude(new BigDecimal(lng));
		}
		if (lat > 0) {
			companyInfo.setLatitude(new BigDecimal(lat));
		}
		companyInfo.setCreatetime(new Date());
		companyInfo.setStatus(1);
		
		companyInfoMapper.insertSelective(companyInfo);
		result.setStatus(0);
		return result;
	}

	/**
	 * 修改公司信息
	 */
	public BusResult changeCompany(Integer operatorID, String address, Integer companyID, String companyName, String shortName, Integer parentID, String companyPhone, 
			String contacts, String zcode, Integer companyCode, String remark, Integer regionStatus, double lng, double lat, Integer status) {
		// TODO Auto-generated method stub
		BusResult result = new BusResult();
		CompanyInfo companyInfo = new CompanyInfo();
		companyInfo.setCompanyid(companyID);
		if (address != null) {
			companyInfo.setAddress(address);
		}
		if (companyName != null) {
			companyInfo.setCompanyname(companyName);
		}
		if (shortName != null) {
			companyInfo.setShortname(shortName);
		}
		if (parentID != null) {
			companyInfo.setPartentid(parentID);
		}
		if (companyPhone != null) {
			companyInfo.setCompanyphone(companyPhone);
		}
		if (contacts != null) {
			companyInfo.setContacts(contacts);
		}
		if (zcode != null) {
			companyInfo.setZcode(zcode);
		}
		if (companyCode != null) {
			companyInfo.setConpanycode(companyCode);
		}
		if (remark != null) {
			companyInfo.setRemark(remark);
		}
		if (regionStatus != null) {
			companyInfo.setRegionstatus(regionStatus);
		}
		if (lng > 0) {
			companyInfo.setLongitude(new BigDecimal(lng));
		}
		if (lat > 0) {
			companyInfo.setLatitude(new BigDecimal(lat));
		}
		if (status != null) {
			companyInfo.setStatus(status);
		}
		
		companyInfoMapper.updateByPrimaryKeySelective(companyInfo);
		result.setStatus(0);
		return result;
	}

	/**
	 * 删除公司信息
	 * @param companyID
	 * @param status
	 * @return
	 */
	public BusResult delCompany(Integer companyID, Integer status) {
		// TODO Auto-generated method stub
		BusResult result = new BusResult();
		CompanyInfo companyInfo = new CompanyInfo();
		companyInfo.setCompanyid(companyID);
		companyInfo.setStatus(status);
		
		companyInfoMapper.updateByPrimaryKeySelective(companyInfo);
		result.setStatus(0);
		return result;
	}

	/**
	 * 查询公司的运营信息
	 */
	public BusResult queryRuns(Integer operatorID, Integer companyID, String loginIP, String beginDate, String endDate) {
		// TODO Auto-generated method stub
		BusResult result = new BusResult();
		
		JSONObject obj = new JSONObject();
        obj.putOpt("OptID", operatorID);
        obj.putOpt("CompanyID", companyID);
        if (beginDate != null && beginDate != "") {
        	obj.putOpt("BeginDate", beginDate);
		}
        if (endDate != null && endDate != "") {
        	obj.putOpt("EndDate", endDate);
		}
        
        String url = BusUtil.BASE_IP+"Info/QueryRuns/?UserID="+operatorID+"&UserType=1&UserIP="+loginIP;
        
        BusResult  jsonResult = JsonPostUtil.sendPost(url, obj.toString());
        String jsonStr = jsonResult.getData().toString();
        
        JSONObject jsonObject = new JSONObject(jsonStr);
		int status = jsonObject.getInt("Result");
		result.setStatus(status);
		if (status != 0) {
			return result;
		}
		Integer UserAll = jsonObject.getInt("UserAll");
		Integer UserReged = jsonObject.getInt("UserReged");
		Integer UserReging = jsonObject.getInt("UserReging");
		Integer UserAdd = jsonObject.getInt("UserAdd");
		Integer UserAddReged = jsonObject.getInt("UserAddReged");
		Integer UserAddReging = jsonObject.getInt("UserAddReging");
		Integer LeaseReserve = jsonObject.getInt("LeaseReserve");
		Integer LeaseGet = jsonObject.getInt("LeaseGet");
		Integer LeaseCancel = jsonObject.getInt("LeaseCancel");
		Double LeaseFee = jsonObject.getDouble("LeaseFee");
		Double LeaseCoupon = jsonObject.getDouble("LeaseCoupon");
		Double LeasePay = jsonObject.getDouble("LeasePay");
		Integer LeaseAddReserve = jsonObject.getInt("LeaseAddReserve");
		Integer LeaseAddGet = jsonObject.getInt("LeaseAddGet");
		Integer LeaseAddCancel = jsonObject.getInt("LeaseAddCancel");
		Double LeaseAddFee = jsonObject.getDouble("LeaseAddFee");
		Double LeaseAddCoupon = jsonObject.getDouble("LeaseAddCoupon");
		Double LeaseAddPay = jsonObject.getDouble("LeaseAddPay");
		Integer CarAll = jsonObject.getInt("CarAll");
		Integer CarActive = jsonObject.getInt("CarActive");
		Integer CarUnActive = jsonObject.getInt("CarUnActive");
		Integer CarOnline = jsonObject.getInt("CarOnline");
		Integer CarOffline = jsonObject.getInt("CarOffline");
		Integer CarCharging = jsonObject.getInt("CarCharging");
		Integer CouponCount = jsonObject.getInt("CouponCount");
		Double CouponFee = jsonObject.getDouble("CouponFee");
		Integer CouponAddCount = jsonObject.getInt("CouponAddCount");
		Double CouponAddFee = jsonObject.getDouble("CouponAddFee");
		Double AccountAllBalance = jsonObject.getDouble("AccountAllBalance");
		Double AccountAllBail = jsonObject.getDouble("AccountAllBail");
		Integer IllegalCheck = jsonObject.getInt("IllegalCheck");
		Integer IllegalAll = jsonObject.getInt("IllegalAll");
		Integer IllegalDealed = jsonObject.getInt("IllegalDealed");
		Integer IllegalDealing = jsonObject.getInt("IllegalDealing");
		Integer IllegalUnDeal = jsonObject.getInt("IllegalUnDeal");
		Integer IllegalAdd = jsonObject.getInt("IllegalAdd");
		Integer FaultAll = jsonObject.getInt("FaultAll");
		Integer FaultDealed = jsonObject.getInt("FaultDealed");
		Integer FaultDealing = jsonObject.getInt("FaultDealing");
		Integer FaultUnDeal = jsonObject.getInt("FaultUnDeal");
		Integer FaultAdd = jsonObject.getInt("FaultAdd");
		Integer AccidentAll = jsonObject.getInt("AccidentAll");
		Integer AccidentDealed = jsonObject.getInt("AccidentDealed");
		Integer AccidentDealing = jsonObject.getInt("AccidentDealing");
		Integer AccidentUnDeal = jsonObject.getInt("AccidentUnDeal");
		Integer AccidentAdd = jsonObject.getInt("AccidentAdd");
		
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("UserAll", UserAll);
		map.put("UserReged", UserReged);
		map.put("UserReging", UserReging);
		map.put("UserAdd", UserAdd);
		map.put("UserAddReged", UserAddReged);
		map.put("UserAddReging", UserAddReging);
		map.put("LeaseReserve", LeaseReserve);
		map.put("LeaseGet", LeaseGet);
		map.put("LeaseCancel", LeaseCancel);
		map.put("LeaseFee", LeaseFee);
		map.put("LeaseCoupon", LeaseCoupon);
		map.put("LeasePay", LeasePay);
		map.put("LeaseAddReserve", LeaseAddReserve);
		map.put("LeaseAddGet", LeaseAddGet);
		map.put("LeaseAddCancel", LeaseAddCancel);
		map.put("LeaseAddFee", LeaseAddFee);
		map.put("LeaseAddCoupon", LeaseAddCoupon);
		map.put("LeaseAddPay", LeaseAddPay);
		map.put("CarAll", CarAll);
		map.put("CarActive", CarActive);
		map.put("CarUnActive", CarUnActive);
		map.put("CarOnline", CarOnline);
		map.put("CarOffline", CarOffline);
		map.put("CarCharging", CarCharging);
		map.put("CouponCount", CouponCount);
		map.put("CouponFee", CouponFee);
		map.put("CouponAddCount", CouponAddCount);
		map.put("CouponAddFee", CouponAddFee);
		map.put("AccountAllBalance", AccountAllBalance);
		map.put("AccountAllBail", AccountAllBail);
		map.put("IllegalCheck", IllegalCheck);
		map.put("IllegalAll", IllegalAll);
		map.put("IllegalDealed", IllegalDealed);
		map.put("IllegalDealing", IllegalDealing);
		map.put("IllegalUnDeal", IllegalUnDeal);
		map.put("IllegalAdd", IllegalAdd);
		map.put("FaultAll", FaultAll);
		map.put("FaultDealed", FaultDealed);
		map.put("FaultDealing", FaultDealing);
		map.put("FaultUnDeal", FaultUnDeal);
		map.put("FaultAdd", FaultAdd);
		map.put("AccidentAll", AccidentAll);
		map.put("AccidentDealed", AccidentDealed);
		map.put("AccidentDealing", AccidentDealing);
		map.put("AccidentUnDeal", AccidentUnDeal);
		map.put("AccidentAdd", AccidentAdd);
		
		result.setData(map);
		return result;
	}

}
