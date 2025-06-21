package com.google.android.gms.tasks;

/* loaded from: classes22.dex */
final class zze implements java.lang.Runnable {
    public final /* synthetic */ com.google.android.gms.tasks.Task n;
    public final /* synthetic */ com.google.android.gms.tasks.zzc t;

    public zze(com.google.android.gms.tasks.zzc zzcVar, com.google.android.gms.tasks.Task task) {
        this.t = zzcVar;
        this.n = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.gms.tasks.zzu zzuVar;
        com.google.android.gms.tasks.zzu zzuVar2;
        com.google.android.gms.tasks.zzu zzuVar3;
        com.google.android.gms.tasks.Continuation continuation;
        com.google.android.gms.tasks.zzu zzuVar4;
        com.google.android.gms.tasks.zzu zzuVar5;
        if (this.n.isCanceled()) {
            zzuVar5 = this.t.c;
            zzuVar5.c();
            return;
        }
        try {
            continuation = this.t.b;
            java.lang.Object then = continuation.then(this.n);
            zzuVar4 = this.t.c;
            zzuVar4.b(then);
        } catch (com.google.android.gms.tasks.RuntimeExecutionException e) {
            if (e.getCause() instanceof java.lang.Exception) {
                zzuVar3 = this.t.c;
                zzuVar3.a((java.lang.Exception) e.getCause());
            } else {
                zzuVar2 = this.t.c;
                zzuVar2.a(e);
            }
        } catch (java.lang.Exception e2) {
            zzuVar = this.t.c;
            zzuVar.a(e2);
        }
    }
}
