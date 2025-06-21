package com.getui.gs.e;

/* loaded from: classes22.dex */
public final class d {
    public static com.getui.gtc.base.http.GtHttpClient a = new com.getui.gtc.base.http.GtHttpClient.Builder().addInterceptor(new com.getui.gtc.base.http.LoggerInterceptor(com.getui.gs.h.b.a.a.a)).build();

    public static class a {
        private static final com.getui.gs.e.e a = new com.getui.gs.e.e(com.getui.gs.a.d.c(), com.getui.gs.a.d.b());
        private static final com.getui.gs.e.f b = new com.getui.gs.e.f();
    }

    public static com.getui.gs.e.a a(java.lang.String str) throws org.json.JSONException {
        com.getui.gs.e.a aVar = new com.getui.gs.e.a();
        org.json.JSONObject jSONObject = new org.json.JSONObject(str);
        aVar.a = jSONObject.getString("errcode");
        aVar.b = jSONObject.getString("errmsg");
        aVar.c = jSONObject.getInt("errno");
        return aVar;
    }

    public static com.getui.gtc.base.http.Interceptor a(boolean z) {
        return z ? com.getui.gs.e.d.a.a : com.getui.gs.e.d.a.b;
    }

    public static org.json.JSONObject a() throws org.json.JSONException {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        jSONObject.put("os", com.aliyun.vod.log.core.AliyunLogCommon.OPERATION_SYSTEM);
        jSONObject.put("gtcid", com.getui.gs.a.d.e());
        jSONObject.put("appid", com.getui.gs.a.d.d());
        return jSONObject;
    }
}
