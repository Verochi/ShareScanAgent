package com.amap.api.col.s;

/* loaded from: classes12.dex */
public final class f extends com.amap.api.col.s.e<com.amap.api.col.s.aa, com.amap.api.services.cloud.CloudItemDetail> {
    public f(android.content.Context context, com.amap.api.col.s.aa aaVar) {
        super(context, aaVar);
    }

    public static com.amap.api.services.cloud.CloudItemDetail G(java.lang.String str) throws com.amap.api.services.core.AMapException {
        if (str == null || str.equals("")) {
            return null;
        }
        try {
            return H(new org.json.JSONObject(str));
        } catch (org.json.JSONException e) {
            e.printStackTrace();
            return null;
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static com.amap.api.services.cloud.CloudItemDetail H(org.json.JSONObject jSONObject) throws org.json.JSONException {
        org.json.JSONArray a = com.amap.api.col.s.e.a(jSONObject);
        if (a == null || a.length() <= 0) {
            return null;
        }
        org.json.JSONObject jSONObject2 = a.getJSONObject(0);
        com.amap.api.services.cloud.CloudItemDetail c = com.amap.api.col.s.e.c(jSONObject2);
        com.amap.api.col.s.e.a(c, jSONObject2);
        return c;
    }

    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    public final /* synthetic */ java.lang.Object a(java.lang.String str) throws com.amap.api.services.core.AMapException {
        return G(str);
    }

    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    public final java.lang.String a_() {
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a, com.amap.api.col.s.dd
    public final java.util.Map<java.lang.String, java.lang.String> e() {
        java.util.Hashtable hashtable = new java.util.Hashtable(16);
        hashtable.put("key", com.amap.api.col.s.bi.f(this.e));
        hashtable.put("layerId", ((com.amap.api.col.s.aa) this.b).a);
        hashtable.put("output", com.aliyun.auth.common.AliyunVodHttpCommon.Format.FORMAT_JSON);
        hashtable.put("id", ((com.amap.api.col.s.aa) this.b).b);
        java.lang.String a = com.amap.api.col.s.bl.a();
        java.lang.String a2 = com.amap.api.col.s.bl.a(this.e, a, com.amap.api.col.s.bu.b(hashtable));
        hashtable.put("ts", a);
        hashtable.put("scode", a2);
        return hashtable;
    }

    @Override // com.amap.api.col.s.dd
    public final java.lang.String h() {
        return com.amap.api.col.s.h.d() + "/datasearch/id";
    }
}
