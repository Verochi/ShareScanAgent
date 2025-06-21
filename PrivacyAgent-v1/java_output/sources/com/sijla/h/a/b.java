package com.sijla.h.a;

/* loaded from: classes19.dex */
final class b implements java.lang.Runnable {
    private /* synthetic */ android.content.Context a;

    public b(android.content.Context context) {
        this.a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            com.sijla.h.a.a.a(this.a, "wsidcache", com.sijla.h.a.a.f(this.a) ? "WiFi" : com.sijla.h.a.a.o(this.a));
        } catch (java.lang.Exception unused) {
        }
    }
}
