package com.anythink.expressad.exoplayer.k;

/* loaded from: classes12.dex */
public final class d {
    private static final int b = 15;
    private static final int d = -1;
    private static final int f = 2;
    private static final int g = 5;
    private static final int h = 22;
    private static final int i = 29;
    private static final int j = 31;
    private static final byte[] a = {0, 0, 0, 1};
    private static final int[] c = {96000, 88200, 64000, com.google.android.exoplayer2.audio.OpusUtil.SAMPLE_RATE, 44100, com.uc.crashsdk.export.LogType.UNEXP_KNOWN_REASON, 24000, 22050, com.google.android.exoplayer2.audio.AacUtil.AAC_HE_V1_MAX_RATE_BYTES_PER_SECOND, 12000, 11025, 8000, 7350};
    private static final int[] e = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    private d() {
    }

    private static int a(byte[] bArr, int i2) {
        int length = bArr.length - a.length;
        while (i2 <= length) {
            if (b(bArr, i2)) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    private static android.util.Pair<java.lang.Integer, java.lang.Integer> a(com.anythink.expressad.exoplayer.k.r rVar) {
        int b2 = b(rVar);
        int c2 = c(rVar);
        int c3 = rVar.c(4);
        if (b2 == 5 || b2 == 29) {
            c2 = c(rVar);
            if (b(rVar) == 22) {
                c3 = rVar.c(4);
            }
        }
        int i2 = e[c3];
        com.anythink.expressad.exoplayer.k.a.a(i2 != -1);
        return android.util.Pair.create(java.lang.Integer.valueOf(c2), java.lang.Integer.valueOf(i2));
    }

    public static android.util.Pair<java.lang.Integer, java.lang.Integer> a(byte[] bArr) {
        com.anythink.expressad.exoplayer.k.r rVar = new com.anythink.expressad.exoplayer.k.r(bArr);
        int b2 = b(rVar);
        int c2 = c(rVar);
        int c3 = rVar.c(4);
        if (b2 == 5 || b2 == 29) {
            c2 = c(rVar);
            if (b(rVar) == 22) {
                c3 = rVar.c(4);
            }
        }
        int i2 = e[c3];
        com.anythink.expressad.exoplayer.k.a.a(i2 != -1);
        return android.util.Pair.create(java.lang.Integer.valueOf(c2), java.lang.Integer.valueOf(i2));
    }

    private static void a(com.anythink.expressad.exoplayer.k.r rVar, int i2, int i3) {
        rVar.b(1);
        if (rVar.d()) {
            rVar.b(14);
        }
        boolean d2 = rVar.d();
        if (i3 == 0) {
            throw new java.lang.UnsupportedOperationException();
        }
        if (i2 == 6 || i2 == 20) {
            rVar.b(3);
        }
        if (d2) {
            if (i2 == 22) {
                rVar.b(16);
            }
            if (i2 == 17 || i2 == 19 || i2 == 20 || i2 == 23) {
                rVar.b(3);
            }
            rVar.b(1);
        }
    }

    private static byte[] a(int i2, int i3) {
        int i4 = 0;
        int i5 = -1;
        while (true) {
            int[] iArr = c;
            if (i4 >= iArr.length) {
                break;
            }
            if (i2 == iArr[i4]) {
                i5 = i4;
            }
            i4++;
        }
        int i6 = 0;
        int i7 = -1;
        while (true) {
            int[] iArr2 = e;
            if (i6 >= iArr2.length) {
                break;
            }
            if (i3 == iArr2[i6]) {
                i7 = i6;
            }
            i6++;
        }
        if (i2 != -1 && i7 != -1) {
            return new byte[]{(byte) (((i5 >> 1) & 7) | 16), (byte) (((i5 << 7) & 128) | ((i7 << 3) & 120))};
        }
        throw new java.lang.IllegalArgumentException("Invalid sample rate or number of channels: " + i2 + ", " + i3);
    }

    public static byte[] a(byte[] bArr, int i2, int i3) {
        byte[] bArr2 = a;
        byte[] bArr3 = new byte[bArr2.length + i3];
        java.lang.System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        java.lang.System.arraycopy(bArr, i2, bArr3, bArr2.length, i3);
        return bArr3;
    }

    private static int b(com.anythink.expressad.exoplayer.k.r rVar) {
        int c2 = rVar.c(5);
        return c2 == 31 ? rVar.c(6) + 32 : c2;
    }

    private static boolean b(byte[] bArr, int i2) {
        if (bArr.length - i2 <= a.length) {
            return false;
        }
        int i3 = 0;
        while (true) {
            byte[] bArr2 = a;
            if (i3 >= bArr2.length) {
                return true;
            }
            if (bArr[i2 + i3] != bArr2[i3]) {
                return false;
            }
            i3++;
        }
    }

    private static byte[] b(int i2, int i3) {
        return new byte[]{(byte) (((i2 >> 1) & 7) | 16), (byte) (((i2 << 7) & 128) | ((i3 << 3) & 120))};
    }

    private static byte[][] b(byte[] bArr) {
        if (!b(bArr, 0)) {
            return null;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        int i2 = 0;
        do {
            arrayList.add(java.lang.Integer.valueOf(i2));
            i2 = a(bArr, i2 + a.length);
        } while (i2 != -1);
        byte[][] bArr2 = new byte[arrayList.size()][];
        int i3 = 0;
        while (i3 < arrayList.size()) {
            int intValue = ((java.lang.Integer) arrayList.get(i3)).intValue();
            int intValue2 = (i3 < arrayList.size() + (-1) ? ((java.lang.Integer) arrayList.get(i3 + 1)).intValue() : bArr.length) - intValue;
            byte[] bArr3 = new byte[intValue2];
            java.lang.System.arraycopy(bArr, intValue, bArr3, 0, intValue2);
            bArr2[i3] = bArr3;
            i3++;
        }
        return bArr2;
    }

    private static int c(com.anythink.expressad.exoplayer.k.r rVar) {
        int c2 = rVar.c(4);
        if (c2 == 15) {
            return rVar.c(24);
        }
        com.anythink.expressad.exoplayer.k.a.a(c2 < 13);
        return c[c2];
    }
}
