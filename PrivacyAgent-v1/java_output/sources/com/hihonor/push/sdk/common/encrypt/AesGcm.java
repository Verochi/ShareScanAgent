package com.hihonor.push.sdk.common.encrypt;

/* loaded from: classes22.dex */
public class AesGcm {
    private static final java.lang.String TAG = "AesGcm";

    public static java.lang.String decrypt(java.lang.String str, byte[] bArr) {
        if (!android.text.TextUtils.isEmpty(str) && bArr != null && bArr.length >= 16) {
            try {
                javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(bArr, "AES");
                javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES/GCM/NoPadding");
                java.lang.String substring = str.substring(0, 24);
                java.lang.String substring2 = str.substring(24);
                if (!android.text.TextUtils.isEmpty(substring) && !android.text.TextUtils.isEmpty(substring2)) {
                    cipher.init(2, secretKeySpec, new javax.crypto.spec.GCMParameterSpec(128, com.hihonor.push.sdk.common.encrypt.HexUtils.hexStr2ByteArray(substring)));
                    return new java.lang.String(cipher.doFinal(com.hihonor.push.sdk.common.encrypt.HexUtils.hexStr2ByteArray(substring2)), java.nio.charset.StandardCharsets.UTF_8);
                }
            } catch (java.lang.Exception e) {
                com.hihonor.push.sdk.common.logger.Logger.e(TAG, "GCM decrypt data exception: " + e.getMessage());
            }
        }
        return "";
    }

    public static java.lang.String encrypt(java.lang.String str, byte[] bArr) {
        if (!android.text.TextUtils.isEmpty(str) && bArr != null && bArr.length >= 16) {
            try {
                byte[] generateSecureRandom = generateSecureRandom(12);
                byte[] bytes = str.getBytes(java.nio.charset.StandardCharsets.UTF_8);
                javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(bArr, "AES");
                javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES/GCM/NoPadding");
                cipher.init(1, secretKeySpec, new javax.crypto.spec.GCMParameterSpec(128, generateSecureRandom));
                byte[] doFinal = cipher.doFinal(bytes);
                if (doFinal != null && doFinal.length != 0) {
                    return com.hihonor.push.sdk.common.encrypt.HexUtils.byteArray2HexStr(generateSecureRandom) + com.hihonor.push.sdk.common.encrypt.HexUtils.byteArray2HexStr(doFinal);
                }
            } catch (java.security.GeneralSecurityException e) {
                com.hihonor.push.sdk.common.logger.Logger.e(TAG, "GCM encrypt data error" + e.getMessage());
            }
        }
        return "";
    }

    public static byte[] generateSecureRandom(int i) {
        try {
            byte[] bArr = new byte[i];
            new java.security.SecureRandom().nextBytes(bArr);
            return bArr;
        } catch (java.lang.Exception unused) {
            return new byte[0];
        }
    }
}
