package com.wgjev.weibus.controller.role;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wgjev.weibus.entity.BusResult;
import com.wgjev.weibus.service.RoleService;

@Controller
@RequestMapping("/role")
public class AddRoleController {
	
	@Resource
	private RoleService roleService;
	
	@RequestMapping("/addRole.do")
	@ResponseBody
	public BusResult execute(Integer operatorID, String roleNo, String roleName,  String remark){
		BusResult result = roleService.addRole(operatorID, roleNo, roleName, remark);
		return result;
	}
	
}
