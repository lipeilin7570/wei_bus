package com.wgjev.weibus.controller.carInfo;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wgjev.weibus.entity.BusResult;
import com.wgjev.weibus.service.CarService;

@Controller
@RequestMapping("/car")
public class ChangeCarInfoStatusController {
	
	@Resource
	private CarService carService;
	
	@RequestMapping("/changeCarStatus.do")
	@ResponseBody
	public BusResult execute(Integer carID, Integer carStatus){
		BusResult result = carService.changeCarStatus(carID, carStatus);
		return result;
	}
}
