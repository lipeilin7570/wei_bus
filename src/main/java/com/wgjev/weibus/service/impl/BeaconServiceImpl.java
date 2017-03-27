package com.wgjev.weibus.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wgjev.weibus.dao.BeaconInfoMapper;
import com.wgjev.weibus.dao.OperatorSysMapper;
import com.wgjev.weibus.dao.json.BeaconJsonMapper;
import com.wgjev.weibus.dao.json.OptViewJsonMapper;
import com.wgjev.weibus.entity.BeaconInfo;
import com.wgjev.weibus.entity.BusResult;
import com.wgjev.weibus.entity.OperatorSys;
import com.wgjev.weibus.entity.json.BeaconJson;
import com.wgjev.weibus.entity.json.OptViewJson;
import com.wgjev.weibus.service.BeaconService;
import com.wgjev.weibus.util.BusUtil;

@Service
public class BeaconServiceImpl implements BeaconService {
	
	@Resource
	private BeaconJsonMapper beaconJsonMapper;
	
	@Resource
	private BeaconInfoMapper beaconInfoMapper;
	
	@Resource
	private OptViewJsonMapper optViewJsonMapper;
	
	@Resource
	private OperatorSysMapper operatorSysMapper;
	
	/**
	 * 根据companyID显示信标信息
	 */
	public BusResult loadBeaconByCompanyID(Integer companyID) {
		// TODO Auto-generated method stub
		BusResult result = new BusResult();
		List<BeaconJson> list;
		if (companyID == 0) {
			list = beaconJsonMapper.loadAllBeacon();
		}else {
			list = beaconJsonMapper.loadBeaconByCompanyID(companyID);
		}
		result.setStatus(0);
		result.setData(list);
		return result;
	}
	
	
	/**
	 * 根据siteID查找信标信息
	 */
	public BusResult loadBeaconBySiteID(Integer siteID) {
		// TODO Auto-generated method stub
		BusResult result = new BusResult();
		List<BeaconJson> list = beaconJsonMapper.loadBeaconBySiteID(siteID);
		
		result.setStatus(0);
		result.setData(list);
		return result;
	}

	/**
	 * 添加信标信息
	 */
	public BusResult addBeacom(Integer operatorID, Integer companyID, Integer siteID, String beaconNo, String UUID,
			String Major, String Minor, String Mac, String position, String fixTime, String remark) {
		// TODO Auto-generated method stub
		BusResult result = new BusResult();
//		OptViewJson optViewJson = optViewJsonMapper.findOptByUserID(operatorID);
		OperatorSys operatorSys = operatorSysMapper.selectByPrimaryKey(operatorID);
		
		BeaconInfo beaconInfo = new BeaconInfo();
		if (beaconNo != null) {
			beaconInfo.setBeaconno(beaconNo);
		}
		beaconInfo.setCreatetime(new Date());
		if (UUID != null) {
			beaconInfo.setUuid(UUID);
		}
		if (Major != null) {
			beaconInfo.setMajor(Major);
		}
		if (Minor != null) {
			beaconInfo.setMinor(Minor);
		}
		if (Mac != null) {
			beaconInfo.setMac(Mac);
		}
		if (position != null) {
			beaconInfo.setPosition(position);
		}
		if (fixTime != null) {
			beaconInfo.setFixtime(BusUtil.stringToDateTime(fixTime));
		}
		if (siteID != null) {
			beaconInfo.setSiteid(siteID);
		}
		beaconInfo.setStatus(1);
		if (companyID != null) {
			beaconInfo.setCompanyid(companyID);
		}
		if (remark != null) {
			beaconInfo.setRemark(remark);
		}
		beaconInfo.setOptid(operatorID);
		beaconInfo.setOptname(operatorSys.getSysusename());
		beaconInfoMapper.insertSelective(beaconInfo);
		result.setStatus(0);
		return result;
	}
	
	/**
	 * 修改信标信息
	 */
	public BusResult changeBeacom(Integer operatorID, Integer companyID, Integer siteID, Integer beaconID,
			String beaconNo, String UUID, String Major, String Minor, String Mac, String position, String fixTime,
			String remark, Integer status) {
		// TODO Auto-generated method stub
		BusResult result = new BusResult();
//		OptViewJson optViewJson = optViewJsonMapper.findOptByUserID(operatorID);
		OperatorSys operatorSys = operatorSysMapper.selectByPrimaryKey(operatorID);
		BeaconInfo beaconInfo = new BeaconInfo();
		beaconInfo.setBeaconid(beaconID);
		if (beaconNo != null) {
			beaconInfo.setBeaconno(beaconNo);
		}
		if (UUID != null) {
			beaconInfo.setUuid(UUID);
		}
		if (Major != null) {
			beaconInfo.setMajor(Major);
		}
		if (Minor != null) {
			beaconInfo.setMinor(Minor);
		}
		if (Mac != null) {
			beaconInfo.setMac(Mac);
		}
		if (position != null) {
			beaconInfo.setPosition(position);
		}
		if (fixTime != null) {
			beaconInfo.setFixtime(BusUtil.stringToDateTime(fixTime));
		}
		if (siteID != null) {
			beaconInfo.setSiteid(siteID);
		}
		if (status != null) {
			beaconInfo.setStatus(status);
		}
		if (companyID != null) {
			beaconInfo.setCompanyid(companyID);
		}
		if (remark != null) {
			beaconInfo.setRemark(remark);
		}
		beaconInfo.setOptid(operatorID);
		beaconInfo.setOptname(operatorSys.getSysusename());
		
		beaconInfoMapper.updateByPrimaryKeySelective(beaconInfo);
		
		result.setStatus(0);
		return result;
	}
	

}
