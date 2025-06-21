package com.huawei.secure.android.common.encrypt.utils;

/* loaded from: classes22.dex */
public class WorkKeyCryptUtil {
    public static java.lang.String decryptWorkKey(java.lang.String str, com.huawei.secure.android.common.encrypt.utils.RootKeyUtil rootKeyUtil) {
        return com.huawei.secure.android.common.encrypt.aes.AesCbc.decrypt(str, rootKeyUtil.getRootKey());
    }

    public static java.lang.String decryptWorkKey(java.lang.String str, byte[] bArr) {
        return com.huawei.secure.android.common.encrypt.aes.AesCbc.decrypt(str, bArr);
    }

    public static byte[] decryptWorkKey2Byte(byte[] bArr, com.huawei.secure.android.common.encrypt.utils.RootKeyUtil rootKeyUtil, byte[] bArr2) {
        return com.huawei.secure.android.common.encrypt.aes.AesCbc.decrypt(bArr, rootKeyUtil.getRootKey(), bArr2);
    }

    public static byte[] decryptWorkKey2Byte(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return com.huawei.secure.android.common.encrypt.aes.AesCbc.decrypt(bArr, bArr2, bArr3);
    }

    public static byte[] decryptWorkKey2ByteGcm(byte[] bArr, com.huawei.secure.android.common.encrypt.utils.RootKeyUtil rootKeyUtil, byte[] bArr2) {
        return com.huawei.secure.android.common.encrypt.aes.AesGcm.decrypt(bArr, rootKeyUtil.getRootKey(), bArr2);
    }

    public static byte[] decryptWorkKey2ByteGcm(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return com.huawei.secure.android.common.encrypt.aes.AesGcm.decrypt(bArr, bArr2, bArr3);
    }

    public static java.lang.String decryptWorkKeyGcm(java.lang.String str, com.huawei.secure.android.common.encrypt.utils.RootKeyUtil rootKeyUtil) {
        return com.huawei.secure.android.common.encrypt.aes.AesGcm.decrypt(str, rootKeyUtil.getRootKey());
    }

    public static java.lang.String decryptWorkKeyGcm(java.lang.String str, byte[] bArr) {
        return com.huawei.secure.android.common.encrypt.aes.AesGcm.decrypt(str, bArr);
    }

    public static java.lang.String encryptWorkKey(java.lang.String str, com.huawei.secure.android.common.encrypt.utils.RootKeyUtil rootKeyUtil) {
        return com.huawei.secure.android.common.encrypt.aes.AesCbc.encrypt(str, rootKeyUtil.getRootKey());
    }

    public static java.lang.String encryptWorkKey(java.lang.String str, byte[] bArr) {
        return com.huawei.secure.android.common.encrypt.aes.AesCbc.encrypt(str, bArr);
    }

    public static byte[] encryptWorkKey2Byte(byte[] bArr, com.huawei.secure.android.common.encrypt.utils.RootKeyUtil rootKeyUtil, byte[] bArr2) {
        return com.huawei.secure.android.common.encrypt.aes.AesCbc.encrypt(bArr, rootKeyUtil.getRootKey(), bArr2);
    }

    public static byte[] encryptWorkKey2Byte(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return com.huawei.secure.android.common.encrypt.aes.AesCbc.encrypt(bArr, bArr2, bArr3);
    }

    public static byte[] encryptWorkKey2ByteGcm(byte[] bArr, com.huawei.secure.android.common.encrypt.utils.RootKeyUtil rootKeyUtil, byte[] bArr2) {
        return com.huawei.secure.android.common.encrypt.aes.AesGcm.encrypt(bArr, rootKeyUtil.getRootKey(), bArr2);
    }

    public static byte[] encryptWorkKey2ByteGcm(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return com.huawei.secure.android.common.encrypt.aes.AesGcm.encrypt(bArr, bArr2, bArr3);
    }

    public static java.lang.String encryptWorkKeyGcm(java.lang.String str, com.huawei.secure.android.common.encrypt.utils.RootKeyUtil rootKeyUtil) {
        return com.huawei.secure.android.common.encrypt.aes.AesGcm.encrypt(str, rootKeyUtil.getRootKey());
    }

    public static java.lang.String encryptWorkKeyGcm(java.lang.String str, byte[] bArr) {
        return com.huawei.secure.android.common.encrypt.aes.AesGcm.encrypt(str, bArr);
    }
}
