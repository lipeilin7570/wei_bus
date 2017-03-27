package com.wgjev.weibus.entity;

import java.math.BigDecimal;
import java.util.Date;

public class CouponRun {
    private Integer couponid;

    private String couponno;

    private String couponname;

    private Integer couponmodel;

    private Integer arrivaltype;

    private Integer invitetype;

    private Date invitebegintime;

    private Date inviteendtime;

    private Integer condition;

    private Integer limitdays;

    private String useridlist;

    private Integer limitreceive;

    private Integer couponlimit;

    private Integer codecount;

    private Integer couponcount;

    private String appointcompany;

    private Integer validatetype;

    private Integer validatedays;

    private Integer coupontype;

    private BigDecimal couponmoney;

    private BigDecimal limitmoney;

    private Integer sendtype;

    private Integer sendmodel;

    private Date senddate;

    private Integer createmanid;

    private String createman;

    private Integer status;

    private Integer companyid;

    public Integer getCouponid() {
        return couponid;
    }

    public void setCouponid(Integer couponid) {
        this.couponid = couponid;
    }

    public String getCouponno() {
        return couponno;
    }

    public void setCouponno(String couponno) {
        this.couponno = couponno == null ? null : couponno.trim();
    }

    public String getCouponname() {
        return couponname;
    }

    public void setCouponname(String couponname) {
        this.couponname = couponname == null ? null : couponname.trim();
    }

    public Integer getCouponmodel() {
        return couponmodel;
    }

    public void setCouponmodel(Integer couponmodel) {
        this.couponmodel = couponmodel;
    }

    public Integer getArrivaltype() {
        return arrivaltype;
    }

    public void setArrivaltype(Integer arrivaltype) {
        this.arrivaltype = arrivaltype;
    }

    public Integer getInvitetype() {
        return invitetype;
    }

    public void setInvitetype(Integer invitetype) {
        this.invitetype = invitetype;
    }

    public Date getInvitebegintime() {
        return invitebegintime;
    }

    public void setInvitebegintime(Date invitebegintime) {
        this.invitebegintime = invitebegintime;
    }

    public Date getInviteendtime() {
        return inviteendtime;
    }

    public void setInviteendtime(Date inviteendtime) {
        this.inviteendtime = inviteendtime;
    }

    public Integer getCondition() {
        return condition;
    }

    public void setCondition(Integer condition) {
        this.condition = condition;
    }

    public Integer getLimitdays() {
        return limitdays;
    }

    public void setLimitdays(Integer limitdays) {
        this.limitdays = limitdays;
    }

    public String getUseridlist() {
        return useridlist;
    }

    public void setUseridlist(String useridlist) {
        this.useridlist = useridlist == null ? null : useridlist.trim();
    }

    public Integer getLimitreceive() {
        return limitreceive;
    }

    public void setLimitreceive(Integer limitreceive) {
        this.limitreceive = limitreceive;
    }

    public Integer getCouponlimit() {
        return couponlimit;
    }

    public void setCouponlimit(Integer couponlimit) {
        this.couponlimit = couponlimit;
    }

    public Integer getCodecount() {
        return codecount;
    }

    public void setCodecount(Integer codecount) {
        this.codecount = codecount;
    }

    public Integer getCouponcount() {
        return couponcount;
    }

    public void setCouponcount(Integer couponcount) {
        this.couponcount = couponcount;
    }

    public String getAppointcompany() {
        return appointcompany;
    }

    public void setAppointcompany(String appointcompany) {
        this.appointcompany = appointcompany == null ? null : appointcompany.trim();
    }

    public Integer getValidatetype() {
        return validatetype;
    }

    public void setValidatetype(Integer validatetype) {
        this.validatetype = validatetype;
    }

    public Integer getValidatedays() {
        return validatedays;
    }

    public void setValidatedays(Integer validatedays) {
        this.validatedays = validatedays;
    }

    public Integer getCoupontype() {
        return coupontype;
    }

    public void setCoupontype(Integer coupontype) {
        this.coupontype = coupontype;
    }

    public BigDecimal getCouponmoney() {
        return couponmoney;
    }

    public void setCouponmoney(BigDecimal couponmoney) {
        this.couponmoney = couponmoney;
    }

    public BigDecimal getLimitmoney() {
        return limitmoney;
    }

    public void setLimitmoney(BigDecimal limitmoney) {
        this.limitmoney = limitmoney;
    }

    public Integer getSendtype() {
        return sendtype;
    }

    public void setSendtype(Integer sendtype) {
        this.sendtype = sendtype;
    }

    public Integer getSendmodel() {
        return sendmodel;
    }

    public void setSendmodel(Integer sendmodel) {
        this.sendmodel = sendmodel;
    }

    public Date getSenddate() {
        return senddate;
    }

    public void setSenddate(Date senddate) {
        this.senddate = senddate;
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

    public Integer getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Integer companyid) {
        this.companyid = companyid;
    }
}