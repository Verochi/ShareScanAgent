package com.google.common.cache;

@com.google.common.annotations.GwtCompatible(emulated = true)
/* loaded from: classes22.dex */
final class LongAddables {
    public static final com.google.common.base.Supplier<com.google.common.cache.LongAddable> a;

    /* renamed from: com.google.common.cache.LongAddables$1, reason: invalid class name */
    public static class AnonymousClass1 implements com.google.common.base.Supplier<com.google.common.cache.LongAddable> {
        @Override // com.google.common.base.Supplier
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.google.common.cache.LongAddable get() {
            return new com.google.common.cache.LongAdder();
        }
    }

    /* renamed from: com.google.common.cache.LongAddables$2, reason: invalid class name */
    public static class AnonymousClass2 implements com.google.common.base.Supplier<com.google.common.cache.LongAddable> {
        @Override // com.google.common.base.Supplier
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.google.common.cache.LongAddable get() {
            return new com.google.common.cache.LongAddables.PureJavaLongAddable(null);
        }
    }

    public static final class PureJavaLongAddable extends java.util.concurrent.atomic.AtomicLong implements com.google.common.cache.LongAddable {
        private PureJavaLongAddable() {
        }

        public /* synthetic */ PureJavaLongAddable(com.google.common.cache.LongAddables.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.google.common.cache.LongAddable
        public void add(long j) {
            getAndAdd(j);
        }

        @Override // com.google.common.cache.LongAddable
        public void increment() {
            getAndIncrement();
        }

        @Override // com.google.common.cache.LongAddable
        public long sum() {
            return get();
        }
    }

    static {
        com.google.common.base.Supplier<com.google.common.cache.LongAddable> anonymousClass2;
        try {
            new com.google.common.cache.LongAdder();
            anonymousClass2 = new com.google.common.cache.LongAddables.AnonymousClass1();
        } catch (java.lang.Throwable unused) {
            anonymousClass2 = new com.google.common.cache.LongAddables.AnonymousClass2();
        }
        a = anonymousClass2;
    }

    public static com.google.common.cache.LongAddable a() {
        return a.get();
    }
}
