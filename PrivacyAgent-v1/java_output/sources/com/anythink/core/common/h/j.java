package com.anythink.core.common.h;

/* loaded from: classes12.dex */
public final class j extends com.anythink.core.common.h.a {
    @Override // com.anythink.core.common.h.a
    public final int a() {
        return 2;
    }

    @Override // com.anythink.core.common.h.a
    public final java.lang.Object a(java.lang.Object obj) {
        try {
            return (org.json.JSONObject) obj;
        } catch (java.lang.Exception unused) {
            return null;
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
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        java.lang.String c = com.anythink.core.common.o.g.c(java.lang.String.valueOf(currentTimeMillis));
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        com.anythink.core.common.h.a();
        sb.append(com.anythink.core.common.h.d());
        sb.append("?t=");
        sb.append(currentTimeMillis);
        sb.append("&sign=");
        sb.append(c);
        return sb.toString();
    }

    @Override // com.anythink.core.common.h.a
    public final void b(com.anythink.core.api.AdError adError) {
    }

    @Override // com.anythink.core.common.h.a
    public final java.util.Map<java.lang.String, java.lang.String> c() {
        return null;
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
    public final boolean n() {
        return true;
    }
}
