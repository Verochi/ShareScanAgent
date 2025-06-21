package com.huawei.agconnect.config.impl;

/* loaded from: classes22.dex */
class i {
    public static javax.crypto.SecretKey a(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, int i) throws java.security.NoSuchAlgorithmException, java.security.spec.InvalidKeySpecException {
        if (bArr.length != 16 || bArr2.length != 16 || bArr3.length != 16) {
            throw new java.lang.IllegalArgumentException("invalid data for generating the key.");
        }
        return new javax.crypto.spec.SecretKeySpec(javax.crypto.SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(new javax.crypto.spec.PBEKeySpec(com.huawei.agconnect.config.impl.Hex.encodeHexString(e(bArr, bArr2, bArr3)).toCharArray(), bArr4, i, 128)).getEncoded(), "AES");
    }

    public static byte[] b(javax.crypto.SecretKey secretKey, byte[] bArr) throws java.security.GeneralSecurityException {
        if (secretKey == null || bArr == null) {
            throw new java.lang.NullPointerException("key or cipherText must not be null.");
        }
        byte[] copyOfRange = java.util.Arrays.copyOfRange(bArr, 1, 17);
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, secretKey, new javax.crypto.spec.IvParameterSpec(copyOfRange));
        return cipher.doFinal(bArr, copyOfRange.length + 1, (bArr.length - copyOfRange.length) - 1);
    }

    public static byte[] c(byte[] bArr, int i) {
        if (bArr == null) {
            throw new java.lang.NullPointerException("bytes must not be null.");
        }
        for (int i2 = 0; i2 < bArr.length; i2++) {
            if (i < 0) {
                bArr[i2] = (byte) (bArr[i2] << (-i));
            } else {
                bArr[i2] = (byte) (bArr[i2] >> i);
            }
        }
        return bArr;
    }

    public static byte[] d(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            throw new java.lang.NullPointerException("left or right must not be null.");
        }
        if (bArr.length != bArr2.length) {
            throw new java.lang.IllegalArgumentException("left and right must be the same length.");
        }
        byte[] bArr3 = new byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            bArr3[i] = (byte) (bArr[i] ^ bArr2[i]);
        }
        return bArr3;
    }

    public static byte[] e(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return d(c(d(c(bArr, -4), bArr2), 6), bArr3);
    }
}
