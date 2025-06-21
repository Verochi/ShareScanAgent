package com.google.common.hash;

/* loaded from: classes22.dex */
final class LongAddables {
    public static final com.google.common.base.Supplier<com.google.common.hash.LongAddable> a;

    /* renamed from: com.google.common.hash.LongAddables$1, reason: invalid class name */
    public static class AnonymousClass1 implements com.google.common.base.Supplier<com.google.common.hash.LongAddable> {
        @Override // com.google.common.base.Supplier
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.google.common.hash.LongAddable get() {
            return new com.google.common.hash.LongAdder();
        }
    }

    /* renamed from: com.google.common.hash.LongAddables$2, reason: invalid class name */
    public static class AnonymousClass2 implements com.google.common.base.Supplier<com.google.common.hash.LongAddable> {
        @Override // com.google.common.base.Supplier
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.google.common.hash.LongAddable get() {
            return new com.google.common.hash.LongAddables.PureJavaLongAddable(null);
        }
    }

    public static final class PureJavaLongAddable extends java.util.concurrent.atomic.AtomicLong implements com.google.common.hash.LongAddable {
        private PureJavaLongAddable() {
        }

        public /* synthetic */ PureJavaLongAddable(com.google.common.hash.LongAddables.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.google.common.hash.LongAddable
        public void add(long j) {
            getAndAdd(j);
        }

        @Override // com.google.common.hash.LongAddable
        public void increment() {
            getAndIncrement();
        }

        @Override // com.google.common.hash.LongAddable
        public long sum() {
            return get();
        }
    }

    static {
        com.google.common.base.Supplier<com.google.common.hash.LongAddable> anonymousClass2;
        try {
            new com.google.common.hash.LongAdder();
            anonymousClass2 = new com.google.common.hash.LongAddables.AnonymousClass1();
        } catch (java.lang.Throwable unused) {
            anonymousClass2 = new com.google.common.hash.LongAddables.AnonymousClass2();
        }
        a = anonymousClass2;
    }

    public static com.google.common.hash.LongAddable a() {
        return a.get();
    }
}
