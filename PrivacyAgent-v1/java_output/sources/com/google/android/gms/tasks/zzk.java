package com.google.android.gms.tasks;

/* loaded from: classes22.dex */
final class zzk implements java.lang.Runnable {
    public final /* synthetic */ com.google.android.gms.tasks.Task n;
    public final /* synthetic */ com.google.android.gms.tasks.zzl t;

    public zzk(com.google.android.gms.tasks.zzl zzlVar, com.google.android.gms.tasks.Task task) {
        this.t = zzlVar;
        this.n = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        java.lang.Object obj;
        com.google.android.gms.tasks.OnFailureListener onFailureListener;
        com.google.android.gms.tasks.OnFailureListener onFailureListener2;
        obj = this.t.b;
        synchronized (obj) {
            onFailureListener = this.t.c;
            if (onFailureListener != null) {
                onFailureListener2 = this.t.c;
                onFailureListener2.onFailure((java.lang.Exception) com.google.android.gms.common.internal.Preconditions.checkNotNull(this.n.getException()));
            }
        }
    }
}
