package com.wgjev.weibus.entity;

import java.math.BigDecimal;
import java.util.Date;

public class CarStatusInfo {
	private String carModelName;
	
    public String getCarModelName() {
		return carModelName;
	}

	public void setCarModelName(String carModelName) {
		this.carModelName = carModelName;
	}
	
	private Integer carServiceStatus;
	
	public Integer getCarServiceStatus() {
		return carServiceStatus;
	}

	public void setCarServiceStatus(Integer carServiceStatus) {
		this.carServiceStatus = carServiceStatus;
	}

	private String carNo;
	
	public String getCarNo() {
		return carNo;
	}
	
	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}
	
    private Integer carid;
    
	private Integer electricity;

    private Integer electricitystatus;

    private BigDecimal remainkon;

    private BigDecimal mileages;

    private String remark;

    private Date lasttime;

    private BigDecimal longitude;

    private BigDecimal latitude;

    private BigDecimal speed;

    private Integer dire;

    private Integer siteid;

    private String location;

    private Integer centrallock;

    private Integer trunkstatus;

    private Integer chargelid;

    private Integer batterydoor;

    private Integer lfwindow;

    private Integer rlwindow;

    private Integer lbwindow;

    private Integer rbwindow;

    private Integer window5control;

    private Integer window6control;

    private Integer skylight;

    private Integer headlight;

    private Integer doublelamp;

    private Integer ffoglamp;

    private Integer bfoglamp;

    private Integer littlelight;

    private Integer backlight;

    private Integer lturnlight;

    private Integer rturnlight;

    private Integer carhorn;

    private Integer doortheft;

    private Integer collision;

    private Integer aircondition;

    private Integer ac;

    private Integer ptc;

    private Integer cycle;

    private Integer windtype;

    private Integer temperature;

    private Integer windspeed;

    private Integer airconditionstatus;

    private Integer indoortemperature;

    private Integer gpsvalid;

    private Integer acc;

    public Integer getCarid() {
        return carid;
    }

    public void setCarid(Integer carid) {
        this.carid = carid;
    }
    
    public Integer getElectricity() {
        return electricity;
    }

    public void setElectricity(Integer electricity) {
        this.electricity = electricity;
    }

    public Integer getElectricitystatus() {
        return electricitystatus;
    }

    public void setElectricitystatus(Integer electricitystatus) {
        this.electricitystatus = electricitystatus;
    }

    public BigDecimal getRemainkon() {
        return remainkon;
    }

    public void setRemainkon(BigDecimal remainkon) {
        this.remainkon = remainkon;
    }

    public BigDecimal getMileages() {
        return mileages;
    }

    public void setMileages(BigDecimal mileages) {
        this.mileages = mileages;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getLasttime() {
        return lasttime;
    }

    public void setLasttime(Date lasttime) {
        this.lasttime = lasttime;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getSpeed() {
        return speed;
    }

    public void setSpeed(BigDecimal speed) {
        this.speed = speed;
    }

    public Integer getDire() {
        return dire;
    }

    public void setDire(Integer dire) {
        this.dire = dire;
    }

    public Integer getSiteid() {
        return siteid;
    }

    public void setSiteid(Integer siteid) {
        this.siteid = siteid;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public Integer getCentrallock() {
        return centrallock;
    }

    public void setCentrallock(Integer centrallock) {
        this.centrallock = centrallock;
    }

    public Integer getTrunkstatus() {
        return trunkstatus;
    }

    public void setTrunkstatus(Integer trunkstatus) {
        this.trunkstatus = trunkstatus;
    }

    public Integer getChargelid() {
        return chargelid;
    }

    public void setChargelid(Integer chargelid) {
        this.chargelid = chargelid;
    }

    public Integer getBatterydoor() {
        return batterydoor;
    }

    public void setBatterydoor(Integer batterydoor) {
        this.batterydoor = batterydoor;
    }

    public Integer getLfwindow() {
        return lfwindow;
    }

    public void setLfwindow(Integer lfwindow) {
        this.lfwindow = lfwindow;
    }

    public Integer getRlwindow() {
        return rlwindow;
    }

    public void setRlwindow(Integer rlwindow) {
        this.rlwindow = rlwindow;
    }

    public Integer getLbwindow() {
        return lbwindow;
    }

    public void setLbwindow(Integer lbwindow) {
        this.lbwindow = lbwindow;
    }

    public Integer getRbwindow() {
        return rbwindow;
    }

    public void setRbwindow(Integer rbwindow) {
        this.rbwindow = rbwindow;
    }

    public Integer getWindow5control() {
        return window5control;
    }

    public void setWindow5control(Integer window5control) {
        this.window5control = window5control;
    }

    public Integer getWindow6control() {
        return window6control;
    }

    public void setWindow6control(Integer window6control) {
        this.window6control = window6control;
    }

    public Integer getSkylight() {
        return skylight;
    }

    public void setSkylight(Integer skylight) {
        this.skylight = skylight;
    }

    public Integer getHeadlight() {
        return headlight;
    }

    public void setHeadlight(Integer headlight) {
        this.headlight = headlight;
    }

    public Integer getDoublelamp() {
        return doublelamp;
    }

    public void setDoublelamp(Integer doublelamp) {
        this.doublelamp = doublelamp;
    }

    public Integer getFfoglamp() {
        return ffoglamp;
    }

    public void setFfoglamp(Integer ffoglamp) {
        this.ffoglamp = ffoglamp;
    }

    public Integer getBfoglamp() {
        return bfoglamp;
    }

    public void setBfoglamp(Integer bfoglamp) {
        this.bfoglamp = bfoglamp;
    }

    public Integer getLittlelight() {
        return littlelight;
    }

    public void setLittlelight(Integer littlelight) {
        this.littlelight = littlelight;
    }

    public Integer getBacklight() {
        return backlight;
    }

    public void setBacklight(Integer backlight) {
        this.backlight = backlight;
    }

    public Integer getLturnlight() {
        return lturnlight;
    }

    public void setLturnlight(Integer lturnlight) {
        this.lturnlight = lturnlight;
    }

    public Integer getRturnlight() {
        return rturnlight;
    }

    public void setRturnlight(Integer rturnlight) {
        this.rturnlight = rturnlight;
    }

    public Integer getCarhorn() {
        return carhorn;
    }

    public void setCarhorn(Integer carhorn) {
        this.carhorn = carhorn;
    }

    public Integer getDoortheft() {
        return doortheft;
    }

    public void setDoortheft(Integer doortheft) {
        this.doortheft = doortheft;
    }

    public Integer getCollision() {
        return collision;
    }

    public void setCollision(Integer collision) {
        this.collision = collision;
    }

    public Integer getAircondition() {
        return aircondition;
    }

    public void setAircondition(Integer aircondition) {
        this.aircondition = aircondition;
    }

    public Integer getAc() {
        return ac;
    }

    public void setAc(Integer ac) {
        this.ac = ac;
    }

    public Integer getPtc() {
        return ptc;
    }

    public void setPtc(Integer ptc) {
        this.ptc = ptc;
    }

    public Integer getCycle() {
        return cycle;
    }

    public void setCycle(Integer cycle) {
        this.cycle = cycle;
    }

    public Integer getWindtype() {
        return windtype;
    }

    public void setWindtype(Integer windtype) {
        this.windtype = windtype;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public Integer getWindspeed() {
        return windspeed;
    }

    public void setWindspeed(Integer windspeed) {
        this.windspeed = windspeed;
    }

    public Integer getAirconditionstatus() {
        return airconditionstatus;
    }

    public void setAirconditionstatus(Integer airconditionstatus) {
        this.airconditionstatus = airconditionstatus;
    }

    public Integer getIndoortemperature() {
        return indoortemperature;
    }

    public void setIndoortemperature(Integer indoortemperature) {
        this.indoortemperature = indoortemperature;
    }

    public Integer getGpsvalid() {
        return gpsvalid;
    }

    public void setGpsvalid(Integer gpsvalid) {
        this.gpsvalid = gpsvalid;
    }

    public Integer getAcc() {
        return acc;
    }

    public void setAcc(Integer acc) {
        this.acc = acc;
    }
}