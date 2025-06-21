package com.google.common.graph;

/* loaded from: classes22.dex */
final class UndirectedMultiNetworkConnections<N, E> extends com.google.common.graph.AbstractUndirectedNetworkConnections<N, E> {

    @com.google.errorprone.annotations.concurrent.LazyInit
    public transient java.lang.ref.Reference<com.google.common.collect.Multiset<N>> b;

    /* renamed from: com.google.common.graph.UndirectedMultiNetworkConnections$1, reason: invalid class name */
    public class AnonymousClass1 extends com.google.common.graph.MultiEdgesConnecting<E> {
        public final /* synthetic */ java.lang.Object u;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(java.util.Map map, java.lang.Object obj, java.lang.Object obj2) {
            super(map, obj);
            this.u = obj2;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return com.google.common.graph.UndirectedMultiNetworkConnections.this.n().count(this.u);
        }
    }

    public UndirectedMultiNetworkConnections(java.util.Map<E, N> map) {
        super(map);
    }

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public static <T> T o(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.ref.Reference<T> reference) {
        if (reference == null) {
            return null;
        }
        return reference.get();
    }

    public static <N, E> com.google.common.graph.UndirectedMultiNetworkConnections<N, E> p() {
        return new com.google.common.graph.UndirectedMultiNetworkConnections<>(new java.util.HashMap(2, 1.0f));
    }

    public static <N, E> com.google.common.graph.UndirectedMultiNetworkConnections<N, E> q(java.util.Map<E, N> map) {
        return new com.google.common.graph.UndirectedMultiNetworkConnections<>(com.google.common.collect.ImmutableMap.copyOf((java.util.Map) map));
    }

    @Override // com.google.common.graph.NetworkConnections
    public java.util.Set<N> a() {
        return java.util.Collections.unmodifiableSet(n().elementSet());
    }

    @Override // com.google.common.graph.AbstractUndirectedNetworkConnections, com.google.common.graph.NetworkConnections
    public N f(E e) {
        N n = (N) super.f(e);
        com.google.common.collect.Multiset multiset = (com.google.common.collect.Multiset) o(this.b);
        if (multiset != null) {
            com.google.common.base.Preconditions.checkState(multiset.remove(n));
        }
        return n;
    }

    @Override // com.google.common.graph.AbstractUndirectedNetworkConnections, com.google.common.graph.NetworkConnections
    public N h(E e, boolean z) {
        if (z) {
            return null;
        }
        return f(e);
    }

    @Override // com.google.common.graph.AbstractUndirectedNetworkConnections, com.google.common.graph.NetworkConnections
    public void i(E e, N n) {
        super.i(e, n);
        com.google.common.collect.Multiset multiset = (com.google.common.collect.Multiset) o(this.b);
        if (multiset != null) {
            com.google.common.base.Preconditions.checkState(multiset.add(n));
        }
    }

    @Override // com.google.common.graph.AbstractUndirectedNetworkConnections, com.google.common.graph.NetworkConnections
    public void j(E e, N n, boolean z) {
        if (z) {
            return;
        }
        i(e, n);
    }

    @Override // com.google.common.graph.NetworkConnections
    public java.util.Set<E> l(N n) {
        return new com.google.common.graph.UndirectedMultiNetworkConnections.AnonymousClass1(this.a, n, n);
    }

    public final com.google.common.collect.Multiset<N> n() {
        com.google.common.collect.Multiset<N> multiset = (com.google.common.collect.Multiset) o(this.b);
        if (multiset != null) {
            return multiset;
        }
        com.google.common.collect.HashMultiset create = com.google.common.collect.HashMultiset.create(this.a.values());
        this.b = new java.lang.ref.SoftReference(create);
        return create;
    }
}
