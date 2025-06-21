package com.sijla.bean;

/* loaded from: classes19.dex */
public class QtLocation extends com.sijla.bean.Info {
    private double Latitude;
    private double Longitude;
    private java.lang.String address;
    private java.lang.String city;
    private java.lang.String district;

    public java.lang.String getAddress() {
        return this.address;
    }

    public java.lang.String getCity() {
        return this.city;
    }

    public java.lang.String getDistrict() {
        return this.district;
    }

    public double getLatitude() {
        return this.Latitude;
    }

    public double getLongitude() {
        return this.Longitude;
    }

    public void setAddress(java.lang.String str) {
        this.address = str;
    }

    public void setCity(java.lang.String str) {
        this.city = str;
    }

    public void setDistrict(java.lang.String str) {
        this.district = str;
    }

    public void setLatitude(double d) {
        this.Latitude = d;
    }

    public void setLongitude(double d) {
        this.Longitude = d;
    }
}
