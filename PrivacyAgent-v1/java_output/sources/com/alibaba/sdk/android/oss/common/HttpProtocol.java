package com.alibaba.sdk.android.oss.common;

/* loaded from: classes.dex */
public enum HttpProtocol {
    HTTP(com.alipay.sdk.m.l.a.q),
    HTTPS("https");

    private final java.lang.String httpProtocol;

    HttpProtocol(java.lang.String str) {
        this.httpProtocol = str;
    }

    @Override // java.lang.Enum
    public java.lang.String toString() {
        return this.httpProtocol;
    }
}
