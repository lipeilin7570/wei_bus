package com.wgjev.weibus.controller.role;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wgjev.weibus.entity.BusResult;
import com.wgjev.weibus.service.RoleService;

@Controller
@RequestMapping("/role")
public class ChangeRoleController {

	@Resource
	private RoleService roleService;
	
	@RequestMapping("/changeRole.do")
	@ResponseBody
	public BusResult execute(Integer roleID, Integer operatorID, String roleName, String remark){
		BusResult result = roleService.changeRole(roleID, operatorID, roleName, remark);
		return result;
	}
}
