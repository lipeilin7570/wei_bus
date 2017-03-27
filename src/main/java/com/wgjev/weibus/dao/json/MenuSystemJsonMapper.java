package com.wgjev.weibus.dao.json;

import java.util.List;

import com.wgjev.weibus.entity.json.MenuSystemJson;

public interface MenuSystemJsonMapper {
	/**
	 * 加载所有菜单
	 * @return
	 */
	public List<MenuSystemJson> loadAllMenu();
	
	/**
	 * 根据菜单ID查询菜单信息
	 * @param menuID
	 * @return
	 */
	public MenuSystemJson queryMenuByMenuID(Integer menuID);
	
	
}
