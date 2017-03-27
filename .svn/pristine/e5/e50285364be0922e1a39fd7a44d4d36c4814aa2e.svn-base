package com.wgjev.weibus.controller.price;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wgjev.weibus.entity.BusResult;
import com.wgjev.weibus.service.PriceService;

@Controller
@RequestMapping("/price")
public class FindPriceByPriceIDController {
	
	@Resource
	private PriceService priceService;
	
	@RequestMapping("/findPriceByPriceID.do")
	@ResponseBody
	public BusResult execute(Integer priceID){
		return priceService.findPriceByPriceID(priceID);
	}
	
}
