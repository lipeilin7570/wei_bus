package com.wgjev.weibus.dao.json;

import java.util.List;

import com.wgjev.weibus.entity.json.LeaseOrderJson;

public interface LeaseOrderJsonMapper {
	/**
	 * 显示所有订单信息
	 * @return
	 */
	public List<LeaseOrderJson> loadAllLeaseOrderJson();
	
	
}
