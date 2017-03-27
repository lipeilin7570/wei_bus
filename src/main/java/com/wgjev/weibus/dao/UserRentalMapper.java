package com.wgjev.weibus.dao;

import java.util.List;

import com.wgjev.weibus.entity.UserRental;

public interface UserRentalMapper {
    int deleteByPrimaryKey(Integer rentaluserid);

    int insert(UserRental record);

    int insertSelective(UserRental record);

    UserRental selectByPrimaryKey(Integer rentaluserid);

    int updateByPrimaryKeySelective(UserRental record);

    int updateByPrimaryKey(UserRental record);
    
    /**
     * 加载所有用户信息
     * @return
     */
    public List<UserRental> loadAllUsers();
    
    /**
     * 根据手机号查找用户
     * @param telPhone
     * @return
     */
    public UserRental findByTelPhone(String telPhone);
    
}