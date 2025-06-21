package com.google.common.util.concurrent;

@com.google.j2objc.annotations.ReflectionSupport(com.google.j2objc.annotations.ReflectionSupport.Level.FULL)
@com.google.common.annotations.GwtCompatible(emulated = true)
/* loaded from: classes22.dex */
abstract class AggregateFutureState {
    public static final com.google.common.util.concurrent.AggregateFutureState.AtomicHelper u;
    public static final java.util.logging.Logger v = java.util.logging.Logger.getLogger(com.google.common.util.concurrent.AggregateFutureState.class.getName());
    public volatile java.util.Set<java.lang.Throwable> n = null;
    public volatile int t;

    public static abstract class AtomicHelper {
        public AtomicHelper() {
        }

        public /* synthetic */ AtomicHelper(com.google.common.util.concurrent.AggregateFutureState.AnonymousClass1 anonymousClass1) {
            this();
        }

        public abstract void a(com.google.common.util.concurrent.AggregateFutureState aggregateFutureState, java.util.Set<java.lang.Throwable> set, java.util.Set<java.lang.Throwable> set2);

        public abstract int b(com.google.common.util.concurrent.AggregateFutureState aggregateFutureState);
    }

    public static final class SafeAtomicHelper extends com.google.common.util.concurrent.AggregateFutureState.AtomicHelper {
        public final java.util.concurrent.atomic.AtomicReferenceFieldUpdater<com.google.common.util.concurrent.AggregateFutureState, java.util.Set<java.lang.Throwable>> a;
        public final java.util.concurrent.atomic.AtomicIntegerFieldUpdater<com.google.common.util.concurrent.AggregateFutureState> b;

        public SafeAtomicHelper(java.util.concurrent.atomic.AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, java.util.concurrent.atomic.AtomicIntegerFieldUpdater atomicIntegerFieldUpdater) {
            super(null);
            this.a = atomicReferenceFieldUpdater;
            this.b = atomicIntegerFieldUpdater;
        }

        @Override // com.google.common.util.concurrent.AggregateFutureState.AtomicHelper
        public void a(com.google.common.util.concurrent.AggregateFutureState aggregateFutureState, java.util.Set<java.lang.Throwable> set, java.util.Set<java.lang.Throwable> set2) {
            defpackage.q1.a(this.a, aggregateFutureState, set, set2);
        }

        @Override // com.google.common.util.concurrent.AggregateFutureState.AtomicHelper
        public int b(com.google.common.util.concurrent.AggregateFutureState aggregateFutureState) {
            return this.b.decrementAndGet(aggregateFutureState);
        }
    }

    public static final class SynchronizedAtomicHelper extends com.google.common.util.concurrent.AggregateFutureState.AtomicHelper {
        public SynchronizedAtomicHelper() {
            super(null);
        }

        public /* synthetic */ SynchronizedAtomicHelper(com.google.common.util.concurrent.AggregateFutureState.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.google.common.util.concurrent.AggregateFutureState.AtomicHelper
        public void a(com.google.common.util.concurrent.AggregateFutureState aggregateFutureState, java.util.Set<java.lang.Throwable> set, java.util.Set<java.lang.Throwable> set2) {
            synchronized (aggregateFutureState) {
                if (aggregateFutureState.n == set) {
                    aggregateFutureState.n = set2;
                }
            }
        }

        @Override // com.google.common.util.concurrent.AggregateFutureState.AtomicHelper
        public int b(com.google.common.util.concurrent.AggregateFutureState aggregateFutureState) {
            int i;
            synchronized (aggregateFutureState) {
                com.google.common.util.concurrent.AggregateFutureState.d(aggregateFutureState);
                i = aggregateFutureState.t;
            }
            return i;
        }
    }

    static {
        com.google.common.util.concurrent.AggregateFutureState.AtomicHelper synchronizedAtomicHelper;
        java.lang.Throwable th = null;
        try {
            synchronizedAtomicHelper = new com.google.common.util.concurrent.AggregateFutureState.SafeAtomicHelper(java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(com.google.common.util.concurrent.AggregateFutureState.class, java.util.Set.class, com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT), java.util.concurrent.atomic.AtomicIntegerFieldUpdater.newUpdater(com.google.common.util.concurrent.AggregateFutureState.class, "t"));
        } catch (java.lang.Throwable th2) {
            synchronizedAtomicHelper = new com.google.common.util.concurrent.AggregateFutureState.SynchronizedAtomicHelper(null);
            th = th2;
        }
        u = synchronizedAtomicHelper;
        if (th != null) {
            v.log(java.util.logging.Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
    }

    public AggregateFutureState(int i) {
        this.t = i;
    }

    public static /* synthetic */ int d(com.google.common.util.concurrent.AggregateFutureState aggregateFutureState) {
        int i = aggregateFutureState.t;
        aggregateFutureState.t = i - 1;
        return i;
    }

    public abstract void e(java.util.Set<java.lang.Throwable> set);

    public final int f() {
        return u.b(this);
    }

    public final java.util.Set<java.lang.Throwable> g() {
        java.util.Set<java.lang.Throwable> set = this.n;
        if (set != null) {
            return set;
        }
        java.util.Set<java.lang.Throwable> newConcurrentHashSet = com.google.common.collect.Sets.newConcurrentHashSet();
        e(newConcurrentHashSet);
        u.a(this, null, newConcurrentHashSet);
        return this.n;
    }
}
