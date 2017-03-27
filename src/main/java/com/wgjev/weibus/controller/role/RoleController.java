package com.wgjev.weibus.controller.role;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wgjev.weibus.entity.BusResult;
import com.wgjev.weibus.service.RoleService;

@Controller
@RequestMapping("/role")
public class RoleController {
	
	@Resource
	private RoleService roleService;
	
	@RequestMapping("/role.do")
	@ResponseBody
	public BusResult execute(Integer operator, Integer roleID, String menuList){
		BusResult result = roleService.Role(operator, roleID, menuList);
		return result;
	}
}
