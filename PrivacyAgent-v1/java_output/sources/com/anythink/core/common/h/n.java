package com.anythink.core.common.h;

/* loaded from: classes12.dex */
public final class n extends com.anythink.core.common.h.a {
    com.anythink.core.common.f.u a;
    boolean b = true;

    public n(com.anythink.core.common.f.u uVar) {
        this.a = uVar;
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
        return false;
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

    /* JADX WARN: Removed duplicated region for block: B:16:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x003f  */
    @Override // com.anythink.core.common.h.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final byte[] d() {
        org.json.JSONObject jSONObject;
        java.lang.String str = this.a.c;
        boolean z = str != null && str.contains("gzip");
        org.json.JSONObject jSONObject2 = null;
        try {
            jSONObject = new org.json.JSONObject(this.a.e);
        } catch (java.lang.Exception e) {
            e = e;
        }
        try {
            if (this.b) {
                jSONObject.put(com.anythink.core.common.h.c.U, 1);
            }
        } catch (java.lang.Exception e2) {
            e = e2;
            jSONObject2 = jSONObject;
            e.printStackTrace();
            jSONObject = jSONObject2;
            if (!z) {
            }
        }
        return !z ? jSONObject != null ? com.anythink.core.common.h.a.b(jSONObject.toString()) : new byte[0] : jSONObject != null ? jSONObject.toString().getBytes() : new byte[0];
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

    public final void p() {
        this.b = false;
    }

    public final com.anythink.core.common.f.u q() {
        return this.a;
    }
}
