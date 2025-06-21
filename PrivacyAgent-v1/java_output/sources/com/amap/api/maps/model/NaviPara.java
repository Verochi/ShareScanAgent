package com.amap.api.maps.model;

/* loaded from: classes12.dex */
public class NaviPara {

    @java.lang.Deprecated
    public static final int DRIVING_AVOID_CONGESTION = 4;

    @java.lang.Deprecated
    public static final int DRIVING_DEFAULT = 0;

    @java.lang.Deprecated
    public static final int DRIVING_NO_HIGHWAY = 3;

    @java.lang.Deprecated
    public static final int DRIVING_NO_HIGHWAY_AVOID_CONGESTION = 6;

    @java.lang.Deprecated
    public static final int DRIVING_NO_HIGHWAY_AVOID_SHORT_MONEY = 5;

    @java.lang.Deprecated
    public static final int DRIVING_NO_HIGHWAY_SAVE_MONEY_AVOID_CONGESTION = 8;

    @java.lang.Deprecated
    public static final int DRIVING_SAVE_MONEY = 1;

    @java.lang.Deprecated
    public static final int DRIVING_SAVE_MONEY_AVOID_CONGESTION = 7;

    @java.lang.Deprecated
    public static final int DRIVING_SHORT_DISTANCE = 2;
    private com.amap.api.maps.model.LatLng latLng;
    private int naviStyle = 0;

    public int getNaviStyle() {
        return this.naviStyle;
    }

    public com.amap.api.maps.model.LatLng getTargetPoint() {
        return this.latLng;
    }

    public void setNaviStyle(int i) {
        if (i < 0 || i >= 9) {
            return;
        }
        this.naviStyle = i;
    }

    public void setTargetPoint(com.amap.api.maps.model.LatLng latLng) {
        this.latLng = latLng;
    }
}
