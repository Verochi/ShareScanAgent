package com.anythink.core.common.h;

/* loaded from: classes12.dex */
public class l extends com.anythink.core.common.h.a {
    public static final java.lang.String a = "sdk_custom";
    private static final java.lang.String d = "l";
    long b;
    long c;
    private java.lang.String e;
    private java.lang.String f;
    private java.lang.String g;
    private android.content.Context h;
    private java.lang.String i;
    private java.lang.String j;
    private java.lang.String k;
    private java.util.Map<java.lang.String, java.lang.Object> l;
    private java.util.Map<java.lang.String, java.lang.Object> p;
    private java.util.Map<java.lang.String, java.lang.String> q;
    private int r;

    public l(android.content.Context context, com.anythink.core.common.f.al alVar) {
        if (alVar != null) {
            this.i = alVar.a();
            this.j = alVar.b();
            this.h = context;
            this.g = alVar.c();
            this.e = com.anythink.core.common.b.o.a().q();
            this.f = com.anythink.core.common.b.o.a().g(this.g);
            this.k = alVar.d();
            this.l = alVar.e();
            this.p = alVar.f();
            this.r = alVar.g();
            this.q = alVar.h();
        }
    }

    private void a(org.json.JSONObject jSONObject) {
        org.json.JSONObject a2 = com.anythink.core.c.b.a().a(this.g);
        if (a2 != null) {
            jSONObject.put(com.anythink.core.common.h.c.av, a2);
        }
    }

    @Override // com.anythink.core.common.h.a
    public final int a() {
        return 1;
    }

    @Override // com.anythink.core.common.h.a
    public final java.lang.Object a(java.lang.Object obj) {
        try {
            org.json.JSONObject jSONObject = (org.json.JSONObject) obj;
            if (this.l != null) {
                jSONObject.put(a, new org.json.JSONObject(this.l));
            }
            com.anythink.core.common.n.c.a("placement", this.g, this.b, java.lang.System.currentTimeMillis(), android.os.SystemClock.elapsedRealtime() - this.c);
            return jSONObject;
        } catch (java.lang.Exception unused) {
            return null;
        }
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
        return com.anythink.core.common.h.c();
    }

    @Override // com.anythink.core.common.h.a
    public final void b(com.anythink.core.api.AdError adError) {
        com.anythink.core.common.n.c.a("placement", adError.getPlatformCode(), adError.getPlatformMSG(), b(), this.g, "", "");
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
        java.lang.Object obj;
        org.json.JSONObject e = super.e();
        try {
            e.put("app_id", this.i);
            e.put("pl_id", this.g);
            e.put("session_id", this.f);
            e.put("nw_ver", com.anythink.core.common.o.e.h());
            e.put("exclude_myofferid", com.anythink.core.common.r.a().a(this.h));
            if (com.anythink.core.common.b.o.a().k() != null) {
                e.put(com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.EXCLUDE_OFFER, com.anythink.core.common.b.o.a().k());
            }
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
            org.json.JSONObject a2 = com.anythink.core.common.h.c.a(this.l);
            if (a2 != null) {
                e.put("custom", a2);
            }
            if (com.anythink.core.common.b.o.a().b() != null) {
                e.put("deny", com.anythink.core.common.o.e.p(com.anythink.core.common.b.o.a().f()));
            }
            if (com.anythink.core.common.b.o.a().v()) {
                com.anythink.core.common.b.o.a().w().fillRequestParam(e);
            }
            e.put(com.anythink.core.common.h.c.ap, com.anythink.core.common.l.a().c());
            java.util.Map<java.lang.String, java.lang.Object> map = this.p;
            if (map != null && (obj = map.get(com.anythink.core.api.ATAdConst.KEY.CP_PLACEMENT_ID)) != null) {
                e.put(com.anythink.core.common.h.c.am, obj.toString());
            }
            java.util.Map<java.lang.String, java.lang.String> map2 = this.q;
            if (map2 != null && map2.size() != 0) {
                try {
                    e.put("cached", new org.json.JSONObject(this.q));
                } catch (java.lang.Throwable unused) {
                }
            }
            if (this.r == 1) {
                e.put(com.anythink.core.common.h.c.au, 1);
            } else {
                e.put(com.anythink.core.common.h.c.au, 2);
            }
            org.json.JSONObject a3 = com.anythink.core.c.b.a().a(this.g);
            if (a3 != null) {
                e.put(com.anythink.core.common.h.c.av, a3);
            }
            if (com.anythink.core.common.w.a().c(this.g)) {
                e.put(com.anythink.core.common.h.c.aw, 2);
            } else {
                e.put(com.anythink.core.common.h.c.aw, 1);
            }
        } catch (org.json.JSONException unused2) {
        }
        return e;
    }

    @Override // com.anythink.core.common.h.a
    public final org.json.JSONObject f() {
        org.json.JSONObject f = super.f();
        try {
            if (com.anythink.core.common.b.o.a().b() != null) {
                f.put("btts", com.anythink.core.common.o.e.g());
            }
        } catch (org.json.JSONException unused) {
        }
        return f;
    }

    @Override // com.anythink.core.common.h.a
    public final java.lang.String h() {
        return this.i;
    }

    @Override // com.anythink.core.common.h.a
    public final android.content.Context i() {
        return this.h;
    }

    @Override // com.anythink.core.common.h.a
    public final java.lang.String j() {
        return this.j;
    }

    @Override // com.anythink.core.common.h.a
    public final java.util.Map<java.lang.String, java.lang.Object> k() {
        return null;
    }

    @Override // com.anythink.core.common.h.a
    public final int l() {
        return 63;
    }

    @Override // com.anythink.core.common.h.a
    public final boolean n() {
        return true;
    }
}
