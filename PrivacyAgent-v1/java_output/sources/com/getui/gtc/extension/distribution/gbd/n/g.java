package com.getui.gtc.extension.distribution.gbd.n;

/* loaded from: classes22.dex */
public class g {
    public static java.lang.String a = "";
    private static final java.lang.String b = "com.getui.gtc.extension.distribution.gbd.n.g";
    private static boolean c = false;
    private static int d = 0;
    private static byte[] e = null;
    private static byte[] f = null;
    private static final int g = 200;

    private static boolean a() {
        return c;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static byte[] a(byte[] bArr) {
        boolean z;
        byte[] bytes = com.getui.gtc.extension.distribution.gbd.d.c.h.getBytes();
        int length = bytes.length;
        if (length > 0 && length <= 256) {
            int i = 0;
            for (byte b2 : bytes) {
                if ((b2 & 255) != 14 || (i = i + 1) <= 3) {
                }
            }
            z = true;
            if (z) {
                throw new java.lang.IllegalArgumentException("key is fail!");
            }
            if (bArr.length <= 0) {
                throw new java.lang.IllegalArgumentException("data is fail!");
            }
            if (bArr.length <= 0 || bArr.length > 256) {
                throw new java.lang.IllegalArgumentException("data is fail!");
            }
            int[] iArr = new int[256];
            for (int i2 = 0; i2 < 256; i2++) {
                iArr[i2] = i2;
            }
            int i3 = 0;
            for (int i4 = 0; i4 < 256; i4++) {
                i3 = ((i3 + iArr[i4]) + (bytes[i4 % bytes.length] & 255)) % 256;
                com.getui.gtc.extension.distribution.gbd.n.c.a.a(iArr, i4, i3);
            }
            int length2 = bArr.length;
            byte[] bArr2 = new byte[length2];
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < length2; i7++) {
                i5 = (i5 + 1) % 256;
                i6 = (i6 + iArr[i5]) % 256;
                com.getui.gtc.extension.distribution.gbd.n.c.a.a(iArr, i5, i6);
                bArr2[i7] = (byte) (iArr[(iArr[i5] + iArr[i6]) % 256] ^ bArr[i7]);
            }
            return bArr2;
        }
        z = false;
        if (z) {
        }
    }
}
