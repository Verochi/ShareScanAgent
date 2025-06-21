package com.anythink.core.common.f;

/* loaded from: classes12.dex */
public final class am {
    private java.util.Map<java.lang.String, java.lang.Object> b;
    private com.anythink.core.common.f.e c;
    private java.util.Map<java.lang.String, java.lang.String> d;
    private boolean f;
    private java.util.Map<java.lang.String, java.lang.String> h;
    private java.lang.String g = "";
    final java.lang.Object a = new java.lang.Object();
    private java.util.Map<java.lang.String, com.anythink.core.common.f> e = new java.util.concurrent.ConcurrentHashMap(1);

    public final com.anythink.core.common.f a(java.lang.String str) {
        return this.e.get(str);
    }

    public final java.lang.Object a() {
        return this.a;
    }

    public final void a(com.anythink.core.api.ATAdInfo aTAdInfo) {
        if (aTAdInfo != null) {
            this.c = new com.anythink.core.common.f.e(aTAdInfo.getAdsourceId(), aTAdInfo.getShowId(), aTAdInfo.getNetworkFirmId());
        } else {
            this.c = null;
        }
    }

    public final void a(java.lang.String str, com.anythink.core.common.f fVar) {
        this.e.put(str, fVar);
    }

    public final void a(java.lang.String str, java.lang.Object obj) {
        if (this.b == null) {
            this.b = new java.util.concurrent.ConcurrentHashMap(2);
        }
        this.b.put(str, obj);
    }

    public final void a(java.lang.String str, java.lang.String str2) {
        synchronized (this) {
            if (this.d == null) {
                this.d = new java.util.concurrent.ConcurrentHashMap(2);
            }
        }
        this.d.put(str, str2);
    }

    public final void a(java.util.Map<java.lang.String, java.lang.Object> map) {
        this.b = map;
    }

    public final void a(boolean z) {
        this.f = z;
    }

    public final void a(java.lang.Object[] objArr) {
        this.g = com.anythink.core.common.o.i.a(objArr);
    }

    public final java.lang.String b(java.lang.String str) {
        java.util.Map<java.lang.String, java.lang.String> map = this.d;
        return map == null ? "" : map.remove(str);
    }

    public final java.util.Map<java.lang.String, java.lang.Object> b() {
        return this.b;
    }

    public final void b(java.lang.String str, java.lang.String str2) {
        if (this.h == null) {
            this.h = new java.util.concurrent.ConcurrentHashMap(2);
        }
        this.h.put(str, str2);
    }

    public final com.anythink.core.common.f.e c() {
        return this.c;
    }

    public final java.lang.String c(java.lang.String str) {
        java.util.Map<java.lang.String, java.lang.String> map = this.h;
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    public final boolean d() {
        return this.f;
    }

    public final java.lang.String e() {
        return this.g;
    }
}
