package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class al {
    private static final java.lang.String a = java.lang.System.getProperty("line.separator");
    private static char[] b = new char[64];
    private static byte[] c;

    static {
        char c2 = 'A';
        int i = 0;
        while (c2 <= 'Z') {
            b[i] = c2;
            c2 = (char) (c2 + 1);
            i++;
        }
        char c3 = 'a';
        while (c3 <= 'z') {
            b[i] = c3;
            c3 = (char) (c3 + 1);
            i++;
        }
        char c4 = '0';
        while (c4 <= '9') {
            b[i] = c4;
            c4 = (char) (c4 + 1);
            i++;
        }
        char[] cArr = b;
        cArr[i] = '+';
        cArr[i + 1] = '/';
        c = new byte[128];
        int i2 = 0;
        while (true) {
            byte[] bArr = c;
            if (i2 >= bArr.length) {
                break;
            }
            bArr[i2] = -1;
            i2++;
        }
        for (int i3 = 0; i3 < 64; i3++) {
            c[b[i3]] = (byte) i3;
        }
    }

    public static java.lang.String a(java.lang.String str) {
        return new java.lang.String(a(str.getBytes()));
    }

    public static char[] a(byte[] bArr) {
        return a(bArr, bArr.length);
    }

    private static char[] a(byte[] bArr, int i) {
        int i2;
        int i3;
        int i4;
        int i5 = ((i * 4) + 2) / 3;
        char[] cArr = new char[((i + 2) / 3) * 4];
        int i6 = i + 0;
        int i7 = 0;
        int i8 = 0;
        while (i7 < i6) {
            int i9 = i7 + 1;
            int i10 = bArr[i7] & 255;
            if (i9 < i6) {
                i2 = i9 + 1;
                i3 = bArr[i9] & 255;
            } else {
                i2 = i9;
                i3 = 0;
            }
            if (i2 < i6) {
                i4 = bArr[i2] & 255;
                i2++;
            } else {
                i4 = 0;
            }
            int i11 = i10 >>> 2;
            int i12 = ((i10 & 3) << 4) | (i3 >>> 4);
            int i13 = ((i3 & 15) << 2) | (i4 >>> 6);
            int i14 = i4 & 63;
            int i15 = i8 + 1;
            char[] cArr2 = b;
            cArr[i8] = cArr2[i11];
            int i16 = i15 + 1;
            cArr[i15] = cArr2[i12];
            char c2 = com.alipay.sdk.m.n.a.h;
            cArr[i16] = i16 < i5 ? cArr2[i13] : com.alipay.sdk.m.n.a.h;
            int i17 = i16 + 1;
            if (i17 < i5) {
                c2 = cArr2[i14];
            }
            cArr[i17] = c2;
            i8 = i17 + 1;
            i7 = i2;
        }
        return cArr;
    }

    public static byte[] b(java.lang.String str) {
        int i;
        char c2;
        int i2;
        char c3;
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        if (length % 4 != 0) {
            throw new java.lang.IllegalArgumentException("Length of Base64 encoded input string is not a multiple of 4.");
        }
        while (length > 0 && charArray[(length + 0) - 1] == '=') {
            length--;
        }
        int i3 = (length * 3) / 4;
        byte[] bArr = new byte[i3];
        int i4 = length + 0;
        int i5 = 0;
        for (int i6 = 0; i6 < i4; i6 = i2) {
            int i7 = i6 + 1;
            char c4 = charArray[i6];
            int i8 = i7 + 1;
            char c5 = charArray[i7];
            if (i8 < i4) {
                i = i8 + 1;
                c2 = charArray[i8];
            } else {
                i = i8;
                c2 = 'A';
            }
            if (i < i4) {
                i2 = i + 1;
                c3 = charArray[i];
            } else {
                i2 = i;
                c3 = 'A';
            }
            if (c4 > 127 || c5 > 127 || c2 > 127 || c3 > 127) {
                throw new java.lang.IllegalArgumentException("Illegal character in Base64 encoded data.");
            }
            byte[] bArr2 = c;
            byte b2 = bArr2[c4];
            byte b3 = bArr2[c5];
            byte b4 = bArr2[c2];
            byte b5 = bArr2[c3];
            if (b2 < 0 || b3 < 0 || b4 < 0 || b5 < 0) {
                throw new java.lang.IllegalArgumentException("Illegal character in Base64 encoded data.");
            }
            int i9 = (b2 << 2) | (b3 >>> 4);
            int i10 = ((b3 & 15) << 4) | (b4 >>> 2);
            int i11 = ((b4 & 3) << 6) | b5;
            int i12 = i5 + 1;
            bArr[i5] = (byte) i9;
            if (i12 < i3) {
                bArr[i12] = (byte) i10;
                i12++;
            }
            if (i12 < i3) {
                bArr[i12] = (byte) i11;
                i5 = i12 + 1;
            } else {
                i5 = i12;
            }
        }
        return bArr;
    }
}
