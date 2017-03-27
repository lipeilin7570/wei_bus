package com.wgjev.weibus.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wgjev.weibus.dao.RoleSysMapper;
import com.wgjev.weibus.dao.json.MenuSystemJsonMapper;
import com.wgjev.weibus.dao.json.RoleJsonMapper;
import com.wgjev.weibus.entity.BusResult;
import com.wgjev.weibus.entity.RoleSys;
import com.wgjev.weibus.entity.json.MenuSystemJson;
import com.wgjev.weibus.entity.json.RoleJson;
import com.wgjev.weibus.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Resource
	private RoleJsonMapper roleJsonMapper;
	
	@Resource
	private MenuSystemJsonMapper menuSystemJsonMapper;
	
	@Resource
	private RoleSysMapper roleSysMapper;
	
	/**
	 * 根据角色ID查找角色信息
	 */
	public BusResult queryRoleByRoleID(Integer roleID) {
		// TODO Auto-generated method stub
		BusResult result = new BusResult();
		RoleJson roleJson = roleJsonMapper.queryRoleByRoleID(roleID);
		if (roleJson == null) {
			result.setStatus(1);
			return result;
		}
		if (roleJson.getMenuList() == null) {
			result.setStatus(101);
			return result;
		}
		List<MenuSystemJson> list = new ArrayList<MenuSystemJson>();
		String arr[] = roleJson.getMenuList().split(",");
		for (String string : arr) {
			Integer i = new Integer(string);
			MenuSystemJson menuSystemJson = menuSystemJsonMapper.queryMenuByMenuID(i);
			list.add(menuSystemJson);
		}
		roleJson.setMenus(list);
		result.setStatus(0);
		result.setData(roleJson);
		return result;
	}

	/**
	 * 添加角色信息
	 */
	public BusResult addRole(Integer operatorID, String roleNo, String roleName, String remark) {
		// TODO Auto-generated method stub
		BusResult result = new BusResult();
		RoleSys roleSys = new RoleSys();
		roleSys.setSysroleno(roleNo);
		roleSys.setSysrolename(roleName);
		roleSys.setStatus(1);
		roleSys.setCreatetime(new Date());
		roleSys.setUpdatecounts(0);
		roleSys.setRemark(remark);
		roleSysMapper.insertSelective(roleSys);
		
		result.setStatus(0);
		return result;
		
	}

	/**
	 * 修改角色信息
	 */
	public BusResult changeRole(Integer roleID, Integer operatorID, String roleName, String remark) {
		// TODO Auto-generated method stub
		BusResult result = new BusResult();
		RoleSys roleSys = new RoleSys();
		roleSys.setSysroleid(roleID);
		roleSys.setSysrolename(roleName);
		roleSys.setUpdatetime(new Date());
		if (roleSys.getUpdatecounts()==null) {
			roleSys.setUpdatecounts(0);
		}
		roleSys.setUpdatecounts(roleSys.getUpdatecounts() + 1);
		roleSys.setRemark(remark);
		roleSysMapper.updateByPrimaryKeySelective(roleSys);
		
		result.setStatus(0);
		return result;
	}

	/**
	 * 修改角色状态
	 */
	public BusResult changeRoleStatus(Integer roleID, Integer operatorID, Integer status) {
		// TODO Auto-generated method stub
		BusResult result = new BusResult();
		RoleSys roleSys = new RoleSys();
		roleSys.setSysroleid(roleID);
		roleSys.setStatus(status);
		roleSys.setUpdatetime(new Date());
		if (roleSys.getUpdatecounts()==null) {
			roleSys.setUpdatecounts(0);
		}
		roleSys.setUpdatecounts(roleSys.getUpdatecounts() + 1);
		roleSysMapper.updateByPrimaryKeySelective(roleSys);
		
		result.setStatus(0);
		return result;
	}

	/**
	 * 加载所有角色信息
	 */
	public BusResult loadAllRoles(Integer operatorID) {
		// TODO Auto-generated method stub
		BusResult result = new BusResult();
		List<RoleJson> list = roleJsonMapper.loadAllRoles();
		for (RoleJson roleJson : list) {
			StringBuilder stringBuilder = new StringBuilder();
			if (roleJson.getMenuList()==null) {
				continue;
			}
			String arr[] = roleJson.getMenuList().split(",");
			List<MenuSystemJson> menus = new ArrayList<MenuSystemJson>();
			for (int i = 0; i < arr.length; i++) {
				Integer index = new Integer(arr[i]);
				MenuSystemJson menuSystemJson = menuSystemJsonMapper.queryMenuByMenuID(index);
				if (i== (arr.length-1)) {
					stringBuilder.append(menuSystemJson.getMenuName());
				}else {
					stringBuilder.append(menuSystemJson.getMenuName()).append(",");
				}
				menus.add(menuSystemJson);
			}
			roleJson.setMenus(menus);
			roleJson.setMenuList(stringBuilder.toString());
		}
		for (int i = 0; i < list.size(); i++) {
			
		}
		
		result.setStatus(0);
		result.setData(list);
		return result;
	}

	
	/**
	 * 授权
	 */
	public BusResult Role(Integer operator, Integer roleID, String munuList) {
		// TODO Auto-generated method stub
		BusResult result = new BusResult();
		RoleSys roleSys = new RoleSys();
		roleSys.setSysroleid(roleID);
		roleSys.setSysmenulist(munuList);
		roleSys.setUpdatetime(new Date());
		if (roleSys.getUpdatecounts()==null) {
			roleSys.setUpdatecounts(0);
		}
		roleSys.setUpdatecounts(roleSys.getUpdatecounts() + 1);
		roleSysMapper.updateByPrimaryKeySelective(roleSys);
		
		result.setStatus(0);
		return result;
	}
	
	
	
	
	
}
