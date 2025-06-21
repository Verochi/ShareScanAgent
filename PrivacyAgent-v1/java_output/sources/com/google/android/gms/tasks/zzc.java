package com.google.android.gms.tasks;

/* loaded from: classes22.dex */
final class zzc<TResult, TContinuationResult> implements com.google.android.gms.tasks.zzr<TResult> {
    public final java.util.concurrent.Executor a;
    public final com.google.android.gms.tasks.Continuation<TResult, TContinuationResult> b;
    public final com.google.android.gms.tasks.zzu<TContinuationResult> c;

    public zzc(@androidx.annotation.NonNull java.util.concurrent.Executor executor, @androidx.annotation.NonNull com.google.android.gms.tasks.Continuation<TResult, TContinuationResult> continuation, @androidx.annotation.NonNull com.google.android.gms.tasks.zzu<TContinuationResult> zzuVar) {
        this.a = executor;
        this.b = continuation;
        this.c = zzuVar;
    }

    @Override // com.google.android.gms.tasks.zzr
    public final void a(@androidx.annotation.NonNull com.google.android.gms.tasks.Task<TResult> task) {
        this.a.execute(new com.google.android.gms.tasks.zze(this, task));
    }

    @Override // com.google.android.gms.tasks.zzr
    public final void zza() {
        throw new java.lang.UnsupportedOperationException();
    }
}
