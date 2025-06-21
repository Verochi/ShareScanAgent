package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public class fm {
    static final /* synthetic */ boolean a = true;
    private static final byte[] b = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, org.apache.tools.tar.TarConstants.LF_GNUTYPE_LONGLINK, org.apache.tools.tar.TarConstants.LF_GNUTYPE_LONGNAME, 77, 78, 79, 80, 81, 82, org.apache.tools.tar.TarConstants.LF_GNUTYPE_SPARSE, 84, 85, 86, 87, org.apache.tools.tar.TarConstants.LF_PAX_EXTENDED_HEADER_UC, 89, 90, 97, 98, 99, 100, 101, 102, org.apache.tools.tar.TarConstants.LF_PAX_GLOBAL_EXTENDED_HEADER, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, org.apache.tools.tar.TarConstants.LF_PAX_EXTENDED_HEADER_LC, 121, 122, org.apache.tools.tar.TarConstants.LF_NORMAL, org.apache.tools.tar.TarConstants.LF_LINK, org.apache.tools.tar.TarConstants.LF_SYMLINK, org.apache.tools.tar.TarConstants.LF_CHR, org.apache.tools.tar.TarConstants.LF_BLK, org.apache.tools.tar.TarConstants.LF_DIR, org.apache.tools.tar.TarConstants.LF_FIFO, org.apache.tools.tar.TarConstants.LF_CONTIG, 56, 57, 43, 47};
    private static final byte[] c = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, org.apache.tools.tar.TarConstants.LF_BLK, org.apache.tools.tar.TarConstants.LF_DIR, org.apache.tools.tar.TarConstants.LF_FIFO, org.apache.tools.tar.TarConstants.LF_CONTIG, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, com.google.common.base.Ascii.DC2, 19, com.google.common.base.Ascii.DC4, com.google.common.base.Ascii.NAK, com.google.common.base.Ascii.SYN, com.google.common.base.Ascii.ETB, com.google.common.base.Ascii.CAN, com.google.common.base.Ascii.EM, -9, -9, -9, -9, -9, -9, com.google.common.base.Ascii.SUB, com.google.common.base.Ascii.ESC, com.google.common.base.Ascii.FS, com.google.common.base.Ascii.GS, com.google.common.base.Ascii.RS, com.google.common.base.Ascii.US, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, org.apache.tools.tar.TarConstants.LF_NORMAL, org.apache.tools.tar.TarConstants.LF_LINK, org.apache.tools.tar.TarConstants.LF_SYMLINK, org.apache.tools.tar.TarConstants.LF_CHR, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
    private static final byte[] d = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, org.apache.tools.tar.TarConstants.LF_GNUTYPE_LONGLINK, org.apache.tools.tar.TarConstants.LF_GNUTYPE_LONGNAME, 77, 78, 79, 80, 81, 82, org.apache.tools.tar.TarConstants.LF_GNUTYPE_SPARSE, 84, 85, 86, 87, org.apache.tools.tar.TarConstants.LF_PAX_EXTENDED_HEADER_UC, 89, 90, 97, 98, 99, 100, 101, 102, org.apache.tools.tar.TarConstants.LF_PAX_GLOBAL_EXTENDED_HEADER, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, org.apache.tools.tar.TarConstants.LF_PAX_EXTENDED_HEADER_LC, 121, 122, org.apache.tools.tar.TarConstants.LF_NORMAL, org.apache.tools.tar.TarConstants.LF_LINK, org.apache.tools.tar.TarConstants.LF_SYMLINK, org.apache.tools.tar.TarConstants.LF_CHR, org.apache.tools.tar.TarConstants.LF_BLK, org.apache.tools.tar.TarConstants.LF_DIR, org.apache.tools.tar.TarConstants.LF_FIFO, org.apache.tools.tar.TarConstants.LF_CONTIG, 56, 57, 45, 95};
    private static final byte[] e = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, org.apache.tools.tar.TarConstants.LF_BLK, org.apache.tools.tar.TarConstants.LF_DIR, org.apache.tools.tar.TarConstants.LF_FIFO, org.apache.tools.tar.TarConstants.LF_CONTIG, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, com.google.common.base.Ascii.DC2, 19, com.google.common.base.Ascii.DC4, com.google.common.base.Ascii.NAK, com.google.common.base.Ascii.SYN, com.google.common.base.Ascii.ETB, com.google.common.base.Ascii.CAN, com.google.common.base.Ascii.EM, -9, -9, -9, -9, 63, -9, com.google.common.base.Ascii.SUB, com.google.common.base.Ascii.ESC, com.google.common.base.Ascii.FS, com.google.common.base.Ascii.GS, com.google.common.base.Ascii.RS, com.google.common.base.Ascii.US, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, org.apache.tools.tar.TarConstants.LF_NORMAL, org.apache.tools.tar.TarConstants.LF_LINK, org.apache.tools.tar.TarConstants.LF_SYMLINK, org.apache.tools.tar.TarConstants.LF_CHR, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
    private static final byte[] f = {45, org.apache.tools.tar.TarConstants.LF_NORMAL, org.apache.tools.tar.TarConstants.LF_LINK, org.apache.tools.tar.TarConstants.LF_SYMLINK, org.apache.tools.tar.TarConstants.LF_CHR, org.apache.tools.tar.TarConstants.LF_BLK, org.apache.tools.tar.TarConstants.LF_DIR, org.apache.tools.tar.TarConstants.LF_FIFO, org.apache.tools.tar.TarConstants.LF_CONTIG, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, org.apache.tools.tar.TarConstants.LF_GNUTYPE_LONGLINK, org.apache.tools.tar.TarConstants.LF_GNUTYPE_LONGNAME, 77, 78, 79, 80, 81, 82, org.apache.tools.tar.TarConstants.LF_GNUTYPE_SPARSE, 84, 85, 86, 87, org.apache.tools.tar.TarConstants.LF_PAX_EXTENDED_HEADER_UC, 89, 90, 95, 97, 98, 99, 100, 101, 102, org.apache.tools.tar.TarConstants.LF_PAX_GLOBAL_EXTENDED_HEADER, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, org.apache.tools.tar.TarConstants.LF_PAX_EXTENDED_HEADER_LC, 121, 122};
    private static final byte[] g = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -9, -9, -9, -1, -9, -9, -9, 11, 12, 13, 14, 15, 16, 17, com.google.common.base.Ascii.DC2, 19, com.google.common.base.Ascii.DC4, com.google.common.base.Ascii.NAK, com.google.common.base.Ascii.SYN, com.google.common.base.Ascii.ETB, com.google.common.base.Ascii.CAN, com.google.common.base.Ascii.EM, com.google.common.base.Ascii.SUB, com.google.common.base.Ascii.ESC, com.google.common.base.Ascii.FS, com.google.common.base.Ascii.GS, com.google.common.base.Ascii.RS, com.google.common.base.Ascii.US, 32, 33, 34, 35, 36, -9, -9, -9, -9, 37, -9, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, org.apache.tools.tar.TarConstants.LF_NORMAL, org.apache.tools.tar.TarConstants.LF_LINK, org.apache.tools.tar.TarConstants.LF_SYMLINK, org.apache.tools.tar.TarConstants.LF_CHR, org.apache.tools.tar.TarConstants.LF_BLK, org.apache.tools.tar.TarConstants.LF_DIR, org.apache.tools.tar.TarConstants.LF_FIFO, org.apache.tools.tar.TarConstants.LF_CONTIG, 56, 57, 58, 59, 60, 61, 62, 63, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    private fm() {
    }

    public static java.lang.String a(byte[] bArr) {
        java.lang.String str;
        try {
            str = a(bArr, bArr.length);
        } catch (java.io.IOException e2) {
            if (!a) {
                throw new java.lang.AssertionError(e2.getMessage());
            }
            str = null;
        }
        if (a || str != null) {
            return str;
        }
        throw new java.lang.AssertionError();
    }

    private static java.lang.String a(byte[] bArr, int i) throws java.io.IOException {
        if (bArr == null) {
            throw new java.lang.NullPointerException("Cannot serialize a null array.");
        }
        if (i < 0) {
            throw new java.lang.IllegalArgumentException("Cannot have length offset: ".concat(java.lang.String.valueOf(i)));
        }
        if (i + 0 > bArr.length) {
            throw new java.lang.IllegalArgumentException(java.lang.String.format("Cannot have offset of %d and length of %d with array of length %d", 0, java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(bArr.length)));
        }
        int i2 = ((i / 3) * 4) + (i % 3 <= 0 ? 0 : 4);
        byte[] bArr2 = new byte[i2];
        int i3 = i - 2;
        int i4 = 0;
        int i5 = 0;
        while (i4 < i3) {
            a(bArr, i4 + 0, 3, bArr2, i5);
            i4 += 3;
            i5 += 4;
        }
        if (i4 < i) {
            a(bArr, i4 + 0, i - i4, bArr2, i5);
            i5 += 4;
        }
        if (i5 <= i2 - 1) {
            byte[] bArr3 = new byte[i5];
            java.lang.System.arraycopy(bArr2, 0, bArr3, 0, i5);
            bArr2 = bArr3;
        }
        try {
            return new java.lang.String(bArr2, "US-ASCII");
        } catch (java.io.UnsupportedEncodingException unused) {
            return new java.lang.String(bArr2);
        }
    }

    public static byte[] a(java.lang.String str) throws java.io.IOException {
        return b(str);
    }

    private static byte[] a(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        byte[] bArr3 = b;
        int i4 = (i2 > 0 ? (bArr[i] << com.google.common.base.Ascii.CAN) >>> 8 : 0) | (i2 > 1 ? (bArr[i + 1] << com.google.common.base.Ascii.CAN) >>> 16 : 0) | (i2 > 2 ? (bArr[i + 2] << com.google.common.base.Ascii.CAN) >>> 24 : 0);
        if (i2 == 1) {
            bArr2[i3] = bArr3[i4 >>> 18];
            bArr2[i3 + 1] = bArr3[(i4 >>> 12) & 63];
            bArr2[i3 + 2] = 61;
            bArr2[i3 + 3] = 61;
            return bArr2;
        }
        if (i2 == 2) {
            bArr2[i3] = bArr3[i4 >>> 18];
            bArr2[i3 + 1] = bArr3[(i4 >>> 12) & 63];
            bArr2[i3 + 2] = bArr3[(i4 >>> 6) & 63];
            bArr2[i3 + 3] = 61;
            return bArr2;
        }
        if (i2 != 3) {
            return bArr2;
        }
        bArr2[i3] = bArr3[i4 >>> 18];
        bArr2[i3 + 1] = bArr3[(i4 >>> 12) & 63];
        bArr2[i3 + 2] = bArr3[(i4 >>> 6) & 63];
        bArr2[i3 + 3] = bArr3[i4 & 63];
        return bArr2;
    }

    private static byte[] b(java.lang.String str) throws java.io.IOException {
        byte[] bytes;
        java.io.ByteArrayInputStream byteArrayInputStream;
        java.util.zip.GZIPInputStream gZIPInputStream;
        if (str == null) {
            throw new java.lang.NullPointerException("Input string was null.");
        }
        try {
            bytes = str.getBytes("US-ASCII");
        } catch (java.io.UnsupportedEncodingException unused) {
            bytes = str.getBytes();
        }
        byte[] b2 = b(bytes, bytes.length);
        if (b2.length >= 4 && 35615 == ((b2[0] & 255) | ((b2[1] << 8) & androidx.core.view.MotionEventCompat.ACTION_POINTER_INDEX_MASK))) {
            byte[] bArr = new byte[2048];
            java.io.ByteArrayOutputStream byteArrayOutputStream = null;
            try {
                try {
                    java.io.ByteArrayOutputStream byteArrayOutputStream2 = new java.io.ByteArrayOutputStream();
                    try {
                        byteArrayInputStream = new java.io.ByteArrayInputStream(b2);
                        try {
                            gZIPInputStream = new java.util.zip.GZIPInputStream(byteArrayInputStream);
                            while (true) {
                                try {
                                    int read = gZIPInputStream.read(bArr);
                                    if (read < 0) {
                                        break;
                                    }
                                    byteArrayOutputStream2.write(bArr, 0, read);
                                } catch (java.io.IOException e2) {
                                    e = e2;
                                    byteArrayOutputStream = byteArrayOutputStream2;
                                    try {
                                        e.printStackTrace();
                                        byteArrayOutputStream.close();
                                        gZIPInputStream.close();
                                        byteArrayInputStream.close();
                                        return b2;
                                    } catch (java.lang.Throwable th) {
                                        th = th;
                                        try {
                                            byteArrayOutputStream.close();
                                        } catch (java.lang.Exception unused2) {
                                        }
                                        try {
                                            gZIPInputStream.close();
                                        } catch (java.lang.Exception unused3) {
                                        }
                                        try {
                                            byteArrayInputStream.close();
                                            throw th;
                                        } catch (java.lang.Exception unused4) {
                                            throw th;
                                        }
                                    }
                                } catch (java.lang.Throwable th2) {
                                    th = th2;
                                    byteArrayOutputStream = byteArrayOutputStream2;
                                    byteArrayOutputStream.close();
                                    gZIPInputStream.close();
                                    byteArrayInputStream.close();
                                    throw th;
                                }
                            }
                            b2 = byteArrayOutputStream2.toByteArray();
                            byteArrayOutputStream2.close();
                        } catch (java.io.IOException e3) {
                            e = e3;
                            gZIPInputStream = null;
                        } catch (java.lang.Throwable th3) {
                            th = th3;
                            gZIPInputStream = null;
                        }
                    } catch (java.io.IOException e4) {
                        e = e4;
                        byteArrayInputStream = null;
                        gZIPInputStream = null;
                    } catch (java.lang.Throwable th4) {
                        th = th4;
                        byteArrayInputStream = null;
                        gZIPInputStream = null;
                    }
                } catch (java.lang.Exception unused5) {
                }
            } catch (java.io.IOException e5) {
                e = e5;
                byteArrayInputStream = null;
                gZIPInputStream = null;
            } catch (java.lang.Throwable th5) {
                th = th5;
                byteArrayInputStream = null;
                gZIPInputStream = null;
            }
            try {
                gZIPInputStream.close();
            } catch (java.lang.Exception unused6) {
            }
            try {
                byteArrayInputStream.close();
            } catch (java.lang.Exception unused7) {
            }
        }
        return b2;
    }

    private static byte[] b(byte[] bArr, int i) throws java.io.IOException {
        int i2;
        if (bArr == null) {
            throw new java.lang.NullPointerException("Cannot decode null source array.");
        }
        int i3 = i + 0;
        int i4 = 3;
        char c2 = 2;
        int i5 = 1;
        if (i3 > bArr.length) {
            throw new java.lang.IllegalArgumentException(java.lang.String.format("Source array with length %d cannot have offset of %d and process %d bytes.", java.lang.Integer.valueOf(bArr.length), 0, java.lang.Integer.valueOf(i)));
        }
        if (i == 0) {
            return new byte[0];
        }
        if (i < 4) {
            throw new java.lang.IllegalArgumentException("Base64Util-encoded string must have at least four characters, but length specified was ".concat(java.lang.String.valueOf(i)));
        }
        byte[] bArr2 = c;
        int i6 = (i * 3) / 4;
        byte[] bArr3 = new byte[i6];
        byte[] bArr4 = new byte[4];
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i7 < i3) {
            byte b2 = bArr[i7];
            byte b3 = bArr2[b2 & 255];
            if (b3 < -5) {
                throw new java.io.IOException(java.lang.String.format("Bad Base64Util input character decimal %d in array position %d", java.lang.Integer.valueOf(bArr[i7] & 255), java.lang.Integer.valueOf(i7)));
            }
            if (b3 >= -1) {
                int i10 = i8 + 1;
                bArr4[i8] = b2;
                if (i10 <= i4) {
                    i8 = i10;
                } else {
                    if (i9 < 0 || (i2 = i9 + 2) >= i6) {
                        throw new java.lang.IllegalArgumentException(java.lang.String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", java.lang.Integer.valueOf(i6), java.lang.Integer.valueOf(i9)));
                    }
                    byte[] bArr5 = c;
                    byte b4 = bArr4[c2];
                    if (b4 == 61) {
                        bArr3[i9] = (byte) ((((bArr5[bArr4[0]] & 255) << 18) | ((bArr5[bArr4[i5]] & 255) << 12)) >>> 16);
                    } else {
                        byte b5 = bArr4[i4];
                        if (b5 == 61) {
                            int i11 = ((bArr5[bArr4[0]] & 255) << 18) | ((bArr5[bArr4[i5]] & 255) << 12) | ((bArr5[b4] & 255) << 6);
                            bArr3[i9] = (byte) (i11 >>> 16);
                            bArr3[i9 + 1] = (byte) (i11 >>> 8);
                            i5 = 2;
                        } else {
                            int i12 = ((bArr5[bArr4[0]] & 255) << 18) | ((bArr5[bArr4[i5]] & 255) << 12) | ((bArr5[b4] & 255) << 6) | (bArr5[b5] & 255);
                            bArr3[i9] = (byte) (i12 >> 16);
                            bArr3[i9 + 1] = (byte) (i12 >> 8);
                            bArr3[i2] = (byte) i12;
                            i5 = 3;
                        }
                    }
                    i9 += i5;
                    if (bArr[i7] == 61) {
                        break;
                    }
                    i8 = 0;
                }
            }
            i7++;
            i4 = 3;
            c2 = 2;
            i5 = 1;
        }
        byte[] bArr6 = new byte[i9];
        java.lang.System.arraycopy(bArr3, 0, bArr6, 0, i9);
        return bArr6;
    }
}
