package com.amap.api.maps.model;

/* loaded from: classes12.dex */
public class WeightedLatLng {
    public static final double DEFAULT_INTENSITY = 1.0d;
    public final double intensity;
    public final com.amap.api.maps.model.LatLng latLng;
    private com.autonavi.amap.mapcore.DPoint mPoint;

    public WeightedLatLng(com.amap.api.maps.model.LatLng latLng) {
        this(latLng, 1.0d);
    }

    public WeightedLatLng(com.amap.api.maps.model.LatLng latLng, double d) {
        if (latLng == null) {
            throw new java.lang.IllegalArgumentException("latLng can not null");
        }
        this.latLng = latLng;
        this.mPoint = com.amap.api.mapcore.util.dl.a(latLng);
        if (d >= 0.0d) {
            this.intensity = d;
        } else {
            this.intensity = 1.0d;
        }
    }

    public com.autonavi.amap.mapcore.DPoint getPoint() {
        return this.mPoint;
    }
}
