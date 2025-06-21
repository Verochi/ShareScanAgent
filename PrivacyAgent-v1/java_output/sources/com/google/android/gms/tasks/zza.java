package com.google.android.gms.tasks;

/* loaded from: classes22.dex */
final class zza extends com.google.android.gms.tasks.CancellationToken {
    public final com.google.android.gms.tasks.zzu<java.lang.Void> a = new com.google.android.gms.tasks.zzu<>();

    public final void a() {
        this.a.f(null);
    }

    @Override // com.google.android.gms.tasks.CancellationToken
    public final boolean isCancellationRequested() {
        return this.a.isComplete();
    }

    @Override // com.google.android.gms.tasks.CancellationToken
    public final com.google.android.gms.tasks.CancellationToken onCanceledRequested(@androidx.annotation.NonNull com.google.android.gms.tasks.OnTokenCanceledListener onTokenCanceledListener) {
        this.a.addOnSuccessListener(new com.google.android.gms.tasks.zzb(this, onTokenCanceledListener));
        return this;
    }
}
