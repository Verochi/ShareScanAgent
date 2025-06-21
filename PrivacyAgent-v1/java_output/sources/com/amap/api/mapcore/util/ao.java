package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class ao extends com.amap.api.mapcore.util.bk<java.lang.String, com.amap.api.mapcore.util.an> {
    public ao(android.content.Context context, java.lang.String str) {
        super(context, str);
    }

    private static com.amap.api.mapcore.util.an b(org.json.JSONObject jSONObject) throws com.amap.api.maps.AMapException {
        com.amap.api.mapcore.util.an anVar = new com.amap.api.mapcore.util.an();
        try {
            java.lang.String optString = jSONObject.optString("update", "");
            if (optString.equals("0")) {
                anVar.a(false);
            } else if (optString.equals("1")) {
                anVar.a(true);
            }
            anVar.a(jSONObject.optString("version", ""));
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.gd.c(th, "OfflineInitHandlerAbstract", "loadData parseJson");
        }
        return anVar;
    }

    @Override // com.amap.api.mapcore.util.bk
    public final /* synthetic */ com.amap.api.mapcore.util.an a(org.json.JSONObject jSONObject) throws com.amap.api.maps.AMapException {
        return b(jSONObject);
    }

    @Override // com.amap.api.mapcore.util.bk
    public final java.lang.String a() {
        return "016";
    }

    @Override // com.amap.api.mapcore.util.bk
    public final org.json.JSONObject a(com.amap.api.mapcore.util.ew.a aVar) {
        org.json.JSONObject jSONObject;
        if (aVar == null || (jSONObject = aVar.f) == null) {
            return null;
        }
        return jSONObject.optJSONObject("016");
    }

    @Override // com.amap.api.mapcore.util.bk
    public final java.util.Map<java.lang.String, java.lang.String> b() {
        java.util.Hashtable hashtable = new java.util.Hashtable(16);
        hashtable.put("mapver", this.a);
        return hashtable;
    }
}
