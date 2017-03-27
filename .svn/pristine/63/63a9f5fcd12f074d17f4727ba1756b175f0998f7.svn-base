package com.wgjev.weibus.controller.area;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wgjev.weibus.entity.BusResult;
import com.wgjev.weibus.service.AreaService;

@Controller
@RequestMapping("/area")
public class ChangeRegionController {
	@Resource
	private AreaService areaService;
	
	@RequestMapping("/changeRegion.do")
	@ResponseBody
	public BusResult execute(Integer regionID, String name, String regionNo, String zcode, String remark){
		BusResult result = areaService.changeRegion(regionID, name, regionNo, zcode, remark);
		return result;
	}
}
