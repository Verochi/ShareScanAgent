package com.google.android.gms.tasks;

/* loaded from: classes22.dex */
final class zzo implements java.lang.Runnable {
    public final /* synthetic */ com.google.android.gms.tasks.Task n;
    public final /* synthetic */ com.google.android.gms.tasks.zzp t;

    public zzo(com.google.android.gms.tasks.zzp zzpVar, com.google.android.gms.tasks.Task task) {
        this.t = zzpVar;
        this.n = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.gms.tasks.SuccessContinuation successContinuation;
        try {
            successContinuation = this.t.b;
            com.google.android.gms.tasks.Task then = successContinuation.then(this.n.getResult());
            if (then == null) {
                this.t.onFailure(new java.lang.NullPointerException("Continuation returned null"));
                return;
            }
            java.util.concurrent.Executor executor = com.google.android.gms.tasks.TaskExecutors.a;
            then.addOnSuccessListener(executor, this.t);
            then.addOnFailureListener(executor, this.t);
            then.addOnCanceledListener(executor, this.t);
        } catch (com.google.android.gms.tasks.RuntimeExecutionException e) {
            if (e.getCause() instanceof java.lang.Exception) {
                this.t.onFailure((java.lang.Exception) e.getCause());
            } else {
                this.t.onFailure(e);
            }
        } catch (java.util.concurrent.CancellationException unused) {
            this.t.onCanceled();
        } catch (java.lang.Exception e2) {
            this.t.onFailure(e2);
        }
    }
}
