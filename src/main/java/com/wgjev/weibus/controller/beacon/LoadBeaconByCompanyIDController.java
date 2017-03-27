package com.wgjev.weibus.controller.beacon;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wgjev.weibus.entity.BusResult;
import com.wgjev.weibus.service.BeaconService;

@Controller
@RequestMapping("/beacon")
public class LoadBeaconByCompanyIDController {
	
	@Resource
	private BeaconService beaconService;
	
	@RequestMapping("/loadBeanconByCompanyID.do")
	@ResponseBody
	public BusResult execute(Integer companyID){
		return beaconService.loadBeaconByCompanyID(companyID);
	}
	
}
