package com.amap.api.services.weather;

/* loaded from: classes12.dex */
public class WeatherSearchQuery implements java.lang.Cloneable {
    public static final int WEATHER_TYPE_FORECAST = 2;
    public static final int WEATHER_TYPE_LIVE = 1;
    private java.lang.String a;
    private int b;

    public WeatherSearchQuery() {
        this.b = 1;
    }

    public WeatherSearchQuery(java.lang.String str, int i) {
        this.a = str;
        this.b = i;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public com.amap.api.services.weather.WeatherSearchQuery m42clone() {
        try {
            super.clone();
        } catch (java.lang.CloneNotSupportedException e) {
            com.amap.api.col.s.i.a(e, "WeatherSearchQuery", "clone");
        }
        return new com.amap.api.services.weather.WeatherSearchQuery(this.a, this.b);
    }

    public java.lang.String getCity() {
        return this.a;
    }

    public int getType() {
        return this.b;
    }
}
