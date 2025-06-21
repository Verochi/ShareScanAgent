package com.google.common.graph;

@com.google.common.annotations.Beta
/* loaded from: classes22.dex */
public interface MutableValueGraph<N, V> extends com.google.common.graph.ValueGraph<N, V> {
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    boolean addNode(N n);

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    V putEdgeValue(com.google.common.graph.EndpointPair<N> endpointPair, V v);

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    V putEdgeValue(N n, N n2, V v);

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    V removeEdge(com.google.common.graph.EndpointPair<N> endpointPair);

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    V removeEdge(N n, N n2);

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    boolean removeNode(N n);
}
