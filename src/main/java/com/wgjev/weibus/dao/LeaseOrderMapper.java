package com.wgjev.weibus.dao;

import java.util.List;

import com.wgjev.weibus.entity.LeaseOrder;

public interface LeaseOrderMapper {
    int deleteByPrimaryKey(Integer leaseid);

    int insert(LeaseOrder record);

    int insertSelective(LeaseOrder record);

    LeaseOrder selectByPrimaryKey(Integer leaseid);

    int updateByPrimaryKeySelective(LeaseOrder record);

    int updateByPrimaryKey(LeaseOrder record);
    
    /**
     * 加载所有订单信息
     * @return
     */
    public List<LeaseOrder> loadAllLeaseOrder();
    
    /**
     * 根据状态获取订单信息
     * @param status
     * @return
     */
    public LeaseOrder loadLeaseOrderByStatus(Integer status);
    
    
}