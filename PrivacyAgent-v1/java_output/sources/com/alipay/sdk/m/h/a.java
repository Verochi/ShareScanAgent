package com.alipay.sdk.m.h;

/* loaded from: classes.dex */
public class a extends com.alipay.sdk.m.g.a {
    public static final /* synthetic */ boolean d = true;

    public a(byte[] bArr) {
        super(bArr);
    }

    public static com.alipay.sdk.m.h.a a(java.lang.String str, long j, com.alipay.sdk.m.h.b bVar, short s2, com.alipay.sdk.m.h.e eVar) throws java.lang.Exception {
        byte[] a = com.alipay.sdk.m.g.c.a((byte) 1);
        boolean z = d;
        if (!z && a.length != 1) {
            throw new java.lang.AssertionError();
        }
        byte[] a2 = com.alipay.sdk.m.g.c.a(str.charAt(0), str.charAt(1));
        if (!z && a2.length != 2) {
            throw new java.lang.AssertionError();
        }
        byte[] a3 = com.alipay.sdk.m.g.c.a(j);
        if (!z && a3.length != 8) {
            throw new java.lang.AssertionError();
        }
        byte[] b = com.alipay.sdk.m.g.c.b();
        if (!z && b.length != 2) {
            throw new java.lang.AssertionError();
        }
        bVar.a();
        byte[] a4 = com.alipay.sdk.m.g.c.a(bVar.a);
        if (!z && a4.length != 1) {
            throw new java.lang.AssertionError();
        }
        byte[] a5 = com.alipay.sdk.m.g.c.a(bVar.b);
        if (!z && a5.length != 1) {
            throw new java.lang.AssertionError();
        }
        byte[] bArr = (byte[]) bVar.c.clone();
        if (!z && bArr.length != (bVar.b & 255)) {
            throw new java.lang.AssertionError();
        }
        byte[] a6 = com.alipay.sdk.m.g.c.a(s2);
        if (!z && a6.length != 2) {
            throw new java.lang.AssertionError();
        }
        byte[] b2 = com.alipay.sdk.m.g.c.b();
        if (!z && b2.length != 2) {
            throw new java.lang.AssertionError();
        }
        eVar.a();
        byte[] a7 = com.alipay.sdk.m.g.c.a(eVar.a);
        if (!z && a7.length != 1) {
            throw new java.lang.AssertionError();
        }
        byte[] bArr2 = (byte[]) eVar.b.clone();
        if (!z && bArr2.length != (eVar.a & 255)) {
            throw new java.lang.AssertionError();
        }
        byte[] c = com.alipay.sdk.m.g.c.c();
        if (z || c.length == 4) {
            return new com.alipay.sdk.m.h.a(com.alipay.sdk.m.g.c.a(a, a2, a3, b, a4, a5, bArr, a6, b2, a7, bArr2, c));
        }
        throw new java.lang.AssertionError();
    }

    public static com.alipay.sdk.m.h.a c() {
        try {
            return a(com.alipay.sdk.m.g.a.c, 0L, new com.alipay.sdk.m.h.c(""), (short) 0, new com.alipay.sdk.m.h.f());
        } catch (java.lang.Exception unused) {
            return null;
        }
    }
}
