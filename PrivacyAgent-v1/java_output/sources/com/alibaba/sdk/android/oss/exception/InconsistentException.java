package com.alibaba.sdk.android.oss.exception;

/* loaded from: classes.dex */
public class InconsistentException extends java.io.IOException {
    private java.lang.Long clientChecksum;
    private java.lang.String requestId;
    private java.lang.Long serverChecksum;

    public InconsistentException(java.lang.Long l, java.lang.Long l2, java.lang.String str) {
        this.clientChecksum = l;
        this.serverChecksum = l2;
        this.requestId = str;
    }

    @Override // java.lang.Throwable
    public java.lang.String getMessage() {
        return "InconsistentException: inconsistent object\n[RequestId]: " + this.requestId + "\n[ClientChecksum]: " + this.clientChecksum + "\n[ServerChecksum]: " + this.serverChecksum;
    }
}
