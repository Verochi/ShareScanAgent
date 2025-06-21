package com.anythink.basead.g;

/* loaded from: classes12.dex */
public final class d extends com.anythink.core.common.h.a {
    java.lang.String a;
    java.lang.String b;
    java.lang.String c;
    int d;
    int e;
    int f;
    int g;
    java.lang.String[] h;
    int i;
    int j;
    java.lang.String k;
    java.lang.String l = "OnlineOfferLoader";

    public d(com.anythink.core.common.f.m mVar, int i, int i2, java.lang.String[] strArr, java.lang.String str) {
        this.a = mVar.d;
        this.b = mVar.b;
        this.c = mVar.c;
        this.i = mVar.e;
        this.f = i;
        this.g = i2;
        this.h = strArr;
        this.d = mVar.h;
        this.e = mVar.i;
        this.j = mVar.j;
        this.k = str;
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
                a(i, com.anythink.core.common.h.i.m, obj.toString(), com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.noADError, "", obj.toString()));
            } else {
                super.a(i, jSONObject);
            }
        } catch (java.lang.Throwable unused) {
            a(i, com.anythink.core.common.h.i.n, obj.toString(), com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.noADError, "", obj.toString()));
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
        com.anythink.core.common.h.a();
        return com.anythink.core.common.h.h();
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
            e.put("pl_id", this.b);
            e.put("session_id", com.anythink.core.common.b.o.a().g(this.b));
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
            e.put(com.anythink.core.common.h.c.ap, com.anythink.core.common.l.a().c());
            org.json.JSONObject a = com.anythink.core.common.h.c.a(this.b);
            if (a != null) {
                e.put("customs", a);
            }
            com.anythink.core.common.h.c.a(e);
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
        hashMap.put("request_id", this.a);
        hashMap.put("ad_source_id", java.lang.Integer.valueOf(java.lang.Integer.parseInt(this.c)));
        hashMap.put(com.anythink.expressad.a.g, java.lang.Integer.valueOf(this.i));
        java.lang.String[] strArr = this.h;
        char c = 0;
        if (strArr != null && strArr.length > 0) {
            org.json.JSONArray jSONArray = new org.json.JSONArray();
            for (java.lang.String str : this.h) {
                jSONArray.put(str);
            }
            hashMap.put("exclude_offers", jSONArray);
        }
        if (com.anythink.core.common.b.o.a().k() != null) {
            hashMap.put(com.anythink.core.b.a.a.c, com.anythink.core.common.o.d.a(com.anythink.core.common.b.o.a().k().toString()));
        }
        int i = this.f;
        if (i > 0 && this.g > 0) {
            hashMap.put(com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.AD_WIDTH, java.lang.Integer.valueOf(i));
            hashMap.put(com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.AD_HEIGHT, java.lang.Integer.valueOf(this.g));
        }
        org.json.JSONObject jSONObject = new org.json.JSONObject(hashMap);
        try {
            java.lang.String valueOf = java.lang.String.valueOf(this.j);
            switch (valueOf.hashCode()) {
                case 49:
                    if (valueOf.equals("1")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 50:
                    if (valueOf.equals("2")) {
                        break;
                    }
                    c = 65535;
                    break;
                case 51:
                    if (valueOf.equals("3")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 52:
                    if (valueOf.equals("4")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            if (c == 0 || c == 1 || c == 2 || c == 3) {
                jSONObject.put(com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.ADP_ACCEPT_TYPE, new org.json.JSONArray(com.anythink.core.api.ATAdConst.AD_SUPPORT_TYPE_ARRAY));
            }
        } catch (java.lang.Throwable unused) {
        }
        return jSONObject.toString();
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
        return 2;
    }
}
