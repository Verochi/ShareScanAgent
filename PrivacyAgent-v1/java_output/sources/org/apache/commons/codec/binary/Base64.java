package org.apache.commons.codec.binary;

/* loaded from: classes24.dex */
public class Base64 extends org.apache.commons.codec.binary.BaseNCodec {
    public static final byte[] k = {13, 10};
    public static final byte[] l = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, org.apache.tools.tar.TarConstants.LF_GNUTYPE_LONGLINK, org.apache.tools.tar.TarConstants.LF_GNUTYPE_LONGNAME, 77, 78, 79, 80, 81, 82, org.apache.tools.tar.TarConstants.LF_GNUTYPE_SPARSE, 84, 85, 86, 87, org.apache.tools.tar.TarConstants.LF_PAX_EXTENDED_HEADER_UC, 89, 90, 97, 98, 99, 100, 101, 102, org.apache.tools.tar.TarConstants.LF_PAX_GLOBAL_EXTENDED_HEADER, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, org.apache.tools.tar.TarConstants.LF_PAX_EXTENDED_HEADER_LC, 121, 122, org.apache.tools.tar.TarConstants.LF_NORMAL, org.apache.tools.tar.TarConstants.LF_LINK, org.apache.tools.tar.TarConstants.LF_SYMLINK, org.apache.tools.tar.TarConstants.LF_CHR, org.apache.tools.tar.TarConstants.LF_BLK, org.apache.tools.tar.TarConstants.LF_DIR, org.apache.tools.tar.TarConstants.LF_FIFO, org.apache.tools.tar.TarConstants.LF_CONTIG, 56, 57, 43, 47};
    public static final byte[] m = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, org.apache.tools.tar.TarConstants.LF_GNUTYPE_LONGLINK, org.apache.tools.tar.TarConstants.LF_GNUTYPE_LONGNAME, 77, 78, 79, 80, 81, 82, org.apache.tools.tar.TarConstants.LF_GNUTYPE_SPARSE, 84, 85, 86, 87, org.apache.tools.tar.TarConstants.LF_PAX_EXTENDED_HEADER_UC, 89, 90, 97, 98, 99, 100, 101, 102, org.apache.tools.tar.TarConstants.LF_PAX_GLOBAL_EXTENDED_HEADER, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, org.apache.tools.tar.TarConstants.LF_PAX_EXTENDED_HEADER_LC, 121, 122, org.apache.tools.tar.TarConstants.LF_NORMAL, org.apache.tools.tar.TarConstants.LF_LINK, org.apache.tools.tar.TarConstants.LF_SYMLINK, org.apache.tools.tar.TarConstants.LF_CHR, org.apache.tools.tar.TarConstants.LF_BLK, org.apache.tools.tar.TarConstants.LF_DIR, org.apache.tools.tar.TarConstants.LF_FIFO, org.apache.tools.tar.TarConstants.LF_CONTIG, 56, 57, 45, 95};
    public static final byte[] n = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, 63, org.apache.tools.tar.TarConstants.LF_BLK, org.apache.tools.tar.TarConstants.LF_DIR, org.apache.tools.tar.TarConstants.LF_FIFO, org.apache.tools.tar.TarConstants.LF_CONTIG, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, com.google.common.base.Ascii.DC2, 19, com.google.common.base.Ascii.DC4, com.google.common.base.Ascii.NAK, com.google.common.base.Ascii.SYN, com.google.common.base.Ascii.ETB, com.google.common.base.Ascii.CAN, com.google.common.base.Ascii.EM, -1, -1, -1, -1, 63, -1, com.google.common.base.Ascii.SUB, com.google.common.base.Ascii.ESC, com.google.common.base.Ascii.FS, com.google.common.base.Ascii.GS, com.google.common.base.Ascii.RS, com.google.common.base.Ascii.US, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, org.apache.tools.tar.TarConstants.LF_NORMAL, org.apache.tools.tar.TarConstants.LF_LINK, org.apache.tools.tar.TarConstants.LF_SYMLINK, org.apache.tools.tar.TarConstants.LF_CHR};
    public final byte[] e;
    public final byte[] f;
    public final byte[] g;
    public final int h;
    public final int i;
    public int j;

    public Base64() {
        this(0);
    }

    public Base64(int i) {
        this(i, k);
    }

    public Base64(int i, byte[] bArr) {
        this(i, bArr, false);
    }

    public Base64(int i, byte[] bArr, boolean z) {
        super(3, 4, i, bArr == null ? 0 : bArr.length);
        this.f = n;
        if (bArr == null) {
            this.i = 4;
            this.g = null;
        } else {
            if (containsAlphabetOrPad(bArr)) {
                throw new java.lang.IllegalArgumentException("lineSeparator must not contain base64 characters: [" + org.apache.commons.codec.binary.StringUtils.newStringUtf8(bArr) + "]");
            }
            if (i > 0) {
                this.i = bArr.length + 4;
                byte[] bArr2 = new byte[bArr.length];
                this.g = bArr2;
                java.lang.System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            } else {
                this.i = 4;
                this.g = null;
            }
        }
        this.h = this.i - 1;
        this.e = z ? m : l;
    }

    public Base64(boolean z) {
        this(76, k, z);
    }

    public static byte[] decodeBase64(java.lang.String str) {
        return new org.apache.commons.codec.binary.Base64().decode(str);
    }

    public static byte[] decodeBase64(byte[] bArr) {
        return new org.apache.commons.codec.binary.Base64().decode(bArr);
    }

    public static java.math.BigInteger decodeInteger(byte[] bArr) {
        return new java.math.BigInteger(1, decodeBase64(bArr));
    }

    public static byte[] encodeBase64(byte[] bArr) {
        return encodeBase64(bArr, false);
    }

    public static byte[] encodeBase64(byte[] bArr, boolean z) {
        return encodeBase64(bArr, z, false);
    }

    public static byte[] encodeBase64(byte[] bArr, boolean z, boolean z2) {
        return encodeBase64(bArr, z, z2, Integer.MAX_VALUE);
    }

    public static byte[] encodeBase64(byte[] bArr, boolean z, boolean z2, int i) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        org.apache.commons.codec.binary.Base64 base64 = z ? new org.apache.commons.codec.binary.Base64(z2) : new org.apache.commons.codec.binary.Base64(0, k, z2);
        long encodedLength = base64.getEncodedLength(bArr);
        if (encodedLength <= i) {
            return base64.encode(bArr);
        }
        throw new java.lang.IllegalArgumentException("Input array too big, the output array would be bigger (" + encodedLength + ") than the specified maximum size of " + i);
    }

    public static byte[] encodeBase64Chunked(byte[] bArr) {
        return encodeBase64(bArr, true);
    }

    public static java.lang.String encodeBase64String(byte[] bArr) {
        return org.apache.commons.codec.binary.StringUtils.newStringUtf8(encodeBase64(bArr, false));
    }

    public static byte[] encodeBase64URLSafe(byte[] bArr) {
        return encodeBase64(bArr, false, true);
    }

    public static java.lang.String encodeBase64URLSafeString(byte[] bArr) {
        return org.apache.commons.codec.binary.StringUtils.newStringUtf8(encodeBase64(bArr, false, true));
    }

    public static byte[] encodeInteger(java.math.BigInteger bigInteger) {
        if (bigInteger != null) {
            return encodeBase64(h(bigInteger), false);
        }
        throw new java.lang.NullPointerException("encodeInteger called with null parameter");
    }

    public static byte[] h(java.math.BigInteger bigInteger) {
        int bitLength = ((bigInteger.bitLength() + 7) >> 3) << 3;
        byte[] byteArray = bigInteger.toByteArray();
        int i = 1;
        if (bigInteger.bitLength() % 8 != 0 && (bigInteger.bitLength() / 8) + 1 == bitLength / 8) {
            return byteArray;
        }
        int length = byteArray.length;
        if (bigInteger.bitLength() % 8 == 0) {
            length--;
        } else {
            i = 0;
        }
        int i2 = bitLength / 8;
        int i3 = i2 - length;
        byte[] bArr = new byte[i2];
        java.lang.System.arraycopy(byteArray, i, bArr, i3, length);
        return bArr;
    }

    public static boolean isArrayByteBase64(byte[] bArr) {
        return isBase64(bArr);
    }

    public static boolean isBase64(byte b) {
        if (b != 61) {
            if (b >= 0) {
                byte[] bArr = n;
                if (b >= bArr.length || bArr[b] == -1) {
                }
            }
            return false;
        }
        return true;
    }

    public static boolean isBase64(java.lang.String str) {
        return isBase64(org.apache.commons.codec.binary.StringUtils.getBytesUtf8(str));
    }

    public static boolean isBase64(byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            if (!isBase64(bArr[i]) && !org.apache.commons.codec.binary.BaseNCodec.isWhiteSpace(bArr[i])) {
                return false;
            }
        }
        return true;
    }

    @Override // org.apache.commons.codec.binary.BaseNCodec
    public void b(byte[] bArr, int i, int i2) {
        byte b;
        if (this.eof) {
            return;
        }
        if (i2 < 0) {
            this.eof = true;
        }
        int i3 = 0;
        while (true) {
            if (i3 >= i2) {
                break;
            }
            ensureBufferSize(this.h);
            int i4 = i + 1;
            byte b2 = bArr[i];
            if (b2 == 61) {
                this.eof = true;
                break;
            }
            if (b2 >= 0) {
                byte[] bArr2 = n;
                if (b2 < bArr2.length && (b = bArr2[b2]) >= 0) {
                    int i5 = (this.modulus + 1) % 4;
                    this.modulus = i5;
                    int i6 = (this.j << 6) + b;
                    this.j = i6;
                    if (i5 == 0) {
                        byte[] bArr3 = this.buffer;
                        int i7 = this.pos;
                        int i8 = i7 + 1;
                        bArr3[i7] = (byte) ((i6 >> 16) & 255);
                        int i9 = i8 + 1;
                        bArr3[i8] = (byte) ((i6 >> 8) & 255);
                        this.pos = i9 + 1;
                        bArr3[i9] = (byte) (i6 & 255);
                    }
                }
            }
            i3++;
            i = i4;
        }
        if (!this.eof || this.modulus == 0) {
            return;
        }
        ensureBufferSize(this.h);
        int i10 = this.modulus;
        if (i10 == 2) {
            int i11 = this.j >> 4;
            this.j = i11;
            byte[] bArr4 = this.buffer;
            int i12 = this.pos;
            this.pos = i12 + 1;
            bArr4[i12] = (byte) (i11 & 255);
            return;
        }
        if (i10 != 3) {
            return;
        }
        int i13 = this.j >> 2;
        this.j = i13;
        byte[] bArr5 = this.buffer;
        int i14 = this.pos;
        int i15 = i14 + 1;
        bArr5[i14] = (byte) ((i13 >> 8) & 255);
        this.pos = i15 + 1;
        bArr5[i15] = (byte) (i13 & 255);
    }

    @Override // org.apache.commons.codec.binary.BaseNCodec
    public void c(byte[] bArr, int i, int i2) {
        if (this.eof) {
            return;
        }
        if (i2 >= 0) {
            int i3 = 0;
            while (i3 < i2) {
                ensureBufferSize(this.i);
                int i4 = (this.modulus + 1) % 3;
                this.modulus = i4;
                int i5 = i + 1;
                int i6 = bArr[i];
                if (i6 < 0) {
                    i6 += 256;
                }
                int i7 = (this.j << 8) + i6;
                this.j = i7;
                if (i4 == 0) {
                    byte[] bArr2 = this.buffer;
                    int i8 = this.pos;
                    int i9 = i8 + 1;
                    byte[] bArr3 = this.e;
                    bArr2[i8] = bArr3[(i7 >> 18) & 63];
                    int i10 = i9 + 1;
                    bArr2[i9] = bArr3[(i7 >> 12) & 63];
                    int i11 = i10 + 1;
                    bArr2[i10] = bArr3[(i7 >> 6) & 63];
                    int i12 = i11 + 1;
                    this.pos = i12;
                    bArr2[i11] = bArr3[i7 & 63];
                    int i13 = this.currentLinePos + 4;
                    this.currentLinePos = i13;
                    int i14 = this.lineLength;
                    if (i14 > 0 && i14 <= i13) {
                        byte[] bArr4 = this.g;
                        java.lang.System.arraycopy(bArr4, 0, bArr2, i12, bArr4.length);
                        this.pos += this.g.length;
                        this.currentLinePos = 0;
                    }
                }
                i3++;
                i = i5;
            }
            return;
        }
        this.eof = true;
        if (this.modulus == 0 && this.lineLength == 0) {
            return;
        }
        ensureBufferSize(this.i);
        int i15 = this.pos;
        int i16 = this.modulus;
        if (i16 == 1) {
            byte[] bArr5 = this.buffer;
            int i17 = i15 + 1;
            byte[] bArr6 = this.e;
            int i18 = this.j;
            bArr5[i15] = bArr6[(i18 >> 2) & 63];
            int i19 = i17 + 1;
            this.pos = i19;
            bArr5[i17] = bArr6[(i18 << 4) & 63];
            if (bArr6 == l) {
                int i20 = i19 + 1;
                bArr5[i19] = 61;
                this.pos = i20 + 1;
                bArr5[i20] = 61;
            }
        } else if (i16 == 2) {
            byte[] bArr7 = this.buffer;
            int i21 = i15 + 1;
            byte[] bArr8 = this.e;
            int i22 = this.j;
            bArr7[i15] = bArr8[(i22 >> 10) & 63];
            int i23 = i21 + 1;
            bArr7[i21] = bArr8[(i22 >> 4) & 63];
            int i24 = i23 + 1;
            this.pos = i24;
            bArr7[i23] = bArr8[(i22 << 2) & 63];
            if (bArr8 == l) {
                this.pos = i24 + 1;
                bArr7[i24] = 61;
            }
        }
        int i25 = this.currentLinePos;
        int i26 = this.pos;
        int i27 = i25 + (i26 - i15);
        this.currentLinePos = i27;
        if (this.lineLength <= 0 || i27 <= 0) {
            return;
        }
        byte[] bArr9 = this.g;
        java.lang.System.arraycopy(bArr9, 0, this.buffer, i26, bArr9.length);
        this.pos += this.g.length;
    }

    @Override // org.apache.commons.codec.binary.BaseNCodec
    public boolean isInAlphabet(byte b) {
        if (b >= 0) {
            byte[] bArr = this.f;
            if (b < bArr.length && bArr[b] != -1) {
                return true;
            }
        }
        return false;
    }

    public boolean isUrlSafe() {
        return this.e == m;
    }
}
