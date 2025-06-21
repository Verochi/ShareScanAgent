package com.google.common.graph;

@com.google.common.annotations.Beta
/* loaded from: classes22.dex */
public interface MutableGraph<N> extends com.google.common.graph.Graph<N> {
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    boolean addNode(N n);

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    boolean putEdge(com.google.common.graph.EndpointPair<N> endpointPair);

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    boolean putEdge(N n, N n2);

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    boolean removeEdge(com.google.common.graph.EndpointPair<N> endpointPair);

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    boolean removeEdge(N n, N n2);

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    boolean removeNode(N n);
}
