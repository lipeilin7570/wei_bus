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
public class QueryBalancesController {
	@Resource
	private AccountService accountService;
	
	@RequestMapping("/queryBalances.do")
	@ResponseBody
	public BusResult execute(Integer operatorID, Integer order,
			HttpServletRequest request, HttpServletResponse response){
		String loginIP = request.getRemoteHost();
		return accountService.queryBalances(operatorID, order, loginIP);
	}
}
