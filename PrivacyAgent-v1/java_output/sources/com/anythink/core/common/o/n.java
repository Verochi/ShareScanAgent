package com.anythink.core.common.o;

/* loaded from: classes12.dex */
public final class n {
    public static final java.lang.String A = "it_src";
    public static final java.lang.String a = "platform";
    public static final java.lang.String b = "os_vn";
    public static final java.lang.String c = "os_vc";
    public static final java.lang.String d = "package_name";
    public static final java.lang.String e = "app_vn";
    public static final java.lang.String f = "app_vc";
    public static final java.lang.String g = "brand";
    public static final java.lang.String h = "model";
    public static final java.lang.String i = "screen";
    public static final java.lang.String j = "network_type";
    public static final java.lang.String k = "mnc";
    public static final java.lang.String l = "mcc";
    public static final java.lang.String m = "language";
    public static final java.lang.String n = "timezone";
    public static final java.lang.String o = "sdk_ver";
    public static final java.lang.String p = "gp_ver";
    public static final java.lang.String q = "nw_ver";
    public static final java.lang.String r = "ua";

    /* renamed from: s, reason: collision with root package name */
    public static final java.lang.String f181s = "orient";
    public static final java.lang.String t = "system";
    public static final java.lang.String u = "android_id";
    public static final java.lang.String v = "gaid";
    public static final java.lang.String w = "channel";
    public static final java.lang.String x = "sub_channel";
    public static final java.lang.String y = "upid";
    public static final java.lang.String z = "ps_id";

    public static org.json.JSONObject a() {
        org.json.JSONObject b2 = b();
        org.json.JSONObject c2 = c();
        try {
            b2.put("app_id", com.anythink.core.common.b.o.a().o());
            java.util.Iterator<java.lang.String> keys = c2.keys();
            while (keys.hasNext()) {
                java.lang.String next = keys.next();
                b2.put(next, c2.opt(next));
            }
        } catch (org.json.JSONException unused) {
        }
        return b2;
    }

    private static org.json.JSONObject b() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        android.content.Context f2 = com.anythink.core.common.b.o.a().f();
        try {
            jSONObject.put("platform", 1);
            jSONObject.put("os_vn", com.anythink.core.common.o.e.e());
            jSONObject.put("os_vc", com.anythink.core.common.o.e.d());
            jSONObject.put("package_name", com.anythink.core.common.o.e.l(f2));
            jSONObject.put("app_vn", com.anythink.core.common.o.e.j(f2));
            jSONObject.put("app_vc", com.anythink.core.common.o.e.i(f2));
            jSONObject.put("brand", com.anythink.core.common.o.e.b());
            jSONObject.put("model", com.anythink.core.common.o.e.a());
            jSONObject.put("screen", com.anythink.core.common.o.e.k(f2));
            jSONObject.put("network_type", java.lang.String.valueOf(com.anythink.core.common.o.e.n(f2)));
            jSONObject.put("mnc", com.anythink.core.common.o.e.c(f2));
            jSONObject.put("mcc", com.anythink.core.common.o.e.b(f2));
            jSONObject.put("language", com.anythink.core.common.o.e.f(f2));
            jSONObject.put("timezone", com.anythink.core.common.o.e.c());
            jSONObject.put("sdk_ver", com.anythink.core.common.o.h.a());
            jSONObject.put("gp_ver", com.anythink.core.common.o.e.o(f2));
            jSONObject.put("ua", com.anythink.core.common.o.e.i());
            jSONObject.put("orient", com.anythink.core.common.o.e.g(f2));
            jSONObject.put("system", 1);
            if (!android.text.TextUtils.isEmpty(com.anythink.core.common.b.o.a().m())) {
                jSONObject.put("channel", com.anythink.core.common.b.o.a().m());
            }
            if (!android.text.TextUtils.isEmpty(com.anythink.core.common.b.o.a().n())) {
                jSONObject.put("sub_channel", com.anythink.core.common.b.o.a().n());
            }
            jSONObject.put("upid", com.anythink.core.common.b.o.a().x());
            jSONObject.put("ps_id", com.anythink.core.common.b.o.a().q());
        } catch (java.lang.Exception unused) {
        }
        return jSONObject;
    }

    private static org.json.JSONObject c() {
        java.lang.String N;
        android.content.Context f2 = com.anythink.core.common.b.o.a().f();
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        com.anythink.core.d.a b2 = com.anythink.core.d.b.a(f2).b(com.anythink.core.common.b.o.a().o());
        if (b2 != null) {
            try {
                N = b2.N();
            } catch (java.lang.Exception unused) {
            }
        } else {
            N = "";
        }
        boolean z2 = true;
        if (!android.text.TextUtils.isEmpty(N)) {
            try {
                org.json.JSONObject jSONObject2 = new org.json.JSONObject(N);
                if (!jSONObject2.isNull("a")) {
                    if (jSONObject2.optInt("a") != 1) {
                        z2 = false;
                    }
                }
            } catch (java.lang.Exception unused2) {
            }
        }
        jSONObject.put("android_id", z2 ? com.anythink.core.common.o.e.d(f2) : "");
        jSONObject.put("gaid", com.anythink.core.common.o.e.f());
        com.anythink.core.api.IExHandler b3 = com.anythink.core.common.b.o.a().b();
        if (b3 != null) {
            b3.fillRequestData(jSONObject, b2);
            jSONObject.put("is_cn_sdk", "1");
        } else {
            jSONObject.put("is_cn_sdk", "0");
        }
        java.lang.String m2 = com.anythink.core.common.o.e.m(f2);
        jSONObject.put("it_src", android.text.TextUtils.isEmpty(m2) ? "" : m2);
        return jSONObject;
    }
}
