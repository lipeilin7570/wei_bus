package com.wgjev.weibus.controller.role;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wgjev.weibus.entity.BusResult;
import com.wgjev.weibus.service.RoleService;

@Controller
@RequestMapping("/role")
public class ChangeRoleStatusController {

	@Resource
	private RoleService roleService;
	
	@RequestMapping("/changeRoleStatus.do")
	@ResponseBody
	public BusResult execute(Integer roleID, Integer operatorID, Integer status){
		BusResult result = roleService.changeRoleStatus(roleID, operatorID, status);
		return result;
	}
}
