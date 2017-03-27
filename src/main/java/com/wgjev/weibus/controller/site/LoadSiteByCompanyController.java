package com.wgjev.weibus.controller.site;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wgjev.weibus.entity.BusResult;
import com.wgjev.weibus.service.SiteService;

@Controller
@RequestMapping("/site")
public class LoadSiteByCompanyController {
	
	@Resource
	private SiteService siteService;
	
	@RequestMapping("/loadSite.do")
	@ResponseBody
	public BusResult execute(Integer companyID){
		return siteService.findSiteByCompany(companyID);
	}
}
