package org.apache.tools.bzip2;

/* loaded from: classes26.dex */
class BlockSort {
    public static final int[] m = {1, 4, 13, 40, 121, 364, 1093, 3280, 9841, 29524, 88573, 265720, 797161, 2391484};
    public int a;
    public int b;
    public boolean c;
    public final int[] d = new int[1000];
    public final int[] e = new int[1000];
    public final int[] f = new int[1000];
    public final int[] g = new int[256];
    public final int[] h = new int[256];
    public final boolean[] i = new boolean[256];
    public final int[] j = new int[65537];
    public final char[] k;
    public int[] l;

    public BlockSort(org.apache.tools.bzip2.CBZip2OutputStream.Data data) {
        this.k = data.f505s;
    }

    public static byte o(byte b, byte b2, byte b3) {
        if (b < b2) {
            if (b2 >= b3) {
                if (b >= b3) {
                    return b;
                }
                return b3;
            }
            return b2;
        }
        if (b2 <= b3) {
            if (b <= b3) {
                return b;
            }
            return b3;
        }
        return b2;
    }

    public static void p(int[] iArr, int i, int i2, int i3) {
        int i4 = i3 + i;
        while (i < i4) {
            int i5 = iArr[i];
            iArr[i] = iArr[i2];
            iArr[i2] = i5;
            i2++;
            i++;
        }
    }

    public void a(org.apache.tools.bzip2.CBZip2OutputStream.Data data, int i) {
        this.b = i * 30;
        this.a = 0;
        this.c = true;
        if (i + 1 < 10000) {
            d(data, i);
        } else {
            n(data, i);
            if (this.c && this.a > this.b) {
                d(data, i);
            }
        }
        int[] iArr = data.r;
        data.t = -1;
        for (int i2 = 0; i2 <= i; i2++) {
            if (iArr[i2] == 0) {
                data.t = i2;
                return;
            }
        }
    }

    public final void b(int[] iArr, int[] iArr2, int i, int i2) {
        int i3;
        char c = 0;
        h(0, i, i2);
        long j = 0;
        int i4 = 1;
        long j2 = 0;
        int i5 = 1;
        while (i5 > 0) {
            i5--;
            int[] g = g(i5);
            int i6 = g[c];
            int i7 = g[i4];
            if (i7 - i6 < 10) {
                c(iArr, iArr2, i6, i7);
            } else {
                j2 = ((j2 * 7621) + 1) % 32768;
                long j3 = j2 % 3;
                long j4 = j3 == j ? iArr2[iArr[i6]] : j3 == 1 ? iArr2[iArr[(i6 + i7) >>> i4]] : iArr2[iArr[i7]];
                int i8 = i7;
                int i9 = i8;
                int i10 = i6;
                int i11 = i10;
                while (true) {
                    if (i11 <= i8) {
                        int i12 = iArr2[iArr[i11]] - ((int) j4);
                        if (i12 == 0) {
                            i(iArr, i11, i10);
                            i10++;
                            i11++;
                        } else if (i12 <= 0) {
                            i11++;
                        }
                    }
                    i3 = i9;
                    while (i11 <= i8) {
                        int i13 = iArr2[iArr[i8]] - ((int) j4);
                        if (i13 == 0) {
                            i(iArr, i8, i3);
                            i3--;
                        } else if (i13 < 0) {
                            break;
                        }
                        i8--;
                    }
                    if (i11 > i8) {
                        break;
                    }
                    i(iArr, i11, i8);
                    i11++;
                    i8--;
                    i9 = i3;
                }
                if (i3 >= i10) {
                    int f = f(i10 - i6, i11 - i10);
                    j(iArr, i6, i11 - f, f);
                    int i14 = i7 - i3;
                    int i15 = i3 - i8;
                    int f2 = f(i14, i15);
                    j(iArr, i8 + 1, (i7 - f2) + 1, f2);
                    int i16 = ((i11 + i6) - i10) - 1;
                    int i17 = (i7 - i15) + 1;
                    if (i16 - i6 > i7 - i17) {
                        int i18 = i5 + 1;
                        h(i5, i6, i16);
                        h(i18, i17, i7);
                        i5 = i18 + 1;
                    } else {
                        int i19 = i5 + 1;
                        h(i5, i17, i7);
                        h(i19, i6, i16);
                        i5 = i19 + 1;
                    }
                }
                c = 0;
                j = 0;
                i4 = 1;
            }
        }
    }

    public final void c(int[] iArr, int[] iArr2, int i, int i2) {
        if (i == i2) {
            return;
        }
        if (i2 - i > 3) {
            for (int i3 = i2 - 4; i3 >= i; i3--) {
                int i4 = iArr[i3];
                int i5 = iArr2[i4];
                int i6 = i3 + 4;
                while (i6 <= i2) {
                    int i7 = iArr[i6];
                    if (i5 > iArr2[i7]) {
                        iArr[i6 - 4] = i7;
                        i6 += 4;
                    }
                }
                iArr[i6 - 4] = i4;
            }
        }
        for (int i8 = i2 - 1; i8 >= i; i8--) {
            int i9 = iArr[i8];
            int i10 = iArr2[i9];
            int i11 = i8 + 1;
            while (i11 <= i2) {
                int i12 = iArr[i11];
                if (i10 > iArr2[i12]) {
                    iArr[i11 - 1] = i12;
                    i11++;
                }
            }
            iArr[i11 - 1] = i9;
        }
    }

    public final void d(org.apache.tools.bzip2.CBZip2OutputStream.Data data, int i) {
        byte[] bArr = data.q;
        int i2 = i + 1;
        bArr[0] = bArr[i2];
        e(data.r, bArr, i2);
        for (int i3 = 0; i3 < i2; i3++) {
            data.r[i3] = r2[i3] - 1;
        }
        for (int i4 = 0; i4 < i2; i4++) {
            int[] iArr = data.r;
            if (iArr[i4] == -1) {
                iArr[i4] = i;
                return;
            }
        }
    }

    public final void e(int[] iArr, byte[] bArr, int i) {
        int i2;
        int[] iArr2 = new int[257];
        int[] k = k();
        for (int i3 = 0; i3 < i; i3++) {
            k[i3] = 0;
        }
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = bArr[i4] & 255;
            iArr2[i5] = iArr2[i5] + 1;
        }
        for (int i6 = 1; i6 < 257; i6++) {
            iArr2[i6] = iArr2[i6] + iArr2[i6 - 1];
        }
        for (int i7 = 0; i7 < i; i7++) {
            int i8 = bArr[i7] & 255;
            int i9 = iArr2[i8] - 1;
            iArr2[i8] = i9;
            iArr[i9] = i7;
        }
        java.util.BitSet bitSet = new java.util.BitSet(i + 64);
        for (int i10 = 0; i10 < 256; i10++) {
            bitSet.set(iArr2[i10]);
        }
        for (int i11 = 0; i11 < 32; i11++) {
            int i12 = (i11 * 2) + i;
            bitSet.set(i12);
            bitSet.clear(i12 + 1);
        }
        int i13 = 1;
        do {
            int i14 = 0;
            for (int i15 = 0; i15 < i; i15++) {
                if (bitSet.get(i15)) {
                    i14 = i15;
                }
                int i16 = iArr[i15] - i13;
                if (i16 < 0) {
                    i16 += i;
                }
                k[i16] = i14;
            }
            int i17 = -1;
            i2 = 0;
            while (true) {
                int nextClearBit = bitSet.nextClearBit(i17 + 1);
                int i18 = nextClearBit - 1;
                if (i18 < i && (i17 = bitSet.nextSetBit(nextClearBit + 1) - 1) < i) {
                    if (i17 > i18) {
                        i2 += (i17 - i18) + 1;
                        b(iArr, k, i18, i17);
                        int i19 = -1;
                        while (i18 <= i17) {
                            int i20 = k[iArr[i18]];
                            if (i19 != i20) {
                                bitSet.set(i18);
                                i19 = i20;
                            }
                            i18++;
                        }
                    }
                }
            }
            i13 *= 2;
            if (i13 > i) {
                return;
            }
        } while (i2 != 0);
    }

    public final int f(int i, int i2) {
        return i < i2 ? i : i2;
    }

    public final int[] g(int i) {
        return new int[]{this.d[i], this.e[i]};
    }

    public final void h(int i, int i2, int i3) {
        this.d[i] = i2;
        this.e[i] = i3;
    }

    public final void i(int[] iArr, int i, int i2) {
        int i3 = iArr[i];
        iArr[i] = iArr[i2];
        iArr[i2] = i3;
    }

    public final void j(int[] iArr, int i, int i2, int i3) {
        while (i3 > 0) {
            i(iArr, i, i2);
            i++;
            i2++;
            i3--;
        }
    }

    public final int[] k() {
        if (this.l == null) {
            this.l = new int[this.k.length / 2];
        }
        return this.l;
    }

    public final void l(org.apache.tools.bzip2.CBZip2OutputStream.Data data, int i, int i2, int i3, int i4) {
        int i5;
        int[] iArr = this.d;
        int[] iArr2 = this.e;
        int[] iArr3 = this.f;
        int[] iArr4 = data.r;
        byte[] bArr = data.q;
        iArr[0] = i;
        iArr2[0] = i2;
        iArr3[0] = i3;
        int i6 = 1;
        int i7 = 1;
        while (true) {
            int i8 = i7 - 1;
            if (i8 < 0) {
                return;
            }
            int i9 = iArr[i8];
            int i10 = iArr2[i8];
            int i11 = iArr3[i8];
            if (i10 - i9 >= 20 && i11 <= 10) {
                int i12 = i11 + 1;
                int o = o(bArr[iArr4[i9] + i12], bArr[iArr4[i10] + i12], bArr[iArr4[(i9 + i10) >>> i6] + i12]) & 255;
                int i13 = i9;
                int i14 = i13;
                int i15 = i10;
                int i16 = i15;
                while (true) {
                    if (i13 <= i15) {
                        int i17 = iArr4[i13];
                        int i18 = (bArr[i17 + i12] & 255) - o;
                        if (i18 == 0) {
                            iArr4[i13] = iArr4[i14];
                            iArr4[i14] = i17;
                            i14++;
                            i13++;
                        } else if (i18 < 0) {
                            i13++;
                        }
                    }
                    i5 = i16;
                    while (i13 <= i15) {
                        int i19 = iArr4[i15];
                        int i20 = (bArr[i19 + i12] & 255) - o;
                        if (i20 != 0) {
                            if (i20 <= 0) {
                                break;
                            } else {
                                i15--;
                            }
                        } else {
                            iArr4[i15] = iArr4[i5];
                            iArr4[i5] = i19;
                            i5--;
                            i15--;
                        }
                    }
                    if (i13 > i15) {
                        break;
                    }
                    int i21 = iArr4[i13];
                    iArr4[i13] = iArr4[i15];
                    iArr4[i15] = i21;
                    i15--;
                    i13++;
                    i16 = i5;
                }
                if (i5 < i14) {
                    iArr[i8] = i9;
                    iArr2[i8] = i10;
                    iArr3[i8] = i12;
                    i7 = i8 + 1;
                    i6 = 1;
                } else {
                    int i22 = i14 - i9;
                    int i23 = i13 - i14;
                    if (i22 >= i23) {
                        i22 = i23;
                    }
                    p(iArr4, i9, i13 - i22, i22);
                    int i24 = i10 - i5;
                    int i25 = i5 - i15;
                    if (i24 >= i25) {
                        i24 = i25;
                    }
                    p(iArr4, i13, (i10 - i24) + 1, i24);
                    int i26 = ((i13 + i9) - i14) - 1;
                    int i27 = (i10 - i25) + 1;
                    iArr[i8] = i9;
                    iArr2[i8] = i26;
                    iArr3[i8] = i11;
                    int i28 = i8 + 1;
                    iArr[i28] = i26 + 1;
                    iArr2[i28] = i27 - 1;
                    iArr3[i28] = i12;
                    int i29 = i28 + 1;
                    iArr[i29] = i27;
                    iArr2[i29] = i10;
                    iArr3[i29] = i11;
                    i8 = i29 + 1;
                }
            } else if (m(data, i9, i10, i11, i4)) {
                return;
            }
            i7 = i8;
            i6 = 1;
        }
    }

    public final boolean m(org.apache.tools.bzip2.CBZip2OutputStream.Data data, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10 = (i2 - i) + 1;
        if (i10 < 2) {
            return this.c && this.a > this.b;
        }
        int i11 = 0;
        while (m[i11] < i10) {
            i11++;
        }
        int[] iArr = data.r;
        char[] cArr = this.k;
        byte[] bArr = data.q;
        int i12 = i4 + 1;
        boolean z = this.c;
        int i13 = this.b;
        int i14 = this.a;
        loop1: while (true) {
            i11--;
            if (i11 < 0) {
                break;
            }
            int i15 = m[i11];
            int i16 = i + i15;
            int i17 = i16 - 1;
            while (i16 <= i2) {
                int i18 = 3;
                while (i16 <= i2) {
                    int i19 = i18 - 1;
                    if (i19 < 0) {
                        break;
                    }
                    int i20 = iArr[i16];
                    int i21 = i20 + i3;
                    int i22 = i16;
                    boolean z2 = false;
                    int i23 = 0;
                    while (true) {
                        if (z2) {
                            iArr[i22] = i23;
                            i9 = i22 - i15;
                            if (i9 <= i17) {
                                i8 = i11;
                                i6 = i15;
                                i5 = i17;
                                i7 = i19;
                                break;
                            }
                            i22 = i9;
                        } else {
                            z2 = true;
                        }
                        int i24 = iArr[i22 - i15];
                        int i25 = i24 + i3;
                        byte b = bArr[i25 + 1];
                        byte b2 = bArr[i21 + 1];
                        if (b != b2) {
                            i8 = i11;
                            i6 = i15;
                            i5 = i17;
                            i7 = i19;
                            if ((b & 255) <= (b2 & 255)) {
                                break;
                            }
                            i23 = i24;
                            i11 = i8;
                            i19 = i7;
                            i15 = i6;
                            i17 = i5;
                        } else {
                            byte b3 = bArr[i25 + 2];
                            byte b4 = bArr[i21 + 2];
                            if (b3 != b4) {
                                i8 = i11;
                                i6 = i15;
                                i5 = i17;
                                i7 = i19;
                                if ((b3 & 255) <= (b4 & 255)) {
                                    break;
                                }
                                i23 = i24;
                                i11 = i8;
                                i19 = i7;
                                i15 = i6;
                                i17 = i5;
                            } else {
                                byte b5 = bArr[i25 + 3];
                                byte b6 = bArr[i21 + 3];
                                if (b5 != b6) {
                                    i8 = i11;
                                    i6 = i15;
                                    i5 = i17;
                                    i7 = i19;
                                    if ((b5 & 255) <= (b6 & 255)) {
                                        break;
                                    }
                                    i23 = i24;
                                    i11 = i8;
                                    i19 = i7;
                                    i15 = i6;
                                    i17 = i5;
                                } else {
                                    byte b7 = bArr[i25 + 4];
                                    byte b8 = bArr[i21 + 4];
                                    if (b7 != b8) {
                                        i8 = i11;
                                        i6 = i15;
                                        i5 = i17;
                                        i7 = i19;
                                        if ((b7 & 255) <= (b8 & 255)) {
                                            break;
                                        }
                                        i23 = i24;
                                        i11 = i8;
                                        i19 = i7;
                                        i15 = i6;
                                        i17 = i5;
                                    } else {
                                        byte b9 = bArr[i25 + 5];
                                        byte b10 = bArr[i21 + 5];
                                        if (b9 != b10) {
                                            i8 = i11;
                                            i6 = i15;
                                            i5 = i17;
                                            i7 = i19;
                                            if ((b9 & 255) <= (b10 & 255)) {
                                                break;
                                            }
                                            i23 = i24;
                                            i11 = i8;
                                            i19 = i7;
                                            i15 = i6;
                                            i17 = i5;
                                        } else {
                                            int i26 = i25 + 6;
                                            byte b11 = bArr[i26];
                                            int i27 = i21 + 6;
                                            i8 = i11;
                                            byte b12 = bArr[i27];
                                            if (b11 != b12) {
                                                i6 = i15;
                                                i5 = i17;
                                                i7 = i19;
                                                if ((b11 & 255) <= (b12 & 255)) {
                                                    break;
                                                }
                                                i23 = i24;
                                                i11 = i8;
                                                i19 = i7;
                                                i15 = i6;
                                                i17 = i5;
                                            } else {
                                                int i28 = i4;
                                                while (true) {
                                                    if (i28 <= 0) {
                                                        i6 = i15;
                                                        i5 = i17;
                                                        i7 = i19;
                                                        break;
                                                    }
                                                    int i29 = i28 - 4;
                                                    int i30 = i26 + 1;
                                                    byte b13 = bArr[i30];
                                                    int i31 = i27 + 1;
                                                    i6 = i15;
                                                    byte b14 = bArr[i31];
                                                    if (b13 != b14) {
                                                        i5 = i17;
                                                        i7 = i19;
                                                        if ((b13 & 255) <= (b14 & 255)) {
                                                            break;
                                                        }
                                                    } else {
                                                        char c = cArr[i26];
                                                        char c2 = cArr[i27];
                                                        if (c != c2) {
                                                            i5 = i17;
                                                            i7 = i19;
                                                            if (c <= c2) {
                                                                break;
                                                            }
                                                        } else {
                                                            int i32 = i26 + 2;
                                                            byte b15 = bArr[i32];
                                                            int i33 = i27 + 2;
                                                            i5 = i17;
                                                            byte b16 = bArr[i33];
                                                            if (b15 != b16) {
                                                                i7 = i19;
                                                                if ((b15 & 255) <= (b16 & 255)) {
                                                                    break;
                                                                }
                                                            } else {
                                                                char c3 = cArr[i30];
                                                                char c4 = cArr[i31];
                                                                if (c3 != c4) {
                                                                    i7 = i19;
                                                                    if (c3 <= c4) {
                                                                        break;
                                                                    }
                                                                } else {
                                                                    int i34 = i26 + 3;
                                                                    byte b17 = bArr[i34];
                                                                    int i35 = i27 + 3;
                                                                    i7 = i19;
                                                                    byte b18 = bArr[i35];
                                                                    if (b17 != b18) {
                                                                        if ((b17 & 255) <= (b18 & 255)) {
                                                                            break;
                                                                        }
                                                                    } else {
                                                                        char c5 = cArr[i32];
                                                                        char c6 = cArr[i33];
                                                                        if (c5 != c6) {
                                                                            if (c5 <= c6) {
                                                                                break;
                                                                            }
                                                                        } else {
                                                                            int i36 = i26 + 4;
                                                                            byte b19 = bArr[i36];
                                                                            i27 += 4;
                                                                            byte b20 = bArr[i27];
                                                                            if (b19 != b20) {
                                                                                if ((b19 & 255) <= (b20 & 255)) {
                                                                                    break;
                                                                                }
                                                                            } else {
                                                                                char c7 = cArr[i34];
                                                                                char c8 = cArr[i35];
                                                                                if (c7 != c8) {
                                                                                    if (c7 <= c8) {
                                                                                        break;
                                                                                    }
                                                                                } else {
                                                                                    if (i36 >= i12) {
                                                                                        i36 -= i12;
                                                                                    }
                                                                                    i26 = i36;
                                                                                    if (i27 >= i12) {
                                                                                        i27 -= i12;
                                                                                    }
                                                                                    i14++;
                                                                                    i28 = i29;
                                                                                    i19 = i7;
                                                                                    i15 = i6;
                                                                                    i17 = i5;
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                i23 = i24;
                                                i11 = i8;
                                                i19 = i7;
                                                i15 = i6;
                                                i17 = i5;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    i9 = i22;
                    iArr[i9] = i20;
                    i16++;
                    i11 = i8;
                    i18 = i7;
                    i15 = i6;
                    i17 = i5;
                }
                int i37 = i11;
                int i38 = i15;
                int i39 = i17;
                if (z && i16 <= i2 && i14 > i13) {
                    break loop1;
                }
                i11 = i37;
                i15 = i38;
                i17 = i39;
            }
        }
        this.a = i14;
        return z && i14 > i13;
    }

    public final void n(org.apache.tools.bzip2.CBZip2OutputStream.Data data, int i) {
        int i2;
        int i3;
        int[] iArr;
        int i4;
        int i5;
        int i6;
        int[] iArr2 = this.g;
        int[] iArr3 = this.h;
        boolean[] zArr = this.i;
        int[] iArr4 = this.j;
        byte[] bArr = data.q;
        int[] iArr5 = data.r;
        char[] cArr = this.k;
        int i7 = this.b;
        boolean z = this.c;
        int i8 = 65537;
        while (true) {
            i8--;
            if (i8 < 0) {
                break;
            } else {
                iArr4[i8] = 0;
            }
        }
        for (int i9 = 0; i9 < 20; i9++) {
            bArr[i + i9 + 2] = bArr[(i9 % (i + 1)) + 1];
        }
        int i10 = i + 20 + 1;
        while (true) {
            i10--;
            if (i10 < 0) {
                break;
            } else {
                cArr[i10] = 0;
            }
        }
        int i11 = i + 1;
        byte b = bArr[i11];
        bArr[0] = b;
        int i12 = 255;
        int i13 = b & 255;
        int i14 = 0;
        while (i14 <= i) {
            i14++;
            int i15 = bArr[i14] & 255;
            int i16 = (i13 << 8) + i15;
            iArr4[i16] = iArr4[i16] + 1;
            i13 = i15;
        }
        for (int i17 = 1; i17 <= 65536; i17++) {
            iArr4[i17] = iArr4[i17] + iArr4[i17 - 1];
        }
        int i18 = bArr[1] & 255;
        int i19 = 0;
        while (i19 < i) {
            int i20 = bArr[i19 + 2] & 255;
            int i21 = (i18 << 8) + i20;
            int i22 = iArr4[i21] - 1;
            iArr4[i21] = i22;
            iArr5[i22] = i19;
            i19++;
            i18 = i20;
        }
        int i23 = ((bArr[i11] & 255) << 8) + (bArr[1] & 255);
        int i24 = iArr4[i23] - 1;
        iArr4[i23] = i24;
        iArr5[i24] = i;
        int i25 = 256;
        while (true) {
            i25--;
            if (i25 < 0) {
                break;
            }
            zArr[i25] = false;
            iArr2[i25] = i25;
        }
        int i26 = 364;
        while (i26 != 1) {
            i26 /= 3;
            int i27 = i26;
            while (i27 <= i12) {
                int i28 = iArr2[i27];
                int i29 = iArr4[(i28 + 1) << 8] - iArr4[i28 << 8];
                int i30 = i26 - 1;
                int i31 = iArr2[i27 - i26];
                int i32 = i27;
                while (true) {
                    i6 = i7;
                    if (iArr4[(i31 + 1) << 8] - iArr4[i31 << 8] <= i29) {
                        break;
                    }
                    iArr2[i32] = i31;
                    int i33 = i32 - i26;
                    if (i33 <= i30) {
                        i32 = i33;
                        break;
                    } else {
                        i31 = iArr2[i33 - i26];
                        i32 = i33;
                        i7 = i6;
                    }
                }
                iArr2[i32] = i28;
                i27++;
                i7 = i6;
                i12 = 255;
            }
        }
        int i34 = i7;
        int i35 = 0;
        while (i35 <= i12) {
            int i36 = iArr2[i35];
            int i37 = 0;
            while (i37 <= i12) {
                int i38 = (i36 << 8) + i37;
                int i39 = iArr4[i38];
                if ((i39 & 2097152) != 2097152) {
                    int i40 = i39 & (-2097153);
                    int i41 = (iArr4[i38 + 1] & (-2097153)) - 1;
                    if (i41 > i40) {
                        i5 = 2097152;
                        i2 = i37;
                        i3 = i34;
                        iArr = iArr2;
                        i4 = i35;
                        l(data, i40, i41, 2, i);
                        if (z && this.a > i3) {
                            return;
                        }
                    } else {
                        i2 = i37;
                        i3 = i34;
                        i5 = 2097152;
                        iArr = iArr2;
                        i4 = i35;
                    }
                    iArr4[i38] = i39 | i5;
                } else {
                    i2 = i37;
                    i3 = i34;
                    iArr = iArr2;
                    i4 = i35;
                }
                i37 = i2 + 1;
                i35 = i4;
                iArr2 = iArr;
                i12 = 255;
                i34 = i3;
            }
            int i42 = i34;
            int[] iArr6 = iArr2;
            int i43 = i35;
            for (int i44 = 0; i44 <= 255; i44++) {
                iArr3[i44] = iArr4[(i44 << 8) + i36] & (-2097153);
            }
            int i45 = i36 << 8;
            int i46 = iArr4[i45] & (-2097153);
            int i47 = (i36 + 1) << 8;
            int i48 = iArr4[i47] & (-2097153);
            while (i46 < i48) {
                int i49 = iArr5[i46];
                int i50 = i48;
                int i51 = bArr[i49] & 255;
                if (!zArr[i51]) {
                    iArr5[iArr3[i51]] = i49 == 0 ? i : i49 - 1;
                    iArr3[i51] = iArr3[i51] + 1;
                }
                i46++;
                i48 = i50;
            }
            int i52 = 256;
            while (true) {
                i52--;
                if (i52 < 0) {
                    break;
                }
                int i53 = (i52 << 8) + i36;
                iArr4[i53] = iArr4[i53] | 2097152;
            }
            zArr[i36] = true;
            if (i43 < 255) {
                int i54 = iArr4[i45] & (-2097153);
                int i55 = ((-2097153) & iArr4[i47]) - i54;
                int i56 = 0;
                while ((i55 >> i56) > 65534) {
                    i56++;
                }
                int i57 = 0;
                while (i57 < i55) {
                    int i58 = iArr5[i54 + i57];
                    char c = (char) (i57 >> i56);
                    cArr[i58] = c;
                    int i59 = i54;
                    if (i58 < 20) {
                        cArr[i58 + i + 1] = c;
                    }
                    i57++;
                    i54 = i59;
                }
            }
            i35 = i43 + 1;
            iArr2 = iArr6;
            i12 = 255;
            i34 = i42;
        }
    }
}
