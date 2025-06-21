package com.google.android.gms.common.api;

/* loaded from: classes22.dex */
public class ApiException extends java.lang.Exception {

    @androidx.annotation.RecentlyNonNull
    @java.lang.Deprecated
    protected final com.google.android.gms.common.api.Status mStatus;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ApiException(@androidx.annotation.RecentlyNonNull com.google.android.gms.common.api.Status status) {
        super(r3.toString());
        int statusCode = status.getStatusCode();
        java.lang.String statusMessage = status.getStatusMessage() != null ? status.getStatusMessage() : "";
        java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(statusMessage).length() + 13);
        sb.append(statusCode);
        sb.append(": ");
        sb.append(statusMessage);
        this.mStatus = status;
    }

    @androidx.annotation.NonNull
    public com.google.android.gms.common.api.Status getStatus() {
        return this.mStatus;
    }

    @androidx.annotation.RecentlyNonNull
    public int getStatusCode() {
        return this.mStatus.getStatusCode();
    }

    @androidx.annotation.RecentlyNullable
    @java.lang.Deprecated
    public java.lang.String getStatusMessage() {
        return this.mStatus.getStatusMessage();
    }
}
