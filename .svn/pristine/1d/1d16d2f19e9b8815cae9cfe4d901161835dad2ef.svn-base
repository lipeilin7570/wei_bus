package com.wgjev.weibus.controller.company;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wgjev.weibus.entity.BusResult;
import com.wgjev.weibus.service.CompanyService;

@Controller
@RequestMapping("/company")
public class LoadCompanyController {
	@Resource
	private CompanyService companyService;
	
	@RequestMapping("/loadCompany.do")
	@ResponseBody
	public BusResult execute(){
		BusResult result = companyService.loadCompanies();
		return result;
	}
	
}
