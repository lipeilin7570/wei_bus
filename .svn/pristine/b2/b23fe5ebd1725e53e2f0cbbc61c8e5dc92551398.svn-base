package com.wgjev.weibus.controller.sysInfo;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wgjev.weibus.entity.BusResult;
import com.wgjev.weibus.service.SysInfoService;

@Controller
@RequestMapping("/sysinfo")
public class FindDictController {
	
	@Resource
	private SysInfoService sysInfoService;
	
	@RequestMapping("/loadDict.do")
	@ResponseBody
	public BusResult execute(int typeID){
		BusResult result = sysInfoService.findDictByTypeID(typeID);
		return result;
	}
	
}
