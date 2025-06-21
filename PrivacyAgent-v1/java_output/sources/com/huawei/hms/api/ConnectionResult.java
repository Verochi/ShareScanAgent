package com.huawei.hms.api;

/* loaded from: classes22.dex */
public final class ConnectionResult implements android.os.Parcelable {
    public static final int API_UNAVAILABLE = 1000;
    public static final int BINDFAIL_RESOLUTION_BACKGROUND = 7;
    public static final int BINDFAIL_RESOLUTION_REQUIRED = 6;
    public static final int CANCELED = 13;
    public static final android.os.Parcelable.Creator<com.huawei.hms.api.ConnectionResult> CREATOR = new com.huawei.hms.api.ConnectionResult.a();
    public static final int DEVELOPER_ERROR = 10;
    public static final int DRIVE_EXTERNAL_STORAGE_REQUIRED = 9002;
    public static final int INTERNAL_ERROR = 8;
    public static final int INTERRUPTED = 15;
    public static final int INVALID_ACCOUNT = 5;
    public static final int LICENSE_CHECK_FAILED = 11;
    public static final int NETWORK_ERROR = 9000;
    public static final int RESOLUTION_REQUIRED = 9001;
    public static final int RESTRICTED_PROFILE = 9003;
    public static final int SERVICE_DISABLED = 3;
    public static final int SERVICE_INVALID = 9;
    public static final int SERVICE_MISSING = 1;
    public static final int SERVICE_MISSING_PERMISSION = 19;
    public static final int SERVICE_UNSUPPORTED = 21;
    public static final int SERVICE_UPDATING = 9004;
    public static final int SERVICE_VERSION_UPDATE_REQUIRED = 2;
    public static final int SIGN_IN_FAILED = 9005;
    public static final int SIGN_IN_REQUIRED = 4;
    public static final int SUCCESS = 0;
    public static final int TIMEOUT = 14;
    private int apiVersion;
    private int connectionErrorCode;
    private java.lang.String connectionErrorMessage;
    private android.app.PendingIntent pendingIntent;

    public static class a implements android.os.Parcelable.Creator<com.huawei.hms.api.ConnectionResult> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.huawei.hms.api.ConnectionResult createFromParcel(android.os.Parcel parcel) {
            return new com.huawei.hms.api.ConnectionResult(parcel, (com.huawei.hms.api.ConnectionResult.a) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.huawei.hms.api.ConnectionResult[] newArray(int i) {
            return new com.huawei.hms.api.ConnectionResult[i];
        }
    }

    public ConnectionResult(int i) {
        this(i, (android.app.PendingIntent) null);
    }

    public ConnectionResult(int i, int i2, android.app.PendingIntent pendingIntent, java.lang.String str) {
        this.apiVersion = i;
        this.connectionErrorCode = i2;
        this.pendingIntent = pendingIntent;
        this.connectionErrorMessage = str;
    }

    public ConnectionResult(int i, android.app.PendingIntent pendingIntent) {
        this(i, pendingIntent, null);
    }

    public ConnectionResult(int i, android.app.PendingIntent pendingIntent, java.lang.String str) {
        this(1, i, pendingIntent, str);
    }

    private ConnectionResult(android.os.Parcel parcel) {
        this.apiVersion = 1;
        this.pendingIntent = null;
        this.connectionErrorMessage = null;
        this.apiVersion = parcel.readInt();
        this.connectionErrorCode = parcel.readInt();
        this.connectionErrorMessage = parcel.readString();
        android.os.Parcelable parcelable = (android.os.Parcelable) android.app.PendingIntent.CREATOR.createFromParcel(parcel);
        if (parcelable != null) {
            this.pendingIntent = (android.app.PendingIntent) parcelable;
        }
    }

    public /* synthetic */ ConnectionResult(android.os.Parcel parcel, com.huawei.hms.api.ConnectionResult.a aVar) {
        this(parcel);
    }

    public static java.lang.String getErrorString(int i) {
        if (i == -1) {
            return com.huawei.hms.framework.network.grs.GrsBaseInfo.CountryCodeSource.UNKNOWN;
        }
        if (i == 0) {
            return com.alipay.sdk.m.f0.c.p;
        }
        if (i == 1) {
            return "SERVICE_MISSING";
        }
        if (i == 2) {
            return "SERVICE_VERSION_UPDATE_REQUIRED";
        }
        if (i == 3) {
            return "SERVICE_DISABLED";
        }
        if (i == 13) {
            return "CANCELED";
        }
        if (i == 14) {
            return "TIMEOUT";
        }
        if (i == 19) {
            return "SERVICE_MISSING_PERMISSION";
        }
        if (i == 21) {
            return "API_VERSION_UPDATE_REQUIRED";
        }
        switch (i) {
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
                return "UNKNOWN_ERROR_CODE(" + i + ")";
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        try {
            if ((obj instanceof com.huawei.hms.api.ConnectionResult) && this.apiVersion == ((com.huawei.hms.api.ConnectionResult) obj).apiVersion && this.connectionErrorCode == ((com.huawei.hms.api.ConnectionResult) obj).connectionErrorCode && this.connectionErrorMessage.equals(((com.huawei.hms.api.ConnectionResult) obj).connectionErrorMessage)) {
                if (this.pendingIntent.equals(((com.huawei.hms.api.ConnectionResult) obj).pendingIntent)) {
                    return true;
                }
            }
            return false;
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    public int getErrorCode() {
        return this.connectionErrorCode;
    }

    public final java.lang.String getErrorMessage() {
        return this.connectionErrorMessage;
    }

    public final android.app.PendingIntent getResolution() {
        return this.pendingIntent;
    }

    public final boolean hasResolution() {
        return com.huawei.hms.api.HuaweiApiAvailability.getInstance().isUserResolvableError(this.connectionErrorCode, this.pendingIntent);
    }

    public int hashCode() {
        return com.huawei.hms.common.internal.Objects.hashCode(java.lang.Long.valueOf(this.apiVersion), java.lang.Long.valueOf(getErrorCode()), getErrorMessage(), this.pendingIntent);
    }

    public final boolean isSuccess() {
        return this.connectionErrorCode == 0;
    }

    public final void startResolutionForResult(android.app.Activity activity, int i) throws android.content.IntentSender.SendIntentException {
        if (hasResolution()) {
            com.huawei.hms.api.HuaweiApiAvailability.getInstance().resolveError(activity, this.connectionErrorCode, i, this.pendingIntent);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeInt(this.apiVersion);
        parcel.writeInt(this.connectionErrorCode);
        parcel.writeString(this.connectionErrorMessage);
        this.pendingIntent.writeToParcel(parcel, i);
    }
}
