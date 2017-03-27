package com.wgjev.weibus.dao;

import com.wgjev.weibus.entity.ControlLog;

public interface ControlLogMapper {
    int deleteByPrimaryKey(Integer tLogControl);

    int insert(ControlLog record);

    int insertSelective(ControlLog record);

    ControlLog selectByPrimaryKey(Integer tLogControl);

    int updateByPrimaryKeySelective(ControlLog record);

    int updateByPrimaryKey(ControlLog record);
}