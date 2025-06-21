package com.amap.api.services.routepoisearch;

/* loaded from: classes12.dex */
public class RoutePOISearchResult {
    private java.util.List<com.amap.api.services.routepoisearch.RoutePOIItem> a;
    private com.amap.api.services.routepoisearch.RoutePOISearchQuery b;

    public RoutePOISearchResult(java.util.ArrayList<com.amap.api.services.routepoisearch.RoutePOIItem> arrayList, com.amap.api.services.routepoisearch.RoutePOISearchQuery routePOISearchQuery) {
        new java.util.ArrayList();
        this.a = arrayList;
        this.b = routePOISearchQuery;
    }

    public com.amap.api.services.routepoisearch.RoutePOISearchQuery getQuery() {
        return this.b;
    }

    public java.util.List<com.amap.api.services.routepoisearch.RoutePOIItem> getRoutePois() {
        return this.a;
    }
}
