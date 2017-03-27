package com.wgjev.weibus.dao.json;

import java.util.List;

import com.wgjev.weibus.entity.json.RoleJson;

public interface RoleJsonMapper {
	
	/*
	 * 根据角色ID查找角色信息
	 */
	public RoleJson queryRoleByRoleID(Integer roleID);
	
	/**
	 * 加载所有角色信息
	 * @return
	 */
	public List<RoleJson> loadAllRoles();
	
}
