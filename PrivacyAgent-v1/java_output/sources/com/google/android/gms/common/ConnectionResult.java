package com.google.android.gms.common;

@com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class(creator = "ConnectionResultCreator")
/* loaded from: classes22.dex */
public final class ConnectionResult extends com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable {

    @androidx.annotation.RecentlyNonNull
    public static final int API_UNAVAILABLE = 16;

    @androidx.annotation.RecentlyNonNull
    public static final int CANCELED = 13;

    @androidx.annotation.RecentlyNonNull
    public static final int DEVELOPER_ERROR = 10;

    @androidx.annotation.RecentlyNonNull
    @java.lang.Deprecated
    public static final int DRIVE_EXTERNAL_STORAGE_REQUIRED = 1500;

    @androidx.annotation.RecentlyNonNull
    public static final int INTERNAL_ERROR = 8;

    @androidx.annotation.RecentlyNonNull
    public static final int INTERRUPTED = 15;

    @androidx.annotation.RecentlyNonNull
    public static final int INVALID_ACCOUNT = 5;

    @androidx.annotation.RecentlyNonNull
    public static final int LICENSE_CHECK_FAILED = 11;

    @androidx.annotation.RecentlyNonNull
    public static final int NETWORK_ERROR = 7;

    @androidx.annotation.RecentlyNonNull
    public static final int RESOLUTION_ACTIVITY_NOT_FOUND = 22;

    @androidx.annotation.RecentlyNonNull
    public static final int RESOLUTION_REQUIRED = 6;

    @androidx.annotation.RecentlyNonNull
    public static final int RESTRICTED_PROFILE = 20;

    @androidx.annotation.RecentlyNonNull
    public static final int SERVICE_DISABLED = 3;

    @androidx.annotation.RecentlyNonNull
    public static final int SERVICE_INVALID = 9;

    @androidx.annotation.RecentlyNonNull
    public static final int SERVICE_MISSING = 1;

    @androidx.annotation.RecentlyNonNull
    public static final int SERVICE_MISSING_PERMISSION = 19;

    @androidx.annotation.RecentlyNonNull
    public static final int SERVICE_UPDATING = 18;

    @androidx.annotation.RecentlyNonNull
    public static final int SERVICE_VERSION_UPDATE_REQUIRED = 2;

    @androidx.annotation.RecentlyNonNull
    public static final int SIGN_IN_FAILED = 17;

    @androidx.annotation.RecentlyNonNull
    public static final int SIGN_IN_REQUIRED = 4;

    @androidx.annotation.RecentlyNonNull
    public static final int SUCCESS = 0;

    @androidx.annotation.RecentlyNonNull
    public static final int TIMEOUT = 14;

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static final int UNKNOWN = -1;

    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField(id = 1)
    private final int zza;

    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field(getter = "getErrorCode", id = 2)
    private final int zzb;

    @androidx.annotation.Nullable
    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field(getter = "getResolution", id = 3)
    private final android.app.PendingIntent zzc;

    @androidx.annotation.Nullable
    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field(getter = "getErrorMessage", id = 4)
    private final java.lang.String zzd;

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.internal.ShowFirstParty
    @com.google.android.gms.common.annotation.KeepForSdk
    public static final com.google.android.gms.common.ConnectionResult RESULT_SUCCESS = new com.google.android.gms.common.ConnectionResult(0);

    @androidx.annotation.RecentlyNonNull
    public static final android.os.Parcelable.Creator<com.google.android.gms.common.ConnectionResult> CREATOR = new com.google.android.gms.common.zza();

    public ConnectionResult(@androidx.annotation.RecentlyNonNull int i) {
        this(i, null, null);
    }

    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor
    public ConnectionResult(@com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 1) int i, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 2) int i2, @androidx.annotation.Nullable @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 3) android.app.PendingIntent pendingIntent, @androidx.annotation.Nullable @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 4) java.lang.String str) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = pendingIntent;
        this.zzd = str;
    }

    public ConnectionResult(@androidx.annotation.RecentlyNonNull int i, @androidx.annotation.Nullable android.app.PendingIntent pendingIntent) {
        this(i, pendingIntent, null);
    }

    public ConnectionResult(@androidx.annotation.RecentlyNonNull int i, @androidx.annotation.Nullable android.app.PendingIntent pendingIntent, @androidx.annotation.Nullable java.lang.String str) {
        this(1, i, pendingIntent, str);
    }

    @androidx.annotation.NonNull
    public static java.lang.String zza(int i) {
        if (i == 99) {
            return "UNFINISHED";
        }
        if (i == 1500) {
            return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
        }
        switch (i) {
            case -1:
                return com.huawei.hms.framework.network.grs.GrsBaseInfo.CountryCodeSource.UNKNOWN;
            case 0:
                return com.alipay.sdk.m.f0.c.p;
            case 1:
                return "SERVICE_MISSING";
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return "DEVELOPER_ERROR";
            case 11:
                return "LICENSE_CHECK_FAILED";
            default:
                switch (i) {
                    case 13:
                        return "CANCELED";
                    case 14:
                        return "TIMEOUT";
                    case 15:
                        return "INTERRUPTED";
                    case 16:
                        return "API_UNAVAILABLE";
                    case 17:
                        return "SIGN_IN_FAILED";
                    case 18:
                        return "SERVICE_UPDATING";
                    case 19:
                        return "SERVICE_MISSING_PERMISSION";
                    case 20:
                        return "RESTRICTED_PROFILE";
                    case 21:
                        return "API_VERSION_UPDATE_REQUIRED";
                    case 22:
                        return "RESOLUTION_ACTIVITY_NOT_FOUND";
                    default:
                        java.lang.StringBuilder sb = new java.lang.StringBuilder(31);
                        sb.append("UNKNOWN_ERROR_CODE(");
                        sb.append(i);
                        sb.append(")");
                        return sb.toString();
                }
        }
    }

    @androidx.annotation.RecentlyNonNull
    public final boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof com.google.android.gms.common.ConnectionResult)) {
            return false;
        }
        com.google.android.gms.common.ConnectionResult connectionResult = (com.google.android.gms.common.ConnectionResult) obj;
        return this.zzb == connectionResult.zzb && com.google.android.gms.common.internal.Objects.equal(this.zzc, connectionResult.zzc) && com.google.android.gms.common.internal.Objects.equal(this.zzd, connectionResult.zzd);
    }

    @androidx.annotation.RecentlyNonNull
    public final int getErrorCode() {
        return this.zzb;
    }

    @androidx.annotation.RecentlyNullable
    public final java.lang.String getErrorMessage() {
        return this.zzd;
    }

    @androidx.annotation.RecentlyNullable
    public final android.app.PendingIntent getResolution() {
        return this.zzc;
    }

    @androidx.annotation.RecentlyNonNull
    public final boolean hasResolution() {
        return (this.zzb == 0 || this.zzc == null) ? false : true;
    }

    @androidx.annotation.RecentlyNonNull
    public final int hashCode() {
        return com.google.android.gms.common.internal.Objects.hashCode(java.lang.Integer.valueOf(this.zzb), this.zzc, this.zzd);
    }

    @androidx.annotation.RecentlyNonNull
    public final boolean isSuccess() {
        return this.zzb == 0;
    }

    public final void startResolutionForResult(@androidx.annotation.RecentlyNonNull android.app.Activity activity, @androidx.annotation.RecentlyNonNull int i) throws android.content.IntentSender.SendIntentException {
        if (hasResolution()) {
            activity.startIntentSenderForResult(((android.app.PendingIntent) com.google.android.gms.common.internal.Preconditions.checkNotNull(this.zzc)).getIntentSender(), i, null, 0, 0, 0);
        }
    }

    @androidx.annotation.RecentlyNonNull
    public final java.lang.String toString() {
        return com.google.android.gms.common.internal.Objects.toStringHelper(this).add(com.huawei.hms.support.hianalytics.HiAnalyticsConstant.HaKey.BI_KEY_RESULT, zza(this.zzb)).add("resolution", this.zzc).add("message", this.zzd).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i) {
        int beginObjectHeader = com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.beginObjectHeader(parcel);
        com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.writeInt(parcel, 1, this.zza);
        com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.writeInt(parcel, 2, getErrorCode());
        com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.writeParcelable(parcel, 3, getResolution(), i, false);
        com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.writeString(parcel, 4, getErrorMessage(), false);
        com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
