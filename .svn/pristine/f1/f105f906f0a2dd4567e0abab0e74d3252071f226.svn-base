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
public class AddCarInfoController {
	@Resource
	private CarService carService;
	
	@RequestMapping("/addCar.do")
	@ResponseBody
	public BusResult execute(Integer operatorID, Integer carID, String carNo, Integer carBrand, Integer carModel, 
			Integer carColor, String carVin, Integer people, 
			String terminalNo, String SIMNo, String bluetoothNo,
			String remark, Integer companyID, String nameplateTime, String registrationTime, 
			String machineNo, String batteryCode, Integer chargingGun, Integer extinguisher, 
			Integer tools, Integer sign, Integer spareTire, @RequestParam(value="file",required=false) MultipartFile carLicense, 
			@RequestParam(value="file1",required=false) MultipartFile carIcon, 
			HttpServletRequest request){
		 
		BusResult result = carService.addCarInfo(operatorID, carNo, carBrand, carModel, carColor, 
				carVin, people, terminalNo, SIMNo, bluetoothNo,
				remark, companyID, nameplateTime, 
				registrationTime, machineNo, batteryCode, chargingGun, extinguisher, tools, 
				sign, spareTire, carLicense, carIcon);
		return result;
	}
}
