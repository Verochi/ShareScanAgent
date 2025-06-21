package com.amap.api.services.nearby;

/* loaded from: classes12.dex */
public class NearbyInfo {
    private java.lang.String a;
    private com.amap.api.services.core.LatLonPoint b;
    private long c;
    private int d;
    private int e;

    public int getDistance() {
        return this.d;
    }

    public int getDrivingDistance() {
        return this.e;
    }

    public com.amap.api.services.core.LatLonPoint getPoint() {
        return this.b;
    }

    public long getTimeStamp() {
        return this.c;
    }

    public java.lang.String getUserID() {
        return this.a;
    }

    public void setDistance(int i) {
        this.d = i;
    }

    public void setDrivingDistance(int i) {
        this.e = i;
    }

    public void setPoint(com.amap.api.services.core.LatLonPoint latLonPoint) {
        this.b = latLonPoint;
    }

    public void setTimeStamp(long j) {
        this.c = j;
    }

    public void setUserID(java.lang.String str) {
        this.a = str;
    }
}
