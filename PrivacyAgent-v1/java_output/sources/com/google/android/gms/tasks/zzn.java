package com.google.android.gms.tasks;

/* loaded from: classes22.dex */
final class zzn implements java.lang.Runnable {
    public final /* synthetic */ com.google.android.gms.tasks.Task n;
    public final /* synthetic */ com.google.android.gms.tasks.zzm t;

    public zzn(com.google.android.gms.tasks.zzm zzmVar, com.google.android.gms.tasks.Task task) {
        this.t = zzmVar;
        this.n = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        java.lang.Object obj;
        com.google.android.gms.tasks.OnSuccessListener onSuccessListener;
        com.google.android.gms.tasks.OnSuccessListener onSuccessListener2;
        obj = this.t.b;
        synchronized (obj) {
            onSuccessListener = this.t.c;
            if (onSuccessListener != null) {
                onSuccessListener2 = this.t.c;
                onSuccessListener2.onSuccess(this.n.getResult());
            }
        }
    }
}
