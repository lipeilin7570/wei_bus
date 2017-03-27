package com.wgjev.weibus.entity.json;

import java.math.BigDecimal;
import java.util.Date;

import com.wgjev.weibus.util.BusUtil;

public class LeaseOrderJson {
	private Integer leaseID;
	private String leaseNo;
	private int userID;
	private String userName;
	private String carNo;
	private Integer leaseType;
	private Date leaseCreateTime;
	private String leaseCreateTimeStr;
	
	private Date takeTime;
	private String takeTimeStr;
	private Integer takeSiteID;
	private String takeSite;
	
	private Date backTime;
	private String backTimeStr;
	private Integer backSiteID;
	private String backSite;
	
	private BigDecimal feeMoney;
	private BigDecimal deuctMoney;
	private BigDecimal payMoney;
	private Integer leaseStatus;
	private Integer leaseFeeStatus;
	
	private Integer illagalStatus;
	private Integer faultStatus;
	private Integer accidentStatus;
	private Integer breachStatus;
	
	private String userNo;
	private String telPhone;
	private String cancelTimeStr;
	private String checkTimeStr;
	
	private String couponNo;
	
	private Integer carID;
	
	public Integer getCarID() {
		return carID;
	}
	public void setCarID(Integer carID) {
		this.carID = carID;
	}
	public String getTakeSite() {
		return takeSite;
	}
	public void setTakeSite(String takeSite) {
		this.takeSite = takeSite;
	}
	public String getBackSite() {
		return backSite;
	}
	public void setBackSite(String backSite) {
		this.backSite = backSite;
	}
	public String getCouponNo() {
		return couponNo;
	}
	public void setCouponNo(String couponNo) {
		this.couponNo = couponNo;
	}
	public void setCancelTimeStr(String cancelTimeStr) {
		this.cancelTimeStr = cancelTimeStr.substring(0, 19);
	}
	public void setCheckTimeStr(String checkTimeStr) {
		this.checkTimeStr = checkTimeStr.substring(0, 19);
	}
	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	public String getTelPhone() {
		return telPhone;
	}
	public void setTelPhone(String telPhone) {
		this.telPhone = telPhone;
	}
	public String getCancelTimeStr() {
		return cancelTimeStr;
	}
	public void setCancelTimeStr(Date cancelTimeStr) {
		this.cancelTimeStr = BusUtil.dateToString(cancelTimeStr).substring(0, 19);
	}
	public String getCheckTimeStr() {
		return checkTimeStr;
	}
	public void setCheckTimeStr(Date checkTimeStr) {
		this.checkTimeStr = BusUtil.dateToString(checkTimeStr).substring(0, 19);
	}
	public Integer getIllagalStatus() {
		return illagalStatus;
	}
	public void setIllagalStatus(Integer illagalStatus) {
		this.illagalStatus = illagalStatus;
	}
	public Integer getFaultStatus() {
		return faultStatus;
	}
	public void setFaultStatus(Integer faultStatus) {
		this.faultStatus = faultStatus;
	}
	public Integer getAccidentStatus() {
		return accidentStatus;
	}
	public void setAccidentStatus(Integer accidentStatus) {
		this.accidentStatus = accidentStatus;
	}
	public Integer getBreachStatus() {
		return breachStatus;
	}
	public void setBreachStatus(Integer breachStatus) {
		this.breachStatus = breachStatus;
	}
	public Integer getLeaseStatus() {
		return leaseStatus;
	}
	public void setLeaseStatus(Integer leaseStatus) {
		this.leaseStatus = leaseStatus;
	}
	public Integer getLeaseFeeStatus() {
		return leaseFeeStatus;
	}
	public void setLeaseFeeStatus(Integer leaseFeeStatus) {
		this.leaseFeeStatus = leaseFeeStatus;
	}
	public Integer getLeaseID() {
		return leaseID;
	}
	public void setLeaseID(Integer leaseID) {
		this.leaseID = leaseID;
	}
	public String getLeaseNo() {
		return leaseNo;
	}
	public void setLeaseNo(String leaseNo) {
		this.leaseNo = leaseNo;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCarNo() {
		return carNo;
	}
	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}
	public Integer getLeaseType() {
		return leaseType;
	}
	public void setLeaseType(Integer leaseType) {
		this.leaseType = leaseType;
	}
	public Date getLeaseCreateTime() {
		return leaseCreateTime;
	}
	public void setLeaseCreateTime(Date leaseCreateTime) {
		this.leaseCreateTime = leaseCreateTime;
		this.leaseCreateTimeStr = BusUtil.dateToString(leaseCreateTime).substring(0, 19);
	}
	public String getLeaseCreateTimeStr() {
		return leaseCreateTimeStr;
	}
	public void setLeaseCreateTimeStr(String leaseCreateTimeStr) {
		this.leaseCreateTimeStr = leaseCreateTimeStr.substring(0, 19);
	}
	public Date getTakeTime() {
		return takeTime;
	}
	public void setTakeTime(Date takeTime) {
		this.takeTime = takeTime;
		this.takeTimeStr = BusUtil.dateToString(takeTime).substring(0, 19);
	}
	public String getTakeTimeStr() {
		return takeTimeStr;
	}
	public void setTakeTimeStr(String takeTimeStr) {
		this.takeTimeStr = takeTimeStr;
	}
	public Integer getTakeSiteID() {
		return takeSiteID;
	}
	public void setTakeSiteID(Integer takeSiteID) {
		this.takeSiteID = takeSiteID;
	}
	public Date getBackTime() {
		return backTime;
	}
	public void setBackTime(Date backTime) {
		this.backTime = backTime;
		this.backTimeStr = BusUtil.dateToString(backTime).substring(0, 19);
	}
	public String getBackTimeStr() {
		return backTimeStr;
	}
	public void setBackTimeStr(String backTimeStr) {
		this.backTimeStr = backTimeStr.substring(0, 19);
	}
	public Integer getBackSiteID() {
		return backSiteID;
	}
	public void setBackSiteID(Integer backSiteID) {
		this.backSiteID = backSiteID;
	}
	public BigDecimal getFeeMoney() {
		return feeMoney;
	}
	public void setFeeMoney(BigDecimal feeMoney) {
		this.feeMoney = feeMoney;
	}
	public BigDecimal getDeuctMoney() {
		return deuctMoney;
	}
	public void setDeuctMoney(BigDecimal deuctMoney) {
		this.deuctMoney = deuctMoney;
	}
	public BigDecimal getPayMoney() {
		return payMoney;
	}
	public void setPayMoney(BigDecimal payMoney) {
		this.payMoney = payMoney;
	}
	
}
