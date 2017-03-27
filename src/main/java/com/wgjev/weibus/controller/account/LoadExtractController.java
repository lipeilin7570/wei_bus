package com.wgjev.weibus.controller.account;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wgjev.weibus.entity.BusResult;
import com.wgjev.weibus.service.AccountService;

@Controller
@RequestMapping("/account")
public class LoadExtractController {
	
	@Resource
	private AccountService accountService;
	
	@RequestMapping("/loadExtract.do")
	@ResponseBody
	public BusResult execute(){
		return accountService.loadExtract();
	}
	
	
}
