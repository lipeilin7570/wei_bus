package com.wgjev.weibus.controller.beacon;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wgjev.weibus.entity.BusResult;
import com.wgjev.weibus.service.BeaconService;

@Controller
@RequestMapping("/beacon")
public class ChangeBeaconController {
	@Resource
	private BeaconService beaconService;
	
	@RequestMapping("/changeBeancon.do")
	@ResponseBody
	public BusResult execute(Integer operatorID, Integer companyID, Integer siteID, Integer beaconID,
			String beaconNo, String UUID, String Major, String Minor, String Mac, 
			String position, String fixTime, String remark, Integer status){
		return beaconService.changeBeacom(operatorID, companyID, siteID, beaconID, beaconNo, 
				UUID, Major, Minor, Mac, position, fixTime, remark, status);
	}
	
}
