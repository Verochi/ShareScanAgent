package com.anythink.expressad.exoplayer.k;

/* loaded from: classes12.dex */
public final class s {
    public byte[] a;
    private int b;
    private int c;

    public s() {
    }

    public s(int i) {
        this.a = new byte[i];
        this.c = i;
    }

    public s(byte[] bArr) {
        this.a = bArr;
        this.c = bArr.length;
    }

    public s(byte[] bArr, int i) {
        this.a = bArr;
        this.c = i;
    }

    private int A() {
        byte[] bArr = this.a;
        int i = this.b;
        int i2 = i + 1;
        int i3 = i2 + 1;
        int i4 = (bArr[i] & 255) | ((bArr[i2] & 255) << 8);
        int i5 = i3 + 1;
        int i6 = i4 | ((bArr[i3] & 255) << 16);
        this.b = i5 + 1;
        return ((bArr[i5] & 255) << 24) | i6;
    }

    private long B() {
        byte[] bArr = this.a;
        long j = bArr[r1] & 255;
        int i = this.b + 1 + 1 + 1;
        long j2 = j | ((bArr[r2] & 255) << 8) | ((bArr[r1] & 255) << 16);
        long j3 = j2 | ((bArr[i] & 255) << 24);
        long j4 = j3 | ((bArr[r3] & 255) << 32);
        long j5 = j4 | ((bArr[r4] & 255) << 40);
        long j6 = j5 | ((bArr[r3] & 255) << 48);
        this.b = i + 1 + 1 + 1 + 1 + 1;
        return j6 | ((bArr[r4] & 255) << 56);
    }

    private int C() {
        byte[] bArr = this.a;
        int i = this.b;
        int i2 = i + 1;
        int i3 = i2 + 1;
        int i4 = (bArr[i] & 255) | ((bArr[i2] & 255) << 8);
        int i5 = i3 + 1;
        int i6 = i4 | ((bArr[i3] & 255) << 16);
        this.b = i5 + 1;
        int i7 = ((bArr[i5] & 255) << 24) | i6;
        if (i7 >= 0) {
            return i7;
        }
        throw new java.lang.IllegalStateException("Top bit not zero: ".concat(java.lang.String.valueOf(i7)));
    }

    private float D() {
        return java.lang.Float.intBitsToFloat(i());
    }

    private double E() {
        return java.lang.Double.longBitsToDouble(j());
    }

    private java.lang.String F() {
        if (a() == 0) {
            return null;
        }
        int i = this.b;
        while (i < this.c && !com.anythink.expressad.exoplayer.k.af.a((int) this.a[i])) {
            i++;
        }
        int i2 = this.b;
        if (i - i2 >= 3) {
            byte[] bArr = this.a;
            if (bArr[i2] == -17 && bArr[i2 + 1] == -69 && bArr[i2 + 2] == -65) {
                this.b = i2 + 3;
            }
        }
        byte[] bArr2 = this.a;
        int i3 = this.b;
        java.lang.String a = com.anythink.expressad.exoplayer.k.af.a(bArr2, i3, i - i3);
        this.b = i;
        int i4 = this.c;
        if (i == i4) {
            return a;
        }
        byte[] bArr3 = this.a;
        if (bArr3[i] == 13) {
            int i5 = i + 1;
            this.b = i5;
            if (i5 == i4) {
                return a;
            }
        }
        int i6 = this.b;
        if (bArr3[i6] == 10) {
            this.b = i6 + 1;
        }
        return a;
    }

    private long G() {
        int i;
        int i2;
        long j = this.a[this.b];
        int i3 = 7;
        while (true) {
            if (i3 < 0) {
                break;
            }
            if (((1 << i3) & j) != 0) {
                i3--;
            } else if (i3 < 6) {
                j &= r6 - 1;
                i2 = 7 - i3;
            } else if (i3 == 7) {
                i2 = 1;
            }
        }
        i2 = 0;
        if (i2 == 0) {
            throw new java.lang.NumberFormatException("Invalid UTF-8 sequence first byte: ".concat(java.lang.String.valueOf(j)));
        }
        for (i = 1; i < i2; i++) {
            if ((this.a[this.b + i] & 192) != 128) {
                throw new java.lang.NumberFormatException("Invalid UTF-8 sequence continuation byte: ".concat(java.lang.String.valueOf(j)));
            }
            j = (j << 6) | (r3 & 63);
        }
        this.b += i2;
        return j;
    }

    private java.lang.String a(java.nio.charset.Charset charset) {
        java.lang.String str = new java.lang.String(this.a, this.b, 4, charset);
        this.b += 4;
        return str;
    }

    private void a(com.anythink.expressad.exoplayer.k.r rVar, int i) {
        a(rVar.a, 0, i);
        rVar.a(0);
    }

    private void a(java.nio.ByteBuffer byteBuffer, int i) {
        byteBuffer.put(this.a, this.b, i);
        this.b += i;
    }

    private void q() {
        this.b = 0;
        this.c = 0;
    }

    private int r() {
        byte[] bArr = this.a;
        if (bArr == null) {
            return 0;
        }
        return bArr.length;
    }

    private int s() {
        return this.a[this.b] & 255;
    }

    private char t() {
        byte[] bArr = this.a;
        int i = this.b;
        return (char) ((bArr[i + 1] & 255) | ((bArr[i] & 255) << 8));
    }

    private int u() {
        byte[] bArr = this.a;
        int i = this.b;
        int i2 = i + 1;
        int i3 = bArr[i] & 255;
        this.b = i2 + 1;
        return ((bArr[i2] & 255) << 8) | i3;
    }

    private short v() {
        byte[] bArr = this.a;
        int i = this.b;
        int i2 = i + 1;
        int i3 = bArr[i] & 255;
        this.b = i2 + 1;
        return (short) (((bArr[i2] & 255) << 8) | i3);
    }

    private int w() {
        byte[] bArr = this.a;
        int i = this.b;
        int i2 = i + 1;
        int i3 = i2 + 1;
        int i4 = (((bArr[i] & 255) << 24) >> 8) | ((bArr[i2] & 255) << 8);
        this.b = i3 + 1;
        return (bArr[i3] & 255) | i4;
    }

    private int x() {
        byte[] bArr = this.a;
        int i = this.b;
        int i2 = i + 1;
        int i3 = i2 + 1;
        int i4 = (bArr[i] & 255) | ((bArr[i2] & 255) << 8);
        this.b = i3 + 1;
        return ((bArr[i3] & 255) << 16) | i4;
    }

    private int y() {
        byte[] bArr = this.a;
        int i = this.b;
        int i2 = i + 1;
        int i3 = i2 + 1;
        int i4 = (bArr[i] & 255) | ((bArr[i2] & 255) << 8);
        this.b = i3 + 1;
        return ((bArr[i3] & 255) << 16) | i4;
    }

    private long z() {
        byte[] bArr = this.a;
        long j = bArr[r1] & 255;
        int i = this.b + 1 + 1 + 1;
        long j2 = j | ((bArr[r2] & 255) << 8) | ((bArr[r1] & 255) << 16);
        this.b = i + 1;
        return j2 | ((bArr[i] & 255) << 24);
    }

    public final int a() {
        return this.c - this.b;
    }

    public final void a(int i) {
        byte[] bArr = this.a;
        if ((bArr == null ? 0 : bArr.length) < i) {
            bArr = new byte[i];
        }
        a(bArr, i);
    }

    public final void a(byte[] bArr, int i) {
        this.a = bArr;
        this.c = i;
        this.b = 0;
    }

    public final void a(byte[] bArr, int i, int i2) {
        java.lang.System.arraycopy(this.a, this.b, bArr, i, i2);
        this.b += i2;
    }

    public final int b() {
        return this.c;
    }

    public final void b(int i) {
        com.anythink.expressad.exoplayer.k.a.a(i >= 0 && i <= this.a.length);
        this.c = i;
    }

    public final int c() {
        return this.b;
    }

    public final void c(int i) {
        com.anythink.expressad.exoplayer.k.a.a(i >= 0 && i <= this.c);
        this.b = i;
    }

    public final int d() {
        byte[] bArr = this.a;
        int i = this.b;
        this.b = i + 1;
        return bArr[i] & 255;
    }

    public final void d(int i) {
        c(this.b + i);
    }

    public final int e() {
        byte[] bArr = this.a;
        int i = this.b;
        int i2 = i + 1;
        int i3 = (bArr[i] & 255) << 8;
        this.b = i2 + 1;
        return (bArr[i2] & 255) | i3;
    }

    public final java.lang.String e(int i) {
        if (i == 0) {
            return "";
        }
        int i2 = this.b;
        int i3 = (i2 + i) - 1;
        java.lang.String a = com.anythink.expressad.exoplayer.k.af.a(this.a, i2, (i3 >= this.c || this.a[i3] != 0) ? i : i - 1);
        this.b += i;
        return a;
    }

    public final short f() {
        byte[] bArr = this.a;
        int i = this.b;
        int i2 = i + 1;
        int i3 = (bArr[i] & 255) << 8;
        this.b = i2 + 1;
        return (short) ((bArr[i2] & 255) | i3);
    }

    public final int g() {
        byte[] bArr = this.a;
        int i = this.b;
        int i2 = i + 1;
        int i3 = i2 + 1;
        int i4 = ((bArr[i] & 255) << 16) | ((bArr[i2] & 255) << 8);
        this.b = i3 + 1;
        return (bArr[i3] & 255) | i4;
    }

    public final long h() {
        byte[] bArr = this.a;
        long j = (bArr[r1] & 255) << 24;
        int i = this.b + 1 + 1 + 1;
        long j2 = j | ((bArr[r2] & 255) << 16) | ((bArr[r1] & 255) << 8);
        this.b = i + 1;
        return j2 | (bArr[i] & 255);
    }

    public final int i() {
        byte[] bArr = this.a;
        int i = this.b;
        int i2 = i + 1;
        int i3 = i2 + 1;
        int i4 = ((bArr[i] & 255) << 24) | ((bArr[i2] & 255) << 16);
        int i5 = i3 + 1;
        int i6 = i4 | ((bArr[i3] & 255) << 8);
        this.b = i5 + 1;
        return (bArr[i5] & 255) | i6;
    }

    public final long j() {
        byte[] bArr = this.a;
        long j = (bArr[r1] & 255) << 56;
        int i = this.b + 1 + 1 + 1;
        long j2 = j | ((bArr[r2] & 255) << 48) | ((bArr[r1] & 255) << 40);
        long j3 = j2 | ((bArr[i] & 255) << 32);
        long j4 = j3 | ((bArr[r3] & 255) << 24);
        long j5 = j4 | ((bArr[r4] & 255) << 16);
        long j6 = j5 | ((bArr[r3] & 255) << 8);
        this.b = i + 1 + 1 + 1 + 1 + 1;
        return j6 | (bArr[r4] & 255);
    }

    public final int k() {
        byte[] bArr = this.a;
        int i = this.b;
        int i2 = i + 1;
        int i3 = (bArr[i2] & 255) | ((bArr[i] & 255) << 8);
        this.b = i2 + 1 + 2;
        return i3;
    }

    public final int l() {
        return (d() << 21) | (d() << 14) | (d() << 7) | d();
    }

    public final int m() {
        int i = i();
        if (i >= 0) {
            return i;
        }
        throw new java.lang.IllegalStateException("Top bit not zero: ".concat(java.lang.String.valueOf(i)));
    }

    public final long n() {
        long j = j();
        if (j >= 0) {
            return j;
        }
        throw new java.lang.IllegalStateException("Top bit not zero: ".concat(java.lang.String.valueOf(j)));
    }

    public final java.lang.String o() {
        java.lang.String str = new java.lang.String(this.a, this.b, 4, java.nio.charset.Charset.forName("UTF-8"));
        this.b += 4;
        return str;
    }

    public final java.lang.String p() {
        if (a() == 0) {
            return null;
        }
        int i = this.b;
        while (i < this.c && this.a[i] != 0) {
            i++;
        }
        byte[] bArr = this.a;
        int i2 = this.b;
        java.lang.String a = com.anythink.expressad.exoplayer.k.af.a(bArr, i2, i - i2);
        this.b = i;
        if (i < this.c) {
            this.b = i + 1;
        }
        return a;
    }
}
