package com.loc;

/* loaded from: classes23.dex */
public final class ao {
    public static java.security.PublicKey a(java.lang.String str) throws java.lang.Exception {
        try {
            return java.security.KeyFactory.getInstance(com.loc.y.c("EUlNB")).generatePublic(new java.security.spec.X509EncodedKeySpec(com.loc.ak.a(str)));
        } catch (java.lang.NullPointerException unused) {
            throw new java.lang.Exception("公钥数据为空");
        } catch (java.security.NoSuchAlgorithmException unused2) {
            throw new java.lang.Exception("无此算法");
        } catch (java.security.spec.InvalidKeySpecException unused3) {
            throw new java.lang.Exception("公钥非法");
        }
    }

    public static byte[] a(byte[] bArr, java.security.PublicKey publicKey) {
        try {
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(com.loc.y.c("CUlNBL0VDQi9QS0NTMVBhZGRpbmc"));
            cipher.init(1, publicKey);
            return cipher.doFinal(bArr);
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }
}
