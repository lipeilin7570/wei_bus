package com.wgjev.weibus.entity.json;

public class OrderResultJson {
	private Integer status;
	private Integer reserveCount;
	private Integer getCount;
	private Integer payCount;
	private Integer illegalCount;
	private Integer accidentCount;
	private Object orders;
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getReserveCount() {
		return reserveCount;
	}
	public void setReserveCount(Integer reserveCount) {
		this.reserveCount = reserveCount;
	}
	public Integer getGetCount() {
		return getCount;
	}
	public void setGetCount(Integer getCount) {
		this.getCount = getCount;
	}
	public Integer getPayCount() {
		return payCount;
	}
	public void setPayCount(Integer payCount) {
		this.payCount = payCount;
	}
	public Integer getIllegalCount() {
		return illegalCount;
	}
	public void setIllegalCount(Integer illegalCount) {
		this.illegalCount = illegalCount;
	}
	public Integer getAccidentCount() {
		return accidentCount;
	}
	public void setAccidentCount(Integer accidentCount) {
		this.accidentCount = accidentCount;
	}
	public Object getOrders() {
		return orders;
	}
	public void setOrders(Object orders) {
		this.orders = orders;
	}
	
	
	
}
