package com.google.common.graph;

/* loaded from: classes22.dex */
class MapIteratorCache<K, V> {
    public final java.util.Map<K, V> a;

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public transient java.util.Map.Entry<K, V> b;

    /* renamed from: com.google.common.graph.MapIteratorCache$1, reason: invalid class name */
    public class AnonymousClass1 extends java.util.AbstractSet<K> {

        /* renamed from: com.google.common.graph.MapIteratorCache$1$1, reason: invalid class name and collision with other inner class name */
        public class C03531 extends com.google.common.collect.UnmodifiableIterator<K> {
            public final /* synthetic */ java.util.Iterator n;

            public C03531(java.util.Iterator it) {
                this.n = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.n.hasNext();
            }

            @Override // java.util.Iterator
            public K next() {
                java.util.Map.Entry entry = (java.util.Map.Entry) this.n.next();
                com.google.common.graph.MapIteratorCache.this.b = entry;
                return (K) entry.getKey();
            }
        }

        public AnonymousClass1() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.google.common.collect.UnmodifiableIterator<K> iterator() {
            return new com.google.common.graph.MapIteratorCache.AnonymousClass1.C03531(com.google.common.graph.MapIteratorCache.this.a.entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            return com.google.common.graph.MapIteratorCache.this.d(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return com.google.common.graph.MapIteratorCache.this.a.size();
        }
    }

    public MapIteratorCache(java.util.Map<K, V> map) {
        this.a = (java.util.Map) com.google.common.base.Preconditions.checkNotNull(map);
    }

    public void c() {
        this.b = null;
    }

    public final boolean d(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return f(obj) != null || this.a.containsKey(obj);
    }

    public V e(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        V f = f(obj);
        return f != null ? f : g(obj);
    }

    public V f(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        java.util.Map.Entry<K, V> entry = this.b;
        if (entry == null || entry.getKey() != obj) {
            return null;
        }
        return entry.getValue();
    }

    public final V g(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return this.a.get(obj);
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public V h(@org.checkerframework.checker.nullness.compatqual.NullableDecl K k, @org.checkerframework.checker.nullness.compatqual.NullableDecl V v) {
        c();
        return this.a.put(k, v);
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public V i(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        c();
        return this.a.remove(obj);
    }

    public final java.util.Set<K> j() {
        return new com.google.common.graph.MapIteratorCache.AnonymousClass1();
    }
}
