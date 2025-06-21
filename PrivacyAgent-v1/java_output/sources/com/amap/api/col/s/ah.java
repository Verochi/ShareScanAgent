package com.amap.api.col.s;

/* loaded from: classes12.dex */
public final class ah extends com.amap.api.col.s.b<com.amap.api.services.geocoder.RegeocodeQuery, com.amap.api.services.geocoder.RegeocodeAddress> {
    public ah(android.content.Context context, com.amap.api.services.geocoder.RegeocodeQuery regeocodeQuery) {
        super(context, regeocodeQuery);
    }

    public static com.amap.api.services.geocoder.RegeocodeAddress H(java.lang.String str) throws com.amap.api.services.core.AMapException {
        org.json.JSONObject optJSONObject;
        com.amap.api.services.geocoder.RegeocodeAddress regeocodeAddress = new com.amap.api.services.geocoder.RegeocodeAddress();
        try {
            optJSONObject = new org.json.JSONObject(str).optJSONObject("regeocode");
        } catch (org.json.JSONException e) {
            com.amap.api.col.s.i.a(e, "ReverseGeocodingHandler", "paseJSON");
        }
        if (optJSONObject == null) {
            return regeocodeAddress;
        }
        regeocodeAddress.setFormatAddress(com.amap.api.col.s.p.a(optJSONObject, "formatted_address"));
        org.json.JSONObject optJSONObject2 = optJSONObject.optJSONObject("addressComponent");
        if (optJSONObject2 != null) {
            com.amap.api.col.s.p.a(optJSONObject2, regeocodeAddress);
        }
        regeocodeAddress.setPois(com.amap.api.col.s.p.c(optJSONObject));
        org.json.JSONArray optJSONArray = optJSONObject.optJSONArray("roads");
        if (optJSONArray != null) {
            com.amap.api.col.s.p.b(optJSONArray, regeocodeAddress);
        }
        org.json.JSONArray optJSONArray2 = optJSONObject.optJSONArray("roadinters");
        if (optJSONArray2 != null) {
            com.amap.api.col.s.p.a(optJSONArray2, regeocodeAddress);
        }
        org.json.JSONArray optJSONArray3 = optJSONObject.optJSONArray("aois");
        if (optJSONArray3 != null) {
            com.amap.api.col.s.p.c(optJSONArray3, regeocodeAddress);
        }
        return regeocodeAddress;
    }

    public static com.amap.api.col.s.af I() {
        com.amap.api.col.s.ae a = com.amap.api.col.s.ad.a().a("regeo");
        if (a == null) {
            return null;
        }
        return (com.amap.api.col.s.af) a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final java.lang.String G(boolean z) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("output=json&location=");
        if (z) {
            sb.append(com.amap.api.col.s.i.a(((com.amap.api.services.geocoder.RegeocodeQuery) this.b).getPoint().getLongitude()));
            sb.append(",");
            sb.append(com.amap.api.col.s.i.a(((com.amap.api.services.geocoder.RegeocodeQuery) this.b).getPoint().getLatitude()));
        }
        if (!android.text.TextUtils.isEmpty(((com.amap.api.services.geocoder.RegeocodeQuery) this.b).getPoiType())) {
            sb.append("&poitype=");
            sb.append(((com.amap.api.services.geocoder.RegeocodeQuery) this.b).getPoiType());
        }
        if (!android.text.TextUtils.isEmpty(((com.amap.api.services.geocoder.RegeocodeQuery) this.b).getMode())) {
            sb.append("&mode=");
            sb.append(((com.amap.api.services.geocoder.RegeocodeQuery) this.b).getMode());
        }
        if (android.text.TextUtils.isEmpty(((com.amap.api.services.geocoder.RegeocodeQuery) this.b).getExtensions())) {
            sb.append("&extensions=base");
        } else {
            sb.append("&extensions=");
            sb.append(((com.amap.api.services.geocoder.RegeocodeQuery) this.b).getExtensions());
        }
        sb.append("&radius=");
        sb.append((int) ((com.amap.api.services.geocoder.RegeocodeQuery) this.b).getRadius());
        sb.append("&coordsys=");
        sb.append(((com.amap.api.services.geocoder.RegeocodeQuery) this.b).getLatLonType());
        sb.append("&key=");
        sb.append(com.amap.api.col.s.bi.f(this.e));
        return sb.toString();
    }

    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    public final /* synthetic */ java.lang.Object a(java.lang.String str) throws com.amap.api.services.core.AMapException {
        return H(str);
    }

    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    public final java.lang.String a_() {
        return G(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.s.a
    public final com.amap.api.col.s.ad.b d() {
        com.amap.api.col.s.af I = I();
        double l = I != null ? I.l() : 0.0d;
        com.amap.api.col.s.ad.b bVar = new com.amap.api.col.s.ad.b();
        bVar.a = h() + G(false) + "language=" + com.amap.api.services.core.ServiceSettings.getInstance().getLanguage();
        T t = this.b;
        if (t != 0 && ((com.amap.api.services.geocoder.RegeocodeQuery) t).getPoint() != null) {
            bVar.b = new com.amap.api.col.s.af.a(((com.amap.api.services.geocoder.RegeocodeQuery) this.b).getPoint().getLatitude(), ((com.amap.api.services.geocoder.RegeocodeQuery) this.b).getPoint().getLongitude(), l);
        }
        return bVar;
    }

    @Override // com.amap.api.col.s.dd
    public final java.lang.String h() {
        return com.amap.api.col.s.h.a() + "/geocode/regeo?";
    }
}
