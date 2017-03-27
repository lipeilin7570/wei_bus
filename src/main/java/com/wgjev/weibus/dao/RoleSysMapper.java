package com.wgjev.weibus.dao;

import com.wgjev.weibus.entity.RoleSys;

public interface RoleSysMapper {
    int deleteByPrimaryKey(Integer sysroleid);

    int insert(RoleSys record);

    int insertSelective(RoleSys record);

    RoleSys selectByPrimaryKey(Integer sysroleid);

    int updateByPrimaryKeySelective(RoleSys record);

    int updateByPrimaryKey(RoleSys record);
}