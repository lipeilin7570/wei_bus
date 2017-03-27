package com.wgjev.weibus.entity.json;

import java.math.BigDecimal;

public class PriceJson {
	private Integer priceID;
	private Integer priceVersion;
	private String priceName;
	private String carModelName;
	private BigDecimal hourPrice;
	private BigDecimal startPrice;
	private Integer freeTime;
	
	private BigDecimal dayPrice;
	private BigDecimal nightPrice;
	private BigDecimal weekPrice;
	private BigDecimal hourMileage;
	private BigDecimal dayMileage;
	private BigDecimal nightMileage;
	private BigDecimal weekMileage;
	private BigDecimal superPrice;
	
	private String dayBeginTime;
	private String dayEndTime;
	
	private Integer startCharge;
	private String createMan;
	private String createTime;
	private Integer status;
	private Integer companyID;
	private String companyName;
	
	public BigDecimal getNightMileage() {
		return nightMileage;
	}
	public void setNightMileage(BigDecimal nightMileage) {
		this.nightMileage = nightMileage;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public int getPriceID() {
		return priceID;
	}
	public void setPriceID(Integer priceID) {
		this.priceID = priceID;
	}
	public int getPriceVersion() {
		return priceVersion;
	}
	public void setPriceVersion(Integer priceVersion) {
		this.priceVersion = priceVersion;
	}
	public String getPriceName() {
		return priceName;
	}
	public void setPriceName(String priceName) {
		this.priceName = priceName;
	}
	
	public String getCarModelName() {
		return carModelName;
	}
	public void setCarModelName(String carModelName) {
		this.carModelName = carModelName;
	}
	public BigDecimal getHourPrice() {
		return hourPrice;
	}
	public void setHourPrice(BigDecimal hourPrice) {
		this.hourPrice = hourPrice;
	}
	public BigDecimal getStartPrice() {
		return startPrice;
	}
	public void setStartPrice(BigDecimal startPrice) {
		this.startPrice = startPrice;
	}
	public int getFreeTime() {
		return freeTime;
	}
	public void setFreeTime(Integer freeTime) {
		this.freeTime = freeTime;
	}
	public BigDecimal getDayPrice() {
		return dayPrice;
	}
	public void setDayPrice(BigDecimal dayPrice) {
		this.dayPrice = dayPrice;
	}
	public BigDecimal getNightPrice() {
		return nightPrice;
	}
	public void setNightPrice(BigDecimal nightPrice) {
		this.nightPrice = nightPrice;
	}
	public BigDecimal getWeekPrice() {
		return weekPrice;
	}
	public void setWeekPrice(BigDecimal weekPrice) {
		this.weekPrice = weekPrice;
	}
	public BigDecimal getHourMileage() {
		return hourMileage;
	}
	public void setHourMileage(BigDecimal hourMileage) {
		this.hourMileage = hourMileage;
	}
	public BigDecimal getDayMileage() {
		return dayMileage;
	}
	public void setDayMileage(BigDecimal dayMileage) {
		this.dayMileage = dayMileage;
	}
	public BigDecimal getWeekMileage() {
		return weekMileage;
	}
	public void setWeekMileage(BigDecimal weekMileage) {
		this.weekMileage = weekMileage;
	}
	public BigDecimal getSuperPrice() {
		return superPrice;
	}
	public void setSuperPrice(BigDecimal superPrice) {
		this.superPrice = superPrice;
	}
	public String getDayBeginTime() {
		return dayBeginTime;
	}
	public void setDayBeginTime(String dayBeginTime) {
		this.dayBeginTime = dayBeginTime;
	}
	public String getDayEndTime() {
		return dayEndTime;
	}
	public void setDayEndTime(String dayEndTime) {
		this.dayEndTime = dayEndTime;
	}
	public int getStartCharge() {
		return startCharge;
	}
	public void setStartCharge(Integer startCharge) {
		this.startCharge = startCharge;
	}

	public String getCreateMan() {
		return createMan;
	}
	public void setCreateMan(String createMan) {
		this.createMan = createMan;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public int getCompanyID() {
		return companyID;
	}
	public void setCompanyID(Integer companyID) {
		this.companyID = companyID;
	}
	
}
