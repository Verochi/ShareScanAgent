package com.google.android.gms.common.api;

@com.google.android.gms.common.annotation.KeepForSdk
@com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class(creator = "ScopeCreator")
/* loaded from: classes22.dex */
public final class Scope extends com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable implements com.google.android.gms.common.internal.ReflectedParcelable {

    @androidx.annotation.RecentlyNonNull
    public static final android.os.Parcelable.Creator<com.google.android.gms.common.api.Scope> CREATOR = new com.google.android.gms.common.api.zza();

    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField(id = 1)
    private final int zza;

    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field(getter = "getScopeUri", id = 2)
    private final java.lang.String zzb;

    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor
    public Scope(@com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 1) int i, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 2) java.lang.String str) {
        com.google.android.gms.common.internal.Preconditions.checkNotEmpty(str, "scopeUri must not be null or empty");
        this.zza = i;
        this.zzb = str;
    }

    public Scope(@androidx.annotation.RecentlyNonNull java.lang.String str) {
        this(1, str);
    }

    @androidx.annotation.RecentlyNonNull
    public final boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof com.google.android.gms.common.api.Scope) {
            return this.zzb.equals(((com.google.android.gms.common.api.Scope) obj).zzb);
        }
        return false;
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public final java.lang.String getScopeUri() {
        return this.zzb;
    }

    @androidx.annotation.RecentlyNonNull
    public final int hashCode() {
        return this.zzb.hashCode();
    }

    @androidx.annotation.RecentlyNonNull
    public final java.lang.String toString() {
        return this.zzb;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i) {
        int beginObjectHeader = com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.beginObjectHeader(parcel);
        com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.writeInt(parcel, 1, this.zza);
        com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.writeString(parcel, 2, getScopeUri(), false);
        com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
