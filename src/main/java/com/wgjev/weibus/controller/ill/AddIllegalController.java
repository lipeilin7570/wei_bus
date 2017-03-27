package com.wgjev.weibus.controller.ill;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wgjev.weibus.entity.BusResult;
import com.wgjev.weibus.service.IllService;

@Controller
@RequestMapping("/order")
public class AddIllegalController {
	
	@Resource
	private IllService illService;
	
	@RequestMapping("/addIllegal.do")
	@ResponseBody
	public BusResult execute(Integer operatorID,  Integer leaseID, String illegalTime, 
			String description, String address, String collectionUnit, Integer points, double fine, 
			String remark, 
			HttpServletRequest request, HttpServletResponse response){
		String loginIP = request.getRemoteHost();
		
		return illService.AddIllegal(operatorID, leaseID, illegalTime, 
				description, address, collectionUnit, points, fine, remark, 
				loginIP);
	}
	
}
