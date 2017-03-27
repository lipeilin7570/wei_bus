package com.wgjev.weibus.entity.json;

import java.util.Date;

import com.sun.jndi.url.iiopname.iiopnameURLContextFactory;
import com.wgjev.weibus.util.BusUtil;

public class SiteJson {
	private Integer siteID;
	private String siteName;
	private String siteNo;
	private String siteMan;
	private String sitePicIcon;
	private String Zcode;
	private String siteAddress;
	private double lng;
	private double lat;
	private String createTime;
	private String startTime;
	private String endTime;
	
	private int pileStatus;
	private Object piles;
	
	private int status;
	private String companyShortName;
	private int usableCar;
	private int usablePark;
	private int usablePile;
	private String serviceTime;
	
	private int cars;
	private int parks;
	
	private int beaconCount;
	private Object beacons;
	
	private double siteRadius;
	
	public double getSiteRadius() {
		return siteRadius;
	}
	public void setSiteRadius(double siteRadius) {
		this.siteRadius = siteRadius;
	}
	public Object getBeacons() {
		return beacons;
	}
	public void setBeacons(Object beacons) {
		this.beacons = beacons;
	}
	public int getBeaconCount() {
		return beaconCount;
	}
	public void setBeaconCount(int beaconCount) {
		this.beaconCount = beaconCount;
	}
	public int getCars() {
		return cars;
	}
	public void setCars(int cars) {
		this.cars = cars;
	}
	public int getParks() {
		return parks;
	}
	public void setParks(int parks) {
		this.parks = parks;
	}
	public String getServiceTime() {
		return serviceTime;
	}
	public void setServiceTime(String serviceTime) {
		this.serviceTime = serviceTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime.substring(0, 19);
	}
	public Integer getSiteID() {
		return siteID;
	}
	public void setSiteID(Integer siteID) {
		this.siteID = siteID;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public String getSiteNo() {
		return siteNo;
	}
	public void setSiteNo(String siteNo) {
		this.siteNo = siteNo;
	}
	public String getSiteMan() {
		return siteMan;
	}
	public void setSiteMan(String siteMan) {
		this.siteMan = siteMan;
	}
	public String getSitePicIcon() {
		return sitePicIcon;
	}
	public void setSitePicIcon(String sitePicIcon) {
		this.sitePicIcon = sitePicIcon;
	}
	public String getZcode() {
		return Zcode;
	}
	public void setZcode(String zcode) {
		Zcode = zcode;
	}
	public String getSiteAddress() {
		return siteAddress;
	}
	public void setSiteAddress(String siteAddress) {
		this.siteAddress = siteAddress;
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
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = BusUtil.dayToString(createTime);
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
//		this.startTime = startTime.substring(0, 5);
		this.startTime=startTime;
		if (this.serviceTime == null) {
			this.serviceTime = this.startTime;
		}else {
			this.serviceTime = this.startTime+this.serviceTime;
		}
		
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
//		this.endTime = endTime.substring(0, 5);
		this.endTime=endTime;
		if (this.serviceTime == null) {
			this.serviceTime = "-"+this.endTime;
		}else {
			this.serviceTime = this.serviceTime+"-"+this.endTime;
		}
	}
	public int getPileStatus() {
		return pileStatus;
	}
	public void setPileStatus(int pileStatus) {
		this.pileStatus = pileStatus;
	}
	public Object getPiles() {
		return piles;
	}
	public void setPiles(Object piles) {
		this.piles = piles;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getCompanyShortName() {
		return companyShortName;
	}
	public void setCompanyShortName(String companyShortName) {
		this.companyShortName = companyShortName;
	}
	public int getUsableCar() {
		return usableCar;
	}
	public void setUsableCar(int usableCar) {
		this.usableCar = usableCar;
	}
	public int getUsablePark() {
		return usablePark;
	}
	public void setUsablePark(int usablePark) {
		this.usablePark = usablePark;
	}
	public int getUsablePile() {
		return usablePile;
	}
	public void setUsablePile(int usablePile) {
		this.usablePile = usablePile;
	}
	
	
}
