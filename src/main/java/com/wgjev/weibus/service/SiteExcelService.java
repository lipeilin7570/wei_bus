package com.wgjev.weibus.service;

import org.springframework.web.multipart.MultipartFile;

import com.wgjev.weibus.entity.BusResult;

public interface SiteExcelService {
	
	/**
	 * 批量导入站点信息
	 * @param operatorID
	 * @param mFile
	 * @param rootPath
	 * @param loginIP
	 * @return
	 */
	public BusResult importFile(Integer operatorID, Integer companyID, MultipartFile mFile, String rootPath, String loginIP);
	
	
}
