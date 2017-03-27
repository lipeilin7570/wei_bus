package com.wgjev.weibus.controller.carInfo;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wgjev.weibus.entity.BusResult;
import com.wgjev.weibus.service.CarService;

@Controller
@RequestMapping("/car")
public class LoadCarInfoController {
	@Resource
	private CarService carService;
	
	@RequestMapping("/loadCars.do")
	@ResponseBody
	public BusResult execute(Integer companyID){
		BusResult result = carService.loadCars(companyID);
		return result;
	}
}
