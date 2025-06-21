package com.anythink.expressad.exoplayer.h.a;

/* loaded from: classes12.dex */
public final class a {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e = 4;
    public static final com.anythink.expressad.exoplayer.h.a.a f = new com.anythink.expressad.exoplayer.h.a.a(new long[0]);
    public final int g;
    public final long[] h;
    public final com.anythink.expressad.exoplayer.h.a.a.C0195a[] i;
    public final long j;
    public final long k;

    /* renamed from: com.anythink.expressad.exoplayer.h.a.a$a, reason: collision with other inner class name */
    public static final class C0195a {
        public final int a;
        public final android.net.Uri[] b;
        public final int[] c;
        public final long[] d;

        public C0195a() {
            this(-1, new int[0], new android.net.Uri[0], new long[0]);
        }

        private C0195a(int i, int[] iArr, android.net.Uri[] uriArr, long[] jArr) {
            com.anythink.expressad.exoplayer.k.a.a(iArr.length == uriArr.length);
            this.a = i;
            this.c = iArr;
            this.b = uriArr;
            this.d = jArr;
        }

        @androidx.annotation.CheckResult
        private static int[] a(int[] iArr, int i) {
            int length = iArr.length;
            int max = java.lang.Math.max(i, length);
            int[] copyOf = java.util.Arrays.copyOf(iArr, max);
            java.util.Arrays.fill(copyOf, length, max, 0);
            return copyOf;
        }

        @androidx.annotation.CheckResult
        private static long[] a(long[] jArr, int i) {
            int length = jArr.length;
            int max = java.lang.Math.max(i, length);
            long[] copyOf = java.util.Arrays.copyOf(jArr, max);
            java.util.Arrays.fill(copyOf, length, max, -9223372036854775807L);
            return copyOf;
        }

        private int c() {
            return a(-1);
        }

        public final int a(int i) {
            int i2;
            int i3 = i + 1;
            while (true) {
                int[] iArr = this.c;
                if (i3 >= iArr.length || (i2 = iArr[i3]) == 0 || i2 == 1) {
                    break;
                }
                i3++;
            }
            return i3;
        }

        @androidx.annotation.CheckResult
        public final com.anythink.expressad.exoplayer.h.a.a.C0195a a(int i, int i2) {
            int i3 = this.a;
            com.anythink.expressad.exoplayer.k.a.a(i3 == -1 || i2 < i3);
            int[] a = a(this.c, i2 + 1);
            int i4 = a[i2];
            com.anythink.expressad.exoplayer.k.a.a(i4 == 0 || i4 == 1 || i4 == i);
            long[] jArr = this.d;
            if (jArr.length != a.length) {
                jArr = a(jArr, a.length);
            }
            android.net.Uri[] uriArr = this.b;
            if (uriArr.length != a.length) {
                uriArr = (android.net.Uri[]) java.util.Arrays.copyOf(uriArr, a.length);
            }
            a[i2] = i;
            return new com.anythink.expressad.exoplayer.h.a.a.C0195a(this.a, a, uriArr, jArr);
        }

        @androidx.annotation.CheckResult
        public final com.anythink.expressad.exoplayer.h.a.a.C0195a a(android.net.Uri uri, int i) {
            int i2 = this.a;
            com.anythink.expressad.exoplayer.k.a.a(i2 == -1 || i < i2);
            int[] a = a(this.c, i + 1);
            com.anythink.expressad.exoplayer.k.a.a(a[i] == 0);
            long[] jArr = this.d;
            if (jArr.length != a.length) {
                jArr = a(jArr, a.length);
            }
            android.net.Uri[] uriArr = (android.net.Uri[]) java.util.Arrays.copyOf(this.b, a.length);
            uriArr[i] = uri;
            a[i] = 1;
            return new com.anythink.expressad.exoplayer.h.a.a.C0195a(this.a, a, uriArr, jArr);
        }

        @androidx.annotation.CheckResult
        public final com.anythink.expressad.exoplayer.h.a.a.C0195a a(long[] jArr) {
            com.anythink.expressad.exoplayer.k.a.a(this.a == -1 || jArr.length <= this.b.length);
            int length = jArr.length;
            android.net.Uri[] uriArr = this.b;
            if (length < uriArr.length) {
                jArr = a(jArr, uriArr.length);
            }
            return new com.anythink.expressad.exoplayer.h.a.a.C0195a(this.a, this.c, this.b, jArr);
        }

        public final boolean a() {
            return this.a == -1 || a(-1) < this.a;
        }

        @androidx.annotation.CheckResult
        public final com.anythink.expressad.exoplayer.h.a.a.C0195a b() {
            if (this.a == -1) {
                return new com.anythink.expressad.exoplayer.h.a.a.C0195a(0, new int[0], new android.net.Uri[0], new long[0]);
            }
            int[] iArr = this.c;
            int length = iArr.length;
            int[] copyOf = java.util.Arrays.copyOf(iArr, length);
            for (int i = 0; i < length; i++) {
                int i2 = copyOf[i];
                if (i2 == 1 || i2 == 0) {
                    copyOf[i] = 2;
                }
            }
            return new com.anythink.expressad.exoplayer.h.a.a.C0195a(length, copyOf, this.b, this.d);
        }

        @androidx.annotation.CheckResult
        public final com.anythink.expressad.exoplayer.h.a.a.C0195a b(int i) {
            com.anythink.expressad.exoplayer.k.a.a(this.a == -1 && this.c.length <= i);
            return new com.anythink.expressad.exoplayer.h.a.a.C0195a(i, a(this.c, i), (android.net.Uri[]) java.util.Arrays.copyOf(this.b, i), a(this.d, i));
        }
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface b {
    }

    private a(long... jArr) {
        this.g = 0;
        this.h = java.util.Arrays.copyOf(jArr, 0);
        this.i = new com.anythink.expressad.exoplayer.h.a.a.C0195a[0];
        this.j = 0L;
        this.k = -9223372036854775807L;
    }

    private a(long[] jArr, com.anythink.expressad.exoplayer.h.a.a.C0195a[] c0195aArr, long j, long j2) {
        this.g = c0195aArr.length;
        this.h = jArr;
        this.i = c0195aArr;
        this.j = j;
        this.k = j2;
    }

    private int a(long j) {
        int length = this.h.length - 1;
        while (length >= 0) {
            long j2 = this.h[length];
            if (j2 != Long.MIN_VALUE && j2 <= j) {
                break;
            }
            length--;
        }
        if (length < 0 || !this.i[length].a()) {
            return -1;
        }
        return length;
    }

    @androidx.annotation.CheckResult
    private com.anythink.expressad.exoplayer.h.a.a a(int i) {
        com.anythink.expressad.exoplayer.h.a.a.C0195a[] c0195aArr = this.i;
        com.anythink.expressad.exoplayer.h.a.a.C0195a[] c0195aArr2 = (com.anythink.expressad.exoplayer.h.a.a.C0195a[]) java.util.Arrays.copyOf(c0195aArr, c0195aArr.length);
        c0195aArr2[i] = c0195aArr2[i].b();
        return new com.anythink.expressad.exoplayer.h.a.a(this.h, c0195aArr2, this.j, this.k);
    }

    @androidx.annotation.CheckResult
    private com.anythink.expressad.exoplayer.h.a.a a(int i, int i2) {
        com.anythink.expressad.exoplayer.k.a.a(i2 > 0);
        com.anythink.expressad.exoplayer.h.a.a.C0195a[] c0195aArr = this.i;
        if (c0195aArr[i].a == i2) {
            return this;
        }
        com.anythink.expressad.exoplayer.h.a.a.C0195a[] c0195aArr2 = (com.anythink.expressad.exoplayer.h.a.a.C0195a[]) java.util.Arrays.copyOf(c0195aArr, c0195aArr.length);
        c0195aArr2[i] = this.i[i].b(i2);
        return new com.anythink.expressad.exoplayer.h.a.a(this.h, c0195aArr2, this.j, this.k);
    }

    @androidx.annotation.CheckResult
    private com.anythink.expressad.exoplayer.h.a.a a(int i, int i2, android.net.Uri uri) {
        com.anythink.expressad.exoplayer.h.a.a.C0195a[] c0195aArr = this.i;
        com.anythink.expressad.exoplayer.h.a.a.C0195a[] c0195aArr2 = (com.anythink.expressad.exoplayer.h.a.a.C0195a[]) java.util.Arrays.copyOf(c0195aArr, c0195aArr.length);
        c0195aArr2[i] = c0195aArr2[i].a(uri, i2);
        return new com.anythink.expressad.exoplayer.h.a.a(this.h, c0195aArr2, this.j, this.k);
    }

    private int b(long j) {
        int i = 0;
        while (true) {
            long[] jArr = this.h;
            if (i >= jArr.length) {
                break;
            }
            long j2 = jArr[i];
            if (j2 == Long.MIN_VALUE || (j < j2 && this.i[i].a())) {
                break;
            }
            i++;
        }
        if (i < this.h.length) {
            return i;
        }
        return -1;
    }

    @androidx.annotation.CheckResult
    private com.anythink.expressad.exoplayer.h.a.a b(int i, int i2) {
        com.anythink.expressad.exoplayer.h.a.a.C0195a[] c0195aArr = this.i;
        com.anythink.expressad.exoplayer.h.a.a.C0195a[] c0195aArr2 = (com.anythink.expressad.exoplayer.h.a.a.C0195a[]) java.util.Arrays.copyOf(c0195aArr, c0195aArr.length);
        c0195aArr2[i] = c0195aArr2[i].a(3, i2);
        return new com.anythink.expressad.exoplayer.h.a.a(this.h, c0195aArr2, this.j, this.k);
    }

    @androidx.annotation.CheckResult
    private com.anythink.expressad.exoplayer.h.a.a c(int i, int i2) {
        com.anythink.expressad.exoplayer.h.a.a.C0195a[] c0195aArr = this.i;
        com.anythink.expressad.exoplayer.h.a.a.C0195a[] c0195aArr2 = (com.anythink.expressad.exoplayer.h.a.a.C0195a[]) java.util.Arrays.copyOf(c0195aArr, c0195aArr.length);
        c0195aArr2[i] = c0195aArr2[i].a(2, i2);
        return new com.anythink.expressad.exoplayer.h.a.a(this.h, c0195aArr2, this.j, this.k);
    }

    @androidx.annotation.CheckResult
    private com.anythink.expressad.exoplayer.h.a.a c(long j) {
        return this.j == j ? this : new com.anythink.expressad.exoplayer.h.a.a(this.h, this.i, j, this.k);
    }

    @androidx.annotation.CheckResult
    private com.anythink.expressad.exoplayer.h.a.a d(int i, int i2) {
        com.anythink.expressad.exoplayer.h.a.a.C0195a[] c0195aArr = this.i;
        com.anythink.expressad.exoplayer.h.a.a.C0195a[] c0195aArr2 = (com.anythink.expressad.exoplayer.h.a.a.C0195a[]) java.util.Arrays.copyOf(c0195aArr, c0195aArr.length);
        c0195aArr2[i] = c0195aArr2[i].a(4, i2);
        return new com.anythink.expressad.exoplayer.h.a.a(this.h, c0195aArr2, this.j, this.k);
    }

    @androidx.annotation.CheckResult
    private com.anythink.expressad.exoplayer.h.a.a d(long j) {
        return this.k == j ? this : new com.anythink.expressad.exoplayer.h.a.a(this.h, this.i, this.j, j);
    }

    @androidx.annotation.CheckResult
    public final com.anythink.expressad.exoplayer.h.a.a a(long[][] jArr) {
        com.anythink.expressad.exoplayer.h.a.a.C0195a[] c0195aArr = this.i;
        com.anythink.expressad.exoplayer.h.a.a.C0195a[] c0195aArr2 = (com.anythink.expressad.exoplayer.h.a.a.C0195a[]) java.util.Arrays.copyOf(c0195aArr, c0195aArr.length);
        for (int i = 0; i < this.g; i++) {
            c0195aArr2[i] = c0195aArr2[i].a(jArr[i]);
        }
        return new com.anythink.expressad.exoplayer.h.a.a(this.h, c0195aArr2, this.j, this.k);
    }
}
