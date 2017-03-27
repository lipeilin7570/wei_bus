package com.wgjev.weibus.controller.sysInfo;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wgjev.weibus.entity.BusResult;
import com.wgjev.weibus.service.SysInfoService;

@Controller
@RequestMapping("/sysinfo")
public class DelDictController {
	
	@Resource
	private SysInfoService sysInfoService;
	
	@RequestMapping("/delDictType.do")
	@ResponseBody
	public BusResult execute(int typeID, int dictID){
		BusResult result = sysInfoService.delDict(typeID, dictID);
		return result;
	}
}
