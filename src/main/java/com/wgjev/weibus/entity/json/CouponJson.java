package com.wgjev.weibus.entity.json;

import java.util.Date;

import com.wgjev.weibus.util.BusUtil;

public class CouponJson {
	private int couponID;
	private String couponNo;
	private String couponName;
	private int couponModel;
	private int couponType;
	private int sendType;
	private int sendModel;
	private String sendDate;
	private String beginDate;
	private String endDate;
	private int createManID;
	private String createMan;
	private String remark;
	private int companyID;
	private double couponMoney;
	private double limitMoney;
	private String shortName;
	private int status;
	private String appointCompany;
	
	private Integer auditStatus;
	
	public Integer getAuditStatus() {
		return auditStatus;
	}
	public void setAuditStatus(Integer auditStatus) {
		this.auditStatus = auditStatus;
	}
	
	public double getCouponMoney() {
		return couponMoney;
	}
	public void setCouponMoney(double couponMoney) {
		this.couponMoney = couponMoney;
	}
	public double getLimitMoney() {
		return limitMoney;
	}
	public void setLimitMoney(double limitMoney) {
		this.limitMoney = limitMoney;
	}
	public String getAppointCompany() {
		return appointCompany;
	}
	public void setAppointCompany(String appointCompany) {
		this.appointCompany = appointCompany;
	}
	public String getSendDate() {
		return sendDate;
	}
	public void setSendDate(Date sendDate) {
		this.sendDate = BusUtil.dateToString(sendDate).substring(0, 19);
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getCouponID() {
		return couponID;
	}
	public void setCouponID(int couponID) {
		this.couponID = couponID;
	}
	public String getCouponNo() {
		return couponNo;
	}
	public void setCouponNo(String couponNo) {
		this.couponNo = couponNo;
	}
	public String getCouponName() {
		return couponName;
	}
	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}
	public int getCouponModel() {
		return couponModel;
	}
	public void setCouponModel(int couponModel) {
		this.couponModel = couponModel;
	}
	public int getCouponType() {
		return couponType;
	}
	public void setCouponType(int couponType) {
		this.couponType = couponType;
	}
	public int getSendType() {
		return sendType;
	}
	public void setSendType(int sendType) {
		this.sendType = sendType;
	}
	public int getSendModel() {
		return sendModel;
	}
	public void setSendModel(int sendModel) {
		this.sendModel = sendModel;
	}
	public String getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(Date beginDate) {
		this.beginDate = BusUtil.dateToString(beginDate).substring(0, 19);
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = BusUtil.dateToString(endDate).substring(0, 19);
	}
	public int getCreateManID() {
		return createManID;
	}
	public void setCreateManID(int createManID) {
		this.createManID = createManID;
	}
	public String getCreateMan() {
		return createMan;
	}
	public void setCreateMan(String createMan) {
		this.createMan = createMan;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getCompanyID() {
		return companyID;
	}
	public void setCompanyID(int companyID) {
		this.companyID = companyID;
	}
	
}
