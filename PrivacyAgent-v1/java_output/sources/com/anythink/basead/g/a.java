package com.anythink.basead.g;

/* loaded from: classes12.dex */
public final class a extends com.anythink.core.common.h.a {
    java.lang.String a;
    java.lang.String b;
    java.lang.String c;
    int d;
    int e;
    java.lang.String f;
    java.lang.String g;

    public a(com.anythink.core.common.f.m mVar) {
        this.a = mVar.a;
        this.b = mVar.d;
        this.c = mVar.b;
        this.d = mVar.h;
        this.e = mVar.i;
        this.f = mVar.k;
        this.g = mVar.l;
    }

    @Override // com.anythink.core.common.h.a
    public final int a() {
        return 1;
    }

    @Override // com.anythink.core.common.h.a
    public final java.lang.Object a(java.lang.Object obj) {
        return obj;
    }

    @Override // com.anythink.core.common.h.a
    public final void a(int i, java.lang.Object obj) {
        if (obj == null) {
            a(i, com.anythink.core.common.h.i.l, "Return Empty Ad.", com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.noADError, "", ""));
            return;
        }
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(obj.toString());
            if (android.text.TextUtils.isEmpty(jSONObject.optString("data"))) {
                a(i, com.anythink.core.common.h.i.m, "Return Empty Ad.", com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.noADError, "", obj.toString()));
            } else {
                super.a(i, jSONObject);
            }
        } catch (java.lang.Throwable unused) {
            a(i, com.anythink.core.common.h.i.n, "Return Empty Ad.", com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.noADError, "", obj.toString()));
        }
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
        if (!android.text.TextUtils.isEmpty(this.g)) {
            return this.g;
        }
        com.anythink.core.common.h.a();
        return com.anythink.core.common.h.f();
    }

    @Override // com.anythink.core.common.h.a
    public final void b(com.anythink.core.api.AdError adError) {
    }

    @Override // com.anythink.core.common.h.a
    public final java.util.Map<java.lang.String, java.lang.String> c() {
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put("Content-Encoding", "gzip");
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
            e.put("app_id", com.anythink.core.common.b.o.a().o());
            e.put("pl_id", this.c);
            e.put("session_id", com.anythink.core.common.b.o.a().g(this.c));
            e.put("t_g_id", this.d);
            e.put("gro_id", this.e);
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
            if (com.anythink.core.common.b.o.a().b() != null) {
                e.put("deny", com.anythink.core.common.o.e.p(com.anythink.core.common.b.o.a().f()));
            }
            org.json.JSONObject a = com.anythink.core.common.h.c.a(this.c);
            if (a != null) {
                e.put("customs", a);
            }
        } catch (java.lang.Exception unused) {
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
    public final java.lang.String g() {
        java.util.HashMap hashMap = new java.util.HashMap();
        java.lang.String a = com.anythink.core.common.o.d.a(e().toString());
        java.lang.String a2 = com.anythink.core.common.o.d.a(f().toString());
        hashMap.put("p", a);
        hashMap.put(com.anythink.core.common.h.c.X, a2);
        hashMap.put("request_id", this.b);
        hashMap.put(com.anythink.core.common.c.k.a.c, this.a);
        return new org.json.JSONObject(hashMap).toString();
    }

    @Override // com.anythink.core.common.h.a
    public final java.lang.String h() {
        return null;
    }

    @Override // com.anythink.core.common.h.a
    public final android.content.Context i() {
        return null;
    }

    @Override // com.anythink.core.common.h.a
    public final java.lang.String j() {
        return null;
    }

    @Override // com.anythink.core.common.h.a
    public final java.util.Map<java.lang.String, java.lang.Object> k() {
        return null;
    }

    @Override // com.anythink.core.common.h.a
    public final int l() {
        return 34;
    }
}
