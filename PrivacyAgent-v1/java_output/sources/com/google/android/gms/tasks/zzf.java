package com.google.android.gms.tasks;

/* loaded from: classes22.dex */
final class zzf implements java.lang.Runnable {
    public final /* synthetic */ com.google.android.gms.tasks.Task n;
    public final /* synthetic */ com.google.android.gms.tasks.zzd t;

    public zzf(com.google.android.gms.tasks.zzd zzdVar, com.google.android.gms.tasks.Task task) {
        this.t = zzdVar;
        this.n = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.gms.tasks.zzu zzuVar;
        com.google.android.gms.tasks.zzu zzuVar2;
        com.google.android.gms.tasks.zzu zzuVar3;
        com.google.android.gms.tasks.Continuation continuation;
        try {
            continuation = this.t.b;
            com.google.android.gms.tasks.Task task = (com.google.android.gms.tasks.Task) continuation.then(this.n);
            if (task == null) {
                this.t.onFailure(new java.lang.NullPointerException("Continuation returned null"));
                return;
            }
            java.util.concurrent.Executor executor = com.google.android.gms.tasks.TaskExecutors.a;
            task.addOnSuccessListener(executor, this.t);
            task.addOnFailureListener(executor, this.t);
            task.addOnCanceledListener(executor, this.t);
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
