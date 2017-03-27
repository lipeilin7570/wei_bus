package com.wgjev.weibus.entity;

import java.util.Date;

public class LeaseOrder {
    private Integer leaseid;

    private String leaseno;

    private Integer leasetype;

    private Integer rentaluserid;

    private String rentalusername;

    private String telphone;

    private Date createtime;

    private Integer reserveid;

    private Integer takeid;

    private Integer backid;

    private Integer changeid;

    private Integer leasefeeid;

    private Integer illegalfeeid;

    private Integer faultfeeid;

    private Integer otherfeeid;

    private Integer status;

    private Integer illagalstatus;

    private Integer faultstatus;

    private Integer accidentstatus;

    private Integer breachstatus;

    private String remark;

    private Integer companyid;

    private Integer carid;

    private String carno;

    private Integer priceid;

    public Integer getLeaseid() {
        return leaseid;
    }

    public void setLeaseid(Integer leaseid) {
        this.leaseid = leaseid;
    }

    public String getLeaseno() {
        return leaseno;
    }

    public void setLeaseno(String leaseno) {
        this.leaseno = leaseno == null ? null : leaseno.trim();
    }

    public Integer getLeasetype() {
        return leasetype;
    }

    public void setLeasetype(Integer leasetype) {
        this.leasetype = leasetype;
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

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone == null ? null : telphone.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getReserveid() {
        return reserveid;
    }

    public void setReserveid(Integer reserveid) {
        this.reserveid = reserveid;
    }

    public Integer getTakeid() {
        return takeid;
    }

    public void setTakeid(Integer takeid) {
        this.takeid = takeid;
    }

    public Integer getBackid() {
        return backid;
    }

    public void setBackid(Integer backid) {
        this.backid = backid;
    }

    public Integer getChangeid() {
        return changeid;
    }

    public void setChangeid(Integer changeid) {
        this.changeid = changeid;
    }

    public Integer getLeasefeeid() {
        return leasefeeid;
    }

    public void setLeasefeeid(Integer leasefeeid) {
        this.leasefeeid = leasefeeid;
    }

    public Integer getIllegalfeeid() {
        return illegalfeeid;
    }

    public void setIllegalfeeid(Integer illegalfeeid) {
        this.illegalfeeid = illegalfeeid;
    }

    public Integer getFaultfeeid() {
        return faultfeeid;
    }

    public void setFaultfeeid(Integer faultfeeid) {
        this.faultfeeid = faultfeeid;
    }

    public Integer getOtherfeeid() {
        return otherfeeid;
    }

    public void setOtherfeeid(Integer otherfeeid) {
        this.otherfeeid = otherfeeid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIllagalstatus() {
        return illagalstatus;
    }

    public void setIllagalstatus(Integer illagalstatus) {
        this.illagalstatus = illagalstatus;
    }

    public Integer getFaultstatus() {
        return faultstatus;
    }

    public void setFaultstatus(Integer faultstatus) {
        this.faultstatus = faultstatus;
    }

    public Integer getAccidentstatus() {
        return accidentstatus;
    }

    public void setAccidentstatus(Integer accidentstatus) {
        this.accidentstatus = accidentstatus;
    }

    public Integer getBreachstatus() {
        return breachstatus;
    }

    public void setBreachstatus(Integer breachstatus) {
        this.breachstatus = breachstatus;
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

    public Integer getPriceid() {
        return priceid;
    }

    public void setPriceid(Integer priceid) {
        this.priceid = priceid;
    }
}