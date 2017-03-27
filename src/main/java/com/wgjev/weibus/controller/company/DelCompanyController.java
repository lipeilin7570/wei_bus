package com.wgjev.weibus.controller.company;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wgjev.weibus.entity.BusResult;
import com.wgjev.weibus.service.CompanyService;

@Controller
@RequestMapping("/company")
public class DelCompanyController {
	@Resource
	private CompanyService companyService;
	
	@RequestMapping("/delCompany.do")
	@ResponseBody
	public BusResult execute(Integer companyID, Integer status){
		BusResult result = companyService.delCompany(companyID, status);
		return result;
	}
}
