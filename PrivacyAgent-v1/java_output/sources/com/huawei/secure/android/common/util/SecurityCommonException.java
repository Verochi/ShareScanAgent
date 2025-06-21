package com.huawei.secure.android.common.util;

/* loaded from: classes22.dex */
public class SecurityCommonException extends java.lang.Exception {
    private static final long c = 1;
    private java.lang.String a;
    private java.lang.String b;

    public SecurityCommonException() {
    }

    public SecurityCommonException(java.lang.String str) {
        super(str);
        this.b = str;
    }

    public SecurityCommonException(java.lang.String str, java.lang.String str2) {
        this.a = str;
        this.b = str2;
    }

    public SecurityCommonException(java.lang.String str, java.lang.Throwable th) {
        super(str, th);
    }

    public SecurityCommonException(java.lang.Throwable th) {
        super(th);
    }

    public java.lang.String getMsgDes() {
        return this.b;
    }

    public java.lang.String getRetCd() {
        return this.a;
    }
}
