package com.google.common.graph;

/* loaded from: classes22.dex */
abstract class AbstractDirectedNetworkConnections<N, E> implements com.google.common.graph.NetworkConnections<N, E> {
    public final java.util.Map<E, N> a;
    public final java.util.Map<E, N> b;
    public int c;

    /* renamed from: com.google.common.graph.AbstractDirectedNetworkConnections$1, reason: invalid class name */
    public class AnonymousClass1 extends java.util.AbstractSet<E> {
        public AnonymousClass1() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.google.common.collect.UnmodifiableIterator<E> iterator() {
            return com.google.common.collect.Iterators.unmodifiableIterator((com.google.common.graph.AbstractDirectedNetworkConnections.this.c == 0 ? com.google.common.collect.Iterables.concat(com.google.common.graph.AbstractDirectedNetworkConnections.this.a.keySet(), com.google.common.graph.AbstractDirectedNetworkConnections.this.b.keySet()) : com.google.common.collect.Sets.union(com.google.common.graph.AbstractDirectedNetworkConnections.this.a.keySet(), com.google.common.graph.AbstractDirectedNetworkConnections.this.b.keySet())).iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            return com.google.common.graph.AbstractDirectedNetworkConnections.this.a.containsKey(obj) || com.google.common.graph.AbstractDirectedNetworkConnections.this.b.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return com.google.common.math.IntMath.saturatedAdd(com.google.common.graph.AbstractDirectedNetworkConnections.this.a.size(), com.google.common.graph.AbstractDirectedNetworkConnections.this.b.size() - com.google.common.graph.AbstractDirectedNetworkConnections.this.c);
        }
    }

    public AbstractDirectedNetworkConnections(java.util.Map<E, N> map, java.util.Map<E, N> map2, int i) {
        this.a = (java.util.Map) com.google.common.base.Preconditions.checkNotNull(map);
        this.b = (java.util.Map) com.google.common.base.Preconditions.checkNotNull(map2);
        this.c = com.google.common.graph.Graphs.b(i);
        com.google.common.base.Preconditions.checkState(i <= map.size() && i <= map2.size());
    }

    @Override // com.google.common.graph.NetworkConnections
    public java.util.Set<N> a() {
        return com.google.common.collect.Sets.union(c(), b());
    }

    @Override // com.google.common.graph.NetworkConnections
    public N d(E e) {
        return (N) com.google.common.base.Preconditions.checkNotNull(this.b.get(e));
    }

    @Override // com.google.common.graph.NetworkConnections
    public java.util.Set<E> e() {
        return java.util.Collections.unmodifiableSet(this.a.keySet());
    }

    @Override // com.google.common.graph.NetworkConnections
    public N f(E e) {
        return (N) com.google.common.base.Preconditions.checkNotNull(this.b.remove(e));
    }

    @Override // com.google.common.graph.NetworkConnections
    public java.util.Set<E> g() {
        return java.util.Collections.unmodifiableSet(this.b.keySet());
    }

    @Override // com.google.common.graph.NetworkConnections
    public N h(E e, boolean z) {
        if (z) {
            int i = this.c - 1;
            this.c = i;
            com.google.common.graph.Graphs.b(i);
        }
        return (N) com.google.common.base.Preconditions.checkNotNull(this.a.remove(e));
    }

    @Override // com.google.common.graph.NetworkConnections
    public void i(E e, N n) {
        com.google.common.base.Preconditions.checkState(this.b.put(e, n) == null);
    }

    @Override // com.google.common.graph.NetworkConnections
    public void j(E e, N n, boolean z) {
        if (z) {
            int i = this.c + 1;
            this.c = i;
            com.google.common.graph.Graphs.d(i);
        }
        com.google.common.base.Preconditions.checkState(this.a.put(e, n) == null);
    }

    @Override // com.google.common.graph.NetworkConnections
    public java.util.Set<E> k() {
        return new com.google.common.graph.AbstractDirectedNetworkConnections.AnonymousClass1();
    }
}
