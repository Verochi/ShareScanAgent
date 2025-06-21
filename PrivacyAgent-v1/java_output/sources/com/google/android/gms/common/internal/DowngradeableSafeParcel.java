package com.google.android.gms.common.internal;

@com.google.android.gms.common.annotation.KeepForSdk
/* loaded from: classes22.dex */
public abstract class DowngradeableSafeParcel extends com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable implements com.google.android.gms.common.internal.ReflectedParcelable {
    private static final java.lang.Object zza = new java.lang.Object();

    @androidx.annotation.Nullable
    private static java.lang.ClassLoader zzb;

    @androidx.annotation.Nullable
    private static java.lang.Integer zzc;
    private boolean zzd = false;

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static boolean canUnparcelSafely(@androidx.annotation.RecentlyNonNull java.lang.String str) {
        zza();
        return true;
    }

    @androidx.annotation.RecentlyNullable
    @com.google.android.gms.common.annotation.KeepForSdk
    public static java.lang.Integer getUnparcelClientVersion() {
        synchronized (zza) {
        }
        return null;
    }

    @androidx.annotation.Nullable
    private static java.lang.ClassLoader zza() {
        synchronized (zza) {
        }
        return null;
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public abstract boolean prepareForClientVersion(@androidx.annotation.RecentlyNonNull int i);

    @com.google.android.gms.common.annotation.KeepForSdk
    public void setShouldDowngrade(@androidx.annotation.RecentlyNonNull boolean z) {
        this.zzd = z;
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public boolean shouldDowngrade() {
        return this.zzd;
    }
}
