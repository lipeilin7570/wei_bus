package com.wgjev.weibus.dao.json;

import java.util.List;

import com.wgjev.weibus.entity.json.PriceJson;

public interface PriceJsonMapper {
	/**
	 * 显示某公司的价格表
	 * @param companyID
	 * @return
	 */
	public List<PriceJson> loadAllPriceByCompanyID(Integer companyID);
	
	/**
	 * 显示所有价格表
	 * @return
	 */
	public List<PriceJson> loadAllPrice();
	
	/**
	 * 查看价格表详情
	 * @param priceID
	 * @return
	 */
	public PriceJson findPriceByPriceID(Integer priceID);
	
}
