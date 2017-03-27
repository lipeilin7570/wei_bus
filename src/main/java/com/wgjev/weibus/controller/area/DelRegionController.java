package com.wgjev.weibus.controller.area;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wgjev.weibus.entity.BusResult;
import com.wgjev.weibus.service.AreaService;

@Controller
@RequestMapping("/area")
public class DelRegionController {
	@Resource
	private AreaService areaService;
	
	@RequestMapping("/delRegion.do")
	@ResponseBody
	public BusResult execute(Integer regionID, Integer status){
		BusResult result = areaService.delRegion(regionID, status);
		return result;
	}
}
