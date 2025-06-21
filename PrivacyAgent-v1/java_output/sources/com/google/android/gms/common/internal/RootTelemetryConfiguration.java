package com.google.android.gms.common.internal;

@com.google.android.gms.common.annotation.KeepForSdk
@com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class(creator = "RootTelemetryConfigurationCreator")
/* loaded from: classes22.dex */
public class RootTelemetryConfiguration extends com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable {

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static final android.os.Parcelable.Creator<com.google.android.gms.common.internal.RootTelemetryConfiguration> CREATOR = new com.google.android.gms.common.internal.zzv();

    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field(getter = "getVersion", id = 1)
    private final int zza;

    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field(getter = "getMethodInvocationTelemetryEnabled", id = 2)
    private final boolean zzb;

    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field(getter = "getMethodTimingTelemetryEnabled", id = 3)
    private final boolean zzc;

    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field(getter = "getBatchPeriodMillis", id = 4)
    private final int zzd;

    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field(getter = "getMaxMethodInvocationsInBatch", id = 5)
    private final int zze;

    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor
    public RootTelemetryConfiguration(@androidx.annotation.RecentlyNonNull @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 1) int i, @androidx.annotation.RecentlyNonNull @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 2) boolean z, @androidx.annotation.RecentlyNonNull @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 3) boolean z2, @androidx.annotation.RecentlyNonNull @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 4) int i2, @androidx.annotation.RecentlyNonNull @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 5) int i3) {
        this.zza = i;
        this.zzb = z;
        this.zzc = z2;
        this.zzd = i2;
        this.zze = i3;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i) {
        int beginObjectHeader = com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.beginObjectHeader(parcel);
        com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.writeInt(parcel, 1, this.zza);
        com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.writeBoolean(parcel, 2, this.zzb);
        com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.writeBoolean(parcel, 3, this.zzc);
        com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.writeInt(parcel, 4, this.zzd);
        com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.writeInt(parcel, 5, this.zze);
        com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
