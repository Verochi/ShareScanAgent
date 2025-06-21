package com.amap.api.col.s;

/* loaded from: classes12.dex */
public final class n extends com.amap.api.col.s.b<com.amap.api.services.geocoder.GeocodeQuery, java.util.ArrayList<com.amap.api.services.geocoder.GeocodeAddress>> {
    public n(android.content.Context context, com.amap.api.services.geocoder.GeocodeQuery geocodeQuery) {
        super(context, geocodeQuery);
    }

    public static java.util.ArrayList<com.amap.api.services.geocoder.GeocodeAddress> G(java.lang.String str) throws com.amap.api.services.core.AMapException {
        java.util.ArrayList<com.amap.api.services.geocoder.GeocodeAddress> arrayList = new java.util.ArrayList<>();
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            return (jSONObject.has(me.leolin.shortcutbadger.impl.NewHtcHomeBadger.COUNT) && jSONObject.getInt(me.leolin.shortcutbadger.impl.NewHtcHomeBadger.COUNT) > 0) ? com.amap.api.col.s.p.g(jSONObject) : arrayList;
        } catch (org.json.JSONException e) {
            com.amap.api.col.s.i.a(e, "GeocodingHandler", "paseJSONJSONException");
            return arrayList;
        } catch (java.lang.Exception e2) {
            com.amap.api.col.s.i.a(e2, "GeocodingHandler", "paseJSONException");
            return arrayList;
        }
    }

    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    public final /* synthetic */ java.lang.Object a(java.lang.String str) throws com.amap.api.services.core.AMapException {
        return G(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    public final java.lang.String a_() {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        stringBuffer.append("output=json&address=");
        stringBuffer.append(com.amap.api.col.s.b.b(((com.amap.api.services.geocoder.GeocodeQuery) this.b).getLocationName()));
        java.lang.String city = ((com.amap.api.services.geocoder.GeocodeQuery) this.b).getCity();
        if (!com.amap.api.col.s.p.f(city)) {
            java.lang.String b = com.amap.api.col.s.b.b(city);
            stringBuffer.append("&city=");
            stringBuffer.append(b);
        }
        if (!com.amap.api.col.s.p.f(((com.amap.api.services.geocoder.GeocodeQuery) this.b).getCountry())) {
            stringBuffer.append("&country=");
            stringBuffer.append(com.amap.api.col.s.b.b(((com.amap.api.services.geocoder.GeocodeQuery) this.b).getCountry()));
        }
        stringBuffer.append("&key=" + com.amap.api.col.s.bi.f(this.e));
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.a
    public final com.amap.api.col.s.ad.b d() {
        com.amap.api.col.s.ad.b bVar = new com.amap.api.col.s.ad.b();
        bVar.a = h() + a_() + "language=" + com.amap.api.services.core.ServiceSettings.getInstance().getLanguage();
        return bVar;
    }

    @Override // com.amap.api.col.s.dd
    public final java.lang.String h() {
        return com.amap.api.col.s.h.a() + "/geocode/geo?";
    }
}
