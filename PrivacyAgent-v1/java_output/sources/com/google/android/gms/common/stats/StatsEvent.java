package com.google.android.gms.common.stats;

@com.google.android.gms.common.annotation.KeepForSdk
@java.lang.Deprecated
/* loaded from: classes22.dex */
public abstract class StatsEvent extends com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable implements com.google.android.gms.common.internal.ReflectedParcelable {

    @com.google.android.gms.common.annotation.KeepForSdk
    public interface Types {

        @androidx.annotation.RecentlyNonNull
        @com.google.android.gms.common.annotation.KeepForSdk
        public static final int EVENT_TYPE_ACQUIRE_WAKE_LOCK = 7;

        @androidx.annotation.RecentlyNonNull
        @com.google.android.gms.common.annotation.KeepForSdk
        public static final int EVENT_TYPE_RELEASE_WAKE_LOCK = 8;
    }

    @androidx.annotation.RecentlyNonNull
    public java.lang.String toString() {
        long zza = zza();
        int zzb = zzb();
        long zzc = zzc();
        java.lang.String zzd = zzd();
        java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(zzd).length() + 53);
        sb.append(zza);
        sb.append("\t");
        sb.append(zzb);
        sb.append("\t");
        sb.append(zzc);
        sb.append(zzd);
        return sb.toString();
    }

    @androidx.annotation.RecentlyNonNull
    public abstract long zza();

    @androidx.annotation.RecentlyNonNull
    public abstract int zzb();

    @androidx.annotation.RecentlyNonNull
    public abstract long zzc();

    @androidx.annotation.RecentlyNonNull
    public abstract java.lang.String zzd();
}
