package com.heytap.msp.push.encrypt;

/* loaded from: classes22.dex */
public class AESEncrypt {
    private static final java.lang.String ALGORITHM = "AES";
    private static final java.lang.String IV_CONNECT = "%IV1%";
    private static final int KEY_BYTE_SIZE = 256;
    public static final java.lang.String SDK_APP_SECRET = "isvrbeT7qUywVEZ1Ia0/aUVA/TcFaeV0wC8qFLc8rg4=";
    private static final java.lang.String TRANSFORMATION = "AES/CTR/NoPadding";

    public static java.lang.String decrypt(java.lang.String str, java.lang.String str2) {
        java.lang.String[] split = str2.split(IV_CONNECT);
        byte[] b = com.heytap.msp.push.encrypt.a.b(split[0]);
        byte[] b2 = com.heytap.msp.push.encrypt.a.b(split[1]);
        javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(com.heytap.msp.push.encrypt.a.b(str), ALGORITHM);
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(TRANSFORMATION);
        cipher.init(2, secretKeySpec, new javax.crypto.spec.IvParameterSpec(b2));
        return new java.lang.String(cipher.doFinal(b));
    }

    public static java.lang.String encrypt(java.lang.String str) {
        try {
            return encrypt(SDK_APP_SECRET, str);
        } catch (java.lang.Exception e) {
            com.heytap.mcssdk.utils.d.b(e.getLocalizedMessage());
            return "";
        }
    }

    public static java.lang.String encrypt(java.lang.String str, java.lang.String str2) {
        javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(com.heytap.msp.push.encrypt.a.b(str), ALGORITHM);
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(TRANSFORMATION);
        cipher.init(1, secretKeySpec);
        java.lang.String d = com.heytap.msp.push.encrypt.a.d(cipher.getIV());
        return com.heytap.msp.push.encrypt.a.d(cipher.doFinal(str2.getBytes())) + IV_CONNECT + d;
    }

    public static java.lang.String genKey() {
        javax.crypto.KeyGenerator keyGenerator = javax.crypto.KeyGenerator.getInstance(ALGORITHM);
        keyGenerator.init(256);
        return com.heytap.msp.push.encrypt.a.d(keyGenerator.generateKey().getEncoded());
    }
}
