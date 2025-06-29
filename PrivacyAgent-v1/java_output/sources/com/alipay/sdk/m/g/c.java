package com.alipay.sdk.m.g;

/* loaded from: classes.dex */
public class c {
    public static volatile java.security.SecureRandom a;
    public static final char[] b = "0123456789ABCDEF".toCharArray();

    public static java.lang.String a(byte[] bArr) {
        return android.util.Base64.encodeToString(bArr, 3);
    }

    public static java.security.SecureRandom a() {
        if (a != null) {
            return a;
        }
        synchronized (com.alipay.sdk.m.g.c.class) {
            if (a == null) {
                a = new java.security.SecureRandom();
            }
        }
        return a;
    }

    public static byte[] a(byte b2) {
        return new byte[]{b2};
    }

    public static byte[] a(char c) {
        return new byte[]{(byte) (c & 255)};
    }

    public static byte[] a(char c, char c2) {
        return new byte[]{(byte) (c & 255), (byte) (c2 & 255)};
    }

    public static byte[] a(int i) {
        return new byte[]{(byte) i, (byte) (i >> 8), (byte) (i >> 16), (byte) (i >> 24)};
    }

    public static byte[] a(long j) {
        return new byte[]{(byte) j, (byte) (j >> 8), (byte) (j >> 16), (byte) (j >> 24), (byte) (j >> 32), (byte) (j >> 40), (byte) (j >> 48), (byte) (j >> 56)};
    }

    public static byte[] a(short s2) {
        return new byte[]{(byte) s2, (byte) (s2 >> 8)};
    }

    public static byte[] a(byte[]... bArr) {
        int i = 0;
        for (byte[] bArr2 : bArr) {
            i += bArr2.length;
        }
        byte[] bArr3 = null;
        int i2 = 0;
        for (byte[] bArr4 : bArr) {
            if (bArr3 == null) {
                bArr3 = java.util.Arrays.copyOf(bArr4, i);
                i2 = bArr4.length;
            } else {
                java.lang.System.arraycopy(bArr4, 0, bArr3, i2, bArr4.length);
                i2 += bArr4.length;
            }
        }
        return bArr3;
    }

    public static java.lang.String b(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            int i3 = i * 2;
            char[] cArr2 = b;
            cArr[i3] = cArr2[i2 >>> 4];
            cArr[i3 + 1] = cArr2[i2 & 15];
        }
        return new java.lang.String(cArr);
    }

    public static byte[] b() {
        byte[] bArr = new byte[2];
        a().nextBytes(bArr);
        return bArr;
    }

    public static byte[] c() {
        byte[] bArr = new byte[4];
        a().nextBytes(bArr);
        return bArr;
    }
}
