package com.wgjev.weibus.controller.operator;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wgjev.weibus.entity.BusResult;
import com.wgjev.weibus.service.OperatorService;
/**
 * 操作员修改自己的基本信息的控制器
 * 修改操作员信息(用户姓名，密码，登录账户，部门，职务，联系电话，备注，公司ID)
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/operator")
public class UpdateOperatorInfoController {
	
	@Resource
	private OperatorService operatorService;
	
	@RequestMapping("/updateInfo.do")
	@ResponseBody
	public BusResult execute(Integer operatorID,String userName,String pwd,String loginName,Integer deptType,Integer dutyType,String telPhone, String remark){
		BusResult result;
		try {
			result = operatorService.changeInfoByPersonal(operatorID, userName, pwd, loginName,  deptType, dutyType, telPhone, remark);
		} catch (Exception e) {
			result = new BusResult();
			result.setStatus(1);
			e.printStackTrace();
		}
		
		return result;
	}
	
}
