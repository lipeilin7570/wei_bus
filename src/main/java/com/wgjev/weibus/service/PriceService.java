package com.wgjev.weibus.service;


import com.wgjev.weibus.entity.BusResult;

public interface PriceService {
	
	/**
	 * 显示公司的价格表
	 * @param companyID
	 * @return
	 */
	public BusResult loadAllPriceByCompanyID(int companyID);
	
	/**
	 * 调价
	 * @param companyID
	 * @param operatorID
	 * @param priceID
	 * @param priceVersion
	 * @param priceName
	 * @param carModel
	 * @param hourPrice
	 * @param startPrice
	 * @param freeTime
	 * @param dayPrice
	 * @param nightPrice
	 * @param weekPrice
	 * @param hourMileage
	 * @param dayMileage
	 * @param weekMileage
	 * @param superPrice
	 * @param dayBeginTime
	 * @param dayEndTime
	 * @param startCharge
	 * @return
	 */
	public BusResult changeCompanyPrice(Integer operatorID, Integer priceID, Integer priceVersion, 
			String priceName, Integer carModel, double hourPrice, double startPrice, Integer freeTime, double dayPrice, 
			double nightPrice, double weekPrice, double hourMileage, double dayMileage, double nightMileage, double weekMileage, 
			double superPrice, String dayBeginTime, String dayEndTime, Integer startCharge);
	
	/**
	 * 查看价格详情
	 * @param priceID
	 * @return
	 */
	public BusResult findPriceByPriceID(int priceID);
	
	/**
	 * 新增价格信息
	 * @param operatorID
	 * @param companyID
	 * @param priceName
	 * @param carModel
	 * @param hourPrice
	 * @param startPrice
	 * @param freeTime
	 * @param dayPrice
	 * @param nightPrice
	 * @param weekPrice
	 * @param hourMileage
	 * @param dayMileage
	 * @param nightMileage
	 * @param weekMileage
	 * @param superPrice
	 * @param dayBeginTime
	 * @param dayEndTime
	 * @param startCharge
	 * @return
	 */
	public BusResult addCompanyPrice(Integer operatorID, Integer companyID, 
			String priceName, Integer carModel, double hourPrice, double startPrice, Integer freeTime, double dayPrice, 
			double nightPrice, double weekPrice, double hourMileage, double dayMileage, double nightMileage, double weekMileage, 
			double superPrice, String dayBeginTime, String dayEndTime, Integer startCharge);
	
}
