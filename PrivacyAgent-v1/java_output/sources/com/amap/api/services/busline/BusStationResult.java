package com.amap.api.services.busline;

/* loaded from: classes12.dex */
public final class BusStationResult {
    private int a;
    private java.util.ArrayList<com.amap.api.services.busline.BusStationItem> b;
    private com.amap.api.services.busline.BusStationQuery c;
    private java.util.List<java.lang.String> d;
    private java.util.List<com.amap.api.services.core.SuggestionCity> e;

    private BusStationResult(com.amap.api.services.busline.BusStationQuery busStationQuery, int i, java.util.List<com.amap.api.services.core.SuggestionCity> list, java.util.List<java.lang.String> list2, java.util.ArrayList<com.amap.api.services.busline.BusStationItem> arrayList) {
        this.b = new java.util.ArrayList<>();
        this.d = new java.util.ArrayList();
        this.e = new java.util.ArrayList();
        this.c = busStationQuery;
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

    public static com.amap.api.services.busline.BusStationResult createPagedResult(com.amap.api.services.busline.BusStationQuery busStationQuery, int i, java.util.List<com.amap.api.services.core.SuggestionCity> list, java.util.List<java.lang.String> list2, java.util.ArrayList<com.amap.api.services.busline.BusStationItem> arrayList) {
        return new com.amap.api.services.busline.BusStationResult(busStationQuery, i, list, list2, arrayList);
    }

    public final java.util.List<com.amap.api.services.busline.BusStationItem> getBusStations() {
        return this.b;
    }

    public final int getPageCount() {
        return this.a;
    }

    public final com.amap.api.services.busline.BusStationQuery getQuery() {
        return this.c;
    }

    public final java.util.List<com.amap.api.services.core.SuggestionCity> getSearchSuggestionCities() {
        return this.e;
    }

    public final java.util.List<java.lang.String> getSearchSuggestionKeywords() {
        return this.d;
    }
}
