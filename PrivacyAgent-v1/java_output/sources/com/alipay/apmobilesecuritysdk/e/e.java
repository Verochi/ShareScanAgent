package com.alipay.apmobilesecuritysdk.e;

/* loaded from: classes.dex */
public final class e {
    public static com.alipay.apmobilesecuritysdk.e.f a(android.content.Context context) {
        if (context == null) {
            return null;
        }
        java.lang.String a = com.alipay.apmobilesecuritysdk.f.a.a(context, "device_feature_prefs_name", "device_feature_prefs_key");
        if (com.alipay.sdk.m.z.a.a(a)) {
            a = com.alipay.apmobilesecuritysdk.f.a.a("device_feature_file_name", "device_feature_file_key");
        }
        if (com.alipay.sdk.m.z.a.a(a)) {
            return null;
        }
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(a);
            com.alipay.apmobilesecuritysdk.e.f fVar = new com.alipay.apmobilesecuritysdk.e.f();
            fVar.a(jSONObject.getString("imei"));
            fVar.b(jSONObject.getString("imsi"));
            fVar.c(jSONObject.getString("mac"));
            fVar.d(jSONObject.getString("bluetoothmac"));
            fVar.e(jSONObject.getString("gsi"));
            return fVar;
        } catch (java.lang.Exception e) {
            com.alipay.apmobilesecuritysdk.c.a.a(e);
            return null;
        }
    }
}
