package com.badlogic.gdx.utils;

/* loaded from: classes12.dex */
class ComparableTimSort {
    public java.lang.Object[] a;
    public int d;
    public int b = 7;
    public int e = 0;
    public java.lang.Object[] c = new java.lang.Object[256];
    public final int[] f = new int[40];
    public final int[] g = new int[40];

    public static void a(java.lang.Object[] objArr, int i, int i2, int i3) {
        if (i3 == i) {
            i3++;
        }
        while (i3 < i2) {
            java.lang.Comparable comparable = (java.lang.Comparable) objArr[i3];
            int i4 = i;
            int i5 = i3;
            while (i4 < i5) {
                int i6 = (i4 + i5) >>> 1;
                if (comparable.compareTo(objArr[i6]) < 0) {
                    i5 = i6;
                } else {
                    i4 = i6 + 1;
                }
            }
            int i7 = i3 - i4;
            if (i7 != 1) {
                if (i7 != 2) {
                    java.lang.System.arraycopy(objArr, i4, objArr, i4 + 1, i7);
                    objArr[i4] = comparable;
                    i3++;
                } else {
                    objArr[i4 + 2] = objArr[i4 + 1];
                }
            }
            objArr[i4 + 1] = objArr[i4];
            objArr[i4] = comparable;
            i3++;
        }
    }

    public static int b(java.lang.Object[] objArr, int i, int i2) {
        int i3 = i + 1;
        if (i3 == i2) {
            return 1;
        }
        int i4 = i3 + 1;
        if (((java.lang.Comparable) objArr[i3]).compareTo(objArr[i]) < 0) {
            while (i4 < i2 && ((java.lang.Comparable) objArr[i4]).compareTo(objArr[i4 - 1]) < 0) {
                i4++;
            }
            o(objArr, i, i4);
        } else {
            while (i4 < i2 && ((java.lang.Comparable) objArr[i4]).compareTo(objArr[i4 - 1]) >= 0) {
                i4++;
            }
        }
        return i4 - i;
    }

    public static int e(java.lang.Comparable<java.lang.Object> comparable, java.lang.Object[] objArr, int i, int i2, int i3) {
        int i4;
        int i5;
        int i6 = i + i3;
        if (comparable.compareTo(objArr[i6]) > 0) {
            int i7 = i2 - i3;
            int i8 = 0;
            int i9 = 1;
            while (i9 < i7 && comparable.compareTo(objArr[i6 + i9]) > 0) {
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
            while (i14 < i12 && comparable.compareTo(objArr[i6 - i14]) <= 0) {
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
            if (comparable.compareTo(objArr[i + i20]) > 0) {
                i19 = i20 + 1;
            } else {
                i5 = i20;
            }
        }
        return i5;
    }

    public static int f(java.lang.Comparable<java.lang.Object> comparable, java.lang.Object[] objArr, int i, int i2, int i3) {
        int i4;
        int i5;
        int i6 = i + i3;
        if (comparable.compareTo(objArr[i6]) < 0) {
            int i7 = i3 + 1;
            int i8 = 0;
            int i9 = 1;
            while (i9 < i7 && comparable.compareTo(objArr[i6 - i9]) < 0) {
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
            while (i14 < i12 && comparable.compareTo(objArr[i6 + i14]) >= 0) {
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
            if (comparable.compareTo(objArr[i + i19]) < 0) {
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

    public void c(java.lang.Object[] objArr, int i, int i2) {
        this.e = 0;
        n(objArr.length, i, i2);
        int i3 = i2 - i;
        if (i3 < 2) {
            return;
        }
        if (i3 < 32) {
            a(objArr, i, i2, b(objArr, i, i2) + i);
            return;
        }
        this.a = objArr;
        this.d = 0;
        int l = l(i3);
        do {
            int b = b(objArr, i, i2);
            if (b < l) {
                int i4 = i3 <= l ? i3 : l;
                a(objArr, i, i + i4, b + i);
                b = i4;
            }
            m(i, b);
            h();
            i += b;
            i3 -= b;
        } while (i3 != 0);
        i();
        this.a = null;
        java.lang.Object[] objArr2 = this.c;
        int i5 = this.d;
        for (int i6 = 0; i6 < i5; i6++) {
            objArr2[i6] = null;
        }
    }

    public final java.lang.Object[] d(int i) {
        this.d = java.lang.Math.max(this.d, i);
        if (this.c.length < i) {
            int i2 = (i >> 1) | i;
            int i3 = i2 | (i2 >> 2);
            int i4 = i3 | (i3 >> 4);
            int i5 = i4 | (i4 >> 8);
            int i6 = (i5 | (i5 >> 16)) + 1;
            if (i6 >= 0) {
                i = java.lang.Math.min(i6, this.a.length >>> 1);
            }
            this.c = new java.lang.Object[i];
        }
        return this.c;
    }

    public final void g(int i) {
        int[] iArr = this.f;
        int i2 = iArr[i];
        int[] iArr2 = this.g;
        int i3 = iArr2[i];
        int i4 = i + 1;
        int i5 = iArr[i4];
        int i6 = iArr2[i4];
        iArr2[i] = i3 + i6;
        int i7 = this.e;
        if (i == i7 - 3) {
            int i8 = i + 2;
            iArr[i4] = iArr[i8];
            iArr2[i4] = iArr2[i8];
        }
        this.e = i7 - 1;
        java.lang.Object[] objArr = this.a;
        int f = f((java.lang.Comparable) objArr[i5], objArr, i2, i3, 0);
        int i9 = i2 + f;
        int i10 = i3 - f;
        if (i10 == 0) {
            return;
        }
        java.lang.Object[] objArr2 = this.a;
        int e = e((java.lang.Comparable) objArr2[(i9 + i10) - 1], objArr2, i5, i6, i6 - 1);
        if (e == 0) {
            return;
        }
        if (i10 <= e) {
            k(i9, i10, i5, e);
        } else {
            j(i9, i10, i5, e);
        }
    }

    public final void h() {
        while (true) {
            int i = this.e;
            if (i <= 1) {
                return;
            }
            int i2 = i - 2;
            if (i2 > 0) {
                int[] iArr = this.g;
                int i3 = iArr[i2 - 1];
                int i4 = iArr[i2];
                int i5 = iArr[i2 + 1];
                if (i3 <= i4 + i5) {
                    if (i3 < i5) {
                        i2--;
                    }
                    g(i2);
                }
            }
            int[] iArr2 = this.g;
            if (iArr2[i2] > iArr2[i2 + 1]) {
                return;
            } else {
                g(i2);
            }
        }
    }

    public final void i() {
        while (true) {
            int i = this.e;
            if (i <= 1) {
                return;
            }
            int i2 = i - 2;
            if (i2 > 0) {
                int[] iArr = this.g;
                if (iArr[i2 - 1] < iArr[i2 + 1]) {
                    i2--;
                }
            }
            g(i2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x006e, code lost:
    
        r3 = r13 - f((java.lang.Comparable) r1[r5], r0, r12, r13, r13 - 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x007a, code lost:
    
        if (r3 == 0) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x007c, code lost:
    
        r6 = r6 - r3;
        r7 = r7 - r3;
        r13 = r13 - r3;
        java.lang.System.arraycopy(r0, r7 + 1, r0, r6 + 1, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0086, code lost:
    
        if (r13 != 0) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0088, code lost:
    
        r3 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x008a, code lost:
    
        r8 = r6 - 1;
        r9 = r5 - 1;
        r0[r6] = r1[r5];
        r15 = r15 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0094, code lost:
    
        if (r15 != 1) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0097, code lost:
    
        r5 = r15 - e((java.lang.Comparable) r0[r7], r1, 0, r15, r15 - 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00a3, code lost:
    
        if (r5 == 0) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00a5, code lost:
    
        r6 = r8 - r5;
        r8 = r9 - r5;
        r15 = r15 - r5;
        java.lang.System.arraycopy(r1, r8 + 1, r0, r6 + 1, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00b1, code lost:
    
        if (r15 > 1) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00b8, code lost:
    
        r9 = r6 - 1;
        r10 = r7 - 1;
        r0[r6] = r0[r7];
        r13 = r13 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00c2, code lost:
    
        if (r13 != 0) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00ec, code lost:
    
        r14 = r14 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00ef, code lost:
    
        if (r3 < 7) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00f1, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00f4, code lost:
    
        if (r5 < 7) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00f6, code lost:
    
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00fa, code lost:
    
        if ((r3 | r5) != false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0106, code lost:
    
        r5 = r8;
        r6 = r9;
        r7 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00fc, code lost:
    
        if (r14 >= 0) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00fe, code lost:
    
        r14 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00f8, code lost:
    
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00f3, code lost:
    
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00c4, code lost:
    
        r5 = r8;
        r3 = r9;
        r7 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00b3, code lost:
    
        r3 = r6;
        r5 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00b6, code lost:
    
        r6 = r8;
        r8 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0063, code lost:
    
        r3 = r8;
        r5 = r9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void j(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        java.lang.Object[] objArr = this.a;
        java.lang.Object[] d = d(i4);
        java.lang.System.arraycopy(objArr, i3, d, 0, i4);
        int i9 = (i + i2) - 1;
        int i10 = i4 - 1;
        int i11 = (i3 + i4) - 1;
        int i12 = i11 - 1;
        int i13 = i9 - 1;
        objArr[i11] = objArr[i9];
        int i14 = i2 - 1;
        if (i14 == 0) {
            java.lang.System.arraycopy(d, 0, objArr, i12 - i10, i4);
            return;
        }
        if (i4 == 1) {
            int i15 = i12 - i14;
            java.lang.System.arraycopy(objArr, (i13 - i14) + 1, objArr, i15 + 1, i14);
            objArr[i15] = d[i10];
            return;
        }
        int i16 = this.b;
        loop0: while (true) {
            int i17 = 0;
            int i18 = 0;
            while (true) {
                if (((java.lang.Comparable) d[i10]).compareTo(objArr[i13]) < 0) {
                    i5 = i12 - 1;
                    int i19 = i13 - 1;
                    objArr[i12] = objArr[i13];
                    i18++;
                    i14--;
                    if (i14 == 0) {
                        i13 = i19;
                        break loop0;
                    } else {
                        i12 = i5;
                        i13 = i19;
                        i17 = 0;
                    }
                } else {
                    int i20 = i12 - 1;
                    int i21 = i10 - 1;
                    objArr[i12] = d[i10];
                    i17++;
                    i4--;
                    if (i4 == 1) {
                        break loop0;
                    }
                    i12 = i20;
                    i10 = i21;
                    i18 = 0;
                }
                if ((i18 | i17) >= i16) {
                    break;
                }
            }
            i16 += 2;
            i10 = i6;
            i12 = i7;
            i13 = i8;
        }
        if (i16 < 1) {
            i16 = 1;
        }
        this.b = i16;
        if (i4 == 1) {
            int i22 = i5 - i14;
            java.lang.System.arraycopy(objArr, (i13 - i14) + 1, objArr, i22 + 1, i14);
            objArr[i22] = d[i10];
        } else {
            if (i4 == 0) {
                throw new java.lang.IllegalArgumentException("Comparison method violates its general contract!");
            }
            java.lang.System.arraycopy(d, 0, objArr, i5 - (i4 - 1), i4);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0062, code lost:
    
        r6 = f((java.lang.Comparable) r0[r4], r1, r5, r13, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x006a, code lost:
    
        if (r6 == 0) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x006c, code lost:
    
        java.lang.System.arraycopy(r1, r5, r0, r3, r6);
        r3 = r3 + r6;
        r5 = r5 + r6;
        r13 = r13 - r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0072, code lost:
    
        if (r13 > 1) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0074, code lost:
    
        r6 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0076, code lost:
    
        r7 = r3 + 1;
        r8 = r4 + 1;
        r0[r3] = r0[r4];
        r15 = r15 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0080, code lost:
    
        if (r15 != 0) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0084, code lost:
    
        r3 = e((java.lang.Comparable) r1[r5], r0, r8, r15, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x008c, code lost:
    
        if (r3 == 0) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x008e, code lost:
    
        java.lang.System.arraycopy(r0, r8, r0, r7, r3);
        r4 = r7 + r3;
        r7 = r8 + r3;
        r15 = r15 - r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0096, code lost:
    
        if (r15 != 0) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x009b, code lost:
    
        r7 = r4;
        r4 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00a0, code lost:
    
        r8 = r7 + 1;
        r9 = r5 + 1;
        r0[r7] = r1[r5];
        r13 = r13 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00aa, code lost:
    
        if (r13 != 1) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00cc, code lost:
    
        r14 = r14 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00cf, code lost:
    
        if (r6 < 7) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00d1, code lost:
    
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00d4, code lost:
    
        if (r3 < 7) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00d6, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00da, code lost:
    
        if ((r3 | r6) != false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00e5, code lost:
    
        r3 = r8;
        r5 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00dc, code lost:
    
        if (r14 >= 0) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00de, code lost:
    
        r14 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00d8, code lost:
    
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00d3, code lost:
    
        r6 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00ac, code lost:
    
        r6 = r8;
        r5 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0098, code lost:
    
        r6 = r4;
        r4 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x009f, code lost:
    
        r4 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0082, code lost:
    
        r6 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0044, code lost:
    
        r4 = r8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void k(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        java.lang.Object[] objArr = this.a;
        java.lang.Object[] d = d(i2);
        java.lang.System.arraycopy(objArr, i, d, 0, i2);
        int i8 = i + 1;
        int i9 = i3 + 1;
        objArr[i] = objArr[i3];
        int i10 = i4 - 1;
        if (i10 == 0) {
            java.lang.System.arraycopy(d, 0, objArr, i8, i2);
            return;
        }
        if (i2 == 1) {
            java.lang.System.arraycopy(objArr, i9, objArr, i8, i10);
            objArr[i8 + i10] = d[0];
            return;
        }
        int i11 = this.b;
        int i12 = 0;
        loop0: while (true) {
            int i13 = 0;
            int i14 = 0;
            while (true) {
                if (((java.lang.Comparable) objArr[i9]).compareTo(d[i12]) < 0) {
                    i5 = i8 + 1;
                    int i15 = i9 + 1;
                    objArr[i8] = objArr[i9];
                    i14++;
                    i10--;
                    if (i10 == 0) {
                        break loop0;
                    }
                    i8 = i5;
                    i9 = i15;
                    i13 = 0;
                } else {
                    int i16 = i8 + 1;
                    int i17 = i12 + 1;
                    objArr[i8] = d[i12];
                    i13++;
                    i2--;
                    if (i2 == 1) {
                        i5 = i16;
                        i12 = i17;
                        break loop0;
                    } else {
                        i8 = i16;
                        i12 = i17;
                        i14 = 0;
                    }
                }
                if ((i13 | i14) >= i11) {
                    break;
                }
            }
            i11 += 2;
            i8 = i6;
            i12 = i7;
        }
        if (i11 < 1) {
            i11 = 1;
        }
        this.b = i11;
        if (i2 == 1) {
            java.lang.System.arraycopy(objArr, i9, objArr, i5, i10);
            objArr[i5 + i10] = d[i12];
        } else {
            if (i2 == 0) {
                throw new java.lang.IllegalArgumentException("Comparison method violates its general contract!");
            }
            java.lang.System.arraycopy(d, i12, objArr, i5, i2);
        }
    }

    public final void m(int i, int i2) {
        int[] iArr = this.f;
        int i3 = this.e;
        iArr[i3] = i;
        this.g[i3] = i2;
        this.e = i3 + 1;
    }
}
