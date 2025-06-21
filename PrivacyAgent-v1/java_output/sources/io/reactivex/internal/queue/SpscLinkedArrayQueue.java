package io.reactivex.internal.queue;

/* loaded from: classes13.dex */
public final class SpscLinkedArrayQueue<T> implements io.reactivex.internal.fuseable.SimplePlainQueue<T> {
    public static final int A = java.lang.Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    public static final java.lang.Object B = new java.lang.Object();
    public int t;
    public long u;
    public final int v;
    public java.util.concurrent.atomic.AtomicReferenceArray<java.lang.Object> w;
    public final int x;
    public java.util.concurrent.atomic.AtomicReferenceArray<java.lang.Object> y;
    public final java.util.concurrent.atomic.AtomicLong n = new java.util.concurrent.atomic.AtomicLong();
    public final java.util.concurrent.atomic.AtomicLong z = new java.util.concurrent.atomic.AtomicLong();

    public SpscLinkedArrayQueue(int i) {
        int roundToPowerOfTwo = io.reactivex.internal.util.Pow2.roundToPowerOfTwo(java.lang.Math.max(8, i));
        int i2 = roundToPowerOfTwo - 1;
        java.util.concurrent.atomic.AtomicReferenceArray<java.lang.Object> atomicReferenceArray = new java.util.concurrent.atomic.AtomicReferenceArray<>(roundToPowerOfTwo + 1);
        this.w = atomicReferenceArray;
        this.v = i2;
        a(roundToPowerOfTwo);
        this.y = atomicReferenceArray;
        this.x = i2;
        this.u = i2 - 1;
        p(0L);
    }

    public static int b(int i) {
        return i;
    }

    public static int c(long j, int i) {
        return b(((int) j) & i);
    }

    public static <E> java.lang.Object g(java.util.concurrent.atomic.AtomicReferenceArray<java.lang.Object> atomicReferenceArray, int i) {
        return atomicReferenceArray.get(i);
    }

    public static void n(java.util.concurrent.atomic.AtomicReferenceArray<java.lang.Object> atomicReferenceArray, int i, java.lang.Object obj) {
        atomicReferenceArray.lazySet(i, obj);
    }

    public final void a(int i) {
        this.t = java.lang.Math.min(i / 4, A);
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    public final long d() {
        return this.z.get();
    }

    public final long e() {
        return this.n.get();
    }

    public final long f() {
        return this.z.get();
    }

    public final java.util.concurrent.atomic.AtomicReferenceArray<java.lang.Object> h(java.util.concurrent.atomic.AtomicReferenceArray<java.lang.Object> atomicReferenceArray, int i) {
        int b = b(i);
        java.util.concurrent.atomic.AtomicReferenceArray<java.lang.Object> atomicReferenceArray2 = (java.util.concurrent.atomic.AtomicReferenceArray) g(atomicReferenceArray, b);
        n(atomicReferenceArray, b, null);
        return atomicReferenceArray2;
    }

    public final long i() {
        return this.n.get();
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean isEmpty() {
        return i() == f();
    }

    public final T j(java.util.concurrent.atomic.AtomicReferenceArray<java.lang.Object> atomicReferenceArray, long j, int i) {
        this.y = atomicReferenceArray;
        return (T) g(atomicReferenceArray, c(j, i));
    }

    public final T k(java.util.concurrent.atomic.AtomicReferenceArray<java.lang.Object> atomicReferenceArray, long j, int i) {
        this.y = atomicReferenceArray;
        int c = c(j, i);
        T t = (T) g(atomicReferenceArray, c);
        if (t != null) {
            n(atomicReferenceArray, c, null);
            m(j + 1);
        }
        return t;
    }

    public final void l(java.util.concurrent.atomic.AtomicReferenceArray<java.lang.Object> atomicReferenceArray, long j, int i, T t, long j2) {
        java.util.concurrent.atomic.AtomicReferenceArray<java.lang.Object> atomicReferenceArray2 = new java.util.concurrent.atomic.AtomicReferenceArray<>(atomicReferenceArray.length());
        this.w = atomicReferenceArray2;
        this.u = (j2 + j) - 1;
        n(atomicReferenceArray2, i, t);
        o(atomicReferenceArray, atomicReferenceArray2);
        n(atomicReferenceArray, i, B);
        p(j + 1);
    }

    public final void m(long j) {
        this.z.lazySet(j);
    }

    public final void o(java.util.concurrent.atomic.AtomicReferenceArray<java.lang.Object> atomicReferenceArray, java.util.concurrent.atomic.AtomicReferenceArray<java.lang.Object> atomicReferenceArray2) {
        n(atomicReferenceArray, b(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean offer(T t) {
        if (t == null) {
            throw new java.lang.NullPointerException("Null is not a valid element");
        }
        java.util.concurrent.atomic.AtomicReferenceArray<java.lang.Object> atomicReferenceArray = this.w;
        long e = e();
        int i = this.v;
        int c = c(e, i);
        if (e < this.u) {
            return q(atomicReferenceArray, t, e, c);
        }
        long j = this.t + e;
        if (g(atomicReferenceArray, c(j, i)) == null) {
            this.u = j - 1;
            return q(atomicReferenceArray, t, e, c);
        }
        if (g(atomicReferenceArray, c(1 + e, i)) == null) {
            return q(atomicReferenceArray, t, e, c);
        }
        l(atomicReferenceArray, e, c, t, i);
        return true;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean offer(T t, T t2) {
        java.util.concurrent.atomic.AtomicReferenceArray<java.lang.Object> atomicReferenceArray = this.w;
        long i = i();
        int i2 = this.v;
        long j = 2 + i;
        if (g(atomicReferenceArray, c(j, i2)) == null) {
            int c = c(i, i2);
            n(atomicReferenceArray, c + 1, t2);
            n(atomicReferenceArray, c, t);
            p(j);
            return true;
        }
        java.util.concurrent.atomic.AtomicReferenceArray<java.lang.Object> atomicReferenceArray2 = new java.util.concurrent.atomic.AtomicReferenceArray<>(atomicReferenceArray.length());
        this.w = atomicReferenceArray2;
        int c2 = c(i, i2);
        n(atomicReferenceArray2, c2 + 1, t2);
        n(atomicReferenceArray2, c2, t);
        o(atomicReferenceArray, atomicReferenceArray2);
        n(atomicReferenceArray, c2, B);
        p(j);
        return true;
    }

    public final void p(long j) {
        this.n.lazySet(j);
    }

    public T peek() {
        java.util.concurrent.atomic.AtomicReferenceArray<java.lang.Object> atomicReferenceArray = this.y;
        long d = d();
        int i = this.x;
        T t = (T) g(atomicReferenceArray, c(d, i));
        return t == B ? j(h(atomicReferenceArray, i + 1), d, i) : t;
    }

    @Override // io.reactivex.internal.fuseable.SimplePlainQueue, io.reactivex.internal.fuseable.SimpleQueue
    @io.reactivex.annotations.Nullable
    public T poll() {
        java.util.concurrent.atomic.AtomicReferenceArray<java.lang.Object> atomicReferenceArray = this.y;
        long d = d();
        int i = this.x;
        int c = c(d, i);
        T t = (T) g(atomicReferenceArray, c);
        boolean z = t == B;
        if (t == null || z) {
            if (z) {
                return k(h(atomicReferenceArray, i + 1), d, i);
            }
            return null;
        }
        n(atomicReferenceArray, c, null);
        m(d + 1);
        return t;
    }

    public final boolean q(java.util.concurrent.atomic.AtomicReferenceArray<java.lang.Object> atomicReferenceArray, T t, long j, int i) {
        n(atomicReferenceArray, i, t);
        p(j + 1);
        return true;
    }

    public int size() {
        long f = f();
        while (true) {
            long i = i();
            long f2 = f();
            if (f == f2) {
                return (int) (i - f2);
            }
            f = f2;
        }
    }
}
