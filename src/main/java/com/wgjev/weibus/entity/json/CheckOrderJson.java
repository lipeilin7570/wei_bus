package com.wgjev.weibus.entity.json;

import java.util.Date;

import com.wgjev.weibus.util.BusUtil;

public class CheckOrderJson {
	private Integer checkID;
	private String checkNo;
	private Integer leaseID;
	private Integer carID;
	private String carNo;
	private Integer checkType;
	private String checkTime;
	private String frontImg;
	private String leftImg;
	private String backImg;
	private String rightImg;
	private String remark;
	
	public Integer getCheckID() {
		return checkID;
	}
	public void setCheckID(Integer checkID) {
		this.checkID = checkID;
	}
	public String getCheckNo() {
		return checkNo;
	}
	public void setCheckNo(String checkNo) {
		this.checkNo = checkNo;
	}
	public Integer getLeaseID() {
		return leaseID;
	}
	public void setLeaseID(Integer leaseID) {
		this.leaseID = leaseID;
	}
	public Integer getCarID() {
		return carID;
	}
	public void setCarID(Integer carID) {
		this.carID = carID;
	}
	public String getCarNo() {
		return carNo;
	}
	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}
	public Integer getCheckType() {
		return checkType;
	}
	public void setCheckType(Integer checkType) {
		this.checkType = checkType;
	}
	public String getCheckTime() {
		return checkTime;
	}
	public void setCheckTime(Date checkTime) {
		this.checkTime = BusUtil.dateToString(checkTime).substring(0, 19);
	}
	public String getFrontImg() {
		return frontImg;
	}
	public void setFrontImg(String frontImg) {
		if (frontImg != null) {
			this.frontImg = BusUtil.SERVICE_IP + frontImg;
		}
	}
	public String getLeftImg() {
		return leftImg;
	}
	public void setLeftImg(String leftImg) {
		if (leftImg != null) {
			this.leftImg = BusUtil.SERVICE_IP + leftImg;
		}
	}
	public String getBackImg() {
		return backImg;
	}
	public void setBackImg(String backImg) {
		if (backImg != null) {
			this.backImg = BusUtil.SERVICE_IP + backImg;
		}
	}
	public String getRightImg() {
		return rightImg;
	}
	public void setRightImg(String rightImg) {
		if (rightImg != null) {
			this.rightImg = BusUtil.SERVICE_IP + rightImg;
		}
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
