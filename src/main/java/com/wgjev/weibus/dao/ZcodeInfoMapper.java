package com.wgjev.weibus.dao;

import java.util.List;

import com.wgjev.weibus.entity.ZcodeInfo;

public interface ZcodeInfoMapper {
	public int insert(ZcodeInfo record);
	
    public int insertSelective(ZcodeInfo record);
    
    /**
	 * 查询国家行政区划
	 */
    public List<ZcodeInfo> loadChinaZcodes();
    
    
}