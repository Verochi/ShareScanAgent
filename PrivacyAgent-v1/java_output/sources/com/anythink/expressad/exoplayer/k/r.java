package com.anythink.expressad.exoplayer.k;

/* loaded from: classes12.dex */
public final class r {
    public byte[] a;
    private int b;
    private int c;
    private int d;

    public r() {
    }

    public r(byte[] bArr) {
        this(bArr, bArr.length);
    }

    private r(byte[] bArr, int i) {
        this.a = bArr;
        this.d = i;
    }

    private void a(com.anythink.expressad.exoplayer.k.s sVar) {
        a(sVar.a, sVar.b());
        a(sVar.c() * 8);
    }

    private void a(byte[] bArr) {
        a(bArr, bArr.length);
    }

    private void a(byte[] bArr, int i, int i2) {
        int i3 = (i2 >> 3) + i;
        while (i < i3) {
            byte[] bArr2 = this.a;
            int i4 = this.b;
            int i5 = i4 + 1;
            this.b = i5;
            byte b = bArr2[i4];
            int i6 = this.c;
            byte b2 = (byte) (b << i6);
            bArr[i] = b2;
            bArr[i] = (byte) (((255 & bArr2[i5]) >> (8 - i6)) | b2);
            i++;
        }
        int i7 = i2 & 7;
        if (i7 == 0) {
            return;
        }
        byte b3 = (byte) (bArr[i3] & (255 >> i7));
        bArr[i3] = b3;
        int i8 = this.c;
        if (i8 + i7 > 8) {
            byte[] bArr3 = this.a;
            int i9 = this.b;
            this.b = i9 + 1;
            bArr[i3] = (byte) (b3 | ((bArr3[i9] & 255) << i8));
            this.c = i8 - 8;
        }
        int i10 = this.c + i7;
        this.c = i10;
        byte[] bArr4 = this.a;
        int i11 = this.b;
        bArr[i3] = (byte) (((byte) (((255 & bArr4[i11]) >> (8 - i10)) << (8 - i7))) | bArr[i3]);
        if (i10 == 8) {
            this.c = 0;
            this.b = i11 + 1;
        }
        g();
    }

    private void b(byte[] bArr, int i, int i2) {
        com.anythink.expressad.exoplayer.k.a.b(this.c == 0);
        java.lang.System.arraycopy(this.a, this.b, bArr, i, i2);
        this.b += i2;
        g();
    }

    private void e(int i) {
        com.anythink.expressad.exoplayer.k.a.b(this.c == 0);
        this.b += i;
        g();
    }

    private int f() {
        com.anythink.expressad.exoplayer.k.a.b(this.c == 0);
        return this.b;
    }

    private void g() {
        int i;
        int i2 = this.b;
        com.anythink.expressad.exoplayer.k.a.b(i2 >= 0 && (i2 < (i = this.d) || (i2 == i && this.c == 0)));
    }

    public final int a() {
        return ((this.d - this.b) * 8) - this.c;
    }

    public final void a(int i) {
        int i2 = i / 8;
        this.b = i2;
        this.c = i - (i2 * 8);
        g();
    }

    public final void a(byte[] bArr, int i) {
        this.a = bArr;
        this.b = 0;
        this.c = 0;
        this.d = i;
    }

    public final int b() {
        return (this.b * 8) + this.c;
    }

    public final void b(int i) {
        int i2 = i / 8;
        int i3 = this.b + i2;
        this.b = i3;
        int i4 = this.c + (i - (i2 * 8));
        this.c = i4;
        if (i4 > 7) {
            this.b = i3 + 1;
            this.c = i4 - 8;
        }
        g();
    }

    public final int c(int i) {
        int i2;
        if (i == 0) {
            return 0;
        }
        this.c += i;
        int i3 = 0;
        while (true) {
            i2 = this.c;
            if (i2 <= 8) {
                break;
            }
            int i4 = i2 - 8;
            this.c = i4;
            byte[] bArr = this.a;
            int i5 = this.b;
            this.b = i5 + 1;
            i3 |= (bArr[i5] & 255) << i4;
        }
        byte[] bArr2 = this.a;
        int i6 = this.b;
        int i7 = ((-1) >>> (32 - i)) & (i3 | ((bArr2[i6] & 255) >> (8 - i2)));
        if (i2 == 8) {
            this.c = 0;
            this.b = i6 + 1;
        }
        g();
        return i7;
    }

    public final void c() {
        int i = this.c + 1;
        this.c = i;
        if (i == 8) {
            this.c = 0;
            this.b++;
        }
        g();
    }

    public final void d(int i) {
        int i2 = i & 16383;
        int min = java.lang.Math.min(8 - this.c, 14);
        int i3 = this.c;
        int i4 = (8 - i3) - min;
        int i5 = (androidx.core.view.MotionEventCompat.ACTION_POINTER_INDEX_MASK >> i3) | ((1 << i4) - 1);
        byte[] bArr = this.a;
        int i6 = this.b;
        byte b = (byte) (i5 & bArr[i6]);
        bArr[i6] = b;
        int i7 = 14 - min;
        bArr[i6] = (byte) (b | ((i2 >>> i7) << i4));
        int i8 = i6 + 1;
        while (i7 > 8) {
            this.a[i8] = (byte) (i2 >>> (i7 - 8));
            i7 -= 8;
            i8++;
        }
        int i9 = 8 - i7;
        byte[] bArr2 = this.a;
        byte b2 = (byte) (bArr2[i8] & ((1 << i9) - 1));
        bArr2[i8] = b2;
        bArr2[i8] = (byte) (((i2 & ((1 << i7) - 1)) << i9) | b2);
        b(14);
        g();
    }

    public final boolean d() {
        boolean z = (this.a[this.b] & (128 >> this.c)) != 0;
        c();
        return z;
    }

    public final void e() {
        if (this.c == 0) {
            return;
        }
        this.c = 0;
        this.b++;
        g();
    }
}
