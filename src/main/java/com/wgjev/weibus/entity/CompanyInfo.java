package com.wgjev.weibus.entity;

import java.math.BigDecimal;
import java.util.Date;

public class CompanyInfo {
    private Integer companyid;

    private String companyname;

    private String shortname;

    private Integer partentid;

    private String companyphone;

    private String contacts;

    private String zcode;

    private String address;

    private Integer companyorder;

    private Date createtime;

    private Integer status;

    private Integer conpanycode;

    private BigDecimal longitude;

    private BigDecimal latitude;

    private Integer regionstatus;

    private String remark;

    public Integer getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Integer companyid) {
        this.companyid = companyid;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname == null ? null : companyname.trim();
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname == null ? null : shortname.trim();
    }

    public Integer getPartentid() {
        return partentid;
    }

    public void setPartentid(Integer partentid) {
        this.partentid = partentid;
    }

    public String getCompanyphone() {
        return companyphone;
    }

    public void setCompanyphone(String companyphone) {
        this.companyphone = companyphone == null ? null : companyphone.trim();
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts == null ? null : contacts.trim();
    }

    public String getZcode() {
        return zcode;
    }

    public void setZcode(String zcode) {
        this.zcode = zcode == null ? null : zcode.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getCompanyorder() {
        return companyorder;
    }

    public void setCompanyorder(Integer companyorder) {
        this.companyorder = companyorder;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getConpanycode() {
        return conpanycode;
    }

    public void setConpanycode(Integer conpanycode) {
        this.conpanycode = conpanycode;
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

    public Integer getRegionstatus() {
        return regionstatus;
    }

    public void setRegionstatus(Integer regionstatus) {
        this.regionstatus = regionstatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}