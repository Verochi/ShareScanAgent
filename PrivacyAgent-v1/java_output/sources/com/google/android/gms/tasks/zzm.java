package com.google.android.gms.tasks;

/* loaded from: classes22.dex */
final class zzm<TResult> implements com.google.android.gms.tasks.zzr<TResult> {
    public final java.util.concurrent.Executor a;
    public final java.lang.Object b = new java.lang.Object();

    @javax.annotation.concurrent.GuardedBy("mLock")
    @javax.annotation.Nullable
    public com.google.android.gms.tasks.OnSuccessListener<? super TResult> c;

    public zzm(@androidx.annotation.NonNull java.util.concurrent.Executor executor, @androidx.annotation.NonNull com.google.android.gms.tasks.OnSuccessListener<? super TResult> onSuccessListener) {
        this.a = executor;
        this.c = onSuccessListener;
    }

    @Override // com.google.android.gms.tasks.zzr
    public final void a(@androidx.annotation.NonNull com.google.android.gms.tasks.Task<TResult> task) {
        if (task.isSuccessful()) {
            synchronized (this.b) {
                if (this.c == null) {
                    return;
                }
                this.a.execute(new com.google.android.gms.tasks.zzn(this, task));
            }
        }
    }

    @Override // com.google.android.gms.tasks.zzr
    public final void zza() {
        synchronized (this.b) {
            this.c = null;
        }
    }
}
