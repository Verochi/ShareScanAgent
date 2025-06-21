package com.sijla.h.a;

/* loaded from: classes19.dex */
final class f implements java.lang.Runnable {
    private /* synthetic */ java.lang.String a;
    private /* synthetic */ java.lang.String b;
    private /* synthetic */ boolean c;

    public f(java.lang.String str, java.lang.String str2, boolean z) {
        this.a = str;
        this.b = str2;
        this.c = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.sijla.h.a.e.b(this.a, this.b, this.c);
    }
}
