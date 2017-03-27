package com.wgjev.weibus.controller.site;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wgjev.weibus.entity.BusResult;
import com.wgjev.weibus.service.TestService;

@Controller
@RequestMapping("/site")
public class TestController {
	@Resource
	private TestService testService;
	
	@RequestMapping(value="/test.do",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public BusResult execute(){
		
		return testService.test();
	}
	
	
}
