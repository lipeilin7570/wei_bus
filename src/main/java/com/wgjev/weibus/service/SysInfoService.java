package com.wgjev.weibus.service;

import com.wgjev.weibus.entity.BusResult;

public interface SysInfoService {
	//查询数据字典类型
	public BusResult loadAllDictTypes();
	
	//查询已定义的数据字典
	public BusResult findDictByTypeID(int typeID);
	
	//增加数据字典
	public BusResult addDict(int typeID, String dictName, int dictID);
	
	//修改数据字典
	public BusResult updataDict(int typeID, String newDictName, int dictID);
	
	//删除数据字典
	public BusResult delDict(int typeID, int dictID);
	
	/**
	 * 加载所有菜单信息
	 * @return
	 */
	public BusResult loadMenus();
	
}
