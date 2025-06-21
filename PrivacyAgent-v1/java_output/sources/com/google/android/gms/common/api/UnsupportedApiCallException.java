package com.google.android.gms.common.api;

/* loaded from: classes22.dex */
public final class UnsupportedApiCallException extends java.lang.UnsupportedOperationException {
    private final com.google.android.gms.common.Feature zza;

    @com.google.android.gms.common.annotation.KeepForSdk
    public UnsupportedApiCallException(@androidx.annotation.RecentlyNonNull com.google.android.gms.common.Feature feature) {
        this.zza = feature;
    }

    @Override // java.lang.Throwable
    @androidx.annotation.RecentlyNonNull
    public final java.lang.String getMessage() {
        java.lang.String valueOf = java.lang.String.valueOf(this.zza);
        java.lang.StringBuilder sb = new java.lang.StringBuilder(valueOf.length() + 8);
        sb.append("Missing ");
        sb.append(valueOf);
        return sb.toString();
    }
}
