package com.anythink.basead.g;

/* loaded from: classes12.dex */
public class e extends com.anythink.core.common.h.a {
    private static java.lang.String f = "e";
    int a;
    java.lang.String b;
    com.anythink.core.common.f.ai c;
    java.util.Map<java.lang.String, java.lang.Object> d;
    boolean e = false;

    public e(int i, java.lang.String str, com.anythink.core.common.f.ai aiVar, java.util.Map<java.lang.String, java.lang.Object> map) {
        this.a = i;
        this.b = str;
        this.c = aiVar;
        this.d = map;
    }

    private void p() {
        java.lang.String jSONObject;
        try {
            jSONObject = new org.json.JSONObject(c()).toString();
        } catch (java.lang.Throwable unused) {
            jSONObject = new org.json.JSONObject().toString();
        }
        com.anythink.core.common.s.a().a(this.o, jSONObject, this.c.V());
    }

    @Override // com.anythink.core.common.h.a
    public final int a() {
        return 2;
    }

    @Override // com.anythink.core.common.h.a
    public final java.lang.Object a(java.lang.Object obj) {
        return null;
    }

    @Override // com.anythink.core.common.h.a
    public final void a(com.anythink.core.api.AdError adError) {
    }

    public final void a(boolean z) {
        this.e = z;
    }

    @Override // com.anythink.core.common.h.a
    public final boolean a(int i) {
        return false;
    }

    @Override // com.anythink.core.common.h.a
    public final java.lang.String b() {
        if (this.d != null && !android.text.TextUtils.isEmpty(this.b)) {
            try {
                for (java.util.Map.Entry<java.lang.String, java.lang.Object> entry : this.d.entrySet()) {
                    java.lang.String key = entry.getKey();
                    this.b = this.b.replaceAll("\\{" + key + "\\}", (java.lang.String) entry.getValue());
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
        return this.b;
    }

    @Override // com.anythink.core.common.h.a
    public final void b(int i) {
        java.lang.String jSONObject;
        if (this.e) {
            com.anythink.core.common.s.a();
            if (com.anythink.core.common.s.a(i)) {
                try {
                    jSONObject = new org.json.JSONObject(c()).toString();
                } catch (java.lang.Throwable unused) {
                    jSONObject = new org.json.JSONObject().toString();
                }
                com.anythink.core.common.s.a().a(this.o, jSONObject, this.c.V());
            }
        }
    }

    @Override // com.anythink.core.common.h.a
    public final void b(com.anythink.core.api.AdError adError) {
    }

    @Override // com.anythink.core.common.h.a
    public final java.util.Map<java.lang.String, java.lang.String> c() {
        if (this.c == null) {
            return null;
        }
        java.util.HashMap hashMap = new java.util.HashMap();
        com.anythink.core.common.f.n n = this.c.n();
        if (n != null && com.anythink.basead.a.a.a(this.a, n)) {
            java.lang.String i = com.anythink.core.common.o.e.i();
            if (!android.text.TextUtils.isEmpty(i)) {
                hashMap.put("User-Agent", i);
            }
        }
        return hashMap;
    }

    @Override // com.anythink.core.common.h.a
    public final byte[] d() {
        return new byte[0];
    }

    @Override // com.anythink.core.common.h.a
    public final java.lang.String g() {
        return "";
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
