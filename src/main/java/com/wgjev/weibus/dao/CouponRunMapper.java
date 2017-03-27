package com.wgjev.weibus.dao;

import com.wgjev.weibus.entity.CouponRun;

public interface CouponRunMapper {
    int deleteByPrimaryKey(Integer couponid);

    int insert(CouponRun record);

    int insertSelective(CouponRun record);

    CouponRun selectByPrimaryKey(Integer couponid);

    int updateByPrimaryKeySelective(CouponRun record);

    int updateByPrimaryKey(CouponRun record);
}