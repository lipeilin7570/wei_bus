package com.wgjev.weibus.entity;

import java.math.BigDecimal;
import java.util.Date;

public class FaultOrder {
    private Integer faultid;

    private String faultno;

    private Date createtime;

    private Integer carid;

    private String carno;

    private Integer rentaluserid;

    private String rentaluserno;

    private String rentalusername;

    private String telphone;

    private Integer leaseid;

    private Date faulttime;

    private Integer faultduty;

    private String faultimg1;

    private String faultimg2;

    private String faultimg3;

    private String description;

    private Integer sysoptid;

    private String sysoptname;

    private String remark;

    private Integer bailpayid;

    private Integer repairid;

    private BigDecimal feemoney;

    private Integer fafeeid;

    private Integer status;

    private Date canceltime;

    private Integer cancelmanid;

    private String cancelman;

    private Date updatetime;

    private Integer companyid;

    public Integer getFaultid() {
        return faultid;
    }

    public void setFaultid(Integer faultid) {
        this.faultid = faultid;
    }

    public String getFaultno() {
        return faultno;
    }

    public void setFaultno(String faultno) {
        this.faultno = faultno == null ? null : faultno.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getCarid() {
        return carid;
    }

    public void setCarid(Integer carid) {
        this.carid = carid;
    }

    public String getCarno() {
        return carno;
    }

    public void setCarno(String carno) {
        this.carno = carno == null ? null : carno.trim();
    }

    public Integer getRentaluserid() {
        return rentaluserid;
    }

    public void setRentaluserid(Integer rentaluserid) {
        this.rentaluserid = rentaluserid;
    }

    public String getRentaluserno() {
        return rentaluserno;
    }

    public void setRentaluserno(String rentaluserno) {
        this.rentaluserno = rentaluserno == null ? null : rentaluserno.trim();
    }

    public String getRentalusername() {
        return rentalusername;
    }

    public void setRentalusername(String rentalusername) {
        this.rentalusername = rentalusername == null ? null : rentalusername.trim();
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone == null ? null : telphone.trim();
    }

    public Integer getLeaseid() {
        return leaseid;
    }

    public void setLeaseid(Integer leaseid) {
        this.leaseid = leaseid;
    }

    public Date getFaulttime() {
        return faulttime;
    }

    public void setFaulttime(Date faulttime) {
        this.faulttime = faulttime;
    }

    public Integer getFaultduty() {
        return faultduty;
    }

    public void setFaultduty(Integer faultduty) {
        this.faultduty = faultduty;
    }

    public String getFaultimg1() {
        return faultimg1;
    }

    public void setFaultimg1(String faultimg1) {
        this.faultimg1 = faultimg1 == null ? null : faultimg1.trim();
    }

    public String getFaultimg2() {
        return faultimg2;
    }

    public void setFaultimg2(String faultimg2) {
        this.faultimg2 = faultimg2 == null ? null : faultimg2.trim();
    }

    public String getFaultimg3() {
        return faultimg3;
    }

    public void setFaultimg3(String faultimg3) {
        this.faultimg3 = faultimg3 == null ? null : faultimg3.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getSysoptid() {
        return sysoptid;
    }

    public void setSysoptid(Integer sysoptid) {
        this.sysoptid = sysoptid;
    }

    public String getSysoptname() {
        return sysoptname;
    }

    public void setSysoptname(String sysoptname) {
        this.sysoptname = sysoptname == null ? null : sysoptname.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getBailpayid() {
        return bailpayid;
    }

    public void setBailpayid(Integer bailpayid) {
        this.bailpayid = bailpayid;
    }

    public Integer getRepairid() {
        return repairid;
    }

    public void setRepairid(Integer repairid) {
        this.repairid = repairid;
    }

    public BigDecimal getFeemoney() {
        return feemoney;
    }

    public void setFeemoney(BigDecimal feemoney) {
        this.feemoney = feemoney;
    }

    public Integer getFafeeid() {
        return fafeeid;
    }

    public void setFafeeid(Integer fafeeid) {
        this.fafeeid = fafeeid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCanceltime() {
        return canceltime;
    }

    public void setCanceltime(Date canceltime) {
        this.canceltime = canceltime;
    }

    public Integer getCancelmanid() {
        return cancelmanid;
    }

    public void setCancelmanid(Integer cancelmanid) {
        this.cancelmanid = cancelmanid;
    }

    public String getCancelman() {
        return cancelman;
    }

    public void setCancelman(String cancelman) {
        this.cancelman = cancelman == null ? null : cancelman.trim();
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Integer getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Integer companyid) {
        this.companyid = companyid;
    }
}