package com.badlogic.gdx.utils;

/* loaded from: classes12.dex */
class TimSort<T> {
    public T[] a;
    public java.util.Comparator<? super T> b;
    public int e;
    public int c = 7;
    public int f = 0;
    public T[] d = (T[]) new java.lang.Object[256];
    public final int[] g = new int[40];
    public final int[] h = new int[40];

    public static <T> void a(T[] tArr, int i, int i2, int i3, java.util.Comparator<? super T> comparator) {
        if (i3 == i) {
            i3++;
        }
        while (i3 < i2) {
            T t = tArr[i3];
            int i4 = i;
            int i5 = i3;
            while (i4 < i5) {
                int i6 = (i4 + i5) >>> 1;
                if (comparator.compare(t, tArr[i6]) < 0) {
                    i5 = i6;
                } else {
                    i4 = i6 + 1;
                }
            }
            int i7 = i3 - i4;
            if (i7 != 1) {
                if (i7 != 2) {
                    java.lang.System.arraycopy(tArr, i4, tArr, i4 + 1, i7);
                    tArr[i4] = t;
                    i3++;
                } else {
                    tArr[i4 + 2] = tArr[i4 + 1];
                }
            }
            tArr[i4 + 1] = tArr[i4];
            tArr[i4] = t;
            i3++;
        }
    }

    public static <T> int b(T[] tArr, int i, int i2, java.util.Comparator<? super T> comparator) {
        int i3 = i + 1;
        if (i3 == i2) {
            return 1;
        }
        int i4 = i3 + 1;
        if (comparator.compare(tArr[i3], tArr[i]) < 0) {
            while (i4 < i2 && comparator.compare(tArr[i4], tArr[i4 - 1]) < 0) {
                i4++;
            }
            o(tArr, i, i4);
        } else {
            while (i4 < i2 && comparator.compare(tArr[i4], tArr[i4 - 1]) >= 0) {
                i4++;
            }
        }
        return i4 - i;
    }

    public static <T> int e(T t, T[] tArr, int i, int i2, int i3, java.util.Comparator<? super T> comparator) {
        int i4;
        int i5;
        int i6 = i + i3;
        if (comparator.compare(t, tArr[i6]) > 0) {
            int i7 = i2 - i3;
            int i8 = 0;
            int i9 = 1;
            while (i9 < i7 && comparator.compare(t, tArr[i6 + i9]) > 0) {
                int i10 = (i9 << 1) + 1;
                if (i10 <= 0) {
                    i8 = i9;
                    i9 = i7;
                } else {
                    int i11 = i9;
                    i9 = i10;
                    i8 = i11;
                }
            }
            if (i9 <= i7) {
                i7 = i9;
            }
            i4 = i8 + i3;
            i5 = i7 + i3;
        } else {
            int i12 = i3 + 1;
            int i13 = 0;
            int i14 = 1;
            while (i14 < i12 && comparator.compare(t, tArr[i6 - i14]) <= 0) {
                int i15 = (i14 << 1) + 1;
                if (i15 <= 0) {
                    i13 = i14;
                    i14 = i12;
                } else {
                    int i16 = i14;
                    i14 = i15;
                    i13 = i16;
                }
            }
            if (i14 <= i12) {
                i12 = i14;
            }
            int i17 = i3 - i12;
            int i18 = i3 - i13;
            i4 = i17;
            i5 = i18;
        }
        int i19 = i4 + 1;
        while (i19 < i5) {
            int i20 = ((i5 - i19) >>> 1) + i19;
            if (comparator.compare(t, tArr[i + i20]) > 0) {
                i19 = i20 + 1;
            } else {
                i5 = i20;
            }
        }
        return i5;
    }

    public static <T> int f(T t, T[] tArr, int i, int i2, int i3, java.util.Comparator<? super T> comparator) {
        int i4;
        int i5;
        int i6 = i + i3;
        if (comparator.compare(t, tArr[i6]) < 0) {
            int i7 = i3 + 1;
            int i8 = 0;
            int i9 = 1;
            while (i9 < i7 && comparator.compare(t, tArr[i6 - i9]) < 0) {
                int i10 = (i9 << 1) + 1;
                if (i10 <= 0) {
                    i8 = i9;
                    i9 = i7;
                } else {
                    int i11 = i9;
                    i9 = i10;
                    i8 = i11;
                }
            }
            if (i9 <= i7) {
                i7 = i9;
            }
            i5 = i3 - i7;
            i4 = i3 - i8;
        } else {
            int i12 = i2 - i3;
            int i13 = 0;
            int i14 = 1;
            while (i14 < i12 && comparator.compare(t, tArr[i6 + i14]) >= 0) {
                int i15 = (i14 << 1) + 1;
                if (i15 <= 0) {
                    i13 = i14;
                    i14 = i12;
                } else {
                    int i16 = i14;
                    i14 = i15;
                    i13 = i16;
                }
            }
            if (i14 <= i12) {
                i12 = i14;
            }
            int i17 = i13 + i3;
            i4 = i3 + i12;
            i5 = i17;
        }
        int i18 = i5 + 1;
        while (i18 < i4) {
            int i19 = ((i4 - i18) >>> 1) + i18;
            if (comparator.compare(t, tArr[i + i19]) < 0) {
                i4 = i19;
            } else {
                i18 = i19 + 1;
            }
        }
        return i4;
    }

    public static int l(int i) {
        int i2 = 0;
        while (i >= 32) {
            i2 |= i & 1;
            i >>= 1;
        }
        return i + i2;
    }

    public static void n(int i, int i2, int i3) {
        if (i2 <= i3) {
            if (i2 < 0) {
                throw new java.lang.ArrayIndexOutOfBoundsException(i2);
            }
            if (i3 > i) {
                throw new java.lang.ArrayIndexOutOfBoundsException(i3);
            }
            return;
        }
        throw new java.lang.IllegalArgumentException("fromIndex(" + i2 + ") > toIndex(" + i3 + ")");
    }

    public static void o(java.lang.Object[] objArr, int i, int i2) {
        int i3 = i2 - 1;
        while (i < i3) {
            java.lang.Object obj = objArr[i];
            objArr[i] = objArr[i3];
            objArr[i3] = obj;
            i3--;
            i++;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void c(T[] tArr, java.util.Comparator<T> comparator, int i, int i2) {
        this.f = 0;
        n(tArr.length, i, i2);
        int i3 = i2 - i;
        if (i3 < 2) {
            return;
        }
        if (i3 < 32) {
            a(tArr, i, i2, b(tArr, i, i2, comparator) + i, comparator);
            return;
        }
        this.a = tArr;
        this.b = comparator;
        this.e = 0;
        int l = l(i3);
        do {
            int b = b(tArr, i, i2, comparator);
            if (b < l) {
                int i4 = i3 <= l ? i3 : l;
                a(tArr, i, i + i4, b + i, comparator);
                b = i4;
            }
            m(i, b);
            h();
            i += b;
            i3 -= b;
        } while (i3 != 0);
        i();
        this.a = null;
        this.b = null;
        T[] tArr2 = this.d;
        int i5 = this.e;
        for (int i6 = 0; i6 < i5; i6++) {
            tArr2[i6] = null;
        }
    }

    public final T[] d(int i) {
        this.e = java.lang.Math.max(this.e, i);
        if (this.d.length < i) {
            int i2 = (i >> 1) | i;
            int i3 = i2 | (i2 >> 2);
            int i4 = i3 | (i3 >> 4);
            int i5 = i4 | (i4 >> 8);
            int i6 = (i5 | (i5 >> 16)) + 1;
            if (i6 >= 0) {
                i = java.lang.Math.min(i6, this.a.length >>> 1);
            }
            this.d = (T[]) new java.lang.Object[i];
        }
        return this.d;
    }

    public final void g(int i) {
        int[] iArr = this.g;
        int i2 = iArr[i];
        int[] iArr2 = this.h;
        int i3 = iArr2[i];
        int i4 = i + 1;
        int i5 = iArr[i4];
        int i6 = iArr2[i4];
        iArr2[i] = i3 + i6;
        int i7 = this.f;
        if (i == i7 - 3) {
            int i8 = i + 2;
            iArr[i4] = iArr[i8];
            iArr2[i4] = iArr2[i8];
        }
        this.f = i7 - 1;
        T[] tArr = this.a;
        int f = f(tArr[i5], tArr, i2, i3, 0, this.b);
        int i9 = i2 + f;
        int i10 = i3 - f;
        if (i10 == 0) {
            return;
        }
        T[] tArr2 = this.a;
        int e = e(tArr2[(i9 + i10) - 1], tArr2, i5, i6, i6 - 1, this.b);
        if (e == 0) {
            return;
        }
        if (i10 <= e) {
            k(i9, i10, i5, e);
        } else {
            j(i9, i10, i5, e);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0028, code lost:
    
        if (r1[r0 - 2] <= (r1[r0] + r1[r0 - 1])) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0016, code lost:
    
        if (r1[r0 - 1] > (r1[r0] + r1[r0 + 1])) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x002a, code lost:
    
        r1 = r5.h;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0034, code lost:
    
        if (r1[r0 - 1] >= r1[r0 + 1]) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0036, code lost:
    
        r0 = r0 - 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void h() {
        while (true) {
            int i = this.f;
            if (i <= 1) {
                return;
            }
            int i2 = i - 2;
            if (i2 >= 1) {
                int[] iArr = this.h;
            }
            if (i2 >= 2) {
                int[] iArr2 = this.h;
            }
            int[] iArr3 = this.h;
            if (iArr3[i2] > iArr3[i2 + 1]) {
                return;
            } else {
                g(i2);
            }
        }
    }

    public final void i() {
        while (true) {
            int i = this.f;
            if (i <= 1) {
                return;
            }
            int i2 = i - 2;
            if (i2 > 0) {
                int[] iArr = this.h;
                if (iArr[i2 - 1] < iArr[i2 + 1]) {
                    i2--;
                }
            }
            g(i2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0074, code lost:
    
        r12 = r1;
        r13 = r2;
        r14 = r3;
        r15 = r4;
        r16 = r5;
        r17 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x007c, code lost:
    
        r6 = r12 - f(r8[r15], r7, r21, r12, r12 - 1, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x008b, code lost:
    
        if (r6 == 0) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x008d, code lost:
    
        r1 = r16 - r6;
        r2 = r17 - r6;
        r3 = r12 - r6;
        java.lang.System.arraycopy(r7, r2 + 1, r7, r1 + 1, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x009a, code lost:
    
        if (r3 != 0) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00a4, code lost:
    
        r16 = r1;
        r17 = r2;
        r12 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x009c, code lost:
    
        r12 = r1;
        r6 = r2;
        r1 = r3;
        r2 = r13;
        r3 = r14;
        r4 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00a9, code lost:
    
        r18 = r16 - 1;
        r19 = r15 - 1;
        r7[r16] = r8[r15];
        r13 = r13 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00b3, code lost:
    
        if (r13 != 1) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00bf, code lost:
    
        r1 = r13 - e(r7[r17], r8, 0, r13, r13 - 1, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00ce, code lost:
    
        if (r1 == 0) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00d0, code lost:
    
        r2 = r18 - r1;
        r4 = r19 - r1;
        r3 = r13 - r1;
        java.lang.System.arraycopy(r8, r4 + 1, r7, r2 + 1, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00dd, code lost:
    
        if (r3 > 1) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00e6, code lost:
    
        r18 = r2;
        r13 = r3;
        r19 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00df, code lost:
    
        r1 = r12;
        r6 = r17;
        r12 = r2;
        r2 = r3;
        r3 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00eb, code lost:
    
        r16 = r18 - 1;
        r2 = r17 - 1;
        r7[r18] = r7[r17];
        r12 = r12 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00f5, code lost:
    
        if (r12 != 0) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0123, code lost:
    
        r14 = r14 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0126, code lost:
    
        if (r6 < 7) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0128, code lost:
    
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x012b, code lost:
    
        if (r1 < 7) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x012d, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0131, code lost:
    
        if ((r1 | r4) != false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0141, code lost:
    
        r17 = r2;
        r15 = r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0133, code lost:
    
        if (r14 >= 0) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0135, code lost:
    
        r14 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x012f, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x012a, code lost:
    
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00f7, code lost:
    
        r6 = r2;
        r1 = r12;
        r2 = r13;
        r3 = r14;
        r12 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00b5, code lost:
    
        r1 = r12;
        r2 = r13;
        r3 = r14;
        r6 = r17;
        r12 = r18;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0074 A[EDGE_INSN: B:18:0x0074->B:19:0x0074 BREAK  A[LOOP:1: B:11:0x003e->B:70:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[LOOP:1: B:11:0x003e->B:70:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void j(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12 = i4;
        T[] tArr = this.a;
        T[] d = d(i12);
        java.lang.System.arraycopy(tArr, i3, d, 0, i12);
        int i13 = (i + i2) - 1;
        int i14 = i12 - 1;
        int i15 = (i3 + i12) - 1;
        int i16 = i15 - 1;
        int i17 = i13 - 1;
        tArr[i15] = tArr[i13];
        int i18 = i2 - 1;
        if (i18 == 0) {
            java.lang.System.arraycopy(d, 0, tArr, i16 - i14, i12);
            return;
        }
        if (i12 == 1) {
            int i19 = i16 - i18;
            java.lang.System.arraycopy(tArr, (i17 - i18) + 1, tArr, i19 + 1, i18);
            tArr[i19] = d[i14];
            return;
        }
        java.util.Comparator<? super T> comparator = this.b;
        int i20 = this.c;
        loop0: while (true) {
            int i21 = 0;
            int i22 = 0;
            while (true) {
                if (comparator.compare(d[i14], tArr[i17]) < 0) {
                    i5 = i16 - 1;
                    int i23 = i17 - 1;
                    tArr[i16] = tArr[i17];
                    i22++;
                    i18--;
                    if (i18 == 0) {
                        i17 = i23;
                        break loop0;
                    }
                    i16 = i5;
                    i17 = i23;
                    i21 = 0;
                    if ((i22 | i21) < i20) {
                        break;
                    }
                } else {
                    int i24 = i16 - 1;
                    int i25 = i14 - 1;
                    tArr[i16] = d[i14];
                    i21++;
                    i12--;
                    if (i12 == 1) {
                        i5 = i24;
                        i14 = i25;
                        break loop0;
                    } else {
                        i16 = i24;
                        i14 = i25;
                        i22 = 0;
                        if ((i22 | i21) < i20) {
                        }
                    }
                }
            }
            i20 = i8 + 2;
            i17 = i11;
            i18 = i6;
            i12 = i7;
            i16 = i9;
            i14 = i10;
        }
        i14 = i10;
        if (i20 < 1) {
            i20 = 1;
        }
        this.c = i20;
        if (i12 == 1) {
            int i26 = i5 - i18;
            java.lang.System.arraycopy(tArr, (i17 - i18) + 1, tArr, i26 + 1, i18);
            tArr[i26] = d[i14];
        } else {
            if (i12 == 0) {
                throw new java.lang.IllegalArgumentException("Comparison method violates its general contract!");
            }
            java.lang.System.arraycopy(d, 0, tArr, i5 - (i12 - 1), i12);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0069, code lost:
    
        r12 = r1;
        r13 = r2;
        r14 = r3;
        r15 = r4;
        r16 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x006f, code lost:
    
        r9 = r6;
        r6 = f(r7[r15], r8, r6, r13, 0, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x007b, code lost:
    
        if (r6 == 0) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x007d, code lost:
    
        java.lang.System.arraycopy(r8, r9, r7, r14, r6);
        r1 = r14 + r6;
        r2 = r9 + r6;
        r3 = r13 - r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0086, code lost:
    
        if (r3 > r10) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0095, code lost:
    
        r14 = r1;
        r9 = r2;
        r13 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0088, code lost:
    
        r6 = r2;
        r2 = r3;
        r4 = r15;
        r5 = r16;
        r9 = 1;
        r17 = r12;
        r12 = r1;
        r1 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0098, code lost:
    
        r5 = r14 + 1;
        r4 = r15 + 1;
        r7[r14] = r7[r15];
        r12 = r12 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00a2, code lost:
    
        if (r12 != 0) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00ac, code lost:
    
        r15 = r4;
        r1 = e(r8[r9], r7, r4, r12, 0, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00bb, code lost:
    
        if (r1 == 0) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00bd, code lost:
    
        java.lang.System.arraycopy(r7, r15, r7, r5, r1);
        r2 = r5 + r1;
        r4 = r15 + r1;
        r3 = r12 - r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00c6, code lost:
    
        if (r3 != 0) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00cf, code lost:
    
        r5 = r2;
        r12 = r3;
        r15 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00d4, code lost:
    
        r2 = r5 + 1;
        r6 = r9 + 1;
        r7[r5] = r8[r9];
        r13 = r13 - 1;
        r9 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00df, code lost:
    
        if (r13 != 1) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0105, code lost:
    
        r16 = r16 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0108, code lost:
    
        if (r6 < 7) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x010a, code lost:
    
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x010d, code lost:
    
        if (r1 < 7) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x010f, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0113, code lost:
    
        if ((r1 | r4) != false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0123, code lost:
    
        r14 = r2;
        r10 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0115, code lost:
    
        if (r16 >= 0) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0117, code lost:
    
        r16 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0111, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x010c, code lost:
    
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00e1, code lost:
    
        r1 = r12;
        r4 = r15;
        r5 = r16;
        r12 = r2;
        r2 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00c8, code lost:
    
        r12 = r2;
        r1 = r3;
        r6 = r9;
        r2 = r13;
        r5 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x005f, code lost:
    
        r9 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00d3, code lost:
    
        r5 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00a4, code lost:
    
        r6 = r9;
        r1 = r12;
        r2 = r13;
        r9 = 1;
        r12 = r5;
        r5 = r16;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0128 A[LOOP:1: B:12:0x0033->B:19:0x0128, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0069 A[EDGE_INSN: B:20:0x0069->B:21:0x0069 BREAK  A[LOOP:1: B:12:0x0033->B:19:0x0128], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void k(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12 = i2;
        T[] tArr = this.a;
        T[] d = d(i12);
        java.lang.System.arraycopy(tArr, i, d, 0, i12);
        int i13 = i + 1;
        int i14 = i3 + 1;
        tArr[i] = tArr[i3];
        int i15 = i4 - 1;
        if (i15 == 0) {
            java.lang.System.arraycopy(d, 0, tArr, i13, i12);
            return;
        }
        int i16 = 1;
        if (i12 == 1) {
            java.lang.System.arraycopy(tArr, i14, tArr, i13, i15);
            tArr[i13 + i15] = d[0];
            return;
        }
        java.util.Comparator<? super T> comparator = this.b;
        int i17 = this.c;
        int i18 = 0;
        loop0: while (true) {
            int i19 = 0;
            int i20 = 0;
            while (true) {
                if (comparator.compare(tArr[i14], d[i18]) < 0) {
                    i5 = i13 + 1;
                    int i21 = i14 + 1;
                    tArr[i13] = tArr[i14];
                    i20 += i16;
                    i15--;
                    if (i15 == 0) {
                        i14 = i21;
                        break loop0;
                    }
                    i13 = i5;
                    i14 = i21;
                    i19 = 0;
                    if ((i19 | i20) < i17) {
                        break;
                    }
                } else {
                    int i22 = i13 + 1;
                    int i23 = i18 + 1;
                    tArr[i13] = d[i18];
                    i19 += i16;
                    i12--;
                    if (i12 == i16) {
                        i5 = i22;
                        i18 = i23;
                        break loop0;
                    } else {
                        i13 = i22;
                        i18 = i23;
                        i20 = 0;
                        if ((i19 | i20) < i17) {
                        }
                    }
                }
            }
            i17 = i10 + 2;
            i13 = i11;
            i15 = i7;
            i12 = i8;
            i14 = i9;
            i16 = 1;
        }
        if (i17 < i6) {
            i17 = 1;
        }
        this.c = i17;
        if (i12 == i6) {
            java.lang.System.arraycopy(tArr, i14, tArr, i5, i15);
            tArr[i5 + i15] = d[i18];
        } else {
            if (i12 == 0) {
                throw new java.lang.IllegalArgumentException("Comparison method violates its general contract!");
            }
            java.lang.System.arraycopy(d, i18, tArr, i5, i12);
        }
    }

    public final void m(int i, int i2) {
        int[] iArr = this.g;
        int i3 = this.f;
        iArr[i3] = i;
        this.h[i3] = i2;
        this.f = i3 + 1;
    }
}
