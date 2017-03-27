package com.wgjev.weibus.dao;

import java.util.List;
import java.util.Map;

import com.wgjev.weibus.entity.OperatorSys;

public interface OperatorSysMapper {
    int deleteByPrimaryKey(Integer sysoperatorid);

    int insert(OperatorSys record);

    int insertSelective(OperatorSys record);

    OperatorSys selectByPrimaryKey(Integer sysoperatorid);

    int updateByPrimaryKeySelective(OperatorSys record);

    int updateByPrimaryKey(OperatorSys record);
    
    //根据登录名查找管理员
    public OperatorSys findByLoginName(String loginname);
    
    //根据状态获取操作员的信息
  	public List<OperatorSys> findByStatus(int status);
  	
  	//加载所有操作员的信息
  	public List<OperatorSys> findAllOperators();
  	
  	//模糊查询（用户姓名、登录账户、部门、联系电话、状态、公司ID）
  	public List<OperatorSys> dimFindOperator(Map<String, Object> params);
    
  	//根据电话查找管理员
    public OperatorSys findByTelPhone(String telPhone);
    
}