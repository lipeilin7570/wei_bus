package com.wgjev.weibus.service;

import com.wgjev.weibus.entity.BusResult;

public interface UserService {
	
	/**
	 * 加载所有用户信息
	 */
	public BusResult loadUsers();
	
	/**
	 * 查看用户认证资料
	 * @param userID
	 * @return
	 */
	public BusResult showUserDataByUserId(Integer userID);
	
	/**
	 * 设置用户认证状态
	 * @param userID
	 * @param authentication
	 * @return
	 */
	public BusResult changUserAuthentication(Integer operatorID, Integer userID, Integer authentication, String reason);
	
	/**
	 * 修改用户状态
	 * @param userID
	 * @param status
	 * @return
	 */
	public BusResult changeUserStatus(Integer userID, Integer status);
	
	
	
	
}
