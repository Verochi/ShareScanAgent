package com.getui.gtc.extension.distribution.gbd.n.b;

/* loaded from: classes22.dex */
public final class d {
    private static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', com.aliyun.svideo.editor.guide.customView.MultiLamp.BOTTOM, 'c', 'd', 'e', 'f'};

    public static java.lang.String a(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            char[] cArr2 = a;
            cArr[i] = cArr2[(b & 255) >> 4];
            i = i2 + 1;
            cArr[i2] = cArr2[(b & 255) % 16];
        }
        return new java.lang.String(cArr);
    }

    private static java.lang.String a(byte[] bArr, int i) {
        char[] cArr = new char[i * 2];
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = i2 + 1;
            char[] cArr2 = a;
            byte b = bArr[i3];
            cArr[i2] = cArr2[(b & 255) >> 4];
            i2 = i4 + 1;
            cArr[i4] = cArr2[(b & 255) % 16];
        }
        return new java.lang.String(cArr);
    }
}
