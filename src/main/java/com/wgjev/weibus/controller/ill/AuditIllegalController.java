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
public class AuditIllegalController {
	@Resource
	private IllService illService;
	
	@RequestMapping("/auditIllegal.do")
	@ResponseBody
	public BusResult execute(Integer operatorID, Integer illegalID, Integer auditStatus, String failReason,
			HttpServletRequest request, HttpServletResponse response){
		String loginIP = request.getRemoteHost();
		return illService.auditIllegal(operatorID, illegalID, auditStatus, failReason, loginIP);
	}
}
