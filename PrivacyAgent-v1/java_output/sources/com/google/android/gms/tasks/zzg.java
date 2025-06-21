package com.google.android.gms.tasks;

/* loaded from: classes22.dex */
final class zzg implements java.lang.Runnable {
    public final /* synthetic */ com.google.android.gms.tasks.zzh n;

    public zzg(com.google.android.gms.tasks.zzh zzhVar) {
        this.n = zzhVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        java.lang.Object obj;
        com.google.android.gms.tasks.OnCanceledListener onCanceledListener;
        com.google.android.gms.tasks.OnCanceledListener onCanceledListener2;
        obj = this.n.b;
        synchronized (obj) {
            onCanceledListener = this.n.c;
            if (onCanceledListener != null) {
                onCanceledListener2 = this.n.c;
                onCanceledListener2.onCanceled();
            }
        }
    }
}
