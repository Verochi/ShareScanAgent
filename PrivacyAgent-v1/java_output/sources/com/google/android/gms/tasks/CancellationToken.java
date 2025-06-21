package com.google.android.gms.tasks;

/* loaded from: classes22.dex */
public abstract class CancellationToken {
    public abstract boolean isCancellationRequested();

    @androidx.annotation.NonNull
    public abstract com.google.android.gms.tasks.CancellationToken onCanceledRequested(@androidx.annotation.NonNull com.google.android.gms.tasks.OnTokenCanceledListener onTokenCanceledListener);
}
