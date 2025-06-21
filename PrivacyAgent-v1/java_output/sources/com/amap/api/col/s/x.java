package com.amap.api.col.s;

/* loaded from: classes12.dex */
public final class x extends com.amap.api.col.s.w<java.lang.String, com.amap.api.services.core.PoiItem> {
    public com.amap.api.services.poisearch.PoiSearch.Query t;

    public x(android.content.Context context, java.lang.String str, com.amap.api.services.poisearch.PoiSearch.Query query) {
        super(context, str);
        this.t = query;
    }

    public static com.amap.api.services.core.PoiItem G(org.json.JSONObject jSONObject) throws org.json.JSONException {
        org.json.JSONObject optJSONObject;
        org.json.JSONArray optJSONArray = jSONObject.optJSONArray("pois");
        if (optJSONArray == null || optJSONArray.length() <= 0 || (optJSONObject = optJSONArray.optJSONObject(0)) == null) {
            return null;
        }
        return com.amap.api.col.s.p.d(optJSONObject);
    }

    public static com.amap.api.services.core.PoiItem H(java.lang.String str) throws com.amap.api.services.core.AMapException {
        try {
            return G(new org.json.JSONObject(str));
        } catch (org.json.JSONException e) {
            com.amap.api.col.s.i.a(e, "PoiSearchIdHandler", "paseJSONJSONException");
            return null;
        } catch (java.lang.Exception e2) {
            com.amap.api.col.s.i.a(e2, "PoiSearchIdHandler", "paseJSONException");
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private java.lang.String j() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("id=");
        sb.append((java.lang.String) this.b);
        sb.append("&output=json");
        com.amap.api.services.poisearch.PoiSearch.Query query = this.t;
        if (query == null || com.amap.api.col.s.w.c(query.getExtensions())) {
            sb.append("&extensions=base");
        } else {
            sb.append("&extensions=");
            sb.append(this.t.getExtensions());
        }
        sb.append("&children=1");
        sb.append("&key=" + com.amap.api.col.s.bi.f(this.e));
        return sb.toString();
    }

    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    public final /* synthetic */ java.lang.Object a(java.lang.String str) throws com.amap.api.services.core.AMapException {
        return H(str);
    }

    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    public final java.lang.String a_() {
        return j();
    }

    @Override // com.amap.api.col.s.a
    public final com.amap.api.col.s.ad.b d() {
        com.amap.api.col.s.ad.b bVar = new com.amap.api.col.s.ad.b();
        bVar.a = h() + a_() + "language=" + com.amap.api.services.core.ServiceSettings.getInstance().getLanguage();
        return bVar;
    }

    @Override // com.amap.api.col.s.dd
    public final java.lang.String h() {
        return com.amap.api.col.s.h.a() + "/place/detail?";
    }
}
