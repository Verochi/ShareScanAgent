package com.huawei.secure.android.common.encrypt.utils;

/* loaded from: classes22.dex */
public class BaseKeyUtil {
    public static final java.lang.String a = "BaseKeyUtil";

    public static int a(int i, int i2, int i3) {
        if (i2 < i) {
            i = i2;
        }
        return i3 < i ? i3 : i;
    }

    public static boolean b(int i) {
        return i >= 16;
    }

    public static boolean c(int i, byte[] bArr) {
        return b(i) & d(bArr);
    }

    public static boolean d(byte[] bArr) {
        return bArr.length >= 16;
    }

    public static java.lang.String exportHexRootKey(java.lang.String str, java.lang.String str2, java.lang.String str3, byte[] bArr, int i, boolean z) {
        return com.huawei.secure.android.common.encrypt.utils.HexUtil.byteArray2HexStr(exportRootKey(str, str2, str3, bArr, i, z));
    }

    public static byte[] exportRootKey(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, int i, boolean z) {
        return exportRootKey(str, str2, str3, com.huawei.secure.android.common.encrypt.utils.HexUtil.hexStr2ByteArray(str4), i, z);
    }

    public static byte[] exportRootKey(java.lang.String str, java.lang.String str2, java.lang.String str3, byte[] bArr, int i, int i2, boolean z) {
        byte[] hexStr2ByteArray = com.huawei.secure.android.common.encrypt.utils.HexUtil.hexStr2ByteArray(str);
        byte[] hexStr2ByteArray2 = com.huawei.secure.android.common.encrypt.utils.HexUtil.hexStr2ByteArray(str2);
        byte[] hexStr2ByteArray3 = com.huawei.secure.android.common.encrypt.utils.HexUtil.hexStr2ByteArray(str3);
        int a2 = a(hexStr2ByteArray.length, hexStr2ByteArray2.length, hexStr2ByteArray3.length);
        if (!c(a2, bArr)) {
            throw new java.lang.IllegalArgumentException("key length must be more than 128bit.");
        }
        char[] cArr = new char[a2];
        for (int i3 = 0; i3 < a2; i3++) {
            cArr[i3] = (char) ((hexStr2ByteArray[i3] ^ hexStr2ByteArray2[i3]) ^ hexStr2ByteArray3[i3]);
        }
        if (z) {
            com.huawei.secure.android.common.encrypt.utils.b.c(a, "exportRootKey: sha256");
            return com.huawei.secure.android.common.encrypt.hash.PBKDF2.pbkdf2SHA256(cArr, bArr, i, i2 * 8);
        }
        com.huawei.secure.android.common.encrypt.utils.b.c(a, "exportRootKey: sha1");
        return com.huawei.secure.android.common.encrypt.hash.PBKDF2.pbkdf2(cArr, bArr, i, i2 * 8);
    }

    @android.annotation.SuppressLint({"NewApi"})
    public static byte[] exportRootKey(java.lang.String str, java.lang.String str2, java.lang.String str3, byte[] bArr, int i, boolean z) {
        return exportRootKey(str, str2, str3, bArr, 10000, i, z);
    }

    @android.annotation.SuppressLint({"NewApi"})
    public static byte[] exportRootKey(java.lang.String str, java.lang.String str2, java.lang.String str3, byte[] bArr, boolean z) {
        return exportRootKey(str, str2, str3, bArr, 16, z);
    }

    public static byte[] exportRootKey32(java.lang.String str, java.lang.String str2, java.lang.String str3, byte[] bArr, boolean z) {
        return exportRootKey(str, str2, str3, bArr, 32, z);
    }

    public static byte[] exportRootKey32Iteration1(java.lang.String str, java.lang.String str2, java.lang.String str3, byte[] bArr, boolean z) {
        return exportRootKey(str, str2, str3, bArr, 1, 32, z);
    }

    @android.annotation.SuppressLint({"NewApi"})
    public static byte[] exportRootKeyIteration1(java.lang.String str, java.lang.String str2, java.lang.String str3, byte[] bArr, boolean z) {
        return exportRootKey(str, str2, str3, bArr, 1, 16, z);
    }
}
