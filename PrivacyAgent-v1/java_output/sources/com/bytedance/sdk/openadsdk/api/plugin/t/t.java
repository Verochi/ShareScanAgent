package com.bytedance.sdk.openadsdk.api.plugin.t;

/* loaded from: classes22.dex */
public class t {
    private static final char[] vw = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', com.aliyun.svideo.editor.guide.customView.MultiLamp.BOTTOM, 'c', 'd', 'e', 'f'};

    public static java.lang.String vw(byte[] bArr) {
        if (bArr != null) {
            return vw(bArr, 0, bArr.length);
        }
        throw new java.lang.NullPointerException("bytes is null");
    }

    public static java.lang.String vw(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new java.lang.NullPointerException("bytes is null");
        }
        if (i < 0 || i + i2 > bArr.length) {
            throw new java.lang.IndexOutOfBoundsException();
        }
        int i3 = i2 * 2;
        char[] cArr = new char[i3];
        int i4 = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            int i6 = bArr[i5 + i] & 255;
            int i7 = i4 + 1;
            char[] cArr2 = vw;
            cArr[i4] = cArr2[i6 >> 4];
            i4 = i7 + 1;
            cArr[i7] = cArr2[i6 & 15];
        }
        return new java.lang.String(cArr, 0, i3);
    }
}
