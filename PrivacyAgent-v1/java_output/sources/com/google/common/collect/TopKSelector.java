package com.google.common.collect;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
final class TopKSelector<T> {
    public final int a;
    public final java.util.Comparator<? super T> b;
    public final T[] c;
    public int d;

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public T e;

    public TopKSelector(java.util.Comparator<? super T> comparator, int i) {
        this.b = (java.util.Comparator) com.google.common.base.Preconditions.checkNotNull(comparator, "comparator");
        this.a = i;
        com.google.common.base.Preconditions.checkArgument(i >= 0, "k must be nonnegative, was %s", i);
        this.c = (T[]) new java.lang.Object[i * 2];
        this.d = 0;
        this.e = null;
    }

    public static <T> com.google.common.collect.TopKSelector<T> a(int i, java.util.Comparator<? super T> comparator) {
        return new com.google.common.collect.TopKSelector<>(comparator, i);
    }

    public void b(@org.checkerframework.checker.nullness.compatqual.NullableDecl T t) {
        int i = this.a;
        if (i == 0) {
            return;
        }
        int i2 = this.d;
        if (i2 == 0) {
            this.c[0] = t;
            this.e = t;
            this.d = 1;
            return;
        }
        if (i2 < i) {
            T[] tArr = this.c;
            this.d = i2 + 1;
            tArr[i2] = t;
            if (this.b.compare(t, this.e) > 0) {
                this.e = t;
                return;
            }
            return;
        }
        if (this.b.compare(t, this.e) < 0) {
            T[] tArr2 = this.c;
            int i3 = this.d;
            int i4 = i3 + 1;
            this.d = i4;
            tArr2[i3] = t;
            if (i4 == this.a * 2) {
                g();
            }
        }
    }

    public void c(java.util.Iterator<? extends T> it) {
        while (it.hasNext()) {
            b(it.next());
        }
    }

    public final int d(int i, int i2, int i3) {
        T[] tArr = this.c;
        T t = tArr[i3];
        tArr[i3] = tArr[i2];
        int i4 = i;
        while (i < i2) {
            if (this.b.compare(this.c[i], t) < 0) {
                e(i4, i);
                i4++;
            }
            i++;
        }
        T[] tArr2 = this.c;
        tArr2[i2] = tArr2[i4];
        tArr2[i4] = t;
        return i4;
    }

    public final void e(int i, int i2) {
        T[] tArr = this.c;
        T t = tArr[i];
        tArr[i] = tArr[i2];
        tArr[i2] = t;
    }

    public java.util.List<T> f() {
        java.util.Arrays.sort(this.c, 0, this.d, this.b);
        int i = this.d;
        int i2 = this.a;
        if (i > i2) {
            T[] tArr = this.c;
            java.util.Arrays.fill(tArr, i2, tArr.length, (java.lang.Object) null);
            int i3 = this.a;
            this.d = i3;
            this.e = this.c[i3 - 1];
        }
        return java.util.Collections.unmodifiableList(java.util.Arrays.asList(java.util.Arrays.copyOf(this.c, this.d)));
    }

    public final void g() {
        int i = (this.a * 2) - 1;
        int log2 = com.google.common.math.IntMath.log2(i + 0, java.math.RoundingMode.CEILING) * 3;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i2 >= i) {
                break;
            }
            int d = d(i2, i, ((i2 + i) + 1) >>> 1);
            int i5 = this.a;
            if (d <= i5) {
                if (d >= i5) {
                    break;
                }
                i2 = java.lang.Math.max(d, i2 + 1);
                i4 = d;
            } else {
                i = d - 1;
            }
            i3++;
            if (i3 >= log2) {
                java.util.Arrays.sort(this.c, i2, i, this.b);
                break;
            }
        }
        this.d = this.a;
        this.e = this.c[i4];
        while (true) {
            i4++;
            if (i4 >= this.a) {
                return;
            }
            if (this.b.compare(this.c[i4], this.e) > 0) {
                this.e = this.c[i4];
            }
        }
    }
}
