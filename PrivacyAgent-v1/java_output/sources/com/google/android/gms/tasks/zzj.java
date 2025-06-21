package com.google.android.gms.tasks;

/* loaded from: classes22.dex */
final class zzj implements java.lang.Runnable {
    public final /* synthetic */ com.google.android.gms.tasks.Task n;
    public final /* synthetic */ com.google.android.gms.tasks.zzi t;

    public zzj(com.google.android.gms.tasks.zzi zziVar, com.google.android.gms.tasks.Task task) {
        this.t = zziVar;
        this.n = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        java.lang.Object obj;
        com.google.android.gms.tasks.OnCompleteListener onCompleteListener;
        com.google.android.gms.tasks.OnCompleteListener onCompleteListener2;
        obj = this.t.b;
        synchronized (obj) {
            onCompleteListener = this.t.c;
            if (onCompleteListener != null) {
                onCompleteListener2 = this.t.c;
                onCompleteListener2.onComplete(this.n);
            }
        }
    }
}
