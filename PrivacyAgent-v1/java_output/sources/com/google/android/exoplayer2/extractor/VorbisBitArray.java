package com.google.android.exoplayer2.extractor;

/* loaded from: classes22.dex */
public final class VorbisBitArray {
    public final byte[] a;
    public final int b;
    public int c;
    public int d;

    public VorbisBitArray(byte[] bArr) {
        this.a = bArr;
        this.b = bArr.length;
    }

    public final void a() {
        int i;
        int i2 = this.c;
        com.google.android.exoplayer2.util.Assertions.checkState(i2 >= 0 && (i2 < (i = this.b) || (i2 == i && this.d == 0)));
    }

    public int bitsLeft() {
        return ((this.b - this.c) * 8) - this.d;
    }

    public int getPosition() {
        return (this.c * 8) + this.d;
    }

    public boolean readBit() {
        boolean z = (((this.a[this.c] & 255) >> this.d) & 1) == 1;
        skipBits(1);
        return z;
    }

    public int readBits(int i) {
        int i2 = this.c;
        int min = java.lang.Math.min(i, 8 - this.d);
        int i3 = i2 + 1;
        int i4 = ((this.a[i2] & 255) >> this.d) & (255 >> (8 - min));
        while (min < i) {
            i4 |= (this.a[i3] & 255) << min;
            min += 8;
            i3++;
        }
        int i5 = i4 & ((-1) >>> (32 - i));
        skipBits(i);
        return i5;
    }

    public void reset() {
        this.c = 0;
        this.d = 0;
    }

    public void setPosition(int i) {
        int i2 = i / 8;
        this.c = i2;
        this.d = i - (i2 * 8);
        a();
    }

    public void skipBits(int i) {
        int i2 = i / 8;
        int i3 = this.c + i2;
        this.c = i3;
        int i4 = this.d + (i - (i2 * 8));
        this.d = i4;
        if (i4 > 7) {
            this.c = i3 + 1;
            this.d = i4 - 8;
        }
        a();
    }
}
