package com.google.android.gms.common.api;

/* loaded from: classes22.dex */
public abstract class ResultCallbacks<R extends com.google.android.gms.common.api.Result> implements com.google.android.gms.common.api.ResultCallback<R> {
    public abstract void onFailure(@androidx.annotation.RecentlyNonNull com.google.android.gms.common.api.Status status);

    @Override // com.google.android.gms.common.api.ResultCallback
    @com.google.android.gms.common.annotation.KeepForSdk
    public final void onResult(@androidx.annotation.RecentlyNonNull R r) {
        com.google.android.gms.common.api.Status status = r.getStatus();
        if (status.isSuccess()) {
            onSuccess(r);
            return;
        }
        onFailure(status);
        if (r instanceof com.google.android.gms.common.api.Releasable) {
            try {
                ((com.google.android.gms.common.api.Releasable) r).release();
            } catch (java.lang.RuntimeException unused) {
                java.lang.String valueOf = java.lang.String.valueOf(r);
                java.lang.StringBuilder sb = new java.lang.StringBuilder(valueOf.length() + 18);
                sb.append("Unable to release ");
                sb.append(valueOf);
            }
        }
    }

    public abstract void onSuccess(@androidx.annotation.RecentlyNonNull R r);
}
