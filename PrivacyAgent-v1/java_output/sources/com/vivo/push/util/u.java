package com.vivo.push.util;

/* loaded from: classes19.dex */
public final class u {
    private static java.lang.String a = "RSA";

    public static java.lang.String a(java.security.Key key) {
        return android.util.Base64.encodeToString(key.getEncoded(), 2);
    }

    public static java.security.PublicKey a(java.lang.String str) {
        try {
            return java.security.KeyFactory.getInstance(a).generatePublic(new java.security.spec.X509EncodedKeySpec(android.util.Base64.decode(str, 2)));
        } catch (java.lang.NullPointerException unused) {
            throw new java.lang.Exception("公钥数据为空");
        } catch (java.security.NoSuchAlgorithmException unused2) {
            throw new java.lang.Exception("无此算法");
        } catch (java.security.spec.InvalidKeySpecException unused3) {
            throw new java.lang.Exception("公钥非法");
        }
    }

    public static boolean a(byte[] bArr, java.security.PublicKey publicKey, byte[] bArr2) {
        java.security.Signature signature = java.security.Signature.getInstance("MD5withRSA");
        signature.initVerify(publicKey);
        signature.update(bArr);
        return signature.verify(bArr2);
    }
}
