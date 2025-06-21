package com.google.android.gms.common.internal;

@com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class(creator = "ConnectionInfoCreator")
/* loaded from: classes22.dex */
public final class zzc extends com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable {
    public static final android.os.Parcelable.Creator<com.google.android.gms.common.internal.zzc> CREATOR = new com.google.android.gms.common.internal.zzb();

    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field(id = 1)
    android.os.Bundle zza;

    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field(id = 2)
    com.google.android.gms.common.Feature[] zzb;

    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field(defaultValue = "0", id = 3)
    private int zzc;

    public zzc() {
    }

    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor
    public zzc(@com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 1) android.os.Bundle bundle, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 2) com.google.android.gms.common.Feature[] featureArr, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 3) int i, @androidx.annotation.Nullable @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 4) com.google.android.gms.common.internal.ConnectionTelemetryConfiguration connectionTelemetryConfiguration) {
        this.zza = bundle;
        this.zzb = featureArr;
        this.zzc = i;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(android.os.Parcel parcel, int i) {
        int beginObjectHeader = com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.beginObjectHeader(parcel);
        com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.writeBundle(parcel, 1, this.zza, false);
        com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.writeTypedArray(parcel, 2, this.zzb, i, false);
        com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.writeInt(parcel, 3, this.zzc);
        com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.writeParcelable(parcel, 4, null, i, false);
        com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
