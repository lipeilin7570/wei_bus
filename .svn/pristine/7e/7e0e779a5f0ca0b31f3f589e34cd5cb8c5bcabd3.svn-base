package com.wgjev.weibus.controller.beacon;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wgjev.weibus.entity.BusResult;
import com.wgjev.weibus.service.BeaconService;

@Controller
@RequestMapping("/beacon")
public class AddBeacoController {

	@Resource
	private BeaconService beaconService;
	
	@RequestMapping("/addBeancon.do")
	@ResponseBody
	public BusResult execute(Integer operatorID, Integer companyID, Integer siteID, 
			String beaconNo, String UUID, String Major, String Minor, String Mac, 
			String position, String fixTime, String remark){
		return beaconService.addBeacom(operatorID, companyID, siteID, beaconNo, 
				UUID, Major, Minor, Mac, position, fixTime, remark);
	}
}
