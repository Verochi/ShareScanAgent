package com.getui.gtc.extension.distribution.gbd.n.b;

/* loaded from: classes22.dex */
public final class a {
    public static java.lang.String a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        byte[] bArr = null;
        if (str == null || str3 == null) {
            return null;
        }
        byte[] bytes = str.getBytes(str2);
        byte[] a = com.getui.gtc.extension.distribution.gbd.n.b.e.a(str3);
        if (bytes != null && bytes.length != 0 && a != null) {
            int[] a2 = a(bytes, true);
            int[] a3 = a(a, false);
            int length = a2.length - 1;
            if (length > 0) {
                if (a3.length < 4) {
                    int[] iArr = new int[4];
                    java.lang.System.arraycopy(a3, 0, iArr, 0, a3.length);
                    a3 = iArr;
                }
                int i = a2[length];
                int i2 = (52 / (length + 1)) + 6;
                int i3 = 0;
                while (true) {
                    int i4 = i2 - 1;
                    if (i2 <= 0) {
                        break;
                    }
                    i3 -= 1640531527;
                    int i5 = (i3 >>> 2) & 3;
                    int i6 = 0;
                    while (i6 < length) {
                        int i7 = i6 + 1;
                        int i8 = a2[i7];
                        i = ((((i >>> 5) ^ (i8 << 2)) + ((i8 >>> 3) ^ (i << 4))) ^ ((i8 ^ i3) + (i ^ a3[(i6 & 3) ^ i5]))) + a2[i6];
                        a2[i6] = i;
                        i6 = i7;
                    }
                    int i9 = a2[0];
                    i = ((((i >>> 5) ^ (i9 << 2)) + ((i9 >>> 3) ^ (i << 4))) ^ ((i9 ^ i3) + (i ^ a3[i5 ^ (i6 & 3)]))) + a2[length];
                    a2[length] = i;
                    i2 = i4;
                }
            }
            bArr = a(a2, false);
        }
        return com.getui.gtc.extension.distribution.gbd.n.b.e.a(bArr);
    }

    private static byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr.length == 0 || bArr2 == null) {
            return null;
        }
        int[] a = a(bArr, true);
        int[] a2 = a(bArr2, false);
        int length = a.length - 1;
        if (length > 0) {
            if (a2.length < 4) {
                int[] iArr = new int[4];
                java.lang.System.arraycopy(a2, 0, iArr, 0, a2.length);
                a2 = iArr;
            }
            int i = a[length];
            int i2 = (52 / (length + 1)) + 6;
            int i3 = 0;
            while (true) {
                int i4 = i2 - 1;
                if (i2 <= 0) {
                    break;
                }
                i3 -= 1640531527;
                int i5 = (i3 >>> 2) & 3;
                int i6 = 0;
                while (i6 < length) {
                    int i7 = i6 + 1;
                    int i8 = a[i7];
                    i = ((((i >>> 5) ^ (i8 << 2)) + ((i8 >>> 3) ^ (i << 4))) ^ ((i8 ^ i3) + (i ^ a2[(i6 & 3) ^ i5]))) + a[i6];
                    a[i6] = i;
                    i6 = i7;
                }
                int i9 = a[0];
                i = ((((i >>> 5) ^ (i9 << 2)) + ((i9 >>> 3) ^ (i << 4))) ^ ((i9 ^ i3) + (i ^ a2[i5 ^ (i6 & 3)]))) + a[length];
                a[length] = i;
                i2 = i4;
            }
        }
        return a(a, false);
    }

    private static byte[] a(int[] iArr, boolean z) {
        int length = iArr.length << 2;
        if (z) {
            int i = iArr[iArr.length - 1];
            if (i > length || i <= 0) {
                return null;
            }
            length = i;
        }
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            bArr[i2] = (byte) ((iArr[i2 >>> 2] >>> ((i2 & 3) << 3)) & 255);
        }
        return bArr;
    }

    private static int[] a(byte[] bArr, boolean z) {
        int[] iArr;
        int length = (bArr.length & 3) == 0 ? bArr.length >>> 2 : (bArr.length >>> 2) + 1;
        if (z) {
            iArr = new int[length + 1];
            iArr[length] = bArr.length;
        } else {
            iArr = new int[length];
        }
        int length2 = bArr.length;
        for (int i = 0; i < length2; i++) {
            int i2 = i >>> 2;
            iArr[i2] = iArr[i2] | ((bArr[i] & 255) << ((i & 3) << 3));
        }
        return iArr;
    }

    private static int[] a(int[] iArr, int[] iArr2) {
        int length = iArr.length - 1;
        if (length <= 0) {
            return iArr;
        }
        if (iArr2.length < 4) {
            int[] iArr3 = new int[4];
            java.lang.System.arraycopy(iArr2, 0, iArr3, 0, iArr2.length);
            iArr2 = iArr3;
        }
        int i = iArr[length];
        int i2 = (52 / (length + 1)) + 6;
        int i3 = 0;
        while (true) {
            int i4 = i2 - 1;
            if (i2 <= 0) {
                return iArr;
            }
            i3 -= 1640531527;
            int i5 = (i3 >>> 2) & 3;
            int i6 = 0;
            while (i6 < length) {
                int i7 = i6 + 1;
                int i8 = iArr[i7];
                i = ((((i >>> 5) ^ (i8 << 2)) + ((i8 >>> 3) ^ (i << 4))) ^ ((i8 ^ i3) + (i ^ iArr2[(i6 & 3) ^ i5]))) + iArr[i6];
                iArr[i6] = i;
                i6 = i7;
            }
            int i9 = iArr[0];
            i = ((((i >>> 5) ^ (i9 << 2)) + ((i9 >>> 3) ^ (i << 4))) ^ ((i9 ^ i3) + (i ^ iArr2[i5 ^ (i6 & 3)]))) + iArr[length];
            iArr[length] = i;
            i2 = i4;
        }
    }

    private static java.lang.String b(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        byte[] bArr = null;
        if (str == null || str2 == null || str3 == null) {
            return null;
        }
        byte[] a = com.getui.gtc.extension.distribution.gbd.n.b.e.a(str);
        byte[] a2 = com.getui.gtc.extension.distribution.gbd.n.b.e.a(str3);
        if (a != null && a.length != 0 && a2 != null) {
            bArr = a(b(a(a, false), a(a2, false)), true);
        }
        return new java.lang.String(bArr, str2);
    }

    private static byte[] b(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr.length == 0 || bArr2 == null) {
            return null;
        }
        return a(b(a(bArr, false), a(bArr2, false)), true);
    }

    private static int[] b(int[] iArr, int[] iArr2) {
        int length = iArr.length - 1;
        if (length <= 0) {
            return iArr;
        }
        if (iArr2.length < 4) {
            int[] iArr3 = new int[4];
            java.lang.System.arraycopy(iArr2, 0, iArr3, 0, iArr2.length);
            iArr2 = iArr3;
        }
        int i = iArr[0];
        for (int i2 = ((52 / (length + 1)) + 6) * (-1640531527); i2 != 0; i2 -= -1640531527) {
            int i3 = (i2 >>> 2) & 3;
            int i4 = length;
            while (i4 > 0) {
                int i5 = iArr[i4 - 1];
                i = iArr[i4] - (((i ^ i2) + (i5 ^ iArr2[(i4 & 3) ^ i3])) ^ (((i5 >>> 5) ^ (i << 2)) + ((i >>> 3) ^ (i5 << 4))));
                iArr[i4] = i;
                i4--;
            }
            int i6 = iArr[length];
            i = iArr[0] - (((i ^ i2) + (iArr2[i3 ^ (i4 & 3)] ^ i6)) ^ (((i6 >>> 5) ^ (i << 2)) + ((i >>> 3) ^ (i6 << 4))));
            iArr[0] = i;
        }
        return iArr;
    }
}
