package com.alipay.android.phone.mrpc.core;

/* loaded from: classes.dex */
public final class p extends com.alipay.android.phone.mrpc.core.u {
    public int c;
    public java.lang.String d;
    public long e;
    public long f;
    public java.lang.String g;
    public com.alipay.android.phone.mrpc.core.HttpUrlHeader h;

    public p(com.alipay.android.phone.mrpc.core.HttpUrlHeader httpUrlHeader, int i, java.lang.String str, byte[] bArr) {
        this.h = httpUrlHeader;
        this.c = i;
        this.d = str;
        this.a = bArr;
    }

    public final com.alipay.android.phone.mrpc.core.HttpUrlHeader a() {
        return this.h;
    }

    public final void a(long j) {
        this.e = j;
    }

    public final void a(java.lang.String str) {
        this.g = str;
    }

    public final void b(long j) {
        this.f = j;
    }
}
