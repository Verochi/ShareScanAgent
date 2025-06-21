package com.huawei.secure.android.common.encrypt.aes;

/* loaded from: classes22.dex */
public final class AesGcm {
    public static int a(byte[] bArr) {
        return bArr[12] == 58 ? 12 : -1;
    }

    public static java.lang.String b(java.lang.String str) {
        return (android.text.TextUtils.isEmpty(str) || str.length() < 24) ? "" : str.substring(24);
    }

    public static byte[] c(java.lang.String str, byte[] bArr, byte[] bArr2) {
        if (android.text.TextUtils.isEmpty(str)) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCM", "encrypt 5 content is null");
            return new byte[0];
        }
        if (bArr == null) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCM", "encrypt 5 key is null");
            return new byte[0];
        }
        if (bArr.length < 16) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCM", "encrypt 5 key lengh is not right");
            return new byte[0];
        }
        if (bArr2 == null) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCM", "encrypt 5 iv is null");
            return new byte[0];
        }
        if (bArr2.length < 12) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCM", "encrypt 5 iv lengh is not right");
            return new byte[0];
        }
        if (!isBuildVersionHigherThan19()) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCM", "encrypt 5 build version not higher than 19");
            return new byte[0];
        }
        try {
            return encrypt(str.getBytes("UTF-8"), bArr, bArr2);
        } catch (java.io.UnsupportedEncodingException e) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCM", "GCM encrypt data error" + e.getMessage());
            return new byte[0];
        }
    }

    public static byte[] d(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        java.lang.System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        java.lang.System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    public static java.lang.String decrypt(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str)) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCM", "decrypt 1 content is null");
            return "";
        }
        if (android.text.TextUtils.isEmpty(str2)) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCM", "decrypt 1 key is null");
            return "";
        }
        if (!isBuildVersionHigherThan19()) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCM", "decrypt 1 build version not higher than 19");
            return "";
        }
        byte[] hexStr2ByteArray = com.huawei.secure.android.common.encrypt.utils.HexUtil.hexStr2ByteArray(str2);
        if (hexStr2ByteArray.length >= 16) {
            return decrypt(str, hexStr2ByteArray);
        }
        com.huawei.secure.android.common.encrypt.utils.b.b("GCM", "decrypt 1 key length is not right");
        return "";
    }

    public static java.lang.String decrypt(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (android.text.TextUtils.isEmpty(str)) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCM", "decrypt 3 content is null");
            return "";
        }
        if (android.text.TextUtils.isEmpty(str2)) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCM", "decrypt 3 key is null");
            return "";
        }
        if (android.text.TextUtils.isEmpty(str3)) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCM", "decrypt 3 iv is null");
            return "";
        }
        if (!isBuildVersionHigherThan19()) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCM", "decrypt 3 build version not higher than 19");
            return "";
        }
        byte[] hexStr2ByteArray = com.huawei.secure.android.common.encrypt.utils.HexUtil.hexStr2ByteArray(str2);
        byte[] hexStr2ByteArray2 = com.huawei.secure.android.common.encrypt.utils.HexUtil.hexStr2ByteArray(str3);
        if (hexStr2ByteArray.length < 16) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCM", "decrypt 3 key length is not right");
            return "";
        }
        if (hexStr2ByteArray2.length >= 12) {
            return decrypt(str, hexStr2ByteArray, hexStr2ByteArray2);
        }
        com.huawei.secure.android.common.encrypt.utils.b.b("GCM", "decrypt 3 iv length is not right");
        return "";
    }

    public static java.lang.String decrypt(java.lang.String str, byte[] bArr) {
        if (android.text.TextUtils.isEmpty(str)) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCM", "decrypt 2 content is null");
            return "";
        }
        if (bArr == null) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCM", "decrypt 2 key is null");
            return "";
        }
        if (bArr.length < 16) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCM", "decrypt 2 key lengh is not right");
            return "";
        }
        if (!isBuildVersionHigherThan19()) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCM", "decrypt 2 build version not higher than 19");
            return "";
        }
        try {
            javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(bArr, "AES");
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES/GCM/NoPadding");
            java.lang.String e = e(str);
            java.lang.String b = b(str);
            if (android.text.TextUtils.isEmpty(e)) {
                com.huawei.secure.android.common.encrypt.utils.b.b("GCM", "decrypt 2 iv is null");
                return "";
            }
            if (android.text.TextUtils.isEmpty(b)) {
                com.huawei.secure.android.common.encrypt.utils.b.b("GCM", "decrypt 2 encrypt content is null");
                return "";
            }
            cipher.init(2, secretKeySpec, getGcmAlgorithmParams(com.huawei.secure.android.common.encrypt.utils.HexUtil.hexStr2ByteArray(e)));
            return new java.lang.String(cipher.doFinal(com.huawei.secure.android.common.encrypt.utils.HexUtil.hexStr2ByteArray(b)), "UTF-8");
        } catch (java.io.UnsupportedEncodingException | java.security.GeneralSecurityException e2) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCM", "GCM decrypt data exception: " + e2.getMessage());
            return "";
        }
    }

    public static java.lang.String decrypt(java.lang.String str, byte[] bArr, byte[] bArr2) {
        if (android.text.TextUtils.isEmpty(str)) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCM", "decrypt 4 content is null");
            return "";
        }
        if (bArr == null) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCM", "decrypt 4 key is null");
            return "";
        }
        if (bArr.length < 16) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCM", "decrypt 4 key lengh is not right");
            return "";
        }
        if (bArr2 == null) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCM", "decrypt 4 iv is null");
            return "";
        }
        if (bArr2.length < 12) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCM", "decrypt 4 iv lengh is not right");
            return "";
        }
        if (!isBuildVersionHigherThan19()) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCM", "decrypt 4 build version not higher than 19");
            return "";
        }
        try {
            return new java.lang.String(decrypt(com.huawei.secure.android.common.encrypt.utils.HexUtil.hexStr2ByteArray(str), bArr, bArr2), "UTF-8");
        } catch (java.io.UnsupportedEncodingException e) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCM", "GCM decrypt data exception: " + e.getMessage());
            return "";
        }
    }

    public static byte[] decrypt(byte[] bArr, byte[] bArr2) {
        return decrypt(f(bArr), bArr2, g(bArr));
    }

    public static byte[] decrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr == null) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCM", "decrypt 6 content is null");
            return new byte[0];
        }
        if (bArr.length == 0) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCM", "decrypt 6 content length is 0");
            return new byte[0];
        }
        if (bArr2 == null) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCM", "decrypt 6 key is null");
            return new byte[0];
        }
        if (bArr2.length < 16) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCM", "decrypt 6 key length is error");
            return new byte[0];
        }
        if (bArr3 == null) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCM", "decrypt 6 iv is null");
            return new byte[0];
        }
        if (bArr3.length < 12) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCM", "decrypt 6 iv length is error");
            return new byte[0];
        }
        if (!isBuildVersionHigherThan19()) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCM", "decrypt 6 build version not higher than 19");
            return new byte[0];
        }
        try {
            javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(bArr2, "AES");
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(2, secretKeySpec, getGcmAlgorithmParams(bArr3));
            return cipher.doFinal(bArr);
        } catch (java.security.GeneralSecurityException e) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCM", "GCM decrypt data exception: " + e.getMessage());
            return new byte[0];
        }
    }

    public static java.lang.String decryptWithCryptHead(java.lang.String str, byte[] bArr) {
        if (!android.text.TextUtils.isEmpty(str) && bArr != null && bArr.length >= 16) {
            java.lang.String h = com.huawei.secure.android.common.encrypt.aes.AesCbc.h(str);
            if ("".equals(h)) {
                return "";
            }
            int indexOf = h.indexOf(58);
            if (indexOf >= 0) {
                return decrypt(com.huawei.secure.android.common.encrypt.utils.HexUtil.byteArray2HexStr(com.huawei.secure.android.common.encrypt.utils.HexUtil.hexStr2ByteArray(h.substring(indexOf + 1))), bArr, com.huawei.secure.android.common.encrypt.utils.HexUtil.hexStr2ByteArray(h.substring(0, indexOf)));
            }
            com.huawei.secure.android.common.encrypt.utils.b.b("GCM", " gcm cipherText data missing colon");
        }
        return "";
    }

    public static java.lang.String decryptWithCryptHead(byte[] bArr, byte[] bArr2) {
        try {
            return new java.lang.String(decryptWithCryptHeadReturnByte(bArr, bArr2), "UTF-8");
        } catch (java.io.UnsupportedEncodingException unused) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCM", "UnsupportedEncodingException");
            return "";
        }
    }

    public static byte[] decryptWithCryptHeadReturnByte(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr2.length < 16) {
            return new byte[0];
        }
        byte[] j = com.huawei.secure.android.common.encrypt.aes.AesCbc.j(bArr);
        if (j.length == 0) {
            return new byte[0];
        }
        int a = a(j);
        if (a < 0) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCM", " gcm cipherText data missing colon");
            return new byte[0];
        }
        byte[] copyOf = java.util.Arrays.copyOf(j, a);
        int length = (j.length - copyOf.length) - 1;
        byte[] bArr3 = new byte[length];
        java.lang.System.arraycopy(j, a + 1, bArr3, 0, length);
        return decrypt(bArr3, bArr2, copyOf);
    }

    public static java.lang.String e(java.lang.String str) {
        if (!android.text.TextUtils.isEmpty(str) && str.length() >= 24) {
            return str.substring(0, 24);
        }
        com.huawei.secure.android.common.encrypt.utils.b.b("GCM", "IV is invalid.");
        return "";
    }

    public static java.lang.String encrypt(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str)) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCM", "encrypt 1 content is null");
            return "";
        }
        if (android.text.TextUtils.isEmpty(str2)) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCM", "encrypt 1 key is null");
            return "";
        }
        if (!isBuildVersionHigherThan19()) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCM", "encrypt 1 build version not higher than 19");
            return "";
        }
        byte[] hexStr2ByteArray = com.huawei.secure.android.common.encrypt.utils.HexUtil.hexStr2ByteArray(str2);
        if (hexStr2ByteArray.length >= 16) {
            return encrypt(str, hexStr2ByteArray);
        }
        com.huawei.secure.android.common.encrypt.utils.b.b("GCM", "encrypt 1 key length is not right");
        return "";
    }

    public static java.lang.String encrypt(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (android.text.TextUtils.isEmpty(str)) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCM", "encrypt 3 content is null");
            return "";
        }
        if (android.text.TextUtils.isEmpty(str2)) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCM", "encrypt 3 key is null");
            return "";
        }
        if (android.text.TextUtils.isEmpty(str3)) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCM", "encrypt 3 iv is null");
            return "";
        }
        if (!isBuildVersionHigherThan19()) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCM", "encrypt 3 build version not higher than 19");
            return "";
        }
        byte[] hexStr2ByteArray = com.huawei.secure.android.common.encrypt.utils.HexUtil.hexStr2ByteArray(str2);
        byte[] hexStr2ByteArray2 = com.huawei.secure.android.common.encrypt.utils.HexUtil.hexStr2ByteArray(str3);
        if (hexStr2ByteArray.length < 16) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCM", "encrypt 3 key length is not right");
            return "";
        }
        if (hexStr2ByteArray2.length >= 12) {
            return encrypt(str, hexStr2ByteArray, hexStr2ByteArray2);
        }
        com.huawei.secure.android.common.encrypt.utils.b.b("GCM", "encrypt 3 iv length is not right");
        return "";
    }

    public static java.lang.String encrypt(java.lang.String str, byte[] bArr) {
        if (android.text.TextUtils.isEmpty(str)) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCM", "encrypt 2 content is null");
            return "";
        }
        if (bArr == null) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCM", "encrypt 2 key is null");
            return "";
        }
        if (bArr.length < 16) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCM", "encrypt 2 key lengh is not right");
            return "";
        }
        if (!isBuildVersionHigherThan19()) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCM", "encrypt 2 build version not higher than 19");
            return "";
        }
        byte[] generateSecureRandom = com.huawei.secure.android.common.encrypt.utils.EncryptUtil.generateSecureRandom(12);
        byte[] c = c(str, bArr, generateSecureRandom);
        if (c == null || c.length == 0) {
            return "";
        }
        return com.huawei.secure.android.common.encrypt.utils.HexUtil.byteArray2HexStr(generateSecureRandom) + com.huawei.secure.android.common.encrypt.utils.HexUtil.byteArray2HexStr(c);
    }

    public static java.lang.String encrypt(java.lang.String str, byte[] bArr, byte[] bArr2) {
        if (android.text.TextUtils.isEmpty(str)) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCM", "encrypt 4 content is null");
            return "";
        }
        if (bArr == null) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCM", "encrypt 4 key is null");
            return "";
        }
        if (bArr.length < 16) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCM", "encrypt 4 key lengh is not right");
            return "";
        }
        if (bArr2 == null) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCM", "encrypt 4 iv is null");
            return "";
        }
        if (bArr2.length < 12) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCM", "encrypt 4 iv lengh is not right");
            return "";
        }
        if (isBuildVersionHigherThan19()) {
            return com.huawei.secure.android.common.encrypt.utils.HexUtil.byteArray2HexStr(c(str, bArr, bArr2));
        }
        com.huawei.secure.android.common.encrypt.utils.b.b("GCM", "encrypt 4 build version not higher than 19");
        return "";
    }

    public static byte[] encrypt(byte[] bArr, byte[] bArr2) {
        byte[] generateSecureRandom = com.huawei.secure.android.common.encrypt.utils.EncryptUtil.generateSecureRandom(12);
        return d(generateSecureRandom, encrypt(bArr, bArr2, generateSecureRandom));
    }

    public static byte[] encrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr == null) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCM", "encrypt 6 content is null");
            return new byte[0];
        }
        if (bArr.length == 0) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCM", "encrypt 6 content length is 0");
            return new byte[0];
        }
        if (bArr2 == null) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCM", "encrypt 6 key is null");
            return new byte[0];
        }
        if (bArr2.length < 16) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCM", "encrypt 6 key length is error");
            return new byte[0];
        }
        if (bArr3 == null) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCM", "encrypt 6 iv is null");
            return new byte[0];
        }
        if (bArr3.length < 12) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCM", "encrypt 6 iv length is error");
            return new byte[0];
        }
        if (!isBuildVersionHigherThan19()) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCM", "encrypt 6 build version not higher than 19");
            return new byte[0];
        }
        try {
            javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(bArr2, "AES");
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(1, secretKeySpec, getGcmAlgorithmParams(bArr3));
            return cipher.doFinal(bArr);
        } catch (java.security.GeneralSecurityException e) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCM", "GCM encrypt data error" + e.getMessage());
            return new byte[0];
        }
    }

    public static byte[] f(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length - 12];
        java.lang.System.arraycopy(bArr, 12, bArr2, 0, bArr.length - 12);
        return bArr2;
    }

    public static byte[] g(byte[] bArr) {
        byte[] bArr2 = new byte[12];
        java.lang.System.arraycopy(bArr, 0, bArr2, 0, 12);
        return bArr2;
    }

    public static java.security.spec.AlgorithmParameterSpec getGcmAlgorithmParams(byte[] bArr) {
        return new javax.crypto.spec.GCMParameterSpec(128, bArr);
    }

    public static boolean isBuildVersionHigherThan19() {
        return true;
    }
}
