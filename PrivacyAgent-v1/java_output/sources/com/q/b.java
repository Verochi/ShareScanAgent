package com.q;

/* loaded from: classes19.dex */
final class b implements java.lang.Runnable {
    public /* synthetic */ android.content.Context n;
    public /* synthetic */ java.lang.String t;

    public b(android.content.Context context, java.lang.String str) {
        this.n = context;
        this.t = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.n == null || com.sijla.h.c.a(this.t) || !com.sijla.h.c.a(this.n, "oaid2k", 259200L)) {
                return;
            }
            com.sijla.g.a.a(this.n, this.t, 2);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }
}
