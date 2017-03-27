package com.wgjev.weibus.controller.operator;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wgjev.weibus.entity.BusResult;
import com.wgjev.weibus.service.OperatorService;

/**
 * 管理员修改操作员的权限和密码
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/operator")
public class ChangeOperatorInfoController {
	
	@Resource
	private OperatorService operatorService;
	
	@RequestMapping("/changeInfo.do")
	@ResponseBody
	public BusResult execute(Integer operatorID, String pwd){
		try {
			BusResult result = operatorService.changeInfoByLeader(operatorID,  pwd);
			return result;
		} catch (Exception e) {
			BusResult result = new BusResult();
			result.setStatus(1);
			return result;
		}
	}
	
	
}
