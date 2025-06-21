package com.amap.api.maps.model;

/* loaded from: classes12.dex */
public class RoutePara {
    private java.lang.String endName;
    private com.amap.api.maps.model.LatLng endPoint;
    private java.lang.String startName;
    private com.amap.api.maps.model.LatLng startPoint;
    private int drivingRouteStyle = 0;
    private int transitRouteStyle = 0;

    public int getDrivingRouteStyle() {
        return this.drivingRouteStyle;
    }

    public java.lang.String getEndName() {
        return this.endName;
    }

    public com.amap.api.maps.model.LatLng getEndPoint() {
        return this.endPoint;
    }

    public java.lang.String getStartName() {
        return this.startName;
    }

    public com.amap.api.maps.model.LatLng getStartPoint() {
        return this.startPoint;
    }

    public int getTransitRouteStyle() {
        return this.transitRouteStyle;
    }

    public void setDrivingRouteStyle(int i) {
        if (i < 0 || i >= 9) {
            return;
        }
        this.drivingRouteStyle = i;
    }

    public void setEndName(java.lang.String str) {
        this.endName = str;
    }

    public void setEndPoint(com.amap.api.maps.model.LatLng latLng) {
        this.endPoint = latLng;
    }

    public void setStartName(java.lang.String str) {
        this.startName = str;
    }

    public void setStartPoint(com.amap.api.maps.model.LatLng latLng) {
        this.startPoint = latLng;
    }

    public void setTransitRouteStyle(int i) {
        if (i < 0 || i >= 6) {
            return;
        }
        this.transitRouteStyle = i;
    }
}
