package com.tencent.open.utils;

/* loaded from: classes19.dex */
public class e {
    private static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static java.lang.String a(java.lang.String str, java.lang.String str2, byte[] bArr) {
        try {
            javax.crypto.spec.IvParameterSpec ivParameterSpec = new javax.crypto.spec.IvParameterSpec(bArr);
            javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(str2.getBytes(), "AES");
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(1, secretKeySpec, ivParameterSpec);
            return android.util.Base64.encodeToString(cipher.doFinal(str.getBytes()), 0);
        } catch (java.lang.Exception e) {
            com.tencent.open.log.SLog.e("DESUtils", com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Encrypt.METHOD_ENCRYPT_AES, e);
            return null;
        }
    }

    public static java.lang.String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        char[] cArr = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i];
            int i2 = i * 2;
            char[] cArr2 = a;
            cArr[i2 + 1] = cArr2[b & 15];
            cArr[i2] = cArr2[((byte) (b >>> 4)) & 15];
        }
        return new java.lang.String(cArr);
    }

    public static byte[] a(java.lang.String str) {
        try {
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("SHA-256");
            messageDigest.update(str.getBytes());
            return messageDigest.digest();
        } catch (java.lang.Exception e) {
            com.tencent.open.log.SLog.e("DESUtils", "encryptSha", e);
            return null;
        }
    }
}
