package com.hihonor.push.sdk.common.encrypt;

/* loaded from: classes22.dex */
public class HexUtils {
    private static final java.lang.String TAG = "HexUtils";

    public static java.lang.String byteArray2HexStr(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (byte b : bArr) {
            java.lang.String hexString = java.lang.Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public static byte[] hexStr2ByteArray(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return new byte[0];
        }
        java.lang.String upperCase = str.toUpperCase(java.util.Locale.ENGLISH);
        int length = upperCase.length() / 2;
        byte[] bArr = new byte[length];
        try {
            byte[] bytes = upperCase.getBytes(java.nio.charset.StandardCharsets.UTF_8);
            for (int i = 0; i < length; i++) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder("0x");
                int i2 = i * 2;
                sb.append(new java.lang.String(new byte[]{bytes[i2]}, java.nio.charset.StandardCharsets.UTF_8));
                bArr[i] = (byte) (((byte) (java.lang.Byte.decode(sb.toString()).byteValue() << 4)) ^ java.lang.Byte.decode("0x" + new java.lang.String(new byte[]{bytes[i2 + 1]}, java.nio.charset.StandardCharsets.UTF_8)).byteValue());
            }
        } catch (java.lang.NumberFormatException e) {
            com.hihonor.push.sdk.common.logger.Logger.e(TAG, "hex string 2 byte array exception : " + e.getMessage());
        }
        return bArr;
    }
}
