package com.wgjev.weibus.dao;

import java.util.List;
import java.util.Map;

import com.wgjev.weibus.entity.SiteInfo;

public interface SiteInfoMapper {
    int deleteByPrimaryKey(Integer siteid);

    int insert(SiteInfo record);

    int insertSelective(SiteInfo record);

    SiteInfo selectByPrimaryKey(Integer siteid);

    int updateByPrimaryKeySelective(SiteInfo record);

    int updateByPrimaryKey(SiteInfo record);
    
    /**
     * 根据公司ID显示站点信息
     * @param companyID
     * @return
     */
    public List<SiteInfo> loadSiteInfoByCompanyID(Integer companyID);
    
    /**
     * 加载所有站点信息
     * @return
     */
    public List<SiteInfo> loadSiteInfos();
    
    /**
     * 根据站点编号和公司ID查询站点信息
     * @param params
     * @return
     */
    public List<SiteInfo> findSiteInfoBySiteNoAndCompanyID(Map<String, Object> params);
    
    
}