package com.wgjev.weibus.entity;

import java.util.Date;

public class CarServiceInfo {
    private Integer carid;

    private Date lasttime;

    private Integer status;

    private Integer updatemanid;

    private String updateman;

    private Integer updatemantype;

    private String remark;

    public Integer getCarid() {
        return carid;
    }

    public void setCarid(Integer carid) {
        this.carid = carid;
    }

    public Date getLasttime() {
        return lasttime;
    }

    public void setLasttime(Date lasttime) {
        this.lasttime = lasttime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUpdatemanid() {
        return updatemanid;
    }

    public void setUpdatemanid(Integer updatemanid) {
        this.updatemanid = updatemanid;
    }

    public String getUpdateman() {
        return updateman;
    }

    public void setUpdateman(String updateman) {
        this.updateman = updateman == null ? null : updateman.trim();
    }

    public Integer getUpdatemantype() {
        return updatemantype;
    }

    public void setUpdatemantype(Integer updatemantype) {
        this.updatemantype = updatemantype;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}