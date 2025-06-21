package com.huawei.secure.android.common.encrypt.hash;

/* loaded from: classes22.dex */
public final class SHA {
    public static final java.lang.String a = "SHA";
    public static final java.lang.String[] b = {"SHA-256", "SHA-384", "SHA-512"};

    public static boolean a(java.lang.String str) {
        for (java.lang.String str2 : b) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static java.lang.String sha256Encrypt(java.lang.String str) {
        return shaEncrypt(str, "SHA-256");
    }

    public static java.lang.String shaEncrypt(java.lang.String str, java.lang.String str2) {
        byte[] bArr;
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "content or algorithm is null.");
            return "";
        }
        if (!a(str2)) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "algorithm is not safe or legal");
            return "";
        }
        try {
            bArr = str.getBytes("UTF-8");
        } catch (java.io.UnsupportedEncodingException unused) {
            bArr = new byte[0];
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "Error in generate SHA UnsupportedEncodingException");
        }
        return com.huawei.secure.android.common.encrypt.utils.HexUtil.byteArray2HexStr(shaEncryptByte(bArr, str2));
    }

    public static byte[] shaEncryptByte(byte[] bArr, java.lang.String str) {
        if (bArr == null || android.text.TextUtils.isEmpty(str)) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "content or algorithm is null.");
            return new byte[0];
        }
        if (!a(str)) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "algorithm is not safe or legal");
            return new byte[0];
        }
        try {
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance(str);
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (java.security.NoSuchAlgorithmException unused) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "Error in generate SHA NoSuchAlgorithmException");
            return new byte[0];
        }
    }

    public static boolean validateSHA(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2) || android.text.TextUtils.isEmpty(str3)) {
            return false;
        }
        return str2.equals(shaEncrypt(str, str3));
    }

    public static boolean validateSHA256(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            return false;
        }
        return str2.equals(sha256Encrypt(str));
    }
}
