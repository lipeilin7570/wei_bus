package com.wgjev.weibus.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.wgjev.weibus.dao.AccidentOrderMapper;
import com.wgjev.weibus.dao.FaultOrderMapper;
import com.wgjev.weibus.dao.IllegalOrderMapper;
import com.wgjev.weibus.dao.LeaseOrderMapper;
import com.wgjev.weibus.dao.OperatorSysMapper;
import com.wgjev.weibus.dao.UserRentalMapper;
import com.wgjev.weibus.dao.json.CheckOrderJsonMapper;
import com.wgjev.weibus.dao.json.LeaseOrderJsonMapper;
import com.wgjev.weibus.entity.AccidentOrder;
import com.wgjev.weibus.entity.BusResult;
import com.wgjev.weibus.entity.FaultOrder;
import com.wgjev.weibus.entity.IllegalOrder;
import com.wgjev.weibus.entity.LeaseOrder;
import com.wgjev.weibus.entity.OperatorSys;
import com.wgjev.weibus.entity.UserRental;
import com.wgjev.weibus.entity.json.CheckOrderJson;
import com.wgjev.weibus.entity.json.LeaseOrderJson;
import com.wgjev.weibus.service.OrderService;
import com.wgjev.weibus.util.BusUtil;
import com.wgjev.weibus.util.JsonPostUtil;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Resource
	private LeaseOrderMapper leaseOrderMapper;
	
	@Resource
	private LeaseOrderJsonMapper leaseOrderJsonMapper;
	
	@Resource
	private OperatorSysMapper operatorSysMapper;
	
	@Resource
	private IllegalOrderMapper illegalOrderMapper;
	
	@Resource
	private FaultOrderMapper faultOrderMapper;
	
	@Resource
	private AccidentOrderMapper accidentOrderMapper;
	
	@Resource
	private CheckOrderJsonMapper checkOrderJsonMapper;
	
	@Resource
	private UserRentalMapper userRentalMapper;
	
	/**
	 * 显示订单
	 */
	public BusResult loadAllLeaseOrder() {
		BusResult result = new BusResult();
		List<LeaseOrderJson> list = leaseOrderJsonMapper.loadAllLeaseOrderJson();
		result.setStatus(0);
		result.setData(list);
		
		return result;
	}
	
	/**
	 * 根据订单号显示预约订单
	 */
	public BusResult shouReserve(Integer leaseID) {
		BusResult result = new BusResult();
		
		
		return result;
	}
	
	/**
	 * 违章信息录入
	 */
	public BusResult addIllegal(Integer operatorID, Integer leaseID, String description, String address,
			String collectionUnit, String illegalTime, Integer points, double fine, String remark, String loginIP) {
		// TODO Auto-generated method stub
		BusResult result = new BusResult();
		OperatorSys operatorSys = operatorSysMapper.selectByPrimaryKey(operatorID);
		LeaseOrder leaseOrder = leaseOrderMapper.selectByPrimaryKey(leaseID);
		IllegalOrder illegalOrder = new IllegalOrder();
		illegalOrder.setIllegalno("auto");
		illegalOrder.setCarid(leaseOrder.getCarid());
		illegalOrder.setCarno(leaseOrder.getCarno());
		illegalOrder.setRentaluserid(leaseOrder.getRentaluserid());
		illegalOrder.setRentalusername(leaseOrder.getRentalusername());
		illegalOrder.setTelphone(leaseOrder.getTelphone());
		illegalOrder.setLeaseid(leaseID);
		illegalOrder.setCreatetime(new Date());
		if (description != null) {
			illegalOrder.setDescription(description);
		}
		if (address != null) {
			illegalOrder.setAddress(address);
		}
		if (collectionUnit != null) {
			illegalOrder.setCollectionunit(collectionUnit);
		}
		if (illegalTime != null) {
			illegalOrder.setIllegaltime(BusUtil.stringToDateTime(illegalTime));
		}
		if (points != null) {
			illegalOrder.setPoints(points);
		}
		if (fine > 0) {
			illegalOrder.setFine(new BigDecimal(fine));
		}
		illegalOrder.setSysoptid(operatorID);
		illegalOrder.setSysoptname(operatorSys.getSysusename());
		if (remark != null) {
			illegalOrder.setRemark(remark);
		}
		illegalOrder.setStatus(1);
		
		illegalOrderMapper.insertSelective(illegalOrder);
		result.setStatus(0);
		
		return result;
	}

	
	/**
	 * 故障信息录入
	 */
	public BusResult addFault(Integer operatorID, Integer leaseID, String faultTime, Integer faultDuty,
			String description, String remark, String loginIP) {
		// TODO Auto-generated method stub
		BusResult result = new BusResult();
		OperatorSys operatorSys = operatorSysMapper.selectByPrimaryKey(operatorID);
		LeaseOrder leaseOrder = leaseOrderMapper.selectByPrimaryKey(leaseID);
		FaultOrder faultOrder = new FaultOrder();
		faultOrder.setFaultno("auto");
		faultOrder.setCreatetime(new Date());
		faultOrder.setCarid(leaseOrder.getCarid());
		faultOrder.setCarno(leaseOrder.getCarno());
		faultOrder.setRentaluserid(leaseOrder.getRentaluserid());
		faultOrder.setRentalusername(leaseOrder.getRentalusername());
		faultOrder.setTelphone(leaseOrder.getTelphone());
		faultOrder.setLeaseid(leaseID);
		faultOrder.setSysoptid(operatorID);
		faultOrder.setSysoptname(operatorSys.getSysusename());
		if (faultTime != null) {
			faultOrder.setFaulttime(BusUtil.stringToDateTime(faultTime));
		}
		if (faultDuty != null) {
			faultOrder.setFaultduty(faultDuty);
		}
		if (description != null) {
			faultOrder.setDescription(description);
		}
		if (remark != null) {
			faultOrder.setRemark(remark);
		}
		faultOrder.setStatus(1);
		faultOrderMapper.insertSelective(faultOrder);
		
		//车辆的状态处理
		
		//订单状态的处理
		
		//人为原因，充值保证金
		
		result.setStatus(0);
		return result;
	}

	/**
	 * 事故信息录入
	 */
	public BusResult addAccident(Integer operatorID, Integer leaseID, String accidentTime, Integer accidentDuty,
			String description, String remark, String loginIP) {
		// TODO Auto-generated method stub
		BusResult result = new BusResult();
		OperatorSys operatorSys = operatorSysMapper.selectByPrimaryKey(operatorID);
		LeaseOrder leaseOrder = leaseOrderMapper.selectByPrimaryKey(leaseID);
		AccidentOrder accidentOrder = new AccidentOrder();
		accidentOrder.setAccidentno("auto");
		accidentOrder.setCreatetime(new Date());
		accidentOrder.setCarid(leaseOrder.getCarid());
		accidentOrder.setCarno(leaseOrder.getCarno());
		accidentOrder.setRentaluserid(leaseOrder.getRentaluserid());
		accidentOrder.setRentalusername(leaseOrder.getRentalusername());
		accidentOrder.setTelphone(leaseOrder.getTelphone());
		accidentOrder.setLeaseid(leaseID);
		accidentOrder.setSysoptid(operatorSys.getSysoperatorid());
		accidentOrder.setSysoptname(operatorSys.getSysusename());
		if (accidentTime != null) {
			accidentOrder.setAccidenttime(BusUtil.stringToDateTime(accidentTime));
		}
		if (accidentDuty != null) {
			accidentOrder.setAccidentduty(accidentDuty);
		}
		if (description != null) {
			accidentOrder.setDescription(description);
		}
		if (remark != null) {
			accidentOrder.setRemark(remark);
		}
		//保证金的缴纳
		
		//订单状态的修改
		
		//车辆状态的修改
		
		result.setStatus(0);
		return result;
	}

	/**
	 * 查看订单的验车信息
	 */
	public BusResult findCheckOrderByLeaseID(Integer leaseID) {
		// TODO Auto-generated method stub
		BusResult result = new BusResult();
		CheckOrderJson checkOrderJson = checkOrderJsonMapper.showCheckOrderByLeaseID(leaseID);
		if (checkOrderJson == null) {
			result.setStatus(101);
			return result;
		}
		
		result.setStatus(0);
		result.setData(checkOrderJson);
		return result;
	}
	
	/**
	 * 还车
	 */
	public BusResult backCar(Integer operatorID, Integer leaseID, Integer siteID, String remark, String backTime, String loginIP) {
		// TODO Auto-generated method stub
		BusResult result = new BusResult();

		LeaseOrder leaseOrder = leaseOrderMapper.selectByPrimaryKey(leaseID);
		
		JSONObject obj = new JSONObject();
        obj.putOpt("LeaseID", leaseID);
        obj.putOpt("OptID", operatorID);
        obj.putOpt("SiteID", siteID);
        obj.putOpt("Remark", remark);
        obj.putOpt("BackTime", backTime);
        
        
        String url = BusUtil.BASE_IP+"Rent/BackCarByOpt/?UserID="+operatorID+"&UserType=1&UserIP="+loginIP;
        BusResult  jsonResult = JsonPostUtil.sendPost(url, obj.toString());
        String jsonStr = jsonResult.getData().toString();
        JSONObject jsonObject;
		
		jsonObject = new JSONObject(jsonStr);
		int status = jsonObject.getInt("Result");
		result.setStatus(status);
		if (status == 0) {
			//用户租车状态：0正常，1预约中，2租车中
			UserRental userRental = userRentalMapper.selectByPrimaryKey(leaseOrder.getRentaluserid());
			userRental.setRentalstatusint(0);
			userRentalMapper.updateByPrimaryKeySelective(userRental);
		}
		
		result.setStatus(0);
		return result;
	}

	/**
	 * 强行结束订单
	 */
	public BusResult finishOrder(Integer operatorID, Integer leaseID, Integer finishType, Integer cancelFee,
			double couponFee, String remark, String finishTime, String loginIP) {
		// TODO Auto-generated method stub
		BusResult result = new BusResult();
//		LeaseOrder leaseOrder = leaseOrderMapper.selectByPrimaryKey(leaseID);
//		CheckOrder checkOrder = checkOrderMapper.findCheckOrderByLeaseID(leaseID);
		
		JSONObject obj = new JSONObject();
        obj.putOpt("LeaseID", leaseID);
        obj.putOpt("OperatorID", operatorID);
        obj.putOpt("FinishType", finishType);
        obj.putOpt("CancelFee", cancelFee);
        if (cancelFee == 3) {
        	obj.putOpt("CouponFee", couponFee);
		}
        obj.putOpt("Remark", remark);
        obj.putOpt("FinishTime", finishTime);
        
        String url = BusUtil.BASE_IP+"Rent/FinishLease/?UserID="+operatorID+"&UserType=1&UserIP="+loginIP;
        BusResult  jsonResult = JsonPostUtil.sendPost(url, obj.toString());
        String jsonStr = jsonResult.getData().toString();
        JSONObject jsonObject;
		
		jsonObject = new JSONObject(jsonStr);
		int status = jsonObject.getInt("Result");
		result.setStatus(status);
		
		
		result.setStatus(0);
		return result;
	}
	
	
}
