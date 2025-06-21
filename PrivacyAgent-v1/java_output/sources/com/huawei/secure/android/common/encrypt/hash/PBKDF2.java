package com.huawei.secure.android.common.encrypt.hash;

/* loaded from: classes22.dex */
public abstract class PBKDF2 {
    public static final java.lang.String a = "PBKDF2";

    public static boolean a(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            return false;
        }
        int length = bArr.length ^ bArr2.length;
        for (int i = 0; i < bArr.length && i < bArr2.length; i++) {
            length |= bArr[i] ^ bArr2[i];
        }
        return length == 0;
    }

    public static byte[] b(char[] cArr, byte[] bArr, int i, int i2, boolean z) {
        try {
            return (z ? javax.crypto.SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256") : javax.crypto.SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1")).generateSecret(new javax.crypto.spec.PBEKeySpec(cArr, bArr, i, i2)).getEncoded();
        } catch (java.security.NoSuchAlgorithmException | java.security.spec.InvalidKeySpecException e) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "pbkdf exception : " + e.getMessage());
            return new byte[0];
        }
    }

    public static byte[] pbkdf2(char[] cArr, byte[] bArr, int i, int i2) {
        return b(cArr, bArr, i, i2, false);
    }

    @java.lang.Deprecated
    public static java.lang.String pbkdf2Encrypt(java.lang.String str) {
        return pbkdf2Encrypt(str, 10000);
    }

    @java.lang.Deprecated
    public static java.lang.String pbkdf2Encrypt(java.lang.String str, int i) {
        return pbkdf2Encrypt(str, com.huawei.secure.android.common.encrypt.utils.EncryptUtil.generateSecureRandom(8), i, 32);
    }

    @java.lang.Deprecated
    public static java.lang.String pbkdf2Encrypt(java.lang.String str, byte[] bArr, int i, int i2) {
        if (android.text.TextUtils.isEmpty(str)) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "pwd is null.");
            return "";
        }
        if (i < 1000) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "iterations times is not enough.");
            return "";
        }
        if (bArr == null || bArr.length < 8) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "salt parameter is null or length is not enough");
            return "";
        }
        if (i2 < 32) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "cipherLen length is not enough");
            return "";
        }
        return com.huawei.secure.android.common.encrypt.utils.HexUtil.byteArray2HexStr(bArr) + com.huawei.secure.android.common.encrypt.utils.HexUtil.byteArray2HexStr(pbkdf2(str.toCharArray(), bArr, i, i2 * 8));
    }

    public static java.lang.String pbkdf2EncryptNew(java.lang.String str) {
        return pbkdf2EncryptNew(str, 10000);
    }

    public static java.lang.String pbkdf2EncryptNew(java.lang.String str, int i) {
        return pbkdf2EncryptNew(str, com.huawei.secure.android.common.encrypt.utils.EncryptUtil.generateSecureRandom(16), i, 32);
    }

    public static java.lang.String pbkdf2EncryptNew(java.lang.String str, byte[] bArr, int i, int i2) {
        byte[] pbkdf2SHA256;
        if (android.text.TextUtils.isEmpty(str)) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "pwd is null.");
            return "";
        }
        if (i < 1000) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "iterations times is not enough.");
            return "";
        }
        if (bArr == null || bArr.length < 16) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "salt parameter is null or length is not enough");
            return "";
        }
        if (i2 < 32) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "cipherLen length is not enough");
            return "";
        }
        if (android.os.Build.VERSION.SDK_INT < 26) {
            com.huawei.secure.android.common.encrypt.utils.b.c(a, "sha 1");
            pbkdf2SHA256 = pbkdf2(str.toCharArray(), bArr, i, i2 * 8);
        } else {
            com.huawei.secure.android.common.encrypt.utils.b.c(a, "sha 256");
            pbkdf2SHA256 = pbkdf2SHA256(str.toCharArray(), bArr, i, i2 * 8);
        }
        return com.huawei.secure.android.common.encrypt.utils.HexUtil.byteArray2HexStr(bArr) + com.huawei.secure.android.common.encrypt.utils.HexUtil.byteArray2HexStr(pbkdf2SHA256);
    }

    public static byte[] pbkdf2SHA256(char[] cArr, byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[0];
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            return b(cArr, bArr, i, i2, true);
        }
        com.huawei.secure.android.common.encrypt.utils.b.b(a, "system version not high than 26");
        return bArr2;
    }

    @java.lang.Deprecated
    public static boolean validatePassword(java.lang.String str, java.lang.String str2) {
        return validatePassword(str, str2, 10000);
    }

    @java.lang.Deprecated
    public static boolean validatePassword(java.lang.String str, java.lang.String str2, int i) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2) || str2.length() < 16) {
            return false;
        }
        return a(pbkdf2(str.toCharArray(), com.huawei.secure.android.common.encrypt.utils.HexUtil.hexStr2ByteArray(str2.substring(0, 16)), i, 256), com.huawei.secure.android.common.encrypt.utils.HexUtil.hexStr2ByteArray(str2.substring(16)));
    }

    public static boolean validatePasswordNew(java.lang.String str, java.lang.String str2) {
        return validatePasswordNew(str, str2, 10000);
    }

    public static boolean validatePasswordNew(java.lang.String str, java.lang.String str2, int i) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2) || str2.length() < 32) {
            return false;
        }
        java.lang.String substring = str2.substring(0, 32);
        return a(android.os.Build.VERSION.SDK_INT < 26 ? pbkdf2(str.toCharArray(), com.huawei.secure.android.common.encrypt.utils.HexUtil.hexStr2ByteArray(substring), i, 256) : pbkdf2SHA256(str.toCharArray(), com.huawei.secure.android.common.encrypt.utils.HexUtil.hexStr2ByteArray(substring), i, 256), com.huawei.secure.android.common.encrypt.utils.HexUtil.hexStr2ByteArray(str2.substring(32)));
    }
}
