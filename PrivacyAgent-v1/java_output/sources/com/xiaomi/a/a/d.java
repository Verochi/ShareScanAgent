package com.xiaomi.a.a;

/* loaded from: classes19.dex */
public class d {
    private java.lang.String a = android.os.Build.VERSION.RELEASE + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + android.os.Build.VERSION.INCREMENTAL;
    private java.lang.String b = com.xiaomi.push.iu.c();
    public int e;
    public java.lang.String f;
    public int g;
    public java.lang.String h;
    public java.lang.String i;

    public org.json.JSONObject a() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("production", this.e);
            jSONObject.put("reportType", this.g);
            jSONObject.put("clientInterfaceId", this.f);
            jSONObject.put("os", this.a);
            jSONObject.put("miuiVersion", this.b);
            jSONObject.put(com.vivo.push.PushClientConstants.TAG_PKG_NAME, this.h);
            jSONObject.put(com.heytap.mcssdk.constant.b.C, this.i);
            return jSONObject;
        } catch (org.json.JSONException e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return null;
        }
    }

    public java.lang.String b() {
        org.json.JSONObject a = a();
        return a == null ? "" : a.toString();
    }
}
