package com.wgjev.weibus.dao.json;

import com.wgjev.weibus.entity.json.SiteHasCarsAndParkJson;

public interface SiteHasCarsAndParksJsonMapper {
	/**
     * 根据站点ID查询站点内车辆和车位信息
     * @param siteID
     * @return
     */
    public SiteHasCarsAndParkJson findSiteCarsParksBySiteID(Integer siteID);
}
