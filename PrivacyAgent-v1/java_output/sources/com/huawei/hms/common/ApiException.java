package com.huawei.hms.common;

/* loaded from: classes22.dex */
public class ApiException extends java.lang.Exception {
    protected final com.huawei.hms.support.api.client.Status mStatus;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ApiException(com.huawei.hms.support.api.client.Status status) {
        super(r0.toString());
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(status.getStatusCode());
        sb.append(": ");
        sb.append(status.getStatusMessage() != null ? status.getStatusMessage() : "");
        this.mStatus = status;
    }

    public int getStatusCode() {
        return this.mStatus.getStatusCode();
    }

    @java.lang.Deprecated
    public java.lang.String getStatusMessage() {
        return this.mStatus.getStatusMessage();
    }
}
