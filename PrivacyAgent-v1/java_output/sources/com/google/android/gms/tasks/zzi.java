package com.google.android.gms.tasks;

/* loaded from: classes22.dex */
final class zzi<TResult> implements com.google.android.gms.tasks.zzr<TResult> {
    public final java.util.concurrent.Executor a;
    public final java.lang.Object b = new java.lang.Object();

    @javax.annotation.concurrent.GuardedBy("mLock")
    @javax.annotation.Nullable
    public com.google.android.gms.tasks.OnCompleteListener<TResult> c;

    public zzi(@androidx.annotation.NonNull java.util.concurrent.Executor executor, @androidx.annotation.NonNull com.google.android.gms.tasks.OnCompleteListener<TResult> onCompleteListener) {
        this.a = executor;
        this.c = onCompleteListener;
    }

    @Override // com.google.android.gms.tasks.zzr
    public final void a(@androidx.annotation.NonNull com.google.android.gms.tasks.Task<TResult> task) {
        synchronized (this.b) {
            if (this.c == null) {
                return;
            }
            this.a.execute(new com.google.android.gms.tasks.zzj(this, task));
        }
    }

    @Override // com.google.android.gms.tasks.zzr
    public final void zza() {
        synchronized (this.b) {
            this.c = null;
        }
    }
}
