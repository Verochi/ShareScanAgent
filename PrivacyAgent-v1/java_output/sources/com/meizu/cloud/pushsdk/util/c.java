package com.meizu.cloud.pushsdk.util;

/* loaded from: classes23.dex */
public class c {
    private static final java.nio.charset.Charset a = java.nio.charset.Charset.forName("UTF-8");

    public static java.lang.String a(java.lang.String str, java.lang.String str2) {
        if (str == null) {
            return null;
        }
        try {
            if (android.text.TextUtils.isEmpty(str2)) {
                return null;
            }
            return new java.lang.String(a(a(str), b(str2)), a);
        } catch (java.lang.Exception e) {
            com.meizu.cloud.pushinternal.DebugLogger.e("RSAUtils", "decrypt " + e.getMessage());
            return null;
        }
    }

    private static java.security.interfaces.RSAPublicKey a(java.lang.String str) {
        java.lang.StringBuilder sb;
        java.lang.String str2;
        try {
            return (java.security.interfaces.RSAPublicKey) java.security.KeyFactory.getInstance(com.alipay.sdk.m.n.d.a).generatePublic(new java.security.spec.X509EncodedKeySpec(b(str)));
        } catch (java.security.NoSuchAlgorithmException e) {
            e = e;
            sb = new java.lang.StringBuilder();
            str2 = "loadPublicKey NoSuchAlgorithmException ";
            sb.append(str2);
            sb.append(e.getMessage());
            com.meizu.cloud.pushinternal.DebugLogger.e("RSAUtils", sb.toString());
            return null;
        } catch (java.security.spec.InvalidKeySpecException e2) {
            e = e2;
            sb = new java.lang.StringBuilder();
            str2 = "loadPublicKey InvalidKeySpecException ";
            sb.append(str2);
            sb.append(e.getMessage());
            com.meizu.cloud.pushinternal.DebugLogger.e("RSAUtils", sb.toString());
            return null;
        }
    }

    private static byte[] a(java.security.PublicKey publicKey, byte[] bArr) throws java.lang.Exception {
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(2, publicKey);
        return cipher.doFinal(bArr);
    }

    private static byte[] b(java.lang.String str) {
        return com.meizu.cloud.pushsdk.c.g.a.a(str);
    }
}
