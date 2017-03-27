package com.wgjev.weibus.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wgjev.weibus.dao.OperatorSysMapper;
import com.wgjev.weibus.dao.PriceFinanceMapper;
import com.wgjev.weibus.dao.json.PriceJsonMapper;
import com.wgjev.weibus.entity.BusResult;
import com.wgjev.weibus.entity.OperatorSys;
import com.wgjev.weibus.entity.PriceFinance;
import com.wgjev.weibus.entity.json.PriceJson;
import com.wgjev.weibus.service.PriceService;

@Service
public class PriceServiceImpl implements PriceService {
	
	@Resource
	private PriceFinanceMapper priceFinanceMapper;
	
	@Resource
	private PriceJsonMapper priceJsonMapper;
	
	@Resource
	private OperatorSysMapper operatorSysMapper;
	
	
	/**
	 * 显示公司的价格表
	 */
	public BusResult loadAllPriceByCompanyID(int companyID) {
		// TODO Auto-generated method stub
		BusResult result = new BusResult();
		List<PriceJson> list;
		System.out.println(companyID);
		if (companyID == 0) {
			list = priceJsonMapper.loadAllPrice();
		}else {
			list = priceJsonMapper.loadAllPriceByCompanyID(new Integer(companyID));
		}
		result.setStatus(0);
		result.setData(list);
		
		return result;
	}

	/**
	 * 调价
	 */
	public BusResult changeCompanyPrice(Integer operatorID, Integer priceID, Integer priceVersion, 
			String priceName, Integer carModel, double hourPrice, double startPrice, Integer freeTime, double dayPrice, 
			double nightPrice, double weekPrice, double hourMileage, double dayMileage, double nightMileage, double weekMileage, 
			double superPrice, String dayBeginTime, String dayEndTime, Integer startCharge) {
		// TODO Auto-generated method stub
		BusResult result = new BusResult();
		PriceFinance oldPrice = priceFinanceMapper.selectByPrimaryKey(priceID);
		PriceFinance newPrice = new PriceFinance();
		OperatorSys operatorSys = operatorSysMapper.selectByPrimaryKey(operatorID);
		
		if (priceVersion > oldPrice.getPriceversion()) {
			newPrice.setPriceversion(priceVersion);
		}else {
			result.setStatus(101);
			return result;
		}
		
		if (priceName != null) {
			newPrice.setPricename(priceName);
		}else {
			newPrice.setPricename(oldPrice.getPricename());
		}
		
		
		if (carModel != null) {
			newPrice.setCarmodel(carModel);
		}else {
			newPrice.setCarmodel(oldPrice.getCarmodel());
		}
		
		if (hourPrice > 0) {
			newPrice.setHourprice(new BigDecimal(hourPrice));
		}else {
			newPrice.setHourprice(oldPrice.getHourprice());
		}
		
		if (startPrice > 0) {
			newPrice.setStartprice(new BigDecimal(startPrice));	
		}else {
			newPrice.setStartprice(oldPrice.getStartprice());	
		}
		
		if (freeTime > 0) {
			newPrice.setFreetime(freeTime);
		}else {
			newPrice.setFreetime(oldPrice.getFreetime());
		}
		
		if (dayPrice > 0) {
			newPrice.setDayprice(new BigDecimal(dayPrice));
		}else {
			newPrice.setDayprice(oldPrice.getDayprice());
		}
		
		if (nightPrice > 0) {
			newPrice.setNightprice(new BigDecimal(nightPrice));
		}else {
			newPrice.setNightprice(oldPrice.getNightprice());
		}
		
		if (weekPrice > 0) {
			newPrice.setWeekprice(new BigDecimal(weekPrice));
		}else {
			newPrice.setWeekprice(oldPrice.getWeekprice());
		}
		
		if (hourMileage > 0) {
			newPrice.setHourmileage(new BigDecimal(hourMileage));
		}else {
			newPrice.setHourmileage(oldPrice.getHourmileage());
		}
		
		if (dayMileage > 0) {
			newPrice.setDaymileage(new BigDecimal(dayMileage));
		}else {
			newPrice.setDaymileage(oldPrice.getDaymileage());
		}
		
		if (weekMileage > 0) {
			newPrice.setWeekmileage(new BigDecimal(weekMileage));
		}else {
			newPrice.setWeekmileage(oldPrice.getWeekmileage());
		}
		
		if (superPrice > 0) {
			newPrice.setSuperprice(new BigDecimal(superPrice));
		}else {
			newPrice.setSuperprice(oldPrice.getSuperprice());
		}
		
		if (dayBeginTime != null) {
			newPrice.setDaybegintime(dayBeginTime);
		}else {
			newPrice.setDaybegintime(oldPrice.getDaybegintime());
		}
		
		if (dayEndTime != null) {
			newPrice.setDayendtime(dayEndTime);
		}else {
			newPrice.setDayendtime(oldPrice.getDayendtime());
		}
		
		if (startCharge > 0) {
			newPrice.setStartcharge(startCharge);
		}else {
			newPrice.setStartcharge(oldPrice.getStartcharge());
		}
		
		newPrice.setCompanyid(oldPrice.getCompanyid());
		newPrice.setOldpriceid(oldPrice.getPriceid());
		newPrice.setCreatemanid(operatorID);
		newPrice.setCreateman(operatorSys.getSysusename());
		
		newPrice.setCreatetime(new Date());
		newPrice.setStatus(1);
		newPrice.setNewstatus(1);
		priceFinanceMapper.insertSelective(newPrice);
		oldPrice.setStatus(2);
		oldPrice.setNewstatus(0);
		priceFinanceMapper.updateByPrimaryKeySelective(oldPrice);
		
		result.setStatus(0);
		return result;
	}

	/**
	 * 查看价格详情
	 */
	public BusResult findPriceByPriceID(int priceID) {
		// TODO Auto-generated method stub
		BusResult result = new BusResult();
		PriceJson priceJson = priceJsonMapper.findPriceByPriceID(new Integer(priceID));
		result.setStatus(0);
		result.setData(priceJson);
		return result;
	}
	
	/**
	 * 新增价格信息
	 */
	public BusResult addCompanyPrice(Integer operatorID, Integer companyID, String priceName, Integer carModel,
			double hourPrice, double startPrice, Integer freeTime, double dayPrice, double nightPrice, double weekPrice,
			double hourMileage, double dayMileage, double nightMileage, double weekMileage, double superPrice,
			String dayBeginTime, String dayEndTime, Integer startCharge) {
		// TODO Auto-generated method stub
		BusResult result = new BusResult();
		
		PriceFinance newPrice = new PriceFinance();
		OperatorSys operatorSys = operatorSysMapper.selectByPrimaryKey(operatorID);
		
		newPrice.setPriceversion(1);
		
		if (priceName != null) {
			newPrice.setPricename(priceName);
		}
		if (carModel != null) {
			newPrice.setCarmodel(carModel);
		}if (hourPrice > 0) {
			newPrice.setHourprice(new BigDecimal(hourPrice));
		}
		if (startPrice > 0) {
			newPrice.setStartprice(new BigDecimal(startPrice));	
		}
		if (freeTime > 0) {
			newPrice.setFreetime(freeTime);
		}
		if (dayPrice > 0) {
			newPrice.setDayprice(new BigDecimal(dayPrice));
		}
		if (nightPrice > 0) {
			newPrice.setNightprice(new BigDecimal(nightPrice));
		}
		if (weekPrice > 0) {
			newPrice.setWeekprice(new BigDecimal(weekPrice));
		}
		if (hourMileage > 0) {
			newPrice.setHourmileage(new BigDecimal(hourMileage));
		}
		if (dayMileage > 0) {
			newPrice.setDaymileage(new BigDecimal(dayMileage));
		}
		if (weekMileage > 0) {
			newPrice.setWeekmileage(new BigDecimal(weekMileage));
		}
		if (superPrice > 0) {
			newPrice.setSuperprice(new BigDecimal(superPrice));
		}
		if (dayBeginTime != null) {
			newPrice.setDaybegintime(dayBeginTime);
		}
		if (dayEndTime != null) {
			newPrice.setDayendtime(dayEndTime);
		}
		if (startCharge > 0) {
			newPrice.setStartcharge(startCharge);
		}
		newPrice.setCompanyid(companyID);
		newPrice.setCreatemanid(operatorID);
		newPrice.setCreateman(operatorSys.getSysusename());
		
		newPrice.setCreatetime(new Date());
		newPrice.setStatus(1);
		newPrice.setNewstatus(1);
		priceFinanceMapper.insertSelective(newPrice);
		
		result.setStatus(0);
		return result;
	}
	
	

}
