package com.google.android.gms.common;

@com.google.android.gms.common.annotation.KeepForSdk
@com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class(creator = "FeatureCreator")
/* loaded from: classes22.dex */
public class Feature extends com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable {

    @androidx.annotation.RecentlyNonNull
    public static final android.os.Parcelable.Creator<com.google.android.gms.common.Feature> CREATOR = new com.google.android.gms.common.zzb();

    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field(getter = "getName", id = 1)
    private final java.lang.String zza;

    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field(getter = "getOldVersion", id = 2)
    @java.lang.Deprecated
    private final int zzb;

    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field(defaultValue = "-1", getter = "getVersion", id = 3)
    private final long zzc;

    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor
    public Feature(@androidx.annotation.RecentlyNonNull @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 1) java.lang.String str, @androidx.annotation.RecentlyNonNull @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 2) int i, @androidx.annotation.RecentlyNonNull @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 3) long j) {
        this.zza = str;
        this.zzb = i;
        this.zzc = j;
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public Feature(@androidx.annotation.RecentlyNonNull java.lang.String str, @androidx.annotation.RecentlyNonNull long j) {
        this.zza = str;
        this.zzc = j;
        this.zzb = -1;
    }

    @androidx.annotation.RecentlyNonNull
    public boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
        if (obj instanceof com.google.android.gms.common.Feature) {
            com.google.android.gms.common.Feature feature = (com.google.android.gms.common.Feature) obj;
            if (((getName() != null && getName().equals(feature.getName())) || (getName() == null && feature.getName() == null)) && getVersion() == feature.getVersion()) {
                return true;
            }
        }
        return false;
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public java.lang.String getName() {
        return this.zza;
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public long getVersion() {
        long j = this.zzc;
        return j == -1 ? this.zzb : j;
    }

    @androidx.annotation.RecentlyNonNull
    public int hashCode() {
        return com.google.android.gms.common.internal.Objects.hashCode(getName(), java.lang.Long.valueOf(getVersion()));
    }

    @androidx.annotation.RecentlyNonNull
    public java.lang.String toString() {
        return com.google.android.gms.common.internal.Objects.toStringHelper(this).add("name", getName()).add("version", java.lang.Long.valueOf(getVersion())).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i) {
        int beginObjectHeader = com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.beginObjectHeader(parcel);
        com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.writeString(parcel, 1, getName(), false);
        com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.writeLong(parcel, 3, getVersion());
        com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
