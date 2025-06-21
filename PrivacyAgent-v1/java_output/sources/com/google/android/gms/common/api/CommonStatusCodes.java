package com.google.android.gms.common.api;

@com.google.android.gms.common.annotation.KeepForSdk
/* loaded from: classes22.dex */
public class CommonStatusCodes {

    @androidx.annotation.RecentlyNonNull
    public static final int API_NOT_CONNECTED = 17;

    @androidx.annotation.RecentlyNonNull
    public static final int CANCELED = 16;

    @androidx.annotation.RecentlyNonNull
    public static final int CONNECTION_SUSPENDED_DURING_CALL = 20;

    @androidx.annotation.RecentlyNonNull
    public static final int DEVELOPER_ERROR = 10;

    @androidx.annotation.RecentlyNonNull
    public static final int ERROR = 13;

    @androidx.annotation.RecentlyNonNull
    public static final int INTERNAL_ERROR = 8;

    @androidx.annotation.RecentlyNonNull
    public static final int INTERRUPTED = 14;

    @androidx.annotation.RecentlyNonNull
    public static final int INVALID_ACCOUNT = 5;

    @androidx.annotation.RecentlyNonNull
    public static final int NETWORK_ERROR = 7;

    @androidx.annotation.RecentlyNonNull
    public static final int RECONNECTION_TIMED_OUT = 22;

    @androidx.annotation.RecentlyNonNull
    public static final int RECONNECTION_TIMED_OUT_DURING_UPDATE = 21;

    @androidx.annotation.RecentlyNonNull
    public static final int REMOTE_EXCEPTION = 19;

    @androidx.annotation.RecentlyNonNull
    public static final int RESOLUTION_REQUIRED = 6;

    @androidx.annotation.RecentlyNonNull
    @java.lang.Deprecated
    public static final int SERVICE_DISABLED = 3;

    @androidx.annotation.RecentlyNonNull
    @java.lang.Deprecated
    public static final int SERVICE_VERSION_UPDATE_REQUIRED = 2;

    @androidx.annotation.RecentlyNonNull
    public static final int SIGN_IN_REQUIRED = 4;

    @androidx.annotation.RecentlyNonNull
    public static final int SUCCESS = 0;

    @androidx.annotation.RecentlyNonNull
    public static final int SUCCESS_CACHE = -1;

    @androidx.annotation.RecentlyNonNull
    public static final int TIMEOUT = 15;

    @com.google.android.gms.common.annotation.KeepForSdk
    public CommonStatusCodes() {
    }

    @androidx.annotation.NonNull
    public static java.lang.String getStatusCodeString(@androidx.annotation.RecentlyNonNull int i) {
        switch (i) {
            case -1:
                return "SUCCESS_CACHE";
            case 0:
                return com.alipay.sdk.m.f0.c.p;
            case 1:
            case 9:
            case 11:
            case 12:
            default:
                java.lang.StringBuilder sb = new java.lang.StringBuilder(32);
                sb.append("unknown status code: ");
                sb.append(i);
                return sb.toString();
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
            case 10:
                return "DEVELOPER_ERROR";
            case 13:
                return com.baidu.mobads.sdk.internal.bz.l;
            case 14:
                return "INTERRUPTED";
            case 15:
                return "TIMEOUT";
            case 16:
                return "CANCELED";
            case 17:
                return "API_NOT_CONNECTED";
            case 18:
                return "DEAD_CLIENT";
            case 19:
                return "REMOTE_EXCEPTION";
            case 20:
                return "CONNECTION_SUSPENDED_DURING_CALL";
            case 21:
                return "RECONNECTION_TIMED_OUT_DURING_UPDATE";
            case 22:
                return "RECONNECTION_TIMED_OUT";
        }
    }
}
