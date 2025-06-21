package com.alipay.sdk.m.n;

/* loaded from: classes.dex */
public class e {
    public static java.lang.String a = "DESede/CBC/PKCS5Padding";

    public static java.lang.String a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        try {
            return new java.lang.String(a(str, com.alipay.sdk.m.n.a.a(str2), str3));
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public static byte[] a(java.lang.String str, byte[] bArr, java.lang.String str2) {
        try {
            javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(str.getBytes(), "DESede");
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(a);
            cipher.init(2, secretKeySpec, new javax.crypto.spec.IvParameterSpec(com.alipay.sdk.m.n.c.a(cipher, str2)));
            return cipher.doFinal(bArr);
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public static java.lang.String b(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        try {
            return com.alipay.sdk.m.n.a.a(b(str, str2.getBytes(), str3));
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public static byte[] b(java.lang.String str, byte[] bArr, java.lang.String str2) {
        try {
            javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(str.getBytes(), "DESede");
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(a);
            cipher.init(1, secretKeySpec, new javax.crypto.spec.IvParameterSpec(com.alipay.sdk.m.n.c.a(cipher, str2)));
            return cipher.doFinal(bArr);
        } catch (java.lang.Exception unused) {
            return null;
        }
    }
}
