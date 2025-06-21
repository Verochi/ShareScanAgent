package com.vivo.push.util;

/* loaded from: classes19.dex */
public class VivoPushException extends java.lang.Exception {
    public static final int REASON_CODE_ACCESS = 10000;
    private int mReasonCode;

    public VivoPushException(int i, java.lang.String str) {
        super(str);
        this.mReasonCode = i;
    }

    public VivoPushException(java.lang.String str) {
        this(10000, str);
    }

    public int getCode() {
        return this.mReasonCode;
    }
}
