package com.wgjev.weibus.controller.account;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wgjev.weibus.entity.BusResult;
import com.wgjev.weibus.service.AccountService;

@Controller
@RequestMapping("/account")
public class QueryDealsController {
	@Resource
	private AccountService accountService;
	
	@RequestMapping("/queryDeals.do")
	@ResponseBody
	public BusResult execute(Integer operatorID, String beginTime, String endTime,
			Integer userID, Integer dealType, Integer tradeType, Integer tradeAccount, 
			HttpServletRequest request, HttpServletResponse response){
		String loginIP = request.getRemoteHost();
		return accountService.queryDeals(operatorID, beginTime, endTime, userID, dealType, tradeType, tradeAccount, loginIP);
	}
}
