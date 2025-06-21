package com.anythink.core.common.f;

/* loaded from: classes12.dex */
public final class v {
    public java.lang.String a;
    public com.anythink.core.api.ATMediationRequestInfo b;
    public java.lang.String c;
    public int d;
    public com.anythink.core.common.b.c e;
    public com.anythink.core.common.n f;
    public java.util.Map<java.lang.String, java.lang.Object> g;
    public int h;
    public com.anythink.core.common.f.c i;
    public boolean j = false;
    public long k = android.os.SystemClock.elapsedRealtime();
    private android.content.Context l;
    private java.lang.ref.WeakReference<android.app.Activity> m;

    private int c() {
        return this.d;
    }

    public final android.content.Context a() {
        android.app.Activity activity;
        java.lang.ref.WeakReference<android.app.Activity> weakReference = this.m;
        if (weakReference != null && (activity = weakReference.get()) != null) {
            return activity;
        }
        android.app.Activity F = com.anythink.core.common.b.o.a().F();
        return F != null ? F : this.l;
    }

    public final void a(android.content.Context context) {
        this.l = com.anythink.core.common.b.o.a().f();
        if (context == null || !(context instanceof android.app.Activity)) {
            return;
        }
        this.m = new java.lang.ref.WeakReference<>((android.app.Activity) context);
    }

    public final com.anythink.core.common.f.v b() {
        com.anythink.core.common.f.v vVar = new com.anythink.core.common.f.v();
        vVar.b = this.b;
        vVar.c = this.c;
        vVar.l = this.l;
        vVar.m = this.m;
        vVar.d = this.d;
        vVar.e = this.e;
        vVar.f = this.f;
        vVar.g = this.g;
        vVar.h = this.h;
        return vVar;
    }
}
