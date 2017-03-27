package com.wgjev.weibus.dao;

import java.util.List;

import com.wgjev.weibus.entity.CarStatusInfo;

public interface CarStatusInfoMapper {
    int deleteByPrimaryKey(Integer carid);

    int insert(CarStatusInfo record);

    int insertSelective(CarStatusInfo record);

    CarStatusInfo selectByPrimaryKey(Integer carid);

    int updateByPrimaryKeySelective(CarStatusInfo record);

    int updateByPrimaryKey(CarStatusInfo record);
    
    /**
     * 加载所有车辆状态
     * @return
     */
    public List<CarStatusInfo> loadCarStatus();
    
    
    
}