package com.wgjev.weibus.controller.carInfo;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.wgjev.weibus.entity.BusResult;
import com.wgjev.weibus.service.CarService;

@Controller
@RequestMapping("/car")
public class ChangeCarInfoController {
	@Resource
	private CarService carService;
	
	@RequestMapping("/changeCarInfo.do")
	@ResponseBody
	public BusResult execute(Integer operatorID, Integer carID, String carNo, Integer carBrand, String carModel, 
			Integer carColor, String carVin, 
			String terminalNo, String SIMNo, String bluetoothNo,
			String remark, String nameplateTime, String registrationTime, 
			String machineNo, String batteryCode, Integer chargingGun, Integer extinguisher, 
			Integer tools, Integer sign, Integer spareTire, Integer carStatus, @RequestParam(value="file",required=false) MultipartFile carLicense, 
			@RequestParam(value="file",required=false) MultipartFile carIcon, 
			HttpServletRequest request){
		
		
		BusResult result = carService.changeCarInfo(operatorID, carID, carNo, carBrand, carModel, carColor, carVin, 
				terminalNo, SIMNo, bluetoothNo, remark, nameplateTime, registrationTime, machineNo, 
				batteryCode, chargingGun, extinguisher, tools, sign, spareTire, carStatus, carLicense, carIcon);
		return result;
	}
}
