package com.anythink.core.common.h;

/* loaded from: classes12.dex */
public final class b extends com.anythink.core.common.h.a {
    android.content.Context a;
    int b;
    java.util.List<java.lang.String> e;
    int f;
    boolean g = false;
    java.lang.String c = com.anythink.core.common.b.o.a().o();
    java.lang.String d = com.anythink.core.common.b.o.a().p();

    public b(android.content.Context context, int i, java.util.List<java.lang.String> list) {
        this.a = context;
        this.e = list;
        this.b = list.size();
        this.f = i;
    }

    private static java.lang.String a(java.lang.String str) {
        try {
            return java.net.URLEncoder.encode(str, "utf-8");
        } catch (java.io.UnsupportedEncodingException unused) {
            return null;
        }
    }

    @Override // com.anythink.core.common.h.a
    public final int a() {
        return 1;
    }

    @Override // com.anythink.core.common.h.a
    public final java.lang.Object a(java.lang.Object obj) {
        return java.lang.Integer.valueOf(this.b);
    }

    @Override // com.anythink.core.common.h.a
    public final void a(int i, com.anythink.core.common.h.k kVar) {
        if (!android.text.TextUtils.isEmpty(b())) {
            super.a(i, kVar);
        } else if (kVar != null) {
            kVar.onLoadFinish(i, java.lang.Integer.valueOf(this.b));
        }
    }

    @Override // com.anythink.core.common.h.a
    public final void a(com.anythink.core.api.AdError adError) {
        if (this.g) {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            java.util.Map<java.lang.String, java.lang.String> c = c();
            if (c != null) {
                try {
                    for (java.lang.String str : c.keySet()) {
                        jSONObject.put(str, c.get(str));
                    }
                } catch (java.lang.Exception unused) {
                }
            }
            java.lang.String jSONObject2 = jSONObject.toString();
            java.lang.String g = g();
            com.anythink.core.common.t.a().a(1, b(), jSONObject2, g, com.anythink.core.common.f.u.a(1001));
        }
    }

    @Override // com.anythink.core.common.h.a
    public final boolean a(int i) {
        return false;
    }

    @Override // com.anythink.core.common.h.a
    public final java.lang.String b() {
        com.anythink.core.common.h.a();
        return com.anythink.core.common.h.k();
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
        return com.anythink.core.common.h.a.b(g());
    }

    @Override // com.anythink.core.common.h.a
    public final org.json.JSONObject e() {
        org.json.JSONObject e = super.e();
        if (e != null) {
            try {
                e.put("app_id", this.c);
                e.put("nw_ver", com.anythink.core.common.o.e.h());
                java.util.Map<java.lang.String, java.lang.Object> l = com.anythink.core.common.b.o.a().l();
                if (l != null) {
                    try {
                        if (l.size() > 0) {
                            org.json.JSONObject jSONObject = new org.json.JSONObject();
                            for (java.lang.String str : l.keySet()) {
                                java.lang.Object obj = l.get(str);
                                if (obj != null) {
                                    jSONObject.put(str, obj.toString());
                                }
                            }
                            e.put("custom", jSONObject);
                        }
                    } catch (java.lang.Throwable unused) {
                    }
                }
                org.json.JSONArray jSONArray = new org.json.JSONArray();
                java.util.List<java.lang.String> list = this.e;
                if (list != null && list.size() > 0) {
                    for (java.lang.String str2 : this.e) {
                        if (!android.text.TextUtils.isEmpty(str2)) {
                            jSONArray.put(new org.json.JSONObject(str2));
                        }
                    }
                }
                e.put("data", jSONArray);
            } catch (java.lang.Exception unused2) {
            }
        }
        return e;
    }

    @Override // com.anythink.core.common.h.a
    public final org.json.JSONObject f() {
        org.json.JSONObject f = super.f();
        if (f != null) {
            try {
                f.put(com.anythink.core.common.h.c.T, this.f);
            } catch (java.lang.Exception unused) {
            }
        }
        return f;
    }

    @Override // com.anythink.core.common.h.a
    public final java.lang.String h() {
        return this.c;
    }

    @Override // com.anythink.core.common.h.a
    public final android.content.Context i() {
        return this.a;
    }

    @Override // com.anythink.core.common.h.a
    public final java.lang.String j() {
        return this.d;
    }

    @Override // com.anythink.core.common.h.a
    public final java.util.Map<java.lang.String, java.lang.Object> k() {
        return null;
    }

    @Override // com.anythink.core.common.h.a
    public final int l() {
        return 4;
    }

    @Override // com.anythink.core.common.h.a
    public final boolean o() {
        return true;
    }

    public final void p() {
        this.g = true;
    }
}
