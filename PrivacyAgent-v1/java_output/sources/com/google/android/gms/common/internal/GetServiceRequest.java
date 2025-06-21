package com.google.android.gms.common.internal;

@com.google.android.gms.common.annotation.KeepForSdk
@com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class(creator = "GetServiceRequestCreator")
@com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved({9})
/* loaded from: classes22.dex */
public class GetServiceRequest extends com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable {

    @androidx.annotation.RecentlyNonNull
    public static final android.os.Parcelable.Creator<com.google.android.gms.common.internal.GetServiceRequest> CREATOR = new com.google.android.gms.common.internal.zze();

    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field(id = 4)
    java.lang.String zza;

    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field(id = 5)
    android.os.IBinder zzb;

    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field(id = 6)
    com.google.android.gms.common.api.Scope[] zzc;

    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field(id = 7)
    android.os.Bundle zzd;

    @androidx.annotation.Nullable
    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field(id = 8)
    android.accounts.Account zze;

    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field(id = 10)
    com.google.android.gms.common.Feature[] zzf;

    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field(id = 11)
    com.google.android.gms.common.Feature[] zzg;

    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field(getter = "isRequestingTelemetryConfiguration", id = 14)
    boolean zzh;

    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField(id = 1)
    private final int zzi;

    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field(id = 2)
    private final int zzj;

    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field(id = 3)
    private int zzk;

    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field(id = 12)
    private boolean zzl;

    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field(defaultValue = "0", id = 13)
    private int zzm;

    public GetServiceRequest(@androidx.annotation.RecentlyNonNull int i) {
        this.zzi = 5;
        this.zzk = com.google.android.gms.common.GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
        this.zzj = i;
        this.zzl = true;
    }

    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor
    public GetServiceRequest(@com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 1) int i, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 2) int i2, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 3) int i3, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 4) java.lang.String str, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 5) android.os.IBinder iBinder, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 6) com.google.android.gms.common.api.Scope[] scopeArr, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 7) android.os.Bundle bundle, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 8) android.accounts.Account account, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 10) com.google.android.gms.common.Feature[] featureArr, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 11) com.google.android.gms.common.Feature[] featureArr2, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 12) boolean z, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 13) int i4, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 14) boolean z2) {
        this.zzi = i;
        this.zzj = i2;
        this.zzk = i3;
        if ("com.google.android.gms".equals(str)) {
            this.zza = "com.google.android.gms";
        } else {
            this.zza = str;
        }
        if (i < 2) {
            this.zze = iBinder != null ? com.google.android.gms.common.internal.AccountAccessor.getAccountBinderSafe(com.google.android.gms.common.internal.IAccountAccessor.Stub.asInterface(iBinder)) : null;
        } else {
            this.zzb = iBinder;
            this.zze = account;
        }
        this.zzc = scopeArr;
        this.zzd = bundle;
        this.zzf = featureArr;
        this.zzg = featureArr2;
        this.zzl = z;
        this.zzm = i4;
        this.zzh = z2;
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public android.os.Bundle getExtraArgs() {
        return this.zzd;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i) {
        int beginObjectHeader = com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.beginObjectHeader(parcel);
        com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.writeInt(parcel, 1, this.zzi);
        com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.writeInt(parcel, 2, this.zzj);
        com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.writeInt(parcel, 3, this.zzk);
        com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.writeString(parcel, 4, this.zza, false);
        com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.writeIBinder(parcel, 5, this.zzb, false);
        com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.writeTypedArray(parcel, 6, this.zzc, i, false);
        com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.writeBundle(parcel, 7, this.zzd, false);
        com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.writeParcelable(parcel, 8, this.zze, i, false);
        com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.writeTypedArray(parcel, 10, this.zzf, i, false);
        com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.writeTypedArray(parcel, 11, this.zzg, i, false);
        com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.writeBoolean(parcel, 12, this.zzl);
        com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.writeInt(parcel, 13, this.zzm);
        com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.writeBoolean(parcel, 14, this.zzh);
        com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
