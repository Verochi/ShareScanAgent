package com.google.android.gms.common.util.concurrent;

/* loaded from: classes22.dex */
final class zza implements java.lang.Runnable {
    public final java.lang.Runnable n;
    public final int t = 0;

    public zza(java.lang.Runnable runnable, int i) {
        this.n = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        android.os.Process.setThreadPriority(this.t);
        this.n.run();
    }
}
