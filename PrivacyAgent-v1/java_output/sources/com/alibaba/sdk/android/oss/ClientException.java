package com.alibaba.sdk.android.oss;

/* loaded from: classes.dex */
public class ClientException extends java.lang.Exception {
    private java.lang.Boolean canceled;

    public ClientException() {
        this.canceled = java.lang.Boolean.FALSE;
    }

    public ClientException(java.lang.String str) {
        super("[ErrorMessage]: " + str);
        this.canceled = java.lang.Boolean.FALSE;
    }

    public ClientException(java.lang.String str, java.lang.Throwable th) {
        this(str, th, java.lang.Boolean.FALSE);
    }

    public ClientException(java.lang.String str, java.lang.Throwable th, java.lang.Boolean bool) {
        super("[ErrorMessage]: " + str, th);
        this.canceled = bool;
        com.alibaba.sdk.android.oss.common.OSSLog.logThrowable2Local(this);
    }

    public ClientException(java.lang.Throwable th) {
        super(th);
        this.canceled = java.lang.Boolean.FALSE;
    }

    @Override // java.lang.Throwable
    public java.lang.String getMessage() {
        java.lang.String message = super.getMessage();
        if (getCause() == null) {
            return message;
        }
        return getCause().getMessage() + "\n" + message;
    }

    public java.lang.Boolean isCanceledException() {
        return this.canceled;
    }
}
