package com.wgjev.weibus.controller.role;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wgjev.weibus.entity.BusResult;
import com.wgjev.weibus.service.RoleService;

@Controller
@RequestMapping("/role")
public class QueryRoleController {
	
	@Resource
	private RoleService roleService;
	
	@RequestMapping("/queryRole.do")
	@ResponseBody
	public BusResult execute(Integer operatorID, Integer roleID){
		BusResult result = roleService.queryRoleByRoleID(roleID);
		return result;
	}
	
}
