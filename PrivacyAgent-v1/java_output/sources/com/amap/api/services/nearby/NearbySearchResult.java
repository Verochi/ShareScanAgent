package com.amap.api.services.nearby;

/* loaded from: classes12.dex */
public class NearbySearchResult {
    private java.util.List<com.amap.api.services.nearby.NearbyInfo> a = new java.util.ArrayList();
    private int b = 0;

    public java.util.List<com.amap.api.services.nearby.NearbyInfo> getNearbyInfoList() {
        return this.a;
    }

    public int getTotalNum() {
        return this.b;
    }

    public void setNearbyInfoList(java.util.List<com.amap.api.services.nearby.NearbyInfo> list) {
        this.a = list;
        this.b = list.size();
    }
}
