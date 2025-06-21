package com.anythink.basead.g;

/* loaded from: classes12.dex */
public final class c extends com.anythink.core.common.h.a {
    java.lang.String a;
    boolean b;

    public c(java.lang.String str, java.lang.String str2, boolean z) {
        this.b = z;
        this.a = str.replaceAll("\\{req_id\\}", str2 == null ? "" : str2);
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

    @Override // com.anythink.core.common.h.a
    public final boolean a(int i) {
        return false;
    }

    @Override // com.anythink.core.common.h.a
    public final java.lang.String b() {
        return this.a;
    }

    @Override // com.anythink.core.common.h.a
    public final void b(com.anythink.core.api.AdError adError) {
    }

    @Override // com.anythink.core.common.h.a
    public final java.util.Map<java.lang.String, java.lang.String> c() {
        if (!this.b) {
            return null;
        }
        java.util.HashMap hashMap = new java.util.HashMap();
        java.lang.String i = com.anythink.core.common.o.e.i();
        if (!android.text.TextUtils.isEmpty(i)) {
            hashMap.put("User-Agent", i);
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
