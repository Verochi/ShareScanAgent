package com.huawei.secure.android.common.encrypt.aes;

/* loaded from: classes22.dex */
public class CipherUtil {
    public static int a(javax.crypto.Cipher cipher, byte[] bArr) {
        if (cipher == null || bArr == null) {
            return -1;
        }
        return cipher.getOutputSize(bArr.length);
    }

    public static javax.crypto.Cipher b(byte[] bArr, byte[] bArr2, int i) {
        return c(bArr, bArr2, i, "AES/CBC/PKCS5Padding");
    }

    public static javax.crypto.Cipher c(byte[] bArr, byte[] bArr2, int i, java.lang.String str) {
        if (bArr == null || bArr.length < 16 || bArr2 == null || bArr2.length < 12 || !com.huawei.secure.android.common.encrypt.aes.AesGcm.isBuildVersionHigherThan19()) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CipherUtil", "gcm encrypt param is not right");
            return null;
        }
        try {
            javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(bArr, "AES");
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(str);
            cipher.init(i, secretKeySpec, "AES/GCM/NoPadding".equals(str) ? com.huawei.secure.android.common.encrypt.aes.AesGcm.getGcmAlgorithmParams(bArr2) : new javax.crypto.spec.IvParameterSpec(bArr2));
            return cipher;
        } catch (java.security.GeneralSecurityException e) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CipherUtil", "GCM encrypt data error" + e.getMessage());
            return null;
        }
    }

    public static javax.crypto.Cipher d(byte[] bArr, byte[] bArr2, int i) {
        return c(bArr, bArr2, i, "AES/GCM/NoPadding");
    }

    public static javax.crypto.Cipher getAesCbcDecryptCipher(byte[] bArr, javax.crypto.Cipher cipher) {
        return getAesCbcDecryptCipher(bArr, cipher.getIV());
    }

    public static javax.crypto.Cipher getAesCbcDecryptCipher(byte[] bArr, byte[] bArr2) {
        return b(bArr, bArr2, 2);
    }

    public static javax.crypto.Cipher getAesCbcEncryptCipher(byte[] bArr) {
        return getAesCbcEncryptCipher(bArr, com.huawei.secure.android.common.encrypt.utils.EncryptUtil.generateSecureRandom(16));
    }

    public static javax.crypto.Cipher getAesCbcEncryptCipher(byte[] bArr, byte[] bArr2) {
        return b(bArr, bArr2, 1);
    }

    public static int getAesCbcEncryptContentLen(byte[] bArr, byte[] bArr2) {
        return getAesCbcEncryptContentLen(bArr, bArr2, com.huawei.secure.android.common.encrypt.utils.EncryptUtil.generateSecureRandom(16));
    }

    public static int getAesCbcEncryptContentLen(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return a(getAesCbcEncryptCipher(bArr2, bArr3), bArr);
    }

    public static javax.crypto.Cipher getAesGcmDecryptCipher(byte[] bArr, javax.crypto.Cipher cipher) {
        return getAesGcmDecryptCipher(bArr, cipher.getIV());
    }

    public static javax.crypto.Cipher getAesGcmDecryptCipher(byte[] bArr, byte[] bArr2) {
        return d(bArr, bArr2, 2);
    }

    public static javax.crypto.Cipher getAesGcmEncryptCipher(byte[] bArr) {
        byte[] generateSecureRandom = com.huawei.secure.android.common.encrypt.utils.EncryptUtil.generateSecureRandom(12);
        com.huawei.secure.android.common.encrypt.utils.b.a("CipherUtil", "getEncryptCipher: iv is : " + com.huawei.secure.android.common.encrypt.utils.HexUtil.byteArray2HexStr(generateSecureRandom));
        return getAesGcmEncryptCipher(bArr, generateSecureRandom);
    }

    public static javax.crypto.Cipher getAesGcmEncryptCipher(byte[] bArr, byte[] bArr2) {
        return d(bArr, bArr2, 1);
    }

    public static int getAesGcmEncryptContentLen(byte[] bArr, byte[] bArr2) {
        return getAesGcmEncryptContentLen(bArr, bArr2, com.huawei.secure.android.common.encrypt.utils.EncryptUtil.generateSecureRandom(12));
    }

    public static int getAesGcmEncryptContentLen(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return a(getAesGcmEncryptCipher(bArr2, bArr3), bArr);
    }

    public static int getContent(javax.crypto.Cipher cipher, byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws javax.crypto.BadPaddingException, javax.crypto.IllegalBlockSizeException, javax.crypto.ShortBufferException {
        if (cipher != null && bArr != null) {
            return cipher.doFinal(bArr, i, i2, bArr2, i3);
        }
        com.huawei.secure.android.common.encrypt.utils.b.b("CipherUtil", "getEncryptCOntent: cipher is null or content is null");
        return -1;
    }

    public static int getContent(javax.crypto.Cipher cipher, byte[] bArr, byte[] bArr2) {
        if (cipher == null || bArr == null) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CipherUtil", "getEncryptCOntent: cipher is null or content is null");
            return -1;
        }
        try {
            return cipher.doFinal(bArr, 0, bArr.length, bArr2);
        } catch (javax.crypto.BadPaddingException unused) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CipherUtil", "getContent: BadPaddingException");
            return -1;
        } catch (javax.crypto.IllegalBlockSizeException unused2) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CipherUtil", "getContent: IllegalBlockSizeException");
            return -1;
        } catch (javax.crypto.ShortBufferException unused3) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CipherUtil", "getContent: ShortBufferException");
            return -1;
        }
    }

    public static byte[] getContent(javax.crypto.Cipher cipher, byte[] bArr) {
        if (cipher == null || bArr == null) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CipherUtil", "getEncryptCOntent: cipher is null or content is null");
            return new byte[0];
        }
        try {
            return cipher.doFinal(bArr, 0, bArr.length);
        } catch (javax.crypto.BadPaddingException unused) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CipherUtil", "getContent: BadPaddingException");
            return new byte[0];
        } catch (javax.crypto.IllegalBlockSizeException unused2) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CipherUtil", "getContent: IllegalBlockSizeException");
            return new byte[0];
        }
    }
}
