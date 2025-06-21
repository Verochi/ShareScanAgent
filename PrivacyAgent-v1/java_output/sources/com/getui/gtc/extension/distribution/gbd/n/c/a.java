package com.getui.gtc.extension.distribution.gbd.n.c;

/* loaded from: classes22.dex */
public final class a {
    private static java.lang.String a() {
        return null;
    }

    public static void a(int[] iArr, int i, int i2) {
        int i3 = iArr[i];
        iArr[i] = iArr[i2];
        iArr[i2] = i3;
    }

    private static boolean a(byte[] bArr) {
        int length = bArr.length;
        if (length <= 0 || length > 256) {
            return false;
        }
        int i = 0;
        for (byte b : bArr) {
            if ((b & 255) == 14 && (i = i + 1) > 3) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0080  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static byte[] a(byte[] bArr, java.lang.String str) {
        boolean z;
        byte[] bytes = str.getBytes();
        int length = bytes.length;
        if (length > 0 && length <= 256) {
            int i = 0;
            for (byte b : bytes) {
                if ((b & 255) != 14 || (i = i + 1) <= 3) {
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
                a(iArr, i4, i3);
            }
            int length2 = bArr.length;
            byte[] bArr2 = new byte[length2];
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < length2; i7++) {
                i5 = (i5 + 1) % 256;
                i6 = (i6 + iArr[i5]) % 256;
                a(iArr, i5, i6);
                bArr2[i7] = (byte) (iArr[(iArr[i5] + iArr[i6]) % 256] ^ bArr[i7]);
            }
            return bArr2;
        }
        z = false;
        if (z) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x007c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static byte[] a(byte[] bArr, byte[] bArr2) {
        boolean z;
        int length = bArr2.length;
        if (length > 0 && length <= 256) {
            int i = 0;
            for (byte b : bArr2) {
                if ((b & 255) != 14 || (i = i + 1) <= 3) {
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
                i3 = ((i3 + iArr[i4]) + (bArr2[i4 % bArr2.length] & 255)) % 256;
                a(iArr, i4, i3);
            }
            int length2 = bArr.length;
            byte[] bArr3 = new byte[length2];
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < length2; i7++) {
                i5 = (i5 + 1) % 256;
                i6 = (i6 + iArr[i5]) % 256;
                a(iArr, i5, i6);
                bArr3[i7] = (byte) (iArr[(iArr[i5] + iArr[i6]) % 256] ^ bArr[i7]);
            }
            return bArr3;
        }
        z = false;
        if (z) {
        }
    }

    private static byte[] b() {
        while (true) {
        }
    }
}
