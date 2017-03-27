package com.wgjev.weibus.entity;

import java.util.Date;

public class RoleSys {
    private Integer sysroleid;

    private String sysroleno;

    private String sysrolename;

    private String sysmenulist;

    private Integer status;

    private Date createtime;

    private Date updatetime;

    private Integer updatecounts;

    private String remark;

    public Integer getSysroleid() {
        return sysroleid;
    }

    public void setSysroleid(Integer sysroleid) {
        this.sysroleid = sysroleid;
    }

    public String getSysroleno() {
        return sysroleno;
    }

    public void setSysroleno(String sysroleno) {
        this.sysroleno = sysroleno == null ? null : sysroleno.trim();
    }

    public String getSysrolename() {
        return sysrolename;
    }

    public void setSysrolename(String sysrolename) {
        this.sysrolename = sysrolename == null ? null : sysrolename.trim();
    }

    public String getSysmenulist() {
        return sysmenulist;
    }

    public void setSysmenulist(String sysmenulist) {
        this.sysmenulist = sysmenulist == null ? null : sysmenulist.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Integer getUpdatecounts() {
        return updatecounts;
    }

    public void setUpdatecounts(Integer updatecounts) {
        this.updatecounts = updatecounts;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}