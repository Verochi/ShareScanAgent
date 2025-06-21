package com.google.android.exoplayer2.util;

/* loaded from: classes22.dex */
public final class TimedValueQueue<V> {
    public long[] a;
    public V[] b;
    public int c;
    public int d;

    public TimedValueQueue() {
        this(10);
    }

    public TimedValueQueue(int i) {
        this.a = new long[i];
        this.b = (V[]) d(i);
    }

    public static <V> V[] d(int i) {
        return (V[]) new java.lang.Object[i];
    }

    public final void a(long j, V v) {
        int i = this.c;
        int i2 = this.d;
        V[] vArr = this.b;
        int length = (i + i2) % vArr.length;
        this.a[length] = j;
        vArr[length] = v;
        this.d = i2 + 1;
    }

    public synchronized void add(long j, V v) {
        b(j);
        c();
        a(j, v);
    }

    public final void b(long j) {
        if (this.d > 0) {
            if (j <= this.a[((this.c + r0) - 1) % this.b.length]) {
                clear();
            }
        }
    }

    public final void c() {
        int length = this.b.length;
        if (this.d < length) {
            return;
        }
        int i = length * 2;
        long[] jArr = new long[i];
        V[] vArr = (V[]) d(i);
        int i2 = this.c;
        int i3 = length - i2;
        java.lang.System.arraycopy(this.a, i2, jArr, 0, i3);
        java.lang.System.arraycopy(this.b, this.c, vArr, 0, i3);
        int i4 = this.c;
        if (i4 > 0) {
            java.lang.System.arraycopy(this.a, 0, jArr, i3, i4);
            java.lang.System.arraycopy(this.b, 0, vArr, i3, this.c);
        }
        this.a = jArr;
        this.b = vArr;
        this.c = 0;
    }

    public synchronized void clear() {
        this.c = 0;
        this.d = 0;
        java.util.Arrays.fill(this.b, (java.lang.Object) null);
    }

    @androidx.annotation.Nullable
    public final V e(long j, boolean z) {
        V v = null;
        long j2 = Long.MAX_VALUE;
        while (this.d > 0) {
            long j3 = j - this.a[this.c];
            if (j3 < 0 && (z || (-j3) >= j2)) {
                break;
            }
            v = f();
            j2 = j3;
        }
        return v;
    }

    @androidx.annotation.Nullable
    public final V f() {
        com.google.android.exoplayer2.util.Assertions.checkState(this.d > 0);
        V[] vArr = this.b;
        int i = this.c;
        V v = vArr[i];
        vArr[i] = null;
        this.c = (i + 1) % vArr.length;
        this.d--;
        return v;
    }

    @androidx.annotation.Nullable
    public synchronized V poll(long j) {
        return e(j, false);
    }

    @androidx.annotation.Nullable
    public synchronized V pollFirst() {
        return this.d == 0 ? null : f();
    }

    @androidx.annotation.Nullable
    public synchronized V pollFloor(long j) {
        return e(j, true);
    }

    public synchronized int size() {
        return this.d;
    }
}
