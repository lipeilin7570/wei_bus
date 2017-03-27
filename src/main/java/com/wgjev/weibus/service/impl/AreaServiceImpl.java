package com.wgjev.weibus.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wgjev.weibus.dao.RegionInfoMapper;
import com.wgjev.weibus.dao.ZcodeInfoMapper;
import com.wgjev.weibus.entity.BusResult;
import com.wgjev.weibus.entity.RegionInfo;
import com.wgjev.weibus.entity.ZcodeInfo;
import com.wgjev.weibus.service.AreaService;

@Service
public class AreaServiceImpl implements AreaService {
	
	@Resource
	private ZcodeInfoMapper zcodeInfoMapper;
	
	@Resource
	private RegionInfoMapper regionInfoMapper;
	
	/**
	 * 查询国家行政区划
	 */
	public BusResult loadChinaZcodes() {
		BusResult result = new BusResult();
		List<ZcodeInfo> list = zcodeInfoMapper.loadChinaZcodes();
		result.setStatus(0);
		result.setData(list);
		
		return result;
	}
	
	/**
	 * 查询运营区域列表
	 */
	public BusResult loadRegions() {
		BusResult result = new BusResult();
		
		List<RegionInfo> list = regionInfoMapper.loadRegionInfo();
		
		result.setStatus(0);
		result.setData(list);
		
		return result;
	}
	
	
	/**
	 * 增加运营区域
	 * @param name
	 * @param regionNo
	 * @param zcode
	 * @return
	 */
	public BusResult addRegion(String name, String regionNo, String zcode, String remark) {
		// TODO Auto-generated method stub
		BusResult result = new BusResult();
		RegionInfo regionInfo = new RegionInfo();
		regionInfo.setName(name);
		regionInfo.setRegionno(regionNo);
		regionInfo.setZcode(zcode);
		regionInfo.setRemark(remark);
		regionInfo.setStatus(1);
		regionInfoMapper.insertSelective(regionInfo);
		result.setStatus(0);
		return result;
	}

	/**
	 * 修改运营区域信息
	 * @param regionID
	 * @param name
	 * @param regionNo
	 * @param zcode
	 * @return
	 */
	public BusResult changeRegion(Integer regionID, String name, String regionNo, String zcode, String remark) {
		// TODO Auto-generated method stub
		BusResult result = new BusResult();
		RegionInfo regionInfo = new RegionInfo();
		regionInfo.setRegionid(regionID);
		regionInfo.setName(name);
		regionInfo.setRegionno(regionNo);
		regionInfo.setZcode(zcode);
		regionInfo.setRemark(remark);
		regionInfoMapper.updateByPrimaryKeySelective(regionInfo);
		result.setStatus(0);
		
		return result;
	}

	
	/**
	 * 删除运营区域
	 * @param regionID
	 * @param status
	 * @return
	 */
	public BusResult delRegion(Integer regionID, Integer status) {
		// TODO Auto-generated method stub
		BusResult result = new BusResult();
		RegionInfo regionInfo = new RegionInfo();
		
		regionInfo.setRegionid(regionID);
		regionInfo.setStatus(status);
		regionInfoMapper.updateByPrimaryKeySelective(regionInfo);
		result.setStatus(0);
		
		return result;
	}
	
}
