package com.wgjev.weibus.controller.site;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.wgjev.weibus.entity.BusResult;
import com.wgjev.weibus.service.SiteService;

@Controller
@RequestMapping("/site")
public class ChangeSiteInfoController {

	@Resource
	private SiteService siteService;
	
	@RequestMapping("/changeSiteInfo.do")
	@ResponseBody
	public BusResult execute(Integer siteID, String siteName, String siteCode, 
			String zcode, String siteAddress, 
			Double longitude, Double latitude, Double siteRadius, Integer siteManID,
			String siteMan, String startTime, String endTime,Integer pileStatus, 
			Integer status, Integer miniParkingCount, Integer parkingCount, 
			String remark, Integer companyID, Integer operatorID, 
			@RequestParam(value="file",required=false) MultipartFile file, 
			HttpServletRequest request){
		return siteService.changeSiteInfo(operatorID, siteID, siteName, siteCode, 
				zcode, siteAddress, longitude, 
				latitude, siteRadius, siteManID, siteMan, startTime, 
				endTime, pileStatus, status, miniParkingCount, parkingCount, 
				remark, companyID, file);
	}
	
}
