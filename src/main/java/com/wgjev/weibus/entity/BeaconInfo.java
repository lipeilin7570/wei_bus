package com.wgjev.weibus.entity;

import java.util.Date;

public class BeaconInfo {
    private Integer beaconid;

    private String beaconno;

    private Date createtime;

    private String uuid;

    private String major;

    private String minor;

    private String mac;

    private String position;

    private Date fixtime;

    private Integer siteid;

    private Integer status;

    private String remark;

    private Integer optid;

    private String optname;

    private Integer companyid;

    public Integer getBeaconid() {
        return beaconid;
    }

    public void setBeaconid(Integer beaconid) {
        this.beaconid = beaconid;
    }

    public String getBeaconno() {
        return beaconno;
    }

    public void setBeaconno(String beaconno) {
        this.beaconno = beaconno == null ? null : beaconno.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
    }

    public String getMinor() {
        return minor;
    }

    public void setMinor(String minor) {
        this.minor = minor == null ? null : minor.trim();
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac == null ? null : mac.trim();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public Date getFixtime() {
        return fixtime;
    }

    public void setFixtime(Date fixtime) {
        this.fixtime = fixtime;
    }

    public Integer getSiteid() {
        return siteid;
    }

    public void setSiteid(Integer siteid) {
        this.siteid = siteid;
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

    public Integer getOptid() {
        return optid;
    }

    public void setOptid(Integer optid) {
        this.optid = optid;
    }

    public String getOptname() {
        return optname;
    }

    public void setOptname(String optname) {
        this.optname = optname == null ? null : optname.trim();
    }

    public Integer getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Integer companyid) {
        this.companyid = companyid;
    }
}