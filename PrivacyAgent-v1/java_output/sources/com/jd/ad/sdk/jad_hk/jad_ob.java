package com.jd.ad.sdk.jad_hk;

/* loaded from: classes23.dex */
public final class jad_ob {
    public static final java.nio.charset.Charset jad_an = java.nio.charset.Charset.forName("UTF-8");

    public static void jad_an(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new java.lang.ArrayIndexOutOfBoundsException(java.lang.String.format("size=%s offset=%s byteCount=%s", java.lang.Long.valueOf(j), java.lang.Long.valueOf(j2), java.lang.Long.valueOf(j3)));
        }
    }

    public static boolean jad_an(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            if (bArr[i4 + i] != bArr2[i4 + i2]) {
                return false;
            }
        }
        return true;
    }
}
