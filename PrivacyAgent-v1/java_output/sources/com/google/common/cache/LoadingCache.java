package com.google.common.cache;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public interface LoadingCache<K, V> extends com.google.common.cache.Cache<K, V>, com.google.common.base.Function<K, V> {
    @Override // com.google.common.base.Function
    @java.lang.Deprecated
    V apply(K k);

    @Override // com.google.common.cache.Cache
    java.util.concurrent.ConcurrentMap<K, V> asMap();

    V get(K k) throws java.util.concurrent.ExecutionException;

    com.google.common.collect.ImmutableMap<K, V> getAll(java.lang.Iterable<? extends K> iterable) throws java.util.concurrent.ExecutionException;

    V getUnchecked(K k);

    void refresh(K k);
}
