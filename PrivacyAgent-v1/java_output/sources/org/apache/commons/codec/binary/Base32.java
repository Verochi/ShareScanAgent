package org.apache.commons.codec.binary;

/* loaded from: classes24.dex */
public class Base32 extends org.apache.commons.codec.binary.BaseNCodec {
    public static final byte[] k = {13, 10};
    public static final byte[] l = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 63, -1, -1, com.google.common.base.Ascii.SUB, com.google.common.base.Ascii.ESC, com.google.common.base.Ascii.FS, com.google.common.base.Ascii.GS, com.google.common.base.Ascii.RS, com.google.common.base.Ascii.US, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, com.google.common.base.Ascii.DC2, 19, com.google.common.base.Ascii.DC4, com.google.common.base.Ascii.NAK, com.google.common.base.Ascii.SYN, com.google.common.base.Ascii.ETB, com.google.common.base.Ascii.CAN, com.google.common.base.Ascii.EM};
    public static final byte[] m = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, org.apache.tools.tar.TarConstants.LF_GNUTYPE_LONGLINK, org.apache.tools.tar.TarConstants.LF_GNUTYPE_LONGNAME, 77, 78, 79, 80, 81, 82, org.apache.tools.tar.TarConstants.LF_GNUTYPE_SPARSE, 84, 85, 86, 87, org.apache.tools.tar.TarConstants.LF_PAX_EXTENDED_HEADER_UC, 89, 90, org.apache.tools.tar.TarConstants.LF_SYMLINK, org.apache.tools.tar.TarConstants.LF_CHR, org.apache.tools.tar.TarConstants.LF_BLK, org.apache.tools.tar.TarConstants.LF_DIR, org.apache.tools.tar.TarConstants.LF_FIFO, org.apache.tools.tar.TarConstants.LF_CONTIG};
    public static final byte[] n = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 63, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, -1, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, com.google.common.base.Ascii.DC2, 19, com.google.common.base.Ascii.DC4, com.google.common.base.Ascii.NAK, com.google.common.base.Ascii.SYN, com.google.common.base.Ascii.ETB, com.google.common.base.Ascii.CAN, com.google.common.base.Ascii.EM, com.google.common.base.Ascii.SUB, com.google.common.base.Ascii.ESC, com.google.common.base.Ascii.FS, com.google.common.base.Ascii.GS, com.google.common.base.Ascii.RS, com.google.common.base.Ascii.US, 32};
    public static final byte[] o = {org.apache.tools.tar.TarConstants.LF_NORMAL, org.apache.tools.tar.TarConstants.LF_LINK, org.apache.tools.tar.TarConstants.LF_SYMLINK, org.apache.tools.tar.TarConstants.LF_CHR, org.apache.tools.tar.TarConstants.LF_BLK, org.apache.tools.tar.TarConstants.LF_DIR, org.apache.tools.tar.TarConstants.LF_FIFO, org.apache.tools.tar.TarConstants.LF_CONTIG, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, org.apache.tools.tar.TarConstants.LF_GNUTYPE_LONGLINK, org.apache.tools.tar.TarConstants.LF_GNUTYPE_LONGNAME, 77, 78, 79, 80, 81, 82, org.apache.tools.tar.TarConstants.LF_GNUTYPE_SPARSE, 84, 85, 86};
    public long e;
    public final int f;
    public final byte[] g;
    public final int h;
    public final byte[] i;
    public final byte[] j;

    public Base32() {
        this(false);
    }

    public Base32(int i) {
        this(i, k);
    }

    public Base32(int i, byte[] bArr) {
        this(i, bArr, false);
    }

    public Base32(int i, byte[] bArr, boolean z) {
        super(5, 8, i, bArr == null ? 0 : bArr.length);
        if (z) {
            this.i = o;
            this.g = n;
        } else {
            this.i = m;
            this.g = l;
        }
        if (i <= 0) {
            this.h = 8;
            this.j = null;
        } else {
            if (bArr == null) {
                throw new java.lang.IllegalArgumentException("lineLength " + i + " > 0, but lineSeparator is null");
            }
            if (containsAlphabetOrPad(bArr)) {
                throw new java.lang.IllegalArgumentException("lineSeparator must not contain Base32 characters: [" + org.apache.commons.codec.binary.StringUtils.newStringUtf8(bArr) + "]");
            }
            this.h = bArr.length + 8;
            byte[] bArr2 = new byte[bArr.length];
            this.j = bArr2;
            java.lang.System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        }
        this.f = this.h - 1;
    }

    public Base32(boolean z) {
        this(0, null, z);
    }

    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v2, types: [boolean, int] */
    @Override // org.apache.commons.codec.binary.BaseNCodec
    public void b(byte[] bArr, int i, int i2) {
        byte b;
        if (this.eof) {
        }
        ?? r2 = 1;
        if (i2 < 0) {
            this.eof = true;
        }
        int i3 = i;
        int i4 = 0;
        while (true) {
            if (i4 >= i2) {
                break;
            }
            int i5 = i3 + 1;
            byte b2 = bArr[i3];
            if (b2 == 61) {
                this.eof = r2;
                break;
            }
            ensureBufferSize(this.f);
            if (b2 >= 0) {
                byte[] bArr2 = this.g;
                if (b2 < bArr2.length && (b = bArr2[b2]) >= 0) {
                    int i6 = (this.modulus + r2) % 8;
                    this.modulus = i6;
                    this.e = (this.e << 5) + b;
                    if (i6 == 0) {
                        byte[] bArr3 = this.buffer;
                        int i7 = this.pos;
                        int i8 = i7 + 1;
                        bArr3[i7] = (byte) ((r12 >> 32) & 255);
                        int i9 = i8 + 1;
                        bArr3[i8] = (byte) ((r12 >> 24) & 255);
                        int i10 = i9 + 1;
                        bArr3[i9] = (byte) ((r12 >> 16) & 255);
                        int i11 = i10 + 1;
                        bArr3[i10] = (byte) ((r12 >> 8) & 255);
                        this.pos = i11 + 1;
                        bArr3[i11] = (byte) (r12 & 255);
                    }
                }
            }
            i4++;
            i3 = i5;
            r2 = 1;
        }
        if (!this.eof || this.modulus < 2) {
            return;
        }
        ensureBufferSize(this.f);
        switch (this.modulus) {
            case 2:
                byte[] bArr4 = this.buffer;
                int i12 = this.pos;
                this.pos = i12 + 1;
                bArr4[i12] = (byte) ((this.e >> 2) & 255);
                break;
            case 3:
                byte[] bArr5 = this.buffer;
                int i13 = this.pos;
                this.pos = i13 + 1;
                bArr5[i13] = (byte) ((this.e >> 7) & 255);
                break;
            case 4:
                this.e = this.e >> 4;
                byte[] bArr6 = this.buffer;
                int i14 = this.pos;
                int i15 = i14 + 1;
                bArr6[i14] = (byte) ((r1 >> 8) & 255);
                this.pos = i15 + 1;
                bArr6[i15] = (byte) (r1 & 255);
                break;
            case 5:
                this.e = this.e >> 1;
                byte[] bArr7 = this.buffer;
                int i16 = this.pos;
                int i17 = i16 + 1;
                bArr7[i16] = (byte) ((r1 >> 16) & 255);
                int i18 = i17 + 1;
                bArr7[i17] = (byte) ((r1 >> 8) & 255);
                this.pos = i18 + 1;
                bArr7[i18] = (byte) (r1 & 255);
                break;
            case 6:
                this.e = this.e >> 6;
                byte[] bArr8 = this.buffer;
                int i19 = this.pos;
                int i20 = i19 + 1;
                bArr8[i19] = (byte) ((r1 >> 16) & 255);
                int i21 = i20 + 1;
                bArr8[i20] = (byte) ((r1 >> 8) & 255);
                this.pos = i21 + 1;
                bArr8[i21] = (byte) (r1 & 255);
                break;
            case 7:
                this.e = this.e >> 3;
                byte[] bArr9 = this.buffer;
                int i22 = this.pos;
                int i23 = i22 + 1;
                bArr9[i22] = (byte) ((r1 >> 24) & 255);
                int i24 = i23 + 1;
                bArr9[i23] = (byte) ((r1 >> 16) & 255);
                int i25 = i24 + 1;
                bArr9[i24] = (byte) ((r1 >> 8) & 255);
                this.pos = i25 + 1;
                bArr9[i25] = (byte) (r1 & 255);
                break;
        }
    }

    @Override // org.apache.commons.codec.binary.BaseNCodec
    public void c(byte[] bArr, int i, int i2) {
        if (this.eof) {
            return;
        }
        if (i2 >= 0) {
            int i3 = i;
            int i4 = 0;
            while (i4 < i2) {
                ensureBufferSize(this.h);
                int i5 = (this.modulus + 1) % 5;
                this.modulus = i5;
                int i6 = i3 + 1;
                int i7 = bArr[i3];
                if (i7 < 0) {
                    i7 += 256;
                }
                long j = (this.e << 8) + i7;
                this.e = j;
                if (i5 == 0) {
                    byte[] bArr2 = this.buffer;
                    int i8 = this.pos;
                    int i9 = i8 + 1;
                    byte[] bArr3 = this.i;
                    bArr2[i8] = bArr3[((int) (j >> 35)) & 31];
                    int i10 = i9 + 1;
                    bArr2[i9] = bArr3[((int) (j >> 30)) & 31];
                    int i11 = i10 + 1;
                    bArr2[i10] = bArr3[((int) (j >> 25)) & 31];
                    int i12 = i11 + 1;
                    bArr2[i11] = bArr3[((int) (j >> 20)) & 31];
                    int i13 = i12 + 1;
                    bArr2[i12] = bArr3[((int) (j >> 15)) & 31];
                    int i14 = i13 + 1;
                    bArr2[i13] = bArr3[((int) (j >> 10)) & 31];
                    int i15 = i14 + 1;
                    bArr2[i14] = bArr3[((int) (j >> 5)) & 31];
                    int i16 = i15 + 1;
                    this.pos = i16;
                    bArr2[i15] = bArr3[((int) j) & 31];
                    int i17 = this.currentLinePos + 8;
                    this.currentLinePos = i17;
                    int i18 = this.lineLength;
                    if (i18 > 0 && i18 <= i17) {
                        byte[] bArr4 = this.j;
                        java.lang.System.arraycopy(bArr4, 0, bArr2, i16, bArr4.length);
                        this.pos += this.j.length;
                        this.currentLinePos = 0;
                    }
                }
                i4++;
                i3 = i6;
            }
            return;
        }
        this.eof = true;
        if (this.modulus == 0 && this.lineLength == 0) {
            return;
        }
        ensureBufferSize(this.h);
        int i19 = this.pos;
        int i20 = this.modulus;
        if (i20 == 1) {
            byte[] bArr5 = this.buffer;
            int i21 = i19 + 1;
            byte[] bArr6 = this.i;
            long j2 = this.e;
            bArr5[i19] = bArr6[((int) (j2 >> 3)) & 31];
            int i22 = i21 + 1;
            bArr5[i21] = bArr6[((int) (j2 << 2)) & 31];
            int i23 = i22 + 1;
            bArr5[i22] = 61;
            int i24 = i23 + 1;
            bArr5[i23] = 61;
            int i25 = i24 + 1;
            bArr5[i24] = 61;
            int i26 = i25 + 1;
            bArr5[i25] = 61;
            int i27 = i26 + 1;
            bArr5[i26] = 61;
            this.pos = i27 + 1;
            bArr5[i27] = 61;
        } else if (i20 == 2) {
            byte[] bArr7 = this.buffer;
            int i28 = i19 + 1;
            byte[] bArr8 = this.i;
            long j3 = this.e;
            bArr7[i19] = bArr8[((int) (j3 >> 11)) & 31];
            int i29 = i28 + 1;
            bArr7[i28] = bArr8[((int) (j3 >> 6)) & 31];
            int i30 = i29 + 1;
            bArr7[i29] = bArr8[((int) (j3 >> 1)) & 31];
            int i31 = i30 + 1;
            bArr7[i30] = bArr8[((int) (j3 << 4)) & 31];
            int i32 = i31 + 1;
            bArr7[i31] = 61;
            int i33 = i32 + 1;
            bArr7[i32] = 61;
            int i34 = i33 + 1;
            bArr7[i33] = 61;
            this.pos = i34 + 1;
            bArr7[i34] = 61;
        } else if (i20 == 3) {
            byte[] bArr9 = this.buffer;
            int i35 = i19 + 1;
            byte[] bArr10 = this.i;
            long j4 = this.e;
            bArr9[i19] = bArr10[((int) (j4 >> 19)) & 31];
            int i36 = i35 + 1;
            bArr9[i35] = bArr10[((int) (j4 >> 14)) & 31];
            int i37 = i36 + 1;
            bArr9[i36] = bArr10[((int) (j4 >> 9)) & 31];
            int i38 = i37 + 1;
            bArr9[i37] = bArr10[((int) (j4 >> 4)) & 31];
            int i39 = i38 + 1;
            bArr9[i38] = bArr10[((int) (j4 << 1)) & 31];
            int i40 = i39 + 1;
            bArr9[i39] = 61;
            int i41 = i40 + 1;
            bArr9[i40] = 61;
            this.pos = i41 + 1;
            bArr9[i41] = 61;
        } else if (i20 == 4) {
            byte[] bArr11 = this.buffer;
            int i42 = i19 + 1;
            byte[] bArr12 = this.i;
            long j5 = this.e;
            bArr11[i19] = bArr12[((int) (j5 >> 27)) & 31];
            int i43 = i42 + 1;
            bArr11[i42] = bArr12[((int) (j5 >> 22)) & 31];
            int i44 = i43 + 1;
            bArr11[i43] = bArr12[((int) (j5 >> 17)) & 31];
            int i45 = i44 + 1;
            bArr11[i44] = bArr12[((int) (j5 >> 12)) & 31];
            int i46 = i45 + 1;
            bArr11[i45] = bArr12[((int) (j5 >> 7)) & 31];
            int i47 = i46 + 1;
            bArr11[i46] = bArr12[((int) (j5 >> 2)) & 31];
            int i48 = i47 + 1;
            bArr11[i47] = bArr12[((int) (j5 << 3)) & 31];
            this.pos = i48 + 1;
            bArr11[i48] = 61;
        }
        int i49 = this.currentLinePos;
        int i50 = this.pos;
        int i51 = i49 + (i50 - i19);
        this.currentLinePos = i51;
        if (this.lineLength <= 0 || i51 <= 0) {
            return;
        }
        byte[] bArr13 = this.j;
        java.lang.System.arraycopy(bArr13, 0, this.buffer, i50, bArr13.length);
        this.pos += this.j.length;
    }

    @Override // org.apache.commons.codec.binary.BaseNCodec
    public boolean isInAlphabet(byte b) {
        if (b >= 0) {
            byte[] bArr = this.g;
            if (b < bArr.length && bArr[b] != -1) {
                return true;
            }
        }
        return false;
    }
}
