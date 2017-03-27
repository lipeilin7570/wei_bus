package com.wgjev.weibus.controller.company;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wgjev.weibus.entity.BusResult;
import com.wgjev.weibus.service.CompanyService;

@Controller
@RequestMapping("/run")
public class QueryRunsController {
	@Resource
	private CompanyService companyService;
	
	@RequestMapping("/queryRuns.do")
	@ResponseBody
	public BusResult execute(Integer companyID, Integer operatorID, String beginDate, String endDate, 
			HttpServletRequest request, HttpServletResponse response){
		String loginIP = request.getRemoteHost();
		BusResult result = companyService.queryRuns(operatorID, companyID, loginIP, beginDate, endDate);
		return result;
	}
}
