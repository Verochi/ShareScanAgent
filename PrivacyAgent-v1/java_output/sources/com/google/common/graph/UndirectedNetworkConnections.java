package com.google.common.graph;

/* loaded from: classes22.dex */
final class UndirectedNetworkConnections<N, E> extends com.google.common.graph.AbstractUndirectedNetworkConnections<N, E> {
    public UndirectedNetworkConnections(java.util.Map<E, N> map) {
        super(map);
    }

    public static <N, E> com.google.common.graph.UndirectedNetworkConnections<N, E> m() {
        return new com.google.common.graph.UndirectedNetworkConnections<>(com.google.common.collect.HashBiMap.create(2));
    }

    public static <N, E> com.google.common.graph.UndirectedNetworkConnections<N, E> n(java.util.Map<E, N> map) {
        return new com.google.common.graph.UndirectedNetworkConnections<>(com.google.common.collect.ImmutableBiMap.copyOf((java.util.Map) map));
    }

    @Override // com.google.common.graph.NetworkConnections
    public java.util.Set<N> a() {
        return java.util.Collections.unmodifiableSet(((com.google.common.collect.BiMap) this.a).values());
    }

    @Override // com.google.common.graph.NetworkConnections
    public java.util.Set<E> l(N n) {
        return new com.google.common.graph.EdgesConnecting(((com.google.common.collect.BiMap) this.a).inverse(), n);
    }
}
