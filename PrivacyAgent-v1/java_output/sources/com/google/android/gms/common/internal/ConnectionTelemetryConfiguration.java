package com.google.android.gms.common.internal;

@com.google.android.gms.common.annotation.KeepForSdk
@com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class(creator = "ConnectionTelemetryConfigurationCreator")
/* loaded from: classes22.dex */
public class ConnectionTelemetryConfiguration extends com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable {

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static final android.os.Parcelable.Creator<com.google.android.gms.common.internal.ConnectionTelemetryConfiguration> CREATOR = new com.google.android.gms.common.internal.zzd();

    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field(getter = "getRootTelemetryConfiguration", id = 1)
    private final com.google.android.gms.common.internal.RootTelemetryConfiguration zza;

    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field(getter = "getMethodInvocationTelemetryEnabled", id = 2)
    private final boolean zzb;

    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field(getter = "getMethodTimingTelemetryEnabled", id = 3)
    private final boolean zzc;

    @androidx.annotation.Nullable
    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field(getter = "getMethodInvocationMethodKeyWhitelist", id = 4)
    private final int[] zzd;

    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field(getter = "getMaxMethodInvocationsLogged", id = 5)
    private final int zze;

    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor
    public ConnectionTelemetryConfiguration(@com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 1) com.google.android.gms.common.internal.RootTelemetryConfiguration rootTelemetryConfiguration, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 2) boolean z, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 3) boolean z2, @androidx.annotation.Nullable @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 4) int[] iArr, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 5) int i) {
        this.zza = rootTelemetryConfiguration;
        this.zzb = z;
        this.zzc = z2;
        this.zzd = iArr;
        this.zze = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i) {
        int beginObjectHeader = com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.beginObjectHeader(parcel);
        com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.writeParcelable(parcel, 1, this.zza, i, false);
        com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.writeBoolean(parcel, 2, this.zzb);
        com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.writeBoolean(parcel, 3, this.zzc);
        com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.writeIntArray(parcel, 4, this.zzd, false);
        com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.writeInt(parcel, 5, this.zze);
        com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
