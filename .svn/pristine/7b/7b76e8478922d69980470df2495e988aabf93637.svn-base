package com.wgjev.weibus.dao;

import java.util.Map;

import com.wgjev.weibus.entity.ModelDetailInfo;

public interface ModelDetailInfoMapper {
    int deleteByPrimaryKey(Integer modeldetailid);

    int insert(ModelDetailInfo record);

    int insertSelective(ModelDetailInfo record);

    ModelDetailInfo selectByPrimaryKey(Integer modeldetailid);

    int updateByPrimaryKeySelective(ModelDetailInfo record);

    int updateByPrimaryKey(ModelDetailInfo record);
    
    /**
     * 根据车辆模型名和公司ID查找车模信息
     * @param params
     * @return
     */
    public ModelDetailInfo findModelDetailByModelNameAndCompanyID(Map<String, Object> params);
    
}