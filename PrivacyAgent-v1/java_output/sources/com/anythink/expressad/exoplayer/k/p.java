package com.anythink.expressad.exoplayer.k;

/* loaded from: classes12.dex */
public final class p {
    public static final int b = 255;
    private static final java.lang.String d = "NalUnitUtil";
    private static final int e = 6;
    private static final int f = 7;
    private static final int g = 39;
    public static final byte[] a = {0, 0, 0, 1};
    public static final float[] c = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};
    private static final java.lang.Object h = new java.lang.Object();
    private static int[] i = new int[10];

    public static final class a {
        public final int a;
        public final int b;
        public final boolean c;

        public a(int i, int i2, boolean z) {
            this.a = i;
            this.b = i2;
            this.c = z;
        }
    }

    public static final class b {
        public final int a;
        public final int b;
        public final int c;
        public final float d;
        public final boolean e;
        public final boolean f;
        public final int g;
        public final int h;
        public final int i;
        public final boolean j;

        public b(int i, int i2, int i3, float f, boolean z, boolean z2, int i4, int i5, int i6, boolean z3) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = f;
            this.e = z;
            this.f = z2;
            this.g = i4;
            this.h = i5;
            this.i = i6;
            this.j = z3;
        }
    }

    private p() {
    }

    public static int a(byte[] bArr, int i2) {
        int i3;
        synchronized (h) {
            int i4 = 0;
            int i5 = 0;
            while (i4 < i2) {
                while (true) {
                    if (i4 >= i2 - 2) {
                        i4 = i2;
                        break;
                    }
                    if (bArr[i4] == 0 && bArr[i4 + 1] == 0 && bArr[i4 + 2] == 3) {
                        break;
                    }
                    i4++;
                }
                if (i4 < i2) {
                    int[] iArr = i;
                    if (iArr.length <= i5) {
                        i = java.util.Arrays.copyOf(iArr, iArr.length * 2);
                    }
                    i[i5] = i4;
                    i4 += 3;
                    i5++;
                }
            }
            i3 = i2 - i5;
            int i6 = 0;
            int i7 = 0;
            for (int i8 = 0; i8 < i5; i8++) {
                int i9 = i[i8] - i7;
                java.lang.System.arraycopy(bArr, i7, bArr, i6, i9);
                int i10 = i6 + i9;
                int i11 = i10 + 1;
                bArr[i10] = 0;
                i6 = i11 + 1;
                bArr[i11] = 0;
                i7 += i9 + 3;
            }
            java.lang.System.arraycopy(bArr, i7, bArr, i6, i3 - i6);
        }
        return i3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x0094, code lost:
    
        r9 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int a(byte[] bArr, int i2, int i3, boolean[] zArr) {
        int i4 = i3 - i2;
        com.anythink.expressad.exoplayer.k.a.b(i4 >= 0);
        if (i4 == 0) {
            return i3;
        }
        if (zArr != null) {
            if (zArr[0]) {
                a(zArr);
                return i2 - 3;
            }
            if (i4 > 1 && zArr[1] && bArr[i2] == 1) {
                a(zArr);
                return i2 - 2;
            }
            if (i4 > 2 && zArr[2] && bArr[i2] == 0 && bArr[i2 + 1] == 1) {
                a(zArr);
                return i2 - 1;
            }
        }
        int i5 = i3 - 1;
        int i6 = i2 + 2;
        while (i6 < i5) {
            byte b2 = bArr[i6];
            if ((b2 & com.liulishuo.filedownloader.model.FileDownloadStatus.paused) == 0) {
                int i7 = i6 - 2;
                if (bArr[i7] == 0 && bArr[i6 - 1] == 0 && b2 == 1) {
                    if (zArr != null) {
                        a(zArr);
                    }
                    return i7;
                }
                i6 -= 2;
            }
            i6 += 3;
        }
        if (zArr != null) {
            boolean z = i4 > 2 ? false : false;
            zArr[0] = z;
            zArr[1] = i4 <= 1 ? zArr[2] && bArr[i5] == 0 : bArr[i3 + (-2)] == 0 && bArr[i5] == 0;
            zArr[2] = bArr[i5] == 0;
        }
        return i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0159  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.anythink.expressad.exoplayer.k.p.b a(byte[] bArr, int i2, int i3) {
        int c2;
        boolean z;
        boolean z2;
        int i4;
        boolean z3;
        boolean b2;
        float f2;
        int b3;
        int i5;
        com.anythink.expressad.exoplayer.k.t tVar = new com.anythink.expressad.exoplayer.k.t(bArr, i2, i3);
        tVar.a(8);
        int b4 = tVar.b(8);
        tVar.a(16);
        int c3 = tVar.c();
        if (b4 == 100 || b4 == 110 || b4 == 122 || b4 == 244 || b4 == 44 || b4 == 83 || b4 == 86 || b4 == 118 || b4 == 128 || b4 == 138) {
            c2 = tVar.c();
            boolean b5 = c2 == 3 ? tVar.b() : false;
            tVar.c();
            tVar.c();
            tVar.a();
            if (tVar.b()) {
                int i6 = c2 != 3 ? 8 : 12;
                int i7 = 0;
                while (i7 < i6) {
                    if (tVar.b()) {
                        int i8 = i7 < 6 ? 16 : 64;
                        int i9 = 8;
                        int i10 = 8;
                        for (int i11 = 0; i11 < i8; i11++) {
                            if (i9 != 0) {
                                i9 = ((tVar.d() + i10) + 256) % 256;
                            }
                            if (i9 != 0) {
                                i10 = i9;
                            }
                        }
                    }
                    i7++;
                }
            }
            z = b5;
        } else {
            c2 = 1;
            z = false;
        }
        int c4 = tVar.c() + 4;
        int c5 = tVar.c();
        if (c5 == 0) {
            i4 = tVar.c() + 4;
            z2 = z;
        } else {
            if (c5 == 1) {
                boolean b6 = tVar.b();
                tVar.d();
                tVar.d();
                long c6 = tVar.c();
                z2 = z;
                for (int i12 = 0; i12 < c6; i12++) {
                    tVar.c();
                }
                z3 = b6;
                i4 = 0;
                tVar.c();
                tVar.a();
                int c7 = tVar.c() + 1;
                int c8 = tVar.c() + 1;
                b2 = tVar.b();
                int i13 = (2 - (b2 ? 1 : 0)) * c8;
                if (!b2) {
                    tVar.a();
                }
                tVar.a();
                int i14 = c7 * 16;
                int i15 = i13 * 16;
                if (tVar.b()) {
                    int c9 = tVar.c();
                    int c10 = tVar.c();
                    int c11 = tVar.c();
                    int c12 = tVar.c();
                    if (c2 == 0) {
                        i5 = 2 - (b2 ? 1 : 0);
                    } else {
                        int i16 = c2 == 3 ? 1 : 2;
                        i5 = (2 - (b2 ? 1 : 0)) * (c2 == 1 ? 2 : 1);
                        r7 = i16;
                    }
                    i14 -= (c9 + c10) * r7;
                    i15 -= (c11 + c12) * i5;
                }
                int i17 = i14;
                int i18 = i15;
                float f3 = 1.0f;
                if (tVar.b() && tVar.b()) {
                    b3 = tVar.b(8);
                    if (b3 != 255) {
                        int b7 = tVar.b(16);
                        int b8 = tVar.b(16);
                        if (b7 != 0 && b8 != 0) {
                            f3 = b7 / b8;
                        }
                        f2 = f3;
                    } else {
                        float[] fArr = c;
                        if (b3 < fArr.length) {
                            f2 = fArr[b3];
                        } else {
                            "Unexpected aspect_ratio_idc value: ".concat(java.lang.String.valueOf(b3));
                        }
                    }
                    return new com.anythink.expressad.exoplayer.k.p.b(c3, i17, i18, f2, z2, b2, c4, c5, i4, z3);
                }
                f2 = 1.0f;
                return new com.anythink.expressad.exoplayer.k.p.b(c3, i17, i18, f2, z2, b2, c4, c5, i4, z3);
            }
            z2 = z;
            i4 = 0;
        }
        z3 = false;
        tVar.c();
        tVar.a();
        int c72 = tVar.c() + 1;
        int c82 = tVar.c() + 1;
        b2 = tVar.b();
        int i132 = (2 - (b2 ? 1 : 0)) * c82;
        if (!b2) {
        }
        tVar.a();
        int i142 = c72 * 16;
        int i152 = i132 * 16;
        if (tVar.b()) {
        }
        int i172 = i142;
        int i182 = i152;
        float f32 = 1.0f;
        if (tVar.b()) {
            b3 = tVar.b(8);
            if (b3 != 255) {
            }
            return new com.anythink.expressad.exoplayer.k.p.b(c3, i172, i182, f2, z2, b2, c4, c5, i4, z3);
        }
        f2 = 1.0f;
        return new com.anythink.expressad.exoplayer.k.p.b(c3, i172, i182, f2, z2, b2, c4, c5, i4, z3);
    }

    private static void a(com.anythink.expressad.exoplayer.k.t tVar, int i2) {
        int i3 = 8;
        int i4 = 8;
        for (int i5 = 0; i5 < i2; i5++) {
            if (i3 != 0) {
                i3 = ((tVar.d() + i4) + 256) % 256;
            }
            if (i3 != 0) {
                i4 = i3;
            }
        }
    }

    public static void a(java.nio.ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = i2 + 1;
            if (i4 >= position) {
                byteBuffer.clear();
                return;
            }
            int i5 = byteBuffer.get(i2) & 255;
            if (i3 == 3) {
                if (i5 == 1 && (byteBuffer.get(i4) & com.google.common.base.Ascii.US) == 7) {
                    java.nio.ByteBuffer duplicate = byteBuffer.duplicate();
                    duplicate.position(i2 - 3);
                    duplicate.limit(position);
                    byteBuffer.position(0);
                    byteBuffer.put(duplicate);
                    return;
                }
            } else if (i5 == 0) {
                i3++;
            }
            if (i5 != 0) {
                i3 = 0;
            }
            i2 = i4;
        }
    }

    private static void a(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }

    public static boolean a(java.lang.String str, byte b2) {
        return ("video/avc".equals(str) && (b2 & com.google.common.base.Ascii.US) == 6) || ("video/hevc".equals(str) && ((b2 & 126) >> 1) == 39);
    }

    private static int b(byte[] bArr, int i2) {
        return bArr[i2 + 3] & com.google.common.base.Ascii.US;
    }

    private static com.anythink.expressad.exoplayer.k.p.a b(byte[] bArr, int i2, int i3) {
        com.anythink.expressad.exoplayer.k.t tVar = new com.anythink.expressad.exoplayer.k.t(bArr, i2, i3);
        tVar.a(8);
        int c2 = tVar.c();
        int c3 = tVar.c();
        tVar.a();
        return new com.anythink.expressad.exoplayer.k.p.a(c2, c3, tVar.b());
    }

    private static int c(byte[] bArr, int i2) {
        return (bArr[i2 + 3] & 126) >> 1;
    }

    private static int c(byte[] bArr, int i2, int i3) {
        while (i2 < i3 - 2) {
            if (bArr[i2] == 0 && bArr[i2 + 1] == 0 && bArr[i2 + 2] == 3) {
                return i2;
            }
            i2++;
        }
        return i3;
    }
}
