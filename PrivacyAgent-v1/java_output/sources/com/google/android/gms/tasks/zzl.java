package com.google.android.gms.tasks;

/* loaded from: classes22.dex */
final class zzl<TResult> implements com.google.android.gms.tasks.zzr<TResult> {
    public final java.util.concurrent.Executor a;
    public final java.lang.Object b = new java.lang.Object();

    @javax.annotation.concurrent.GuardedBy("mLock")
    @javax.annotation.Nullable
    public com.google.android.gms.tasks.OnFailureListener c;

    public zzl(@androidx.annotation.NonNull java.util.concurrent.Executor executor, @androidx.annotation.NonNull com.google.android.gms.tasks.OnFailureListener onFailureListener) {
        this.a = executor;
        this.c = onFailureListener;
    }

    @Override // com.google.android.gms.tasks.zzr
    public final void a(@androidx.annotation.NonNull com.google.android.gms.tasks.Task<TResult> task) {
        if (task.isSuccessful() || task.isCanceled()) {
            return;
        }
        synchronized (this.b) {
            if (this.c == null) {
                return;
            }
            this.a.execute(new com.google.android.gms.tasks.zzk(this, task));
        }
    }

    @Override // com.google.android.gms.tasks.zzr
    public final void zza() {
        synchronized (this.b) {
            this.c = null;
        }
    }
}
