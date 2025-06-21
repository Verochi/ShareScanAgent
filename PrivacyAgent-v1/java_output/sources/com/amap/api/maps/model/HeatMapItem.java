package com.amap.api.maps.model;

@com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
/* loaded from: classes12.dex */
public class HeatMapItem {
    private com.amap.api.maps.model.LatLng center;
    private int[] indexes;
    private double intensity;

    public com.amap.api.maps.model.LatLng getCenter() {
        return this.center;
    }

    public int[] getIndexes() {
        return this.indexes;
    }

    public double getIntensity() {
        return this.intensity;
    }

    public void setCenter(double d, double d2) {
        this.center = new com.amap.api.maps.model.LatLng(d, d2);
    }

    public void setIndexes(int[] iArr) {
        this.indexes = iArr;
    }

    public void setIntensity(double d) {
        this.intensity = d;
    }
}
