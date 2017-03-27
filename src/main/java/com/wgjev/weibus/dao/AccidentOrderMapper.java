package com.wgjev.weibus.dao;

import com.wgjev.weibus.entity.AccidentOrder;

public interface AccidentOrderMapper {
    int deleteByPrimaryKey(Integer accidentid);

    int insert(AccidentOrder record);

    int insertSelective(AccidentOrder record);

    AccidentOrder selectByPrimaryKey(Integer accidentid);

    int updateByPrimaryKeySelective(AccidentOrder record);

    int updateByPrimaryKey(AccidentOrder record);
}