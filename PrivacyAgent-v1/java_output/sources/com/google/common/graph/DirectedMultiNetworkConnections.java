package com.google.common.graph;

/* loaded from: classes22.dex */
final class DirectedMultiNetworkConnections<N, E> extends com.google.common.graph.AbstractDirectedNetworkConnections<N, E> {

    @com.google.errorprone.annotations.concurrent.LazyInit
    public transient java.lang.ref.Reference<com.google.common.collect.Multiset<N>> d;

    @com.google.errorprone.annotations.concurrent.LazyInit
    public transient java.lang.ref.Reference<com.google.common.collect.Multiset<N>> e;

    /* renamed from: com.google.common.graph.DirectedMultiNetworkConnections$1, reason: invalid class name */
    public class AnonymousClass1 extends com.google.common.graph.MultiEdgesConnecting<E> {
        public final /* synthetic */ java.lang.Object u;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(java.util.Map map, java.lang.Object obj, java.lang.Object obj2) {
            super(map, obj);
            this.u = obj2;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return com.google.common.graph.DirectedMultiNetworkConnections.this.s().count(this.u);
        }
    }

    public DirectedMultiNetworkConnections(java.util.Map<E, N> map, java.util.Map<E, N> map2, int i) {
        super(map, map2, i);
    }

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public static <T> T o(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.ref.Reference<T> reference) {
        if (reference == null) {
            return null;
        }
        return reference.get();
    }

    public static <N, E> com.google.common.graph.DirectedMultiNetworkConnections<N, E> p() {
        return new com.google.common.graph.DirectedMultiNetworkConnections<>(new java.util.HashMap(2, 1.0f), new java.util.HashMap(2, 1.0f), 0);
    }

    public static <N, E> com.google.common.graph.DirectedMultiNetworkConnections<N, E> q(java.util.Map<E, N> map, java.util.Map<E, N> map2, int i) {
        return new com.google.common.graph.DirectedMultiNetworkConnections<>(com.google.common.collect.ImmutableMap.copyOf((java.util.Map) map), com.google.common.collect.ImmutableMap.copyOf((java.util.Map) map2), i);
    }

    @Override // com.google.common.graph.NetworkConnections
    public java.util.Set<N> b() {
        return java.util.Collections.unmodifiableSet(s().elementSet());
    }

    @Override // com.google.common.graph.NetworkConnections
    public java.util.Set<N> c() {
        return java.util.Collections.unmodifiableSet(r().elementSet());
    }

    @Override // com.google.common.graph.AbstractDirectedNetworkConnections, com.google.common.graph.NetworkConnections
    public N f(E e) {
        N n = (N) super.f(e);
        com.google.common.collect.Multiset multiset = (com.google.common.collect.Multiset) o(this.e);
        if (multiset != null) {
            com.google.common.base.Preconditions.checkState(multiset.remove(n));
        }
        return n;
    }

    @Override // com.google.common.graph.AbstractDirectedNetworkConnections, com.google.common.graph.NetworkConnections
    public N h(E e, boolean z) {
        N n = (N) super.h(e, z);
        com.google.common.collect.Multiset multiset = (com.google.common.collect.Multiset) o(this.d);
        if (multiset != null) {
            com.google.common.base.Preconditions.checkState(multiset.remove(n));
        }
        return n;
    }

    @Override // com.google.common.graph.AbstractDirectedNetworkConnections, com.google.common.graph.NetworkConnections
    public void i(E e, N n) {
        super.i(e, n);
        com.google.common.collect.Multiset multiset = (com.google.common.collect.Multiset) o(this.e);
        if (multiset != null) {
            com.google.common.base.Preconditions.checkState(multiset.add(n));
        }
    }

    @Override // com.google.common.graph.AbstractDirectedNetworkConnections, com.google.common.graph.NetworkConnections
    public void j(E e, N n, boolean z) {
        super.j(e, n, z);
        com.google.common.collect.Multiset multiset = (com.google.common.collect.Multiset) o(this.d);
        if (multiset != null) {
            com.google.common.base.Preconditions.checkState(multiset.add(n));
        }
    }

    @Override // com.google.common.graph.NetworkConnections
    public java.util.Set<E> l(N n) {
        return new com.google.common.graph.DirectedMultiNetworkConnections.AnonymousClass1(this.b, n, n);
    }

    public final com.google.common.collect.Multiset<N> r() {
        com.google.common.collect.Multiset<N> multiset = (com.google.common.collect.Multiset) o(this.d);
        if (multiset != null) {
            return multiset;
        }
        com.google.common.collect.HashMultiset create = com.google.common.collect.HashMultiset.create(this.a.values());
        this.d = new java.lang.ref.SoftReference(create);
        return create;
    }

    public final com.google.common.collect.Multiset<N> s() {
        com.google.common.collect.Multiset<N> multiset = (com.google.common.collect.Multiset) o(this.e);
        if (multiset != null) {
            return multiset;
        }
        com.google.common.collect.HashMultiset create = com.google.common.collect.HashMultiset.create(this.b.values());
        this.e = new java.lang.ref.SoftReference(create);
        return create;
    }
}
