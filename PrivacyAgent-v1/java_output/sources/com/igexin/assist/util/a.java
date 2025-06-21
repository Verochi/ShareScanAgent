package com.igexin.assist.util;

/* loaded from: classes22.dex */
public final class a {
    public static java.lang.String a(java.lang.String str) {
        byte[] bArr;
        try {
            bArr = java.security.MessageDigest.getInstance("md5").digest(str.getBytes("utf-8"));
        } catch (java.io.UnsupportedEncodingException | java.security.NoSuchAlgorithmException e) {
            com.igexin.c.a.c.a.a(e);
            bArr = null;
        }
        return new java.math.BigInteger(1, bArr).toString(16);
    }

    public static java.lang.String a(java.lang.String str, java.lang.String str2) {
        try {
            byte[] decode = android.util.Base64.decode(str, 0);
            javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(a(new java.lang.StringBuilder(str2).reverse().toString().getBytes()), "AES");
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES/CFB128/NoPadding");
            cipher.init(2, secretKeySpec, new javax.crypto.spec.IvParameterSpec(a("".getBytes())));
            byte[] doFinal = cipher.doFinal(decode);
            if (doFinal != null) {
                return new java.lang.String(doFinal);
            }
            return null;
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return null;
        }
    }

    private static byte[] a(byte[] bArr) {
        try {
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (java.lang.Exception e) {
            com.igexin.c.a.c.a.a(e);
            return null;
        }
    }
}
