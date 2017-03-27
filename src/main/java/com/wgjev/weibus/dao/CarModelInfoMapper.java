package com.wgjev.weibus.dao;

import com.wgjev.weibus.entity.CarModelInfo;

public interface CarModelInfoMapper {
    int deleteByPrimaryKey(Integer carmodelid);

    int insert(CarModelInfo record);

    int insertSelective(CarModelInfo record);

    CarModelInfo selectByPrimaryKey(Integer carmodelid);

    int updateByPrimaryKeySelective(CarModelInfo record);

    int updateByPrimaryKey(CarModelInfo record);
}