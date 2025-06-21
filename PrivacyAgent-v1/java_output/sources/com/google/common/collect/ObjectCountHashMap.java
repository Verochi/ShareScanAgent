package com.google.common.collect;

@com.google.common.annotations.GwtCompatible(emulated = true, serializable = true)
/* loaded from: classes22.dex */
class ObjectCountHashMap<K> {
    public transient java.lang.Object[] a;
    public transient int[] b;
    public transient int c;
    public transient int d;
    public transient int[] e;

    @com.google.common.annotations.VisibleForTesting
    public transient long[] f;
    public transient float g;
    public transient int h;

    public class MapEntry extends com.google.common.collect.Multisets.AbstractEntry<K> {

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public final K n;
        public int t;

        public MapEntry(int i) {
            this.n = (K) com.google.common.collect.ObjectCountHashMap.this.a[i];
            this.t = i;
        }

        @Override // com.google.common.collect.Multiset.Entry
        public int getCount() {
            i();
            int i = this.t;
            if (i == -1) {
                return 0;
            }
            return com.google.common.collect.ObjectCountHashMap.this.b[i];
        }

        @Override // com.google.common.collect.Multiset.Entry
        public K getElement() {
            return this.n;
        }

        public void i() {
            int i = this.t;
            if (i == -1 || i >= com.google.common.collect.ObjectCountHashMap.this.C() || !com.google.common.base.Objects.equal(this.n, com.google.common.collect.ObjectCountHashMap.this.a[this.t])) {
                this.t = com.google.common.collect.ObjectCountHashMap.this.m(this.n);
            }
        }
    }

    public ObjectCountHashMap() {
        n(3, 1.0f);
    }

    public ObjectCountHashMap(int i) {
        this(i, 1.0f);
    }

    public ObjectCountHashMap(int i, float f) {
        n(i, f);
    }

    public ObjectCountHashMap(com.google.common.collect.ObjectCountHashMap<? extends K> objectCountHashMap) {
        n(objectCountHashMap.C(), 1.0f);
        int e = objectCountHashMap.e();
        while (e != -1) {
            u(objectCountHashMap.i(e), objectCountHashMap.k(e));
            e = objectCountHashMap.s(e);
        }
    }

    public static long D(long j, int i) {
        return (j & (-4294967296L)) | (net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT & i);
    }

    public static <K> com.google.common.collect.ObjectCountHashMap<K> b() {
        return new com.google.common.collect.ObjectCountHashMap<>();
    }

    public static <K> com.google.common.collect.ObjectCountHashMap<K> c(int i) {
        return new com.google.common.collect.ObjectCountHashMap<>(i);
    }

    public static int h(long j) {
        return (int) (j >>> 32);
    }

    public static int j(long j) {
        return (int) j;
    }

    public static long[] q(int i) {
        long[] jArr = new long[i];
        java.util.Arrays.fill(jArr, -1L);
        return jArr;
    }

    public static int[] r(int i) {
        int[] iArr = new int[i];
        java.util.Arrays.fill(iArr, -1);
        return iArr;
    }

    public final void A(int i) {
        if (this.e.length >= 1073741824) {
            this.h = Integer.MAX_VALUE;
            return;
        }
        int i2 = ((int) (i * this.g)) + 1;
        int[] r = r(i);
        long[] jArr = this.f;
        int length = r.length - 1;
        for (int i3 = 0; i3 < this.c; i3++) {
            int h = h(jArr[i3]);
            int i4 = h & length;
            int i5 = r[i4];
            r[i4] = i3;
            jArr[i3] = (h << 32) | (i5 & net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT);
        }
        this.h = i2;
        this.e = r;
    }

    public void B(int i, int i2) {
        com.google.common.base.Preconditions.checkElementIndex(i, this.c);
        this.b[i] = i2;
    }

    public int C() {
        return this.c;
    }

    public void a() {
        this.d++;
        java.util.Arrays.fill(this.a, 0, this.c, (java.lang.Object) null);
        java.util.Arrays.fill(this.b, 0, this.c, 0);
        java.util.Arrays.fill(this.e, -1);
        java.util.Arrays.fill(this.f, -1L);
        this.c = 0;
    }

    public void d(int i) {
        if (i > this.f.length) {
            y(i);
        }
        if (i >= this.h) {
            A(java.lang.Math.max(2, java.lang.Integer.highestOneBit(i - 1) << 1));
        }
    }

    public int e() {
        return this.c == 0 ? -1 : 0;
    }

    public int f(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        int m = m(obj);
        if (m == -1) {
            return 0;
        }
        return this.b[m];
    }

    public com.google.common.collect.Multiset.Entry<K> g(int i) {
        com.google.common.base.Preconditions.checkElementIndex(i, this.c);
        return new com.google.common.collect.ObjectCountHashMap.MapEntry(i);
    }

    public K i(int i) {
        com.google.common.base.Preconditions.checkElementIndex(i, this.c);
        return (K) this.a[i];
    }

    public int k(int i) {
        com.google.common.base.Preconditions.checkElementIndex(i, this.c);
        return this.b[i];
    }

    public final int l() {
        return this.e.length - 1;
    }

    public int m(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        int d = com.google.common.collect.Hashing.d(obj);
        int i = this.e[l() & d];
        while (i != -1) {
            long j = this.f[i];
            if (h(j) == d && com.google.common.base.Objects.equal(obj, this.a[i])) {
                return i;
            }
            i = j(j);
        }
        return -1;
    }

    public void n(int i, float f) {
        com.google.common.base.Preconditions.checkArgument(i >= 0, "Initial capacity must be non-negative");
        com.google.common.base.Preconditions.checkArgument(f > 0.0f, "Illegal load factor");
        int a = com.google.common.collect.Hashing.a(i, f);
        this.e = r(a);
        this.g = f;
        this.a = new java.lang.Object[i];
        this.b = new int[i];
        this.f = q(i);
        this.h = java.lang.Math.max(1, (int) (a * f));
    }

    public void o(int i, @org.checkerframework.checker.nullness.compatqual.NullableDecl K k, int i2, int i3) {
        this.f[i] = (i3 << 32) | net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT;
        this.a[i] = k;
        this.b[i] = i2;
    }

    public void p(int i) {
        int C = C() - 1;
        if (i >= C) {
            this.a[i] = null;
            this.b[i] = 0;
            this.f[i] = -1;
            return;
        }
        java.lang.Object[] objArr = this.a;
        objArr[i] = objArr[C];
        int[] iArr = this.b;
        iArr[i] = iArr[C];
        objArr[C] = null;
        iArr[C] = 0;
        long[] jArr = this.f;
        long j = jArr[C];
        jArr[i] = j;
        jArr[C] = -1;
        int h = h(j) & l();
        int[] iArr2 = this.e;
        int i2 = iArr2[h];
        if (i2 == C) {
            iArr2[h] = i;
            return;
        }
        while (true) {
            long j2 = this.f[i2];
            int j3 = j(j2);
            if (j3 == C) {
                this.f[i2] = D(j2, i);
                return;
            }
            i2 = j3;
        }
    }

    public int s(int i) {
        int i2 = i + 1;
        if (i2 < this.c) {
            return i2;
        }
        return -1;
    }

    public int t(int i, int i2) {
        return i - 1;
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public int u(@org.checkerframework.checker.nullness.compatqual.NullableDecl K k, int i) {
        com.google.common.collect.CollectPreconditions.d(i, me.leolin.shortcutbadger.impl.NewHtcHomeBadger.COUNT);
        long[] jArr = this.f;
        java.lang.Object[] objArr = this.a;
        int[] iArr = this.b;
        int d = com.google.common.collect.Hashing.d(k);
        int l = l() & d;
        int i2 = this.c;
        int[] iArr2 = this.e;
        int i3 = iArr2[l];
        if (i3 == -1) {
            iArr2[l] = i2;
        } else {
            while (true) {
                long j = jArr[i3];
                if (h(j) == d && com.google.common.base.Objects.equal(k, objArr[i3])) {
                    int i4 = iArr[i3];
                    iArr[i3] = i;
                    return i4;
                }
                int j2 = j(j);
                if (j2 == -1) {
                    jArr[i3] = D(j, i2);
                    break;
                }
                i3 = j2;
            }
        }
        if (i2 == Integer.MAX_VALUE) {
            throw new java.lang.IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
        }
        int i5 = i2 + 1;
        z(i5);
        o(i2, k, i, d);
        this.c = i5;
        if (i2 >= this.h) {
            A(this.e.length * 2);
        }
        this.d++;
        return 0;
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public int v(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return w(obj, com.google.common.collect.Hashing.d(obj));
    }

    public final int w(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, int i) {
        int l = l() & i;
        int i2 = this.e[l];
        if (i2 == -1) {
            return 0;
        }
        int i3 = -1;
        while (true) {
            if (h(this.f[i2]) == i && com.google.common.base.Objects.equal(obj, this.a[i2])) {
                int i4 = this.b[i2];
                if (i3 == -1) {
                    this.e[l] = j(this.f[i2]);
                } else {
                    long[] jArr = this.f;
                    jArr[i3] = D(jArr[i3], j(jArr[i2]));
                }
                p(i2);
                this.c--;
                this.d++;
                return i4;
            }
            int j = j(this.f[i2]);
            if (j == -1) {
                return 0;
            }
            i3 = i2;
            i2 = j;
        }
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public int x(int i) {
        return w(this.a[i], h(this.f[i]));
    }

    public void y(int i) {
        this.a = java.util.Arrays.copyOf(this.a, i);
        this.b = java.util.Arrays.copyOf(this.b, i);
        long[] jArr = this.f;
        int length = jArr.length;
        long[] copyOf = java.util.Arrays.copyOf(jArr, i);
        if (i > length) {
            java.util.Arrays.fill(copyOf, length, i, -1L);
        }
        this.f = copyOf;
    }

    public final void z(int i) {
        int length = this.f.length;
        if (i > length) {
            int max = java.lang.Math.max(1, length >>> 1) + length;
            if (max < 0) {
                max = Integer.MAX_VALUE;
            }
            if (max != length) {
                y(max);
            }
        }
    }
}
