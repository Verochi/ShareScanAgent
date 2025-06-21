package com.anythink.core.common.h;

/* loaded from: classes12.dex */
public class d extends com.anythink.core.common.h.a {
    public static final java.lang.String a = "custom";
    private static final java.lang.String f = "d";
    long b;
    long c;
    java.util.Map<java.lang.String, java.lang.Object> d = com.anythink.core.common.b.o.a().l();
    java.util.Map<java.lang.String, java.lang.String> e;
    private java.lang.String g;
    private java.lang.String h;
    private android.content.Context i;

    public d(android.content.Context context, java.lang.String str, java.lang.String str2, java.util.Map<java.lang.String, java.lang.String> map) {
        this.g = str;
        this.h = str2;
        this.i = context;
        this.e = map;
    }

    @Override // com.anythink.core.common.h.a
    public final int a() {
        return 1;
    }

    @Override // com.anythink.core.common.h.a
    public final java.lang.Object a(java.lang.Object obj) {
        try {
            org.json.JSONObject jSONObject = (org.json.JSONObject) obj;
            if (this.d != null) {
                jSONObject.put("custom", new org.json.JSONObject(this.d));
            }
        } catch (java.lang.Exception unused) {
        }
        com.anythink.core.common.n.c.a("app", (java.lang.String) null, this.b, java.lang.System.currentTimeMillis(), android.os.SystemClock.elapsedRealtime() - this.c);
        return obj;
    }

    @Override // com.anythink.core.common.h.a
    public final void a(int i, com.anythink.core.common.h.k kVar) {
        this.b = java.lang.System.currentTimeMillis();
        this.c = android.os.SystemClock.elapsedRealtime();
        super.a(i, kVar);
    }

    @Override // com.anythink.core.common.h.a
    public final void a(com.anythink.core.api.AdError adError) {
    }

    @Override // com.anythink.core.common.h.a
    public final boolean a(int i) {
        return false;
    }

    @Override // com.anythink.core.common.h.a
    public final java.lang.String b() {
        com.anythink.core.common.h.a();
        return com.anythink.core.common.h.b();
    }

    @Override // com.anythink.core.common.h.a
    public final void b(com.anythink.core.api.AdError adError) {
        com.anythink.core.common.n.c.a("app", adError.getPlatformCode(), adError.getPlatformMSG(), b(), "", "", "");
    }

    @Override // com.anythink.core.common.h.a
    public final java.util.Map<java.lang.String, java.lang.String> c() {
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put(com.google.common.net.HttpHeaders.ACCEPT_ENCODING, "gzip");
        hashMap.put("Content-Type", "application/json;charset=utf-8");
        return hashMap;
    }

    @Override // com.anythink.core.common.h.a
    public final byte[] d() {
        try {
            return g().getBytes("utf-8");
        } catch (java.lang.Exception unused) {
            return g().getBytes();
        }
    }

    @Override // com.anythink.core.common.h.a
    public final org.json.JSONObject e() {
        org.json.JSONObject e = super.e();
        try {
            e.put("app_id", this.g);
            e.put("nw_ver", com.anythink.core.common.o.e.h());
            java.lang.String y = com.anythink.core.common.b.o.a().y();
            if (!android.text.TextUtils.isEmpty(y)) {
                e.put("sy_id", y);
            }
            java.lang.String z = com.anythink.core.common.b.o.a().z();
            if (android.text.TextUtils.isEmpty(z)) {
                com.anythink.core.common.b.o.a().k(com.anythink.core.common.b.o.a().x());
                e.put("bk_id", com.anythink.core.common.b.o.a().x());
            } else {
                e.put("bk_id", z);
            }
            org.json.JSONObject a2 = com.anythink.core.common.h.c.a();
            if (a2 != null) {
                e.put("custom", a2);
            }
            if (com.anythink.core.common.b.o.a().b() != null) {
                e.put("deny", com.anythink.core.common.o.e.p(com.anythink.core.common.b.o.a().f()));
            }
            e.put(com.anythink.core.common.h.c.R, com.anythink.core.common.b.o.a().H() ? 1 : 2);
            if (com.anythink.core.common.b.o.a().v()) {
                e.put("is_test", 1);
            }
            e.put(com.anythink.core.common.h.c.ap, com.anythink.core.common.l.a().c());
            com.anythink.core.common.l.a();
            e.put("pil_offset", com.anythink.core.common.l.b());
            java.util.Map<java.lang.String, java.lang.String> map = this.e;
            if (map != null) {
                if (map.size() != 0) {
                    e.put("cached", new org.json.JSONObject(this.e));
                }
            }
        } catch (java.lang.Throwable unused) {
        }
        return e;
    }

    @Override // com.anythink.core.common.h.a
    public final org.json.JSONObject f() {
        org.json.JSONObject f2 = super.f();
        try {
            if (com.anythink.core.common.b.o.a().b() != null) {
                f2.put("btts", com.anythink.core.common.o.e.g());
            }
        } catch (org.json.JSONException unused) {
        }
        return f2;
    }

    @Override // com.anythink.core.common.h.a
    public final java.lang.String h() {
        return this.g;
    }

    @Override // com.anythink.core.common.h.a
    public final android.content.Context i() {
        return this.i;
    }

    @Override // com.anythink.core.common.h.a
    public final java.lang.String j() {
        return this.h;
    }

    @Override // com.anythink.core.common.h.a
    public final java.util.Map<java.lang.String, java.lang.Object> k() {
        return null;
    }

    @Override // com.anythink.core.common.h.a
    public int l() {
        return 59;
    }

    @Override // com.anythink.core.common.h.a
    public final boolean n() {
        return true;
    }
}
