package com.amap.api.mapcore.util;

@java.lang.Deprecated
/* loaded from: classes12.dex */
public final class ex {
    public static int a = -1;
    public static java.lang.String b = "";
    private static com.amap.api.mapcore.util.fh c = null;
    private static java.lang.String d = "http://apiinit.amap.com/v3/log/init";
    private static java.lang.String e;

    private static java.util.Map<java.lang.String, java.lang.String> a(android.content.Context context) {
        java.util.HashMap hashMap = new java.util.HashMap();
        try {
            hashMap.put("resType", com.aliyun.auth.common.AliyunVodHttpCommon.Format.FORMAT_JSON);
            hashMap.put("encode", "UTF-8");
            java.lang.String a2 = com.amap.api.mapcore.util.ey.a();
            hashMap.put("ts", a2);
            hashMap.put("key", com.amap.api.mapcore.util.ev.f(context));
            hashMap.put("scode", com.amap.api.mapcore.util.ey.a(context, a2, com.amap.api.mapcore.util.fi.d("resType=json&encode=UTF-8&key=" + com.amap.api.mapcore.util.ev.f(context))));
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.ga.a(th, "Auth", "gParams");
        }
        return hashMap;
    }

    @java.lang.Deprecated
    public static synchronized boolean a(android.content.Context context, com.amap.api.mapcore.util.fh fhVar) {
        boolean b2;
        synchronized (com.amap.api.mapcore.util.ex.class) {
            b2 = b(context, fhVar);
        }
        return b2;
    }

    private static boolean a(byte[] bArr) {
        if (bArr == null) {
            return true;
        }
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(com.amap.api.mapcore.util.fi.a(bArr));
            if (jSONObject.has("status")) {
                int i = jSONObject.getInt("status");
                if (i == 1) {
                    a = 1;
                } else if (i == 0) {
                    a = 0;
                }
            }
            if (jSONObject.has("info")) {
                b = jSONObject.getString("info");
            }
            int i2 = a;
            return a == 1;
        } catch (org.json.JSONException e2) {
            com.amap.api.mapcore.util.ga.a(e2, "Auth", "lData");
            return false;
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.ga.a(th, "Auth", "lData");
            return false;
        }
    }

    private static boolean b(android.content.Context context, com.amap.api.mapcore.util.fh fhVar) {
        c = fhVar;
        try {
            java.lang.String str = d;
            java.util.HashMap hashMap = new java.util.HashMap();
            hashMap.put("Content-Type", com.anythink.expressad.foundation.g.f.g.b.e);
            hashMap.put(com.google.common.net.HttpHeaders.ACCEPT_ENCODING, "gzip");
            hashMap.put(com.google.common.net.HttpHeaders.CONNECTION, com.anythink.expressad.foundation.g.f.g.b.c);
            hashMap.put("User-Agent", c.d());
            hashMap.put("X-INFO", com.amap.api.mapcore.util.ey.b(context));
            hashMap.put("logversion", "2.1");
            hashMap.put("platinfo", java.lang.String.format("platform=Android&sdkversion=%s&product=%s", c.b(), c.a()));
            com.amap.api.mapcore.util.hb a2 = com.amap.api.mapcore.util.hb.a();
            com.amap.api.mapcore.util.fj fjVar = new com.amap.api.mapcore.util.fj();
            fjVar.setProxy(com.amap.api.mapcore.util.fg.a(context));
            fjVar.a(hashMap);
            fjVar.b(a(context));
            fjVar.a(str);
            return a(a2.a(fjVar));
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.ga.a(th, "Auth", "getAuth");
            return true;
        }
    }
}
