package com.google.android.exoplayer2.util;

/* loaded from: classes22.dex */
public final class ParsableNalUnitBitArray {
    public byte[] a;
    public int b;
    public int c;
    public int d;

    public ParsableNalUnitBitArray(byte[] bArr, int i, int i2) {
        reset(bArr, i, i2);
    }

    public final void a() {
        int i;
        int i2 = this.c;
        com.google.android.exoplayer2.util.Assertions.checkState(i2 >= 0 && (i2 < (i = this.b) || (i2 == i && this.d == 0)));
    }

    public final int b() {
        int i = 0;
        while (!readBit()) {
            i++;
        }
        return ((1 << i) - 1) + (i > 0 ? readBits(i) : 0);
    }

    public final boolean c(int i) {
        if (2 <= i && i < this.b) {
            byte[] bArr = this.a;
            if (bArr[i] == 3 && bArr[i - 2] == 0 && bArr[i - 1] == 0) {
                return true;
            }
        }
        return false;
    }

    public boolean canReadBits(int i) {
        int i2 = this.c;
        int i3 = i / 8;
        int i4 = i2 + i3;
        int i5 = (this.d + i) - (i3 * 8);
        if (i5 > 7) {
            i4++;
            i5 -= 8;
        }
        while (true) {
            i2++;
            if (i2 > i4 || i4 >= this.b) {
                break;
            }
            if (c(i2)) {
                i4++;
                i2 += 2;
            }
        }
        int i6 = this.b;
        if (i4 >= i6) {
            return i4 == i6 && i5 == 0;
        }
        return true;
    }

    public boolean canReadExpGolombCodedNum() {
        int i = this.c;
        int i2 = this.d;
        int i3 = 0;
        while (this.c < this.b && !readBit()) {
            i3++;
        }
        boolean z = this.c == this.b;
        this.c = i;
        this.d = i2;
        return !z && canReadBits((i3 * 2) + 1);
    }

    public boolean readBit() {
        boolean z = (this.a[this.c] & (128 >> this.d)) != 0;
        skipBit();
        return z;
    }

    public int readBits(int i) {
        int i2;
        this.d += i;
        int i3 = 0;
        while (true) {
            i2 = this.d;
            if (i2 <= 8) {
                break;
            }
            int i4 = i2 - 8;
            this.d = i4;
            byte[] bArr = this.a;
            int i5 = this.c;
            i3 |= (bArr[i5] & 255) << i4;
            if (!c(i5 + 1)) {
                r3 = 1;
            }
            this.c = i5 + r3;
        }
        byte[] bArr2 = this.a;
        int i6 = this.c;
        int i7 = ((-1) >>> (32 - i)) & (i3 | ((bArr2[i6] & 255) >> (8 - i2)));
        if (i2 == 8) {
            this.d = 0;
            this.c = i6 + (c(i6 + 1) ? 2 : 1);
        }
        a();
        return i7;
    }

    public int readSignedExpGolombCodedInt() {
        int b = b();
        return (b % 2 == 0 ? -1 : 1) * ((b + 1) / 2);
    }

    public int readUnsignedExpGolombCodedInt() {
        return b();
    }

    public void reset(byte[] bArr, int i, int i2) {
        this.a = bArr;
        this.c = i;
        this.b = i2;
        this.d = 0;
        a();
    }

    public void skipBit() {
        int i = this.d + 1;
        this.d = i;
        if (i == 8) {
            this.d = 0;
            int i2 = this.c;
            this.c = i2 + (c(i2 + 1) ? 2 : 1);
        }
        a();
    }

    public void skipBits(int i) {
        int i2 = this.c;
        int i3 = i / 8;
        int i4 = i2 + i3;
        this.c = i4;
        int i5 = this.d + (i - (i3 * 8));
        this.d = i5;
        if (i5 > 7) {
            this.c = i4 + 1;
            this.d = i5 - 8;
        }
        while (true) {
            i2++;
            if (i2 > this.c) {
                a();
                return;
            } else if (c(i2)) {
                this.c++;
                i2 += 2;
            }
        }
    }
}
