package com.wgjev.weibus.controller.site;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wgjev.weibus.entity.BusResult;
import com.wgjev.weibus.service.SiteService;

@Controller
@RequestMapping("/site")
public class ChangeSiteStatusController {

	@Resource
	private SiteService siteService;
	
	@RequestMapping("/changeSiteStatus.do")
	@ResponseBody
	public BusResult execute(Integer siteID,Integer status){
		return siteService.changeSiteStatus(siteID, status);
	}
	
}
