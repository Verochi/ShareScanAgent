package com.google.common.cache;

@com.google.common.annotations.GwtCompatible(emulated = true)
/* loaded from: classes22.dex */
public final class CacheBuilder<K, V> {
    public static final com.google.common.base.Supplier<? extends com.google.common.cache.AbstractCache.StatsCounter> q = com.google.common.base.Suppliers.ofInstance(new com.google.common.cache.CacheBuilder.AnonymousClass1());
    public static final com.google.common.cache.CacheStats r = new com.google.common.cache.CacheStats(0, 0, 0, 0, 0, 0);

    /* renamed from: s, reason: collision with root package name */
    public static final com.google.common.base.Supplier<com.google.common.cache.AbstractCache.StatsCounter> f371s = new com.google.common.cache.CacheBuilder.AnonymousClass2();
    public static final com.google.common.base.Ticker t = new com.google.common.cache.CacheBuilder.AnonymousClass3();
    public static final java.util.logging.Logger u = java.util.logging.Logger.getLogger(com.google.common.cache.CacheBuilder.class.getName());

    @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
    public com.google.common.cache.Weigher<? super K, ? super V> f;

    @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
    public com.google.common.cache.LocalCache.Strength g;

    @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
    public com.google.common.cache.LocalCache.Strength h;

    @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
    public com.google.common.base.Equivalence<java.lang.Object> l;

    @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
    public com.google.common.base.Equivalence<java.lang.Object> m;

    @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
    public com.google.common.cache.RemovalListener<? super K, ? super V> n;

    @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
    public com.google.common.base.Ticker o;
    public boolean a = true;
    public int b = -1;
    public int c = -1;
    public long d = -1;
    public long e = -1;
    public long i = -1;
    public long j = -1;
    public long k = -1;
    public com.google.common.base.Supplier<? extends com.google.common.cache.AbstractCache.StatsCounter> p = q;

    /* renamed from: com.google.common.cache.CacheBuilder$1, reason: invalid class name */
    public static class AnonymousClass1 implements com.google.common.cache.AbstractCache.StatsCounter {
        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void recordEviction() {
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void recordHits(int i) {
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void recordLoadException(long j) {
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void recordLoadSuccess(long j) {
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void recordMisses(int i) {
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public com.google.common.cache.CacheStats snapshot() {
            return com.google.common.cache.CacheBuilder.r;
        }
    }

    /* renamed from: com.google.common.cache.CacheBuilder$2, reason: invalid class name */
    public static class AnonymousClass2 implements com.google.common.base.Supplier<com.google.common.cache.AbstractCache.StatsCounter> {
        @Override // com.google.common.base.Supplier
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.google.common.cache.AbstractCache.StatsCounter get() {
            return new com.google.common.cache.AbstractCache.SimpleStatsCounter();
        }
    }

    /* renamed from: com.google.common.cache.CacheBuilder$3, reason: invalid class name */
    public static class AnonymousClass3 extends com.google.common.base.Ticker {
        @Override // com.google.common.base.Ticker
        public long read() {
            return 0L;
        }
    }

    public enum NullListener implements com.google.common.cache.RemovalListener<java.lang.Object, java.lang.Object> {
        INSTANCE;

        @Override // com.google.common.cache.RemovalListener
        public void onRemoval(com.google.common.cache.RemovalNotification<java.lang.Object, java.lang.Object> removalNotification) {
        }
    }

    public enum OneWeigher implements com.google.common.cache.Weigher<java.lang.Object, java.lang.Object> {
        INSTANCE;

        @Override // com.google.common.cache.Weigher
        public int weigh(java.lang.Object obj, java.lang.Object obj2) {
            return 1;
        }
    }

    @com.google.common.annotations.GwtIncompatible
    public static com.google.common.cache.CacheBuilder<java.lang.Object, java.lang.Object> from(com.google.common.cache.CacheBuilderSpec cacheBuilderSpec) {
        return cacheBuilderSpec.d().r();
    }

    @com.google.common.annotations.GwtIncompatible
    public static com.google.common.cache.CacheBuilder<java.lang.Object, java.lang.Object> from(java.lang.String str) {
        return from(com.google.common.cache.CacheBuilderSpec.parse(str));
    }

    public static com.google.common.cache.CacheBuilder<java.lang.Object, java.lang.Object> newBuilder() {
        return new com.google.common.cache.CacheBuilder<>();
    }

    public final void a() {
        com.google.common.base.Preconditions.checkState(this.k == -1, "refreshAfterWrite requires a LoadingCache");
    }

    public final void b() {
        if (this.f == null) {
            com.google.common.base.Preconditions.checkState(this.e == -1, "maximumWeight requires weigher");
        } else if (this.a) {
            com.google.common.base.Preconditions.checkState(this.e != -1, "weigher requires maximumWeight");
        } else if (this.e == -1) {
            u.log(java.util.logging.Level.WARNING, "ignoring weigher specified without maximumWeight");
        }
    }

    public <K1 extends K, V1 extends V> com.google.common.cache.Cache<K1, V1> build() {
        b();
        a();
        return new com.google.common.cache.LocalCache.LocalManualCache(this);
    }

    public <K1 extends K, V1 extends V> com.google.common.cache.LoadingCache<K1, V1> build(com.google.common.cache.CacheLoader<? super K1, V1> cacheLoader) {
        b();
        return new com.google.common.cache.LocalCache.LocalLoadingCache(this, cacheLoader);
    }

    public int c() {
        int i = this.c;
        if (i == -1) {
            return 4;
        }
        return i;
    }

    public com.google.common.cache.CacheBuilder<K, V> concurrencyLevel(int i) {
        int i2 = this.c;
        com.google.common.base.Preconditions.checkState(i2 == -1, "concurrency level was already set to %s", i2);
        com.google.common.base.Preconditions.checkArgument(i > 0);
        this.c = i;
        return this;
    }

    public long d() {
        long j = this.j;
        if (j == -1) {
            return 0L;
        }
        return j;
    }

    public long e() {
        long j = this.i;
        if (j == -1) {
            return 0L;
        }
        return j;
    }

    public com.google.common.cache.CacheBuilder<K, V> expireAfterAccess(long j, java.util.concurrent.TimeUnit timeUnit) {
        long j2 = this.j;
        com.google.common.base.Preconditions.checkState(j2 == -1, "expireAfterAccess was already set to %s ns", j2);
        com.google.common.base.Preconditions.checkArgument(j >= 0, "duration cannot be negative: %s %s", j, timeUnit);
        this.j = timeUnit.toNanos(j);
        return this;
    }

    public com.google.common.cache.CacheBuilder<K, V> expireAfterWrite(long j, java.util.concurrent.TimeUnit timeUnit) {
        long j2 = this.i;
        com.google.common.base.Preconditions.checkState(j2 == -1, "expireAfterWrite was already set to %s ns", j2);
        com.google.common.base.Preconditions.checkArgument(j >= 0, "duration cannot be negative: %s %s", j, timeUnit);
        this.i = timeUnit.toNanos(j);
        return this;
    }

    public int f() {
        int i = this.b;
        if (i == -1) {
            return 16;
        }
        return i;
    }

    public com.google.common.base.Equivalence<java.lang.Object> g() {
        return (com.google.common.base.Equivalence) com.google.common.base.MoreObjects.firstNonNull(this.l, h().defaultEquivalence());
    }

    public com.google.common.cache.LocalCache.Strength h() {
        return (com.google.common.cache.LocalCache.Strength) com.google.common.base.MoreObjects.firstNonNull(this.g, com.google.common.cache.LocalCache.Strength.STRONG);
    }

    public long i() {
        if (this.i == 0 || this.j == 0) {
            return 0L;
        }
        return this.f == null ? this.d : this.e;
    }

    public com.google.common.cache.CacheBuilder<K, V> initialCapacity(int i) {
        int i2 = this.b;
        com.google.common.base.Preconditions.checkState(i2 == -1, "initial capacity was already set to %s", i2);
        com.google.common.base.Preconditions.checkArgument(i >= 0);
        this.b = i;
        return this;
    }

    public long j() {
        long j = this.k;
        if (j == -1) {
            return 0L;
        }
        return j;
    }

    public <K1 extends K, V1 extends V> com.google.common.cache.RemovalListener<K1, V1> k() {
        return (com.google.common.cache.RemovalListener) com.google.common.base.MoreObjects.firstNonNull(this.n, com.google.common.cache.CacheBuilder.NullListener.INSTANCE);
    }

    public com.google.common.base.Supplier<? extends com.google.common.cache.AbstractCache.StatsCounter> l() {
        return this.p;
    }

    public com.google.common.base.Ticker m(boolean z) {
        com.google.common.base.Ticker ticker = this.o;
        return ticker != null ? ticker : z ? com.google.common.base.Ticker.systemTicker() : t;
    }

    public com.google.common.cache.CacheBuilder<K, V> maximumSize(long j) {
        long j2 = this.d;
        com.google.common.base.Preconditions.checkState(j2 == -1, "maximum size was already set to %s", j2);
        long j3 = this.e;
        com.google.common.base.Preconditions.checkState(j3 == -1, "maximum weight was already set to %s", j3);
        com.google.common.base.Preconditions.checkState(this.f == null, "maximum size can not be combined with weigher");
        com.google.common.base.Preconditions.checkArgument(j >= 0, "maximum size must not be negative");
        this.d = j;
        return this;
    }

    @com.google.common.annotations.GwtIncompatible
    public com.google.common.cache.CacheBuilder<K, V> maximumWeight(long j) {
        long j2 = this.e;
        com.google.common.base.Preconditions.checkState(j2 == -1, "maximum weight was already set to %s", j2);
        long j3 = this.d;
        com.google.common.base.Preconditions.checkState(j3 == -1, "maximum size was already set to %s", j3);
        this.e = j;
        com.google.common.base.Preconditions.checkArgument(j >= 0, "maximum weight must not be negative");
        return this;
    }

    public com.google.common.base.Equivalence<java.lang.Object> n() {
        return (com.google.common.base.Equivalence) com.google.common.base.MoreObjects.firstNonNull(this.m, o().defaultEquivalence());
    }

    public com.google.common.cache.LocalCache.Strength o() {
        return (com.google.common.cache.LocalCache.Strength) com.google.common.base.MoreObjects.firstNonNull(this.h, com.google.common.cache.LocalCache.Strength.STRONG);
    }

    public <K1 extends K, V1 extends V> com.google.common.cache.Weigher<K1, V1> p() {
        return (com.google.common.cache.Weigher) com.google.common.base.MoreObjects.firstNonNull(this.f, com.google.common.cache.CacheBuilder.OneWeigher.INSTANCE);
    }

    @com.google.common.annotations.GwtIncompatible
    public com.google.common.cache.CacheBuilder<K, V> q(com.google.common.base.Equivalence<java.lang.Object> equivalence) {
        com.google.common.base.Equivalence<java.lang.Object> equivalence2 = this.l;
        com.google.common.base.Preconditions.checkState(equivalence2 == null, "key equivalence was already set to %s", equivalence2);
        this.l = (com.google.common.base.Equivalence) com.google.common.base.Preconditions.checkNotNull(equivalence);
        return this;
    }

    @com.google.common.annotations.GwtIncompatible
    public com.google.common.cache.CacheBuilder<K, V> r() {
        this.a = false;
        return this;
    }

    public com.google.common.cache.CacheBuilder<K, V> recordStats() {
        this.p = f371s;
        return this;
    }

    @com.google.common.annotations.GwtIncompatible
    public com.google.common.cache.CacheBuilder<K, V> refreshAfterWrite(long j, java.util.concurrent.TimeUnit timeUnit) {
        com.google.common.base.Preconditions.checkNotNull(timeUnit);
        long j2 = this.k;
        com.google.common.base.Preconditions.checkState(j2 == -1, "refresh was already set to %s ns", j2);
        com.google.common.base.Preconditions.checkArgument(j > 0, "duration must be positive: %s %s", j, timeUnit);
        this.k = timeUnit.toNanos(j);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @com.google.errorprone.annotations.CheckReturnValue
    public <K1 extends K, V1 extends V> com.google.common.cache.CacheBuilder<K1, V1> removalListener(com.google.common.cache.RemovalListener<? super K1, ? super V1> removalListener) {
        com.google.common.base.Preconditions.checkState(this.n == null);
        this.n = (com.google.common.cache.RemovalListener) com.google.common.base.Preconditions.checkNotNull(removalListener);
        return this;
    }

    public com.google.common.cache.CacheBuilder<K, V> s(com.google.common.cache.LocalCache.Strength strength) {
        com.google.common.cache.LocalCache.Strength strength2 = this.g;
        com.google.common.base.Preconditions.checkState(strength2 == null, "Key strength was already set to %s", strength2);
        this.g = (com.google.common.cache.LocalCache.Strength) com.google.common.base.Preconditions.checkNotNull(strength);
        return this;
    }

    @com.google.common.annotations.GwtIncompatible
    public com.google.common.cache.CacheBuilder<K, V> softValues() {
        return t(com.google.common.cache.LocalCache.Strength.SOFT);
    }

    public com.google.common.cache.CacheBuilder<K, V> t(com.google.common.cache.LocalCache.Strength strength) {
        com.google.common.cache.LocalCache.Strength strength2 = this.h;
        com.google.common.base.Preconditions.checkState(strength2 == null, "Value strength was already set to %s", strength2);
        this.h = (com.google.common.cache.LocalCache.Strength) com.google.common.base.Preconditions.checkNotNull(strength);
        return this;
    }

    public com.google.common.cache.CacheBuilder<K, V> ticker(com.google.common.base.Ticker ticker) {
        com.google.common.base.Preconditions.checkState(this.o == null);
        this.o = (com.google.common.base.Ticker) com.google.common.base.Preconditions.checkNotNull(ticker);
        return this;
    }

    public java.lang.String toString() {
        com.google.common.base.MoreObjects.ToStringHelper stringHelper = com.google.common.base.MoreObjects.toStringHelper(this);
        int i = this.b;
        if (i != -1) {
            stringHelper.add("initialCapacity", i);
        }
        int i2 = this.c;
        if (i2 != -1) {
            stringHelper.add("concurrencyLevel", i2);
        }
        long j = this.d;
        if (j != -1) {
            stringHelper.add("maximumSize", j);
        }
        long j2 = this.e;
        if (j2 != -1) {
            stringHelper.add("maximumWeight", j2);
        }
        if (this.i != -1) {
            stringHelper.add("expireAfterWrite", this.i + com.meizu.cloud.pushsdk.notification.model.NotificationStyle.NOTIFICATION_STYLE);
        }
        if (this.j != -1) {
            stringHelper.add("expireAfterAccess", this.j + com.meizu.cloud.pushsdk.notification.model.NotificationStyle.NOTIFICATION_STYLE);
        }
        com.google.common.cache.LocalCache.Strength strength = this.g;
        if (strength != null) {
            stringHelper.add("keyStrength", com.google.common.base.Ascii.toLowerCase(strength.toString()));
        }
        com.google.common.cache.LocalCache.Strength strength2 = this.h;
        if (strength2 != null) {
            stringHelper.add("valueStrength", com.google.common.base.Ascii.toLowerCase(strength2.toString()));
        }
        if (this.l != null) {
            stringHelper.addValue("keyEquivalence");
        }
        if (this.m != null) {
            stringHelper.addValue("valueEquivalence");
        }
        if (this.n != null) {
            stringHelper.addValue("removalListener");
        }
        return stringHelper.toString();
    }

    @com.google.common.annotations.GwtIncompatible
    public com.google.common.cache.CacheBuilder<K, V> u(com.google.common.base.Equivalence<java.lang.Object> equivalence) {
        com.google.common.base.Equivalence<java.lang.Object> equivalence2 = this.m;
        com.google.common.base.Preconditions.checkState(equivalence2 == null, "value equivalence was already set to %s", equivalence2);
        this.m = (com.google.common.base.Equivalence) com.google.common.base.Preconditions.checkNotNull(equivalence);
        return this;
    }

    @com.google.common.annotations.GwtIncompatible
    public com.google.common.cache.CacheBuilder<K, V> weakKeys() {
        return s(com.google.common.cache.LocalCache.Strength.WEAK);
    }

    @com.google.common.annotations.GwtIncompatible
    public com.google.common.cache.CacheBuilder<K, V> weakValues() {
        return t(com.google.common.cache.LocalCache.Strength.WEAK);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @com.google.common.annotations.GwtIncompatible
    public <K1 extends K, V1 extends V> com.google.common.cache.CacheBuilder<K1, V1> weigher(com.google.common.cache.Weigher<? super K1, ? super V1> weigher) {
        com.google.common.base.Preconditions.checkState(this.f == null);
        if (this.a) {
            long j = this.d;
            com.google.common.base.Preconditions.checkState(j == -1, "weigher can not be combined with maximum size", j);
        }
        this.f = (com.google.common.cache.Weigher) com.google.common.base.Preconditions.checkNotNull(weigher);
        return this;
    }
}
