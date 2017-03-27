package com.wgjev.weibus.controller.area;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wgjev.weibus.entity.BusResult;
import com.wgjev.weibus.service.AreaService;

@Controller
@RequestMapping("/area")
public class LoadChinaZcodesController {
	@Resource
	private AreaService areaService;
	
	@RequestMapping("/loadChinaZcodes.do")
	@ResponseBody
	public BusResult execute(){
		BusResult result = areaService.loadChinaZcodes();
		return result;
	}
	
}
