package com.google.common.graph;

/* loaded from: classes22.dex */
class MapRetrievalCache<K, V> extends com.google.common.graph.MapIteratorCache<K, V> {

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public transient com.google.common.graph.MapRetrievalCache.CacheEntry<K, V> c;

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public transient com.google.common.graph.MapRetrievalCache.CacheEntry<K, V> d;

    public static final class CacheEntry<K, V> {
        public final K a;
        public final V b;

        public CacheEntry(K k, V v) {
            this.a = k;
            this.b = v;
        }
    }

    public MapRetrievalCache(java.util.Map<K, V> map) {
        super(map);
    }

    @Override // com.google.common.graph.MapIteratorCache
    public void c() {
        super.c();
        this.c = null;
        this.d = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.MapIteratorCache
    public V e(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        V f = f(obj);
        if (f != null) {
            return f;
        }
        V g = g(obj);
        if (g != null) {
            l(obj, g);
        }
        return g;
    }

    @Override // com.google.common.graph.MapIteratorCache
    public V f(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        V v = (V) super.f(obj);
        if (v != null) {
            return v;
        }
        com.google.common.graph.MapRetrievalCache.CacheEntry<K, V> cacheEntry = this.c;
        if (cacheEntry != null && cacheEntry.a == obj) {
            return cacheEntry.b;
        }
        com.google.common.graph.MapRetrievalCache.CacheEntry<K, V> cacheEntry2 = this.d;
        if (cacheEntry2 == null || cacheEntry2.a != obj) {
            return null;
        }
        k(cacheEntry2);
        return cacheEntry2.b;
    }

    public final void k(com.google.common.graph.MapRetrievalCache.CacheEntry<K, V> cacheEntry) {
        this.d = this.c;
        this.c = cacheEntry;
    }

    public final void l(K k, V v) {
        k(new com.google.common.graph.MapRetrievalCache.CacheEntry<>(k, v));
    }
}
