package org.apache.tools.ant.util;

/* loaded from: classes26.dex */
public class Base64Converter {
    public static final char[] a;
    public static final char[] alphabet;

    static {
        char[] cArr = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', com.aliyun.svideo.editor.guide.customView.MultiLamp.BOTTOM, 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', com.aliyun.svideo.editor.guide.customView.MultiLamp.LEFT, 'm', 'n', 'o', 'p', 'q', com.aliyun.svideo.editor.guide.customView.MultiLamp.RIGHT, 's', com.aliyun.svideo.editor.guide.customView.MultiLamp.TOP, 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
        a = cArr;
        alphabet = cArr;
    }

    public java.lang.String encode(java.lang.String str) {
        return encode(str.getBytes());
    }

    public java.lang.String encode(byte[] bArr) {
        char[] cArr = new char[(((bArr.length - 1) / 3) + 1) * 4];
        int i = 0;
        int i2 = 0;
        while (i + 3 <= bArr.length) {
            int i3 = i + 1;
            int i4 = i3 + 1;
            int i5 = ((bArr[i] & 255) << 16) | ((bArr[i3] & 255) << 8);
            int i6 = i4 + 1;
            int i7 = i5 | (bArr[i4] & 255);
            int i8 = i2 + 1;
            char[] cArr2 = a;
            cArr[i2] = cArr2[(i7 & 16515072) >> 18];
            int i9 = i8 + 1;
            cArr[i8] = cArr2[(i7 & 258048) >> 12];
            int i10 = i9 + 1;
            cArr[i9] = cArr2[(i7 & 4032) >> 6];
            i2 = i10 + 1;
            cArr[i10] = cArr2[i7 & 63];
            i = i6;
        }
        if (bArr.length - i == 2) {
            int i11 = ((bArr[i + 1] & 255) << 8) | ((bArr[i] & 255) << 16);
            int i12 = i2 + 1;
            char[] cArr3 = a;
            cArr[i2] = cArr3[(i11 & 16515072) >> 18];
            int i13 = i12 + 1;
            cArr[i12] = cArr3[(i11 & 258048) >> 12];
            cArr[i13] = cArr3[(i11 & 4032) >> 6];
            cArr[i13 + 1] = com.alipay.sdk.m.n.a.h;
        } else if (bArr.length - i == 1) {
            int i14 = (bArr[i] & 255) << 16;
            int i15 = i2 + 1;
            char[] cArr4 = a;
            cArr[i2] = cArr4[(i14 & 16515072) >> 18];
            int i16 = i15 + 1;
            cArr[i15] = cArr4[(i14 & 258048) >> 12];
            cArr[i16] = com.alipay.sdk.m.n.a.h;
            cArr[i16 + 1] = com.alipay.sdk.m.n.a.h;
        }
        return new java.lang.String(cArr);
    }
}
