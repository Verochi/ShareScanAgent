package com.amap.api.maps.model;

@com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
/* loaded from: classes12.dex */
public class MultiPointItem {

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    private java.lang.String customerId = null;
    private com.autonavi.amap.mapcore.IPoint iPoint;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    private com.amap.api.maps.model.LatLng latLng;
    private java.lang.Object object;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    private java.lang.String snippet;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    private java.lang.String title;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    private MultiPointItem() {
    }

    public MultiPointItem(com.amap.api.maps.model.LatLng latLng) {
        this.latLng = latLng;
    }

    public boolean equals(java.lang.Object obj) {
        if (obj == null || !(obj instanceof com.amap.api.maps.model.MultiPointItem)) {
            return false;
        }
        if (this.customerId != null) {
            com.amap.api.maps.model.MultiPointItem multiPointItem = (com.amap.api.maps.model.MultiPointItem) obj;
            if (multiPointItem.getCustomerId() != null) {
                return this.customerId.equals(multiPointItem.getCustomerId());
            }
        }
        return super.equals(obj);
    }

    public java.lang.String getCustomerId() {
        return this.customerId;
    }

    public com.autonavi.amap.mapcore.IPoint getIPoint() {
        return this.iPoint;
    }

    public com.amap.api.maps.model.LatLng getLatLng() {
        return this.latLng;
    }

    public java.lang.Object getObject() {
        return this.object;
    }

    public java.lang.String getSnippet() {
        return this.snippet;
    }

    public java.lang.String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public void setCustomerId(java.lang.String str) {
        this.customerId = str;
    }

    public void setIPoint(com.autonavi.amap.mapcore.IPoint iPoint) {
        this.iPoint = iPoint;
    }

    public void setLatLng(com.amap.api.maps.model.LatLng latLng) {
        this.latLng = latLng;
    }

    public void setObject(java.lang.Object obj) {
        this.object = obj;
    }

    public void setSnippet(java.lang.String str) {
        this.snippet = str;
    }

    public void setTitle(java.lang.String str) {
        this.title = str;
    }
}
