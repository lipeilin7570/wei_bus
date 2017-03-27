package com.wgjev.weibus.service;

import com.wgjev.weibus.entity.BusResult;

public interface CompanyService {
	/**
	 * 加载所以公司信息
	 * @return
	 */
	public BusResult loadCompanies();
	
	/**
	 * 增加公司信息
	 * @param companyName
	 * @param shortName
	 * @param parentID
	 * @param companyPhone
	 * @param contacts
	 * @param zcode
	 * @param companyCode
	 * @param remark
	 * @param regionStatus
	 * @param lng
	 * @param lat
	 * @return
	 */
	public BusResult addCompany(Integer operatorID, String address, String companyName, String shortName, Integer parentID, String companyPhone, 
			String contacts, String zcode, Integer companyCode, String remark, Integer regionStatus, double lng, double lat);
	
	/**
	 * 修改公司信息
	 * @param companyID
	 * @param companyName
	 * @param shortName
	 * @param parentID
	 * @param companyPhone
	 * @param contacts
	 * @param zcode
	 * @param companyCode
	 * @param remark
	 * @param regionStatus
	 * @param lng
	 * @param lat
	 * @return
	 */
	public BusResult changeCompany(Integer operatorID, String address, Integer companyID, String companyName, String shortName, Integer parentID, String companyPhone, 
			String contacts, String zcode, Integer companyCode, String remark, Integer regionStatus, double lng, double lat, Integer status);
	
	
	/**
	 * 删除公司信息
	 * @param companyID
	 * @param status
	 * @return
	 */
	public BusResult delCompany(Integer companyID, Integer status);
	
	/**
	 * 查询公司的运营信息
	 * @param operator
	 * @param companyID
	 * @param loginIP
	 * @return
	 */
	public BusResult queryRuns(Integer operatorID, Integer companyID, String loginIP, String beginDate, String endDate);
	
	
	
}
