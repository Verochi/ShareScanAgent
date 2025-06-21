package com.amap.api.col.s;

/* loaded from: classes12.dex */
public abstract class e<T, V> extends com.amap.api.col.s.b<T, V> {
    public e(android.content.Context context, T t) {
        super(context, t);
        this.a = false;
    }

    public static org.json.JSONArray a(org.json.JSONObject jSONObject) {
        org.json.JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject != null) {
            return optJSONObject.optJSONArray(org.apache.tools.ant.taskdefs.optional.j2ee.HotDeploymentTool.ACTION_LIST);
        }
        return null;
    }

    public static void a(com.amap.api.services.cloud.CloudItem cloudItem, org.json.JSONObject jSONObject) {
        java.util.Iterator<java.lang.String> keys = jSONObject.keys();
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        if (keys == null) {
            return;
        }
        while (keys.hasNext()) {
            java.lang.String next = keys.next();
            if (next != null) {
                hashMap.put(next.toString(), jSONObject.optString(next.toString()));
            }
        }
        cloudItem.setCustomfield(hashMap);
    }

    public static int b(org.json.JSONObject jSONObject) {
        org.json.JSONObject optJSONObject;
        org.json.JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
        if (optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject("info")) == null) {
            return 0;
        }
        return optJSONObject.optInt(me.leolin.shortcutbadger.impl.NewHtcHomeBadger.COUNT);
    }

    public static com.amap.api.services.cloud.CloudItemDetail c(org.json.JSONObject jSONObject) throws org.json.JSONException {
        com.amap.api.services.cloud.CloudItemDetail cloudItemDetail = new com.amap.api.services.cloud.CloudItemDetail(com.amap.api.col.s.p.a(jSONObject, "id"), new com.amap.api.services.core.LatLonPoint(jSONObject.optDouble("point_y"), jSONObject.optDouble("point_x")), com.amap.api.col.s.p.a(jSONObject, "title"), com.amap.api.col.s.p.a(jSONObject, "address"));
        cloudItemDetail.setCreatetime(com.amap.api.col.s.p.a(jSONObject, "gmt_create"));
        cloudItemDetail.setUpdatetime(com.amap.api.col.s.p.a(jSONObject, "gmt_modified"));
        if (jSONObject.has("_distance")) {
            java.lang.String optString = jSONObject.optString("_distance");
            if (!c(optString)) {
                cloudItemDetail.setDistance(java.lang.Integer.parseInt(optString));
            }
        }
        return cloudItemDetail;
    }

    public static boolean c(java.lang.String str) {
        return str == null || str.equals("") || str.equals("[]");
    }

    @Override // com.amap.api.col.s.a
    public final V a(byte[] bArr) throws com.amap.api.services.core.AMapException {
        java.lang.String str;
        try {
            str = new java.lang.String(bArr, "utf-8");
        } catch (java.lang.Exception e) {
            com.amap.api.col.s.i.a(e, "ProtocalHandler", "loadData");
            str = null;
        }
        if (str == null || str.equals("")) {
            return null;
        }
        com.amap.api.col.s.i.c(str);
        return a(str);
    }

    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a, com.amap.api.col.s.dd
    public final java.util.Map<java.lang.String, java.lang.String> f() {
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put("Content-Type", com.anythink.expressad.foundation.g.f.g.b.e);
        hashMap.put(com.google.common.net.HttpHeaders.ACCEPT_ENCODING, "gzip");
        hashMap.put("User-Agent", "AMAP SDK Android Search 8.1.0");
        hashMap.put("X-INFO", com.amap.api.col.s.bl.a(this.e));
        hashMap.put("platinfo", java.lang.String.format("platform=Android&sdkversion=%s&product=%s", "8.1.0", com.aliyun.svideo.editor.util.AlivcResUtil.HOST_CLOUD));
        hashMap.put("logversion", "2.1");
        return hashMap;
    }

    @Override // com.amap.api.col.s.b, com.amap.api.col.s.dd
    public final byte[] g() {
        return null;
    }
}
