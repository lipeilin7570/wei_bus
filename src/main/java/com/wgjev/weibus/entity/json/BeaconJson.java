package com.wgjev.weibus.entity.json;

import java.util.Date;

import com.wgjev.weibus.util.BusUtil;

public class BeaconJson {
	
	private Integer beaconID;
	private String beaconNo;
	private String createTime;
	private String UUID;
	private String Major;
	private String Minor;
	private String Mac;
	private String position;
	private String fixTime;
	private Integer siteID;
	private String siteName;
	
	private Integer status;
	private Integer companyID;
	private String companyName;
	private String shortName;
	
	private Integer optID;
	private String optName;
	private String remark;
	
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public String  getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String  companyName) {
		this.companyName = companyName;
	}
	public Integer getBeaconID() {
		return beaconID;
	}
	public void setBeaconID(Integer beaconID) {
		this.beaconID = beaconID;
	}
	public String getBeaconNo() {
		return beaconNo;
	}
	public void setBeaconNo(String beaconNo) {
		this.beaconNo = beaconNo;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = BusUtil.dateToString(createTime);
	}
	public String getUUID() {
		return UUID;
	}
	public void setUUID(String uUID) {
		UUID = uUID;
	}
	public String getMajor() {
		return Major;
	}
	public void setMajor(String major) {
		Major = major;
	}
	public String getMinor() {
		return Minor;
	}
	public void setMinor(String minor) {
		Minor = minor;
	}
	public String getMac() {
		return Mac;
	}
	public void setMac(String mAC) {
		Mac = mAC;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getFixTime() {
		return fixTime;
	}
	public void setFixTime(Date fixTime) {
		this.fixTime = BusUtil.dateToString(fixTime);
	}
	public Integer getSiteID() {
		return siteID;
	}
	public void setSiteID(Integer siteID) {
		this.siteID = siteID;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getCompanyID() {
		return companyID;
	}
	public void setCompanyID(Integer companyID) {
		this.companyID = companyID;
	}
	public Integer getOptID() {
		return optID;
	}
	public void setOptID(Integer optID) {
		this.optID = optID;
	}
	public String getOptName() {
		return optName;
	}
	public void setOptName(String optName) {
		this.optName = optName;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
