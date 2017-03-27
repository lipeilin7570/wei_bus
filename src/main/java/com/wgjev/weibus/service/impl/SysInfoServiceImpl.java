package com.wgjev.weibus.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wgjev.weibus.dao.DictSysMapper;
import com.wgjev.weibus.dao.DictTypeSysMapper;
import com.wgjev.weibus.dao.json.MenuSystemJsonMapper;
import com.wgjev.weibus.entity.BusResult;
import com.wgjev.weibus.entity.DictSys;
import com.wgjev.weibus.entity.DictSysKey;
import com.wgjev.weibus.entity.DictTypeSys;
import com.wgjev.weibus.entity.json.MenuSystemJson;
import com.wgjev.weibus.service.SysInfoService;

@Service
public class SysInfoServiceImpl implements SysInfoService {
	
	@Resource
	private DictSysMapper dictSysMapper;
	
	@Resource
	private DictTypeSysMapper dictTypeSysMapper;
	
	@Resource
	private MenuSystemJsonMapper menuSystemJsonMapper;
	
	/**
	 * 查询数据字典类型
	 */
	public BusResult loadAllDictTypes() {
		// TODO Auto-generated method stub
		BusResult result = new BusResult();
		List<DictTypeSys> list = dictTypeSysMapper.loadAllDictTypes();
		result.setStatus(0);
		result.setData(list);
		
		return result;
	}
	
	/**
	 * 查询已定义的数据字典
	 */
	public BusResult findDictByTypeID(int typeID) {
		// TODO Auto-generated method stub
		BusResult result = new BusResult();
		List<DictSys> list = dictSysMapper.findDictByTypeID(typeID);
		result.setStatus(0);
		result.setData(list);
		
		return result;
	}

	/**
	 * 增加数据字典
	 */
	public BusResult addDict(int typeID, String dictName, int dictID) {
		// TODO Auto-generated method stub
		BusResult result = new BusResult();
		DictSysKey key = new DictSysKey();
		key.setSysdicttypeid(new Integer(typeID));
		key.setSysdictid(new Integer(dictID));
		
		//判断typeID是否可用
		DictTypeSys has_dictTypeSys = dictTypeSysMapper.selectByPrimaryKey(new Integer(typeID));
		if (has_dictTypeSys == null) {
			result.setStatus(101);
			return result;
		}
		
		//判断dictID是否存在
		DictSys has_dictSys = dictSysMapper.selectByPrimaryKey(key);
		if (has_dictSys != null) {
			result.setStatus(102);
			return result;
		}
		
		DictSys dictSys = new DictSys();
		dictSys.setSysdicttypeid(new Integer(typeID));
		dictSys.setSysdictid(new Integer(dictID));
		dictSys.setSysdictname(dictName);
		dictSys.setStatus(1);
		dictSysMapper.insertSelective(dictSys);
		result.setStatus(0);
		return result;
	}

	/**
	 * 修改数据字典
	 */
	public BusResult updataDict(int typeID, String newDictName, int dictID) {
		// TODO Auto-generated method stub
		BusResult result = new BusResult();
		DictSysKey key = new DictSysKey();
		key.setSysdicttypeid(new Integer(typeID));
		key.setSysdictid(new Integer(dictID));
		
		DictSys dictSys = new DictSys();
		dictSys.setSysdictname(newDictName);
		
		dictSysMapper.updateByPrimaryKeySelective(dictSys);
		result.setStatus(0);
		return result;
	}

	/**
	 * 删除数据字典
	 */
	public BusResult delDict(int typeID, int dictID) {
		// TODO Auto-generated method stub
		BusResult result = new BusResult();
		DictSysKey key = new DictSysKey();
		key.setSysdicttypeid(new Integer(typeID));
		key.setSysdictid(new Integer(dictID));
		
		dictSysMapper.deleteByPrimaryKey(key);
		result.setStatus(0);
		
		return result;
	}

	/**
	 * 加载所有菜单信息
	 */
	public BusResult loadMenus() {
		// TODO Auto-generated method stub
		BusResult result = new BusResult();
		List<MenuSystemJson> list = menuSystemJsonMapper.loadAllMenu();
		result.setStatus(0);
		result.setData(list);
		
		return result;
	}

}
