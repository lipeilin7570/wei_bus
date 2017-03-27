package com.wgjev.weibus.entity;

import java.util.Date;

public class UserRental {
    private Integer rentaluserid;

    private String rentaluserno;

    private String telphone;

    private String passwd;

    private String rentalusername;

    private Integer sex;

    private Integer age;

    private Date birthday;

    private String license;

    private String identity;

    private Date createtime;

    private Integer authentication;

    private Date approvetime;

    private Integer rentalstatusint;

    private Integer status;

    private Date updatetime;

    private String rentaluserimg;

    private String nationality;

    private String drivingtype;

    private Date effectdate;

    private Date expiredate;

    private String issuingagency;

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

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone == null ? null : telphone.trim();
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd == null ? null : passwd.trim();
    }

    public String getRentalusername() {
        return rentalusername;
    }

    public void setRentalusername(String rentalusername) {
        this.rentalusername = rentalusername == null ? null : rentalusername.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license == null ? null : license.trim();
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity == null ? null : identity.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getAuthentication() {
        return authentication;
    }

    public void setAuthentication(Integer authentication) {
        this.authentication = authentication;
    }

    public Date getApprovetime() {
        return approvetime;
    }

    public void setApprovetime(Date approvetime) {
        this.approvetime = approvetime;
    }

    public Integer getRentalstatusint() {
        return rentalstatusint;
    }

    public void setRentalstatusint(Integer rentalstatusint) {
        this.rentalstatusint = rentalstatusint;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getRentaluserimg() {
        return rentaluserimg;
    }

    public void setRentaluserimg(String rentaluserimg) {
        this.rentaluserimg = rentaluserimg == null ? null : rentaluserimg.trim();
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