package com.wgjev.weibus.service;

import com.wgjev.weibus.entity.BusResult;

public interface AreaService {
	
	/**
	 * 查询国家行政区划
	 * @return
	 */
	public BusResult loadChinaZcodes();
	
	/**
	 * 查询运营区域列表
	 * @return
	 */
	public BusResult loadRegions();
	
	/**
	 * 增加运营区域
	 * @param name
	 * @param regionNo
	 * @param zcode
	 * @return
	 */
	public BusResult addRegion(String name, String regionNo, String zcode, String remark);
	
	/**
	 * 修改运营区域信息
	 * @param regionID
	 * @param name
	 * @param regionNo
	 * @param zcode
	 * @return
	 */
	public BusResult changeRegion(Integer regionID, String name, String regionNo, String zcode, String remark);
	
	/**
	 * 删除运营区域
	 * @param regionID
	 * @param status
	 * @return
	 */
	public BusResult delRegion(Integer regionID, Integer status);
	
	
}
