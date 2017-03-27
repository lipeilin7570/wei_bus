package com.wgjev.weibus.controller.carInfo;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wgjev.weibus.entity.BusResult;
import com.wgjev.weibus.service.CarService;

@Controller
@RequestMapping("/car")
public class CarControlController {
	
	@Resource
	private CarService carService;
	
	@RequestMapping("/carControl.do")
	@ResponseBody
	public BusResult execute(int operatorID, int carID, int controlType, 
			HttpServletRequest request, HttpServletResponse response){
		String loginIP = request.getRemoteHost();
		return carService.carControl(operatorID, carID, controlType, loginIP);
	}
	
	
}
