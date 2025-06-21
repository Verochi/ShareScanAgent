package com.getui.gtc.extension.distribution.gbd.n;

/* loaded from: classes22.dex */
public final class u {
    private static java.lang.String a = "RSA";
    private static java.lang.String b = "RSA/NONE/OAEPWithSHA1AndMGF1Padding";

    public static java.security.PublicKey a(byte[] bArr) {
        try {
            return java.security.KeyFactory.getInstance(a).generatePublic(new java.security.spec.X509EncodedKeySpec(bArr));
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return null;
        }
    }

    private static byte[] a(byte[] bArr, java.security.PrivateKey privateKey) {
        try {
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(b);
            cipher.init(2, privateKey);
            return cipher.doFinal(bArr);
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public static byte[] a(byte[] bArr, java.security.PublicKey publicKey) {
        try {
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(b);
            cipher.init(1, publicKey);
            return cipher.doFinal(bArr);
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    private static java.security.PrivateKey b(byte[] bArr) {
        try {
            return java.security.KeyFactory.getInstance(a).generatePrivate(new java.security.spec.PKCS8EncodedKeySpec(bArr));
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return null;
        }
    }
}
