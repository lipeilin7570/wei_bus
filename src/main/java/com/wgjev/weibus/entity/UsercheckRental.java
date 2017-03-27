package com.wgjev.weibus.entity;

import java.util.Date;

public class UsercheckRental {
    private Integer usercheckid;

    private Date createtime;

    private Integer rentaluserid;

    private String rentalusername;

    private String remark;

    private Integer status;

    private Integer sysoperatorid;

    private String sysoperatorname;

    public Integer getUsercheckid() {
        return usercheckid;
    }

    public void setUsercheckid(Integer usercheckid) {
        this.usercheckid = usercheckid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getRentaluserid() {
        return rentaluserid;
    }

    public void setRentaluserid(Integer rentaluserid) {
        this.rentaluserid = rentaluserid;
    }

    public String getRentalusername() {
        return rentalusername;
    }

    public void setRentalusername(String rentalusername) {
        this.rentalusername = rentalusername == null ? null : rentalusername.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSysoperatorid() {
        return sysoperatorid;
    }

    public void setSysoperatorid(Integer sysoperatorid) {
        this.sysoperatorid = sysoperatorid;
    }

    public String getSysoperatorname() {
        return sysoperatorname;
    }

    public void setSysoperatorname(String sysoperatorname) {
        this.sysoperatorname = sysoperatorname == null ? null : sysoperatorname.trim();
    }
}