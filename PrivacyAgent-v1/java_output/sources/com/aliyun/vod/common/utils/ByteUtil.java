package com.aliyun.vod.common.utils;

/* loaded from: classes12.dex */
public class ByteUtil {
    public static short[] byte2short(byte[] bArr) {
        int length = bArr.length / 2;
        short[] sArr = new short[length];
        for (int i = 0; i < length; i++) {
            sArr[i] = getShort(bArr, i * 2);
        }
        return sArr;
    }

    public static int byteArrayToInt(byte[] bArr) {
        return ((bArr[1] & 255) << 8) | (bArr[0] & 255);
    }

    public static long byteArrayToLong(byte[] bArr) {
        byte[] bArr2 = new byte[4];
        int i = 0;
        for (int i2 = 0; i2 < 4; i2++) {
            bArr2[i] = bArr[i2];
            i++;
        }
        long j = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < 32; i4 += 8) {
            j |= (bArr2[i3] & 255) << i4;
            i3++;
        }
        return j;
    }

    public static short byteArrayToShort(byte[] bArr) {
        return (short) ((((short) (bArr[1] & 255)) << 8) | ((short) (bArr[0] & 255)));
    }

    public static java.lang.String byteArrayToString(byte[] bArr) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(bArr.length);
        for (byte b : bArr) {
            sb.append((char) b);
        }
        return sb.toString();
    }

    public static byte[] doubleToByteArray(java.lang.Double d) {
        return longToByteArray(java.lang.Double.doubleToLongBits(d.doubleValue()));
    }

    public static byte[] floatToByteArray(java.lang.Float f) {
        return intToByteArray(java.lang.Float.floatToIntBits(f.floatValue()));
    }

    public static short getShort(byte[] bArr, int i) {
        return (short) ((bArr[i] & 255) | (bArr[i + 1] << 8));
    }

    public static byte[] intToByteArray(int i) {
        return new byte[]{(byte) (i & 255), (byte) ((i >> 8) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 24) & 255)};
    }

    public static byte[] longToByteArray(long j) {
        return new byte[]{(byte) (j & 255), (byte) ((j >> 8) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 24) & 255), (byte) ((j >> 32) & 255), (byte) ((j >> 40) & 255), (byte) ((j >> 48) & 255), (byte) ((j >> 56) & 255)};
    }

    public static void putShort(byte[] bArr, short s2, int i) {
        bArr[i + 1] = (byte) (s2 >> 8);
        bArr[i] = (byte) s2;
    }

    public static byte[] short2byte(short[] sArr) {
        byte[] bArr = new byte[sArr.length * 2];
        for (int i = 0; i < sArr.length; i++) {
            putShort(bArr, sArr[i], i * 2);
        }
        return bArr;
    }

    public static byte[] shortToByteArray(short s2) {
        return new byte[]{(byte) (s2 & 255), (byte) ((s2 >>> 8) & 255)};
    }
}
