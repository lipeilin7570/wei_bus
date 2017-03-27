package com.wgjev.weibus.entity.json;

public class StationJson {
	private int SiteID;
	private String SiteName;
	private String SiteAddr;
	private float Lng;
	private float Lat;
	private String StartTime;
	private String EndTime;
	private int CanRentCar;
	private int CanUseMiniPark;
	private int CanUseUsePark;
	private int HasCar;
	private int Status;
	private int PileStatus;
	private String SiteIcon;
	
	public String getSiteIcon() {
		return SiteIcon;
	}
	public void setSiteIcon(String siteIcon) {
		SiteIcon = siteIcon;
	}
	public int getHasCar() {
		return HasCar;
	}
	public void setHasCar(int hasCar) {
		HasCar = hasCar;
	}
	public int getStatus() {
		return Status;
	}
	public void setStatus(int status) {
		Status = status;
	}
	public int getPileStatus() {
		return PileStatus;
	}
	public void setPileStatus(int pileStatus) {
		PileStatus = pileStatus;
	}
	public int getSiteID() {
		return SiteID;
	}
	public void setSiteID(int siteID) {
		SiteID = siteID;
	}
	public String getSiteName() {
		return SiteName;
	}
	public void setSiteName(String siteName) {
		SiteName = siteName;
	}
	public String getSiteAddr() {
		return SiteAddr;
	}
	public void setSiteAddr(String siteAddr) {
		SiteAddr = siteAddr;
	}
	public float getLng() {
		return Lng;
	}
	public void setLng(float lng) {
		Lng = lng;
	}
	public float getLat() {
		return Lat;
	}
	public void setLat(float lat) {
		Lat = lat;
	}
	public String getStartTime() {
		return StartTime;
	}
	public void setStartTime(String startTime) {
		StartTime = startTime;
	}
	public String getEndTime() {
		return EndTime;
	}
	public void setEndTime(String endTime) {
		EndTime = endTime;
	}
	public int getCanRentCar() {
		return CanRentCar;
	}
	public void setCanRentCar(int canRentCar) {
		CanRentCar = canRentCar;
	}
	public int getCanUseMiniPark() {
		return CanUseMiniPark;
	}
	public void setCanUseMiniPark(int canUseMiniPark) {
		CanUseMiniPark = canUseMiniPark;
	}
	public int getCanUseUsePark() {
		return CanUseUsePark;
	}
	public void setCanUseUsePark(int canUseUsePark) {
		CanUseUsePark = canUseUsePark;
	}
}
