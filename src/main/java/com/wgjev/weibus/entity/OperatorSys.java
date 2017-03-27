package com.wgjev.weibus.entity;

import java.util.Date;

public class OperatorSys {
    private Integer sysoperatorid;

    private String sysusename;

    private String syspassword;

    private String sysloginname;

    private Date createtime;

    private Integer roleid;

    private Integer depttype;

    private Integer dutytype;

    private String telphone;

    private String workalarm;

    private Date logintime;

    private String loginip;

    private Date lastertime;

    private String lasterip;

    private Date updatetime;

    private Integer logincounts;

    private Integer status;

    private String remark;

    private Integer companyid;

    private String nationality;

    private String drivingtype;

    private Date effectdate;

    private Date expiredate;

    private String issuingagency;

    public Integer getSysoperatorid() {
        return sysoperatorid;
    }

    public void setSysoperatorid(Integer sysoperatorid) {
        this.sysoperatorid = sysoperatorid;
    }

    public String getSysusename() {
        return sysusename;
    }

    public void setSysusename(String sysusename) {
        this.sysusename = sysusename == null ? null : sysusename.trim();
    }

    public String getSyspassword() {
        return syspassword;
    }

    public void setSyspassword(String syspassword) {
        this.syspassword = syspassword == null ? null : syspassword.trim();
    }

    public String getSysloginname() {
        return sysloginname;
    }

    public void setSysloginname(String sysloginname) {
        this.sysloginname = sysloginname == null ? null : sysloginname.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public Integer getDepttype() {
        return depttype;
    }

    public void setDepttype(Integer depttype) {
        this.depttype = depttype;
    }

    public Integer getDutytype() {
        return dutytype;
    }

    public void setDutytype(Integer dutytype) {
        this.dutytype = dutytype;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone == null ? null : telphone.trim();
    }

    public String getWorkalarm() {
        return workalarm;
    }

    public void setWorkalarm(String workalarm) {
        this.workalarm = workalarm == null ? null : workalarm.trim();
    }

    public Date getLogintime() {
        return logintime;
    }

    public void setLogintime(Date logintime) {
        this.logintime = logintime;
    }

    public String getLoginip() {
        return loginip;
    }

    public void setLoginip(String loginip) {
        this.loginip = loginip == null ? null : loginip.trim();
    }

    public Date getLastertime() {
        return lastertime;
    }

    public void setLastertime(Date lastertime) {
        this.lastertime = lastertime;
    }

    public String getLasterip() {
        return lasterip;
    }

    public void setLasterip(String lasterip) {
        this.lasterip = lasterip == null ? null : lasterip.trim();
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Integer getLogincounts() {
        return logincounts;
    }

    public void setLogincounts(Integer logincounts) {
        this.logincounts = logincounts;
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

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality == null ? null : nationality.trim();
    }

    public String getDrivingtype() {
        return drivingtype;
    }

    public void setDrivingtype(String drivingtype) {
        this.drivingtype = drivingtype == null ? null : drivingtype.trim();
    }

    public Date getEffectdate() {
        return effectdate;
    }

    public void setEffectdate(Date effectdate) {
        this.effectdate = effectdate;
    }

    public Date getExpiredate() {
        return expiredate;
    }

    public void setExpiredate(Date expiredate) {
        this.expiredate = expiredate;
    }

    public String getIssuingagency() {
        return issuingagency;
    }

    public void setIssuingagency(String issuingagency) {
        this.issuingagency = issuingagency == null ? null : issuingagency.trim();
    }
}