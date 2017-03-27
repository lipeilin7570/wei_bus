package com.wgjev.weibus.service;

import com.wgjev.weibus.entity.BusResult;

public interface RoleService {
	
	/**
	 * 根据角色ID查找角色信息
	 * @param roleID
	 * @return
	 */
	public BusResult queryRoleByRoleID(Integer roleID);
	
	/**
	 * 添加角色信息
	 * @param operatorID
	 * @param roleName
	 * @param menuList
	 * @return
	 */
	public BusResult addRole(Integer operatorID, String roleNo, String roleName, String remark);
	
	/**
	 * 修改角色信息
	 * @param roleID
	 * @param operatorID
	 * @param roleName
	 * @param menuList
	 * @return
	 */
	public BusResult changeRole(Integer roleID, Integer operatorID, String roleName, String remark);
	
	/**
	 * 修改角色状态
	 * @param roleID
	 * @param operatorID
	 * @param status
	 * @return
	 */
	public BusResult changeRoleStatus(Integer roleID, Integer operatorID, Integer status);
	
	/**
	 * 加载所有角色信息
	 * @param operatorID
	 * @return
	 */
	public BusResult loadAllRoles(Integer operatorID);
	
	/**
	 * 授权
	 * @param operator
	 * @param roleID
	 * @param munuList
	 * @return
	 */
	public BusResult Role(Integer operator, Integer roleID, String munuList);
	
}
