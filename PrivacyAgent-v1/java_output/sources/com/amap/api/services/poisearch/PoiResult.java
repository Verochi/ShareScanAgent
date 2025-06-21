package com.amap.api.services.poisearch;

/* loaded from: classes12.dex */
public final class PoiResult {
    private int a;
    private java.util.ArrayList<com.amap.api.services.core.PoiItem> b;
    private com.amap.api.services.poisearch.PoiSearch.Query c;
    private com.amap.api.services.poisearch.PoiSearch.SearchBound d;
    private java.util.List<java.lang.String> e;
    private java.util.List<com.amap.api.services.core.SuggestionCity> f;
    private int g;

    private PoiResult(com.amap.api.services.poisearch.PoiSearch.Query query, com.amap.api.services.poisearch.PoiSearch.SearchBound searchBound, java.util.List<java.lang.String> list, java.util.List<com.amap.api.services.core.SuggestionCity> list2, int i, int i2, java.util.ArrayList<com.amap.api.services.core.PoiItem> arrayList) {
        this.b = new java.util.ArrayList<>();
        this.c = query;
        this.d = searchBound;
        this.e = list;
        this.f = list2;
        this.g = i;
        this.a = a(i2);
        this.b = arrayList;
    }

    private int a(int i) {
        return ((i + r0) - 1) / this.g;
    }

    public static com.amap.api.services.poisearch.PoiResult createPagedResult(com.amap.api.services.poisearch.PoiSearch.Query query, com.amap.api.services.poisearch.PoiSearch.SearchBound searchBound, java.util.List<java.lang.String> list, java.util.List<com.amap.api.services.core.SuggestionCity> list2, int i, int i2, java.util.ArrayList<com.amap.api.services.core.PoiItem> arrayList) {
        return new com.amap.api.services.poisearch.PoiResult(query, searchBound, list, list2, i, i2, arrayList);
    }

    public final com.amap.api.services.poisearch.PoiSearch.SearchBound getBound() {
        return this.d;
    }

    public final int getPageCount() {
        return this.a;
    }

    public final java.util.ArrayList<com.amap.api.services.core.PoiItem> getPois() {
        return this.b;
    }

    public final com.amap.api.services.poisearch.PoiSearch.Query getQuery() {
        return this.c;
    }

    public final java.util.List<com.amap.api.services.core.SuggestionCity> getSearchSuggestionCitys() {
        return this.f;
    }

    public final java.util.List<java.lang.String> getSearchSuggestionKeywords() {
        return this.e;
    }
}
