package com.huawei.secure.android.common.encrypt.hash;

/* loaded from: classes22.dex */
public abstract class HMACSHA256 {
    public static final java.lang.String a = "HMACSHA256";

    public static byte[] hmacEncrypt(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "content or key is null.");
            return new byte[0];
        }
        if (bArr2.length < 32) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "hmac key length is not right");
            return new byte[0];
        }
        try {
            javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(bArr2, "HmacSHA256");
            javax.crypto.Mac mac = javax.crypto.Mac.getInstance(secretKeySpec.getAlgorithm());
            mac.init(secretKeySpec);
            return mac.doFinal(bArr);
        } catch (java.security.InvalidKeyException | java.security.NoSuchAlgorithmException e) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "hmacsha256 encrypt exception" + e.getMessage());
            return new byte[0];
        }
    }

    public static java.lang.String hmacSHA256Encrypt(java.lang.String str, java.lang.String str2) {
        return (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) ? "" : hmacSHA256Encrypt(str, com.huawei.secure.android.common.encrypt.utils.HexUtil.hexStr2ByteArray(str2));
    }

    public static java.lang.String hmacSHA256Encrypt(java.lang.String str, byte[] bArr) {
        byte[] bArr2;
        if (android.text.TextUtils.isEmpty(str) || bArr == null) {
            return "";
        }
        if (bArr.length < 32) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "hmac key length is not right");
            return "";
        }
        try {
            bArr2 = str.getBytes("UTF-8");
        } catch (java.io.UnsupportedEncodingException e) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "hmacsha256 encrypt exception" + e.getMessage());
            bArr2 = new byte[0];
        }
        return com.huawei.secure.android.common.encrypt.utils.HexUtil.byteArray2HexStr(hmacEncrypt(bArr2, bArr));
    }
}
