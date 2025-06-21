package com.google.android.gms.common.internal;

@com.google.android.gms.common.annotation.KeepForSdk
@com.google.android.gms.common.annotation.KeepName
/* loaded from: classes22.dex */
public final class BinderWrapper implements android.os.Parcelable {

    @androidx.annotation.RecentlyNonNull
    public static final android.os.Parcelable.Creator<com.google.android.gms.common.internal.BinderWrapper> CREATOR = new com.google.android.gms.common.internal.zza();
    private android.os.IBinder zza;

    @com.google.android.gms.common.annotation.KeepForSdk
    public BinderWrapper(@androidx.annotation.RecentlyNonNull android.os.IBinder iBinder) {
        this.zza = iBinder;
    }

    private BinderWrapper(android.os.Parcel parcel) {
        this.zza = parcel.readStrongBinder();
    }

    public /* synthetic */ BinderWrapper(android.os.Parcel parcel, com.google.android.gms.common.internal.zza zzaVar) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    @androidx.annotation.RecentlyNonNull
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i) {
        parcel.writeStrongBinder(this.zza);
    }
}
