package com.sensorsdata.analytics.android.sdk.encrypt.utils;

/* loaded from: classes19.dex */
public class EncryptUtils {
    private static final java.lang.String TAG = "SensorsDataEncrypt";

    public static java.lang.String encryptAESKey(java.lang.String str, byte[] bArr, java.lang.String str2) {
        return publicKeyEncrypt(str, str2, bArr);
    }

    public static byte[] generateSymmetricKey(com.sensorsdata.analytics.android.sdk.encrypt.encryptor.SymmetricEncryptMode symmetricEncryptMode) throws java.security.NoSuchAlgorithmException {
        javax.crypto.KeyGenerator keyGenerator = javax.crypto.KeyGenerator.getInstance(symmetricEncryptMode.algorithm);
        keyGenerator.init(128);
        return keyGenerator.generateKey().getEncoded();
    }

    public static boolean isECEncrypt() {
        try {
            java.lang.Class.forName("org.spongycastle.jce.provider.BouncyCastleProvider");
            return true;
        } catch (java.lang.Exception unused) {
            com.sensorsdata.analytics.android.sdk.SALog.i("SA.Encrypt", "No integrated ECC encryption library");
            return false;
        }
    }

    private static java.lang.String publicKeyEncrypt(java.lang.String str, java.lang.String str2, byte[] bArr) {
        javax.crypto.Cipher cipher;
        if (android.text.TextUtils.isEmpty(str)) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "PublicKey is null.");
            return null;
        }
        try {
            java.security.spec.X509EncodedKeySpec x509EncodedKeySpec = new java.security.spec.X509EncodedKeySpec(com.sensorsdata.analytics.android.sdk.util.Base64Coder.decode(str));
            if ("EC".equals(str2)) {
                java.security.interfaces.ECPublicKey eCPublicKey = (java.security.interfaces.ECPublicKey) java.security.KeyFactory.getInstance("EC", "SC").generatePublic(x509EncodedKeySpec);
                cipher = javax.crypto.Cipher.getInstance("ECIES", "SC");
                cipher.init(1, eCPublicKey);
            } else {
                java.security.PublicKey generatePublic = java.security.KeyFactory.getInstance(com.alipay.sdk.m.n.d.a).generatePublic(x509EncodedKeySpec);
                cipher = javax.crypto.Cipher.getInstance("RSA/None/PKCS1Padding");
                cipher.init(1, generatePublic);
            }
            int length = bArr.length;
            java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            int i = 0;
            while (true) {
                int i2 = length - i;
                if (i2 <= 0) {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    return new java.lang.String(com.sensorsdata.analytics.android.sdk.util.Base64Coder.encode(byteArray));
                }
                byte[] doFinal = i2 > 245 ? cipher.doFinal(bArr, i, 245) : cipher.doFinal(bArr, i, i2);
                byteArrayOutputStream.write(doFinal, 0, doFinal.length);
                i += 245;
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return null;
        }
    }

    public static java.lang.String symmetricEncrypt(byte[] bArr, byte[] bArr2, com.sensorsdata.analytics.android.sdk.encrypt.encryptor.SymmetricEncryptMode symmetricEncryptMode) {
        if (bArr != null && bArr2 != null) {
            try {
                byte[] bArr3 = new byte[16];
                new java.security.SecureRandom().nextBytes(bArr3);
                javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(bArr, symmetricEncryptMode.algorithm);
                javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(symmetricEncryptMode.transformation);
                cipher.init(1, secretKeySpec, new javax.crypto.spec.IvParameterSpec(bArr3));
                byte[] doFinal = cipher.doFinal(bArr2);
                java.nio.ByteBuffer allocate = java.nio.ByteBuffer.allocate(16 + doFinal.length);
                allocate.put(bArr3);
                allocate.put(doFinal);
                return new java.lang.String(com.sensorsdata.analytics.android.sdk.util.Base64Coder.encode(allocate.array()));
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
        return null;
    }
}
