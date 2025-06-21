package com.google.common.graph;

@com.google.common.annotations.Beta
/* loaded from: classes22.dex */
public interface Network<N, E> extends com.google.common.graph.SuccessorsFunction<N>, com.google.common.graph.PredecessorsFunction<N> {
    java.util.Set<E> adjacentEdges(E e);

    java.util.Set<N> adjacentNodes(N n);

    boolean allowsParallelEdges();

    boolean allowsSelfLoops();

    com.google.common.graph.Graph<N> asGraph();

    int degree(N n);

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    E edgeConnectingOrNull(com.google.common.graph.EndpointPair<N> endpointPair);

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    E edgeConnectingOrNull(N n, N n2);

    com.google.common.graph.ElementOrder<E> edgeOrder();

    java.util.Set<E> edges();

    java.util.Set<E> edgesConnecting(com.google.common.graph.EndpointPair<N> endpointPair);

    java.util.Set<E> edgesConnecting(N n, N n2);

    boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj);

    boolean hasEdgeConnecting(com.google.common.graph.EndpointPair<N> endpointPair);

    boolean hasEdgeConnecting(N n, N n2);

    int hashCode();

    int inDegree(N n);

    java.util.Set<E> inEdges(N n);

    java.util.Set<E> incidentEdges(N n);

    com.google.common.graph.EndpointPair<N> incidentNodes(E e);

    boolean isDirected();

    com.google.common.graph.ElementOrder<N> nodeOrder();

    java.util.Set<N> nodes();

    int outDegree(N n);

    java.util.Set<E> outEdges(N n);

    java.util.Set<N> predecessors(N n);

    @Override // com.google.common.graph.SuccessorsFunction
    java.util.Set<N> successors(N n);
}
