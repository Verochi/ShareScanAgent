package com.google.common.cache;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public interface Cache<K, V> {
    java.util.concurrent.ConcurrentMap<K, V> asMap();

    void cleanUp();

    V get(K k, java.util.concurrent.Callable<? extends V> callable) throws java.util.concurrent.ExecutionException;

    com.google.common.collect.ImmutableMap<K, V> getAllPresent(java.lang.Iterable<?> iterable);

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    V getIfPresent(@com.google.errorprone.annotations.CompatibleWith("K") java.lang.Object obj);

    void invalidate(@com.google.errorprone.annotations.CompatibleWith("K") java.lang.Object obj);

    void invalidateAll();

    void invalidateAll(java.lang.Iterable<?> iterable);

    void put(K k, V v);

    void putAll(java.util.Map<? extends K, ? extends V> map);

    long size();

    com.google.common.cache.CacheStats stats();
}
