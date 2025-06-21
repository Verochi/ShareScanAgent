package com.heytap.mcssdk.utils;

/* loaded from: classes22.dex */
public abstract class c {
    public static java.lang.String a(java.lang.String str, java.lang.String str2) {
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("DES");
        cipher.init(2, a(str2));
        return new java.lang.String(cipher.doFinal(android.util.Base64.decode(str, 0)), java.nio.charset.Charset.defaultCharset()).trim();
    }

    private static java.security.Key a(java.lang.String str) {
        return javax.crypto.SecretKeyFactory.getInstance("DES").generateSecret(new javax.crypto.spec.DESKeySpec(android.util.Base64.decode(str, 0)));
    }
}
