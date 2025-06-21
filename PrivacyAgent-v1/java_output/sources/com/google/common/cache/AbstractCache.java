package com.google.common.cache;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public abstract class AbstractCache<K, V> implements com.google.common.cache.Cache<K, V> {

    public static final class SimpleStatsCounter implements com.google.common.cache.AbstractCache.StatsCounter {
        public final com.google.common.cache.LongAddable a = com.google.common.cache.LongAddables.a();
        public final com.google.common.cache.LongAddable b = com.google.common.cache.LongAddables.a();
        public final com.google.common.cache.LongAddable c = com.google.common.cache.LongAddables.a();
        public final com.google.common.cache.LongAddable d = com.google.common.cache.LongAddables.a();
        public final com.google.common.cache.LongAddable e = com.google.common.cache.LongAddables.a();
        public final com.google.common.cache.LongAddable f = com.google.common.cache.LongAddables.a();

        public void incrementBy(com.google.common.cache.AbstractCache.StatsCounter statsCounter) {
            com.google.common.cache.CacheStats snapshot = statsCounter.snapshot();
            this.a.add(snapshot.hitCount());
            this.b.add(snapshot.missCount());
            this.c.add(snapshot.loadSuccessCount());
            this.d.add(snapshot.loadExceptionCount());
            this.e.add(snapshot.totalLoadTime());
            this.f.add(snapshot.evictionCount());
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void recordEviction() {
            this.f.increment();
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void recordHits(int i) {
            this.a.add(i);
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void recordLoadException(long j) {
            this.d.increment();
            this.e.add(j);
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void recordLoadSuccess(long j) {
            this.c.increment();
            this.e.add(j);
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void recordMisses(int i) {
            this.b.add(i);
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public com.google.common.cache.CacheStats snapshot() {
            return new com.google.common.cache.CacheStats(this.a.sum(), this.b.sum(), this.c.sum(), this.d.sum(), this.e.sum(), this.f.sum());
        }
    }

    public interface StatsCounter {
        void recordEviction();

        void recordHits(int i);

        void recordLoadException(long j);

        void recordLoadSuccess(long j);

        void recordMisses(int i);

        com.google.common.cache.CacheStats snapshot();
    }

    @Override // com.google.common.cache.Cache
    public java.util.concurrent.ConcurrentMap<K, V> asMap() {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // com.google.common.cache.Cache
    public void cleanUp() {
    }

    @Override // com.google.common.cache.Cache
    public V get(K k, java.util.concurrent.Callable<? extends V> callable) throws java.util.concurrent.ExecutionException {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // com.google.common.cache.Cache
    public com.google.common.collect.ImmutableMap<K, V> getAllPresent(java.lang.Iterable<?> iterable) {
        V ifPresent;
        java.util.LinkedHashMap newLinkedHashMap = com.google.common.collect.Maps.newLinkedHashMap();
        for (java.lang.Object obj : iterable) {
            if (!newLinkedHashMap.containsKey(obj) && (ifPresent = getIfPresent(obj)) != null) {
                newLinkedHashMap.put(obj, ifPresent);
            }
        }
        return com.google.common.collect.ImmutableMap.copyOf((java.util.Map) newLinkedHashMap);
    }

    @Override // com.google.common.cache.Cache
    public void invalidate(java.lang.Object obj) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // com.google.common.cache.Cache
    public void invalidateAll() {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // com.google.common.cache.Cache
    public void invalidateAll(java.lang.Iterable<?> iterable) {
        java.util.Iterator<?> it = iterable.iterator();
        while (it.hasNext()) {
            invalidate(it.next());
        }
    }

    @Override // com.google.common.cache.Cache
    public void put(K k, V v) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // com.google.common.cache.Cache
    public void putAll(java.util.Map<? extends K, ? extends V> map) {
        for (java.util.Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.common.cache.Cache
    public long size() {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // com.google.common.cache.Cache
    public com.google.common.cache.CacheStats stats() {
        throw new java.lang.UnsupportedOperationException();
    }
}
