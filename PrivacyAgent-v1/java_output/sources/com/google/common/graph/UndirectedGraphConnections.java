package com.google.common.graph;

/* loaded from: classes22.dex */
final class UndirectedGraphConnections<N, V> implements com.google.common.graph.GraphConnections<N, V> {
    public final java.util.Map<N, V> a;

    public UndirectedGraphConnections(java.util.Map<N, V> map) {
        this.a = (java.util.Map) com.google.common.base.Preconditions.checkNotNull(map);
    }

    public static <N, V> com.google.common.graph.UndirectedGraphConnections<N, V> i() {
        return new com.google.common.graph.UndirectedGraphConnections<>(new java.util.HashMap(2, 1.0f));
    }

    public static <N, V> com.google.common.graph.UndirectedGraphConnections<N, V> j(java.util.Map<N, V> map) {
        return new com.google.common.graph.UndirectedGraphConnections<>(com.google.common.collect.ImmutableMap.copyOf((java.util.Map) map));
    }

    @Override // com.google.common.graph.GraphConnections
    public java.util.Set<N> a() {
        return java.util.Collections.unmodifiableSet(this.a.keySet());
    }

    @Override // com.google.common.graph.GraphConnections
    public java.util.Set<N> b() {
        return a();
    }

    @Override // com.google.common.graph.GraphConnections
    public java.util.Set<N> c() {
        return a();
    }

    @Override // com.google.common.graph.GraphConnections
    public void d(N n, V v) {
        h(n, v);
    }

    @Override // com.google.common.graph.GraphConnections
    public V e(N n) {
        return this.a.get(n);
    }

    @Override // com.google.common.graph.GraphConnections
    public V f(N n) {
        return this.a.remove(n);
    }

    @Override // com.google.common.graph.GraphConnections
    public void g(N n) {
        f(n);
    }

    @Override // com.google.common.graph.GraphConnections
    public V h(N n, V v) {
        return this.a.put(n, v);
    }
}
