package com.wgjev.weibus.dao;

import com.wgjev.weibus.entity.PriceFinance;

public interface PriceFinanceMapper {
    int deleteByPrimaryKey(Integer priceid);

    int insert(PriceFinance record);

    int insertSelective(PriceFinance record);

    PriceFinance selectByPrimaryKey(Integer priceid);

    int updateByPrimaryKeySelective(PriceFinance record);

    int updateByPrimaryKey(PriceFinance record);
}