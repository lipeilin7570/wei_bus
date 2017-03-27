package com.wgjev.weibus.dao.json;

import com.wgjev.weibus.entity.json.OptViewJson;

public interface OptViewJsonMapper {
	
	public OptViewJson findOptByUserID(Integer operatorID);
	
}
