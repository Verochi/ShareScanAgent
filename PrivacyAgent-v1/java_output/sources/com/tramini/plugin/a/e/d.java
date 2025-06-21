package com.tramini.plugin.a.e;

/* loaded from: classes19.dex */
public final class d extends com.tramini.plugin.a.e.a {
    @Override // com.tramini.plugin.a.e.a
    public final int a() {
        return 1;
    }

    @Override // com.tramini.plugin.a.e.a
    public final java.lang.Object a(java.lang.String str) {
        return str.trim();
    }

    @Override // com.tramini.plugin.a.e.a
    public final java.lang.String b() {
        com.tramini.plugin.a.a.a();
        return com.tramini.plugin.a.a.b();
    }

    @Override // com.tramini.plugin.a.e.a
    public final java.util.Map<java.lang.String, java.lang.String> c() {
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put("Content-Type", "application/json;charset=utf-8");
        return hashMap;
    }

    @Override // com.tramini.plugin.a.e.a
    public final byte[] d() {
        try {
            return f().getBytes("utf-8");
        } catch (java.lang.Exception unused) {
            return f().getBytes();
        }
    }

    @Override // com.tramini.plugin.a.e.a
    public final org.json.JSONObject e() {
        java.lang.String str = "1";
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        android.content.Context b = com.tramini.plugin.a.b.c.a().b();
        try {
            jSONObject.put("platform", "1");
            jSONObject.put("os_vn", com.tramini.plugin.a.h.e.b());
            jSONObject.put("os_vc", com.tramini.plugin.a.h.e.a());
            jSONObject.put("package_name", com.tramini.plugin.a.h.e.c(b));
            jSONObject.put("app_vn", com.tramini.plugin.a.h.e.b(b));
            jSONObject.put("app_vc", com.tramini.plugin.a.h.e.a(b));
            jSONObject.put("sdk_ver", com.tramini.plugin.a.b.a.a);
            jSONObject.put("android_id", "");
            if (!com.tramini.plugin.a.h.h.a(b)) {
                str = "0";
            }
            jSONObject.put(com.tramini.plugin.a.e.a.i, str);
            com.tramini.plugin.b.b b2 = com.tramini.plugin.b.c.a(b).b();
            if (b2 != null && b2.a() != null) {
                if (b2.a().size() != 0) {
                    jSONObject.put("cached", new org.json.JSONObject(b2.a()));
                }
            }
        } catch (java.lang.Throwable unused) {
        }
        return jSONObject;
    }

    @Override // com.tramini.plugin.a.e.a
    public final boolean g() {
        return true;
    }
}
