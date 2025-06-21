package com.google.common.graph;

/* loaded from: classes22.dex */
abstract class AbstractUndirectedNetworkConnections<N, E> implements com.google.common.graph.NetworkConnections<N, E> {
    public final java.util.Map<E, N> a;

    public AbstractUndirectedNetworkConnections(java.util.Map<E, N> map) {
        this.a = (java.util.Map) com.google.common.base.Preconditions.checkNotNull(map);
    }

    @Override // com.google.common.graph.NetworkConnections
    public java.util.Set<N> b() {
        return a();
    }

    @Override // com.google.common.graph.NetworkConnections
    public java.util.Set<N> c() {
        return a();
    }

    @Override // com.google.common.graph.NetworkConnections
    public N d(E e) {
        return (N) com.google.common.base.Preconditions.checkNotNull(this.a.get(e));
    }

    @Override // com.google.common.graph.NetworkConnections
    public java.util.Set<E> e() {
        return k();
    }

    @Override // com.google.common.graph.NetworkConnections
    public N f(E e) {
        return (N) com.google.common.base.Preconditions.checkNotNull(this.a.remove(e));
    }

    @Override // com.google.common.graph.NetworkConnections
    public java.util.Set<E> g() {
        return k();
    }

    @Override // com.google.common.graph.NetworkConnections
    public N h(E e, boolean z) {
        if (z) {
            return null;
        }
        return f(e);
    }

    @Override // com.google.common.graph.NetworkConnections
    public void i(E e, N n) {
        com.google.common.base.Preconditions.checkState(this.a.put(e, n) == null);
    }

    @Override // com.google.common.graph.NetworkConnections
    public void j(E e, N n, boolean z) {
        if (z) {
            return;
        }
        i(e, n);
    }

    @Override // com.google.common.graph.NetworkConnections
    public java.util.Set<E> k() {
        return java.util.Collections.unmodifiableSet(this.a.keySet());
    }
}
