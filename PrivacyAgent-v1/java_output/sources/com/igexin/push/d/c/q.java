package com.igexin.push.d.c;

/* loaded from: classes23.dex */
public final class q extends com.igexin.push.d.c.c {
    public static final int a = 20;
    public int b;

    public q() {
        this.m = 20;
    }

    @Override // com.igexin.push.d.c.c
    public final void a(byte[] bArr) {
        if (bArr.length == 1) {
            this.b = bArr[0] & 255;
        }
    }

    @Override // com.igexin.push.d.c.c
    public final byte[] b() {
        return null;
    }
}
