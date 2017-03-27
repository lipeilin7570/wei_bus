package com.wgjev.weibus.entity.json;

import java.util.Date;

import com.wgjev.weibus.util.BusUtil;

public class CompanyJson {
	private Integer companyID;
	private String companyName;
	private String shortName;
	private String zcode;
	private double lng;
	private double lat;
	
	private String companyPhone;
	private String contacts;
	private String createtime;
	private Integer status;
	private Integer conpanyCode;
	private Integer regionStatus;
	private String remark;
	private String pCompanyName;
	private String pShortName;
	private String address;
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCompanyPhone() {
		return companyPhone;
	}
	public void setCompanyPhone(String companyPhone) {
		this.companyPhone = companyPhone;
	}
	public String getContacts() {
		return contacts;
	}
	public void setContacts(String contacts) {
		this.contacts = contacts;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = BusUtil.dateToString(createtime).substring(0, 19);
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getConpanyCode() {
		return conpanyCode;
	}
	public void setConpanyCode(Integer conpanyCode) {
		this.conpanyCode = conpanyCode;
	}
	public Integer getRegionStatus() {
		return regionStatus;
	}
	public void setRegionStatus(Integer regionStatus) {
		this.regionStatus = regionStatus;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getpCompanyName() {
		return pCompanyName;
	}
	public void setpCompanyName(String pCompanyName) {
		this.pCompanyName = pCompanyName;
	}
	public String getpShortName() {
		return pShortName;
	}
	public void setpShortName(String pShortName) {
		this.pShortName = pShortName;
	}
	public Integer getCompanyID() {
		return companyID;
	}
	public void setCompanyID(Integer companyID) {
		this.companyID = companyID;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public String getZcode() {
		return zcode;
	}
	public void setZcode(String zcode) {
		this.zcode = zcode;
	}
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	
}
