package com.google.android.gms.common.internal;

@com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class(creator = "ValidateAccountRequestCreator")
@java.lang.Deprecated
/* loaded from: classes22.dex */
public final class zzx extends com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable {
    public static final android.os.Parcelable.Creator<com.google.android.gms.common.internal.zzx> CREATOR = new com.google.android.gms.common.internal.zzw();

    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField(id = 1)
    private final int zza;

    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor
    public zzx(@com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 1) int i) {
        this.zza = i;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(android.os.Parcel parcel, int i) {
        int beginObjectHeader = com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.beginObjectHeader(parcel);
        com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.writeInt(parcel, 1, this.zza);
        com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
