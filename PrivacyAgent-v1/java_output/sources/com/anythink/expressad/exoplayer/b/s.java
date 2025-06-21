package com.anythink.expressad.exoplayer.b;

/* loaded from: classes12.dex */
final class s {
    private static final int a = 65;
    private static final int b = 400;
    private static final int c = 4000;
    private final int d;
    private final int e;
    private final float f;
    private final float g;
    private final float h;
    private final int i;
    private final int j;
    private final int k;
    private final short[] l;
    private short[] m;
    private int n;
    private short[] o;
    private int p;
    private short[] q;
    private int r;

    /* renamed from: s, reason: collision with root package name */
    private int f209s;
    private int t;
    private int u;
    private int v;
    private int w;
    private int x;
    private int y;

    public s(int i, int i2, float f, float f2, int i3) {
        this.d = i;
        this.e = i2;
        this.f = f;
        this.g = f2;
        this.h = i / i3;
        this.i = i / 400;
        int i4 = i / 65;
        this.j = i4;
        int i5 = i4 * 2;
        this.k = i5;
        this.l = new short[i5];
        this.m = new short[i5 * i2];
        this.o = new short[i5 * i2];
        this.q = new short[i5 * i2];
    }

    private int a(short[] sArr, int i) {
        int i2;
        int i3 = this.d;
        int i4 = i3 > 4000 ? i3 / 4000 : 1;
        if (this.e == 1 && i4 == 1) {
            i2 = a(sArr, i, this.i, this.j);
        } else {
            c(sArr, i, i4);
            int a2 = a(this.l, 0, this.i / i4, this.j / i4);
            if (i4 != 1) {
                int i5 = a2 * i4;
                int i6 = i4 * 4;
                int i7 = i5 - i6;
                int i8 = i5 + i6;
                int i9 = this.i;
                if (i7 < i9) {
                    i7 = i9;
                }
                int i10 = this.j;
                if (i8 > i10) {
                    i8 = i10;
                }
                if (this.e == 1) {
                    i2 = a(sArr, i, i7, i8);
                } else {
                    c(sArr, i, 1);
                    i2 = a(this.l, 0, i7, i8);
                }
            } else {
                i2 = a2;
            }
        }
        int i11 = this.x;
        int i12 = i11 != 0 && this.v != 0 && this.y <= i11 * 3 && i11 * 2 > this.w * 3 ? this.v : i2;
        this.w = i11;
        this.v = i2;
        return i12;
    }

    private int a(short[] sArr, int i, float f, int i2) {
        int i3;
        if (f >= 2.0f) {
            i3 = (int) (i2 / (f - 1.0f));
        } else {
            this.u = (int) ((i2 * (2.0f - f)) / (f - 1.0f));
            i3 = i2;
        }
        short[] a2 = a(this.o, this.p, i3);
        this.o = a2;
        a(i3, this.e, a2, this.p, sArr, i, sArr, i + i2);
        this.p += i3;
        return i3;
    }

    private int a(short[] sArr, int i, int i2, int i3) {
        int i4 = i * this.e;
        int i5 = 255;
        int i6 = 1;
        int i7 = 0;
        int i8 = 0;
        while (i2 <= i3) {
            int i9 = 0;
            for (int i10 = 0; i10 < i2; i10++) {
                i9 += java.lang.Math.abs(sArr[i4 + i10] - sArr[(i4 + i2) + i10]);
            }
            if (i9 * i7 < i6 * i2) {
                i7 = i2;
                i6 = i9;
            }
            if (i9 * i5 > i8 * i2) {
                i5 = i2;
                i8 = i9;
            }
            i2++;
        }
        this.x = i6 / i7;
        this.y = i8 / i5;
        return i7;
    }

    private void a(float f) {
        int i;
        int i2;
        int i3;
        int i4 = this.n;
        if (i4 < this.k) {
            return;
        }
        int i5 = 0;
        do {
            int i6 = this.u;
            if (i6 > 0) {
                int min = java.lang.Math.min(this.k, i6);
                b(this.m, i5, min);
                this.u -= min;
                i5 += min;
            } else {
                short[] sArr = this.m;
                int i7 = this.d;
                int i8 = i7 > 4000 ? i7 / 4000 : 1;
                if (this.e == 1 && i8 == 1) {
                    i = a(sArr, i5, this.i, this.j);
                } else {
                    c(sArr, i5, i8);
                    int a2 = a(this.l, 0, this.i / i8, this.j / i8);
                    if (i8 != 1) {
                        int i9 = a2 * i8;
                        int i10 = i8 * 4;
                        int i11 = i9 - i10;
                        int i12 = i9 + i10;
                        int i13 = this.i;
                        if (i11 < i13) {
                            i11 = i13;
                        }
                        int i14 = this.j;
                        if (i12 > i14) {
                            i12 = i14;
                        }
                        if (this.e == 1) {
                            i = a(sArr, i5, i11, i12);
                        } else {
                            c(sArr, i5, 1);
                            i = a(this.l, 0, i11, i12);
                        }
                    } else {
                        i = a2;
                    }
                }
                int i15 = this.x;
                int i16 = i15 != 0 && this.v != 0 && this.y <= i15 * 3 && i15 * 2 > this.w * 3 ? this.v : i;
                this.w = i15;
                this.v = i;
                if (f > 1.0d) {
                    short[] sArr2 = this.m;
                    if (f >= 2.0f) {
                        i3 = (int) (i16 / (f - 1.0f));
                    } else {
                        this.u = (int) ((i16 * (2.0f - f)) / (f - 1.0f));
                        i3 = i16;
                    }
                    short[] a3 = a(this.o, this.p, i3);
                    this.o = a3;
                    a(i3, this.e, a3, this.p, sArr2, i5, sArr2, i5 + i16);
                    this.p += i3;
                    i5 += i16 + i3;
                } else {
                    short[] sArr3 = this.m;
                    if (f < 0.5f) {
                        i2 = (int) ((i16 * f) / (1.0f - f));
                    } else {
                        this.u = (int) ((i16 * ((2.0f * f) - 1.0f)) / (1.0f - f));
                        i2 = i16;
                    }
                    int i17 = i16 + i2;
                    short[] a4 = a(this.o, this.p, i17);
                    this.o = a4;
                    int i18 = this.e;
                    java.lang.System.arraycopy(sArr3, i5 * i18, a4, this.p * i18, i18 * i16);
                    a(i2, this.e, this.o, this.p + i16, sArr3, i5 + i16, sArr3, i5);
                    this.p += i17;
                    i5 += i2;
                }
            }
        } while (this.k + i5 <= i4);
        int i19 = this.n - i5;
        short[] sArr4 = this.m;
        int i20 = this.e;
        java.lang.System.arraycopy(sArr4, i5 * i20, sArr4, 0, i20 * i19);
        this.n = i19;
    }

    private void a(float f, int i) {
        int i2;
        int i3;
        int i4;
        if (this.p == i) {
            return;
        }
        int i5 = this.d;
        int i6 = (int) (i5 / f);
        while (true) {
            if (i6 <= 16384 && i5 <= 16384) {
                break;
            }
            i6 /= 2;
            i5 /= 2;
        }
        int i7 = this.p - i;
        short[] a2 = a(this.q, this.r, i7);
        this.q = a2;
        short[] sArr = this.o;
        int i8 = this.e;
        java.lang.System.arraycopy(sArr, i * i8, a2, this.r * i8, i8 * i7);
        this.p = i;
        this.r += i7;
        int i9 = 0;
        while (true) {
            i2 = this.r;
            if (i9 >= i2 - 1) {
                break;
            }
            while (true) {
                i3 = this.f209s;
                int i10 = (i3 + 1) * i6;
                i4 = this.t;
                if (i10 <= i4 * i5) {
                    break;
                }
                this.o = a(this.o, this.p, 1);
                int i11 = 0;
                while (true) {
                    int i12 = this.e;
                    if (i11 < i12) {
                        short[] sArr2 = this.o;
                        int i13 = (this.p * i12) + i11;
                        short[] sArr3 = this.q;
                        int i14 = (i9 * i12) + i11;
                        short s2 = sArr3[i14];
                        short s3 = sArr3[i14 + i12];
                        int i15 = this.t * i5;
                        int i16 = this.f209s;
                        int i17 = i16 * i6;
                        int i18 = (i16 + 1) * i6;
                        int i19 = i18 - i15;
                        int i20 = i18 - i17;
                        sArr2[i13] = (short) (((s2 * i19) + ((i20 - i19) * s3)) / i20);
                        i11++;
                    }
                }
                this.t++;
                this.p++;
            }
            int i21 = i3 + 1;
            this.f209s = i21;
            if (i21 == i5) {
                this.f209s = 0;
                com.anythink.expressad.exoplayer.k.a.b(i4 == i6);
                this.t = 0;
            }
            i9++;
        }
        int i22 = i2 - 1;
        if (i22 != 0) {
            short[] sArr4 = this.q;
            int i23 = this.e;
            java.lang.System.arraycopy(sArr4, i22 * i23, sArr4, 0, (i2 - i22) * i23);
            this.r -= i22;
        }
    }

    private void a(int i) {
        int i2 = this.n - i;
        short[] sArr = this.m;
        int i3 = this.e;
        java.lang.System.arraycopy(sArr, i * i3, sArr, 0, i3 * i2);
        this.n = i2;
    }

    private static void a(int i, int i2, short[] sArr, int i3, short[] sArr2, int i4, short[] sArr3, int i5) {
        for (int i6 = 0; i6 < i2; i6++) {
            int i7 = (i3 * i2) + i6;
            int i8 = (i5 * i2) + i6;
            int i9 = (i4 * i2) + i6;
            for (int i10 = 0; i10 < i; i10++) {
                sArr[i7] = (short) (((sArr2[i9] * (i - i10)) + (sArr3[i8] * i10)) / i);
                i7 += i2;
                i9 += i2;
                i8 += i2;
            }
        }
    }

    private boolean a(int i, int i2) {
        return i != 0 && this.v != 0 && i2 <= i * 3 && i * 2 > this.w * 3;
    }

    private short[] a(short[] sArr, int i, int i2) {
        int length = sArr.length;
        int i3 = this.e;
        int i4 = length / i3;
        return i + i2 <= i4 ? sArr : java.util.Arrays.copyOf(sArr, (((i4 * 3) / 2) + i2) * i3);
    }

    private int b(int i) {
        int min = java.lang.Math.min(this.k, this.u);
        b(this.m, i, min);
        this.u -= min;
        return min;
    }

    private int b(short[] sArr, int i, float f, int i2) {
        int i3;
        if (f < 0.5f) {
            i3 = (int) ((i2 * f) / (1.0f - f));
        } else {
            this.u = (int) ((i2 * ((2.0f * f) - 1.0f)) / (1.0f - f));
            i3 = i2;
        }
        int i4 = i2 + i3;
        short[] a2 = a(this.o, this.p, i4);
        this.o = a2;
        int i5 = this.e;
        java.lang.System.arraycopy(sArr, i * i5, a2, this.p * i5, i5 * i2);
        a(i3, this.e, this.o, this.p + i2, sArr, i + i2, sArr, i);
        this.p += i4;
        return i3;
    }

    private short b(short[] sArr, int i, int i2, int i3) {
        short s2 = sArr[i];
        short s3 = sArr[i + this.e];
        int i4 = this.t * i2;
        int i5 = this.f209s;
        int i6 = i5 * i3;
        int i7 = (i5 + 1) * i3;
        int i8 = i7 - i4;
        int i9 = i7 - i6;
        return (short) (((s2 * i8) + ((i9 - i8) * s3)) / i9);
    }

    private void b(short[] sArr, int i, int i2) {
        short[] a2 = a(this.o, this.p, i2);
        this.o = a2;
        int i3 = this.e;
        java.lang.System.arraycopy(sArr, i * i3, a2, this.p * i3, i3 * i2);
        this.p += i2;
    }

    private void c(int i) {
        int i2 = this.p - i;
        short[] a2 = a(this.q, this.r, i2);
        this.q = a2;
        short[] sArr = this.o;
        int i3 = this.e;
        java.lang.System.arraycopy(sArr, i * i3, a2, this.r * i3, i3 * i2);
        this.p = i;
        this.r += i2;
    }

    private void c(short[] sArr, int i, int i2) {
        int i3 = this.k / i2;
        int i4 = this.e;
        int i5 = i2 * i4;
        int i6 = i * i4;
        for (int i7 = 0; i7 < i3; i7++) {
            int i8 = 0;
            for (int i9 = 0; i9 < i5; i9++) {
                i8 += sArr[(i7 * i5) + i6 + i9];
            }
            this.l[i7] = (short) (i8 / i5);
        }
    }

    private void d() {
        int i = this.p;
        float f = this.f;
        float f2 = this.g;
        float f3 = f / f2;
        float f4 = this.h * f2;
        double d = f3;
        if (d > 1.00001d || d < 0.99999d) {
            a(f3);
        } else {
            b(this.m, 0, this.n);
            this.n = 0;
        }
        if (f4 != 1.0f) {
            a(f4, i);
        }
    }

    private void d(int i) {
        if (i == 0) {
            return;
        }
        short[] sArr = this.q;
        int i2 = this.e;
        java.lang.System.arraycopy(sArr, i * i2, sArr, 0, (this.r - i) * i2);
        this.r -= i;
    }

    public final void a() {
        int i;
        int i2 = this.n;
        float f = this.f;
        float f2 = this.g;
        int i3 = this.p + ((int) ((((i2 / (f / f2)) + this.r) / (this.h * f2)) + 0.5f));
        this.m = a(this.m, i2, (this.k * 2) + i2);
        int i4 = 0;
        while (true) {
            i = this.k;
            int i5 = this.e;
            if (i4 >= i * 2 * i5) {
                break;
            }
            this.m[(i5 * i2) + i4] = 0;
            i4++;
        }
        this.n += i * 2;
        d();
        if (this.p > i3) {
            this.p = i3;
        }
        this.n = 0;
        this.u = 0;
        this.r = 0;
    }

    public final void a(java.nio.ShortBuffer shortBuffer) {
        int remaining = shortBuffer.remaining();
        int i = this.e;
        int i2 = remaining / i;
        short[] a2 = a(this.m, this.n, i2);
        this.m = a2;
        shortBuffer.get(a2, this.n * this.e, ((i * i2) * 2) / 2);
        this.n += i2;
        d();
    }

    public final void b() {
        this.n = 0;
        this.p = 0;
        this.r = 0;
        this.f209s = 0;
        this.t = 0;
        this.u = 0;
        this.v = 0;
        this.w = 0;
        this.x = 0;
        this.y = 0;
    }

    public final void b(java.nio.ShortBuffer shortBuffer) {
        int min = java.lang.Math.min(shortBuffer.remaining() / this.e, this.p);
        shortBuffer.put(this.o, 0, this.e * min);
        int i = this.p - min;
        this.p = i;
        short[] sArr = this.o;
        int i2 = this.e;
        java.lang.System.arraycopy(sArr, min * i2, sArr, 0, i * i2);
    }

    public final int c() {
        return this.p;
    }
}
