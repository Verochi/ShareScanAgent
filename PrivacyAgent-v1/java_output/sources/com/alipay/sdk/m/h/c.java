package com.alipay.sdk.m.h;

/* loaded from: classes.dex */
public final class c extends com.alipay.sdk.m.h.b {
    public final java.lang.String f;

    public c(java.lang.String str) {
        this.f = str;
    }

    @Override // com.alipay.sdk.m.h.b
    public void a() throws java.lang.Exception {
        this.a = (byte) 1;
        byte[] bytes = this.f.getBytes("UTF-8");
        this.c = bytes;
        this.b = (byte) bytes.length;
    }
}
