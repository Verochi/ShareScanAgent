package com.google.android.gms.common.stats;

@com.google.android.gms.common.annotation.KeepForSdk
@com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class(creator = "WakeLockEventCreator")
@java.lang.Deprecated
/* loaded from: classes22.dex */
public final class WakeLockEvent extends com.google.android.gms.common.stats.StatsEvent {

    @androidx.annotation.RecentlyNonNull
    public static final android.os.Parcelable.Creator<com.google.android.gms.common.stats.WakeLockEvent> CREATOR = new com.google.android.gms.common.stats.zza();

    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField(id = 1)
    private final int zza;

    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field(getter = "getTimeMillis", id = 2)
    private final long zzb;

    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field(getter = "getEventType", id = 11)
    private int zzc;

    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field(getter = "getWakeLockName", id = 4)
    private final java.lang.String zzd;

    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field(getter = "getSecondaryWakeLockName", id = 10)
    private final java.lang.String zze;

    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field(getter = "getCodePackage", id = 17)
    private final java.lang.String zzf;

    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field(getter = "getWakeLockType", id = 5)
    private final int zzg;

    @javax.annotation.Nullable
    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field(getter = "getCallingPackages", id = 6)
    private final java.util.List<java.lang.String> zzh;

    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field(getter = "getEventKey", id = 12)
    private final java.lang.String zzi;

    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field(getter = "getElapsedRealtime", id = 8)
    private final long zzj;

    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field(getter = "getDeviceState", id = 14)
    private int zzk;

    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field(getter = "getHostPackage", id = 13)
    private final java.lang.String zzl;

    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field(getter = "getBeginPowerPercentage", id = 15)
    private final float zzm;

    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field(getter = "getTimeout", id = 16)
    private final long zzn;

    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field(getter = "getAcquiredWithTimeout", id = 18)
    private final boolean zzo;
    private long zzp = -1;

    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor
    public WakeLockEvent(@com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 1) int i, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 2) long j, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 11) int i2, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 4) java.lang.String str, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 5) int i3, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 6) @javax.annotation.Nullable java.util.List<java.lang.String> list, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 12) java.lang.String str2, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 8) long j2, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 14) int i4, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 10) java.lang.String str3, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 13) java.lang.String str4, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 15) float f, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 16) long j3, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 17) java.lang.String str5, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 18) boolean z) {
        this.zza = i;
        this.zzb = j;
        this.zzc = i2;
        this.zzd = str;
        this.zze = str3;
        this.zzf = str5;
        this.zzg = i3;
        this.zzh = list;
        this.zzi = str2;
        this.zzj = j2;
        this.zzk = i4;
        this.zzl = str4;
        this.zzm = f;
        this.zzn = j3;
        this.zzo = z;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i) {
        int beginObjectHeader = com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.beginObjectHeader(parcel);
        com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.writeInt(parcel, 1, this.zza);
        com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.writeLong(parcel, 2, zza());
        com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.writeString(parcel, 4, this.zzd, false);
        com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.writeInt(parcel, 5, this.zzg);
        com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.writeStringList(parcel, 6, this.zzh, false);
        com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.writeLong(parcel, 8, this.zzj);
        com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.writeString(parcel, 10, this.zze, false);
        com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.writeInt(parcel, 11, zzb());
        com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.writeString(parcel, 12, this.zzi, false);
        com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.writeString(parcel, 13, this.zzl, false);
        com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.writeInt(parcel, 14, this.zzk);
        com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.writeFloat(parcel, 15, this.zzm);
        com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.writeLong(parcel, 16, this.zzn);
        com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.writeString(parcel, 17, this.zzf, false);
        com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.writeBoolean(parcel, 18, this.zzo);
        com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    @androidx.annotation.RecentlyNonNull
    public final long zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    @androidx.annotation.RecentlyNonNull
    public final int zzb() {
        return this.zzc;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    @androidx.annotation.RecentlyNonNull
    public final long zzc() {
        return this.zzp;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    @androidx.annotation.RecentlyNonNull
    public final java.lang.String zzd() {
        java.util.List<java.lang.String> list = this.zzh;
        java.lang.String str = this.zzd;
        int i = this.zzg;
        java.lang.String join = list == null ? "" : android.text.TextUtils.join(",", list);
        int i2 = this.zzk;
        java.lang.String str2 = this.zze;
        if (str2 == null) {
            str2 = "";
        }
        java.lang.String str3 = this.zzl;
        if (str3 == null) {
            str3 = "";
        }
        float f = this.zzm;
        java.lang.String str4 = this.zzf;
        java.lang.String str5 = str4 != null ? str4 : "";
        boolean z = this.zzo;
        java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(str).length() + 51 + java.lang.String.valueOf(join).length() + java.lang.String.valueOf(str2).length() + java.lang.String.valueOf(str3).length() + java.lang.String.valueOf(str5).length());
        sb.append("\t");
        sb.append(str);
        sb.append("\t");
        sb.append(i);
        sb.append("\t");
        sb.append(join);
        sb.append("\t");
        sb.append(i2);
        sb.append("\t");
        sb.append(str2);
        sb.append("\t");
        sb.append(str3);
        sb.append("\t");
        sb.append(f);
        sb.append("\t");
        sb.append(str5);
        sb.append("\t");
        sb.append(z);
        return sb.toString();
    }
}
