package com.wgjev.weibus.dao;

import com.wgjev.weibus.entity.UsercheckRental;

public interface UsercheckRentalMapper {
    int deleteByPrimaryKey(Integer usercheckid);

    int insert(UsercheckRental record);

    int insertSelective(UsercheckRental record);

    UsercheckRental selectByPrimaryKey(Integer usercheckid);

    int updateByPrimaryKeySelective(UsercheckRental record);

    int updateByPrimaryKey(UsercheckRental record);
}