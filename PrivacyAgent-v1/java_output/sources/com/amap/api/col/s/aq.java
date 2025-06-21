package com.amap.api.col.s;

/* loaded from: classes12.dex */
public final class aq extends com.amap.api.col.s.as<com.amap.api.services.weather.WeatherSearchQuery, com.amap.api.services.weather.LocalWeatherForecast> {
    public com.amap.api.services.weather.LocalWeatherForecast t;

    public aq(android.content.Context context, com.amap.api.services.weather.WeatherSearchQuery weatherSearchQuery) {
        super(context, weatherSearchQuery);
        this.t = new com.amap.api.services.weather.LocalWeatherForecast();
    }

    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public final com.amap.api.services.weather.LocalWeatherForecast a(java.lang.String str) throws com.amap.api.services.core.AMapException {
        com.amap.api.services.weather.LocalWeatherForecast e = com.amap.api.col.s.p.e(str);
        this.t = e;
        return e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    public final java.lang.String a_() {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        stringBuffer.append("output=json");
        java.lang.String city = ((com.amap.api.services.weather.WeatherSearchQuery) this.b).getCity();
        if (!com.amap.api.col.s.p.f(city)) {
            java.lang.String b = com.amap.api.col.s.b.b(city);
            stringBuffer.append("&city=");
            stringBuffer.append(b);
        }
        stringBuffer.append("&extensions=all");
        stringBuffer.append("&key=" + com.amap.api.col.s.bi.f(this.e));
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.as, com.amap.api.col.s.dd
    public final /* bridge */ /* synthetic */ java.lang.String h() {
        return super.h();
    }
}
