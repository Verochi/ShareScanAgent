package com.hihonor.push.sdk.common.encrypt;

/* loaded from: classes22.dex */
public class AesGcmUtil {
    private static final java.lang.String TAG = "AesGcmUtil";

    private static byte[] bytesXor(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = null;
        if (bArr != null && bArr2 != null) {
            int length = bArr.length;
            if (length != bArr2.length) {
                return null;
            }
            bArr3 = new byte[length];
            for (int i = 0; i < length; i++) {
                bArr3[i] = (byte) (bArr[i] ^ bArr2[i]);
            }
        }
        return bArr3;
    }

    public static java.lang.String decrypt(java.lang.String str, java.lang.String str2) {
        return com.hihonor.push.sdk.common.encrypt.AesGcm.decrypt(str, android.util.Base64.decode(str2, 0));
    }

    private static byte[] displacementBytes(byte[] bArr, int i) {
        if (bArr == null) {
            return bArr;
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

    public static java.lang.String encrypt(java.lang.String str, java.lang.String str2) {
        return com.hihonor.push.sdk.common.encrypt.AesGcm.encrypt(str, android.util.Base64.decode(str2, 0));
    }

    public static java.lang.String getAesGcmRandomKey(java.lang.String str, java.lang.String str2) {
        byte[] hexStr2ByteArray = com.hihonor.push.sdk.common.encrypt.HexUtils.hexStr2ByteArray(str);
        byte[] hexStr2ByteArray2 = com.hihonor.push.sdk.common.encrypt.HexUtils.hexStr2ByteArray(str2);
        return android.util.Base64.encodeToString(bytesXor(displacementBytes(bytesXor(displacementBytes(hexStr2ByteArray, -4), hexStr2ByteArray2), 6), com.hihonor.push.sdk.common.encrypt.AesGcm.generateSecureRandom(32)), 0);
    }
}
