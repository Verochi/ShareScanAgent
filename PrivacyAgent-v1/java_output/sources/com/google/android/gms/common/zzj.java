package com.google.android.gms.common;

@com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class(creator = "GoogleCertificatesQueryCreator")
/* loaded from: classes22.dex */
public final class zzj extends com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable {
    public static final android.os.Parcelable.Creator<com.google.android.gms.common.zzj> CREATOR = new com.google.android.gms.common.zzm();

    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field(getter = "getCallingPackage", id = 1)
    private final java.lang.String zza;

    @javax.annotation.Nullable
    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field(getter = "getCallingCertificateBinder", id = 2, type = "android.os.IBinder")
    private final com.google.android.gms.common.zzd zzb;

    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field(getter = "getAllowTestKeys", id = 3)
    private final boolean zzc;

    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field(defaultValue = com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE, getter = "getIgnoreTestKeysOverride", id = 4)
    private final boolean zzd;

    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor
    public zzj(@com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 1) java.lang.String str, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 2) @javax.annotation.Nullable android.os.IBinder iBinder, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 3) boolean z, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 4) boolean z2) {
        this.zza = str;
        this.zzb = zza(iBinder);
        this.zzc = z;
        this.zzd = z2;
    }

    public zzj(java.lang.String str, @javax.annotation.Nullable com.google.android.gms.common.zzd zzdVar, boolean z, boolean z2) {
        this.zza = str;
        this.zzb = zzdVar;
        this.zzc = z;
        this.zzd = z2;
    }

    @javax.annotation.Nullable
    private static com.google.android.gms.common.zzd zza(@javax.annotation.Nullable android.os.IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        try {
            com.google.android.gms.dynamic.IObjectWrapper zzb = com.google.android.gms.common.internal.zzo.zza(iBinder).zzb();
            byte[] bArr = zzb == null ? null : (byte[]) com.google.android.gms.dynamic.ObjectWrapper.unwrap(zzb);
            if (bArr != null) {
                return new com.google.android.gms.common.zzg(bArr);
            }
            return null;
        } catch (android.os.RemoteException unused) {
            return null;
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(android.os.Parcel parcel, int i) {
        int beginObjectHeader = com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.beginObjectHeader(parcel);
        com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        com.google.android.gms.common.zzd zzdVar = this.zzb;
        com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.writeIBinder(parcel, 2, zzdVar == null ? null : zzdVar.asBinder(), false);
        com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.writeBoolean(parcel, 3, this.zzc);
        com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.writeBoolean(parcel, 4, this.zzd);
        com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
