package com.google.common.cache;

@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
public abstract class ForwardingCache<K, V> extends com.google.common.collect.ForwardingObject implements com.google.common.cache.Cache<K, V> {

    public static abstract class SimpleForwardingCache<K, V> extends com.google.common.cache.ForwardingCache<K, V> {
        public final com.google.common.cache.Cache<K, V> n;

        public SimpleForwardingCache(com.google.common.cache.Cache<K, V> cache) {
            this.n = (com.google.common.cache.Cache) com.google.common.base.Preconditions.checkNotNull(cache);
        }

        @Override // com.google.common.cache.ForwardingCache, com.google.common.collect.ForwardingObject
        public final com.google.common.cache.Cache<K, V> delegate() {
            return this.n;
        }
    }

    @Override // com.google.common.cache.Cache
    public java.util.concurrent.ConcurrentMap<K, V> asMap() {
        return delegate().asMap();
    }

    @Override // com.google.common.cache.Cache
    public void cleanUp() {
        delegate().cleanUp();
    }

    @Override // com.google.common.collect.ForwardingObject
    public abstract com.google.common.cache.Cache<K, V> delegate();

    @Override // com.google.common.cache.Cache
    public V get(K k, java.util.concurrent.Callable<? extends V> callable) throws java.util.concurrent.ExecutionException {
        return delegate().get(k, callable);
    }

    @Override // com.google.common.cache.Cache
    public com.google.common.collect.ImmutableMap<K, V> getAllPresent(java.lang.Iterable<?> iterable) {
        return delegate().getAllPresent(iterable);
    }

    @Override // com.google.common.cache.Cache
    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public V getIfPresent(java.lang.Object obj) {
        return delegate().getIfPresent(obj);
    }

    @Override // com.google.common.cache.Cache
    public void invalidate(java.lang.Object obj) {
        delegate().invalidate(obj);
    }

    @Override // com.google.common.cache.Cache
    public void invalidateAll() {
        delegate().invalidateAll();
    }

    @Override // com.google.common.cache.Cache
    public void invalidateAll(java.lang.Iterable<?> iterable) {
        delegate().invalidateAll(iterable);
    }

    @Override // com.google.common.cache.Cache
    public void put(K k, V v) {
        delegate().put(k, v);
    }

    @Override // com.google.common.cache.Cache
    public void putAll(java.util.Map<? extends K, ? extends V> map) {
        delegate().putAll(map);
    }

    @Override // com.google.common.cache.Cache
    public long size() {
        return delegate().size();
    }

    @Override // com.google.common.cache.Cache
    public com.google.common.cache.CacheStats stats() {
        return delegate().stats();
    }
}
