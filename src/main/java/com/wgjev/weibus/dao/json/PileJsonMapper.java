package com.wgjev.weibus.dao.json;

import java.util.List;

import com.wgjev.weibus.entity.json.PileJson;

public interface PileJsonMapper {
	
	/**
	 * 根据站点ID查询充电桩信息
	 * @param siteID
	 * @return
	 */
	public List<PileJson> findPileBySiteID(Integer siteID);
	
}
