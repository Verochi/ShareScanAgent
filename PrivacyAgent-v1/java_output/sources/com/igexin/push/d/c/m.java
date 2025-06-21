package com.igexin.push.d.c;

/* loaded from: classes23.dex */
public final class m extends com.igexin.push.d.c.c {
    public static final int a = 37;
    public boolean b;
    public boolean c;
    public java.lang.String d;
    public java.lang.String e;
    public long f;

    public m() {
        this.m = 37;
    }

    @Override // com.igexin.push.d.c.c, com.igexin.c.a.d.a.a
    public final void a() {
        this.e = null;
        this.d = null;
        this.f = 0L;
    }

    @Override // com.igexin.push.d.c.c
    public final void a(byte[] bArr) {
        byte b = bArr[0];
        int i = 1;
        this.b = (b & com.google.common.primitives.SignedBytes.MAX_POWER_OF_TWO) != 0;
        boolean z = (b & 128) != 0;
        this.c = z;
        if (z) {
            this.d = com.igexin.push.d.c.c.a(b);
            int b2 = com.igexin.c.a.b.g.b(bArr, 1);
            i = 1 + b2 + 2;
            try {
                this.e = new java.lang.String(bArr, 3, b2, this.d);
            } catch (java.lang.Exception e) {
                com.igexin.c.a.c.a.a(e);
            }
        }
        if (bArr.length > i) {
            this.f = com.igexin.c.a.b.g.d(bArr, i);
        }
    }

    @Override // com.igexin.push.d.c.c
    public final byte[] b() {
        int i;
        int i2;
        byte b = this.b ? com.google.common.primitives.SignedBytes.MAX_POWER_OF_TWO : (byte) 0;
        int i3 = 1;
        byte[] bArr = null;
        if (this.c) {
            byte b2 = (byte) (b | 128);
            try {
                bArr = this.e.getBytes(this.d);
                i = bArr.length;
                i2 = i + 3;
            } catch (java.lang.Exception e) {
                com.igexin.c.a.c.a.a(e);
                i2 = 3;
                i = 0;
            }
            b = (byte) (b2 | com.igexin.push.d.c.c.a(this.d));
        } else {
            i = 0;
            i2 = 1;
        }
        byte[] bArr2 = new byte[i2 + 8];
        bArr2[0] = b;
        if (this.c) {
            i3 = com.igexin.c.a.b.g.b(i, bArr2, 1);
            if (bArr != null) {
                i3 = com.igexin.c.a.b.g.a(bArr, bArr2, 2, i) + 2;
            }
        }
        com.igexin.c.a.b.g.a(this.f, bArr2, i3);
        return bArr2;
    }
}
