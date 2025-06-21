package com.amap.api.services.routepoisearch;

/* loaded from: classes12.dex */
public class RoutePOISearchQuery implements java.lang.Cloneable {
    private com.amap.api.services.core.LatLonPoint a;
    private com.amap.api.services.core.LatLonPoint b;
    private int c;
    private com.amap.api.services.routepoisearch.RoutePOISearch.RoutePOISearchType d;
    private int e;
    private java.util.List<com.amap.api.services.core.LatLonPoint> f;

    public RoutePOISearchQuery(com.amap.api.services.core.LatLonPoint latLonPoint, com.amap.api.services.core.LatLonPoint latLonPoint2, int i, com.amap.api.services.routepoisearch.RoutePOISearch.RoutePOISearchType routePOISearchType, int i2) {
        this.a = latLonPoint;
        this.b = latLonPoint2;
        this.c = i;
        this.d = routePOISearchType;
        this.e = i2;
    }

    public RoutePOISearchQuery(java.util.List<com.amap.api.services.core.LatLonPoint> list, com.amap.api.services.routepoisearch.RoutePOISearch.RoutePOISearchType routePOISearchType, int i) {
        this.f = list;
        this.d = routePOISearchType;
        this.e = i;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public com.amap.api.services.routepoisearch.RoutePOISearchQuery m41clone() {
        try {
            super.clone();
        } catch (java.lang.CloneNotSupportedException e) {
            com.amap.api.col.s.i.a(e, "RoutePOISearchQuery", "RoutePOISearchQueryclone");
        }
        java.util.List<com.amap.api.services.core.LatLonPoint> list = this.f;
        return (list == null || list.size() <= 0) ? new com.amap.api.services.routepoisearch.RoutePOISearchQuery(this.a, this.b, this.c, this.d, this.e) : new com.amap.api.services.routepoisearch.RoutePOISearchQuery(this.f, this.d, this.e);
    }

    public com.amap.api.services.core.LatLonPoint getFrom() {
        return this.a;
    }

    public int getMode() {
        return this.c;
    }

    public java.util.List<com.amap.api.services.core.LatLonPoint> getPolylines() {
        return this.f;
    }

    public int getRange() {
        return this.e;
    }

    public com.amap.api.services.routepoisearch.RoutePOISearch.RoutePOISearchType getSearchType() {
        return this.d;
    }

    public com.amap.api.services.core.LatLonPoint getTo() {
        return this.b;
    }
}
