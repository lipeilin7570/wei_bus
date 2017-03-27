package com.wgjev.weibus.controller.price;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wgjev.weibus.entity.BusResult;
import com.wgjev.weibus.service.PriceService;

@Controller
@RequestMapping("/price")
public class ChangeCompanyPriceController {
	@Resource
	private PriceService priceService;
	
	@RequestMapping("/changeCompanyPrice.do")
	@ResponseBody
	public BusResult execute(Integer operatorID, Integer priceID, Integer priceVersion,
			String priceName, Integer carModel, double hourPrice, double startPrice, Integer freeTime, double dayPrice,
			double nightPrice, double weekPrice, double hourMileage, double dayMileage, double nightMileage, double weekMileage,
			double superPrice, String dayBeginTime, String dayEndTime, Integer startCharge, 
			HttpServletRequest request, HttpServletResponse response){
		String loginIP = request.getRemoteHost();
		return priceService.changeCompanyPrice(operatorID, priceID, priceVersion, priceName, carModel, hourPrice, startPrice, freeTime, dayPrice, nightPrice, weekPrice, hourMileage, dayMileage, nightMileage, weekMileage, superPrice, dayBeginTime, dayEndTime, startCharge);
	}
}
