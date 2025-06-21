package com.google.common.util.concurrent;

@com.google.common.annotations.Beta
@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
public abstract class Striped<L> {
    public static final com.google.common.base.Supplier<java.util.concurrent.locks.ReadWriteLock> a = new com.google.common.util.concurrent.Striped.AnonymousClass5();
    public static final com.google.common.base.Supplier<java.util.concurrent.locks.ReadWriteLock> b = new com.google.common.util.concurrent.Striped.AnonymousClass6();

    /* renamed from: com.google.common.util.concurrent.Striped$1, reason: invalid class name */
    public static class AnonymousClass1 implements com.google.common.base.Supplier<java.util.concurrent.locks.Lock> {
        @Override // com.google.common.base.Supplier
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public java.util.concurrent.locks.Lock get() {
            return new com.google.common.util.concurrent.Striped.PaddedLock();
        }
    }

    /* renamed from: com.google.common.util.concurrent.Striped$2, reason: invalid class name */
    public static class AnonymousClass2 implements com.google.common.base.Supplier<java.util.concurrent.locks.Lock> {
        @Override // com.google.common.base.Supplier
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public java.util.concurrent.locks.Lock get() {
            return new java.util.concurrent.locks.ReentrantLock(false);
        }
    }

    /* renamed from: com.google.common.util.concurrent.Striped$3, reason: invalid class name */
    public static class AnonymousClass3 implements com.google.common.base.Supplier<java.util.concurrent.Semaphore> {
        public final /* synthetic */ int n;

        public AnonymousClass3(int i) {
            this.n = i;
        }

        @Override // com.google.common.base.Supplier
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public java.util.concurrent.Semaphore get() {
            return new com.google.common.util.concurrent.Striped.PaddedSemaphore(this.n);
        }
    }

    /* renamed from: com.google.common.util.concurrent.Striped$4, reason: invalid class name */
    public static class AnonymousClass4 implements com.google.common.base.Supplier<java.util.concurrent.Semaphore> {
        public final /* synthetic */ int n;

        public AnonymousClass4(int i) {
            this.n = i;
        }

        @Override // com.google.common.base.Supplier
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public java.util.concurrent.Semaphore get() {
            return new java.util.concurrent.Semaphore(this.n, false);
        }
    }

    /* renamed from: com.google.common.util.concurrent.Striped$5, reason: invalid class name */
    public static class AnonymousClass5 implements com.google.common.base.Supplier<java.util.concurrent.locks.ReadWriteLock> {
        @Override // com.google.common.base.Supplier
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public java.util.concurrent.locks.ReadWriteLock get() {
            return new java.util.concurrent.locks.ReentrantReadWriteLock();
        }
    }

    /* renamed from: com.google.common.util.concurrent.Striped$6, reason: invalid class name */
    public static class AnonymousClass6 implements com.google.common.base.Supplier<java.util.concurrent.locks.ReadWriteLock> {
        @Override // com.google.common.base.Supplier
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public java.util.concurrent.locks.ReadWriteLock get() {
            return new com.google.common.util.concurrent.Striped.WeakSafeReadWriteLock();
        }
    }

    public static class CompactStriped<L> extends com.google.common.util.concurrent.Striped.PowerOfTwoStriped<L> {
        public final java.lang.Object[] d;

        public CompactStriped(int i, com.google.common.base.Supplier<L> supplier) {
            super(i);
            int i2 = 0;
            com.google.common.base.Preconditions.checkArgument(i <= 1073741824, "Stripes must be <= 2^30)");
            this.d = new java.lang.Object[this.c + 1];
            while (true) {
                java.lang.Object[] objArr = this.d;
                if (i2 >= objArr.length) {
                    return;
                }
                objArr[i2] = supplier.get();
                i2++;
            }
        }

        public /* synthetic */ CompactStriped(int i, com.google.common.base.Supplier supplier, com.google.common.util.concurrent.Striped.AnonymousClass1 anonymousClass1) {
            this(i, supplier);
        }

        @Override // com.google.common.util.concurrent.Striped
        public L getAt(int i) {
            return (L) this.d[i];
        }

        @Override // com.google.common.util.concurrent.Striped
        public int size() {
            return this.d.length;
        }
    }

    @com.google.common.annotations.VisibleForTesting
    public static class LargeLazyStriped<L> extends com.google.common.util.concurrent.Striped.PowerOfTwoStriped<L> {
        public final java.util.concurrent.ConcurrentMap<java.lang.Integer, L> d;
        public final com.google.common.base.Supplier<L> e;
        public final int f;

        public LargeLazyStriped(int i, com.google.common.base.Supplier<L> supplier) {
            super(i);
            int i2 = this.c;
            this.f = i2 == -1 ? Integer.MAX_VALUE : i2 + 1;
            this.e = supplier;
            this.d = new com.google.common.collect.MapMaker().weakValues().makeMap();
        }

        @Override // com.google.common.util.concurrent.Striped
        public L getAt(int i) {
            if (this.f != Integer.MAX_VALUE) {
                com.google.common.base.Preconditions.checkElementIndex(i, size());
            }
            L l = this.d.get(java.lang.Integer.valueOf(i));
            if (l != null) {
                return l;
            }
            L l2 = this.e.get();
            return (L) com.google.common.base.MoreObjects.firstNonNull(this.d.putIfAbsent(java.lang.Integer.valueOf(i), l2), l2);
        }

        @Override // com.google.common.util.concurrent.Striped
        public int size() {
            return this.f;
        }
    }

    public static class PaddedLock extends java.util.concurrent.locks.ReentrantLock {
        long unused1;
        long unused2;
        long unused3;

        public PaddedLock() {
            super(false);
        }
    }

    public static class PaddedSemaphore extends java.util.concurrent.Semaphore {
        long unused1;
        long unused2;
        long unused3;

        public PaddedSemaphore(int i) {
            super(i, false);
        }
    }

    public static abstract class PowerOfTwoStriped<L> extends com.google.common.util.concurrent.Striped<L> {
        public final int c;

        public PowerOfTwoStriped(int i) {
            super(null);
            com.google.common.base.Preconditions.checkArgument(i > 0, "Stripes must be positive");
            this.c = i > 1073741824 ? -1 : com.google.common.util.concurrent.Striped.c(i) - 1;
        }

        @Override // com.google.common.util.concurrent.Striped
        public final int e(java.lang.Object obj) {
            return com.google.common.util.concurrent.Striped.g(obj.hashCode()) & this.c;
        }

        @Override // com.google.common.util.concurrent.Striped
        public final L get(java.lang.Object obj) {
            return getAt(e(obj));
        }
    }

    @com.google.common.annotations.VisibleForTesting
    public static class SmallLazyStriped<L> extends com.google.common.util.concurrent.Striped.PowerOfTwoStriped<L> {
        public final java.util.concurrent.atomic.AtomicReferenceArray<com.google.common.util.concurrent.Striped.SmallLazyStriped.ArrayReference<? extends L>> d;
        public final com.google.common.base.Supplier<L> e;
        public final int f;
        public final java.lang.ref.ReferenceQueue<L> g;

        public static final class ArrayReference<L> extends java.lang.ref.WeakReference<L> {
            public final int a;

            public ArrayReference(L l, int i, java.lang.ref.ReferenceQueue<L> referenceQueue) {
                super(l, referenceQueue);
                this.a = i;
            }
        }

        public SmallLazyStriped(int i, com.google.common.base.Supplier<L> supplier) {
            super(i);
            this.g = new java.lang.ref.ReferenceQueue<>();
            int i2 = this.c;
            int i3 = i2 == -1 ? Integer.MAX_VALUE : i2 + 1;
            this.f = i3;
            this.d = new java.util.concurrent.atomic.AtomicReferenceArray<>(i3);
            this.e = supplier;
        }

        @Override // com.google.common.util.concurrent.Striped
        public L getAt(int i) {
            if (this.f != Integer.MAX_VALUE) {
                com.google.common.base.Preconditions.checkElementIndex(i, size());
            }
            com.google.common.util.concurrent.Striped.SmallLazyStriped.ArrayReference<? extends L> arrayReference = this.d.get(i);
            L l = arrayReference == null ? null : arrayReference.get();
            if (l != null) {
                return l;
            }
            L l2 = this.e.get();
            com.google.common.util.concurrent.Striped.SmallLazyStriped.ArrayReference arrayReference2 = new com.google.common.util.concurrent.Striped.SmallLazyStriped.ArrayReference(l2, i, this.g);
            while (!defpackage.es2.a(this.d, i, arrayReference, arrayReference2)) {
                arrayReference = this.d.get(i);
                L l3 = arrayReference == null ? null : arrayReference.get();
                if (l3 != null) {
                    return l3;
                }
            }
            h();
            return l2;
        }

        public final void h() {
            while (true) {
                java.lang.ref.Reference<? extends L> poll = this.g.poll();
                if (poll == null) {
                    return;
                }
                com.google.common.util.concurrent.Striped.SmallLazyStriped.ArrayReference arrayReference = (com.google.common.util.concurrent.Striped.SmallLazyStriped.ArrayReference) poll;
                defpackage.es2.a(this.d, arrayReference.a, arrayReference, null);
            }
        }

        @Override // com.google.common.util.concurrent.Striped
        public int size() {
            return this.f;
        }
    }

    public static final class WeakSafeCondition extends com.google.common.util.concurrent.ForwardingCondition {
        public final java.util.concurrent.locks.Condition a;
        public final com.google.common.util.concurrent.Striped.WeakSafeReadWriteLock b;

        public WeakSafeCondition(java.util.concurrent.locks.Condition condition, com.google.common.util.concurrent.Striped.WeakSafeReadWriteLock weakSafeReadWriteLock) {
            this.a = condition;
            this.b = weakSafeReadWriteLock;
        }

        @Override // com.google.common.util.concurrent.ForwardingCondition
        public java.util.concurrent.locks.Condition a() {
            return this.a;
        }
    }

    public static final class WeakSafeLock extends com.google.common.util.concurrent.ForwardingLock {
        public final java.util.concurrent.locks.Lock n;
        public final com.google.common.util.concurrent.Striped.WeakSafeReadWriteLock t;

        public WeakSafeLock(java.util.concurrent.locks.Lock lock, com.google.common.util.concurrent.Striped.WeakSafeReadWriteLock weakSafeReadWriteLock) {
            this.n = lock;
            this.t = weakSafeReadWriteLock;
        }

        @Override // com.google.common.util.concurrent.ForwardingLock
        public java.util.concurrent.locks.Lock a() {
            return this.n;
        }

        @Override // com.google.common.util.concurrent.ForwardingLock, java.util.concurrent.locks.Lock
        public java.util.concurrent.locks.Condition newCondition() {
            return new com.google.common.util.concurrent.Striped.WeakSafeCondition(this.n.newCondition(), this.t);
        }
    }

    public static final class WeakSafeReadWriteLock implements java.util.concurrent.locks.ReadWriteLock {
        public final java.util.concurrent.locks.ReadWriteLock n = new java.util.concurrent.locks.ReentrantReadWriteLock();

        @Override // java.util.concurrent.locks.ReadWriteLock
        public java.util.concurrent.locks.Lock readLock() {
            return new com.google.common.util.concurrent.Striped.WeakSafeLock(this.n.readLock(), this);
        }

        @Override // java.util.concurrent.locks.ReadWriteLock
        public java.util.concurrent.locks.Lock writeLock() {
            return new com.google.common.util.concurrent.Striped.WeakSafeLock(this.n.writeLock(), this);
        }
    }

    public Striped() {
    }

    public /* synthetic */ Striped(com.google.common.util.concurrent.Striped.AnonymousClass1 anonymousClass1) {
        this();
    }

    public static int c(int i) {
        return 1 << com.google.common.math.IntMath.log2(i, java.math.RoundingMode.CEILING);
    }

    public static <L> com.google.common.util.concurrent.Striped<L> d(int i, com.google.common.base.Supplier<L> supplier) {
        return new com.google.common.util.concurrent.Striped.CompactStriped(i, supplier, null);
    }

    public static <L> com.google.common.util.concurrent.Striped<L> f(int i, com.google.common.base.Supplier<L> supplier) {
        return i < 1024 ? new com.google.common.util.concurrent.Striped.SmallLazyStriped(i, supplier) : new com.google.common.util.concurrent.Striped.LargeLazyStriped(i, supplier);
    }

    public static int g(int i) {
        int i2 = i ^ ((i >>> 20) ^ (i >>> 12));
        return (i2 >>> 4) ^ ((i2 >>> 7) ^ i2);
    }

    public static com.google.common.util.concurrent.Striped<java.util.concurrent.locks.Lock> lazyWeakLock(int i) {
        return f(i, new com.google.common.util.concurrent.Striped.AnonymousClass2());
    }

    public static com.google.common.util.concurrent.Striped<java.util.concurrent.locks.ReadWriteLock> lazyWeakReadWriteLock(int i) {
        return f(i, b);
    }

    public static com.google.common.util.concurrent.Striped<java.util.concurrent.Semaphore> lazyWeakSemaphore(int i, int i2) {
        return f(i, new com.google.common.util.concurrent.Striped.AnonymousClass4(i2));
    }

    public static com.google.common.util.concurrent.Striped<java.util.concurrent.locks.Lock> lock(int i) {
        return d(i, new com.google.common.util.concurrent.Striped.AnonymousClass1());
    }

    public static com.google.common.util.concurrent.Striped<java.util.concurrent.locks.ReadWriteLock> readWriteLock(int i) {
        return d(i, a);
    }

    public static com.google.common.util.concurrent.Striped<java.util.concurrent.Semaphore> semaphore(int i, int i2) {
        return d(i, new com.google.common.util.concurrent.Striped.AnonymousClass3(i2));
    }

    public java.lang.Iterable<L> bulkGet(java.lang.Iterable<?> iterable) {
        java.lang.Object[] array = com.google.common.collect.Iterables.toArray(iterable, java.lang.Object.class);
        if (array.length == 0) {
            return com.google.common.collect.ImmutableList.of();
        }
        int[] iArr = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            iArr[i] = e(array[i]);
        }
        java.util.Arrays.sort(iArr);
        int i2 = iArr[0];
        array[0] = getAt(i2);
        for (int i3 = 1; i3 < array.length; i3++) {
            int i4 = iArr[i3];
            if (i4 == i2) {
                array[i3] = array[i3 - 1];
            } else {
                array[i3] = getAt(i4);
                i2 = i4;
            }
        }
        return java.util.Collections.unmodifiableList(java.util.Arrays.asList(array));
    }

    public abstract int e(java.lang.Object obj);

    public abstract L get(java.lang.Object obj);

    public abstract L getAt(int i);

    public abstract int size();
}
