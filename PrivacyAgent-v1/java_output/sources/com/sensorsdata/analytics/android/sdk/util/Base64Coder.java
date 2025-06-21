package com.sensorsdata.analytics.android.sdk.util;

/* loaded from: classes19.dex */
public class Base64Coder {
    public static final java.lang.String CHARSET_UTF8 = "UTF-8";
    private static char[] map1 = new char[64];
    private static byte[] map2 = new byte[128];

    static {
        char c = 'A';
        int i = 0;
        while (c <= 'Z') {
            map1[i] = c;
            c = (char) (c + 1);
            i++;
        }
        char c2 = 'a';
        while (c2 <= 'z') {
            map1[i] = c2;
            c2 = (char) (c2 + 1);
            i++;
        }
        char c3 = '0';
        while (c3 <= '9') {
            map1[i] = c3;
            c3 = (char) (c3 + 1);
            i++;
        }
        char[] cArr = map1;
        cArr[i] = '+';
        cArr[i + 1] = '/';
        int i2 = 0;
        while (true) {
            byte[] bArr = map2;
            if (i2 >= bArr.length) {
                break;
            }
            bArr[i2] = -1;
            i2++;
        }
        for (int i3 = 0; i3 < 64; i3++) {
            map2[map1[i3]] = (byte) i3;
        }
    }

    public static byte[] decode(java.lang.String str) {
        return decode(str.toCharArray());
    }

    public static byte[] decode(char[] cArr) {
        int i;
        char c;
        int i2;
        char c2;
        int length = cArr.length;
        if (length % 4 != 0) {
            throw new java.lang.IllegalArgumentException("Length of Base64 encoded input string is not a multiple of 4.");
        }
        while (length > 0 && cArr[length - 1] == '=') {
            length--;
        }
        int i3 = (length * 3) / 4;
        byte[] bArr = new byte[i3];
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5 = i2) {
            int i6 = i5 + 1;
            char c3 = cArr[i5];
            int i7 = i6 + 1;
            char c4 = cArr[i6];
            if (i7 < length) {
                i = i7 + 1;
                c = cArr[i7];
            } else {
                i = i7;
                c = 'A';
            }
            if (i < length) {
                i2 = i + 1;
                c2 = cArr[i];
            } else {
                i2 = i;
                c2 = 'A';
            }
            if (c3 > 127 || c4 > 127 || c > 127 || c2 > 127) {
                throw new java.lang.IllegalArgumentException("Illegal character in Base64 encoded data.");
            }
            byte[] bArr2 = map2;
            byte b = bArr2[c3];
            byte b2 = bArr2[c4];
            byte b3 = bArr2[c];
            byte b4 = bArr2[c2];
            if (b < 0 || b2 < 0 || b3 < 0 || b4 < 0) {
                throw new java.lang.IllegalArgumentException("Illegal character in Base64 encoded data.");
            }
            int i8 = (b << 2) | (b2 >>> 4);
            int i9 = ((b2 & 15) << 4) | (b3 >>> 2);
            int i10 = ((b3 & 3) << 6) | b4;
            int i11 = i4 + 1;
            bArr[i4] = (byte) i8;
            if (i11 < i3) {
                bArr[i11] = (byte) i9;
                i11++;
            }
            if (i11 < i3) {
                bArr[i11] = (byte) i10;
                i4 = i11 + 1;
            } else {
                i4 = i11;
            }
        }
        return bArr;
    }

    public static java.lang.String decodeString(java.lang.String str) {
        return new java.lang.String(decode(str));
    }

    public static char[] encode(byte[] bArr) {
        return encode(bArr, bArr.length);
    }

    public static char[] encode(byte[] bArr, int i) {
        int i2;
        int i3;
        int i4;
        int i5 = ((i * 4) + 2) / 3;
        char[] cArr = new char[((i + 2) / 3) * 4];
        int i6 = 0;
        int i7 = 0;
        while (i6 < i) {
            int i8 = i6 + 1;
            int i9 = bArr[i6] & 255;
            if (i8 < i) {
                i2 = i8 + 1;
                i3 = bArr[i8] & 255;
            } else {
                i2 = i8;
                i3 = 0;
            }
            if (i2 < i) {
                i4 = bArr[i2] & 255;
                i2++;
            } else {
                i4 = 0;
            }
            int i10 = i9 >>> 2;
            int i11 = ((i9 & 3) << 4) | (i3 >>> 4);
            int i12 = ((i3 & 15) << 2) | (i4 >>> 6);
            int i13 = i4 & 63;
            int i14 = i7 + 1;
            char[] cArr2 = map1;
            cArr[i7] = cArr2[i10];
            int i15 = i14 + 1;
            cArr[i14] = cArr2[i11];
            char c = com.alipay.sdk.m.n.a.h;
            cArr[i15] = i15 < i5 ? cArr2[i12] : com.alipay.sdk.m.n.a.h;
            int i16 = i15 + 1;
            if (i16 < i5) {
                c = cArr2[i13];
            }
            cArr[i16] = c;
            i7 = i16 + 1;
            i6 = i2;
        }
        return cArr;
    }

    public static java.lang.String encodeString(java.lang.String str) {
        try {
            return new java.lang.String(encode(str.getBytes("UTF-8")));
        } catch (java.io.UnsupportedEncodingException e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return "";
        }
    }
}
