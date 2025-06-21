package com.google.android.gms.tasks;

/* loaded from: classes22.dex */
final class zzy implements java.lang.Runnable {
    public final /* synthetic */ com.google.android.gms.tasks.zzu n;
    public final /* synthetic */ java.util.concurrent.Callable t;

    public zzy(com.google.android.gms.tasks.zzu zzuVar, java.util.concurrent.Callable callable) {
        this.n = zzuVar;
        this.t = callable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.n.b(this.t.call());
        } catch (java.lang.Exception e) {
            this.n.a(e);
        } catch (java.lang.Throwable th) {
            this.n.a(new java.lang.RuntimeException(th));
        }
    }
}
