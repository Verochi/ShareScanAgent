package com.google.android.gms.tasks;

/* loaded from: classes22.dex */
public class CancellationTokenSource {
    public final com.google.android.gms.tasks.zza a = new com.google.android.gms.tasks.zza();

    public void cancel() {
        this.a.a();
    }

    @androidx.annotation.NonNull
    public com.google.android.gms.tasks.CancellationToken getToken() {
        return this.a;
    }
}
