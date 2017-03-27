package com.wgjev.weibus.dao;

import com.wgjev.weibus.entity.IllegalOrder;

public interface IllegalOrderMapper {
    int deleteByPrimaryKey(Integer illegalid);

    int insert(IllegalOrder record);

    int insertSelective(IllegalOrder record);

    IllegalOrder selectByPrimaryKey(Integer illegalid);

    int updateByPrimaryKeySelective(IllegalOrder record);

    int updateByPrimaryKey(IllegalOrder record);
}