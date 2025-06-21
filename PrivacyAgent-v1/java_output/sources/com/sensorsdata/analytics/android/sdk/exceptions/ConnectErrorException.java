package com.sensorsdata.analytics.android.sdk.exceptions;

/* loaded from: classes19.dex */
public class ConnectErrorException extends java.lang.Exception {
    private int mRetryAfter;

    public ConnectErrorException(java.lang.String str) {
        super(str);
        this.mRetryAfter = 30000;
    }

    public ConnectErrorException(java.lang.String str, java.lang.String str2) {
        super(str);
        try {
            this.mRetryAfter = java.lang.Integer.parseInt(str2);
        } catch (java.lang.NumberFormatException unused) {
            this.mRetryAfter = 0;
        }
    }

    public ConnectErrorException(java.lang.Throwable th) {
        super(th);
    }

    public int getRetryAfter() {
        return this.mRetryAfter;
    }
}
