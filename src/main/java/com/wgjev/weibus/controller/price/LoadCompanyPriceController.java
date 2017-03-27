package com.wgjev.weibus.controller.price;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wgjev.weibus.entity.BusResult;
import com.wgjev.weibus.service.PriceService;

@Controller
@RequestMapping("/price")
public class LoadCompanyPriceController {
	
	@Resource
	private PriceService priceService;
	
	@RequestMapping("/loadCompanyPrice.do")
	@ResponseBody
	public BusResult execute(int companyID){
		return priceService.loadAllPriceByCompanyID(companyID);
	}
	
}
