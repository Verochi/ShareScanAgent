package com.huawei.hms.support.api.push;

/* loaded from: classes22.dex */
public class PushException extends java.lang.RuntimeException {
    public static final java.lang.String EXCEPTION_SEND_FAILED = "send message failed";

    public PushException() {
    }

    public PushException(java.lang.String str) {
        super(str);
    }

    public PushException(java.lang.String str, java.lang.Throwable th) {
        super(str, th);
    }

    public PushException(java.lang.Throwable th) {
        super(th);
    }
}
