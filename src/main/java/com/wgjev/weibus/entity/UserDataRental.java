package com.wgjev.weibus.entity;

import java.util.Date;

public class UserDataRental {
    private Integer rentaluserid;

    private Date uploadtime;

    private String identityfrontpic;

    private String identitybackpic;

    private String licensefrontpic;

    private String licensebackpic;

    private Integer status;

    public Integer getRentaluserid() {
        return rentaluserid;
    }

    public void setRentaluserid(Integer rentaluserid) {
        this.rentaluserid = rentaluserid;
    }

    public Date getUploadtime() {
        return uploadtime;
    }

    public void setUploadtime(Date uploadtime) {
        this.uploadtime = uploadtime;
    }

    public String getIdentityfrontpic() {
        return identityfrontpic;
    }

    public void setIdentityfrontpic(String identityfrontpic) {
        this.identityfrontpic = identityfrontpic == null ? null : identityfrontpic.trim();
    }

    public String getIdentitybackpic() {
        return identitybackpic;
    }

    public void setIdentitybackpic(String identitybackpic) {
        this.identitybackpic = identitybackpic == null ? null : identitybackpic.trim();
    }

    public String getLicensefrontpic() {
        return licensefrontpic;
    }

    public void setLicensefrontpic(String licensefrontpic) {
        this.licensefrontpic = licensefrontpic == null ? null : licensefrontpic.trim();
    }

    public String getLicensebackpic() {
        return licensebackpic;
    }

    public void setLicensebackpic(String licensebackpic) {
        this.licensebackpic = licensebackpic == null ? null : licensebackpic.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}