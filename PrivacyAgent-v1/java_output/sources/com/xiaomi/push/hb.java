package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class hb {
    private static final byte[] a = {100, com.google.common.base.Ascii.ETB, 84, 114, 72, 0, 4, 97, 73, 97, 2, org.apache.tools.tar.TarConstants.LF_BLK, 84, 102, com.google.common.base.Ascii.DC2, 32};

    private static javax.crypto.Cipher a(byte[] bArr, int i) {
        javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(bArr, "AES");
        javax.crypto.spec.IvParameterSpec ivParameterSpec = new javax.crypto.spec.IvParameterSpec(a);
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(i, secretKeySpec, ivParameterSpec);
        return cipher;
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        return a(bArr, 2).doFinal(bArr2);
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        return a(bArr, 1).doFinal(bArr2);
    }
}
