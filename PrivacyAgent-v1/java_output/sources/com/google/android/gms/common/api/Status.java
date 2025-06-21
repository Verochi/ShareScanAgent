package com.google.android.gms.common.api;

@com.google.android.gms.common.annotation.KeepForSdk
@com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class(creator = "StatusCreator")
/* loaded from: classes22.dex */
public final class Status extends com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable implements com.google.android.gms.common.api.Result, com.google.android.gms.common.internal.ReflectedParcelable {

    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField(id = 1000)
    private final int zzb;

    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field(getter = "getStatusCode", id = 1)
    private final int zzc;

    @androidx.annotation.Nullable
    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field(getter = "getStatusMessage", id = 2)
    private final java.lang.String zzd;

    @androidx.annotation.Nullable
    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field(getter = "getPendingIntent", id = 3)
    private final android.app.PendingIntent zze;

    @androidx.annotation.Nullable
    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field(getter = "getConnectionResult", id = 4)
    private final com.google.android.gms.common.ConnectionResult zzf;

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.util.VisibleForTesting
    @com.google.android.gms.common.internal.ShowFirstParty
    @com.google.android.gms.common.annotation.KeepForSdk
    public static final com.google.android.gms.common.api.Status RESULT_SUCCESS = new com.google.android.gms.common.api.Status(0);

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.internal.ShowFirstParty
    @com.google.android.gms.common.annotation.KeepForSdk
    public static final com.google.android.gms.common.api.Status RESULT_INTERRUPTED = new com.google.android.gms.common.api.Status(14);

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.internal.ShowFirstParty
    @com.google.android.gms.common.annotation.KeepForSdk
    public static final com.google.android.gms.common.api.Status RESULT_INTERNAL_ERROR = new com.google.android.gms.common.api.Status(8);

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.internal.ShowFirstParty
    @com.google.android.gms.common.annotation.KeepForSdk
    public static final com.google.android.gms.common.api.Status RESULT_TIMEOUT = new com.google.android.gms.common.api.Status(15);

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.internal.ShowFirstParty
    @com.google.android.gms.common.annotation.KeepForSdk
    public static final com.google.android.gms.common.api.Status RESULT_CANCELED = new com.google.android.gms.common.api.Status(16);

    @com.google.android.gms.common.internal.ShowFirstParty
    private static final com.google.android.gms.common.api.Status zza = new com.google.android.gms.common.api.Status(17);

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static final com.google.android.gms.common.api.Status RESULT_DEAD_CLIENT = new com.google.android.gms.common.api.Status(18);

    @androidx.annotation.RecentlyNonNull
    public static final android.os.Parcelable.Creator<com.google.android.gms.common.api.Status> CREATOR = new com.google.android.gms.common.api.zzb();

    @com.google.android.gms.common.annotation.KeepForSdk
    public Status(@androidx.annotation.RecentlyNonNull int i) {
        this(i, (java.lang.String) null);
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public Status(int i, int i2, @androidx.annotation.Nullable java.lang.String str, @androidx.annotation.Nullable android.app.PendingIntent pendingIntent) {
        this(i, i2, str, pendingIntent, null);
    }

    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor
    @com.google.android.gms.common.annotation.KeepForSdk
    public Status(@com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 1000) int i, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 1) int i2, @androidx.annotation.Nullable @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 2) java.lang.String str, @androidx.annotation.Nullable @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 3) android.app.PendingIntent pendingIntent, @androidx.annotation.Nullable @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 4) com.google.android.gms.common.ConnectionResult connectionResult) {
        this.zzb = i;
        this.zzc = i2;
        this.zzd = str;
        this.zze = pendingIntent;
        this.zzf = connectionResult;
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public Status(@androidx.annotation.RecentlyNonNull int i, @androidx.annotation.Nullable java.lang.String str) {
        this(1, i, str, null);
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public Status(@androidx.annotation.RecentlyNonNull int i, @androidx.annotation.Nullable java.lang.String str, @androidx.annotation.Nullable android.app.PendingIntent pendingIntent) {
        this(1, i, str, pendingIntent);
    }

    public Status(@androidx.annotation.RecentlyNonNull com.google.android.gms.common.ConnectionResult connectionResult, @androidx.annotation.RecentlyNonNull java.lang.String str) {
        this(connectionResult, str, 17);
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    @java.lang.Deprecated
    public Status(@androidx.annotation.RecentlyNonNull com.google.android.gms.common.ConnectionResult connectionResult, @androidx.annotation.RecentlyNonNull java.lang.String str, @androidx.annotation.RecentlyNonNull int i) {
        this(1, i, str, connectionResult.getResolution(), connectionResult);
    }

    @androidx.annotation.RecentlyNonNull
    public final boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
        if (!(obj instanceof com.google.android.gms.common.api.Status)) {
            return false;
        }
        com.google.android.gms.common.api.Status status = (com.google.android.gms.common.api.Status) obj;
        return this.zzb == status.zzb && this.zzc == status.zzc && com.google.android.gms.common.internal.Objects.equal(this.zzd, status.zzd) && com.google.android.gms.common.internal.Objects.equal(this.zze, status.zze) && com.google.android.gms.common.internal.Objects.equal(this.zzf, status.zzf);
    }

    @androidx.annotation.RecentlyNullable
    public final com.google.android.gms.common.ConnectionResult getConnectionResult() {
        return this.zzf;
    }

    @androidx.annotation.RecentlyNullable
    public final android.app.PendingIntent getResolution() {
        return this.zze;
    }

    @Override // com.google.android.gms.common.api.Result
    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public final com.google.android.gms.common.api.Status getStatus() {
        return this;
    }

    @androidx.annotation.RecentlyNonNull
    public final int getStatusCode() {
        return this.zzc;
    }

    @androidx.annotation.RecentlyNullable
    public final java.lang.String getStatusMessage() {
        return this.zzd;
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.util.VisibleForTesting
    public final boolean hasResolution() {
        return this.zze != null;
    }

    @androidx.annotation.RecentlyNonNull
    public final int hashCode() {
        return com.google.android.gms.common.internal.Objects.hashCode(java.lang.Integer.valueOf(this.zzb), java.lang.Integer.valueOf(this.zzc), this.zzd, this.zze, this.zzf);
    }

    @androidx.annotation.RecentlyNonNull
    public final boolean isCanceled() {
        return this.zzc == 16;
    }

    @androidx.annotation.RecentlyNonNull
    public final boolean isInterrupted() {
        return this.zzc == 14;
    }

    @androidx.annotation.RecentlyNonNull
    public final boolean isSuccess() {
        return this.zzc <= 0;
    }

    public final void startResolutionForResult(@androidx.annotation.RecentlyNonNull android.app.Activity activity, @androidx.annotation.RecentlyNonNull int i) throws android.content.IntentSender.SendIntentException {
        if (hasResolution()) {
            activity.startIntentSenderForResult(((android.app.PendingIntent) com.google.android.gms.common.internal.Preconditions.checkNotNull(this.zze)).getIntentSender(), i, null, 0, 0, 0);
        }
    }

    @androidx.annotation.RecentlyNonNull
    public final java.lang.String toString() {
        return com.google.android.gms.common.internal.Objects.toStringHelper(this).add(com.huawei.hms.support.hianalytics.HiAnalyticsConstant.HaKey.BI_KEY_RESULT, zza()).add("resolution", this.zze).toString();
    }

    @Override // android.os.Parcelable
    @com.google.android.gms.common.annotation.KeepForSdk
    public final void writeToParcel(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i) {
        int beginObjectHeader = com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.beginObjectHeader(parcel);
        com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.writeInt(parcel, 1, getStatusCode());
        com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.writeString(parcel, 2, getStatusMessage(), false);
        com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.writeParcelable(parcel, 3, this.zze, i, false);
        com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.writeParcelable(parcel, 4, getConnectionResult(), i, false);
        com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.writeInt(parcel, 1000, this.zzb);
        com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @androidx.annotation.RecentlyNonNull
    public final java.lang.String zza() {
        java.lang.String str = this.zzd;
        return str != null ? str : com.google.android.gms.common.api.CommonStatusCodes.getStatusCodeString(this.zzc);
    }
}
