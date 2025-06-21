package com.google.android.gms.tasks;

/* loaded from: classes22.dex */
final class zzp<TResult, TContinuationResult> implements com.google.android.gms.tasks.OnCanceledListener, com.google.android.gms.tasks.OnFailureListener, com.google.android.gms.tasks.OnSuccessListener<TContinuationResult>, com.google.android.gms.tasks.zzr<TResult> {
    public final java.util.concurrent.Executor a;
    public final com.google.android.gms.tasks.SuccessContinuation<TResult, TContinuationResult> b;
    public final com.google.android.gms.tasks.zzu<TContinuationResult> c;

    public zzp(@androidx.annotation.NonNull java.util.concurrent.Executor executor, @androidx.annotation.NonNull com.google.android.gms.tasks.SuccessContinuation<TResult, TContinuationResult> successContinuation, @androidx.annotation.NonNull com.google.android.gms.tasks.zzu<TContinuationResult> zzuVar) {
        this.a = executor;
        this.b = successContinuation;
        this.c = zzuVar;
    }

    @Override // com.google.android.gms.tasks.zzr
    public final void a(@androidx.annotation.NonNull com.google.android.gms.tasks.Task<TResult> task) {
        this.a.execute(new com.google.android.gms.tasks.zzo(this, task));
    }

    @Override // com.google.android.gms.tasks.OnCanceledListener
    public final void onCanceled() {
        this.c.c();
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(@androidx.annotation.NonNull java.lang.Exception exc) {
        this.c.a(exc);
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public final void onSuccess(TContinuationResult tcontinuationresult) {
        this.c.b(tcontinuationresult);
    }

    @Override // com.google.android.gms.tasks.zzr
    public final void zza() {
        throw new java.lang.UnsupportedOperationException();
    }
}
