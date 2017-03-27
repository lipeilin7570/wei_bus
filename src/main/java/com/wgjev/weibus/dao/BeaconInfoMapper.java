package com.wgjev.weibus.dao;

import com.wgjev.weibus.entity.BeaconInfo;

public interface BeaconInfoMapper {
    int deleteByPrimaryKey(Integer beaconid);

    int insert(BeaconInfo record);

    int insertSelective(BeaconInfo record);

    BeaconInfo selectByPrimaryKey(Integer beaconid);

    int updateByPrimaryKeySelective(BeaconInfo record);

    int updateByPrimaryKey(BeaconInfo record);
}