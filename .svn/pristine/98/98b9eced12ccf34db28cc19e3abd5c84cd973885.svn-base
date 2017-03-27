package com.wgjev.weibus.dao;

import java.util.List;

import com.wgjev.weibus.entity.CarInfo;

public interface CarInfoMapper {
    int deleteByPrimaryKey(Integer carid);

    int insert(CarInfo record);

    int insertSelective(CarInfo record);

    CarInfo selectByPrimaryKey(Integer carid);

    int updateByPrimaryKeySelective(CarInfo record);

    int updateByPrimaryKey(CarInfo record);
    
    /**
     * 加载所有车辆信息
     * @return
     */
    public List<CarInfo> loadAllCarInfos();
    
}