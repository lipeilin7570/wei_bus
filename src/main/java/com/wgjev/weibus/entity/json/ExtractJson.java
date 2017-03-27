package com.wgjev.weibus.entity.json;

import java.util.Date;

import com.wgjev.weibus.util.BusUtil;

public class ExtractJson {
	private Integer extractID;
	private String extractNo;
	private Integer userID;
	private String userName;
	private String userNo;
	private String telPhone;
	private String createTime;
	private double feeMoney;
	private Integer status;
	private Integer accountType;
	private String accountNo;
	private String auditMan;
	private String auditTime;
	private String reason;
	private Integer auditStatus;
	
	public String getAuditMan() {
		return auditMan;
	}
	public void setAuditMan(String auditMan) {
		this.auditMan = auditMan;
	}
	public String getAuditTime() {
		return auditTime;
	}
	public void setAuditTime(Date auditTime) {
		this.auditTime = BusUtil.dateToString(auditTime).substring(0, 19);
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Integer getAuditStatus() {
		return auditStatus;
	}
	public void setAuditStatus(Integer auditStatus) {
		this.auditStatus = auditStatus;
	}
	public Integer getExtractID() {
		return extractID;
	}
	public void setExtractID(Integer extractID) {
		this.extractID = extractID;
	}
	public String getExtractNo() {
		return extractNo;
	}
	public void setExtractNo(String extractNo) {
		this.extractNo = extractNo;
	}
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = BusUtil.dateToString(createTime).substring(0, 19);
	}
	public double getFeeMoney() {
		return feeMoney;
	}
	public void setFeeMoney(double feeMoney) {
		this.feeMoney = feeMoney;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getAccountType() {
		return accountType;
	}
	public void setAccountType(Integer accountType) {
		this.accountType = accountType;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	
}
