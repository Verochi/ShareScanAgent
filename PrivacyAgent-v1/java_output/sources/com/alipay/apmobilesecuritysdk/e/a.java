package com.alipay.apmobilesecuritysdk.e;

/* loaded from: classes.dex */
public final class a {
    public static com.alipay.apmobilesecuritysdk.e.b a(java.lang.String str) {
        try {
            if (!com.alipay.sdk.m.z.a.a(str)) {
                org.json.JSONObject jSONObject = new org.json.JSONObject(str);
                return new com.alipay.apmobilesecuritysdk.e.b(jSONObject.optString("apdid"), jSONObject.optString("deviceInfoHash"), jSONObject.optString("timestamp"));
            }
        } catch (java.lang.Exception e) {
            com.alipay.apmobilesecuritysdk.c.a.a(e);
        }
        return null;
    }

    public static synchronized void a() {
        synchronized (com.alipay.apmobilesecuritysdk.e.a.class) {
        }
    }

    public static synchronized void a(android.content.Context context) {
        synchronized (com.alipay.apmobilesecuritysdk.e.a.class) {
            com.alipay.apmobilesecuritysdk.f.a.a(context, "vkeyid_profiles_v3", "deviceid", "");
            com.alipay.apmobilesecuritysdk.f.a.a("wxcasxx_v3", "wxcasxx", "");
        }
    }

    public static synchronized void a(android.content.Context context, com.alipay.apmobilesecuritysdk.e.b bVar) {
        synchronized (com.alipay.apmobilesecuritysdk.e.a.class) {
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                jSONObject.put("apdid", bVar.a);
                jSONObject.put("deviceInfoHash", bVar.b);
                jSONObject.put("timestamp", bVar.c);
                java.lang.String jSONObject2 = jSONObject.toString();
                com.alipay.apmobilesecuritysdk.f.a.a(context, "vkeyid_profiles_v3", "deviceid", jSONObject2);
                com.alipay.apmobilesecuritysdk.f.a.a("wxcasxx_v3", "wxcasxx", jSONObject2);
            } catch (java.lang.Exception e) {
                com.alipay.apmobilesecuritysdk.c.a.a(e);
            }
        }
    }

    public static synchronized com.alipay.apmobilesecuritysdk.e.b b() {
        synchronized (com.alipay.apmobilesecuritysdk.e.a.class) {
            java.lang.String a = com.alipay.apmobilesecuritysdk.f.a.a("wxcasxx_v3", "wxcasxx");
            if (com.alipay.sdk.m.z.a.a(a)) {
                return null;
            }
            return a(a);
        }
    }

    public static synchronized com.alipay.apmobilesecuritysdk.e.b b(android.content.Context context) {
        com.alipay.apmobilesecuritysdk.e.b a;
        synchronized (com.alipay.apmobilesecuritysdk.e.a.class) {
            java.lang.String a2 = com.alipay.apmobilesecuritysdk.f.a.a(context, "vkeyid_profiles_v3", "deviceid");
            if (com.alipay.sdk.m.z.a.a(a2)) {
                a2 = com.alipay.apmobilesecuritysdk.f.a.a("wxcasxx_v3", "wxcasxx");
            }
            a = a(a2);
        }
        return a;
    }

    public static synchronized com.alipay.apmobilesecuritysdk.e.b c(android.content.Context context) {
        synchronized (com.alipay.apmobilesecuritysdk.e.a.class) {
            java.lang.String a = com.alipay.apmobilesecuritysdk.f.a.a(context, "vkeyid_profiles_v3", "deviceid");
            if (com.alipay.sdk.m.z.a.a(a)) {
                return null;
            }
            return a(a);
        }
    }
}
