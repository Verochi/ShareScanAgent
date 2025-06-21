package com.huawei.secure.android.common.util;

/* loaded from: classes22.dex */
public final class HexUtil {
    public static java.lang.String byteArray2HexStr(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return byteArray2HexStr(str.getBytes("UTF-8"));
        } catch (java.io.UnsupportedEncodingException e) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("byte array 2 hex string UnsupportedEncodingException : ");
            sb.append(e.getMessage());
            return "";
        } catch (java.lang.Exception e2) {
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append("byte array 2 hex string exception : ");
            sb2.append(e2.getMessage());
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
        } catch (java.io.UnsupportedEncodingException e) {
            e = e;
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append("hex string 2 byte UnsupportedEncodingException or NumberFormatException : ");
            sb2.append(e.getMessage());
        } catch (java.lang.NumberFormatException e2) {
            e = e2;
            java.lang.StringBuilder sb22 = new java.lang.StringBuilder();
            sb22.append("hex string 2 byte UnsupportedEncodingException or NumberFormatException : ");
            sb22.append(e.getMessage());
        } catch (java.lang.Exception e3) {
            java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
            sb3.append("byte array 2 hex string exception : ");
            sb3.append(e3.getMessage());
        }
        return bArr;
    }
}
