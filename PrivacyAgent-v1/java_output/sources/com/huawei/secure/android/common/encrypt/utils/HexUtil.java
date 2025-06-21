package com.huawei.secure.android.common.encrypt.utils;

/* loaded from: classes22.dex */
public final class HexUtil {
    public static java.lang.String byteArray2HexStr(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return byteArray2HexStr(str.getBytes("UTF-8"));
        } catch (java.io.UnsupportedEncodingException e) {
            com.huawei.secure.android.common.encrypt.utils.b.b("HexUtil", "byte array 2 hex string exception : " + e.getMessage());
            return "";
        }
    }

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
        try {
            java.lang.String upperCase = str.toUpperCase(java.util.Locale.ENGLISH);
            int length = upperCase.length() / 2;
            byte[] bArr = new byte[length];
            try {
                byte[] bytes = upperCase.getBytes("UTF-8");
                for (int i = 0; i < length; i++) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("0x");
                    int i2 = i * 2;
                    sb.append(new java.lang.String(new byte[]{bytes[i2]}, "UTF-8"));
                    bArr[i] = (byte) (((byte) (java.lang.Byte.decode(sb.toString()).byteValue() << 4)) ^ java.lang.Byte.decode("0x" + new java.lang.String(new byte[]{bytes[i2 + 1]}, "UTF-8")).byteValue());
                }
                return bArr;
            } catch (java.io.UnsupportedEncodingException | java.lang.NumberFormatException e) {
                com.huawei.secure.android.common.encrypt.utils.b.b("HexUtil", "hex string 2 byte array exception : " + e.getMessage());
                return new byte[0];
            }
        } catch (java.lang.Throwable th) {
            com.huawei.secure.android.common.encrypt.utils.b.b("HexUtil", "hex string toUpperCase exception : " + th.getMessage());
            return new byte[0];
        }
    }
}
