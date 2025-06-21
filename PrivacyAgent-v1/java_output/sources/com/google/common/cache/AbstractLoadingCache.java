package com.google.common.cache;

@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
public abstract class AbstractLoadingCache<K, V> extends com.google.common.cache.AbstractCache<K, V> implements com.google.common.cache.LoadingCache<K, V> {
    @Override // com.google.common.cache.LoadingCache, com.google.common.base.Function
    public final V apply(K k) {
        return getUnchecked(k);
    }

    @Override // com.google.common.cache.LoadingCache
    public com.google.common.collect.ImmutableMap<K, V> getAll(java.lang.Iterable<? extends K> iterable) throws java.util.concurrent.ExecutionException {
        java.util.LinkedHashMap newLinkedHashMap = com.google.common.collect.Maps.newLinkedHashMap();
        for (K k : iterable) {
            if (!newLinkedHashMap.containsKey(k)) {
                newLinkedHashMap.put(k, get(k));
            }
        }
        return com.google.common.collect.ImmutableMap.copyOf((java.util.Map) newLinkedHashMap);
    }

    @Override // com.google.common.cache.LoadingCache
    public V getUnchecked(K k) {
        try {
            return get(k);
        } catch (java.util.concurrent.ExecutionException e) {
            throw new com.google.common.util.concurrent.UncheckedExecutionException(e.getCause());
        }
    }

    @Override // com.google.common.cache.LoadingCache
    public void refresh(K k) {
        throw new java.lang.UnsupportedOperationException();
    }
}
