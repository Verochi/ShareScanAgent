package com.amap.api.services.nearby;

/* loaded from: classes12.dex */
public class UploadInfo {
    private int a = 1;
    private java.lang.String b;
    private com.amap.api.services.core.LatLonPoint c;

    public int getCoordType() {
        return this.a;
    }

    public com.amap.api.services.core.LatLonPoint getPoint() {
        return this.c;
    }

    public java.lang.String getUserID() {
        return this.b;
    }

    public void setCoordType(int i) {
        if (i == 0 || i == 1) {
            this.a = i;
        } else {
            this.a = 1;
        }
    }

    public void setPoint(com.amap.api.services.core.LatLonPoint latLonPoint) {
        this.c = latLonPoint;
    }

    public void setUserID(java.lang.String str) {
        this.b = str;
    }
}
