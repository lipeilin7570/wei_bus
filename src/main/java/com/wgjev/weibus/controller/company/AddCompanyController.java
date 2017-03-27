package com.wgjev.weibus.controller.company;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wgjev.weibus.entity.BusResult;
import com.wgjev.weibus.service.CompanyService;

@Controller
@RequestMapping("/company")
public class AddCompanyController {
	@Resource
	private CompanyService companyService;
	
	@RequestMapping("/addCompany.do")
	@ResponseBody
	public BusResult execute(Integer operatorID, String address, String companyName, String shortName, Integer parentID, String companyPhone, 
			String contacts, String zcode, Integer companyCode, String remark, Integer regionStatus, double lng, double lat){
		BusResult result = companyService.addCompany(operatorID, address, companyName, shortName, parentID, companyPhone, contacts, 
				zcode, companyCode, remark, regionStatus, lng, lat);
		return result;
	}
}
