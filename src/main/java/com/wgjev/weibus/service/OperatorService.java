package com.wgjev.weibus.service;


import com.wgjev.weibus.entity.BusResult;

public interface OperatorService {
	//登录检查
	public BusResult chenckLogin(String loginname, String pwd, String loginIP);
	
	//查询操作员
	public BusResult findoperators(String userName,String loginName,Integer roleID,String telPhone,Integer status,Integer companyID);
	
	//显示操作员列表
	public BusResult loadOperators(int status);
	
	//显示所有操作员列表
	public BusResult loadAllOperators();
	
	//增加操作员
	public BusResult addOperator(String userName, String pwd, String loginName, Integer roleID, Integer deptType, String telPhone,
			String remark, Integer companyID) throws Exception;
	
	//修改操作员状状态（正常、暂停、销户）
	public BusResult changeStatus(Integer operatorID,Integer status);
	
	//修改操作员信息(用户姓名，密码，登录账户，部门，职务，联系电话，备注，公司ID)
	public BusResult changeInfoByPersonal(Integer operatorID,String userName,String pwd,String loginName,Integer deptType,Integer dutyType,String telPhone, String remark) throws Exception;
	
	//修改操作员密码
	public BusResult changeInfoByLeader(Integer operatorID, String pwd) throws Exception;
	
	//修改操作员权限
	public BusResult changeRole(Integer operatorID,Integer RoleID);
		
	
	
	
}
