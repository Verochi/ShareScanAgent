package com.commonsware.cwac.netsecurity.conscrypt;

/* loaded from: classes22.dex */
public class Hex {
    private static final char[] DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', com.aliyun.svideo.editor.guide.customView.MultiLamp.BOTTOM, 'c', 'd', 'e', 'f'};

    private Hex() {
    }

    public static java.lang.String bytesToHexString(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            char[] cArr2 = DIGITS;
            cArr[i] = cArr2[(b >> 4) & 15];
            i = i2 + 1;
            cArr[i2] = cArr2[b & 15];
        }
        return new java.lang.String(cArr);
    }

    public static java.lang.String intToHexString(int i, int i2) {
        int i3;
        int i4 = 8;
        char[] cArr = new char[8];
        while (true) {
            i4--;
            cArr[i4] = DIGITS[i & 15];
            i >>>= 4;
            if (i == 0 && (i3 = 8 - i4) >= i2) {
                return new java.lang.String(cArr, i4, i3);
            }
        }
    }
}
