package com.wgjev.weibus.service.impl;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wgjev.weibus.dao.OperatorSysMapper;
import com.wgjev.weibus.dao.json.MenuSystemJsonMapper;
import com.wgjev.weibus.dao.json.RoleJsonMapper;
import com.wgjev.weibus.entity.BusResult;
import com.wgjev.weibus.entity.OperatorSys;
import com.wgjev.weibus.entity.json.MenuSystemJson;
import com.wgjev.weibus.entity.json.RoleJson;
import com.wgjev.weibus.service.OperatorService;
import com.wgjev.weibus.util.BusUtil;


@Service
public class OperatorServiceImpl implements OperatorService{
	
	@Resource
	private OperatorSysMapper operatorMapper;
	
	@Resource
	private RoleJsonMapper roleJsonMapper;
	
	@Resource
	private MenuSystemJsonMapper menuSystemJsonMapper;
	
	/**
	 * 登录检查
	 */
	public BusResult chenckLogin(String loginname, String pwd, String loginIP) {
		
		BusResult result = new BusResult();
		OperatorSys operator = operatorMapper.findByLoginName(loginname);
		if(operator == null){
			result.setStatus(1);
			result.setMsg("用户名不存在");
		} else
			try {
				if (!operator.getSyspassword().equals(BusUtil.md5(pwd))) {
					result.setStatus(2);//密码不正确
					result.setMsg("密码不正确");
				}else {
					result.setStatus(0);//用户名和密码正确
					result.setMsg("用户名和密码正确");
					Map<String, Object> params = new HashMap<String, Object>();
					params.put("operatorID", operator.getSysoperatorid());
					params.put("companyID", operator.getCompanyid());
					params.put("userName", operator.getSysusename());
					params.put("loginName", operator.getSysloginname());
					
					//角色
					RoleJson roleJson = roleJsonMapper.queryRoleByRoleID(operator.getRoleid());
					List<MenuSystemJson> list = new ArrayList<MenuSystemJson>();
					String arr[] = roleJson.getMenuList().split(",");
					for (String string : arr) {
						Integer i = new Integer(string);
						MenuSystemJson menuSystemJson = menuSystemJsonMapper.queryMenuByMenuID(i);
						list.add(menuSystemJson);
					}
					roleJson.setMenus(list);
					params.put("role", roleJson);
					
					result.setData(params);
				}
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		//修改IP、时间、登录次数
		if (operator.getLoginip() != null) {
			operator.setLasterip(operator.getLoginip());
		}
		operator.setLoginip(loginIP);
		
		operator.setLastertime(operator.getLogintime());
		operator.setLogintime(new Date());
		
		int count = operator.getLogincounts() + 1;
		operator.setLogincounts(Integer.valueOf(count));
		
		operatorMapper.updateByPrimaryKeySelective(operator);
		
		return result;
	}
	
	/**
	 * 根据状态加载操作员
	 */
	public BusResult loadOperators(int status) {
		BusResult result = new BusResult();
		List<OperatorSys> list = operatorMapper.findByStatus(status);
		result.setStatus(0);
		result.setMsg("加载成功");
		result.setData(list);
		return result;
	}
	
	/**
	 * 加载所有操作员的列表
	 */
	public BusResult loadAllOperators() {
		BusResult result = new BusResult();
		List<OperatorSys> list	= operatorMapper.findAllOperators();
		for (OperatorSys operatorSys : list) {
			operatorSys.setSyspassword("");
		}
		result.setStatus(0);
		result.setMsg(String.valueOf(list.size()));
		result.setData(list);
		return result;
	}
	/**
	 * 模糊查询操作员
	 */
	public BusResult findoperators(String userName,String loginName,Integer roleID,String telPhone,Integer status,Integer companyID) {
		BusResult result = new BusResult();
		Map<String, Object> params = new HashMap<String, Object>();
		
		if (userName == null) {
			userName = "";
		}
		if (loginName == null) {
			loginName ="";
		}
		if (roleID == null) {
			roleID = Integer.valueOf(0);
		}
		if (telPhone == null) {
			telPhone="";
		}
		if (status == null) {
			status = Integer.valueOf(0);
		}
		if (companyID == null) {
			companyID =Integer.valueOf(0);
		}
		params.put("userName", userName);
		params.put("loginName", loginName);
		params.put("telPhone", telPhone);
		params.put("roleID", roleID);
		params.put("status", status);
		params.put("companyID", companyID);
		
		List<OperatorSys> list = operatorMapper.dimFindOperator(params);
		result.setStatus(0);
		int count;
		if (list==null) {
			count =0;
		}else {
			count = list.size();
		}
		result.setMsg(String.valueOf(count));
		result.setData(list);
		return result;
	}

	/**
	 * 新增操作员
	 * @throws Exception 
	 */
	public BusResult addOperator(String userName, String pwd, String loginName, Integer roleID, Integer deptType, String telPhone,
			String remark, Integer companyID) throws Exception {
		BusResult result = new BusResult();
		
		/**
		 * 检查操作员名是否被占用
		 */
		OperatorSys has_operator = operatorMapper.findByLoginName(loginName);
		if (has_operator != null) {
			result.setStatus(1);
			result.setMsg("用户名已存在");
			return result;
		}
		
		/**
		 * 新增操作员
		 */
		OperatorSys operator = new OperatorSys();
		operator.setSysusename(userName);
		operator.setSysloginname(loginName);
		
		String md5_pwd = BusUtil.md5(pwd);
		operator.setSyspassword(md5_pwd);
		
		operator.setCreatetime(new Date());
		operator.setRoleid(roleID);
		operator.setDepttype(deptType);
		operator.setTelphone(telPhone);
		operator.setLogintime(new Date());
		operator.setStatus(1);
		operator.setCompanyid(companyID);
		operator.setLogincounts(0);
		operatorMapper.insertSelective(operator);
		result.setStatus(0);
		result.setMsg("新增操作员成功");
		return result;
	}

	/**
	 * 改操作员状状态（正常、暂停、销户）
	 */
	public BusResult changeStatus(Integer operatorID, Integer status) {
		BusResult result = new BusResult();
		OperatorSys operator = new OperatorSys();
		operator.setSysoperatorid(operatorID);
		operator.setStatus(status);
		operatorMapper.updateByPrimaryKeySelective(operator);
		result.setStatus(0);
		result.setMsg("状态更新成功");
		return result;
	}


	
	/**
	 * 修改操作员信息(用户姓名，密码，登录账户，部门，职务，联系电话，备注，公司ID)
	 * @throws Exception 
	 */
	public BusResult changeInfoByPersonal(Integer operatorID, String userName, String pwd, String loginName,
			 Integer deptType, Integer dutyType, String telPhone, String remark) throws Exception {
		BusResult result = new BusResult();
		/**
		 * 检查操作员名是否被占用
		 */
		OperatorSys has_operator = operatorMapper.findByLoginName(loginName);
		if (has_operator != null) {
			result.setStatus(1);
			result.setMsg("用户名已存在");
			return result;
		}
		OperatorSys operator = new OperatorSys();
		
		operator.setSysoperatorid(operatorID);
		operator.setSysusename(userName);
		operator.setSysloginname(loginName);
		
		String md5_pwd = BusUtil.md5(pwd);
		operator.setSyspassword(md5_pwd);
		
		operator.setDepttype(deptType);
		operator.setDutytype(dutyType);
		operator.setTelphone(telPhone);
		operator.setRemark(remark);
		
		result.setStatus(0);
		result.setMsg("个人信息更新成功");
		
		return result;
	}

	
	/**
	 * 修改操作员的密码
	 * @throws Exception 
	 */
	public BusResult changeInfoByLeader(Integer operatorID, String pwd) throws Exception {
		BusResult result = new BusResult();
		OperatorSys operator = new OperatorSys();
		
		operator.setSysoperatorid(operatorID);
		if (pwd != null && !pwd.equals("")) {
			String md5_pwd = BusUtil.md5(pwd);
			operator.setSyspassword(md5_pwd);
		}
		operatorMapper.updateByPrimaryKeySelective(operator);
		
		result.setStatus(0);
		
		return result;
	}
	
	/**
	 * 修改操作员的权限
	 */
	public BusResult changeRole(Integer operatorID, Integer RoleID) {
		// TODO Auto-generated method stub
		BusResult result = new BusResult();
		OperatorSys operator = new OperatorSys();
		
		operator.setSysoperatorid(operatorID);
		if (RoleID != null ) {
			operator.setRoleid(RoleID);
		}
		operatorMapper.updateByPrimaryKeySelective(operator);
		
		result.setStatus(0);
		
		return result;
	}
	
	
	
	
}
