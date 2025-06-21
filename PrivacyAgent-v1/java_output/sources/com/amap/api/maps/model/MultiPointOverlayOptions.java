package com.amap.api.maps.model;

@com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
/* loaded from: classes12.dex */
public class MultiPointOverlayOptions extends com.amap.api.maps.model.BaseOptions implements java.lang.Cloneable {

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    private com.amap.api.maps.model.BitmapDescriptor bitmapDescriptor;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    private java.util.List<com.amap.api.maps.model.MultiPointItem> multiPointItems;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    private boolean multiPointItemsUpdated;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    private float anchorU = 0.5f;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    private float anchorV = 0.5f;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    private boolean enable = true;

    public MultiPointOverlayOptions() {
        this.type = "MultiPointOverlayOptions";
    }

    public com.amap.api.maps.model.MultiPointOverlayOptions anchor(float f, float f2) {
        this.anchorU = f;
        this.anchorV = f2;
        return this;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public com.amap.api.maps.model.MultiPointOverlayOptions m22clone() {
        try {
            super.clone();
        } catch (java.lang.CloneNotSupportedException e) {
            e.printStackTrace();
        }
        com.amap.api.maps.model.MultiPointOverlayOptions multiPointOverlayOptions = new com.amap.api.maps.model.MultiPointOverlayOptions();
        multiPointOverlayOptions.bitmapDescriptor = this.bitmapDescriptor;
        multiPointOverlayOptions.anchorU = this.anchorU;
        multiPointOverlayOptions.anchorV = this.anchorV;
        multiPointOverlayOptions.multiPointItemsUpdated = this.multiPointItemsUpdated;
        multiPointOverlayOptions.multiPointItems = this.multiPointItems;
        multiPointOverlayOptions.enable = this.enable;
        return multiPointOverlayOptions;
    }

    public float getAnchorU() {
        return this.anchorU;
    }

    public float getAnchorV() {
        return this.anchorV;
    }

    public com.amap.api.maps.model.BitmapDescriptor getIcon() {
        return this.bitmapDescriptor;
    }

    public java.util.List<com.amap.api.maps.model.MultiPointItem> getMultiPointItems() {
        return this.multiPointItems;
    }

    public com.amap.api.maps.model.MultiPointOverlayOptions icon(com.amap.api.maps.model.BitmapDescriptor bitmapDescriptor) {
        this.bitmapDescriptor = bitmapDescriptor;
        return this;
    }

    public void setEnable(boolean z) {
        this.enable = z;
    }

    public void setMultiPointItems(java.util.List<com.amap.api.maps.model.MultiPointItem> list) {
        this.multiPointItems = list;
        this.multiPointItemsUpdated = true;
    }
}
