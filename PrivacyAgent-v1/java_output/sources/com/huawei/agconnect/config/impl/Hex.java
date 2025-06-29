package com.huawei.agconnect.config.impl;

/* loaded from: classes22.dex */
public class Hex {
    public static final char[] a = "0123456789ABCDEF".toCharArray();

    public static byte[] a(char[] cArr) {
        if ((cArr.length & 1) != 0) {
            throw new java.lang.IllegalArgumentException("Odd number of characters.");
        }
        byte[] bArr = new byte[cArr.length >> 1];
        int i = 0;
        int i2 = 0;
        while (i < cArr.length) {
            int digit = java.lang.Character.digit(cArr[i], 16);
            if (digit == -1) {
                throw new java.lang.IllegalArgumentException("Illegal hexadecimal character at index " + i);
            }
            int i3 = i + 1;
            int digit2 = java.lang.Character.digit(cArr[i3], 16);
            if (digit2 == -1) {
                throw new java.lang.IllegalArgumentException("Illegal hexadecimal character at index " + i3);
            }
            i = i3 + 1;
            bArr[i2] = (byte) (((digit << 4) | digit2) & 255);
            i2++;
        }
        return bArr;
    }

    public static byte[] decodeHexString(java.lang.String str) {
        return a(str.toCharArray());
    }

    public static java.lang.String encodeHexString(byte[] bArr) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            char[] cArr = a;
            sb.append(cArr[(b >> 4) & 15]);
            sb.append(cArr[b & 15]);
        }
        return sb.toString();
    }
}
