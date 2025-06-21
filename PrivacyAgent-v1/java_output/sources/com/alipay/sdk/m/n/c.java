package com.alipay.sdk.m.n;

/* loaded from: classes.dex */
public class c {
    public static byte[] a(javax.crypto.Cipher cipher, java.lang.String str) {
        java.security.SecureRandom secureRandom = new java.security.SecureRandom();
        int blockSize = cipher.getBlockSize();
        if (android.text.TextUtils.isEmpty(str)) {
            str = java.lang.String.valueOf(secureRandom.nextDouble());
        }
        int i = blockSize * 2;
        byte[] bArr = new byte[i];
        byte[] bArr2 = new byte[blockSize];
        secureRandom.nextBytes(bArr2);
        for (int i2 = 1; i2 < i; i2++) {
            byte codePointAt = (byte) (str.codePointAt(i2 % str.length()) & 127);
            bArr[i2] = codePointAt;
            if (i2 >= blockSize) {
                bArr[i2] = (byte) (bArr[0] & codePointAt);
            }
        }
        java.lang.System.arraycopy(bArr, blockSize, bArr2, 0, blockSize);
        return bArr2;
    }
}
