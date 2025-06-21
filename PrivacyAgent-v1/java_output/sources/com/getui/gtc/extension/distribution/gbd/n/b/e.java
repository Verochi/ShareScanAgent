package com.getui.gtc.extension.distribution.gbd.n.b;

/* loaded from: classes22.dex */
public final class e {
    private static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static java.lang.String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (int i = 0; i < bArr.length; i++) {
            char[] cArr = a;
            sb.append(cArr[(bArr[i] >> 4) & 15]);
            sb.append(cArr[bArr[i] & 15]);
        }
        return sb.toString();
    }

    public static byte[] a(java.lang.String str) {
        if (str == null) {
            return null;
        }
        char[] charArray = str.toCharArray();
        int length = charArray.length / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            int digit = java.lang.Character.digit(charArray[i2 + 1], 16) | (java.lang.Character.digit(charArray[i2], 16) << 4);
            if (digit > 127) {
                digit += androidx.core.view.InputDeviceCompat.SOURCE_ANY;
            }
            bArr[i] = (byte) digit;
        }
        return bArr;
    }
}
