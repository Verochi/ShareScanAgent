package com.anythink.basead.g;

/* loaded from: classes12.dex */
public final class f extends com.anythink.core.common.h.a {
    java.lang.String a;
    org.json.JSONObject b;
    int c;
    java.lang.String d;
    com.anythink.core.common.f.ai e;
    java.util.Map<java.lang.String, java.lang.Object> f;

    public f(int i, com.anythink.core.common.f.ai aiVar, java.lang.String str, java.util.Map<java.lang.String, java.lang.Object> map) {
        this.c = i;
        this.e = aiVar;
        this.f = map;
        this.d = str;
    }

    @Override // com.anythink.core.common.h.a
    public final int a() {
        return 1;
    }

    @Override // com.anythink.core.common.h.a
    public final java.lang.Object a(java.lang.Object obj) {
        return null;
    }

    @Override // com.anythink.core.common.h.a
    public final void a(com.anythink.core.api.AdError adError) {
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
        org.json.JSONObject jSONObject3 = this.b;
        java.lang.String jSONObject4 = jSONObject3 != null ? jSONObject3.toString() : "";
        com.anythink.core.common.t.a().a(1, b(), jSONObject2, jSONObject4, com.anythink.core.common.f.u.a(1000));
        com.anythink.core.common.n.c.a("tk", adError.getPlatformCode(), adError.getPlatformMSG(), this.a, "", "1", "");
    }

    public final void a(java.lang.String str) {
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                return;
            }
            this.b.put("scenario", str);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.anythink.core.common.h.a
    public final boolean a(int i) {
        return false;
    }

    @Override // com.anythink.core.common.h.a
    public final java.lang.String b() {
        try {
            if (!android.text.TextUtils.isEmpty(this.d)) {
                this.b = new org.json.JSONObject(this.d);
                for (java.util.Map.Entry<java.lang.String, java.lang.Object> entry : this.f.entrySet()) {
                    this.b.put(entry.getKey(), entry.getValue());
                }
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        com.anythink.core.common.h.a();
        java.lang.String g = com.anythink.core.common.h.g();
        this.a = g;
        return g;
    }

    @Override // com.anythink.core.common.h.a
    public final void b(com.anythink.core.api.AdError adError) {
    }

    @Override // com.anythink.core.common.h.a
    public final java.util.Map<java.lang.String, java.lang.String> c() {
        com.anythink.core.common.f.n n;
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put("Content-Encoding", "gzip");
        hashMap.put("Content-Type", "application/json;charset=utf-8");
        com.anythink.core.common.f.ai aiVar = this.e;
        if (aiVar != null && (n = aiVar.n()) != null && com.anythink.basead.a.a.a(this.c, n)) {
            java.lang.String i = com.anythink.core.common.o.e.i();
            if (!android.text.TextUtils.isEmpty(i)) {
                hashMap.put("User-Agent", i);
            }
        }
        return hashMap;
    }

    @Override // com.anythink.core.common.h.a
    public final byte[] d() {
        return com.anythink.core.common.h.a.b(this.b.toString());
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
}
