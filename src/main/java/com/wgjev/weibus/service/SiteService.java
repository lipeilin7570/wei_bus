package com.wgjev.weibus.service;

import org.springframework.web.multipart.MultipartFile;

import com.wgjev.weibus.entity.BusResult;

public interface SiteService {
	
	/**
	 * 根据公司ID加载站点信息
	 * @param companyID
	 * @return
	 */
	public BusResult findSiteByCompany(Integer companyID);
	
	
	/**
	 * 新增站点信息
	 * @param operatorID
	 * @param siteName
	 * @param siteCode
	 * @param zcode
	 * @param siteAddress
	 * @param longitude
	 * @param latitude
	 * @param siteRadius
	 * @param siteManID
	 * @param siteMan
	 * @param startTime
	 * @param endTime
	 * @param pileStatus
	 * @param status
	 * @param miniParkingCount
	 * @param parkingCount
	 * @param remark
	 * @param companyID
	 * @param file
	 * @return
	 */
	public BusResult addSite(Integer operatorID, String siteName, String siteCode, 
			String zcode, String siteAddress, 
			Double longitude, Double latitude, Double siteRadius, Integer siteManID,
			String siteMan, String startTime, String endTime,Integer pileStatus, 
			Integer status, Integer miniParkingCount, Integer parkingCount, 
			String remark, Integer companyID, MultipartFile file);
	
	/**
	 * 修改站点信息
	 * @param siteID
	 * @param siteName
	 * @param siteCode
	 * @param createTime
	 * @param sitePicIcon
	 * @param sitePic
	 * @param zcode
	 * @param siteAddress
	 * @param longitude
	 * @param latitude
	 * @param siteRadius
	 * @param siteManID
	 * @param siteMan
	 * @param startTime
	 * @param endTime
	 * @param pileStatus
	 * @param status
	 * @param miniParkingCount
	 * @param parkingCount
	 * @param remark
	 * @param companyID
	 * @return
	 */
	public BusResult changeSiteInfo(Integer operatorID, Integer siteID, String siteName, String siteCode, 
			String zcode, String siteAddress, 
			Double longitude, Double latitude, Double siteRadius, Integer siteManID,
			String siteMan, String startTime, String endTime,Integer pileStatus, 
			Integer status, Integer miniParkingCount, Integer parkingCount, 
			String remark, Integer companyID, MultipartFile file);
	
	/**
	 * 修改站点状态
	 * @param siteID
	 * @param status
	 * @return
	 */
	public BusResult changeSiteStatus(Integer siteID,Integer status);
	
	/**
	 * 上传站点图片
	 * @param siteID
	 * @param operatorID
	 * @param file
	 * @return
	 */
	public BusResult uploadSitePic(Integer siteID, Integer operatorID, MultipartFile file);
	
	
	
}
