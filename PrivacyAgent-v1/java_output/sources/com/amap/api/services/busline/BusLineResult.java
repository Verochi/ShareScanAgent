package com.amap.api.services.busline;

/* loaded from: classes12.dex */
public final class BusLineResult {
    private int a;
    private java.util.ArrayList<com.amap.api.services.busline.BusLineItem> b;
    private com.amap.api.services.busline.BusLineQuery c;
    private java.util.List<java.lang.String> d;
    private java.util.List<com.amap.api.services.core.SuggestionCity> e;

    private BusLineResult(com.amap.api.services.busline.BusLineQuery busLineQuery, int i, java.util.List<com.amap.api.services.core.SuggestionCity> list, java.util.List<java.lang.String> list2, java.util.ArrayList<com.amap.api.services.busline.BusLineItem> arrayList) {
        this.b = new java.util.ArrayList<>();
        this.d = new java.util.ArrayList();
        this.e = new java.util.ArrayList();
        this.c = busLineQuery;
        this.a = a(i);
        this.e = list;
        this.d = list2;
        this.b = arrayList;
    }

    private int a(int i) {
        int pageSize = ((i + r0) - 1) / this.c.getPageSize();
        if (pageSize > 30) {
            return 30;
        }
        return pageSize;
    }

    public static com.amap.api.services.busline.BusLineResult createPagedResult(com.amap.api.services.busline.BusLineQuery busLineQuery, int i, java.util.List<com.amap.api.services.core.SuggestionCity> list, java.util.List<java.lang.String> list2, java.util.ArrayList<com.amap.api.services.busline.BusLineItem> arrayList) {
        return new com.amap.api.services.busline.BusLineResult(busLineQuery, i, list, list2, arrayList);
    }

    public final java.util.List<com.amap.api.services.busline.BusLineItem> getBusLines() {
        return this.b;
    }

    public final int getPageCount() {
        return this.a;
    }

    public final com.amap.api.services.busline.BusLineQuery getQuery() {
        return this.c;
    }

    public final java.util.List<com.amap.api.services.core.SuggestionCity> getSearchSuggestionCities() {
        return this.e;
    }

    public final java.util.List<java.lang.String> getSearchSuggestionKeywords() {
        return this.d;
    }
}
