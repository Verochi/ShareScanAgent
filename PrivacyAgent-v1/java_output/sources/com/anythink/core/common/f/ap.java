package com.anythink.core.common.f;

/* loaded from: classes12.dex */
public final class ap {
    private java.lang.String a;
    private boolean b;
    private java.lang.Boolean c;

    public ap(java.lang.String str, boolean z) {
        this.a = str;
        this.b = z;
    }

    public final synchronized java.lang.String a() {
        return this.a;
    }

    public final synchronized void a(boolean z) {
        this.c = java.lang.Boolean.valueOf(z);
    }

    public final synchronized boolean b() {
        return this.b;
    }

    public final synchronized java.lang.Boolean c() {
        return this.c;
    }
}
