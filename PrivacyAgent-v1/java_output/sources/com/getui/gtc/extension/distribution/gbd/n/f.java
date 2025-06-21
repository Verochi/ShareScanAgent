package com.getui.gtc.extension.distribution.gbd.n;

/* loaded from: classes22.dex */
public final class f {
    private static float a(byte[] bArr) {
        if (bArr == null || bArr.length != 4) {
            throw new java.lang.IllegalArgumentException("byte[] is null or length != 4");
        }
        if (bArr.length != 4) {
            throw new java.lang.IllegalArgumentException("byte[] is null or length != 4");
        }
        return java.lang.Float.intBitsToFloat((bArr[3] & 255) | ((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8));
    }

    public static int a(byte[] bArr, byte[] bArr2, int i, int i2) {
        java.lang.System.arraycopy(bArr, 0, bArr2, i, i2);
        return i2;
    }

    private static java.lang.String a(byte[] bArr, int i, int i2) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (int i3 = i; i3 < i + i2; i3++) {
            sb.append(java.lang.String.format("%02X", java.lang.Byte.valueOf(bArr[i3])));
        }
        return sb.toString();
    }

    private static byte[] a(char c) {
        return new byte[]{(byte) (c >> '\b'), (byte) (c & 255)};
    }

    private static byte[] a(double d) {
        long doubleToLongBits = java.lang.Double.doubleToLongBits(d);
        return new byte[]{(byte) (doubleToLongBits >> 56), (byte) (doubleToLongBits >> 48), (byte) (doubleToLongBits >> 40), (byte) (doubleToLongBits >> 32), (byte) (doubleToLongBits >> 24), (byte) (doubleToLongBits >> 16), (byte) (doubleToLongBits >> 8), (byte) (doubleToLongBits & 255)};
    }

    private static byte[] a(float f) {
        int floatToIntBits = java.lang.Float.floatToIntBits(f);
        return new byte[]{(byte) (floatToIntBits >> 24), (byte) (floatToIntBits >> 16), (byte) (floatToIntBits >> 8), (byte) (floatToIntBits & 255)};
    }

    private static byte[] a(int i) {
        return new byte[]{(byte) (i >> 24), (byte) (i >> 16), (byte) (i >> 8), (byte) (i & 255)};
    }

    private static byte[] a(long j) {
        return new byte[]{(byte) (j >> 56), (byte) (j >> 48), (byte) (j >> 40), (byte) (j >> 32), (byte) (j >> 24), (byte) (j >> 16), (byte) (j >> 8), (byte) (j & 255)};
    }

    private static byte[] a(java.lang.Short sh) {
        return new byte[]{(byte) (sh.shortValue() >> 8), (byte) (sh.shortValue() & 255)};
    }

    public static byte[] a(short s2) {
        byte[] bArr = new byte[16];
        for (int i = 15; i >= 0; i--) {
            bArr[i] = (byte) (s2 & 1);
            s2 = (short) (s2 >> 1);
        }
        return bArr;
    }

    private static double b(byte[] bArr) {
        if (bArr == null || bArr.length != 8) {
            throw new java.lang.IllegalArgumentException("byte[] is null or length != 8");
        }
        if (bArr.length == 8) {
            return java.lang.Double.longBitsToDouble(((bArr[0] & 255) << 56) | ((bArr[1] & 255) << 48) | ((bArr[2] & 255) << 40) | ((bArr[3] & 255) << 32) | ((bArr[4] & 255) << 24) | ((bArr[5] & 255) << 16) | ((bArr[6] & 255) << 8) | (bArr[7] & 255));
        }
        throw new java.lang.IllegalArgumentException("byte[] is null or length != 8");
    }

    private static byte[] b(int i) {
        byte[] bArr = new byte[32];
        for (int i2 = 31; i2 >= 0; i2--) {
            bArr[i2] = (byte) (i & 1);
            i >>= 1;
        }
        return bArr;
    }

    private static byte[] b(long j) {
        byte[] bArr = new byte[64];
        for (int i = 63; i >= 0; i--) {
            bArr[i] = (byte) (1 & j);
            j >>= 1;
        }
        return bArr;
    }

    private static char c(byte[] bArr) {
        if (bArr == null || bArr.length != 2) {
            throw new java.lang.IllegalArgumentException("byte[] is null or length != 2");
        }
        return (char) (((char) bArr[1]) | ((char) (bArr[0] << 8)));
    }

    private static short d(byte[] bArr) {
        if (bArr != null && bArr.length != 2) {
            throw new java.lang.IllegalArgumentException("byte[] is null or length != 2");
        }
        return (short) ((bArr[1] & 255) | (bArr[0] << 8));
    }

    private static short e(byte[] bArr) {
        if (bArr == null || bArr.length != 16) {
            throw new java.lang.IllegalArgumentException("byte[] is null or length != 16");
        }
        short s2 = 0;
        for (int i = 0; i < 16; i++) {
            s2 = (short) (s2 | (bArr[i] << (15 - i)));
        }
        return s2;
    }

    private static int f(byte[] bArr) {
        if (bArr == null || bArr.length != 4) {
            throw new java.lang.IllegalArgumentException("byte[] is null or length != 4");
        }
        return (bArr[3] & 255) | ((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8);
    }

    private static long g(byte[] bArr) {
        if (bArr == null || bArr.length != 8) {
            throw new java.lang.IllegalArgumentException("byte[] is null or length != 8");
        }
        return ((bArr[6] & 255) << 8) | ((bArr[0] & 255) << 56) | ((bArr[1] & 255) << 48) | ((bArr[2] & 255) << 40) | ((bArr[3] & 255) << 32) | ((bArr[4] & 255) << 24) | ((bArr[5] & 255) << 16) | (bArr[7] & 255);
    }

    private static int h(byte[] bArr) {
        if (bArr == null || bArr.length != 32) {
            throw new java.lang.IllegalArgumentException("byte[] is null or length != 32");
        }
        int i = 0;
        for (int i2 = 0; i2 < 32; i2++) {
            i |= bArr[i2] << (31 - i2);
        }
        return i;
    }

    private static long i(byte[] bArr) {
        if (bArr == null || bArr.length != 64) {
            throw new java.lang.IllegalArgumentException("byte[] is null or length != 64");
        }
        long j = 0;
        for (int i = 0; i < 64; i++) {
            j |= bArr[i] << (63 - i);
        }
        return j;
    }

    private static byte[] j(byte[] bArr) {
        byte[] bArr2 = new byte[3];
        for (int i = 7; i < 10; i++) {
            bArr2[i - 7] = bArr[i];
        }
        return bArr2;
    }
}
