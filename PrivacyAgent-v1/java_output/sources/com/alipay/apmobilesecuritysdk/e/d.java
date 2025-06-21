package com.alipay.apmobilesecuritysdk.e;

/* loaded from: classes.dex */
public final class d {
    public static com.alipay.apmobilesecuritysdk.e.c a(java.lang.String str) {
        try {
            if (!com.alipay.sdk.m.z.a.a(str)) {
                org.json.JSONObject jSONObject = new org.json.JSONObject(str);
                return new com.alipay.apmobilesecuritysdk.e.c(jSONObject.optString("apdid"), jSONObject.optString("deviceInfoHash"), jSONObject.optString("timestamp"), jSONObject.optString("tid"), jSONObject.optString(com.alipay.sdk.m.l.b.g));
            }
        } catch (java.lang.Exception e) {
            com.alipay.apmobilesecuritysdk.c.a.a(e);
        }
        return null;
    }

    public static synchronized void a() {
        synchronized (com.alipay.apmobilesecuritysdk.e.d.class) {
        }
    }

    public static synchronized void a(android.content.Context context) {
        synchronized (com.alipay.apmobilesecuritysdk.e.d.class) {
            com.alipay.apmobilesecuritysdk.f.a.a(context, "vkeyid_profiles_v4", "key_deviceid_v4", "");
            com.alipay.apmobilesecuritysdk.f.a.a("wxcasxx_v4", "key_wxcasxx_v4", "");
        }
    }

    public static synchronized void a(android.content.Context context, com.alipay.apmobilesecuritysdk.e.c cVar) {
        synchronized (com.alipay.apmobilesecuritysdk.e.d.class) {
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                jSONObject.put("apdid", cVar.a);
                jSONObject.put("deviceInfoHash", cVar.b);
                jSONObject.put("timestamp", cVar.c);
                jSONObject.put("tid", cVar.d);
                jSONObject.put(com.alipay.sdk.m.l.b.g, cVar.e);
                java.lang.String jSONObject2 = jSONObject.toString();
                com.alipay.apmobilesecuritysdk.f.a.a(context, "vkeyid_profiles_v4", "key_deviceid_v4", jSONObject2);
                com.alipay.apmobilesecuritysdk.f.a.a("wxcasxx_v4", "key_wxcasxx_v4", jSONObject2);
            } catch (java.lang.Exception e) {
                com.alipay.apmobilesecuritysdk.c.a.a(e);
            }
        }
    }

    public static synchronized com.alipay.apmobilesecuritysdk.e.c b() {
        synchronized (com.alipay.apmobilesecuritysdk.e.d.class) {
            java.lang.String a = com.alipay.apmobilesecuritysdk.f.a.a("wxcasxx_v4", "key_wxcasxx_v4");
            if (com.alipay.sdk.m.z.a.a(a)) {
                return null;
            }
            return a(a);
        }
    }

    public static synchronized com.alipay.apmobilesecuritysdk.e.c b(android.content.Context context) {
        com.alipay.apmobilesecuritysdk.e.c a;
        synchronized (com.alipay.apmobilesecuritysdk.e.d.class) {
            java.lang.String a2 = com.alipay.apmobilesecuritysdk.f.a.a(context, "vkeyid_profiles_v4", "key_deviceid_v4");
            if (com.alipay.sdk.m.z.a.a(a2)) {
                a2 = com.alipay.apmobilesecuritysdk.f.a.a("wxcasxx_v4", "key_wxcasxx_v4");
            }
            a = a(a2);
        }
        return a;
    }

    public static synchronized com.alipay.apmobilesecuritysdk.e.c c(android.content.Context context) {
        synchronized (com.alipay.apmobilesecuritysdk.e.d.class) {
            java.lang.String a = com.alipay.apmobilesecuritysdk.f.a.a(context, "vkeyid_profiles_v4", "key_deviceid_v4");
            if (com.alipay.sdk.m.z.a.a(a)) {
                return null;
            }
            return a(a);
        }
    }
}
