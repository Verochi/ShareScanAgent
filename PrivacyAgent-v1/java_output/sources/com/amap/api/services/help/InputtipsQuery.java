package com.amap.api.services.help;

/* loaded from: classes12.dex */
public class InputtipsQuery implements java.lang.Cloneable {
    private java.lang.String a;
    private java.lang.String b;
    private boolean c = false;
    private java.lang.String d = null;
    private com.amap.api.services.core.LatLonPoint e;

    public InputtipsQuery(java.lang.String str, java.lang.String str2) {
        this.a = str;
        this.b = str2;
    }

    public java.lang.String getCity() {
        return this.b;
    }

    public boolean getCityLimit() {
        return this.c;
    }

    public java.lang.String getKeyword() {
        return this.a;
    }

    public com.amap.api.services.core.LatLonPoint getLocation() {
        return this.e;
    }

    public java.lang.String getType() {
        return this.d;
    }

    public void setCityLimit(boolean z) {
        this.c = z;
    }

    public void setLocation(com.amap.api.services.core.LatLonPoint latLonPoint) {
        this.e = latLonPoint;
    }

    public void setType(java.lang.String str) {
        this.d = str;
    }
}
