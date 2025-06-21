package com.google.common.cache;

@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
public abstract class ForwardingLoadingCache<K, V> extends com.google.common.cache.ForwardingCache<K, V> implements com.google.common.cache.LoadingCache<K, V> {

    public static abstract class SimpleForwardingLoadingCache<K, V> extends com.google.common.cache.ForwardingLoadingCache<K, V> {
        public final com.google.common.cache.LoadingCache<K, V> n;

        public SimpleForwardingLoadingCache(com.google.common.cache.LoadingCache<K, V> loadingCache) {
            this.n = (com.google.common.cache.LoadingCache) com.google.common.base.Preconditions.checkNotNull(loadingCache);
        }

        @Override // com.google.common.cache.ForwardingLoadingCache, com.google.common.cache.ForwardingCache, com.google.common.collect.ForwardingObject
        public final com.google.common.cache.LoadingCache<K, V> delegate() {
            return this.n;
        }
    }

    @Override // com.google.common.cache.LoadingCache, com.google.common.base.Function
    public V apply(K k) {
        return delegate().apply(k);
    }

    @Override // com.google.common.cache.ForwardingCache, com.google.common.collect.ForwardingObject
    public abstract com.google.common.cache.LoadingCache<K, V> delegate();

    @Override // com.google.common.cache.LoadingCache
    public V get(K k) throws java.util.concurrent.ExecutionException {
        return delegate().get(k);
    }

    @Override // com.google.common.cache.LoadingCache
    public com.google.common.collect.ImmutableMap<K, V> getAll(java.lang.Iterable<? extends K> iterable) throws java.util.concurrent.ExecutionException {
        return delegate().getAll(iterable);
    }

    @Override // com.google.common.cache.LoadingCache
    public V getUnchecked(K k) {
        return delegate().getUnchecked(k);
    }

    @Override // com.google.common.cache.LoadingCache
    public void refresh(K k) {
        delegate().refresh(k);
    }
}
