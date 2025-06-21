package com.google.android.exoplayer2.util;

/* loaded from: classes22.dex */
public final class ParsableByteArray {
    public byte[] a;
    public int b;
    public int c;

    public ParsableByteArray() {
        this.a = com.google.android.exoplayer2.util.Util.EMPTY_BYTE_ARRAY;
    }

    public ParsableByteArray(int i) {
        this.a = new byte[i];
        this.c = i;
    }

    public ParsableByteArray(byte[] bArr) {
        this.a = bArr;
        this.c = bArr.length;
    }

    public ParsableByteArray(byte[] bArr, int i) {
        this.a = bArr;
        this.c = i;
    }

    public int bytesLeft() {
        return this.c - this.b;
    }

    public int capacity() {
        return this.a.length;
    }

    public byte[] getData() {
        return this.a;
    }

    public int getPosition() {
        return this.b;
    }

    public int limit() {
        return this.c;
    }

    public char peekChar() {
        byte[] bArr = this.a;
        int i = this.b;
        return (char) ((bArr[i + 1] & 255) | ((bArr[i] & 255) << 8));
    }

    public int peekUnsignedByte() {
        return this.a[this.b] & 255;
    }

    public void readBytes(com.google.android.exoplayer2.util.ParsableBitArray parsableBitArray, int i) {
        readBytes(parsableBitArray.data, 0, i);
        parsableBitArray.setPosition(0);
    }

    public void readBytes(java.nio.ByteBuffer byteBuffer, int i) {
        byteBuffer.put(this.a, this.b, i);
        this.b += i;
    }

    public void readBytes(byte[] bArr, int i, int i2) {
        java.lang.System.arraycopy(this.a, this.b, bArr, i, i2);
        this.b += i2;
    }

    public double readDouble() {
        return java.lang.Double.longBitsToDouble(readLong());
    }

    public float readFloat() {
        return java.lang.Float.intBitsToFloat(readInt());
    }

    public int readInt() {
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

    public int readInt24() {
        byte[] bArr = this.a;
        int i = this.b;
        int i2 = i + 1;
        int i3 = i2 + 1;
        int i4 = (((bArr[i] & 255) << 24) >> 8) | ((bArr[i2] & 255) << 8);
        this.b = i3 + 1;
        return (bArr[i3] & 255) | i4;
    }

    @androidx.annotation.Nullable
    public java.lang.String readLine() {
        if (bytesLeft() == 0) {
            return null;
        }
        int i = this.b;
        while (i < this.c && !com.google.android.exoplayer2.util.Util.isLinebreak(this.a[i])) {
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
        java.lang.String fromUtf8Bytes = com.google.android.exoplayer2.util.Util.fromUtf8Bytes(bArr2, i3, i - i3);
        this.b = i;
        int i4 = this.c;
        if (i == i4) {
            return fromUtf8Bytes;
        }
        byte[] bArr3 = this.a;
        if (bArr3[i] == 13) {
            int i5 = i + 1;
            this.b = i5;
            if (i5 == i4) {
                return fromUtf8Bytes;
            }
        }
        int i6 = this.b;
        if (bArr3[i6] == 10) {
            this.b = i6 + 1;
        }
        return fromUtf8Bytes;
    }

    public int readLittleEndianInt() {
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

    public int readLittleEndianInt24() {
        byte[] bArr = this.a;
        int i = this.b;
        int i2 = i + 1;
        int i3 = i2 + 1;
        int i4 = (bArr[i] & 255) | ((bArr[i2] & 255) << 8);
        this.b = i3 + 1;
        return ((bArr[i3] & 255) << 16) | i4;
    }

    public long readLittleEndianLong() {
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

    public short readLittleEndianShort() {
        byte[] bArr = this.a;
        int i = this.b;
        int i2 = i + 1;
        int i3 = bArr[i] & 255;
        this.b = i2 + 1;
        return (short) (((bArr[i2] & 255) << 8) | i3);
    }

    public long readLittleEndianUnsignedInt() {
        byte[] bArr = this.a;
        long j = bArr[r1] & 255;
        int i = this.b + 1 + 1 + 1;
        long j2 = j | ((bArr[r2] & 255) << 8) | ((bArr[r1] & 255) << 16);
        this.b = i + 1;
        return j2 | ((bArr[i] & 255) << 24);
    }

    public int readLittleEndianUnsignedInt24() {
        byte[] bArr = this.a;
        int i = this.b;
        int i2 = i + 1;
        int i3 = i2 + 1;
        int i4 = (bArr[i] & 255) | ((bArr[i2] & 255) << 8);
        this.b = i3 + 1;
        return ((bArr[i3] & 255) << 16) | i4;
    }

    public int readLittleEndianUnsignedIntToInt() {
        int readLittleEndianInt = readLittleEndianInt();
        if (readLittleEndianInt >= 0) {
            return readLittleEndianInt;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder(29);
        sb.append("Top bit not zero: ");
        sb.append(readLittleEndianInt);
        throw new java.lang.IllegalStateException(sb.toString());
    }

    public int readLittleEndianUnsignedShort() {
        byte[] bArr = this.a;
        int i = this.b;
        int i2 = i + 1;
        int i3 = bArr[i] & 255;
        this.b = i2 + 1;
        return ((bArr[i2] & 255) << 8) | i3;
    }

    public long readLong() {
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

    @androidx.annotation.Nullable
    public java.lang.String readNullTerminatedString() {
        if (bytesLeft() == 0) {
            return null;
        }
        int i = this.b;
        while (i < this.c && this.a[i] != 0) {
            i++;
        }
        byte[] bArr = this.a;
        int i2 = this.b;
        java.lang.String fromUtf8Bytes = com.google.android.exoplayer2.util.Util.fromUtf8Bytes(bArr, i2, i - i2);
        this.b = i;
        if (i < this.c) {
            this.b = i + 1;
        }
        return fromUtf8Bytes;
    }

    public java.lang.String readNullTerminatedString(int i) {
        if (i == 0) {
            return "";
        }
        int i2 = this.b;
        int i3 = (i2 + i) - 1;
        java.lang.String fromUtf8Bytes = com.google.android.exoplayer2.util.Util.fromUtf8Bytes(this.a, i2, (i3 >= this.c || this.a[i3] != 0) ? i : i - 1);
        this.b += i;
        return fromUtf8Bytes;
    }

    public short readShort() {
        byte[] bArr = this.a;
        int i = this.b;
        int i2 = i + 1;
        int i3 = (bArr[i] & 255) << 8;
        this.b = i2 + 1;
        return (short) ((bArr[i2] & 255) | i3);
    }

    public java.lang.String readString(int i) {
        return readString(i, com.google.common.base.Charsets.UTF_8);
    }

    public java.lang.String readString(int i, java.nio.charset.Charset charset) {
        java.lang.String str = new java.lang.String(this.a, this.b, i, charset);
        this.b += i;
        return str;
    }

    public int readSynchSafeInt() {
        return (readUnsignedByte() << 21) | (readUnsignedByte() << 14) | (readUnsignedByte() << 7) | readUnsignedByte();
    }

    public int readUnsignedByte() {
        byte[] bArr = this.a;
        int i = this.b;
        this.b = i + 1;
        return bArr[i] & 255;
    }

    public int readUnsignedFixedPoint1616() {
        byte[] bArr = this.a;
        int i = this.b;
        int i2 = i + 1;
        int i3 = (bArr[i2] & 255) | ((bArr[i] & 255) << 8);
        this.b = i2 + 1 + 2;
        return i3;
    }

    public long readUnsignedInt() {
        byte[] bArr = this.a;
        long j = (bArr[r1] & 255) << 24;
        int i = this.b + 1 + 1 + 1;
        long j2 = j | ((bArr[r2] & 255) << 16) | ((bArr[r1] & 255) << 8);
        this.b = i + 1;
        return j2 | (bArr[i] & 255);
    }

    public int readUnsignedInt24() {
        byte[] bArr = this.a;
        int i = this.b;
        int i2 = i + 1;
        int i3 = i2 + 1;
        int i4 = ((bArr[i] & 255) << 16) | ((bArr[i2] & 255) << 8);
        this.b = i3 + 1;
        return (bArr[i3] & 255) | i4;
    }

    public int readUnsignedIntToInt() {
        int readInt = readInt();
        if (readInt >= 0) {
            return readInt;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder(29);
        sb.append("Top bit not zero: ");
        sb.append(readInt);
        throw new java.lang.IllegalStateException(sb.toString());
    }

    public long readUnsignedLongToLong() {
        long readLong = readLong();
        if (readLong >= 0) {
            return readLong;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder(38);
        sb.append("Top bit not zero: ");
        sb.append(readLong);
        throw new java.lang.IllegalStateException(sb.toString());
    }

    public int readUnsignedShort() {
        byte[] bArr = this.a;
        int i = this.b;
        int i2 = i + 1;
        int i3 = (bArr[i] & 255) << 8;
        this.b = i2 + 1;
        return (bArr[i2] & 255) | i3;
    }

    public long readUtf8EncodedLong() {
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
            java.lang.StringBuilder sb = new java.lang.StringBuilder(55);
            sb.append("Invalid UTF-8 sequence first byte: ");
            sb.append(j);
            throw new java.lang.NumberFormatException(sb.toString());
        }
        for (i = 1; i < i2; i++) {
            if ((this.a[this.b + i] & 192) != 128) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder(62);
                sb2.append("Invalid UTF-8 sequence continuation byte: ");
                sb2.append(j);
                throw new java.lang.NumberFormatException(sb2.toString());
            }
            j = (j << 6) | (r3 & 63);
        }
        this.b += i2;
        return j;
    }

    public void reset(int i) {
        reset(capacity() < i ? new byte[i] : this.a, i);
    }

    public void reset(byte[] bArr) {
        reset(bArr, bArr.length);
    }

    public void reset(byte[] bArr, int i) {
        this.a = bArr;
        this.c = i;
        this.b = 0;
    }

    public void setLimit(int i) {
        com.google.android.exoplayer2.util.Assertions.checkArgument(i >= 0 && i <= this.a.length);
        this.c = i;
    }

    public void setPosition(int i) {
        com.google.android.exoplayer2.util.Assertions.checkArgument(i >= 0 && i <= this.c);
        this.b = i;
    }

    public void skipBytes(int i) {
        setPosition(this.b + i);
    }
}
