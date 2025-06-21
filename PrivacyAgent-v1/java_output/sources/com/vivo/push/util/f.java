package com.vivo.push.util;

/* loaded from: classes19.dex */
public final class f {
    public static java.lang.String a(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[length];
        for (int i = 0; i < length; i++) {
            cArr[i] = (char) (bArr[i] ^ 16);
        }
        return new java.lang.String(cArr);
    }

    public static byte[] a(java.lang.String str, java.lang.String str2, byte[] bArr) {
        javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(str2.getBytes("utf-8"), "AES");
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, secretKeySpec, new javax.crypto.spec.IvParameterSpec(str.getBytes("utf-8")));
        return cipher.doFinal(bArr);
    }
}
