package com.anythink.core.common.h;

/* loaded from: classes12.dex */
public final class m extends com.anythink.core.common.h.a {
    com.anythink.core.common.f.ad a;

    public m(com.anythink.core.common.f.ad adVar) {
        this.a = adVar;
    }

    @Override // com.anythink.core.common.h.a
    public final int a() {
        return this.a.b;
    }

    @Override // com.anythink.core.common.h.a
    public final java.lang.Object a(java.lang.Object obj) {
        return null;
    }

    @Override // com.anythink.core.common.h.a
    public final void a(com.anythink.core.api.AdError adError) {
    }

    @Override // com.anythink.core.common.h.a
    public final boolean a(int i) {
        return i >= 200 && i < 300;
    }

    @Override // com.anythink.core.common.h.a
    public final java.lang.String b() {
        return this.a.d;
    }

    @Override // com.anythink.core.common.h.a
    public final void b(com.anythink.core.api.AdError adError) {
    }

    @Override // com.anythink.core.common.h.a
    public final java.util.Map<java.lang.String, java.lang.String> c() {
        java.lang.String str = this.a.c;
        java.util.HashMap hashMap = new java.util.HashMap();
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            java.util.Iterator<java.lang.String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                java.lang.String next = keys.next();
                hashMap.put(next, jSONObject.optString(next));
            }
        } catch (java.lang.Exception unused) {
        }
        return hashMap;
    }

    @Override // com.anythink.core.common.h.a
    public final byte[] d() {
        return new byte[0];
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
    public final boolean o() {
        return true;
    }
}
