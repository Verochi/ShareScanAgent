package com.anythink.core.common.o;

/* loaded from: classes12.dex */
final class l {
    private static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', com.aliyun.svideo.editor.guide.customView.MultiLamp.BOTTOM, 'c', 'd', 'e', 'f'};
    private static final char[] b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    private l() {
    }

    public static java.lang.String a(byte[] bArr) {
        return new java.lang.String(a(bArr, true));
    }

    private static char[] a(byte[] bArr, boolean z) {
        return a(bArr, z ? b : a);
    }

    private static char[] a(byte[] bArr, char[] cArr) {
        char[] cArr2 = new char[bArr.length << 1];
        int i = 0;
        for (byte b2 : bArr) {
            int i2 = i + 1;
            cArr2[i] = cArr[(b2 & 240) >>> 4];
            i = i2 + 1;
            cArr2[i2] = cArr[b2 & 15];
        }
        return cArr2;
    }

    private static char[] b(byte[] bArr) {
        return a(bArr, false);
    }
}
