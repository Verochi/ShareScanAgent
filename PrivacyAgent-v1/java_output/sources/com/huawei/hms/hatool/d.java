package com.huawei.hms.hatool;

/* loaded from: classes22.dex */
public class d {
    public static final java.nio.charset.Charset a = java.nio.charset.Charset.forName("UTF-8");

    public static android.util.Pair<byte[], java.lang.String> a(java.lang.String str) {
        if (str == null || str.length() < 32) {
            return new android.util.Pair<>(new byte[0], str);
        }
        java.lang.String substring = str.substring(0, 32);
        return new android.util.Pair<>(com.huawei.secure.android.common.encrypt.utils.HexUtil.hexStr2ByteArray(substring), str.substring(32));
    }

    public static java.lang.String a(java.lang.String str, java.lang.String str2) {
        android.util.Pair<byte[], java.lang.String> a2 = a(str);
        return new java.lang.String(com.huawei.secure.android.common.encrypt.aes.AesCbc.decrypt(com.huawei.secure.android.common.encrypt.utils.HexUtil.hexStr2ByteArray((java.lang.String) a2.second), com.huawei.secure.android.common.encrypt.utils.HexUtil.hexStr2ByteArray(str2), (byte[]) a2.first), a);
    }

    public static java.lang.String a(byte[] bArr, java.lang.String str) {
        java.lang.String str2;
        if (bArr == null || bArr.length == 0 || str == null) {
            str2 = "cbc encrypt(byte) param is not right";
        } else {
            byte[] hexStr2ByteArray = com.huawei.secure.android.common.encrypt.utils.HexUtil.hexStr2ByteArray(str);
            if (hexStr2ByteArray.length >= 16) {
                return com.huawei.secure.android.common.encrypt.utils.HexUtil.byteArray2HexStr(com.huawei.secure.android.common.encrypt.aes.AesCbc.encrypt(bArr, hexStr2ByteArray));
            }
            str2 = "key length is not right";
        }
        com.huawei.hms.hatool.y.b("AesCipher", str2);
        return "";
    }

    public static java.lang.String b(java.lang.String str, java.lang.String str2) {
        return com.huawei.secure.android.common.encrypt.utils.HexUtil.byteArray2HexStr(com.huawei.secure.android.common.encrypt.aes.AesCbc.encrypt(str.getBytes(a), com.huawei.secure.android.common.encrypt.utils.HexUtil.hexStr2ByteArray(str2)));
    }
}
