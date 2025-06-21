package com.google.android.exoplayer2.util;

/* loaded from: classes22.dex */
public final class ParsableBitArray {
    public int a;
    public int b;
    public int c;
    public byte[] data;

    public ParsableBitArray() {
        this.data = com.google.android.exoplayer2.util.Util.EMPTY_BYTE_ARRAY;
    }

    public ParsableBitArray(byte[] bArr) {
        this(bArr, bArr.length);
    }

    public ParsableBitArray(byte[] bArr, int i) {
        this.data = bArr;
        this.c = i;
    }

    public final void a() {
        int i;
        int i2 = this.a;
        com.google.android.exoplayer2.util.Assertions.checkState(i2 >= 0 && (i2 < (i = this.c) || (i2 == i && this.b == 0)));
    }

    public int bitsLeft() {
        return ((this.c - this.a) * 8) - this.b;
    }

    public void byteAlign() {
        if (this.b == 0) {
            return;
        }
        this.b = 0;
        this.a++;
        a();
    }

    public int getBytePosition() {
        com.google.android.exoplayer2.util.Assertions.checkState(this.b == 0);
        return this.a;
    }

    public int getPosition() {
        return (this.a * 8) + this.b;
    }

    public void putInt(int i, int i2) {
        if (i2 < 32) {
            i &= (1 << i2) - 1;
        }
        int min = java.lang.Math.min(8 - this.b, i2);
        int i3 = this.b;
        int i4 = (8 - i3) - min;
        int i5 = (androidx.core.view.MotionEventCompat.ACTION_POINTER_INDEX_MASK >> i3) | ((1 << i4) - 1);
        byte[] bArr = this.data;
        int i6 = this.a;
        byte b = (byte) (i5 & bArr[i6]);
        bArr[i6] = b;
        int i7 = i2 - min;
        bArr[i6] = (byte) (b | ((i >>> i7) << i4));
        int i8 = i6 + 1;
        while (i7 > 8) {
            this.data[i8] = (byte) (i >>> (i7 - 8));
            i7 -= 8;
            i8++;
        }
        int i9 = 8 - i7;
        byte[] bArr2 = this.data;
        byte b2 = (byte) (bArr2[i8] & ((1 << i9) - 1));
        bArr2[i8] = b2;
        bArr2[i8] = (byte) (((i & ((1 << i7) - 1)) << i9) | b2);
        skipBits(i2);
        a();
    }

    public boolean readBit() {
        boolean z = (this.data[this.a] & (128 >> this.b)) != 0;
        skipBit();
        return z;
    }

    public int readBits(int i) {
        int i2;
        if (i == 0) {
            return 0;
        }
        this.b += i;
        int i3 = 0;
        while (true) {
            i2 = this.b;
            if (i2 <= 8) {
                break;
            }
            int i4 = i2 - 8;
            this.b = i4;
            byte[] bArr = this.data;
            int i5 = this.a;
            this.a = i5 + 1;
            i3 |= (bArr[i5] & 255) << i4;
        }
        byte[] bArr2 = this.data;
        int i6 = this.a;
        int i7 = ((-1) >>> (32 - i)) & (i3 | ((bArr2[i6] & 255) >> (8 - i2)));
        if (i2 == 8) {
            this.b = 0;
            this.a = i6 + 1;
        }
        a();
        return i7;
    }

    public void readBits(byte[] bArr, int i, int i2) {
        int i3 = (i2 >> 3) + i;
        while (i < i3) {
            byte[] bArr2 = this.data;
            int i4 = this.a;
            int i5 = i4 + 1;
            this.a = i5;
            byte b = bArr2[i4];
            int i6 = this.b;
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
        int i8 = this.b;
        if (i8 + i7 > 8) {
            byte[] bArr3 = this.data;
            int i9 = this.a;
            this.a = i9 + 1;
            bArr[i3] = (byte) (b3 | ((bArr3[i9] & 255) << i8));
            this.b = i8 - 8;
        }
        int i10 = this.b + i7;
        this.b = i10;
        byte[] bArr4 = this.data;
        int i11 = this.a;
        bArr[i3] = (byte) (((byte) (((255 & bArr4[i11]) >> (8 - i10)) << (8 - i7))) | bArr[i3]);
        if (i10 == 8) {
            this.b = 0;
            this.a = i11 + 1;
        }
        a();
    }

    public long readBitsToLong(int i) {
        return i <= 32 ? com.google.android.exoplayer2.util.Util.toUnsignedLong(readBits(i)) : com.google.android.exoplayer2.util.Util.toLong(readBits(i - 32), readBits(32));
    }

    public void readBytes(byte[] bArr, int i, int i2) {
        com.google.android.exoplayer2.util.Assertions.checkState(this.b == 0);
        java.lang.System.arraycopy(this.data, this.a, bArr, i, i2);
        this.a += i2;
        a();
    }

    public java.lang.String readBytesAsString(int i) {
        return readBytesAsString(i, com.google.common.base.Charsets.UTF_8);
    }

    public java.lang.String readBytesAsString(int i, java.nio.charset.Charset charset) {
        byte[] bArr = new byte[i];
        readBytes(bArr, 0, i);
        return new java.lang.String(bArr, charset);
    }

    public void reset(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        reset(parsableByteArray.getData(), parsableByteArray.limit());
        setPosition(parsableByteArray.getPosition() * 8);
    }

    public void reset(byte[] bArr) {
        reset(bArr, bArr.length);
    }

    public void reset(byte[] bArr, int i) {
        this.data = bArr;
        this.a = 0;
        this.b = 0;
        this.c = i;
    }

    public void setPosition(int i) {
        int i2 = i / 8;
        this.a = i2;
        this.b = i - (i2 * 8);
        a();
    }

    public void skipBit() {
        int i = this.b + 1;
        this.b = i;
        if (i == 8) {
            this.b = 0;
            this.a++;
        }
        a();
    }

    public void skipBits(int i) {
        int i2 = i / 8;
        int i3 = this.a + i2;
        this.a = i3;
        int i4 = this.b + (i - (i2 * 8));
        this.b = i4;
        if (i4 > 7) {
            this.a = i3 + 1;
            this.b = i4 - 8;
        }
        a();
    }

    public void skipBytes(int i) {
        com.google.android.exoplayer2.util.Assertions.checkState(this.b == 0);
        this.a += i;
        a();
    }
}
