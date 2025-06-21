package com.google.common.graph;

/* loaded from: classes22.dex */
final class DirectedNetworkConnections<N, E> extends com.google.common.graph.AbstractDirectedNetworkConnections<N, E> {
    public DirectedNetworkConnections(java.util.Map<E, N> map, java.util.Map<E, N> map2, int i) {
        super(map, map2, i);
    }

    public static <N, E> com.google.common.graph.DirectedNetworkConnections<N, E> n() {
        return new com.google.common.graph.DirectedNetworkConnections<>(com.google.common.collect.HashBiMap.create(2), com.google.common.collect.HashBiMap.create(2), 0);
    }

    public static <N, E> com.google.common.graph.DirectedNetworkConnections<N, E> o(java.util.Map<E, N> map, java.util.Map<E, N> map2, int i) {
        return new com.google.common.graph.DirectedNetworkConnections<>(com.google.common.collect.ImmutableBiMap.copyOf((java.util.Map) map), com.google.common.collect.ImmutableBiMap.copyOf((java.util.Map) map2), i);
    }

    @Override // com.google.common.graph.NetworkConnections
    public java.util.Set<N> b() {
        return java.util.Collections.unmodifiableSet(((com.google.common.collect.BiMap) this.b).values());
    }

    @Override // com.google.common.graph.NetworkConnections
    public java.util.Set<N> c() {
        return java.util.Collections.unmodifiableSet(((com.google.common.collect.BiMap) this.a).values());
    }

    @Override // com.google.common.graph.NetworkConnections
    public java.util.Set<E> l(N n) {
        return new com.google.common.graph.EdgesConnecting(((com.google.common.collect.BiMap) this.b).inverse(), n);
    }
}
