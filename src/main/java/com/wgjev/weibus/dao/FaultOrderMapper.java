package com.wgjev.weibus.dao;

import com.wgjev.weibus.entity.FaultOrder;

public interface FaultOrderMapper {
    int deleteByPrimaryKey(Integer faultid);

    int insert(FaultOrder record);

    int insertSelective(FaultOrder record);

    FaultOrder selectByPrimaryKey(Integer faultid);

    int updateByPrimaryKeySelective(FaultOrder record);

    int updateByPrimaryKey(FaultOrder record);
}