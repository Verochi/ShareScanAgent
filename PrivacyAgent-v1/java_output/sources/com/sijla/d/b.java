package com.sijla.d;

/* loaded from: classes19.dex */
public final class b {
    private static byte[] a = new byte[8];
    private static final java.lang.String b;
    private static final java.lang.String c;

    static {
        int i = 0;
        while (i < 8) {
            int i2 = i + 1;
            a[i] = (byte) i2;
            i = i2;
        }
        b = new java.lang.String(com.sijla.d.a.a("REVTL0NCQy9QS0NTNVBhZGRpbmc="));
        c = new java.lang.String(com.sijla.d.a.a("REVT"));
    }

    public static java.lang.String a(java.lang.String str, java.lang.String str2) {
        try {
            return com.sijla.d.a.a(a(str, str2.getBytes(), a));
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private static byte[] a(java.lang.String str, byte[] bArr, byte[] bArr2) {
        try {
            javax.crypto.spec.IvParameterSpec ivParameterSpec = new javax.crypto.spec.IvParameterSpec(bArr2);
            javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(str.getBytes(), c);
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(b);
            cipher.init(1, secretKeySpec, ivParameterSpec);
            return cipher.doFinal(bArr);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static java.lang.String b(java.lang.String str, java.lang.String str2) {
        javax.crypto.spec.IvParameterSpec ivParameterSpec = new javax.crypto.spec.IvParameterSpec(a);
        javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(str.getBytes(), c);
        try {
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(b);
            cipher.init(2, secretKeySpec, ivParameterSpec);
            return new java.lang.String(cipher.doFinal(com.sijla.d.a.a(str2)));
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }
}
