package com.huawei.secure.android.common.encrypt.rsa;

/* loaded from: classes22.dex */
public abstract class RSAEncrypt {
    public static java.lang.String decrypt(java.lang.String str, java.lang.String str2) {
        if (!android.text.TextUtils.isEmpty(str) && !android.text.TextUtils.isEmpty(str2)) {
            return decrypt(str, com.huawei.secure.android.common.encrypt.utils.EncryptUtil.getPrivateKey(str2));
        }
        com.huawei.secure.android.common.encrypt.utils.b.b("RSAEncrypt", "content or private key is null");
        return "";
    }

    public static java.lang.String decrypt(java.lang.String str, java.security.PrivateKey privateKey) {
        if (android.text.TextUtils.isEmpty(str) || privateKey == null || !isPrivateKeyLengthRight((java.security.interfaces.RSAPrivateKey) privateKey)) {
            com.huawei.secure.android.common.encrypt.utils.b.b("RSAEncrypt", "content or privateKey is null , or length is too short");
            return "";
        }
        try {
            return new java.lang.String(decrypt(android.util.Base64.decode(str, 0), privateKey), "UTF-8");
        } catch (java.io.UnsupportedEncodingException e) {
            com.huawei.secure.android.common.encrypt.utils.b.b("RSAEncrypt", "RSA decrypt exception : " + e.getMessage());
            return "";
        } catch (java.lang.Exception e2) {
            com.huawei.secure.android.common.encrypt.utils.b.b("RSAEncrypt", "exception : " + e2.getMessage());
            return "";
        }
    }

    public static byte[] decrypt(byte[] bArr, java.security.PrivateKey privateKey) {
        byte[] bArr2 = new byte[0];
        if (bArr == null || privateKey == null || !isPrivateKeyLengthRight((java.security.interfaces.RSAPrivateKey) privateKey)) {
            com.huawei.secure.android.common.encrypt.utils.b.b("RSAEncrypt", "content or privateKey is null , or length is too short");
            return bArr2;
        }
        try {
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
            cipher.init(2, privateKey);
            return cipher.doFinal(bArr);
        } catch (java.security.GeneralSecurityException e) {
            com.huawei.secure.android.common.encrypt.utils.b.b("RSAEncrypt", "RSA decrypt exception : " + e.getMessage());
            return bArr2;
        }
    }

    public static java.lang.String encrypt(java.lang.String str, java.lang.String str2) {
        if (!android.text.TextUtils.isEmpty(str) && !android.text.TextUtils.isEmpty(str2)) {
            return encrypt(str, com.huawei.secure.android.common.encrypt.utils.EncryptUtil.getPublicKey(str2));
        }
        com.huawei.secure.android.common.encrypt.utils.b.b("RSAEncrypt", "content or public key is null");
        return "";
    }

    public static java.lang.String encrypt(java.lang.String str, java.security.PublicKey publicKey) {
        if (android.text.TextUtils.isEmpty(str) || publicKey == null || !isPublicKeyLengthRight((java.security.interfaces.RSAPublicKey) publicKey)) {
            com.huawei.secure.android.common.encrypt.utils.b.b("RSAEncrypt", "content or PublicKey is null , or length is too short");
            return "";
        }
        try {
            return android.util.Base64.encodeToString(encrypt(str.getBytes("UTF-8"), publicKey), 0);
        } catch (java.io.UnsupportedEncodingException unused) {
            com.huawei.secure.android.common.encrypt.utils.b.b("RSAEncrypt", "encrypt: UnsupportedEncodingException");
            return "";
        } catch (java.lang.Exception e) {
            com.huawei.secure.android.common.encrypt.utils.b.b("RSAEncrypt", "exception : " + e.getMessage());
            return "";
        }
    }

    public static byte[] encrypt(byte[] bArr, java.security.PublicKey publicKey) {
        byte[] bArr2 = new byte[0];
        if (bArr == null || publicKey == null || !isPublicKeyLengthRight((java.security.interfaces.RSAPublicKey) publicKey)) {
            com.huawei.secure.android.common.encrypt.utils.b.b("RSAEncrypt", "content or PublicKey is null , or length is too short");
            return bArr2;
        }
        try {
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
            cipher.init(1, publicKey);
            return cipher.doFinal(bArr);
        } catch (java.security.GeneralSecurityException e) {
            com.huawei.secure.android.common.encrypt.utils.b.b("RSAEncrypt", "RSA encrypt exception : " + e.getMessage());
            return bArr2;
        }
    }

    public static java.util.Map<java.lang.String, java.security.Key> generateRSAKeyPair(int i) throws java.security.NoSuchAlgorithmException {
        java.util.HashMap hashMap = new java.util.HashMap(2);
        if (i < 2048) {
            com.huawei.secure.android.common.encrypt.utils.b.b("RSAEncrypt", "generateRSAKeyPair: key length is too short");
            return hashMap;
        }
        java.security.SecureRandom genSecureRandom = com.huawei.secure.android.common.encrypt.utils.EncryptUtil.genSecureRandom();
        java.security.KeyPairGenerator keyPairGenerator = java.security.KeyPairGenerator.getInstance(com.alipay.sdk.m.n.d.a);
        keyPairGenerator.initialize(i, genSecureRandom);
        java.security.KeyPair generateKeyPair = keyPairGenerator.generateKeyPair();
        java.security.PublicKey publicKey = generateKeyPair.getPublic();
        java.security.PrivateKey privateKey = generateKeyPair.getPrivate();
        hashMap.put("publicKey", publicKey);
        hashMap.put("privateKey", privateKey);
        return hashMap;
    }

    public static boolean isPrivateKeyLengthRight(java.security.interfaces.RSAPrivateKey rSAPrivateKey) {
        return rSAPrivateKey != null && rSAPrivateKey.getModulus().bitLength() >= 2048;
    }

    public static boolean isPublicKeyLengthRight(java.security.interfaces.RSAPublicKey rSAPublicKey) {
        return rSAPublicKey != null && rSAPublicKey.getModulus().bitLength() >= 2048;
    }
}
