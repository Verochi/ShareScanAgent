package com.igexin.push.d.c;

/* loaded from: classes23.dex */
public final class l extends com.igexin.push.d.c.c {
    public static final int a = 36;
    public long b;

    public l() {
        this.m = 36;
        this.n = com.google.common.base.Ascii.DC4;
    }

    @Override // com.igexin.push.d.c.c
    public final void a(byte[] bArr) {
        this.b = com.igexin.c.a.b.g.d(bArr, 0);
    }

    @Override // com.igexin.push.d.c.c
    public final byte[] b() {
        byte[] bArr = new byte[8];
        com.igexin.c.a.b.g.a(this.b, bArr, 0);
        return bArr;
    }
}
