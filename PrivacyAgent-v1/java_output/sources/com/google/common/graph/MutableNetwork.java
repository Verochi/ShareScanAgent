package com.google.common.graph;

@com.google.common.annotations.Beta
/* loaded from: classes22.dex */
public interface MutableNetwork<N, E> extends com.google.common.graph.Network<N, E> {
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    boolean addEdge(com.google.common.graph.EndpointPair<N> endpointPair, E e);

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    boolean addEdge(N n, N n2, E e);

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    boolean addNode(N n);

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    boolean removeEdge(E e);

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    boolean removeNode(N n);
}
