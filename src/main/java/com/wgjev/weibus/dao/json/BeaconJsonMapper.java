package com.wgjev.weibus.dao.json;

import java.util.List;

import com.wgjev.weibus.entity.json.BeaconJson;

public interface BeaconJsonMapper {
	
	/**
	 * 根据公司ID查找信标信息
	 * @param companyID
	 * @return
	 */
	public List<BeaconJson> loadBeaconByCompanyID(Integer companyID);
	
	/**
	 * 查找所有信标信息
	 * @param companyID
	 * @return
	 */
	public List<BeaconJson> loadAllBeacon();
	
	/**
	 * 根据siteID查找信标信息
	 * @param companyID
	 * @return
	 */
	public List<BeaconJson> loadBeaconBySiteID(Integer siteID);
	
}
