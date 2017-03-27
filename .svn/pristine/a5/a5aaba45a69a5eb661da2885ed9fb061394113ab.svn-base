package com.wgjev.weibus.service;

import com.wgjev.weibus.entity.BusResult;

public interface BeaconService {
	
	/**
	 * 根据companyID显示信标信息
	 * @param companyID
	 * @return
	 */
	public BusResult loadBeaconByCompanyID(Integer companyID);
	
	/**
	 * 根据siteID查找信标信息
	 * @param siteID
	 * @return
	 */
	public BusResult loadBeaconBySiteID(Integer siteID);
	
	/**
	 * 添加信标信息
	 * @param operatorID
	 * @param companyID
	 * @param siteID
	 * @param beaconNo
	 * @param UUID
	 * @param Major
	 * @param Minor
	 * @param Mac
	 * @param position
	 * @param fixTime
	 * @param remark
	 * @return
	 */
	public BusResult addBeacom(Integer operatorID, Integer companyID, Integer siteID, 
			String beaconNo, String UUID, String Major, String Minor, String Mac, 
			String position, String fixTime, String remark);
	
	/**
	 * 修改信标信息
	 * @param operatorID
	 * @param companyID
	 * @param siteID
	 * @param beaconID
	 * @param beaconNo
	 * @param UUID
	 * @param Major
	 * @param Minor
	 * @param Mac
	 * @param position
	 * @param fixTime
	 * @param remark
	 * @return
	 */
	public BusResult changeBeacom(Integer operatorID, Integer companyID, Integer siteID, Integer beaconID,
			String beaconNo, String UUID, String Major, String Minor, String Mac, 
			String position, String fixTime, String remark, Integer status);
	
}
