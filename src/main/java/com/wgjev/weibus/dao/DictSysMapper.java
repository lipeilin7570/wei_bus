package com.wgjev.weibus.dao;

import java.util.List;

import com.wgjev.weibus.entity.DictSys;
import com.wgjev.weibus.entity.DictSysKey;

public interface DictSysMapper {
    int deleteByPrimaryKey(DictSysKey key);

    int insert(DictSys record);

    int insertSelective(DictSys record);

    DictSys selectByPrimaryKey(DictSysKey key);

    int updateByPrimaryKeySelective(DictSys record);

    int updateByPrimaryKey(DictSys record);
    
    //查询已定义的数据字典
    public List<DictSys> findDictByTypeID(int typeID);
    
    
}