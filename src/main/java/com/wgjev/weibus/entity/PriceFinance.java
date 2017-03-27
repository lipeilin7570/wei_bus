package com.wgjev.weibus.entity;

import java.math.BigDecimal;
import java.util.Date;

public class PriceFinance {
    private Integer priceid;

    private Integer priceversion;

    private String pricename;

    private Integer carmodel;

    private BigDecimal hourprice;

    private BigDecimal startprice;

    private Integer freetime;

    private BigDecimal dayprice;

    private BigDecimal nightprice;

    private BigDecimal weekprice;

    private BigDecimal hourmileage;

    private BigDecimal daymileage;

    private BigDecimal nightmileage;

    private BigDecimal weekmileage;

    private BigDecimal superprice;

    private Integer startcharge;

    private String daybegintime;

    private String dayendtime;

    private Integer oldpriceid;

    private Date createtime;

    private Integer createmanid;

    private String createman;

    private Integer status;

    private Integer newstatus;

    private Integer companyid;

    public Integer getPriceid() {
        return priceid;
    }

    public void setPriceid(Integer priceid) {
        this.priceid = priceid;
    }

    public Integer getPriceversion() {
        return priceversion;
    }

    public void setPriceversion(Integer priceversion) {
        this.priceversion = priceversion;
    }

    public String getPricename() {
        return pricename;
    }

    public void setPricename(String pricename) {
        this.pricename = pricename == null ? null : pricename.trim();
    }

    public Integer getCarmodel() {
        return carmodel;
    }

    public void setCarmodel(Integer carmodel) {
        this.carmodel = carmodel;
    }

    public BigDecimal getHourprice() {
        return hourprice;
    }

    public void setHourprice(BigDecimal hourprice) {
        this.hourprice = hourprice;
    }

    public BigDecimal getStartprice() {
        return startprice;
    }

    public void setStartprice(BigDecimal startprice) {
        this.startprice = startprice;
    }

    public Integer getFreetime() {
        return freetime;
    }

    public void setFreetime(Integer freetime) {
        this.freetime = freetime;
    }

    public BigDecimal getDayprice() {
        return dayprice;
    }

    public void setDayprice(BigDecimal dayprice) {
        this.dayprice = dayprice;
    }

    public BigDecimal getNightprice() {
        return nightprice;
    }

    public void setNightprice(BigDecimal nightprice) {
        this.nightprice = nightprice;
    }

    public BigDecimal getWeekprice() {
        return weekprice;
    }

    public void setWeekprice(BigDecimal weekprice) {
        this.weekprice = weekprice;
    }

    public BigDecimal getHourmileage() {
        return hourmileage;
    }

    public void setHourmileage(BigDecimal hourmileage) {
        this.hourmileage = hourmileage;
    }

    public BigDecimal getDaymileage() {
        return daymileage;
    }

    public void setDaymileage(BigDecimal daymileage) {
        this.daymileage = daymileage;
    }

    public BigDecimal getNightmileage() {
        return nightmileage;
    }

    public void setNightmileage(BigDecimal nightmileage) {
        this.nightmileage = nightmileage;
    }

    public BigDecimal getWeekmileage() {
        return weekmileage;
    }

    public void setWeekmileage(BigDecimal weekmileage) {
        this.weekmileage = weekmileage;
    }

    public BigDecimal getSuperprice() {
        return superprice;
    }

    public void setSuperprice(BigDecimal superprice) {
        this.superprice = superprice;
    }

    public Integer getStartcharge() {
        return startcharge;
    }

    public void setStartcharge(Integer startcharge) {
        this.startcharge = startcharge;
    }

    public String getDaybegintime() {
        return daybegintime;
    }

    public void setDaybegintime(String daybegintime) {
        this.daybegintime = daybegintime == null ? null : daybegintime.trim();
    }

    public String getDayendtime() {
        return dayendtime;
    }

    public void setDayendtime(String dayendtime) {
        this.dayendtime = dayendtime == null ? null : dayendtime.trim();
    }

    public Integer getOldpriceid() {
        return oldpriceid;
    }

    public void setOldpriceid(Integer oldpriceid) {
        this.oldpriceid = oldpriceid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getCreatemanid() {
        return createmanid;
    }

    public void setCreatemanid(Integer createmanid) {
        this.createmanid = createmanid;
    }

    public String getCreateman() {
        return createman;
    }

    public void setCreateman(String createman) {
        this.createman = createman == null ? null : createman.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getNewstatus() {
        return newstatus;
    }

    public void setNewstatus(Integer newstatus) {
        this.newstatus = newstatus;
    }

    public Integer getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Integer companyid) {
        this.companyid = companyid;
    }
}