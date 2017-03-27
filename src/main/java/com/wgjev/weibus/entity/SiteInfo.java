package com.wgjev.weibus.entity;

import java.math.BigDecimal;
import java.util.Date;

public class SiteInfo {
	/**
	 * 站点内总车辆数
	 */
	private Integer carCount;
	
	/**
	 * 站点内可用车辆数
	 */
	private int CanRentCar;
	
	/**
	 * 站点内总车位
	 */
	private int parks;
	
	/**
	 * 站点内可使用的车位数
	 */
	private int canUseParks;
	
    public Integer getCarCount() {
		return carCount;
	}

	public void setCarCount(Integer carCount) {
		this.carCount = carCount;
	}

	public int getCanRentCar() {
		return CanRentCar;
	}

	public void setCanRentCar(int canRentCar) {
		CanRentCar = canRentCar;
	}

	public int getParks() {
		return parks;
	}

	public void setParks(int parks) {
		this.parks = parks;
	}

	public int getCanUseParks() {
		return canUseParks;
	}

	public void setCanUseParks(int canUseParks) {
		this.canUseParks = canUseParks;
	}

	private Integer siteid;

    private String sitename;

    private String sitecode;

    private Date createtime;

    private String siteaddress;

    private BigDecimal longitude;

    private BigDecimal latitude;

    private Integer sitemanid;

    private String siteman;

    private String starttime;

    private String endtime;

    private Integer pilestatus;

    private Integer status;

    private String remark;

    private Integer companyid;

    private String zcode;

    private BigDecimal siteradius;

    private Integer miniparkingcount;

    private Integer parkingcount;

    private String sitepicicon;

    private String sitepic;

    public Integer getSiteid() {
        return siteid;
    }

    public void setSiteid(Integer siteid) {
        this.siteid = siteid;
    }

    public String getSitename() {
        return sitename;
    }

    public void setSitename(String sitename) {
        this.sitename = sitename == null ? null : sitename.trim();
    }

    public String getSitecode() {
        return sitecode;
    }

    public void setSitecode(String sitecode) {
        this.sitecode = sitecode == null ? null : sitecode.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getSiteaddress() {
        return siteaddress;
    }

    public void setSiteaddress(String siteaddress) {
        this.siteaddress = siteaddress == null ? null : siteaddress.trim();
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

    public Integer getSitemanid() {
        return sitemanid;
    }

    public void setSitemanid(Integer sitemanid) {
        this.sitemanid = sitemanid;
    }

    public String getSiteman() {
        return siteman;
    }

    public void setSiteman(String siteman) {
        this.siteman = siteman == null ? null : siteman.trim();
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime == null ? null : starttime.trim();
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime == null ? null : endtime.trim();
    }

    public Integer getPilestatus() {
        return pilestatus;
    }

    public void setPilestatus(Integer pilestatus) {
        this.pilestatus = pilestatus;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Integer companyid) {
        this.companyid = companyid;
    }

    public String getZcode() {
        return zcode;
    }

    public void setZcode(String zcode) {
        this.zcode = zcode == null ? null : zcode.trim();
    }

    public BigDecimal getSiteradius() {
        return siteradius;
    }

    public void setSiteradius(BigDecimal siteradius) {
        this.siteradius = siteradius;
    }

    public Integer getMiniparkingcount() {
        return miniparkingcount;
    }

    public void setMiniparkingcount(Integer miniparkingcount) {
        this.miniparkingcount = miniparkingcount;
    }

    public Integer getParkingcount() {
        return parkingcount;
    }

    public void setParkingcount(Integer parkingcount) {
        this.parkingcount = parkingcount;
    }

    public String getSitepicicon() {
        return sitepicicon;
    }

    public void setSitepicicon(String sitepicicon) {
        this.sitepicicon = sitepicicon == null ? null : sitepicicon.trim();
    }

    public String getSitepic() {
        return sitepic;
    }

    public void setSitepic(String sitepic) {
        this.sitepic = sitepic == null ? null : sitepic.trim();
    }
}