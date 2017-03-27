package com.wgjev.weibus.entity.json;

public class CarStatusInfoJson {
	private Integer carID;
	private String carNo;
	private String modelName;
	private String alias;
	private Integer carServiceStatus;
	private Integer carStatus;
	private double lng;
	private double lat;
	private String location;
	private double remainKon;
	private Integer electricity;
	private Integer electricityStatus;
	
	
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
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public Integer getCarServiceStatus() {
		return carServiceStatus;
	}
	public void setCarServiceStatus(Integer carServiceStatus) {
		this.carServiceStatus = carServiceStatus;
	}
	public Integer getCarStatus() {
		return carStatus;
	}
	public void setCarStatus(Integer carStatus) {
		this.carStatus = carStatus;
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public double getRemainKon() {
		return remainKon;
	}
	public void setRemainKon(double remainKon) {
		this.remainKon = remainKon;
	}
	public Integer getElectricity() {
		return electricity;
	}
	public void setElectricity(Integer electricity) {
		this.electricity = electricity;
	}
	public Integer getElectricityStatus() {
		return electricityStatus;
	}
	public void setElectricityStatus(Integer electricityStatus) {
		this.electricityStatus = electricityStatus;
	}
	
	
}
