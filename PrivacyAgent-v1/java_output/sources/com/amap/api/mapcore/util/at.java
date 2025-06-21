package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class at extends com.amap.api.mapcore.util.bk<java.lang.String, java.util.List<com.amap.api.maps.offlinemap.OfflineMapProvince>> {
    private android.content.Context d;

    public at(android.content.Context context, java.lang.String str) {
        super(context, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.amap.api.mapcore.util.bk
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public java.util.List<com.amap.api.maps.offlinemap.OfflineMapProvince> a(org.json.JSONObject jSONObject) throws com.amap.api.maps.AMapException {
        try {
            if (this.d != null) {
                com.amap.api.mapcore.util.bj.c(jSONObject.toString(), this.d);
            }
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.gd.c(th, "OfflineUpdateCityHandlerAbstract", "loadData jsonInit");
            th.printStackTrace();
        }
        try {
            android.content.Context context = this.d;
            if (context != null) {
                return com.amap.api.mapcore.util.bj.a(jSONObject, context);
            }
            return null;
        } catch (org.json.JSONException e) {
            com.amap.api.mapcore.util.gd.c(e, "OfflineUpdateCityHandlerAbstract", "loadData parseJson");
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.amap.api.mapcore.util.bk
    public final java.lang.String a() {
        return "015";
    }

    @Override // com.amap.api.mapcore.util.bk
    public final org.json.JSONObject a(com.amap.api.mapcore.util.ew.a aVar) {
        org.json.JSONObject jSONObject;
        if (aVar == null || (jSONObject = aVar.f) == null) {
            return null;
        }
        org.json.JSONObject optJSONObject = jSONObject.optJSONObject("015");
        if (!optJSONObject.has("result")) {
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            try {
                jSONObject2.put("result", new org.json.JSONObject().put("offlinemap_with_province_vfour", optJSONObject));
                return jSONObject2;
            } catch (org.json.JSONException e) {
                e.printStackTrace();
            }
        }
        return optJSONObject;
    }

    public final void a(android.content.Context context) {
        this.d = context;
    }

    @Override // com.amap.api.mapcore.util.bk
    public final java.util.Map<java.lang.String, java.lang.String> b() {
        java.util.Hashtable hashtable = new java.util.Hashtable(16);
        hashtable.put("mapver", this.a);
        return hashtable;
    }
}
